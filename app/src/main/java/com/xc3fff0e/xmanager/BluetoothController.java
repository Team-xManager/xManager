package com.xc3fff0e.xmanager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;

public class BluetoothController {
public static final String STATE_NONE       = "none";
public static final String STATE_LISTEN     = "listen";
public static final String STATE_CONNECTING = "connecting";
public static final String STATE_CONNECTED  = "connected";

private AcceptThread acceptThread;
private ConnectThread connectThread;
private ConnectedThread connectedThread;

private String state = STATE_NONE;

private static BluetoothController instance;

public static synchronized BluetoothController getInstance() {
if(instance == null) {
instance = new BluetoothController();
}

return instance;
}

public synchronized void start(BluetoothConnect bluetoothConnect, BluetoothConnect.BluetoothConnectionListener listener, String tag, UUID uuid, BluetoothAdapter bluetoothAdapter) {
if (connectThread != null) {
connectThread.cancel();
connectThread = null;
}

if (connectedThread != null) {
connectedThread.cancel();
connectedThread = null;
}

if (acceptThread != null) {
acceptThread.cancel();
acceptThread = null;
}

acceptThread = new AcceptThread(bluetoothConnect, listener, tag, uuid, bluetoothAdapter);
acceptThread.start();}

public synchronized void connect(BluetoothDevice device, BluetoothConnect bluetoothConnect, BluetoothConnect.BluetoothConnectionListener listener, String tag, UUID uuid, BluetoothAdapter bluetoothAdapter) {
if (state.equals(STATE_CONNECTING)) {
if (connectThread != null) {
connectThread.cancel();
connectThread = null;
}
}

if (connectedThread != null) {
connectedThread.cancel();
connectedThread = null;
}

connectThread = new ConnectThread(device, bluetoothConnect, listener, tag, uuid, bluetoothAdapter);
connectThread.start();
}

public synchronized void connected(BluetoothSocket socket, final BluetoothDevice device, BluetoothConnect bluetoothConnect, final BluetoothConnect.BluetoothConnectionListener listener, final String tag) {
if (connectThread != null) {
connectThread.cancel();
connectThread = null;
}

if (connectedThread != null) {
connectedThread.cancel();
connectedThread = null;
}

if (acceptThread != null) {
acceptThread.cancel();
acceptThread = null;
}

connectedThread = new ConnectedThread(socket, bluetoothConnect, listener, tag);
connectedThread.start();

bluetoothConnect.getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
HashMap<String, Object> deviceMap = new HashMap<>();
deviceMap.put("name", device.getName());
deviceMap.put("address", device.getAddress());

listener.onConnected(tag, deviceMap);
}
});
}

public synchronized void stop(BluetoothConnect bluetoothConnect, final BluetoothConnect.BluetoothConnectionListener listener, final String tag) {
if (connectThread != null) {
connectThread.cancel();
connectThread = null;
}

if (connectedThread != null) {
connectedThread.cancel();
connectedThread = null;
}

if (acceptThread != null) {
acceptThread.cancel();
acceptThread = null;
}

state = STATE_NONE;

bluetoothConnect.getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
listener.onConnectionStopped(tag);
}
});
}

public void write(byte[] out) {
ConnectedThread r;

synchronized (this) {
if (!state.equals(STATE_CONNECTED)) return;
r = connectedThread;
}

r.write(out);
}

public void connectionFailed(BluetoothConnect bluetoothConnect, final BluetoothConnect.BluetoothConnectionListener listener, final String tag, final String message) {
state = STATE_NONE;

bluetoothConnect.getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
listener.onConnectionError(tag, state, message);
}
});
}

public void connectionLost(BluetoothConnect bluetoothConnect, final BluetoothConnect.BluetoothConnectionListener listener, final String tag) {
state = STATE_NONE;

bluetoothConnect.getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
listener.onConnectionError(tag, state, "Bluetooth connection is disconnected");
}
});
}

public String getState() {
return state;
}

