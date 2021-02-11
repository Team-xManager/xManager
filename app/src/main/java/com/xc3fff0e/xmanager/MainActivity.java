package com.xc3fff0e.xmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.widget.CompoundButton;
import android.view.View;
import android.graphics.Typeface;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String SUB_A = "";
	private String SUB_B = "";
	private String SUB_X = "";
	private String SUB_Y = "";
	private double CHECK = 0;
	private String Latest_Version = "";
	private String Current_Version = "";
	private String Package_Name = "";
	private HashMap<String, Object> Versions = new HashMap<>();
	private HashMap<String, Object> vmap_data = new HashMap<>();
	private boolean Lock_Check = false;
	private String Regular_Title = "";
	private String Regular_Link = "";
	private String Amoled_Title = "";
	private String Amoled_Link = "";
	
	private ArrayList<HashMap<String, Object>> listdata = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Versions_1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> others = new ArrayList<>();
	
	private LinearLayout box_header;
	private LinearLayout main_body_optimization;
	private ScrollView main_scroll_about;
	private  main_refresh_layout;
	private TextView title_header;
	private LinearLayout box_header_tab;
	private LinearLayout box_update;
	private ImageView icon_update;
	private TextView hidden_download;
	private TextView app_changelogs;
	private LinearLayout main_body_about;
	private LinearLayout box_about_close;
	private LinearLayout box_about_header;
	private LinearLayout box_about_sub;
	private LinearLayout box_about_1;
	private LinearLayout box_about_2;
	private LinearLayout box_about_3;
	private LinearLayout box_about_4;
	private LinearLayout box_about_5;
	private LinearLayout box_about_6;
	private LinearLayout box_about_7;
	private TextView contributors_1;
	private LinearLayout box_icon_close;
	private ImageView icon_close;
	private TextView title_about;
	private TextView app_version;
	private TextView sub_title;
	private TextView developer_manager;
	private TextView developer_1;
	private TextView developer_spotify;
	private TextView developer_2;
	private TextView support_team;
	private TextView support_1;
	private TextView mod_testers;
	private TextView testers_1;
	private TextView mobilism_team;
	private TextView mobilism_1;
	private TextView forum_team;
	private TextView forum_1;
	private TextView manager_team;
	private TextView manager_1;
	private LinearLayout main_body;
	private LinearLayout main_box_1;
	private LinearLayout main_box_2;
	private LinearLayout main_box_6;
	private LinearLayout box_sub_header;
	private LinearLayout main_box_5;
	private LinearLayout main_box_4;
	private LinearLayout box_1;
	private LinearLayout box_2;
	private ListView list_menu_1;
	private TextView title_1;
	private LinearLayout box_1_sub;
	private TextView sub_text_1;
	private TextView sub_1;
	private TextView sub_text_2;
	private TextView sub_2;
	private LinearLayout box_switch_1;
	private Switch version_switch_1;
	private LinearLayout box_3;
	private LinearLayout box_4;
	private ListView list_menu_2;
	private TextView title_2;
	private LinearLayout box_3_sub;
	private TextView sub_text_3;
	private TextView sub_3;
	private TextView sub_text_4;
	private TextView sub_4;
	private LinearLayout box_switch_2;
	private Switch version_switch_2;
	private LinearLayout box_6_sub_1;
	private LinearLayout box_6_sub_2;
	private TextView changelogs;
	private LinearLayout box_changelogs;
	private Switch changelogs_switch;
	private LinearLayout box_changelogs_1;
	private TextView changelogs_x;
	private LinearLayout box_sub_1;
	private LinearLayout box_sub_2;
	private TextView title_sub;
	private LinearLayout box_cpu;
	private TextView device_cpu;
	private TextView cpu;
	private LinearLayout box_uninstall;
	private LinearLayout box_settings;
	private LinearLayout box_cache;
	private LinearLayout box_open;
	private ImageView icon_uninstall;
	private ImageView icon_settings;
	private ImageView icon_cache;
	private ImageView icon_open;
	private LinearLayout box_5_sub_1;
	private LinearLayout box_5_sub_2;
	private TextView theme;
	private LinearLayout box_theme_switch;
	private Switch theme_switch;
	private LinearLayout box_theme_0;
	private LinearLayout box_theme_1;
	private LinearLayout box_theme_2;
	private LinearLayout box_theme_3;
	private LinearLayout box_theme_4;
	private LinearLayout box_theme_5;
	private LinearLayout box_theme_6;
	private TextView green_theme;
	private LinearLayout box_green_switch;
	private Switch green_switch;
	private TextView purple_theme;
	private LinearLayout box_purple_switch;
	private Switch purple_switch;
	private TextView red_theme;
	private LinearLayout box_red_switch;
	private Switch red_switch;
	private TextView blue_theme;
	private LinearLayout box_blue_switch;
	private Switch blue_switch;
	private TextView orange_theme;
	private LinearLayout box_orange_switch;
	private Switch orange_switch;
	private TextView yellow_theme;
	private LinearLayout box_yellow_switch;
	private Switch yellow_switch;
	private TextView gray_theme;
	private LinearLayout box_gray_switch;
	private Switch gray_switch;
	private LinearLayout box_source;
	private LinearLayout box_support;
	private LinearLayout box_donate;
	private LinearLayout box_about;
	private TextView source;
	private ImageView icon_source;
	private TextView support;
	private ImageView icon_support;
	private TextView donate;
	private ImageView icon_donate;
	private TextView about;
	private ImageView icon_about;
	
	private AlertDialog.Builder Clear_Cache;
	private AlertDialog.Builder Clear_Cache_Done;
	private TimerTask Timer;
	private Intent Support = new Intent();
	private AlertDialog.Builder Donation;
	private Intent Donate = new Intent();
	private AlertDialog.Builder Mod_Features;
	private AlertDialog.Builder Selected_Spotify;
	private AlertDialog.Builder Download_Spotify;
	private AlertDialog.Builder Mod_Info;
	private AlertDialog.Builder Credits;
	private SharedPreferences SUB_1;
	private SharedPreferences SUB_2;
	private AlertDialog.Builder Success_Download;
	private SharedPreferences ON_SCREEN;
	private AlertDialog.Builder Restart;
	private AlertDialog.Builder Restart_Finished;
	private SharedPreferences THEME;
	private SharedPreferences DESC_X;
	private RequestNetwork Connection;
	private RequestNetwork.RequestListener _Connection_request_listener;
	private DatabaseReference Version = _firebase.getReference("Version");
	private ChildEventListener _Version_child_listener;
	private AlertDialog.Builder Update_Authorized;
	private AlertDialog.Builder Update_Unauthorized;
	private AlertDialog.Builder Update_Latest;
	private DatabaseReference xManager_Update = _firebase.getReference("xManager_Update");
	private ChildEventListener _xManager_Update_child_listener;
	private DatabaseReference Mod_Changelogs = _firebase.getReference("Mod_Changelogs");
	private ChildEventListener _Mod_Changelogs_child_listener;
	private  xManager_Notification;
	private DatabaseReference xManager_Changelogs = _firebase.getReference("xManager_Changelogs");
	private ChildEventListener _xManager_Changelogs_child_listener;
	private  FileProvider;
	private  File_Fixer;
	private Intent Source = new Intent();
	private DatabaseReference Regular_Mod = _firebase.getReference("Regular_Mod");
	private ChildEventListener _Regular_Mod_child_listener;
	private DatabaseReference Amoled_Black = _firebase.getReference("Amoled_Black");
	private ChildEventListener _Amoled_Black_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		box_header = (LinearLayout) findViewById(R.id.box_header);
		main_body_optimization = (LinearLayout) findViewById(R.id.main_body_optimization);
		main_scroll_about = (ScrollView) findViewById(R.id.main_scroll_about);
		main_refresh_layout = () findViewById(R.id.main_refresh_layout);
		title_header = (TextView) findViewById(R.id.title_header);
		box_header_tab = (LinearLayout) findViewById(R.id.box_header_tab);
		box_update = (LinearLayout) findViewById(R.id.box_update);
		icon_update = (ImageView) findViewById(R.id.icon_update);
		hidden_download = (TextView) findViewById(R.id.hidden_download);
		app_changelogs = (TextView) findViewById(R.id.app_changelogs);
		main_body_about = (LinearLayout) findViewById(R.id.main_body_about);
		box_about_close = (LinearLayout) findViewById(R.id.box_about_close);
		box_about_header = (LinearLayout) findViewById(R.id.box_about_header);
		box_about_sub = (LinearLayout) findViewById(R.id.box_about_sub);
		box_about_1 = (LinearLayout) findViewById(R.id.box_about_1);
		box_about_2 = (LinearLayout) findViewById(R.id.box_about_2);
		box_about_3 = (LinearLayout) findViewById(R.id.box_about_3);
		box_about_4 = (LinearLayout) findViewById(R.id.box_about_4);
		box_about_5 = (LinearLayout) findViewById(R.id.box_about_5);
		box_about_6 = (LinearLayout) findViewById(R.id.box_about_6);
		box_about_7 = (LinearLayout) findViewById(R.id.box_about_7);
		contributors_1 = (TextView) findViewById(R.id.contributors_1);
		box_icon_close = (LinearLayout) findViewById(R.id.box_icon_close);
		icon_close = (ImageView) findViewById(R.id.icon_close);
		title_about = (TextView) findViewById(R.id.title_about);
		app_version = (TextView) findViewById(R.id.app_version);
		sub_title = (TextView) findViewById(R.id.sub_title);
		developer_manager = (TextView) findViewById(R.id.developer_manager);
		developer_1 = (TextView) findViewById(R.id.developer_1);
		developer_spotify = (TextView) findViewById(R.id.developer_spotify);
		developer_2 = (TextView) findViewById(R.id.developer_2);
		support_team = (TextView) findViewById(R.id.support_team);
		support_1 = (TextView) findViewById(R.id.support_1);
		mod_testers = (TextView) findViewById(R.id.mod_testers);
		testers_1 = (TextView) findViewById(R.id.testers_1);
		mobilism_team = (TextView) findViewById(R.id.mobilism_team);
		mobilism_1 = (TextView) findViewById(R.id.mobilism_1);
		forum_team = (TextView) findViewById(R.id.forum_team);
		forum_1 = (TextView) findViewById(R.id.forum_1);
		manager_team = (TextView) findViewById(R.id.manager_team);
		manager_1 = (TextView) findViewById(R.id.manager_1);
		main_body = (LinearLayout) findViewById(R.id.main_body);
		main_box_1 = (LinearLayout) findViewById(R.id.main_box_1);
		main_box_2 = (LinearLayout) findViewById(R.id.main_box_2);
		main_box_6 = (LinearLayout) findViewById(R.id.main_box_6);
		box_sub_header = (LinearLayout) findViewById(R.id.box_sub_header);
		main_box_5 = (LinearLayout) findViewById(R.id.main_box_5);
		main_box_4 = (LinearLayout) findViewById(R.id.main_box_4);
		box_1 = (LinearLayout) findViewById(R.id.box_1);
		box_2 = (LinearLayout) findViewById(R.id.box_2);
		list_menu_1 = (ListView) findViewById(R.id.list_menu_1);
		title_1 = (TextView) findViewById(R.id.title_1);
		box_1_sub = (LinearLayout) findViewById(R.id.box_1_sub);
		sub_text_1 = (TextView) findViewById(R.id.sub_text_1);
		sub_1 = (TextView) findViewById(R.id.sub_1);
		sub_text_2 = (TextView) findViewById(R.id.sub_text_2);
		sub_2 = (TextView) findViewById(R.id.sub_2);
		box_switch_1 = (LinearLayout) findViewById(R.id.box_switch_1);
		version_switch_1 = (Switch) findViewById(R.id.version_switch_1);
		box_3 = (LinearLayout) findViewById(R.id.box_3);
		box_4 = (LinearLayout) findViewById(R.id.box_4);
		list_menu_2 = (ListView) findViewById(R.id.list_menu_2);
		title_2 = (TextView) findViewById(R.id.title_2);
		box_3_sub = (LinearLayout) findViewById(R.id.box_3_sub);
		sub_text_3 = (TextView) findViewById(R.id.sub_text_3);
		sub_3 = (TextView) findViewById(R.id.sub_3);
		sub_text_4 = (TextView) findViewById(R.id.sub_text_4);
		sub_4 = (TextView) findViewById(R.id.sub_4);
		box_switch_2 = (LinearLayout) findViewById(R.id.box_switch_2);
		version_switch_2 = (Switch) findViewById(R.id.version_switch_2);
		box_6_sub_1 = (LinearLayout) findViewById(R.id.box_6_sub_1);
		box_6_sub_2 = (LinearLayout) findViewById(R.id.box_6_sub_2);
		changelogs = (TextView) findViewById(R.id.changelogs);
		box_changelogs = (LinearLayout) findViewById(R.id.box_changelogs);
		changelogs_switch = (Switch) findViewById(R.id.changelogs_switch);
		box_changelogs_1 = (LinearLayout) findViewById(R.id.box_changelogs_1);
		changelogs_x = (TextView) findViewById(R.id.changelogs_x);
		box_sub_1 = (LinearLayout) findViewById(R.id.box_sub_1);
		box_sub_2 = (LinearLayout) findViewById(R.id.box_sub_2);
		title_sub = (TextView) findViewById(R.id.title_sub);
		box_cpu = (LinearLayout) findViewById(R.id.box_cpu);
		device_cpu = (TextView) findViewById(R.id.device_cpu);
		cpu = (TextView) findViewById(R.id.cpu);
		box_uninstall = (LinearLayout) findViewById(R.id.box_uninstall);
		box_settings = (LinearLayout) findViewById(R.id.box_settings);
		box_cache = (LinearLayout) findViewById(R.id.box_cache);
		box_open = (LinearLayout) findViewById(R.id.box_open);
		icon_uninstall = (ImageView) findViewById(R.id.icon_uninstall);
		icon_settings = (ImageView) findViewById(R.id.icon_settings);
		icon_cache = (ImageView) findViewById(R.id.icon_cache);
		icon_open = (ImageView) findViewById(R.id.icon_open);
		box_5_sub_1 = (LinearLayout) findViewById(R.id.box_5_sub_1);
		box_5_sub_2 = (LinearLayout) findViewById(R.id.box_5_sub_2);
		theme = (TextView) findViewById(R.id.theme);
		box_theme_switch = (LinearLayout) findViewById(R.id.box_theme_switch);
		theme_switch = (Switch) findViewById(R.id.theme_switch);
		box_theme_0 = (LinearLayout) findViewById(R.id.box_theme_0);
		box_theme_1 = (LinearLayout) findViewById(R.id.box_theme_1);
		box_theme_2 = (LinearLayout) findViewById(R.id.box_theme_2);
		box_theme_3 = (LinearLayout) findViewById(R.id.box_theme_3);
		box_theme_4 = (LinearLayout) findViewById(R.id.box_theme_4);
		box_theme_5 = (LinearLayout) findViewById(R.id.box_theme_5);
		box_theme_6 = (LinearLayout) findViewById(R.id.box_theme_6);
		green_theme = (TextView) findViewById(R.id.green_theme);
		box_green_switch = (LinearLayout) findViewById(R.id.box_green_switch);
		green_switch = (Switch) findViewById(R.id.green_switch);
		purple_theme = (TextView) findViewById(R.id.purple_theme);
		box_purple_switch = (LinearLayout) findViewById(R.id.box_purple_switch);
		purple_switch = (Switch) findViewById(R.id.purple_switch);
		red_theme = (TextView) findViewById(R.id.red_theme);
		box_red_switch = (LinearLayout) findViewById(R.id.box_red_switch);
		red_switch = (Switch) findViewById(R.id.red_switch);
		blue_theme = (TextView) findViewById(R.id.blue_theme);
		box_blue_switch = (LinearLayout) findViewById(R.id.box_blue_switch);
		blue_switch = (Switch) findViewById(R.id.blue_switch);
		orange_theme = (TextView) findViewById(R.id.orange_theme);
		box_orange_switch = (LinearLayout) findViewById(R.id.box_orange_switch);
		orange_switch = (Switch) findViewById(R.id.orange_switch);
		yellow_theme = (TextView) findViewById(R.id.yellow_theme);
		box_yellow_switch = (LinearLayout) findViewById(R.id.box_yellow_switch);
		yellow_switch = (Switch) findViewById(R.id.yellow_switch);
		gray_theme = (TextView) findViewById(R.id.gray_theme);
		box_gray_switch = (LinearLayout) findViewById(R.id.box_gray_switch);
		gray_switch = (Switch) findViewById(R.id.gray_switch);
		box_source = (LinearLayout) findViewById(R.id.box_source);
		box_support = (LinearLayout) findViewById(R.id.box_support);
		box_donate = (LinearLayout) findViewById(R.id.box_donate);
		box_about = (LinearLayout) findViewById(R.id.box_about);
		source = (TextView) findViewById(R.id.source);
		icon_source = (ImageView) findViewById(R.id.icon_source);
		support = (TextView) findViewById(R.id.support);
		icon_support = (ImageView) findViewById(R.id.icon_support);
		donate = (TextView) findViewById(R.id.donate);
		icon_donate = (ImageView) findViewById(R.id.icon_donate);
		about = (TextView) findViewById(R.id.about);
		icon_about = (ImageView) findViewById(R.id.icon_about);
		Clear_Cache = new AlertDialog.Builder(this);
		Clear_Cache_Done = new AlertDialog.Builder(this);
		Donation = new AlertDialog.Builder(this);
		Mod_Features = new AlertDialog.Builder(this);
		Selected_Spotify = new AlertDialog.Builder(this);
		Download_Spotify = new AlertDialog.Builder(this);
		Mod_Info = new AlertDialog.Builder(this);
		Credits = new AlertDialog.Builder(this);
		SUB_1 = getSharedPreferences("SUB_1", Activity.MODE_PRIVATE);
		SUB_2 = getSharedPreferences("SUB_2", Activity.MODE_PRIVATE);
		Success_Download = new AlertDialog.Builder(this);
		ON_SCREEN = getSharedPreferences("ON_SCREEN", Activity.MODE_PRIVATE);
		Restart = new AlertDialog.Builder(this);
		Restart_Finished = new AlertDialog.Builder(this);
		THEME = getSharedPreferences("THEME", Activity.MODE_PRIVATE);
		DESC_X = getSharedPreferences("DESC_X", Activity.MODE_PRIVATE);
		Connection = new RequestNetwork(this);
		Update_Authorized = new AlertDialog.Builder(this);
		Update_Unauthorized = new AlertDialog.Builder(this);
		Update_Latest = new AlertDialog.Builder(this);
		
		box_update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					Version.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							Versions_1 = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									Versions_1.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							Latest_Version = Versions_1.get((int)0).get("V").toString();
							if (Double.parseDouble(Latest_Version) > Double.parseDouble(Current_Version)) {
								try {
									_RequiredDialog(Update_Authorized, false);
									Update_Authorized.setTitle("NEW MANAGER UPDATE");
									Update_Authorized.setPositiveButton("DOWNLOAD UPDATE", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											_RequiredDialog(Update_Authorized, true);
											_Download_Update(hidden_download.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/");
											_Update_Remover();
											Timer = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
															_Hide_Navigation();
														}
													});
												}
											};
											_timer.schedule(Timer, (int)(100));
										}
									});
									Update_Authorized.setNeutralButton("NOT NOW", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											_RequiredDialog(Update_Authorized, true);
											Timer = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
															_Hide_Navigation();
														}
													});
												}
											};
											_timer.schedule(Timer, (int)(100));
										}
									});
									Update_Authorized.create().show();
								}
								catch(Exception e) {
								}
							}
							else {
								if (Double.parseDouble(Current_Version) > Double.parseDouble(Latest_Version)) {
									Version.child("App").child("V").setValue(Current_Version);
								}
								else {
									try {
										xManager_Changelogs.addListenerForSingleValueEvent(new ValueEventListener() {
											@Override
											public void onDataChange(DataSnapshot _dataSnapshot) {
												listdata = new ArrayList<>();
												try {
													GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
													for (DataSnapshot _data : _dataSnapshot.getChildren()) {
														HashMap<String, Object> _map = _data.getValue(_ind);
														listdata.add(_map);
													}
												}
												catch (Exception _e) {
													_e.printStackTrace();
												}
												xManager_Changelogs.addChildEventListener(_xManager_Changelogs_child_listener);
											}
											@Override
											public void onCancelled(DatabaseError _databaseError) {
											}
										});
										Update_Latest.setTitle("xManager v".concat(app_version.getText().toString().concat(" (Latest)")));
										Update_Latest.setMessage(app_changelogs.getText().toString());
										Update_Latest.create().show();
										Timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_Hide_Navigation();
													}
												});
											}
										};
										_timer.schedule(Timer, (int)(100));
									}
									catch(Exception e) {
									}
								}
							}
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				}
				catch(Exception e) {
				}
			}
		});
		
		box_icon_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				main_refresh_layout.setVisibility(View.VISIBLE);
				main_scroll_about.setVisibility(View.GONE);
				main_body_optimization.setVisibility(View.GONE);
				box_update.setVisibility(View.VISIBLE);
			}
		});
		
		version_switch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				try {
					if (_isChecked) {
						try {
							version_switch_2.setChecked(false);
							changelogs_switch.setChecked(false);
							theme_switch.setChecked(false);
							list_menu_1.setVisibility(View.VISIBLE);
							Regular_Mod.addListenerForSingleValueEvent(new ValueEventListener() {
								@Override
								public void onDataChange(DataSnapshot _dataSnapshot) {
									listdata = new ArrayList<>();
									try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
											HashMap<String, Object> _map = _data.getValue(_ind);
											listdata.add(_map);
										}
									}
									catch (Exception _e) {
										_e.printStackTrace();
									}
									list_menu_1.setAdapter(new List_menu_1Adapter(listdata));
									((BaseAdapter)list_menu_1.getAdapter()).notifyDataSetChanged();
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
							xManager_Changelogs.addListenerForSingleValueEvent(new ValueEventListener() {
								@Override
								public void onDataChange(DataSnapshot _dataSnapshot) {
									others = new ArrayList<>();
									try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
											HashMap<String, Object> _map = _data.getValue(_ind);
											others.add(_map);
										}
									}
									catch (Exception _e) {
										_e.printStackTrace();
									}
									xManager_Changelogs.addChildEventListener(_xManager_Changelogs_child_listener);
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
							Mod_Changelogs.addListenerForSingleValueEvent(new ValueEventListener() {
								@Override
								public void onDataChange(DataSnapshot _dataSnapshot) {
									others = new ArrayList<>();
									try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
											HashMap<String, Object> _map = _data.getValue(_ind);
											others.add(_map);
										}
									}
									catch (Exception _e) {
										_e.printStackTrace();
									}
									Mod_Changelogs.addChildEventListener(_Mod_Changelogs_child_listener);
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
							Version.addListenerForSingleValueEvent(new ValueEventListener() {
								@Override
								public void onDataChange(DataSnapshot _dataSnapshot) {
									others = new ArrayList<>();
									try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
											HashMap<String, Object> _map = _data.getValue(_ind);
											others.add(_map);
										}
									}
									catch (Exception _e) {
										_e.printStackTrace();
									}
									Version.addChildEventListener(_Version_child_listener);
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
							main_refresh_layout.setEnabled(false);
						}
						catch(Exception e) {
							SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Fetching failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
						}
					}
					else {
						list_menu_1.setVisibility(View.GONE);
						list_menu_1.setAdapter(new List_menu_1Adapter(listdata));
						((BaseAdapter)list_menu_1.getAdapter()).notifyDataSetChanged();
						main_refresh_layout.setEnabled(true);
					}
				}
				catch(Exception e) {
				}
			}
		});
		
		version_switch_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				try {
					if (_isChecked) {
						try {
							version_switch_1.setChecked(false);
							changelogs_switch.setChecked(false);
							theme_switch.setChecked(false);
							list_menu_2.setVisibility(View.VISIBLE);
							Amoled_Black.addListenerForSingleValueEvent(new ValueEventListener() {
								@Override
								public void onDataChange(DataSnapshot _dataSnapshot) {
									listdata = new ArrayList<>();
									try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
											HashMap<String, Object> _map = _data.getValue(_ind);
											listdata.add(_map);
										}
									}
									catch (Exception _e) {
										_e.printStackTrace();
									}
									list_menu_2.setAdapter(new List_menu_2Adapter(listdata));
									((BaseAdapter)list_menu_2.getAdapter()).notifyDataSetChanged();
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
							xManager_Changelogs.addListenerForSingleValueEvent(new ValueEventListener() {
								@Override
								public void onDataChange(DataSnapshot _dataSnapshot) {
									others = new ArrayList<>();
									try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
											HashMap<String, Object> _map = _data.getValue(_ind);
											others.add(_map);
										}
									}
									catch (Exception _e) {
										_e.printStackTrace();
									}
									xManager_Changelogs.addChildEventListener(_xManager_Changelogs_child_listener);
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
							Mod_Changelogs.addListenerForSingleValueEvent(new ValueEventListener() {
								@Override
								public void onDataChange(DataSnapshot _dataSnapshot) {
									others = new ArrayList<>();
									try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
											HashMap<String, Object> _map = _data.getValue(_ind);
											others.add(_map);
										}
									}
									catch (Exception _e) {
										_e.printStackTrace();
									}
									Mod_Changelogs.addChildEventListener(_Mod_Changelogs_child_listener);
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
							Version.addListenerForSingleValueEvent(new ValueEventListener() {
								@Override
								public void onDataChange(DataSnapshot _dataSnapshot) {
									others = new ArrayList<>();
									try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
											HashMap<String, Object> _map = _data.getValue(_ind);
											others.add(_map);
										}
									}
									catch (Exception _e) {
										_e.printStackTrace();
									}
									Version.addChildEventListener(_Version_child_listener);
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
							main_refresh_layout.setEnabled(false);
						}
						catch(Exception e) {
							SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Fetching failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
						}
					}
					else {
						list_menu_2.setVisibility(View.GONE);
						list_menu_2.setAdapter(new List_menu_2Adapter(listdata));
						((BaseAdapter)list_menu_2.getAdapter()).notifyDataSetChanged();
						main_refresh_layout.setEnabled(true);
					}
				}
				catch(Exception e) {
				}
			}
		});
		
		changelogs_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					box_6_sub_2.setVisibility(View.VISIBLE);
					version_switch_1.setChecked(false);
					version_switch_2.setChecked(false);
					theme_switch.setChecked(false);
				}
				else {
					box_6_sub_2.setVisibility(View.GONE);
				}
			}
		});
		
		box_uninstall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					Intent intent = new Intent(Intent.ACTION_DELETE); intent.setData(Uri.parse("package:com.spotify.music")); 
					startActivity(intent);
				}
				catch(Exception e) {
					SketchwareUtil.CustomToast(getApplicationContext(), "Application not installed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
				}
			}
		});
		
		box_settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS); intent.setData(Uri.parse("package:com.spotify.music")); 
					startActivity(intent);
				}
				catch(Exception e) {
					SketchwareUtil.CustomToast(getApplicationContext(), "Application not installed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
				}
			}
		});
		
		box_cache.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					_RequiredDialog(Clear_Cache, false);
					Clear_Cache.setTitle("CLEAR CACHE");
					Clear_Cache.setMessage("This will erase all the downloaded songs, albums and playlists including offline cached datas from the original or modified spotify app. Would you like to continue?");
					Clear_Cache.setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							_RequiredDialog(Clear_Cache, true);
							if (FileUtil.isExistFile("/storage/emulated/0/Android/data/com.spotify.music/")) {
								FileUtil.deleteFile("/storage/emulated/0/Android/data/com.spotify.music/");
								final ProgressDialog prog = new ProgressDialog(MainActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
								
								prog.setMax(100);
								prog.setMessage("Deleting Spotify's directory folder...");
								prog.setIndeterminate(true);
								prog.setCancelable(false);
								if (!MainActivity.this.isFinishing()) {
									prog.show();
								}
								Timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_RequiredDialog(Clear_Cache_Done, false);
												Clear_Cache_Done.setTitle("DIRECTORY FILES DELETED");
												Clear_Cache_Done.setMessage("Kindly relogin your Spotify account to restore the settings.");
												Clear_Cache_Done.setPositiveButton("GOT IT, THANKS!", new DialogInterface.OnClickListener() {
													@Override
													public void onClick(DialogInterface _dialog, int _which) {
														_RequiredDialog(Clear_Cache_Done, true);
													}
												});
												Clear_Cache_Done.create().show();
												prog.dismiss();
												Timer = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																_Hide_Navigation();
															}
														});
													}
												};
												_timer.schedule(Timer, (int)(100));
												
											}
										});
									}
								};
								_timer.schedule(Timer, (int)(3000));
							}
							else {
								Timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_Hide_Navigation();
											}
										});
									}
								};
								_timer.schedule(Timer, (int)(100));
								
							}
						}
					});
					Clear_Cache.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							_RequiredDialog(Clear_Cache, true);
							Timer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											_Hide_Navigation();
										}
									});
								}
							};
							_timer.schedule(Timer, (int)(100));
						}
					});
					Clear_Cache.create().show();
				}
				catch(Exception e) {
				}
			}
		});
		
		box_open.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String packageName = "com.spotify.music"; 
				
				Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
				if(intent == null) {
					
					try {
						intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
					} catch (Exception e) {
						SketchwareUtil.CustomToast(getApplicationContext(), "Application not installed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
					}
				}
				startActivity(intent);
			}
		});
		
		theme_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					box_5_sub_2.setVisibility(View.VISIBLE);
					version_switch_1.setChecked(false);
					version_switch_2.setChecked(false);
					changelogs_switch.setChecked(false);
				}
				else {
					box_5_sub_2.setVisibility(View.GONE);
				}
			}
		});
		
		green_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					THEME.edit().putString("THEME", "1").commit();
					
					
					green_switch.setChecked(true);
					purple_switch.setChecked(false);
					red_switch.setChecked(false);
					blue_switch.setChecked(false);
					orange_switch.setChecked(false);
					yellow_switch.setChecked(false);
					gray_switch.setChecked(false);
				}
				else {
					if (purple_switch.isChecked()) {
						THEME.edit().putString("THEME", "2").commit();
						
						
						green_switch.setChecked(false);
						purple_switch.setChecked(true);
						red_switch.setChecked(false);
						blue_switch.setChecked(false);
						orange_switch.setChecked(false);
						yellow_switch.setChecked(false);
						gray_switch.setChecked(false);
					}
					else {
						if (red_switch.isChecked()) {
							THEME.edit().putString("THEME", "3").commit();
							
							
							green_switch.setChecked(false);
							purple_switch.setChecked(false);
							red_switch.setChecked(true);
							blue_switch.setChecked(false);
							orange_switch.setChecked(false);
							yellow_switch.setChecked(false);
							gray_switch.setChecked(false);
						}
						else {
							if (blue_switch.isChecked()) {
								THEME.edit().putString("THEME", "4").commit();
								
								
								green_switch.setChecked(false);
								purple_switch.setChecked(false);
								red_switch.setChecked(false);
								blue_switch.setChecked(true);
								orange_switch.setChecked(false);
								yellow_switch.setChecked(false);
								gray_switch.setChecked(false);
							}
							else {
								if (orange_switch.isChecked()) {
									THEME.edit().putString("THEME", "5").commit();
									
									
									green_switch.setChecked(false);
									purple_switch.setChecked(false);
									red_switch.setChecked(false);
									blue_switch.setChecked(false);
									orange_switch.setChecked(true);
									yellow_switch.setChecked(false);
									gray_switch.setChecked(false);
								}
								else {
									if (yellow_switch.isChecked()) {
										THEME.edit().putString("THEME", "6").commit();
										
										
										green_switch.setChecked(false);
										purple_switch.setChecked(false);
										red_switch.setChecked(false);
										blue_switch.setChecked(false);
										orange_switch.setChecked(false);
										yellow_switch.setChecked(true);
										gray_switch.setChecked(false);
									}
									else {
										if (gray_switch.isChecked()) {
											THEME.edit().putString("THEME", "7").commit();
											
											
											green_switch.setChecked(false);
											purple_switch.setChecked(false);
											red_switch.setChecked(false);
											blue_switch.setChecked(false);
											orange_switch.setChecked(false);
											yellow_switch.setChecked(false);
											gray_switch.setChecked(true);
										}
										else {
											if (!(green_switch.isChecked() && (purple_switch.isChecked() && red_switch.isChecked()))) {
												THEME.edit().putString("THEME", "0").commit();
												
												
												green_switch.setChecked(false);
												purple_switch.setChecked(false);
												red_switch.setChecked(false);
												blue_switch.setChecked(false);
												orange_switch.setChecked(false);
												yellow_switch.setChecked(false);
												gray_switch.setChecked(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		purple_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					THEME.edit().putString("THEME", "2").commit();
					
					
					green_switch.setChecked(false);
					purple_switch.setChecked(true);
					red_switch.setChecked(false);
					blue_switch.setChecked(false);
					orange_switch.setChecked(false);
					yellow_switch.setChecked(false);
					gray_switch.setChecked(false);
				}
				else {
					if (green_switch.isChecked()) {
						THEME.edit().putString("THEME", "1").commit();
						
						
						green_switch.setChecked(true);
						purple_switch.setChecked(false);
						red_switch.setChecked(false);
						blue_switch.setChecked(false);
						orange_switch.setChecked(false);
						yellow_switch.setChecked(false);
						gray_switch.setChecked(false);
					}
					else {
						if (red_switch.isChecked()) {
							THEME.edit().putString("THEME", "3").commit();
							
							
							green_switch.setChecked(false);
							purple_switch.setChecked(false);
							red_switch.setChecked(true);
							blue_switch.setChecked(false);
							orange_switch.setChecked(false);
							yellow_switch.setChecked(false);
							gray_switch.setChecked(false);
						}
						else {
							if (blue_switch.isChecked()) {
								THEME.edit().putString("THEME", "4").commit();
								
								
								green_switch.setChecked(false);
								purple_switch.setChecked(false);
								red_switch.setChecked(false);
								blue_switch.setChecked(true);
								orange_switch.setChecked(false);
								yellow_switch.setChecked(false);
								gray_switch.setChecked(false);
							}
							else {
								if (orange_switch.isChecked()) {
									THEME.edit().putString("THEME", "5").commit();
									
									
									green_switch.setChecked(false);
									purple_switch.setChecked(false);
									red_switch.setChecked(false);
									blue_switch.setChecked(false);
									orange_switch.setChecked(true);
									yellow_switch.setChecked(false);
									gray_switch.setChecked(false);
								}
								else {
									if (yellow_switch.isChecked()) {
										THEME.edit().putString("THEME", "6").commit();
										
										
										green_switch.setChecked(false);
										purple_switch.setChecked(false);
										red_switch.setChecked(false);
										blue_switch.setChecked(false);
										orange_switch.setChecked(false);
										yellow_switch.setChecked(true);
										gray_switch.setChecked(false);
									}
									else {
										if (gray_switch.isChecked()) {
											THEME.edit().putString("THEME", "7").commit();
											
											
											green_switch.setChecked(false);
											purple_switch.setChecked(false);
											red_switch.setChecked(false);
											blue_switch.setChecked(false);
											orange_switch.setChecked(false);
											yellow_switch.setChecked(false);
											gray_switch.setChecked(true);
										}
										else {
											if (!(green_switch.isChecked() && (purple_switch.isChecked() && red_switch.isChecked()))) {
												THEME.edit().putString("THEME", "0").commit();
												
												
												green_switch.setChecked(false);
												purple_switch.setChecked(false);
												red_switch.setChecked(false);
												blue_switch.setChecked(false);
												orange_switch.setChecked(false);
												yellow_switch.setChecked(false);
												gray_switch.setChecked(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		red_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					THEME.edit().putString("THEME", "3").commit();
					
					
					green_switch.setChecked(false);
					purple_switch.setChecked(false);
					red_switch.setChecked(true);
					blue_switch.setChecked(false);
					orange_switch.setChecked(false);
					yellow_switch.setChecked(false);
					gray_switch.setChecked(false);
				}
				else {
					if (purple_switch.isChecked()) {
						THEME.edit().putString("THEME", "2").commit();
						
						
						green_switch.setChecked(false);
						purple_switch.setChecked(true);
						red_switch.setChecked(false);
						blue_switch.setChecked(false);
						orange_switch.setChecked(false);
						yellow_switch.setChecked(false);
						gray_switch.setChecked(false);
					}
					else {
						if (green_switch.isChecked()) {
							THEME.edit().putString("THEME", "1").commit();
							
							
							green_switch.setChecked(true);
							purple_switch.setChecked(false);
							red_switch.setChecked(false);
							blue_switch.setChecked(false);
							orange_switch.setChecked(false);
							yellow_switch.setChecked(false);
							gray_switch.setChecked(false);
						}
						else {
							if (blue_switch.isChecked()) {
								THEME.edit().putString("THEME", "4").commit();
								
								
								green_switch.setChecked(false);
								purple_switch.setChecked(false);
								red_switch.setChecked(false);
								blue_switch.setChecked(true);
								orange_switch.setChecked(false);
								yellow_switch.setChecked(false);
								gray_switch.setChecked(false);
							}
							else {
								if (orange_switch.isChecked()) {
									THEME.edit().putString("THEME", "5").commit();
									
									
									green_switch.setChecked(false);
									purple_switch.setChecked(false);
									red_switch.setChecked(false);
									blue_switch.setChecked(false);
									orange_switch.setChecked(true);
									yellow_switch.setChecked(false);
									gray_switch.setChecked(false);
								}
								else {
									if (yellow_switch.isChecked()) {
										THEME.edit().putString("THEME", "6").commit();
										
										
										green_switch.setChecked(false);
										purple_switch.setChecked(false);
										red_switch.setChecked(false);
										blue_switch.setChecked(false);
										orange_switch.setChecked(false);
										yellow_switch.setChecked(true);
										gray_switch.setChecked(false);
									}
									else {
										if (gray_switch.isChecked()) {
											THEME.edit().putString("THEME", "7").commit();
											
											
											green_switch.setChecked(false);
											purple_switch.setChecked(false);
											red_switch.setChecked(false);
											blue_switch.setChecked(false);
											orange_switch.setChecked(false);
											yellow_switch.setChecked(false);
											gray_switch.setChecked(true);
										}
										else {
											if (!(green_switch.isChecked() && (purple_switch.isChecked() && red_switch.isChecked()))) {
												THEME.edit().putString("THEME", "0").commit();
												
												
												green_switch.setChecked(false);
												purple_switch.setChecked(false);
												red_switch.setChecked(false);
												blue_switch.setChecked(false);
												orange_switch.setChecked(false);
												yellow_switch.setChecked(false);
												gray_switch.setChecked(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		blue_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					THEME.edit().putString("THEME", "4").commit();
					
					
					green_switch.setChecked(false);
					purple_switch.setChecked(false);
					red_switch.setChecked(false);
					blue_switch.setChecked(true);
					orange_switch.setChecked(false);
					yellow_switch.setChecked(false);
					gray_switch.setChecked(false);
				}
				else {
					if (purple_switch.isChecked()) {
						THEME.edit().putString("THEME", "2").commit();
						
						
						green_switch.setChecked(false);
						purple_switch.setChecked(true);
						red_switch.setChecked(false);
						blue_switch.setChecked(false);
						orange_switch.setChecked(false);
						yellow_switch.setChecked(false);
						gray_switch.setChecked(false);
					}
					else {
						if (red_switch.isChecked()) {
							THEME.edit().putString("THEME", "3").commit();
							
							
							green_switch.setChecked(false);
							purple_switch.setChecked(false);
							red_switch.setChecked(true);
							blue_switch.setChecked(false);
							orange_switch.setChecked(false);
							yellow_switch.setChecked(false);
							gray_switch.setChecked(false);
						}
						else {
							if (green_switch.isChecked()) {
								THEME.edit().putString("THEME", "1").commit();
								
								
								green_switch.setChecked(true);
								purple_switch.setChecked(false);
								red_switch.setChecked(false);
								blue_switch.setChecked(false);
								orange_switch.setChecked(false);
								yellow_switch.setChecked(false);
								gray_switch.setChecked(false);
							}
							else {
								if (orange_switch.isChecked()) {
									THEME.edit().putString("THEME", "5").commit();
									
									
									green_switch.setChecked(false);
									purple_switch.setChecked(false);
									red_switch.setChecked(false);
									blue_switch.setChecked(false);
									orange_switch.setChecked(true);
									yellow_switch.setChecked(false);
									gray_switch.setChecked(false);
								}
								else {
									if (yellow_switch.isChecked()) {
										THEME.edit().putString("THEME", "6").commit();
										
										
										green_switch.setChecked(false);
										purple_switch.setChecked(false);
										red_switch.setChecked(false);
										blue_switch.setChecked(false);
										orange_switch.setChecked(false);
										yellow_switch.setChecked(true);
										gray_switch.setChecked(false);
									}
									else {
										if (gray_switch.isChecked()) {
											THEME.edit().putString("THEME", "7").commit();
											
											
											green_switch.setChecked(false);
											purple_switch.setChecked(false);
											red_switch.setChecked(false);
											blue_switch.setChecked(false);
											orange_switch.setChecked(false);
											yellow_switch.setChecked(false);
											gray_switch.setChecked(true);
										}
										else {
											if (!(green_switch.isChecked() && (purple_switch.isChecked() && red_switch.isChecked()))) {
												THEME.edit().putString("THEME", "0").commit();
												
												
												green_switch.setChecked(false);
												purple_switch.setChecked(false);
												red_switch.setChecked(false);
												blue_switch.setChecked(false);
												orange_switch.setChecked(false);
												yellow_switch.setChecked(false);
												gray_switch.setChecked(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		orange_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					THEME.edit().putString("THEME", "5").commit();
					
					
					green_switch.setChecked(false);
					purple_switch.setChecked(false);
					red_switch.setChecked(false);
					blue_switch.setChecked(false);
					orange_switch.setChecked(true);
					yellow_switch.setChecked(false);
					gray_switch.setChecked(false);
				}
				else {
					if (purple_switch.isChecked()) {
						THEME.edit().putString("THEME", "2").commit();
						
						
						green_switch.setChecked(false);
						purple_switch.setChecked(true);
						red_switch.setChecked(false);
						blue_switch.setChecked(false);
						orange_switch.setChecked(false);
						yellow_switch.setChecked(false);
						gray_switch.setChecked(false);
					}
					else {
						if (red_switch.isChecked()) {
							THEME.edit().putString("THEME", "3").commit();
							
							
							green_switch.setChecked(false);
							purple_switch.setChecked(false);
							red_switch.setChecked(true);
							blue_switch.setChecked(false);
							orange_switch.setChecked(false);
							yellow_switch.setChecked(false);
							gray_switch.setChecked(false);
						}
						else {
							if (blue_switch.isChecked()) {
								THEME.edit().putString("THEME", "4").commit();
								
								
								green_switch.setChecked(false);
								purple_switch.setChecked(false);
								red_switch.setChecked(false);
								blue_switch.setChecked(true);
								orange_switch.setChecked(false);
								yellow_switch.setChecked(false);
								gray_switch.setChecked(false);
							}
							else {
								if (green_switch.isChecked()) {
									THEME.edit().putString("THEME", "1").commit();
									
									
									green_switch.setChecked(true);
									purple_switch.setChecked(false);
									red_switch.setChecked(false);
									blue_switch.setChecked(false);
									orange_switch.setChecked(false);
									yellow_switch.setChecked(false);
									gray_switch.setChecked(false);
								}
								else {
									if (yellow_switch.isChecked()) {
										THEME.edit().putString("THEME", "6").commit();
										
										
										green_switch.setChecked(false);
										purple_switch.setChecked(false);
										red_switch.setChecked(false);
										blue_switch.setChecked(false);
										orange_switch.setChecked(false);
										yellow_switch.setChecked(true);
										gray_switch.setChecked(false);
									}
									else {
										if (gray_switch.isChecked()) {
											THEME.edit().putString("THEME", "7").commit();
											
											
											green_switch.setChecked(false);
											purple_switch.setChecked(false);
											red_switch.setChecked(false);
											blue_switch.setChecked(false);
											orange_switch.setChecked(false);
											yellow_switch.setChecked(false);
											gray_switch.setChecked(true);
										}
										else {
											if (!(green_switch.isChecked() && (purple_switch.isChecked() && red_switch.isChecked()))) {
												THEME.edit().putString("THEME", "0").commit();
												
												
												green_switch.setChecked(false);
												purple_switch.setChecked(false);
												red_switch.setChecked(false);
												blue_switch.setChecked(false);
												orange_switch.setChecked(false);
												yellow_switch.setChecked(false);
												gray_switch.setChecked(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		yellow_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					THEME.edit().putString("THEME", "6").commit();
					
					
					green_switch.setChecked(false);
					purple_switch.setChecked(false);
					red_switch.setChecked(false);
					blue_switch.setChecked(false);
					orange_switch.setChecked(false);
					yellow_switch.setChecked(true);
					gray_switch.setChecked(false);
				}
				else {
					if (purple_switch.isChecked()) {
						THEME.edit().putString("THEME", "2").commit();
						
						
						green_switch.setChecked(false);
						purple_switch.setChecked(true);
						red_switch.setChecked(false);
						blue_switch.setChecked(false);
						orange_switch.setChecked(false);
						yellow_switch.setChecked(false);
						gray_switch.setChecked(false);
					}
					else {
						if (red_switch.isChecked()) {
							THEME.edit().putString("THEME", "3").commit();
							
							
							green_switch.setChecked(false);
							purple_switch.setChecked(false);
							red_switch.setChecked(true);
							blue_switch.setChecked(false);
							orange_switch.setChecked(false);
							yellow_switch.setChecked(false);
							gray_switch.setChecked(false);
						}
						else {
							if (blue_switch.isChecked()) {
								THEME.edit().putString("THEME", "4").commit();
								
								
								green_switch.setChecked(false);
								purple_switch.setChecked(false);
								red_switch.setChecked(false);
								blue_switch.setChecked(true);
								orange_switch.setChecked(false);
								yellow_switch.setChecked(false);
								gray_switch.setChecked(false);
							}
							else {
								if (orange_switch.isChecked()) {
									THEME.edit().putString("THEME", "5").commit();
									
									
									green_switch.setChecked(false);
									purple_switch.setChecked(false);
									red_switch.setChecked(false);
									blue_switch.setChecked(false);
									orange_switch.setChecked(true);
									yellow_switch.setChecked(false);
									gray_switch.setChecked(false);
								}
								else {
									if (green_switch.isChecked()) {
										THEME.edit().putString("THEME", "1").commit();
										
										
										green_switch.setChecked(true);
										purple_switch.setChecked(false);
										red_switch.setChecked(false);
										blue_switch.setChecked(false);
										orange_switch.setChecked(false);
										yellow_switch.setChecked(false);
										gray_switch.setChecked(false);
									}
									else {
										if (gray_switch.isChecked()) {
											THEME.edit().putString("THEME", "7").commit();
											
											
											green_switch.setChecked(false);
											purple_switch.setChecked(false);
											red_switch.setChecked(false);
											blue_switch.setChecked(false);
											orange_switch.setChecked(false);
											yellow_switch.setChecked(false);
											gray_switch.setChecked(true);
										}
										else {
											if (!(green_switch.isChecked() && (purple_switch.isChecked() && red_switch.isChecked()))) {
												THEME.edit().putString("THEME", "0").commit();
												
												
												green_switch.setChecked(false);
												purple_switch.setChecked(false);
												red_switch.setChecked(false);
												blue_switch.setChecked(false);
												orange_switch.setChecked(false);
												yellow_switch.setChecked(false);
												gray_switch.setChecked(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		gray_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					THEME.edit().putString("THEME", "7").commit();
					
					
					green_switch.setChecked(false);
					purple_switch.setChecked(false);
					red_switch.setChecked(false);
					blue_switch.setChecked(false);
					orange_switch.setChecked(false);
					yellow_switch.setChecked(false);
					gray_switch.setChecked(true);
				}
				else {
					if (purple_switch.isChecked()) {
						THEME.edit().putString("THEME", "2").commit();
						
						
						green_switch.setChecked(false);
						purple_switch.setChecked(true);
						red_switch.setChecked(false);
						blue_switch.setChecked(false);
						orange_switch.setChecked(false);
						yellow_switch.setChecked(false);
						gray_switch.setChecked(false);
					}
					else {
						if (red_switch.isChecked()) {
							THEME.edit().putString("THEME", "3").commit();
							
							
							green_switch.setChecked(false);
							purple_switch.setChecked(false);
							red_switch.setChecked(true);
							blue_switch.setChecked(false);
							orange_switch.setChecked(false);
							yellow_switch.setChecked(false);
							gray_switch.setChecked(false);
						}
						else {
							if (blue_switch.isChecked()) {
								THEME.edit().putString("THEME", "4").commit();
								
								
								green_switch.setChecked(false);
								purple_switch.setChecked(false);
								red_switch.setChecked(false);
								blue_switch.setChecked(true);
								orange_switch.setChecked(false);
								yellow_switch.setChecked(false);
								gray_switch.setChecked(false);
							}
							else {
								if (orange_switch.isChecked()) {
									THEME.edit().putString("THEME", "5").commit();
									
									
									green_switch.setChecked(false);
									purple_switch.setChecked(false);
									red_switch.setChecked(false);
									blue_switch.setChecked(false);
									orange_switch.setChecked(true);
									yellow_switch.setChecked(false);
									gray_switch.setChecked(false);
								}
								else {
									if (yellow_switch.isChecked()) {
										THEME.edit().putString("THEME", "6").commit();
										
										
										green_switch.setChecked(false);
										purple_switch.setChecked(false);
										red_switch.setChecked(false);
										blue_switch.setChecked(false);
										orange_switch.setChecked(false);
										yellow_switch.setChecked(true);
										gray_switch.setChecked(false);
									}
									else {
										if (green_switch.isChecked()) {
											THEME.edit().putString("THEME", "1").commit();
											
											
											green_switch.setChecked(true);
											purple_switch.setChecked(false);
											red_switch.setChecked(false);
											blue_switch.setChecked(false);
											orange_switch.setChecked(false);
											yellow_switch.setChecked(false);
											gray_switch.setChecked(false);
										}
										else {
											if (!(green_switch.isChecked() && (purple_switch.isChecked() && red_switch.isChecked()))) {
												THEME.edit().putString("THEME", "0").commit();
												
												
												green_switch.setChecked(false);
												purple_switch.setChecked(false);
												red_switch.setChecked(false);
												blue_switch.setChecked(false);
												orange_switch.setChecked(false);
												yellow_switch.setChecked(false);
												gray_switch.setChecked(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		box_source.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					Source.setAction(Intent.ACTION_VIEW);
					Source.setData(Uri.parse("https://github.com/xManager-v2/xManager-Spotify"));
					startActivity(Source);
				}
				catch(Exception e) {
				}
			}
		});
		
		box_support.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					Support.setAction(Intent.ACTION_VIEW);
					Support.setData(Uri.parse("https://t.me/SpotifyModSupport"));
					startActivity(Support);
				}
				catch(Exception e) {
				}
			}
		});
		
		box_donate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					_RequiredDialog(Donation, false);
					Donation.setTitle("SHOW YOUR SUPPORT");
					Donation.setMessage("We are a non-profit, non-corporate and non-compromised team. People like you encourage us to create an app to make things much easier especially from downloading to installing.\n\nWe are pouring all of our time and best efforts just to make things right and perfect. We will do our best to support this app as long as we could.\n\nAny amount will help and be very much appreciated!");
					Donation.setPositiveButton("DONATE", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							_RequiredDialog(Donation, true);
							Donate.setAction(Intent.ACTION_VIEW);
							Donate.setData(Uri.parse("https://www.paypal.me/mrvnce"));
							startActivity(Donate);
						}
					});
					Donation.setNeutralButton("NOT NOW", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							_RequiredDialog(Donation, true);
							Timer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											_Hide_Navigation();
										}
									});
								}
							};
							_timer.schedule(Timer, (int)(100));
						}
					});
					Donation.create().show();
				}
				catch(Exception e) {
				}
			}
		});
		
		box_about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				main_scroll_about.setVisibility(View.VISIBLE);
				main_refresh_layout.setVisibility(View.GONE);
				main_body_optimization.setVisibility(View.GONE);
				box_update.setVisibility(View.GONE);
			}
		});
		
		_Connection_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				Regular_Mod.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listdata = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listdata.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						sub_1.setText(SUB_1.getString("SUB_1", ""));
						
						main_body.setEnabled(false);
						main_body.setAlpha((float)(0.65d));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				Amoled_Black.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listdata = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listdata.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						sub_3.setText(SUB_2.getString("SUB_2", ""));
						
						main_body.setEnabled(true);
						main_body.setAlpha((float)(1.0d));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
				main_body.setAlpha((float)(0.65d));
				Timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								
								main_body.setAlpha((float)(1.0d));
							}
						});
					}
				};
				_timer.schedule(Timer, (int)(700));
			}
		};
		
		_Version_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Version.addChildEventListener(_Version_child_listener);
		
		_xManager_Update_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				hidden_download.setText(_childValue.get("Links").toString());
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		xManager_Update.addChildEventListener(_xManager_Update_child_listener);
		
		_Mod_Changelogs_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				changelogs_x.setText(_childValue.get("Changelogs").toString());
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Mod_Changelogs.addChildEventListener(_Mod_Changelogs_child_listener);
		
		_xManager_Changelogs_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				app_changelogs.setText(_childValue.get("App_Changelogs").toString());
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		xManager_Changelogs.addChildEventListener(_xManager_Changelogs_child_listener);
		
		_Regular_Mod_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				listdata.add(_childValue);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Regular_Mod.addChildEventListener(_Regular_Mod_child_listener);
		
		_Amoled_Black_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				listdata.add(_childValue);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Amoled_Black.addChildEventListener(_Amoled_Black_child_listener);
	}
	private void initializeLogic() {
		try {
			_Informations();
			_Model_UI();
		}
		catch(Exception e) {
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (CHECK == 0) {
			CHECK = 1;
			Timer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							CHECK = 0;
						}
					});
				}
			};
			_timer.schedule(Timer, (int)(1000));
			
		}
		else {
			finishAndRemoveTask();
			finishAffinity();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_Hide_Navigation();
	}
	private void _Informations () {
		sub_2.setText("N/A");
		cpu.setText("N/A");
		Timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						String uri = "com.spotify.music";
						android.content.pm.PackageManager pm = getPackageManager();
						
						try {
							android.content.pm.PackageInfo pInfo = pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES);
							String version = pInfo.versionName;
							sub_2.setText(version);
							sub_4.setText(version);
							
						}
						catch (Exception e) {
							SketchwareUtil.CustomToast(getApplicationContext(), "Application not installed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
						}
						String app = "com.xc3fff0e.xmanager";
						android.content.pm.PackageManager ver = getPackageManager();
						
						try {
							android.content.pm.PackageInfo pInfo = ver.getPackageInfo(app, android.content.pm.PackageManager.GET_ACTIVITIES);
							String version = pInfo.versionName;
							app_version.setText(version);
							
						}
						catch (Exception e) {
							SketchwareUtil.CustomToast(getApplicationContext(), "Application not installed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
						}
						cpu.setText(Build.CPU_ABI);
					}
				});
			}
		};
		_timer.schedule(Timer, (int)(750));
	}
	
	
	private void _RequiredDialog (final AlertDialog.Builder _Dialog, final boolean _True) {
		_Dialog.setCancelable(_True);
	}
	
	
	private void _Download (final String _url, final String _path) {
		try {
			FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
			
			android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				
				
				final String urlDownload = _url;
				
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
				
				final String fileName = URLUtil.guessFileName(urlDownload, null, null);
				
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
				
				request.setMimeType("application/vnd.android.package-archive");
				
				request.allowScanningByMediaScanner();
				
				request.setDestinationInExternalFilesDir(this,Environment.DIRECTORY_DOWNLOADS, "Spotify Mod (Official).apk");
				
				final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				
				final long downloadId = manager.enqueue(request);
				
				final ProgressDialog prog = new ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
				prog.setMax(100);
				prog.setIndeterminate(false);
				prog.setCancelable(false);
				prog.setCanceledOnTouchOutside(false);
				prog.setTitle("DOWNLOADING FILE...");
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						boolean downloading = true;
						
						while (downloading) {
							
							DownloadManager.Query q = new DownloadManager.Query();
							
							q.setFilterById(downloadId);
							
							android.database.Cursor cursor = manager.query(q);
							
							if (cursor != null) { 
								  if (cursor.moveToFirst()) {
									
									int bytes_downloaded = cursor.getInt(cursor .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
									
									int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
									
									if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
										
										downloading = false;
										
									}
									
									if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_FAILED) {
										
										runOnUiThread(new Runnable() {
											public void run() { 
												
												SketchwareUtil.CustomToast(getApplicationContext(), "The file or link is currently unavailable. Please try again later.", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
											}
										});
										prog.cancel();
										break;
										
									}
									
									final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
									
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											
											prog.setTitle("DOWNLOADING FILE...");
											prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
											prog.setProgress(dl_progress);
											prog.setMax(100);
											prog.show();
											
											if (dl_progress == prog.getMax()) {
												
												Timer = new TimerTask() {
														@Override
														public void run() {
																runOnUiThread(new Runnable() {
																		@Override
																		public void run() {
																
																try {
																	FileUtil.copyFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk", "/storage/emulated/0/xManager/Spotify Mod (Official).apk");
																	prog.dismiss();
																}
																catch(Exception e) {
																	SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Copying failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																}
																
																_RequiredDialog(Success_Download, false);
																Success_Download.setTitle("SUCCESSFULLY DOWNLOADED");
																Success_Download.setMessage("FILE DIRECTORY:\n</storage/emulated/0/xManager/>");
																Success_Download.setPositiveButton("INSTALL NOW", new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());
																		
																		if(android.os.Build.VERSION.SDK_INT >= 29){
																			
																			try {
																				Intent intent = new Intent(Intent.ACTION_VIEW);
																				
																				intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
																				 
																				intent.setDataAndType(FileProvider.getUriForFile(MainActivity.this, "com.xc3fff0e.xmanager.provider", new File("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk")), "application/vnd.android.package-archive");
																				
																				startActivity(intent);
																			}
																			catch(Exception e) {
																				SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Installation failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																			}
																			
																		} else {
																			
																			try {
																				Intent intent = new Intent(Intent.ACTION_VIEW);
																				intent.setDataAndType(Uri.fromFile(new File("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk")), "application/vnd.android.package-archive");
																				
																				startActivity(intent);
																				Timer = new TimerTask() {
																						@Override
																						public void run() {
																								runOnUiThread(new Runnable() {
																										@Override
																										public void run() {
																												_Hide_Navigation();
																										}
																								});
																						}
																				};
																				_timer.schedule(Timer, (int)(100));
																			}
																			catch(Exception e) {
																				SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Installation failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																			}
																		}
																	}
																});
																Success_Download.setNeutralButton("LATER", new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		Timer = new TimerTask() {
																				@Override
																				public void run() {
																						runOnUiThread(new Runnable() {
																								@Override
																								public void run() {
																										_Hide_Navigation();
																								}
																						});
																				}
																		};
																		_timer.schedule(Timer, (int)(100));
																	}
																});
																Success_Download.create().show();
																SketchwareUtil.CustomToast(getApplicationContext(), "Download Complete", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																		}
																});
														}
												};
												_timer.schedule(Timer, (int)(1500));
											}
										} });
									   }
								    cursor.close();
								     }
						} } }).start();
				
			} else {
				SketchwareUtil.CustomToast(getApplicationContext(), "No Internet Connection", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
			}
		}
		catch(Exception e) {
		}
	}
	
	
	private void _File_Remover () {
		if (FileUtil.isExistFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk")) {
			FileUtil.deleteFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk");
		}
		if (FileUtil.isExistFile("/storage/emulated/0/xManager/Spotify Mod (Official).apk")) {
			FileUtil.deleteFile("/storage/emulated/0/xManager/Spotify Mod (Official).apk");
		}
	}
	
	
	private void _Update_Remover () {
		if (FileUtil.isExistFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/xManager Update.apk")) {
			FileUtil.deleteFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/xManager Update.apk");
		}
		if (FileUtil.isExistFile("/storage/emulated/0/xManager/Update/xManager Update.apk")) {
			FileUtil.deleteFile("/storage/emulated/0/xManager/Update/xManager Update.apk");
		}
	}
	
	
	private void _Model_UI () {
		title_header.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		title_sub.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		title_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		title_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_text_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		sub_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		sub_text_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		sub_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		sub_text_3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		sub_3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		sub_text_4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		sub_4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		title_sub.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		device_cpu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		cpu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		support.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		donate.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		about.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		source.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		version_switch_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		version_switch_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		green_theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		purple_theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		red_theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		blue_theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		orange_theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		yellow_theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		gray_theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		title_about.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		developer_manager.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		developer_spotify.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		support_team.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		mod_testers.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		mobilism_team.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		forum_team.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_team.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		developer_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		developer_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		support_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		testers_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		mobilism_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 0);
		forum_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		contributors_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		changelogs.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		changelogs_x.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		app_version.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		
		
		
		
		
		list_menu_1.setVisibility(View.GONE);
		list_menu_2.setVisibility(View.GONE);
		box_5_sub_2.setVisibility(View.GONE);
		box_6_sub_2.setVisibility(View.GONE);
		list_menu_1.smoothScrollToPosition((int)(0));
		list_menu_2.smoothScrollToPosition((int)(0));
		
		
		
		
		
		
		
		
		
		
		
		
		
		if (!ON_SCREEN.getString("ON_SCREEN", "").equals("ON_SCREEN")) {
			try {
				final ProgressDialog prog_0 = new ProgressDialog(MainActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
				
				prog_0.setMax(100);
				prog_0.setMessage("Initial optimization. Please wait...");
				prog_0.setIndeterminate(true);
				prog_0.setCancelable(false);
				if (!MainActivity.this.isFinishing()){
					prog_0.show();
				}
				Timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								prog_0.dismiss();
								final ProgressDialog prog_1 = new ProgressDialog(MainActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
								
								prog_1.setMax(100);
								prog_1.setMessage("Relaunching...");
								prog_1.setIndeterminate(true);
								prog_1.setCancelable(false);
								prog_1.show();
								
								if (!MainActivity.this.isFinishing()){
									return;
								}
								Timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												prog_1.dismiss();
											}
										});
									}
								};
								_timer.schedule(Timer, (int)(9000));
							}
						});
					}
				};
				_timer.schedule(Timer, (int)(8000));
				if (FileUtil.isExistFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/")) {
					FileUtil.deleteFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/");
				}
				if (FileUtil.isExistFile("/storage/emulated/0/xManager/")) {
					FileUtil.deleteFile("/storage/emulated/0/xManager/");
				}
				main_body.setEnabled(false);
				main_body.setAlpha((float)(0.65d));
				Regular_Mod.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listdata = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listdata.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						sub_1.setText(SUB_1.getString("SUB_1", ""));
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										
										version_switch_1.setChecked(true);
										version_switch_2.setChecked(false);
										changelogs_switch.setChecked(false);
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(0));
						list_menu_1.setAdapter(new List_menu_1Adapter(listdata));
						((BaseAdapter)list_menu_1.getAdapter()).notifyDataSetChanged();
						list_menu_1.smoothScrollToPosition((int)(999));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				Amoled_Black.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listdata = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listdata.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						sub_3.setText(SUB_2.getString("SUB_2", ""));
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										
										version_switch_1.setChecked(false);
										version_switch_2.setChecked(true);
										changelogs_switch.setChecked(false);
										Timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														
														version_switch_1.setChecked(false);
														version_switch_2.setChecked(false);
														changelogs_switch.setChecked(true);
														Timer = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		
																		version_switch_1.setChecked(false);
																		version_switch_2.setChecked(false);
																		changelogs_switch.setChecked(false);
																		main_body.setEnabled(true);
																		main_body.setAlpha((float)(1.0d));
																	}
																});
															}
														};
														_timer.schedule(Timer, (int)(700));
													}
												});
											}
										};
										_timer.schedule(Timer, (int)(700));
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(500));
						list_menu_2.setAdapter(new List_menu_2Adapter(listdata));
						((BaseAdapter)list_menu_2.getAdapter()).notifyDataSetChanged();
						list_menu_2.smoothScrollToPosition((int)(999));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				xManager_Changelogs.addChildEventListener(_xManager_Changelogs_child_listener);
				Mod_Changelogs.addChildEventListener(_Mod_Changelogs_child_listener);
				Version.addChildEventListener(_Version_child_listener);
				Timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								ON_SCREEN.edit().putString("ON_SCREEN", "ON_SCREEN").commit();
								try {
									Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName() ); 
									
									intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
									intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
									startActivity(intent);
								}
								catch (Exception e) {
								}
							}
						});
					}
				};
				_timer.schedule(Timer, (int)(10000));
				box_update.setVisibility(View.GONE);
				Connection.startRequestNetwork(RequestNetworkController.GET, "https://spotify.com", "PAWN!", _Connection_request_listener);
			}
			catch(Exception e) {
			}
		}
		else {
			try {
				Regular_Mod.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listdata = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listdata.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						sub_1.setText(SUB_1.getString("SUB_1", ""));
						
						list_menu_1.setAdapter(new List_menu_1Adapter(listdata));
						((BaseAdapter)list_menu_1.getAdapter()).notifyDataSetChanged();
						main_body.setEnabled(false);
						main_body.setAlpha((float)(0.65d));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				Amoled_Black.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listdata = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listdata.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						sub_3.setText(SUB_2.getString("SUB_2", ""));
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										
										list_menu_2.setAdapter(new List_menu_2Adapter(listdata));
										((BaseAdapter)list_menu_2.getAdapter()).notifyDataSetChanged();
										main_body.setEnabled(true);
										main_body.setAlpha((float)(1.0d));
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(800));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				xManager_Changelogs.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						others = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								others.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						xManager_Changelogs.addChildEventListener(_xManager_Changelogs_child_listener);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				Mod_Changelogs.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						others = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								others.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						Mod_Changelogs.addChildEventListener(_Mod_Changelogs_child_listener);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				Version.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						others = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								others.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						Version.addChildEventListener(_Version_child_listener);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				main_body_optimization.setVisibility(View.GONE);
				main_scroll_about.setVisibility(View.GONE);
				box_update.setVisibility(View.VISIBLE);
				icon_update.setAlpha((float)(1.0d));
				
				Connection.startRequestNetwork(RequestNetworkController.GET, "https://spotify.com", "PAWN!", _Connection_request_listener);
			}
			catch(Exception e) {
			}
		}
		
		
		CHECK = 0;
		_Update_Remover();
		_Updater_Check();
		_Theme_UI();
		_Effects();
	}
	
	
	private void _Theme_UI () {
		if (THEME.getString("THEME", "").equals("0")) {
			
			green_switch.setChecked(false);
			purple_switch.setChecked(false);
			red_switch.setChecked(false);
			blue_switch.setChecked(false);
			orange_switch.setChecked(false);
			yellow_switch.setChecked(false);
			gray_switch.setChecked(false);
		}
		else {
			if (THEME.getString("THEME", "").equals("1")) {
				
				green_switch.setChecked(true);
				purple_switch.setChecked(false);
				red_switch.setChecked(false);
				blue_switch.setChecked(false);
				orange_switch.setChecked(false);
				yellow_switch.setChecked(false);
				gray_switch.setChecked(false);
			}
			else {
				if (THEME.getString("THEME", "").equals("2")) {
					
					green_switch.setChecked(false);
					purple_switch.setChecked(true);
					red_switch.setChecked(false);
					blue_switch.setChecked(false);
					orange_switch.setChecked(false);
					yellow_switch.setChecked(false);
					gray_switch.setChecked(false);
				}
				else {
					if (THEME.getString("THEME", "").equals("3")) {
						
						green_switch.setChecked(false);
						purple_switch.setChecked(false);
						red_switch.setChecked(true);
						blue_switch.setChecked(false);
						orange_switch.setChecked(false);
						yellow_switch.setChecked(false);
						gray_switch.setChecked(false);
					}
					else {
						if (THEME.getString("THEME", "").equals("4")) {
							
							green_switch.setChecked(false);
							purple_switch.setChecked(false);
							red_switch.setChecked(false);
							blue_switch.setChecked(true);
							orange_switch.setChecked(false);
							yellow_switch.setChecked(false);
							gray_switch.setChecked(false);
						}
						else {
							if (THEME.getString("THEME", "").equals("5")) {
								
								green_switch.setChecked(false);
								purple_switch.setChecked(false);
								red_switch.setChecked(false);
								blue_switch.setChecked(false);
								orange_switch.setChecked(true);
								yellow_switch.setChecked(false);
								gray_switch.setChecked(false);
							}
							else {
								if (THEME.getString("THEME", "").equals("6")) {
									
									green_switch.setChecked(false);
									purple_switch.setChecked(false);
									red_switch.setChecked(false);
									blue_switch.setChecked(false);
									orange_switch.setChecked(false);
									yellow_switch.setChecked(true);
									gray_switch.setChecked(false);
								}
								else {
									if (THEME.getString("THEME", "").equals("7")) {
										
										green_switch.setChecked(false);
										purple_switch.setChecked(false);
										red_switch.setChecked(false);
										blue_switch.setChecked(false);
										orange_switch.setChecked(false);
										yellow_switch.setChecked(false);
										gray_switch.setChecked(true);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _Updater () {
		try {
			Version.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot _dataSnapshot) {
					Versions_1 = new ArrayList<>();
					try {
						GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
						for (DataSnapshot _data : _dataSnapshot.getChildren()) {
							HashMap<String, Object> _map = _data.getValue(_ind);
							Versions_1.add(_map);
						}
					}
					catch (Exception _e) {
						_e.printStackTrace();
					}
					Latest_Version = Versions_1.get((int)0).get("V").toString();
					if (Double.parseDouble(Latest_Version) > Double.parseDouble(Current_Version)) {
						if (SketchwareUtil.getRandom((int)(0), (int)(2)) == 1) {
							_RequiredDialog(Update_Authorized, false);
							Update_Authorized.setTitle("NEW MANAGER UPDATE");
							Update_Authorized.setPositiveButton("DOWNLOAD UPDATE", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									try {
										_RequiredDialog(Update_Authorized, true);
										_Download_Update(hidden_download.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/");
										_Update_Remover();
									}
									catch(Exception e) {
									}
								}
							});
							Update_Authorized.setNeutralButton("NOT NOW", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									_RequiredDialog(Update_Authorized, true);
								}
							});
							Update_Authorized.create().show();
						}
					}
					else {
						if (Double.parseDouble(Current_Version) > Double.parseDouble(Latest_Version)) {
							_RequiredDialog(Update_Unauthorized, false);
							Update_Unauthorized.setTitle("MAINTENANCE");
							Update_Unauthorized.setMessage("xManager is currently unavailable right now. Kindly check the application later.");
							Update_Unauthorized.setPositiveButton("THANKS!", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									_RequiredDialog(Update_Unauthorized, true);
									finishAndRemoveTask();
									finishAffinity();
								}
							});
							Update_Unauthorized.create().show();
						}
						else {
							Version.child("App").child("V").setValue(Current_Version);
						}
					}
				}
				@Override
				public void onCancelled(DatabaseError _databaseError) {
				}
			});
		}
		catch(Exception e) {
		}
	}
	
	
	private void _Updater_Check () {
		Package_Name = "com.xc3fff0e.xmanager";
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo(Package_Name, android.content.pm.PackageManager.GET_ACTIVITIES);
			Current_Version = pinfo.versionName;
		}
		catch (Exception e) {
			SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Version unidentified", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
		}
		DatabaseReference rootRef = _firebase.getReference(); rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) {
					
				} else {
					Versions = new HashMap<>();
					Versions.put("V", Current_Version);
					Versions.clear();
					Version.child("App").updateChildren(Versions);
				} }
			@Override
			public void onCancelled(DatabaseError _error) {
			} });
		_Updater();
	}
	
	
	private void _Download_Update (final String _url, final String _path) {
		try {
			FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
			
			android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				
				
				final String urlDownload = _url;
				
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
				
				final String fileName = URLUtil.guessFileName(urlDownload, null, null);
				
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
				
				request.setMimeType("application/vnd.android.package-archive");
				
				request.allowScanningByMediaScanner();
				
				request.setDestinationInExternalFilesDir(this,Environment.DIRECTORY_DOWNLOADS, "/Update/xManager Update.apk");
				
				final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				
				final long downloadId = manager.enqueue(request);
				
				final ProgressDialog prog = new ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
				prog.setMax(100);
				prog.setIndeterminate(false);
				prog.setCancelable(false);
				prog.setCanceledOnTouchOutside(false);
				prog.setTitle("DOWNLOADING FILE...");
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						boolean downloading = true;
						
						while (downloading) {
							
							DownloadManager.Query q = new DownloadManager.Query();
							
							q.setFilterById(downloadId);
							
							android.database.Cursor cursor = manager.query(q);
							
							if (cursor != null) { 
								  if (cursor.moveToFirst()) {
									
									int bytes_downloaded = cursor.getInt(cursor .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
									
									int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
									
									if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
										
										downloading = false;
										
									}
									
									if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_FAILED) {
										
										runOnUiThread(new Runnable() {
											public void run() { 
												
												SketchwareUtil.CustomToast(getApplicationContext(), "The file or link is currently unavailable. Please try again later.", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
											}
										});
										prog.cancel();
										break;
										
									}
									
									final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
									
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											
											prog.setTitle("DOWNLOADING FILE...");
											prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
											prog.setProgress(dl_progress);
											prog.setMax(100);
											prog.show();
											
											if (dl_progress == prog.getMax()) {
												
												Timer = new TimerTask() {
														@Override
														public void run() {
																runOnUiThread(new Runnable() {
																		@Override
																		public void run() {
																
																try {
																	FileUtil.copyFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/xManager Update.apk", "/storage/emulated/0/xManager/Update/xManager Update.apk");
																	prog.dismiss();
																}
																catch(Exception e) {
																	SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Copying failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																}
																
																_RequiredDialog(Success_Download, false);
																Success_Download.setTitle("SUCCESSFULLY DOWNLOADED");
																Success_Download.setMessage("FILE DIRECTORY:\n</storage/emulated/0/xManager/Update/>");
																Success_Download.setPositiveButton("INSTALL UPDATE", new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());
																		
																		if(android.os.Build.VERSION.SDK_INT >= 29){
																			
																			try {
																				Intent intent = new Intent(Intent.ACTION_VIEW);
																				
																				intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
																				 
																				intent.setDataAndType(FileProvider.getUriForFile(MainActivity.this, "com.xc3fff0e.xmanager.provider", new File("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/xManager Update.apk")), "application/vnd.android.package-archive");
																				
																				startActivity(intent);
																			}
																			catch(Exception e) {
																				SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Installation failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																			}
																			
																		} else {
																			
																			try {
																				Intent intent = new Intent(Intent.ACTION_VIEW);
																				intent.setDataAndType(Uri.fromFile(new File("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/xManager Update.apk")), "application/vnd.android.package-archive");
																				
																				startActivity(intent);
																				Timer = new TimerTask() {
																						@Override
																						public void run() {
																								runOnUiThread(new Runnable() {
																										@Override
																										public void run() {
																												_Hide_Navigation();
																										}
																								});
																						}
																				};
																				_timer.schedule(Timer, (int)(100));
																			}
																			catch(Exception e) {
																				SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Installation failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																			}
																		}
																	}
																});
																Success_Download.setNeutralButton("LATER", new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		Timer = new TimerTask() {
																				@Override
																				public void run() {
																						runOnUiThread(new Runnable() {
																								@Override
																								public void run() {
																										_Hide_Navigation();
																								}
																						});
																				}
																		};
																		_timer.schedule(Timer, (int)(100));
																	}
																});
																Success_Download.create().show();
																SketchwareUtil.CustomToast(getApplicationContext(), "Download Complete", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																		}
																});
														}
												};
												_timer.schedule(Timer, (int)(1500));
											}
										} });
									   }
								    cursor.close();
								     }
						} } }).start();
				
			} else {
				SketchwareUtil.CustomToast(getApplicationContext(), "No Internet Connection", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
			}
		}
		catch(Exception e) {
		}
	}
	
	
	private void _Effects () {
		_Ripple(box_update, "#9E9E9E");
	}
	
	
	private void _Ripple (final View _view, final String _c) {
		_view.setBackground(Drawables.getSelectableDrawableFor(Color.parseColor(_c)));
		_view.setClickable(true);
		
	}
	
	public static class Drawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[8];
			        Arrays.fill(outerRadii, 0);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
			    }
	}
	public static class CircleDrawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[180];
			        Arrays.fill(outerRadii, 80);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
		}
	}
	
	public void drawableclass() {
		
		
	}
	
	
	private void _Hide_Navigation () {
		try {
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
			
			if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#212121"));
			}
		}
		catch(Exception e) {
		}
	}
	
	
	public class List_menu_1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public List_menu_1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.list_menu_1, null);
			}
			
			final LinearLayout box = (LinearLayout) _v.findViewById(R.id.box);
			final TextView link = (TextView) _v.findViewById(R.id.link);
			final ImageView icon = (ImageView) _v.findViewById(R.id.icon);
			final TextView title = (TextView) _v.findViewById(R.id.title);
			
			try {
				title.setVisibility(View.VISIBLE);
				link.setVisibility(View.GONE);
				title.setText(listdata.get((int)(listdata.size() - 1) - _position).get("title").toString().replace("-", "."));
				link.setText(listdata.get((int)(listdata.size() - 1) - _position).get("link").toString());
				title.setText(title.getText().toString().replace("(Armeabi.v7a)", "(Armeabi-v7a)"));
				title.setText(title.getText().toString().replace("(Arm64.v8a)", "(Arm64-v8a)"));
				title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
				if ((_position == 0) && title.getText().toString().contains("(Armeabi-v7a)")) {
					SUB_A = title.getText().toString().replace("Spotify v", " ");
					SUB_B = SUB_A.replace("(Armeabi-v7a)", " ");
				}
				else {
					if ((_position == 0) && title.getText().toString().contains("(Arm64-v8a)")) {
						SUB_A = title.getText().toString().replace("Spotify v", " ");
						SUB_B = SUB_A.replace("(Arm64-v8a)", " ");
					}
				}
				SUB_1.edit().putString("SUB_1", SUB_B).commit();
				box.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_RequiredDialog(Selected_Spotify, false);
						Selected_Spotify.setTitle(title.getText().toString());
						Selected_Spotify.setMessage("You selected this modified version. Do you want to continue?");
						Selected_Spotify.setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								_RequiredDialog(Selected_Spotify, true);
								_RequiredDialog(Download_Spotify, false);
								Download_Spotify.setTitle("DOWNLOAD READY");
								Download_Spotify.setMessage("Downloading this modified apk will overwrite the previous file located at the application's external file directory.");
								Download_Spotify.setPositiveButton("DOWNLOAD", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										try {
											_RequiredDialog(Download_Spotify, true);
											_Download(link.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/");
											_File_Remover();
										}
										catch(Exception e) {
										}
									}
								});
								Download_Spotify.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										_RequiredDialog(Download_Spotify, true);
										Timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_Hide_Navigation();
													}
												});
											}
										};
										_timer.schedule(Timer, (int)(100));
									}
								});
								Download_Spotify.create().show();
							}
						});
						Selected_Spotify.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								_RequiredDialog(Selected_Spotify, true);
								Timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_Hide_Navigation();
											}
										});
									}
								};
								_timer.schedule(Timer, (int)(100));
							}
						});
						Selected_Spotify.create().show();
						FileUtil.makeDir("/storage/emulated/0/xManager");
						FileUtil.makeDir("/storage/emulated/0/xManager/Update");
					}
				});
			}
			catch(Exception e) {
			}
			
			return _v;
		}
	}
	
	public class List_menu_2Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public List_menu_2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.list_menu_2, null);
			}
			
			final LinearLayout box = (LinearLayout) _v.findViewById(R.id.box);
			final TextView link = (TextView) _v.findViewById(R.id.link);
			final ImageView icon = (ImageView) _v.findViewById(R.id.icon);
			final TextView title = (TextView) _v.findViewById(R.id.title);
			
			try {
				title.setVisibility(View.VISIBLE);
				link.setVisibility(View.GONE);
				title.setText(listdata.get((int)(listdata.size() - 1) - _position).get("title").toString().replace("-", "."));
				link.setText(listdata.get((int)(listdata.size() - 1) - _position).get("link").toString());
				title.setText(title.getText().toString().replace("(Armeabi.v7a)", "(Armeabi-v7a)"));
				title.setText(title.getText().toString().replace("(Arm64.v8a)", "(Arm64-v8a)"));
				title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
				if ((_position == 0) && title.getText().toString().contains("(Armeabi-v7a)")) {
					SUB_X = title.getText().toString().replace("Spotify v", " ");
					SUB_Y = SUB_X.replace("(Armeabi-v7a)", " ");
				}
				else {
					if ((_position == 0) && title.getText().toString().contains("(Arm64-v8a)")) {
						SUB_X = title.getText().toString().replace("Spotify v", " ");
						SUB_Y = SUB_X.replace("(Arm64-v8a)", " ");
					}
				}
				SUB_2.edit().putString("SUB_2", SUB_Y).commit();
				box.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_RequiredDialog(Selected_Spotify, false);
						Selected_Spotify.setTitle(title.getText().toString());
						Selected_Spotify.setMessage("You selected this modified version. Do you want to continue?");
						Selected_Spotify.setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								_RequiredDialog(Selected_Spotify, true);
								_RequiredDialog(Download_Spotify, false);
								Download_Spotify.setTitle("DOWNLOAD READY");
								Download_Spotify.setMessage("Downloading this modified apk will overwrite the previous file located at the application's external file directory.");
								Download_Spotify.setPositiveButton("DOWNLOAD", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										try {
											_RequiredDialog(Download_Spotify, true);
											_Download(link.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/");
											_File_Remover();
										}
										catch(Exception e) {
										}
									}
								});
								Download_Spotify.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										_RequiredDialog(Download_Spotify, true);
										Timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_Hide_Navigation();
													}
												});
											}
										};
										_timer.schedule(Timer, (int)(100));
									}
								});
								Download_Spotify.create().show();
							}
						});
						Selected_Spotify.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								_RequiredDialog(Selected_Spotify, true);
								Timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_Hide_Navigation();
											}
										});
									}
								};
								_timer.schedule(Timer, (int)(100));
							}
						});
						Selected_Spotify.create().show();
						FileUtil.makeDir("/storage/emulated/0/xManager");
						FileUtil.makeDir("/storage/emulated/0/xManager/Update");
					}
				});
			}
			catch(Exception e) {
			}
			
			return _v;
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
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
