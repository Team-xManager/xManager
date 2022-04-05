package com.xc3fff0e.xmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import com.wuyr.rippleanimation.*;
import com.unity3d.ads.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class SplashActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout main_body;
	private ImageView icon_manager;
	private TextView title_manager;
	
	private TimerTask Timer;
	private Intent Switch_Activity = new Intent();
	private SharedPreferences NAVIGATION_BAR;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		com.google.android.gms.ads.MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		main_body = findViewById(R.id.main_body);
		icon_manager = findViewById(R.id.icon_manager);
		title_manager = findViewById(R.id.title_manager);
		NAVIGATION_BAR = getSharedPreferences("NAVIGATION_BAR", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =SplashActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF171717);
		}
		title_manager.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_glitch.ttf"), 1);
		if (0 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
			title_manager.setText("xManager");
			title_manager.setTextSize((int)25);
		}
		else {
			if (1 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
				title_manager.setText("Freedom");
				title_manager.setTextSize((int)25);
			}
			else {
				if (2 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
					title_manager.setText("Superior");
					title_manager.setTextSize((int)25);
				}
				else {
					if (3 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
						title_manager.setText("Uprising");
						title_manager.setTextSize((int)25);
					}
					else {
						if (4 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
							title_manager.setText("Never Go Back");
							title_manager.setTextSize((int)25);
						}
						else {
							if (5 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
								title_manager.setText("Keep Your $10");
								title_manager.setTextSize((int)25);
							}
							else {
								if (6 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
									title_manager.setText("It's A Movement");
									title_manager.setTextSize((int)25);
								}
								else {
									if (7 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
										title_manager.setText("Keep 'Em Coming");
										title_manager.setTextSize((int)25);
									}
									else {
										if (8 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
											title_manager.setText("We Are Resistance");
											title_manager.setTextSize((int)20);
										}
										else {
											if (9 == SketchwareUtil.getRandom((int)(0), (int)(9))) {
												title_manager.setText("Spotify but on steroids");
												title_manager.setTextSize((int)20);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Switch_Activity.setClass(getApplicationContext(), MainActivity.class);
						startActivity(Switch_Activity);
						finish();
					}
				});
			}
		};
		_timer.schedule(Timer, (int)(1000));
		_Dark_Navigation();
	}
	
	@Override
	public void onBackPressed() {
		SketchwareUtil.showMessage(getApplicationContext(), "Can't Go Back");
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_Hide_Navigation();
	}
	public void _Hide_Navigation() {
		try {
			if (NAVIGATION_BAR.getString("NAVIGATION", "").equals("1")) {
				getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
				
			}
			else {
				if (NAVIGATION_BAR.getString("NAVIGATION", "").equals("0")) {
					getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
					
					if (Build.VERSION.SDK_INT >= 21) {
							getWindow().setNavigationBarColor(Color.parseColor("#171717"));
					}
					
				}
			}
		} catch (Exception e) {
		}
	}
	
	
	public void _Dark_Navigation() {
		if (Build.VERSION.SDK_INT >= 21) {
				getWindow().setNavigationBarColor(Color.parseColor("#171717"));
		}
		
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