private class AcceptThread extends Thread {
private BluetoothServerSocket serverSocket;

private BluetoothConnect bluetoothConnect;
private BluetoothConnect.BluetoothConnectionListener listener;
private String tag;

public AcceptThread(BluetoothConnect bluetoothConnect, BluetoothConnect.BluetoothConnectionListener listener, String tag, UUID uuid, BluetoothAdapter bluetoothAdapter) {
this.bluetoothConnect = bluetoothConnect;
this.listener = listener;
this.tag = tag;

try {
serverSocket = bluetoothAdapter.listenUsingRfcommWithServiceRecord(tag, uuid);
} catch (Exception e) {
e.printStackTrace();
}

state = STATE_LISTEN;
}

@Override
public void run() {
BluetoothSocket bluetoothSocket;

while (!state.equals(STATE_CONNECTED)) {
try {
bluetoothSocket = serverSocket.accept();
} catch (Exception e) {
e.printStackTrace();
break;
}

if (bluetoothSocket != null) {
synchronized (BluetoothController.this) {
switch (state) {
case STATE_LISTEN:
case STATE_CONNECTING:
connected(bluetoothSocket, bluetoothSocket.getRemoteDevice(), bluetoothConnect, listener, tag);
break;
case STATE_NONE:
case STATE_CONNECTED:
try {
bluetoothSocket.close();
} catch (Exception e) {
e.printStackTrace();
}
break;
}
}
}
}
}

public void cancel() {
try {
serverSocket.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}

private class ConnectThread extends Thread {
private BluetoothDevice device;
private BluetoothSocket socket;

private BluetoothConnect bluetoothConnect;
private BluetoothConnect.BluetoothConnectionListener listener;
private String tag;
private BluetoothAdapter bluetoothAdapter;

public ConnectThread(BluetoothDevice device, BluetoothConnect bluetoothConnect, BluetoothConnect.BluetoothConnectionListener listener, String tag, UUID uuid, BluetoothAdapter bluetoothAdapter) {
this.device = device;
this.bluetoothConnect = bluetoothConnect;
this.listener = listener;
this.tag = tag;
this.bluetoothAdapter = bluetoothAdapter;

try {
socket = device.createRfcommSocketToServiceRecord(uuid);
} catch (Exception e) {
e.printStackTrace();
}

state = STATE_CONNECTING;
}

@Override
public void run() {
bluetoothAdapter.cancelDiscovery();

try {
socket.connect();
} catch (Exception e) {
try {
socket.close();
} catch (Exception e2) {
e2.printStackTrace();
}
connectionFailed(bluetoothConnect, listener, tag, e.getMessage());
return;
}

synchronized (BluetoothController.this) {
connectThread = null;
}

connected(socket, device, bluetoothConnect, listener, tag);
}

public void cancel() {
try {
socket.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}

private class ConnectedThread extends Thread {
private BluetoothSocket socket;
private InputStream inputStream;
private OutputStream outputStream;

private BluetoothConnect bluetoothConnect;
private BluetoothConnect.BluetoothConnectionListener listener;
private String tag;

public ConnectedThread(BluetoothSocket socket, BluetoothConnect bluetoothConnect, BluetoothConnect.BluetoothConnectionListener listener, String tag) {
this.bluetoothConnect = bluetoothConnect;
this.listener = listener;
this.tag = tag;

this.socket = socket;

try {
inputStream = socket.getInputStream();
outputStream = socket.getOutputStream();
} catch (Exception e) {
e.printStackTrace();
}

state = STATE_CONNECTED;
}

public void run() {
while (state.equals(STATE_CONNECTED)) {
try {
final byte[] buffer = new byte[1024];
final int bytes = inputStream.read(buffer);

bluetoothConnect.getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
listener.onDataReceived(tag, buffer, bytes);
}
});
} catch (Exception e) {
e.printStackTrace();
connectionLost(bluetoothConnect, listener, tag);
break;
}
}
}

public void write(final byte[] buffer) {
try {
outputStream.write(buffer);

bluetoothConnect.getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
listener.onDataSent(tag, buffer);
}
});
} catch (Exception e) {
e.printStackTrace();
}
}

public void cancel() {
try {
socket.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}
}