package com.xc3fff0e.xmanager;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class BluetoothConnect {
private static final String DEFAULT_UUID = "00001101-0000-1000-8000-00805F9B34FB";

private Activity activity;

private BluetoothAdapter bluetoothAdapter;

public BluetoothConnect(Activity activity) {
this.activity = activity;
this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
}

public boolean isBluetoothEnabled() {
if(bluetoothAdapter != null) return true;

return false;
}

public boolean isBluetoothActivated() {
if(bluetoothAdapter == null) return false;

return bluetoothAdapter.isEnabled();
}

public void activateBluetooth() {
Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
activity.startActivity(intent);
}

public String getRandomUUID() {
return String.valueOf(UUID.randomUUID());
}

public void getPairedDevices(ArrayList<HashMap<String, Object>> results) {
Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

if(pairedDevices.size() > 0) {
for(BluetoothDevice device : pairedDevices) {
HashMap<String, Object> result = new HashMap<>();
result.put("name", device.getName());
result.put("address", device.getAddress());

results.add(result);
}
}
}

public void readyConnection(BluetoothConnectionListener listener, String tag) {
if(BluetoothController.getInstance().getState().equals(BluetoothController.STATE_NONE)) {
BluetoothController.getInstance().start(this, listener, tag, UUID.fromString(DEFAULT_UUID), bluetoothAdapter);
}
}

public void readyConnection(BluetoothConnectionListener listener, String uuid, String tag) {
if(BluetoothController.getInstance().getState().equals(BluetoothController.STATE_NONE)) {
BluetoothController.getInstance().start(this, listener, tag, UUID.fromString(uuid), bluetoothAdapter);
}
}


public void startConnection(BluetoothConnectionListener listener, String address, String tag) {
BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);

BluetoothController.getInstance().connect(device, this, listener, tag, UUID.fromString(DEFAULT_UUID), bluetoothAdapter);
}

public void startConnection(BluetoothConnectionListener listener, String uuid, String address, String tag) {
BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);

BluetoothController.getInstance().connect(device, this, listener, tag, UUID.fromString(uuid), bluetoothAdapter);
}

public void stopConnection(BluetoothConnectionListener listener, String tag) {
BluetoothController.getInstance().stop(this, listener, tag);
}

public void sendData(BluetoothConnectionListener listener, String data, String tag) {
String state = BluetoothController.getInstance().getState();

if(!state.equals(BluetoothController.STATE_CONNECTED)) {
listener.onConnectionError(tag, state, "Bluetooth is not connected yet");
return;
}

BluetoothController.getInstance().write(data.getBytes());
}

public Activity getActivity() {
return activity;
}

public interface BluetoothConnectionListener {
void onConnected(String tag, HashMap<String, Object> deviceData);
void onDataReceived(String tag, byte[] data, int bytes);
void onDataSent(String tag, byte[] data);
void onConnectionError(String tag, String connectionState, String message);
void onConnectionStopped(String tag);
}
}