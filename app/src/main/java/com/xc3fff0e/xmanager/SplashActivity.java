package com.xc3fff0e.xmanager;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.ads.consent.*;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
import com.wuyr.rippleanimation.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class SplashActivity extends AppCompatActivity {

	private Timer _timer = new Timer();

	private LinearLayout main_body;
	private ImageView icon_splash;
	private TextView title_splash;

	private TimerTask Timer;
	private Intent Switch_Activity = new Intent();
	private SharedPreferences THEME;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);

		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		main_body = findViewById(R.id.main_body);
		icon_splash = findViewById(R.id.icon_splash);
		title_splash = findViewById(R.id.title_splash);
		THEME = getSharedPreferences("THEME", Activity.MODE_PRIVATE);
	}

	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w = SplashActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF171717);
		}
		Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/splash.gif")).into(icon_splash);
		title_splash.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/base_glitch.ttf"), 1);

		String[] titles = {
				"xManager", "Still Kickin'", "It's A Movement",
				"We Are Resistance", "Freedom For Everyone"
		};
		int randomValue = SketchwareUtil.getRandom(0, 4);
		title_splash.setText(titles[randomValue]);
		title_splash.setTextSize(randomValue == 4 ? 20 : 25);

		Animation animation_icon;
		animation_icon = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
		animation_icon.setDuration(800);
		icon_splash.startAnimation(animation_icon);
		animation_icon = null;

		Animation animation_title;
		animation_title = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
		animation_title.setDuration(800);
		title_splash.startAnimation(animation_title);
		animation_title = null;

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
		_timer.schedule(Timer, (int) (1000));

		_Dark_Navigation();
		_Theme_UI();
	}

	@Override
	public void onBackPressed() {
		com.google.android.material.snackbar.Snackbar
				.make(main_body, "Can't Go Back", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
	}

	public void _Dark_Navigation() {
		if (Build.VERSION.SDK_INT >= 21) {
			getWindow().setNavigationBarColor(Color.parseColor("#171717"));
		}

	}

	public void _Theme_UI() {
		Map<String, Integer> themeColors = new HashMap<>();
		themeColors.put("14", 0xFF1B5E20);
		themeColors.put("15", 0xFF00008B);
		themeColors.put("16", 0xFF8B0000);
		themeColors.put("17", 0xFFFF8C00);
		themeColors.put("18", 0xFFAA336A);
		themeColors.put("19", 0xFF301934);
		themeColors.put("20", 0xFF008B8B);

		int color = themeColors.getOrDefault(THEME.getString("THEME", ""), 0xFF171717);
		main_body.setBackgroundColor(color);
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
				_result.add((double) _arr.keyAt(_iIdx));
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
