package com.xc3fff0e.xmanager;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class SketchwareUtil {
public static void showMessage(Context _context, String _s) {
Toast.makeText(_context, _s, Toast.LENGTH_SHORT).show();
}

public static int getLocationX(View _v) {
int _location[] = new int[2];
_v.getLocationInWindow(_location);
return _location[0];
}

public static int getLocationY(View _v) {
int _location[] = new int[2];
_v.getLocationInWindow(_location);
return _location[1];
}

public static int getRandom(int _min, int _max) {
Random random = new Random();
return random.nextInt(_max - _min + 1) + _min;
}

public static ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
ArrayList<Double> _result = new ArrayList<Double>();
SparseBooleanArray _arr = _list.getCheckedItemPositions();
for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
if (_arr.valueAt(_iIdx))
_result.add((double) _arr.keyAt(_iIdx));
}
return _result;
}

public static float getDip(Context _context, int _input) {
return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, _context.getResources().getDisplayMetrics());
}

public static int getDisplayWidthPixels(Context _context) {
return _context.getResources().getDisplayMetrics().widthPixels;
}

public static int getDisplayHeightPixels(Context _context) {
return _context.getResources().getDisplayMetrics().heightPixels;
}

public static void getAllKeysFromMap(Map<String, Object> map, ArrayList<String> output) {
if (output == null) return;
output.clear();

if (map == null || map.size() <= 0) return;

Iterator itr = map.entrySet().iterator();
while (itr.hasNext()) {
Map.Entry<String, String> entry = (Map.Entry) itr.next();
output.add(entry.getKey());
}
}
}