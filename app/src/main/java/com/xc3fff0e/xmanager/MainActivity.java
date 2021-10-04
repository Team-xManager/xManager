package com.xc3fff0e.xmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.BaseAdapter;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import android.widget.CompoundButton;
import android.view.View;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.graphics.Typeface;
import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double CHECK = 0;
	private String Latest_Version = "";
	private String Current_Version = "";
	private String Package_Name = "";
	private HashMap<String, Object> Versions = new HashMap<>();
	private String PATH = "";
	private double COUNTER = 0;
	private double DELETE = 0;
	private String VERSIONS_REGULAR = "";
	private String VERSIONS_AMOLED = "";
	private String download_selected_0 = "";
	private String download_ready_0 = "";
	private String download_ready_desc_0 = "";
	private String downloading_file_0 = "";
	private String download_success_0 = "";
	private String copy_url_desc_0 = "";
	private String file_directory_0 = "";
	private String copy_url_0 = "";
	private String download_0 = "";
	private String cancel_0 = "";
	private String continue_0 = "";
	private String later_0 = "";
	private String directory_0 = "";
	private String install_now_0 = "";
	private String go_back_0 = "";
	private String install_update_0 = "";
	private double CLOSER_1 = 0;
	private double CLOSER_2 = 0;
	
	private ArrayList<HashMap<String, Object>> listdata = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Versions_1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> others = new ArrayList<>();
	private ArrayList<String> Language = new ArrayList<>();
	private ArrayList<String> Theme = new ArrayList<>();
	
	private LinearLayout box_header;
	private LinearLayout main_body_optimization;
	private ScrollView main_scroll_settings;
	private ScrollView main_scroll_about;
	private SwipeRefreshLayout main_refresh_layout;
	private TextView title_header;
	private TextView title_header_beta;
	private LinearLayout box_header_tab;
	private LinearLayout box_switch;
	private LinearLayout box_update;
	private ImageView icon_switch;
	private ImageView icon_update;
	private TextView hidden_download;
	private TextView app_changelogs;
	private TextView download_selected;
	private TextView download_ready;
	private TextView download_ready_desc;
	private TextView downloading_file;
	private TextView download_success;
	private TextView maintenance_desc;
	private TextView copy_url_desc;
	private TextView maintenance;
	private TextView thanks;
	private TextView main_title;
	private TextView settings_title;
	private TextView about_title;
	private TextView file_directory;
	private TextView new_update;
	private TextView continue_1;
	private TextView cancel;
	private TextView download;
	private TextView later;
	private TextView directory;
	private TextView install_now;
	private TextView install_update;
	private TextView go_back;
	private TextView download_update;
	private TextView not_now;
	private TextView copy_url;
	private TextView show_support;
	private TextView show_support_desc;
	private LinearLayout main_body_settings;
	private LinearLayout box_settings_close;
	private LinearLayout main_box_8;
	private LinearLayout main_box_11;
	private LinearLayout main_box_12;
	private LinearLayout main_box_7;
	private LinearLayout main_box_5;
	private LinearLayout main_box_14;
	private LinearLayout main_box_9;
	private LinearLayout main_box_10;
	private LinearLayout main_box_13;
	private LinearLayout box_settings_icon_close;
	private ImageView settings_icon_close;
	private LinearLayout box_8_sub_1;
	private LinearLayout box_8_sub_2;
	private TextView list_auto_refresh;
	private LinearLayout box_list_auto_refresh;
	private Switch list_auto_refresh_switch;
	private TextView list_auto_refresh_info;
	private LinearLayout box_11_sub_1;
	private LinearLayout box_11_sub_2;
	private TextView force_auto_install;
	private LinearLayout box_force_auto_install;
	private Switch force_auto_install_switch;
	private TextView force_auto_install_info;
	private LinearLayout box_12_sub_1;
	private LinearLayout box_12_sub_2;
	private TextView copy_url_mode;
	private LinearLayout box_copy_url_mode;
	private Switch copy_url_mode_switch;
	private TextView copy_file_url_mode_info;
	private LinearLayout box_7_sub_1;
	private TextView navigation_bar;
	private LinearLayout box_navigation_switch;
	private Switch navigation_switch;
	private LinearLayout box_5_sub_1;
	private TextView theme;
	private LinearLayout box_theme_switch;
	private Spinner select_theme;
	private LinearLayout box_14_sub_1;
	private TextView language;
	private LinearLayout box_language_switch;
	private Spinner select_language;
	private LinearLayout box_9_sub_1;
	private LinearLayout box_9_sub_2;
	private TextView apk_location;
	private EditText apk_path_location;
	private TextView apk_location_info;
	private LinearLayout box_10_sub_1;
	private LinearLayout box_10_sub_2;
	private TextView clear_directory_folders;
	private TextView clear_directory_folders_info;
	private LinearLayout box_reset_settings;
	private TextView reset_settings;
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
	private TextView mod_testers_1;
	private TextView testers_1;
	private TextView mod_testers_2;
	private TextView testers_2;
	private TextView mobilism_team;
	private TextView mobilism_1;
	private TextView manager_team;
	private TextView manager_1;
	private TextView forum_team;
	private TextView forum_1;
	private LinearLayout box_about_4_sub_1;
	private TextView manager_lang_13;
	private TextView translator_13;
	private TextView manager_lang_1;
	private TextView translator_1;
	private TextView manager_lang_2;
	private TextView translator_2;
	private TextView manager_lang_3;
	private TextView translator_3;
	private TextView manager_lang_4;
	private TextView translator_4;
	private TextView manager_lang_5;
	private TextView translator_5;
	private TextView manager_lang_6;
	private TextView translator_6;
	private TextView manager_lang_7;
	private TextView translator_7;
	private TextView translator_7_1;
	private TextView manager_lang_8;
	private TextView translator_8;
	private TextView manager_lang_15;
	private TextView translator_15;
	private TextView manager_lang_9;
	private TextView translator_9;
	private TextView manager_lang_14;
	private TextView translator_14;
	private TextView manager_lang_10;
	private TextView translator_10;
	private TextView manager_lang_12;
	private TextView translator_12;
	private TextView manager_lang_11;
	private TextView translator_11;
	private TextView manager_lang_16;
	private TextView translator_16;
	private ScrollView main_scroll_body;
	private LinearLayout main_body;
	private LinearLayout main_box_1;
	private LinearLayout main_box_2;
	private LinearLayout main_box_6;
	private LinearLayout box_sub_header;
	private LinearLayout main_box_4;
	private LinearLayout main_box_15;
	private LinearLayout box_1;
	private LinearLayout box_2;
	private LinearLayout box_seperator_1;
	private LinearLayout box_5;
	private ListView list_menu_1;
	private TextView title_1;
	private LinearLayout box_1_sub;
	private TextView regular_info;
	private TextView sub_text_2;
	private TextView sub_2;
	private LinearLayout box_switch_1;
	private TextView sub_text_1;
	private TextView sub_1;
	private TextView version_switch_1;
	private LinearLayout box_sub_5;
	private Switch version_switch_01;
	private LinearLayout box_3;
	private LinearLayout box_4;
	private LinearLayout box_seperator_2;
	private LinearLayout box_6;
	private ListView list_menu_2;
	private TextView title_2;
	private LinearLayout box_3_sub;
	private TextView amoled_info;
	private TextView sub_text_4;
	private TextView sub_4;
	private LinearLayout box_switch_2;
	private TextView sub_text_3;
	private TextView sub_3;
	private TextView version_switch_2;
	private LinearLayout box_sub_6;
	private Switch version_switch_02;
	private LinearLayout box_16_sub_1;
	private LinearLayout box_seperator_3;
	private LinearLayout box_6_sub_1;
	private LinearLayout box_6_sub_2;
	private TextView device_cpu;
	private LinearLayout box_cpu;
	private TextView cpu;
	private TextView changelogs;
	private LinearLayout box_changelogs;
	private Switch changelogs_switch;
	private LinearLayout box_changelogs_1;
	private ScrollView scroll_changelogs_1;
	private TextView changelogs_x;
	private LinearLayout box_sub_1;
	private LinearLayout box_sub_2;
	private TextView title_sub;
	private LinearLayout box_uninstall;
	private LinearLayout box_settings;
	private LinearLayout box_cache;
	private LinearLayout box_open;
	private ImageView icon_uninstall;
	private ImageView icon_settings;
	private ImageView icon_cache;
	private ImageView icon_open;
	private LinearLayout box_support;
	private LinearLayout box_donate;
	private LinearLayout box_about;
	private TextView support;
	private ImageView icon_support;
	private TextView donate;
	private ImageView icon_donate;
	private TextView about;
	private ImageView icon_about;
	private LinearLayout box_discord;
	private LinearLayout box_website;
	private LinearLayout box_source;
	private TextView discord;
	private ImageView icon_discord;
	private TextView website;
	private ImageView icon_website;
	private TextView source;
	private ImageView icon_source;
	
	private TimerTask Timer;
	private Intent Support = new Intent();
	private AlertDialog.Builder Donation;
	private Intent Donate = new Intent();
	private AlertDialog.Builder Mod_Features;
	private AlertDialog.Builder Selected_Spotify;
	private AlertDialog.Builder Download_Spotify;
	private AlertDialog.Builder Mod_Info;
	private AlertDialog.Builder Credits;
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
	
	private OnCompleteListener xManager_Notification_onCompleteListener;
	private DatabaseReference xManager_Changelogs = _firebase.getReference("xManager_Changelogs");
	private ChildEventListener _xManager_Changelogs_child_listener;
	private  FileProvider;
	private  File_Fixer;
	private Intent Source = new Intent();
	private DatabaseReference Regular_Mod = _firebase.getReference("Regular_Mod");
	private ChildEventListener _Regular_Mod_child_listener;
	private DatabaseReference Amoled_Black = _firebase.getReference("Amoled_Black");
	private ChildEventListener _Amoled_Black_child_listener;
	private SharedPreferences NAVIGATION_BAR;
	private SharedPreferences LIST_REFRESH;
	private SharedPreferences APK_PATH;
	private SharedPreferences FORCE_INSTALL;
	private SharedPreferences FORCE_INSTALL_UPDATE;
	private SharedPreferences COPY_URL_MODE;
	private AlertDialog.Builder Directory;
	private SharedPreferences VERSIONS;
	private SharedPreferences LANGUAGE;
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
		main_scroll_settings = (ScrollView) findViewById(R.id.main_scroll_settings);
		main_scroll_about = (ScrollView) findViewById(R.id.main_scroll_about);
		main_refresh_layout = (SwipeRefreshLayout) findViewById(R.id.main_refresh_layout);
		title_header = (TextView) findViewById(R.id.title_header);
		title_header_beta = (TextView) findViewById(R.id.title_header_beta);
		box_header_tab = (LinearLayout) findViewById(R.id.box_header_tab);
		box_switch = (LinearLayout) findViewById(R.id.box_switch);
		box_update = (LinearLayout) findViewById(R.id.box_update);
		icon_switch = (ImageView) findViewById(R.id.icon_switch);
		icon_update = (ImageView) findViewById(R.id.icon_update);
		hidden_download = (TextView) findViewById(R.id.hidden_download);
		app_changelogs = (TextView) findViewById(R.id.app_changelogs);
		download_selected = (TextView) findViewById(R.id.download_selected);
		download_ready = (TextView) findViewById(R.id.download_ready);
		download_ready_desc = (TextView) findViewById(R.id.download_ready_desc);
		downloading_file = (TextView) findViewById(R.id.downloading_file);
		download_success = (TextView) findViewById(R.id.download_success);
		maintenance_desc = (TextView) findViewById(R.id.maintenance_desc);
		copy_url_desc = (TextView) findViewById(R.id.copy_url_desc);
		maintenance = (TextView) findViewById(R.id.maintenance);
		thanks = (TextView) findViewById(R.id.thanks);
		main_title = (TextView) findViewById(R.id.main_title);
		settings_title = (TextView) findViewById(R.id.settings_title);
		about_title = (TextView) findViewById(R.id.about_title);
		file_directory = (TextView) findViewById(R.id.file_directory);
		new_update = (TextView) findViewById(R.id.new_update);
		continue_1 = (TextView) findViewById(R.id.continue_1);
		cancel = (TextView) findViewById(R.id.cancel);
		download = (TextView) findViewById(R.id.download);
		later = (TextView) findViewById(R.id.later);
		directory = (TextView) findViewById(R.id.directory);
		install_now = (TextView) findViewById(R.id.install_now);
		install_update = (TextView) findViewById(R.id.install_update);
		go_back = (TextView) findViewById(R.id.go_back);
		download_update = (TextView) findViewById(R.id.download_update);
		not_now = (TextView) findViewById(R.id.not_now);
		copy_url = (TextView) findViewById(R.id.copy_url);
		show_support = (TextView) findViewById(R.id.show_support);
		show_support_desc = (TextView) findViewById(R.id.show_support_desc);
		main_body_settings = (LinearLayout) findViewById(R.id.main_body_settings);
		box_settings_close = (LinearLayout) findViewById(R.id.box_settings_close);
		main_box_8 = (LinearLayout) findViewById(R.id.main_box_8);
		main_box_11 = (LinearLayout) findViewById(R.id.main_box_11);
		main_box_12 = (LinearLayout) findViewById(R.id.main_box_12);
		main_box_7 = (LinearLayout) findViewById(R.id.main_box_7);
		main_box_5 = (LinearLayout) findViewById(R.id.main_box_5);
		main_box_14 = (LinearLayout) findViewById(R.id.main_box_14);
		main_box_9 = (LinearLayout) findViewById(R.id.main_box_9);
		main_box_10 = (LinearLayout) findViewById(R.id.main_box_10);
		main_box_13 = (LinearLayout) findViewById(R.id.main_box_13);
		box_settings_icon_close = (LinearLayout) findViewById(R.id.box_settings_icon_close);
		settings_icon_close = (ImageView) findViewById(R.id.settings_icon_close);
		box_8_sub_1 = (LinearLayout) findViewById(R.id.box_8_sub_1);
		box_8_sub_2 = (LinearLayout) findViewById(R.id.box_8_sub_2);
		list_auto_refresh = (TextView) findViewById(R.id.list_auto_refresh);
		box_list_auto_refresh = (LinearLayout) findViewById(R.id.box_list_auto_refresh);
		list_auto_refresh_switch = (Switch) findViewById(R.id.list_auto_refresh_switch);
		list_auto_refresh_info = (TextView) findViewById(R.id.list_auto_refresh_info);
		box_11_sub_1 = (LinearLayout) findViewById(R.id.box_11_sub_1);
		box_11_sub_2 = (LinearLayout) findViewById(R.id.box_11_sub_2);
		force_auto_install = (TextView) findViewById(R.id.force_auto_install);
		box_force_auto_install = (LinearLayout) findViewById(R.id.box_force_auto_install);
		force_auto_install_switch = (Switch) findViewById(R.id.force_auto_install_switch);
		force_auto_install_info = (TextView) findViewById(R.id.force_auto_install_info);
		box_12_sub_1 = (LinearLayout) findViewById(R.id.box_12_sub_1);
		box_12_sub_2 = (LinearLayout) findViewById(R.id.box_12_sub_2);
		copy_url_mode = (TextView) findViewById(R.id.copy_url_mode);
		box_copy_url_mode = (LinearLayout) findViewById(R.id.box_copy_url_mode);
		copy_url_mode_switch = (Switch) findViewById(R.id.copy_url_mode_switch);
		copy_file_url_mode_info = (TextView) findViewById(R.id.copy_file_url_mode_info);
		box_7_sub_1 = (LinearLayout) findViewById(R.id.box_7_sub_1);
		navigation_bar = (TextView) findViewById(R.id.navigation_bar);
		box_navigation_switch = (LinearLayout) findViewById(R.id.box_navigation_switch);
		navigation_switch = (Switch) findViewById(R.id.navigation_switch);
		box_5_sub_1 = (LinearLayout) findViewById(R.id.box_5_sub_1);
		theme = (TextView) findViewById(R.id.theme);
		box_theme_switch = (LinearLayout) findViewById(R.id.box_theme_switch);
		select_theme = (Spinner) findViewById(R.id.select_theme);
		box_14_sub_1 = (LinearLayout) findViewById(R.id.box_14_sub_1);
		language = (TextView) findViewById(R.id.language);
		box_language_switch = (LinearLayout) findViewById(R.id.box_language_switch);
		select_language = (Spinner) findViewById(R.id.select_language);
		box_9_sub_1 = (LinearLayout) findViewById(R.id.box_9_sub_1);
		box_9_sub_2 = (LinearLayout) findViewById(R.id.box_9_sub_2);
		apk_location = (TextView) findViewById(R.id.apk_location);
		apk_path_location = (EditText) findViewById(R.id.apk_path_location);
		apk_location_info = (TextView) findViewById(R.id.apk_location_info);
		box_10_sub_1 = (LinearLayout) findViewById(R.id.box_10_sub_1);
		box_10_sub_2 = (LinearLayout) findViewById(R.id.box_10_sub_2);
		clear_directory_folders = (TextView) findViewById(R.id.clear_directory_folders);
		clear_directory_folders_info = (TextView) findViewById(R.id.clear_directory_folders_info);
		box_reset_settings = (LinearLayout) findViewById(R.id.box_reset_settings);
		reset_settings = (TextView) findViewById(R.id.reset_settings);
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
		mod_testers_1 = (TextView) findViewById(R.id.mod_testers_1);
		testers_1 = (TextView) findViewById(R.id.testers_1);
		mod_testers_2 = (TextView) findViewById(R.id.mod_testers_2);
		testers_2 = (TextView) findViewById(R.id.testers_2);
		mobilism_team = (TextView) findViewById(R.id.mobilism_team);
		mobilism_1 = (TextView) findViewById(R.id.mobilism_1);
		manager_team = (TextView) findViewById(R.id.manager_team);
		manager_1 = (TextView) findViewById(R.id.manager_1);
		forum_team = (TextView) findViewById(R.id.forum_team);
		forum_1 = (TextView) findViewById(R.id.forum_1);
		box_about_4_sub_1 = (LinearLayout) findViewById(R.id.box_about_4_sub_1);
		manager_lang_13 = (TextView) findViewById(R.id.manager_lang_13);
		translator_13 = (TextView) findViewById(R.id.translator_13);
		manager_lang_1 = (TextView) findViewById(R.id.manager_lang_1);
		translator_1 = (TextView) findViewById(R.id.translator_1);
		manager_lang_2 = (TextView) findViewById(R.id.manager_lang_2);
		translator_2 = (TextView) findViewById(R.id.translator_2);
		manager_lang_3 = (TextView) findViewById(R.id.manager_lang_3);
		translator_3 = (TextView) findViewById(R.id.translator_3);
		manager_lang_4 = (TextView) findViewById(R.id.manager_lang_4);
		translator_4 = (TextView) findViewById(R.id.translator_4);
		manager_lang_5 = (TextView) findViewById(R.id.manager_lang_5);
		translator_5 = (TextView) findViewById(R.id.translator_5);
		manager_lang_6 = (TextView) findViewById(R.id.manager_lang_6);
		translator_6 = (TextView) findViewById(R.id.translator_6);
		manager_lang_7 = (TextView) findViewById(R.id.manager_lang_7);
		translator_7 = (TextView) findViewById(R.id.translator_7);
		translator_7_1 = (TextView) findViewById(R.id.translator_7_1);
		manager_lang_8 = (TextView) findViewById(R.id.manager_lang_8);
		translator_8 = (TextView) findViewById(R.id.translator_8);
		manager_lang_15 = (TextView) findViewById(R.id.manager_lang_15);
		translator_15 = (TextView) findViewById(R.id.translator_15);
		manager_lang_9 = (TextView) findViewById(R.id.manager_lang_9);
		translator_9 = (TextView) findViewById(R.id.translator_9);
		manager_lang_14 = (TextView) findViewById(R.id.manager_lang_14);
		translator_14 = (TextView) findViewById(R.id.translator_14);
		manager_lang_10 = (TextView) findViewById(R.id.manager_lang_10);
		translator_10 = (TextView) findViewById(R.id.translator_10);
		manager_lang_12 = (TextView) findViewById(R.id.manager_lang_12);
		translator_12 = (TextView) findViewById(R.id.translator_12);
		manager_lang_11 = (TextView) findViewById(R.id.manager_lang_11);
		translator_11 = (TextView) findViewById(R.id.translator_11);
		manager_lang_16 = (TextView) findViewById(R.id.manager_lang_16);
		translator_16 = (TextView) findViewById(R.id.translator_16);
		main_scroll_body = (ScrollView) findViewById(R.id.main_scroll_body);
		main_body = (LinearLayout) findViewById(R.id.main_body);
		main_box_1 = (LinearLayout) findViewById(R.id.main_box_1);
		main_box_2 = (LinearLayout) findViewById(R.id.main_box_2);
		main_box_6 = (LinearLayout) findViewById(R.id.main_box_6);
		box_sub_header = (LinearLayout) findViewById(R.id.box_sub_header);
		main_box_4 = (LinearLayout) findViewById(R.id.main_box_4);
		main_box_15 = (LinearLayout) findViewById(R.id.main_box_15);
		box_1 = (LinearLayout) findViewById(R.id.box_1);
		box_2 = (LinearLayout) findViewById(R.id.box_2);
		box_seperator_1 = (LinearLayout) findViewById(R.id.box_seperator_1);
		box_5 = (LinearLayout) findViewById(R.id.box_5);
		list_menu_1 = (ListView) findViewById(R.id.list_menu_1);
		title_1 = (TextView) findViewById(R.id.title_1);
		box_1_sub = (LinearLayout) findViewById(R.id.box_1_sub);
		regular_info = (TextView) findViewById(R.id.regular_info);
		sub_text_2 = (TextView) findViewById(R.id.sub_text_2);
		sub_2 = (TextView) findViewById(R.id.sub_2);
		box_switch_1 = (LinearLayout) findViewById(R.id.box_switch_1);
		sub_text_1 = (TextView) findViewById(R.id.sub_text_1);
		sub_1 = (TextView) findViewById(R.id.sub_1);
		version_switch_1 = (TextView) findViewById(R.id.version_switch_1);
		box_sub_5 = (LinearLayout) findViewById(R.id.box_sub_5);
		version_switch_01 = (Switch) findViewById(R.id.version_switch_01);
		box_3 = (LinearLayout) findViewById(R.id.box_3);
		box_4 = (LinearLayout) findViewById(R.id.box_4);
		box_seperator_2 = (LinearLayout) findViewById(R.id.box_seperator_2);
		box_6 = (LinearLayout) findViewById(R.id.box_6);
		list_menu_2 = (ListView) findViewById(R.id.list_menu_2);
		title_2 = (TextView) findViewById(R.id.title_2);
		box_3_sub = (LinearLayout) findViewById(R.id.box_3_sub);
		amoled_info = (TextView) findViewById(R.id.amoled_info);
		sub_text_4 = (TextView) findViewById(R.id.sub_text_4);
		sub_4 = (TextView) findViewById(R.id.sub_4);
		box_switch_2 = (LinearLayout) findViewById(R.id.box_switch_2);
		sub_text_3 = (TextView) findViewById(R.id.sub_text_3);
		sub_3 = (TextView) findViewById(R.id.sub_3);
		version_switch_2 = (TextView) findViewById(R.id.version_switch_2);
		box_sub_6 = (LinearLayout) findViewById(R.id.box_sub_6);
		version_switch_02 = (Switch) findViewById(R.id.version_switch_02);
		box_16_sub_1 = (LinearLayout) findViewById(R.id.box_16_sub_1);
		box_seperator_3 = (LinearLayout) findViewById(R.id.box_seperator_3);
		box_6_sub_1 = (LinearLayout) findViewById(R.id.box_6_sub_1);
		box_6_sub_2 = (LinearLayout) findViewById(R.id.box_6_sub_2);
		device_cpu = (TextView) findViewById(R.id.device_cpu);
		box_cpu = (LinearLayout) findViewById(R.id.box_cpu);
		cpu = (TextView) findViewById(R.id.cpu);
		changelogs = (TextView) findViewById(R.id.changelogs);
		box_changelogs = (LinearLayout) findViewById(R.id.box_changelogs);
		changelogs_switch = (Switch) findViewById(R.id.changelogs_switch);
		box_changelogs_1 = (LinearLayout) findViewById(R.id.box_changelogs_1);
		scroll_changelogs_1 = (ScrollView) findViewById(R.id.scroll_changelogs_1);
		changelogs_x = (TextView) findViewById(R.id.changelogs_x);
		box_sub_1 = (LinearLayout) findViewById(R.id.box_sub_1);
		box_sub_2 = (LinearLayout) findViewById(R.id.box_sub_2);
		title_sub = (TextView) findViewById(R.id.title_sub);
		box_uninstall = (LinearLayout) findViewById(R.id.box_uninstall);
		box_settings = (LinearLayout) findViewById(R.id.box_settings);
		box_cache = (LinearLayout) findViewById(R.id.box_cache);
		box_open = (LinearLayout) findViewById(R.id.box_open);
		icon_uninstall = (ImageView) findViewById(R.id.icon_uninstall);
		icon_settings = (ImageView) findViewById(R.id.icon_settings);
		icon_cache = (ImageView) findViewById(R.id.icon_cache);
		icon_open = (ImageView) findViewById(R.id.icon_open);
		box_support = (LinearLayout) findViewById(R.id.box_support);
		box_donate = (LinearLayout) findViewById(R.id.box_donate);
		box_about = (LinearLayout) findViewById(R.id.box_about);
		support = (TextView) findViewById(R.id.support);
		icon_support = (ImageView) findViewById(R.id.icon_support);
		donate = (TextView) findViewById(R.id.donate);
		icon_donate = (ImageView) findViewById(R.id.icon_donate);
		about = (TextView) findViewById(R.id.about);
		icon_about = (ImageView) findViewById(R.id.icon_about);
		box_discord = (LinearLayout) findViewById(R.id.box_discord);
		box_website = (LinearLayout) findViewById(R.id.box_website);
		box_source = (LinearLayout) findViewById(R.id.box_source);
		discord = (TextView) findViewById(R.id.discord);
		icon_discord = (ImageView) findViewById(R.id.icon_discord);
		website = (TextView) findViewById(R.id.website);
		icon_website = (ImageView) findViewById(R.id.icon_website);
		source = (TextView) findViewById(R.id.source);
		icon_source = (ImageView) findViewById(R.id.icon_source);
		Donation = new AlertDialog.Builder(this);
		Mod_Features = new AlertDialog.Builder(this);
		Selected_Spotify = new AlertDialog.Builder(this);
		Download_Spotify = new AlertDialog.Builder(this);
		Mod_Info = new AlertDialog.Builder(this);
		Credits = new AlertDialog.Builder(this);
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
		NAVIGATION_BAR = getSharedPreferences("NAVIGATION_BAR", Activity.MODE_PRIVATE);
		LIST_REFRESH = getSharedPreferences("LIST_REFRESH", Activity.MODE_PRIVATE);
		APK_PATH = getSharedPreferences("APK_PATH", Activity.MODE_PRIVATE);
		FORCE_INSTALL = getSharedPreferences("FORCE_INSTALL", Activity.MODE_PRIVATE);
		FORCE_INSTALL_UPDATE = getSharedPreferences("FORCE_INSTALL_UPDATE", Activity.MODE_PRIVATE);
		COPY_URL_MODE = getSharedPreferences("COPY_URL_MODE", Activity.MODE_PRIVATE);
		Directory = new AlertDialog.Builder(this);
		VERSIONS = getSharedPreferences("VERSIONS", Activity.MODE_PRIVATE);
		LANGUAGE = getSharedPreferences("LANGUAGE", Activity.MODE_PRIVATE);
		
		box_switch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				RippleAnimation.create(box_switch).setDuration((long)700).start();
				main_body_optimization.setVisibility(View.GONE);
				main_scroll_settings.setVisibility(View.VISIBLE);
				main_scroll_about.setVisibility(View.GONE);
				main_refresh_layout.setVisibility(View.GONE);
				box_update.setVisibility(View.GONE);
				box_switch.setVisibility(View.GONE);
				apk_path_location.setEnabled(true);
				title_header.setText(settings_title.getText().toString());
				title_header_beta.setVisibility(View.GONE);
				CLOSER_2 = 1;
				_Animation_1();
			}
		});
		
		box_update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
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
						_timer.schedule(Timer, (int)(2000));
						if (true) {
							com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "Slow or No Internet Connection. Try again later.", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
											@Override
											public void onClick(View _view) {
											}
									}).show();
						}
						else {
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
										
										Timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														try {
															_RequiredDialog(Update_Authorized, false);
															Update_Authorized.setTitle(new_update.getText().toString());
															Update_Authorized.setPositiveButton(download_update.getText().toString(), new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	try {
																		_RequiredDialog(Update_Authorized, true);
																		if (FORCE_INSTALL_UPDATE.getString("FORCE_INSTALL_UPDATE", "").equals("XX")) {
																			_Download_Update_Install(hidden_download.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/");
																		}
																		else {
																			if (FORCE_INSTALL_UPDATE.getString("FORCE_INSTALL_UPDATE", "").equals("YY")) {
																				_Download_Update(hidden_download.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/");
																			}
																		}
																		_Update_Remover();
																	}
																	catch(Exception e) {
																	}
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
															Update_Authorized.setNeutralButton(not_now.getText().toString(), new DialogInterface.OnClickListener() {
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
												});
											}
										};
										_timer.schedule(Timer, (int)(2800));
									}
									else {
										if (Double.parseDouble(Current_Version) > Double.parseDouble(Latest_Version)) {
											Version.child("App").child("V").setValue(Current_Version);
										}
										else {
											
											Timer = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
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
																Update_Latest.setTitle("xManager v".concat(app_version.getText().toString().concat(" (Latest Version)")));
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
													});
												}
											};
											_timer.schedule(Timer, (int)(2800));
										}
									}
								}
								@Override
								public void onCancelled(DatabaseError _databaseError) {
								}
							});
						}
					}
				}
				catch(Exception e) {
				}
			}
		});
		
		main_box_10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.isExistFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/") && (FileUtil.isExistFile("/storage/emulated/0/xManager/") && FileUtil.isExistFile(apk_path_location.getText().toString()))) {
					FileUtil.deleteFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/");
					FileUtil.deleteFile("/storage/emulated/0/xManager/");
					FileUtil.deleteFile(apk_path_location.getText().toString());
				}
				else {
					if (!(FileUtil.isExistFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/") && (FileUtil.isExistFile("/storage/emulated/0/xManager/") && FileUtil.isExistFile(apk_path_location.getText().toString())))) {
						
					}
				}
				if (DELETE == 1) {
					
				}
				else {
					if (DELETE == 0) {
						
					}
				}
				DELETE = 0;
			}
		});
		
		box_settings_icon_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				RippleAnimation.create(box_settings_icon_close).setDuration((long)700).start();
				main_body_optimization.setVisibility(View.GONE);
				main_scroll_settings.setVisibility(View.GONE);
				main_scroll_about.setVisibility(View.GONE);
				main_refresh_layout.setVisibility(View.VISIBLE);
				box_update.setVisibility(View.VISIBLE);
				box_switch.setVisibility(View.VISIBLE);
				apk_path_location.setEnabled(false);
				title_header.setText(main_title.getText().toString());
				title_header_beta.setVisibility(View.VISIBLE);
				Animation header_beta;
				header_beta = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
				header_beta.setDuration(200); title_header_beta.startAnimation(header_beta);
				header_beta = null;
				CLOSER_2 = 0;
				_Animation_0();
				_Url_Mode();
			}
		});
		
		list_auto_refresh_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					LIST_REFRESH.edit().putString("UPDATE", "ON").commit();
				}
				else {
					LIST_REFRESH.edit().putString("UPDATE", "OFF").commit();
				}
				COUNTER = 1;
			}
		});
		
		force_auto_install_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					FORCE_INSTALL.edit().putString("FORCE_INSTALL", "X").commit();
					FORCE_INSTALL_UPDATE.edit().putString("FORCE_INSTALL_UPDATE", "XX").commit();
					copy_url_mode_switch.setChecked(false);
				}
				else {
					FORCE_INSTALL.edit().putString("FORCE_INSTALL", "Y").commit();
					FORCE_INSTALL_UPDATE.edit().putString("FORCE_INSTALL_UPDATE", "YY").commit();
				}
				COUNTER = 1;
			}
		});
		
		copy_url_mode_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					COPY_URL_MODE.edit().putString("COPY_URL_MODE", "URL_ON").commit();
					force_auto_install_switch.setChecked(false);
				}
				else {
					COPY_URL_MODE.edit().putString("COPY_URL_MODE", "URL_OFF").commit();
				}
				COUNTER = 1;
			}
		});
		
		navigation_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					NAVIGATION_BAR.edit().putString("NAVIGATION", "1").commit();
					getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
				}
				else {
					NAVIGATION_BAR.edit().putString("NAVIGATION", "0").commit();
					getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
					
					if (Build.VERSION.SDK_INT >= 21) {
						getWindow().setNavigationBarColor(Color.parseColor("#212121"));
					}
				}
				COUNTER = 1;
			}
		});
		
		select_theme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					THEME.edit().putString("THEME", "0").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 1) {
					THEME.edit().putString("THEME", "1").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 2) {
					THEME.edit().putString("THEME", "2").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 3) {
					THEME.edit().putString("THEME", "3").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 4) {
					THEME.edit().putString("THEME", "4").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 5) {
					THEME.edit().putString("THEME", "5").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 6) {
					THEME.edit().putString("THEME", "6").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 7) {
					THEME.edit().putString("THEME", "7").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 8) {
					THEME.edit().putString("THEME", "8").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 9) {
					THEME.edit().putString("THEME", "9").commit();
					
					
					
					COUNTER = 1;
				}
				if (_position == 10) {
					THEME.edit().putString("THEME", "10").commit();
					
					
					
					COUNTER = 1;
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		select_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					LANGUAGE.edit().putString("LANGUAGE", "0").commit();
					    title_1.setText(R.string.spotify_regular);
						title_2.setText(R.string.spotify_amoled);
						sub_text_2.setText(R.string.installed);
						sub_text_4.setText(R.string.installed);
						sub_text_1.setText(R.string.latest);
						sub_text_3.setText(R.string.latest);
						version_switch_1.setText(R.string.versions);
						version_switch_2.setText(R.string.versions);
						changelogs.setText(R.string.changelogs);
						title_sub.setText(R.string.manager_tools);
						device_cpu.setText(R.string.device_cpu);
						source.setText(R.string.source);
						support.setText(R.string.support);
						donate.setText(R.string.donate);
						about.setText(R.string.about);
						list_auto_refresh.setText(R.string.list_auto_refresh);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc);
						force_auto_install.setText(R.string.force_auto_install);
						force_auto_install_info.setText(R.string.force_auto_install_desc);
						copy_url_mode.setText(R.string.copy_url_mode);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc);
						navigation_bar.setText(R.string.hide_navigation_bar);
						theme.setText(R.string.show_themes);
						apk_location.setText(R.string.apk_location);
						apk_location_info.setText(R.string.apk_location_desc);
						clear_directory_folders.setText(R.string.clear_directory_folders);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc);
						reset_settings.setText(R.string.reset_settings);
						sub_title.setText(R.string.about_sub);
						developer_manager.setText(R.string.xmanager_dev);
						developer_spotify.setText(R.string.spotify_mod_devs);
						support_team.setText(R.string.telegram_support_team);
						mod_testers_1.setText(R.string.manager_testers);
						mod_testers_2.setText(R.string.manager_hosting);
						mobilism_team.setText(R.string.mobilism_team);
						forum_team.setText(R.string.forum_team);
						manager_team.setText(R.string.xspotify_team);
						contributors_1.setText(R.string.contributors);
						download_selected.setText(R.string.download_selected);
						download_ready.setText(R.string.download_ready);
						download_ready_desc.setText(R.string.download_ready_desc);
						downloading_file.setText(R.string.downloading_file);
						download_success.setText(R.string.download_success);
						copy_url_desc.setText(R.string.copy_url_desc);
						file_directory.setText(R.string.file_directory);
						new_update.setText(R.string.new_update);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url);
						continue_1.setText(R.string.continue_1);
						cancel.setText(R.string.cancel);
						download.setText(R.string.download);
						later.setText(R.string.later);
						directory.setText(R.string.directory);
						install_now.setText(R.string.install_now);
						install_update.setText(R.string.install_update);
						go_back.setText(R.string.go_back);
						download_update.setText(R.string.download_update);
						not_now.setText(R.string.not_now);
						show_support.setText(R.string.show_support);
						show_support_desc.setText(R.string.show_support_desc);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title);
						settings_title.setText(R.string.settings_title);
						about_title.setText(R.string.about_title);
						maintenance.setText(R.string.maintenance);
						maintenance_desc.setText(R.string.maintenance_desc);
						thanks.setText(R.string.thanks);
						language.setText(R.string.language);
					  website.setText(R.string.website);
					
					discord.setText(R.string.discord);
					COUNTER = 1;
				}
				if (_position == 1) {
					LANGUAGE.edit().putString("LANGUAGE", "1").commit();
					    title_1.setText(R.string.spotify_regular_01);
						title_2.setText(R.string.spotify_amoled_01);
						sub_text_2.setText(R.string.installed_01);
						sub_text_4.setText(R.string.installed_01);
						sub_text_1.setText(R.string.latest_01);
						sub_text_3.setText(R.string.latest_01);
						version_switch_1.setText(R.string.versions_01);
						version_switch_2.setText(R.string.versions_01);
						changelogs.setText(R.string.changelogs_01);
						title_sub.setText(R.string.manager_tools_01);
						device_cpu.setText(R.string.device_cpu_01);
						source.setText(R.string.source_01);
						support.setText(R.string.support_01);
						donate.setText(R.string.donate_01);
						about.setText(R.string.about_01);
						list_auto_refresh.setText(R.string.list_auto_refresh_01);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_01);
						force_auto_install.setText(R.string.force_auto_install_01);
						force_auto_install_info.setText(R.string.force_auto_install_desc_01);
						copy_url_mode.setText(R.string.copy_url_mode_01);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_01);
						navigation_bar.setText(R.string.hide_navigation_bar_01);
						theme.setText(R.string.show_themes_01);
						apk_location.setText(R.string.apk_location_01);
						apk_location_info.setText(R.string.apk_location_desc_01);
						clear_directory_folders.setText(R.string.clear_directory_folders_01);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_01);
						reset_settings.setText(R.string.reset_settings_01);
						sub_title.setText(R.string.about_sub_01);
						developer_manager.setText(R.string.xmanager_dev_01);
						developer_spotify.setText(R.string.spotify_mod_devs_01);
						support_team.setText(R.string.telegram_support_team_01);
						mod_testers_1.setText(R.string.manager_testers_01);
						mod_testers_2.setText(R.string.manager_hosting_01);
						mobilism_team.setText(R.string.mobilism_team_01);
						forum_team.setText(R.string.forum_team_01);
						manager_team.setText(R.string.xspotify_team_01);
						contributors_1.setText(R.string.contributors_01);
						download_selected.setText(R.string.download_selected_01);
						download_ready.setText(R.string.download_ready_01);
						download_ready_desc.setText(R.string.download_ready_desc_01);
						downloading_file.setText(R.string.downloading_file_01);
						download_success.setText(R.string.download_success_01);
						copy_url_desc.setText(R.string.copy_url_desc_01);
						file_directory.setText(R.string.file_directory_01);
						new_update.setText(R.string.new_update_01);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_01);
						continue_1.setText(R.string.continue_1_01);
						cancel.setText(R.string.cancel_01);
						download.setText(R.string.download_01);
						later.setText(R.string.later_01);
						directory.setText(R.string.directory_01);
						install_now.setText(R.string.install_now_01);
						install_update.setText(R.string.install_update_01);
						go_back.setText(R.string.go_back_01);
						download_update.setText(R.string.download_update_01);
						not_now.setText(R.string.not_now_01);
						show_support.setText(R.string.show_support_01);
						show_support_desc.setText(R.string.show_support_desc_01);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_01);
						settings_title.setText(R.string.settings_title_01);
						about_title.setText(R.string.about_title_01);
						maintenance.setText(R.string.maintenance_01);
						maintenance_desc.setText(R.string.maintenance_desc_01);
						thanks.setText(R.string.thanks_01);
						language.setText(R.string.language_01);
					  website.setText(R.string.website_01);
					
					discord.setText(R.string.discord_01);
					COUNTER = 1;
				}
				if (_position == 2) {
					LANGUAGE.edit().putString("LANGUAGE", "2").commit();
					    title_1.setText(R.string.spotify_regular_02);
						title_2.setText(R.string.spotify_amoled_02);
						sub_text_2.setText(R.string.installed_02);
						sub_text_4.setText(R.string.installed_02);
						sub_text_1.setText(R.string.latest_02);
						sub_text_3.setText(R.string.latest_02);
						version_switch_1.setText(R.string.versions_02);
						version_switch_2.setText(R.string.versions_02);
						changelogs.setText(R.string.changelogs_02);
						title_sub.setText(R.string.manager_tools_02);
						device_cpu.setText(R.string.device_cpu_02);
						source.setText(R.string.source_02);
						support.setText(R.string.support_02);
						donate.setText(R.string.donate_02);
						about.setText(R.string.about_02);
						list_auto_refresh.setText(R.string.list_auto_refresh_02);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_02);
						force_auto_install.setText(R.string.force_auto_install_02);
						force_auto_install_info.setText(R.string.force_auto_install_desc_02);
						copy_url_mode.setText(R.string.copy_url_mode_02);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_02);
						navigation_bar.setText(R.string.hide_navigation_bar_02);
						theme.setText(R.string.show_themes_02);
						apk_location.setText(R.string.apk_location_02);
						apk_location_info.setText(R.string.apk_location_desc_02);
						clear_directory_folders.setText(R.string.clear_directory_folders_02);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_02);
						reset_settings.setText(R.string.reset_settings_02);
						sub_title.setText(R.string.about_sub_02);
						developer_manager.setText(R.string.xmanager_dev_02);
						developer_spotify.setText(R.string.spotify_mod_devs_02);
						support_team.setText(R.string.telegram_support_team_02);
						mod_testers_1.setText(R.string.manager_testers_02);
						mod_testers_2.setText(R.string.manager_hosting_02);
						mobilism_team.setText(R.string.mobilism_team_02);
						forum_team.setText(R.string.forum_team_02);
						manager_team.setText(R.string.xspotify_team_02);
						contributors_1.setText(R.string.contributors_02);
						download_selected.setText(R.string.download_selected_02);
						download_ready.setText(R.string.download_ready_02);
						download_ready_desc.setText(R.string.download_ready_desc_02);
						downloading_file.setText(R.string.downloading_file_02);
						download_success.setText(R.string.download_success_02);
						copy_url_desc.setText(R.string.copy_url_desc_02);
						file_directory.setText(R.string.file_directory_02);
						new_update.setText(R.string.new_update_02);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_02);
						continue_1.setText(R.string.continue_1_02);
						cancel.setText(R.string.cancel_02);
						download.setText(R.string.download_02);
						later.setText(R.string.later_02);
						directory.setText(R.string.directory_02);
						install_now.setText(R.string.install_now_02);
						install_update.setText(R.string.install_update_02);
						go_back.setText(R.string.go_back_02);
						download_update.setText(R.string.download_update_02);
						not_now.setText(R.string.not_now_02);
						show_support.setText(R.string.show_support_02);
						show_support_desc.setText(R.string.show_support_desc_02);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_02);
						settings_title.setText(R.string.settings_title_02);
						about_title.setText(R.string.about_title_02);
						maintenance.setText(R.string.maintenance_02);
						maintenance_desc.setText(R.string.maintenance_desc_02);
						thanks.setText(R.string.thanks_02);
						language.setText(R.string.language_02);
					  website.setText(R.string.website_02);
					
					discord.setText(R.string.discord_02);
					COUNTER = 1;
				}
				if (_position == 3) {
					LANGUAGE.edit().putString("LANGUAGE", "3").commit();
					    title_1.setText(R.string.spotify_regular_03);
						title_2.setText(R.string.spotify_amoled_03);
						sub_text_2.setText(R.string.installed_03);
						sub_text_4.setText(R.string.installed_03);
						sub_text_1.setText(R.string.latest_03);
						sub_text_3.setText(R.string.latest_03);
						version_switch_1.setText(R.string.versions_03);
						version_switch_2.setText(R.string.versions_03);
						changelogs.setText(R.string.changelogs_03);
						title_sub.setText(R.string.manager_tools_03);
						device_cpu.setText(R.string.device_cpu_03);
						source.setText(R.string.source_03);
						support.setText(R.string.support_03);
						donate.setText(R.string.donate_03);
						about.setText(R.string.about_03);
						list_auto_refresh.setText(R.string.list_auto_refresh_03);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_03);
						force_auto_install.setText(R.string.force_auto_install_03);
						force_auto_install_info.setText(R.string.force_auto_install_desc_03);
						copy_url_mode.setText(R.string.copy_url_mode_03);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_03);
						navigation_bar.setText(R.string.hide_navigation_bar_03);
						theme.setText(R.string.show_themes_03);
						apk_location.setText(R.string.apk_location_03);
						apk_location_info.setText(R.string.apk_location_desc_03);
						clear_directory_folders.setText(R.string.clear_directory_folders_03);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_03);
						reset_settings.setText(R.string.reset_settings_03);
						sub_title.setText(R.string.about_sub_03);
						developer_manager.setText(R.string.xmanager_dev_03);
						developer_spotify.setText(R.string.spotify_mod_devs_03);
						support_team.setText(R.string.telegram_support_team_03);
						mod_testers_1.setText(R.string.manager_testers_03);
						mod_testers_2.setText(R.string.manager_hosting_03);
						mobilism_team.setText(R.string.mobilism_team_03);
						forum_team.setText(R.string.forum_team_03);
						manager_team.setText(R.string.xspotify_team_03);
						contributors_1.setText(R.string.contributors_03);
						download_selected.setText(R.string.download_selected_03);
						download_ready.setText(R.string.download_ready_03);
						download_ready_desc.setText(R.string.download_ready_desc_03);
						downloading_file.setText(R.string.downloading_file_03);
						download_success.setText(R.string.download_success_03);
						copy_url_desc.setText(R.string.copy_url_desc_03);
						file_directory.setText(R.string.file_directory_03);
						new_update.setText(R.string.new_update_03);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_03);
						continue_1.setText(R.string.continue_1_03);
						cancel.setText(R.string.cancel_03);
						download.setText(R.string.download_03);
						later.setText(R.string.later_03);
						directory.setText(R.string.directory_03);
						install_now.setText(R.string.install_now_03);
						install_update.setText(R.string.install_update_03);
						go_back.setText(R.string.go_back_03);
						download_update.setText(R.string.download_update_03);
						not_now.setText(R.string.not_now_03);
						show_support.setText(R.string.show_support_03);
						show_support_desc.setText(R.string.show_support_desc_03);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_03);
						settings_title.setText(R.string.settings_title_03);
						about_title.setText(R.string.about_title_03);
						maintenance.setText(R.string.maintenance_03);
						maintenance_desc.setText(R.string.maintenance_desc_03);
						thanks.setText(R.string.thanks_03);
						language.setText(R.string.language_03);
					  website.setText(R.string.website_03);
					
					discord.setText(R.string.discord_03);
					COUNTER = 1;
				}
				if (_position == 4) {
					LANGUAGE.edit().putString("LANGUAGE", "4").commit();
					    title_1.setText(R.string.spotify_regular_04);
						title_2.setText(R.string.spotify_amoled_04);
						sub_text_2.setText(R.string.installed_04);
						sub_text_4.setText(R.string.installed_04);
						sub_text_1.setText(R.string.latest_04);
						sub_text_3.setText(R.string.latest_04);
						version_switch_1.setText(R.string.versions_04);
						version_switch_2.setText(R.string.versions_04);
						changelogs.setText(R.string.changelogs_04);
						title_sub.setText(R.string.manager_tools_04);
						device_cpu.setText(R.string.device_cpu_04);
						source.setText(R.string.source_04);
						support.setText(R.string.support_04);
						donate.setText(R.string.donate_04);
						about.setText(R.string.about_04);
						list_auto_refresh.setText(R.string.list_auto_refresh_04);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_04);
						force_auto_install.setText(R.string.force_auto_install_04);
						force_auto_install_info.setText(R.string.force_auto_install_desc_04);
						copy_url_mode.setText(R.string.copy_url_mode_04);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_04);
						navigation_bar.setText(R.string.hide_navigation_bar_04);
						theme.setText(R.string.show_themes_04);
						apk_location.setText(R.string.apk_location_04);
						apk_location_info.setText(R.string.apk_location_desc_04);
						clear_directory_folders.setText(R.string.clear_directory_folders_04);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_04);
						reset_settings.setText(R.string.reset_settings_04);
						sub_title.setText(R.string.about_sub_04);
						developer_manager.setText(R.string.xmanager_dev_04);
						developer_spotify.setText(R.string.spotify_mod_devs_04);
						support_team.setText(R.string.telegram_support_team_04);
						mod_testers_1.setText(R.string.manager_testers_04);
						mod_testers_2.setText(R.string.manager_hosting_04);
						mobilism_team.setText(R.string.mobilism_team_04);
						forum_team.setText(R.string.forum_team_04);
						manager_team.setText(R.string.xspotify_team_04);
						contributors_1.setText(R.string.contributors_04);
						download_selected.setText(R.string.download_selected_04);
						download_ready.setText(R.string.download_ready_04);
						download_ready_desc.setText(R.string.download_ready_desc_04);
						downloading_file.setText(R.string.downloading_file_04);
						download_success.setText(R.string.download_success_04);
						copy_url_desc.setText(R.string.copy_url_desc_04);
						file_directory.setText(R.string.file_directory_04);
						new_update.setText(R.string.new_update_04);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_04);
						continue_1.setText(R.string.continue_1_04);
						cancel.setText(R.string.cancel_04);
						download.setText(R.string.download_04);
						later.setText(R.string.later_04);
						directory.setText(R.string.directory_04);
						install_now.setText(R.string.install_now_04);
						install_update.setText(R.string.install_update_04);
						go_back.setText(R.string.go_back_04);
						download_update.setText(R.string.download_update_04);
						not_now.setText(R.string.not_now_04);
						show_support.setText(R.string.show_support_04);
						show_support_desc.setText(R.string.show_support_desc_04);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_04);
						settings_title.setText(R.string.settings_title_04);
						about_title.setText(R.string.about_title_04);
						maintenance.setText(R.string.maintenance_04);
						maintenance_desc.setText(R.string.maintenance_desc_04);
						thanks.setText(R.string.thanks_04);
						language.setText(R.string.language_04);
					  website.setText(R.string.website_04);
					
					discord.setText(R.string.discord_04);
					COUNTER = 1;
				}
				if (_position == 5) {
					LANGUAGE.edit().putString("LANGUAGE", "5").commit();
					    title_1.setText(R.string.spotify_regular_05);
						title_2.setText(R.string.spotify_amoled_05);
						sub_text_2.setText(R.string.installed_05);
						sub_text_4.setText(R.string.installed_05);
						sub_text_1.setText(R.string.latest_05);
						sub_text_3.setText(R.string.latest_05);
						version_switch_1.setText(R.string.versions_05);
						version_switch_2.setText(R.string.versions_05);
						changelogs.setText(R.string.changelogs_05);
						title_sub.setText(R.string.manager_tools_05);
						device_cpu.setText(R.string.device_cpu_05);
						source.setText(R.string.source_05);
						support.setText(R.string.support_05);
						donate.setText(R.string.donate_05);
						about.setText(R.string.about_05);
						list_auto_refresh.setText(R.string.list_auto_refresh_05);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_05);
						force_auto_install.setText(R.string.force_auto_install_05);
						force_auto_install_info.setText(R.string.force_auto_install_desc_05);
						copy_url_mode.setText(R.string.copy_url_mode_05);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_05);
						navigation_bar.setText(R.string.hide_navigation_bar_05);
						theme.setText(R.string.show_themes_05);
						apk_location.setText(R.string.apk_location_05);
						apk_location_info.setText(R.string.apk_location_desc_05);
						clear_directory_folders.setText(R.string.clear_directory_folders_05);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_05);
						reset_settings.setText(R.string.reset_settings_05);
						sub_title.setText(R.string.about_sub_05);
						developer_manager.setText(R.string.xmanager_dev_05);
						developer_spotify.setText(R.string.spotify_mod_devs_05);
						support_team.setText(R.string.telegram_support_team_05);
						mod_testers_1.setText(R.string.manager_testers_05);
						mod_testers_2.setText(R.string.manager_hosting_05);
						mobilism_team.setText(R.string.mobilism_team_05);
						forum_team.setText(R.string.forum_team_05);
						manager_team.setText(R.string.xspotify_team_05);
						contributors_1.setText(R.string.contributors_05);
						download_selected.setText(R.string.download_selected_05);
						download_ready.setText(R.string.download_ready_05);
						download_ready_desc.setText(R.string.download_ready_desc_05);
						downloading_file.setText(R.string.downloading_file_05);
						download_success.setText(R.string.download_success_05);
						copy_url_desc.setText(R.string.copy_url_desc_05);
						file_directory.setText(R.string.file_directory_05);
						new_update.setText(R.string.new_update_05);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_05);
						continue_1.setText(R.string.continue_1_05);
						cancel.setText(R.string.cancel_05);
						download.setText(R.string.download_05);
						later.setText(R.string.later_05);
						directory.setText(R.string.directory_05);
						install_now.setText(R.string.install_now_05);
						install_update.setText(R.string.install_update_05);
						go_back.setText(R.string.go_back_05);
						download_update.setText(R.string.download_update_05);
						not_now.setText(R.string.not_now_05);
						show_support.setText(R.string.show_support_05);
						show_support_desc.setText(R.string.show_support_desc_05);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_05);
						settings_title.setText(R.string.settings_title_05);
						about_title.setText(R.string.about_title_05);
						maintenance.setText(R.string.maintenance_05);
						maintenance_desc.setText(R.string.maintenance_desc_05);
						thanks.setText(R.string.thanks_05);
						language.setText(R.string.language_05);
					  website.setText(R.string.website_05);
					
					discord.setText(R.string.discord_05);
					COUNTER = 1;
				}
				if (_position == 6) {
					LANGUAGE.edit().putString("LANGUAGE", "6").commit();
					    title_1.setText(R.string.spotify_regular_06);
						title_2.setText(R.string.spotify_amoled_06);
						sub_text_2.setText(R.string.installed_06);
						sub_text_4.setText(R.string.installed_06);
						sub_text_1.setText(R.string.latest_06);
						sub_text_3.setText(R.string.latest_06);
						version_switch_1.setText(R.string.versions_06);
						version_switch_2.setText(R.string.versions_06);
						changelogs.setText(R.string.changelogs_06);
						title_sub.setText(R.string.manager_tools_06);
						device_cpu.setText(R.string.device_cpu_06);
						source.setText(R.string.source_06);
						support.setText(R.string.support_06);
						donate.setText(R.string.donate_06);
						about.setText(R.string.about_06);
						list_auto_refresh.setText(R.string.list_auto_refresh_06);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_06);
						force_auto_install.setText(R.string.force_auto_install_06);
						force_auto_install_info.setText(R.string.force_auto_install_desc_06);
						copy_url_mode.setText(R.string.copy_url_mode_06);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_06);
						navigation_bar.setText(R.string.hide_navigation_bar_06);
						theme.setText(R.string.show_themes_06);
						apk_location.setText(R.string.apk_location_06);
						apk_location_info.setText(R.string.apk_location_desc_06);
						clear_directory_folders.setText(R.string.clear_directory_folders_06);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_06);
						reset_settings.setText(R.string.reset_settings_06);
						sub_title.setText(R.string.about_sub_06);
						developer_manager.setText(R.string.xmanager_dev_06);
						developer_spotify.setText(R.string.spotify_mod_devs_06);
						support_team.setText(R.string.telegram_support_team_06);
						mod_testers_1.setText(R.string.manager_testers_06);
						mod_testers_2.setText(R.string.manager_hosting_06);
						mobilism_team.setText(R.string.mobilism_team_06);
						forum_team.setText(R.string.forum_team_06);
						manager_team.setText(R.string.xspotify_team_06);
						contributors_1.setText(R.string.contributors_06);
						download_selected.setText(R.string.download_selected_06);
						download_ready.setText(R.string.download_ready_06);
						download_ready_desc.setText(R.string.download_ready_desc_06);
						downloading_file.setText(R.string.downloading_file_06);
						download_success.setText(R.string.download_success_06);
						copy_url_desc.setText(R.string.copy_url_desc_06);
						file_directory.setText(R.string.file_directory_06);
						new_update.setText(R.string.new_update_06);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_06);
						continue_1.setText(R.string.continue_1_06);
						cancel.setText(R.string.cancel_06);
						download.setText(R.string.download_06);
						later.setText(R.string.later_06);
						directory.setText(R.string.directory_06);
						install_now.setText(R.string.install_now_06);
						install_update.setText(R.string.install_update_06);
						go_back.setText(R.string.go_back_06);
						download_update.setText(R.string.download_update_06);
						not_now.setText(R.string.not_now_06);
						show_support.setText(R.string.show_support_06);
						show_support_desc.setText(R.string.show_support_desc_06);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_06);
						settings_title.setText(R.string.settings_title_06);
						about_title.setText(R.string.about_title_06);
						maintenance.setText(R.string.maintenance_06);
						maintenance_desc.setText(R.string.maintenance_desc_06);
						thanks.setText(R.string.thanks_06);
						language.setText(R.string.language_06);
					  website.setText(R.string.website_06);
					
					discord.setText(R.string.discord_06);
					COUNTER = 1;
				}
				if (_position == 7) {
					LANGUAGE.edit().putString("LANGUAGE", "7").commit();
					    title_1.setText(R.string.spotify_regular_07);
						title_2.setText(R.string.spotify_amoled_07);
						sub_text_2.setText(R.string.installed_07);
						sub_text_4.setText(R.string.installed_07);
						sub_text_1.setText(R.string.latest_07);
						sub_text_3.setText(R.string.latest_07);
						version_switch_1.setText(R.string.versions_07);
						version_switch_2.setText(R.string.versions_07);
						changelogs.setText(R.string.changelogs_07);
						title_sub.setText(R.string.manager_tools_07);
						device_cpu.setText(R.string.device_cpu_07);
						source.setText(R.string.source_07);
						support.setText(R.string.support_07);
						donate.setText(R.string.donate_07);
						about.setText(R.string.about_07);
						list_auto_refresh.setText(R.string.list_auto_refresh_07);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_07);
						force_auto_install.setText(R.string.force_auto_install_07);
						force_auto_install_info.setText(R.string.force_auto_install_desc_07);
						copy_url_mode.setText(R.string.copy_url_mode_07);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_07);
						navigation_bar.setText(R.string.hide_navigation_bar_07);
						theme.setText(R.string.show_themes_07);
						apk_location.setText(R.string.apk_location_07);
						apk_location_info.setText(R.string.apk_location_desc_07);
						clear_directory_folders.setText(R.string.clear_directory_folders_07);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_07);
						reset_settings.setText(R.string.reset_settings_07);
						sub_title.setText(R.string.about_sub_07);
						developer_manager.setText(R.string.xmanager_dev_07);
						developer_spotify.setText(R.string.spotify_mod_devs_07);
						support_team.setText(R.string.telegram_support_team_07);
						mod_testers_1.setText(R.string.manager_testers_07);
						mod_testers_2.setText(R.string.manager_hosting_07);
						mobilism_team.setText(R.string.mobilism_team_07);
						forum_team.setText(R.string.forum_team_07);
						manager_team.setText(R.string.xspotify_team_07);
						contributors_1.setText(R.string.contributors_07);
						download_selected.setText(R.string.download_selected_07);
						download_ready.setText(R.string.download_ready_07);
						download_ready_desc.setText(R.string.download_ready_desc_07);
						downloading_file.setText(R.string.downloading_file_07);
						download_success.setText(R.string.download_success_07);
						copy_url_desc.setText(R.string.copy_url_desc_07);
						file_directory.setText(R.string.file_directory_07);
						new_update.setText(R.string.new_update_07);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_07);
						continue_1.setText(R.string.continue_1_07);
						cancel.setText(R.string.cancel_07);
						download.setText(R.string.download_07);
						later.setText(R.string.later_07);
						directory.setText(R.string.directory_07);
						install_now.setText(R.string.install_now_07);
						install_update.setText(R.string.install_update_07);
						go_back.setText(R.string.go_back_07);
						download_update.setText(R.string.download_update_07);
						not_now.setText(R.string.not_now_07);
						show_support.setText(R.string.show_support_07);
						show_support_desc.setText(R.string.show_support_desc_07);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_07);
						settings_title.setText(R.string.settings_title_07);
						about_title.setText(R.string.about_title_07);
						maintenance.setText(R.string.maintenance_07);
						maintenance_desc.setText(R.string.maintenance_desc_07);
						thanks.setText(R.string.thanks_07);
						language.setText(R.string.language_07);
					  website.setText(R.string.website_07);
					
					discord.setText(R.string.discord_07);
					COUNTER = 1;
				}
				if (_position == 8) {
					LANGUAGE.edit().putString("LANGUAGE", "8").commit();
					    title_1.setText(R.string.spotify_regular_08);
						title_2.setText(R.string.spotify_amoled_08);
						sub_text_2.setText(R.string.installed_08);
						sub_text_4.setText(R.string.installed_08);
						sub_text_1.setText(R.string.latest_08);
						sub_text_3.setText(R.string.latest_08);
						version_switch_1.setText(R.string.versions_08);
						version_switch_2.setText(R.string.versions_08);
						changelogs.setText(R.string.changelogs_08);
						title_sub.setText(R.string.manager_tools_08);
						device_cpu.setText(R.string.device_cpu_08);
						source.setText(R.string.source_08);
						support.setText(R.string.support_08);
						donate.setText(R.string.donate_08);
						about.setText(R.string.about_08);
						list_auto_refresh.setText(R.string.list_auto_refresh_08);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_08);
						force_auto_install.setText(R.string.force_auto_install_08);
						force_auto_install_info.setText(R.string.force_auto_install_desc_08);
						copy_url_mode.setText(R.string.copy_url_mode_08);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_08);
						navigation_bar.setText(R.string.hide_navigation_bar_08);
						theme.setText(R.string.show_themes_08);
						apk_location.setText(R.string.apk_location_08);
						apk_location_info.setText(R.string.apk_location_desc_08);
						clear_directory_folders.setText(R.string.clear_directory_folders_08);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_08);
						reset_settings.setText(R.string.reset_settings_08);
						sub_title.setText(R.string.about_sub_08);
						developer_manager.setText(R.string.xmanager_dev_08);
						developer_spotify.setText(R.string.spotify_mod_devs_08);
						support_team.setText(R.string.telegram_support_team_08);
						mod_testers_1.setText(R.string.manager_testers_08);
						mod_testers_2.setText(R.string.manager_hosting_08);
						mobilism_team.setText(R.string.mobilism_team_08);
						forum_team.setText(R.string.forum_team_08);
						manager_team.setText(R.string.xspotify_team_08);
						contributors_1.setText(R.string.contributors_08);
						download_selected.setText(R.string.download_selected_08);
						download_ready.setText(R.string.download_ready_08);
						download_ready_desc.setText(R.string.download_ready_desc_08);
						downloading_file.setText(R.string.downloading_file_08);
						download_success.setText(R.string.download_success_08);
						copy_url_desc.setText(R.string.copy_url_desc_08);
						file_directory.setText(R.string.file_directory_08);
						new_update.setText(R.string.new_update_08);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_08);
						continue_1.setText(R.string.continue_1_08);
						cancel.setText(R.string.cancel_08);
						download.setText(R.string.download_08);
						later.setText(R.string.later_08);
						directory.setText(R.string.directory_08);
						install_now.setText(R.string.install_now_08);
						install_update.setText(R.string.install_update_08);
						go_back.setText(R.string.go_back_08);
						download_update.setText(R.string.download_update_08);
						not_now.setText(R.string.not_now_08);
						show_support.setText(R.string.show_support_08);
						show_support_desc.setText(R.string.show_support_desc_08);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_08);
						settings_title.setText(R.string.settings_title_08);
						about_title.setText(R.string.about_title_08);
						maintenance.setText(R.string.maintenance_08);
						maintenance_desc.setText(R.string.maintenance_desc_08);
						thanks.setText(R.string.thanks_08);
						language.setText(R.string.language_08);
					  website.setText(R.string.website_08);
					
					discord.setText(R.string.discord_08);
					COUNTER = 1;
				}
				if (_position == 9) {
					LANGUAGE.edit().putString("LANGUAGE", "9").commit();
					    title_1.setText(R.string.spotify_regular_09);
						title_2.setText(R.string.spotify_amoled_09);
						sub_text_2.setText(R.string.installed_09);
						sub_text_4.setText(R.string.installed_09);
						sub_text_1.setText(R.string.latest_09);
						sub_text_3.setText(R.string.latest_09);
						version_switch_1.setText(R.string.versions_09);
						version_switch_2.setText(R.string.versions_09);
						changelogs.setText(R.string.changelogs_09);
						title_sub.setText(R.string.manager_tools_09);
						device_cpu.setText(R.string.device_cpu_09);
						source.setText(R.string.source_09);
						support.setText(R.string.support_09);
						donate.setText(R.string.donate_09);
						about.setText(R.string.about_09);
						list_auto_refresh.setText(R.string.list_auto_refresh_09);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_09);
						force_auto_install.setText(R.string.force_auto_install_09);
						force_auto_install_info.setText(R.string.force_auto_install_desc_09);
						copy_url_mode.setText(R.string.copy_url_mode_09);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_09);
						navigation_bar.setText(R.string.hide_navigation_bar_09);
						theme.setText(R.string.show_themes_09);
						apk_location.setText(R.string.apk_location_09);
						apk_location_info.setText(R.string.apk_location_desc_09);
						clear_directory_folders.setText(R.string.clear_directory_folders_09);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_09);
						reset_settings.setText(R.string.reset_settings_09);
						sub_title.setText(R.string.about_sub_09);
						developer_manager.setText(R.string.xmanager_dev_09);
						developer_spotify.setText(R.string.spotify_mod_devs_09);
						support_team.setText(R.string.telegram_support_team_09);
						mod_testers_1.setText(R.string.manager_testers_09);
						mod_testers_2.setText(R.string.manager_hosting_09);
						mobilism_team.setText(R.string.mobilism_team_09);
						forum_team.setText(R.string.forum_team_09);
						manager_team.setText(R.string.xspotify_team_09);
						contributors_1.setText(R.string.contributors_09);
						download_selected.setText(R.string.download_selected_09);
						download_ready.setText(R.string.download_ready_09);
						download_ready_desc.setText(R.string.download_ready_desc_09);
						downloading_file.setText(R.string.downloading_file_09);
						download_success.setText(R.string.download_success_09);
						copy_url_desc.setText(R.string.copy_url_desc_09);
						file_directory.setText(R.string.file_directory_09);
						new_update.setText(R.string.new_update_09);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_09);
						continue_1.setText(R.string.continue_1_09);
						cancel.setText(R.string.cancel_09);
						download.setText(R.string.download_09);
						later.setText(R.string.later_09);
						directory.setText(R.string.directory_09);
						install_now.setText(R.string.install_now_09);
						install_update.setText(R.string.install_update_09);
						go_back.setText(R.string.go_back_09);
						download_update.setText(R.string.download_update_09);
						not_now.setText(R.string.not_now_09);
						show_support.setText(R.string.show_support_09);
						show_support_desc.setText(R.string.show_support_desc_09);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_09);
						settings_title.setText(R.string.settings_title_09);
						about_title.setText(R.string.about_title_09);
						maintenance.setText(R.string.maintenance_09);
						maintenance_desc.setText(R.string.maintenance_desc_09);
						thanks.setText(R.string.thanks_09);
						language.setText(R.string.language_09);
					  website.setText(R.string.website_09);
					
					discord.setText(R.string.discord_09);
					COUNTER = 1;
				}
				if (_position == 10) {
					LANGUAGE.edit().putString("LANGUAGE", "10").commit();
					    title_1.setText(R.string.spotify_regular_10);
						title_2.setText(R.string.spotify_amoled_10);
						sub_text_2.setText(R.string.installed_10);
						sub_text_4.setText(R.string.installed_10);
						sub_text_1.setText(R.string.latest_10);
						sub_text_3.setText(R.string.latest_10);
						version_switch_1.setText(R.string.versions_10);
						version_switch_2.setText(R.string.versions_10);
						changelogs.setText(R.string.changelogs_10);
						title_sub.setText(R.string.manager_tools_10);
						device_cpu.setText(R.string.device_cpu_10);
						source.setText(R.string.source_10);
						support.setText(R.string.support_10);
						donate.setText(R.string.donate_10);
						about.setText(R.string.about_10);
						list_auto_refresh.setText(R.string.list_auto_refresh_10);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_10);
						force_auto_install.setText(R.string.force_auto_install_10);
						force_auto_install_info.setText(R.string.force_auto_install_desc_10);
						copy_url_mode.setText(R.string.copy_url_mode_10);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_10);
						navigation_bar.setText(R.string.hide_navigation_bar_10);
						theme.setText(R.string.show_themes_10);
						apk_location.setText(R.string.apk_location_10);
						apk_location_info.setText(R.string.apk_location_desc_10);
						clear_directory_folders.setText(R.string.clear_directory_folders_10);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_10);
						reset_settings.setText(R.string.reset_settings_10);
						sub_title.setText(R.string.about_sub_10);
						developer_manager.setText(R.string.xmanager_dev_10);
						developer_spotify.setText(R.string.spotify_mod_devs_10);
						support_team.setText(R.string.telegram_support_team_10);
						mod_testers_1.setText(R.string.manager_testers_10);
						mod_testers_2.setText(R.string.manager_hosting_10);
						mobilism_team.setText(R.string.mobilism_team_10);
						forum_team.setText(R.string.forum_team_10);
						manager_team.setText(R.string.xspotify_team_10);
						contributors_1.setText(R.string.contributors_10);
						download_selected.setText(R.string.download_selected_10);
						download_ready.setText(R.string.download_ready_10);
						download_ready_desc.setText(R.string.download_ready_desc_10);
						downloading_file.setText(R.string.downloading_file_10);
						download_success.setText(R.string.download_success_10);
						copy_url_desc.setText(R.string.copy_url_desc_10);
						file_directory.setText(R.string.file_directory_10);
						new_update.setText(R.string.new_update_10);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_10);
						continue_1.setText(R.string.continue_1_10);
						cancel.setText(R.string.cancel_10);
						download.setText(R.string.download_10);
						later.setText(R.string.later_10);
						directory.setText(R.string.directory_10);
						install_now.setText(R.string.install_now_10);
						install_update.setText(R.string.install_update_10);
						go_back.setText(R.string.go_back_10);
						download_update.setText(R.string.download_update_10);
						not_now.setText(R.string.not_now_10);
						show_support.setText(R.string.show_support_10);
						show_support_desc.setText(R.string.show_support_desc_10);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_10);
						settings_title.setText(R.string.settings_title_10);
						about_title.setText(R.string.about_title_10);
						maintenance.setText(R.string.maintenance_10);
						maintenance_desc.setText(R.string.maintenance_desc_10);
						thanks.setText(R.string.thanks_10);
						language.setText(R.string.language_10);
					  website.setText(R.string.website_10);
					
					discord.setText(R.string.discord_10);
					COUNTER = 1;
				}
				if (_position == 11) {
					LANGUAGE.edit().putString("LANGUAGE", "11").commit();
					    title_1.setText(R.string.spotify_regular_11);
						title_2.setText(R.string.spotify_amoled_11);
						sub_text_2.setText(R.string.installed_11);
						sub_text_4.setText(R.string.installed_11);
						sub_text_1.setText(R.string.latest_11);
						sub_text_3.setText(R.string.latest_11);
						version_switch_1.setText(R.string.versions_11);
						version_switch_2.setText(R.string.versions_11);
						changelogs.setText(R.string.changelogs_11);
						title_sub.setText(R.string.manager_tools_11);
						device_cpu.setText(R.string.device_cpu_11);
						source.setText(R.string.source_11);
						support.setText(R.string.support_11);
						donate.setText(R.string.donate_11);
						about.setText(R.string.about_11);
						list_auto_refresh.setText(R.string.list_auto_refresh_11);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_11);
						force_auto_install.setText(R.string.force_auto_install_11);
						force_auto_install_info.setText(R.string.force_auto_install_desc_11);
						copy_url_mode.setText(R.string.copy_url_mode_11);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_11);
						navigation_bar.setText(R.string.hide_navigation_bar_11);
						theme.setText(R.string.show_themes_11);
						apk_location.setText(R.string.apk_location_11);
						apk_location_info.setText(R.string.apk_location_desc_11);
						clear_directory_folders.setText(R.string.clear_directory_folders_11);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_11);
						reset_settings.setText(R.string.reset_settings_11);
						sub_title.setText(R.string.about_sub_11);
						developer_manager.setText(R.string.xmanager_dev_11);
						developer_spotify.setText(R.string.spotify_mod_devs_11);
						support_team.setText(R.string.telegram_support_team_11);
						mod_testers_1.setText(R.string.manager_testers_11);
						mod_testers_2.setText(R.string.manager_hosting_11);
						mobilism_team.setText(R.string.mobilism_team_11);
						forum_team.setText(R.string.forum_team_11);
						manager_team.setText(R.string.xspotify_team_11);
						contributors_1.setText(R.string.contributors_11);
						download_selected.setText(R.string.download_selected_11);
						download_ready.setText(R.string.download_ready_11);
						download_ready_desc.setText(R.string.download_ready_desc_11);
						downloading_file.setText(R.string.downloading_file_11);
						download_success.setText(R.string.download_success_11);
						copy_url_desc.setText(R.string.copy_url_desc_11);
						file_directory.setText(R.string.file_directory_11);
						new_update.setText(R.string.new_update_11);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_11);
						continue_1.setText(R.string.continue_1_11);
						cancel.setText(R.string.cancel_11);
						download.setText(R.string.download_11);
						later.setText(R.string.later_11);
						directory.setText(R.string.directory_11);
						install_now.setText(R.string.install_now_11);
						install_update.setText(R.string.install_update_11);
						go_back.setText(R.string.go_back_11);
						download_update.setText(R.string.download_update_11);
						not_now.setText(R.string.not_now_11);
						show_support.setText(R.string.show_support_11);
						show_support_desc.setText(R.string.show_support_desc_11);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_11);
						settings_title.setText(R.string.settings_title_11);
						about_title.setText(R.string.about_title_11);
						maintenance.setText(R.string.maintenance_11);
						maintenance_desc.setText(R.string.maintenance_desc_11);
						thanks.setText(R.string.thanks_11);
						language.setText(R.string.language_11);
					  website.setText(R.string.website_11);
					
					discord.setText(R.string.discord_11);
					COUNTER = 1;
				}
				if (_position == 12) {
					LANGUAGE.edit().putString("LANGUAGE", "12").commit();
					    title_1.setText(R.string.spotify_regular_12);
						title_2.setText(R.string.spotify_amoled_12);
						sub_text_2.setText(R.string.installed_12);
						sub_text_4.setText(R.string.installed_12);
						sub_text_1.setText(R.string.latest_12);
						sub_text_3.setText(R.string.latest_12);
						version_switch_1.setText(R.string.versions_12);
						version_switch_2.setText(R.string.versions_12);
						changelogs.setText(R.string.changelogs_12);
						title_sub.setText(R.string.manager_tools_12);
						device_cpu.setText(R.string.device_cpu_12);
						source.setText(R.string.source_12);
						support.setText(R.string.support_12);
						donate.setText(R.string.donate_12);
						about.setText(R.string.about_12);
						list_auto_refresh.setText(R.string.list_auto_refresh_12);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_12);
						force_auto_install.setText(R.string.force_auto_install_12);
						force_auto_install_info.setText(R.string.force_auto_install_desc_12);
						copy_url_mode.setText(R.string.copy_url_mode_12);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_12);
						navigation_bar.setText(R.string.hide_navigation_bar_12);
						theme.setText(R.string.show_themes_12);
						apk_location.setText(R.string.apk_location_12);
						apk_location_info.setText(R.string.apk_location_desc_12);
						clear_directory_folders.setText(R.string.clear_directory_folders_12);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_12);
						reset_settings.setText(R.string.reset_settings_12);
						sub_title.setText(R.string.about_sub_12);
						developer_manager.setText(R.string.xmanager_dev_12);
						developer_spotify.setText(R.string.spotify_mod_devs_12);
						support_team.setText(R.string.telegram_support_team_12);
						mod_testers_1.setText(R.string.manager_testers_12);
						mod_testers_2.setText(R.string.manager_hosting_12);
						mobilism_team.setText(R.string.mobilism_team_12);
						forum_team.setText(R.string.forum_team_12);
						manager_team.setText(R.string.xspotify_team_12);
						contributors_1.setText(R.string.contributors_12);
						download_selected.setText(R.string.download_selected_12);
						download_ready.setText(R.string.download_ready_12);
						download_ready_desc.setText(R.string.download_ready_desc_12);
						downloading_file.setText(R.string.downloading_file_12);
						download_success.setText(R.string.download_success_12);
						copy_url_desc.setText(R.string.copy_url_desc_12);
						file_directory.setText(R.string.file_directory_12);
						new_update.setText(R.string.new_update_12);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_12);
						continue_1.setText(R.string.continue_1_12);
						cancel.setText(R.string.cancel_12);
						download.setText(R.string.download_12);
						later.setText(R.string.later_12);
						directory.setText(R.string.directory_12);
						install_now.setText(R.string.install_now_12);
						install_update.setText(R.string.install_update_12);
						go_back.setText(R.string.go_back_12);
						download_update.setText(R.string.download_update_12);
						not_now.setText(R.string.not_now_12);
						show_support.setText(R.string.show_support_12);
						show_support_desc.setText(R.string.show_support_desc_12);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_12);
						settings_title.setText(R.string.settings_title_12);
						about_title.setText(R.string.about_title_12);
						maintenance.setText(R.string.maintenance_12);
						maintenance_desc.setText(R.string.maintenance_desc_12);
						thanks.setText(R.string.thanks_12);
						language.setText(R.string.language_12);
					  website.setText(R.string.website_12);
					
					discord.setText(R.string.discord_12);
					COUNTER = 1;
				}
				if (_position == 13) {
					LANGUAGE.edit().putString("LANGUAGE", "13").commit();
					    title_1.setText(R.string.spotify_regular_13);
						title_2.setText(R.string.spotify_amoled_13);
						sub_text_2.setText(R.string.installed_13);
						sub_text_4.setText(R.string.installed_13);
						sub_text_1.setText(R.string.latest_13);
						sub_text_3.setText(R.string.latest_13);
						version_switch_1.setText(R.string.versions_13);
						version_switch_2.setText(R.string.versions_13);
						changelogs.setText(R.string.changelogs_13);
						title_sub.setText(R.string.manager_tools_13);
						device_cpu.setText(R.string.device_cpu_13);
						source.setText(R.string.source_13);
						support.setText(R.string.support_13);
						donate.setText(R.string.donate_13);
						about.setText(R.string.about_13);
						list_auto_refresh.setText(R.string.list_auto_refresh_13);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_13);
						force_auto_install.setText(R.string.force_auto_install_13);
						force_auto_install_info.setText(R.string.force_auto_install_desc_13);
						copy_url_mode.setText(R.string.copy_url_mode_13);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_13);
						navigation_bar.setText(R.string.hide_navigation_bar_13);
						theme.setText(R.string.show_themes_13);
						apk_location.setText(R.string.apk_location_13);
						apk_location_info.setText(R.string.apk_location_desc_13);
						clear_directory_folders.setText(R.string.clear_directory_folders_13);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_13);
						reset_settings.setText(R.string.reset_settings_13);
						sub_title.setText(R.string.about_sub_13);
						developer_manager.setText(R.string.xmanager_dev_13);
						developer_spotify.setText(R.string.spotify_mod_devs_13);
						support_team.setText(R.string.telegram_support_team_13);
						mod_testers_1.setText(R.string.manager_testers_13);
						mod_testers_2.setText(R.string.manager_hosting_13);
						mobilism_team.setText(R.string.mobilism_team_13);
						forum_team.setText(R.string.forum_team_13);
						manager_team.setText(R.string.xspotify_team_13);
						contributors_1.setText(R.string.contributors_13);
						download_selected.setText(R.string.download_selected_13);
						download_ready.setText(R.string.download_ready_13);
						download_ready_desc.setText(R.string.download_ready_desc_13);
						downloading_file.setText(R.string.downloading_file_13);
						download_success.setText(R.string.download_success_13);
						copy_url_desc.setText(R.string.copy_url_desc_13);
						file_directory.setText(R.string.file_directory_13);
						new_update.setText(R.string.new_update_13);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_13);
						continue_1.setText(R.string.continue_1_13);
						cancel.setText(R.string.cancel_13);
						download.setText(R.string.download_13);
						later.setText(R.string.later_13);
						directory.setText(R.string.directory_13);
						install_now.setText(R.string.install_now_13);
						install_update.setText(R.string.install_update_13);
						go_back.setText(R.string.go_back_13);
						download_update.setText(R.string.download_update_13);
						not_now.setText(R.string.not_now_13);
						show_support.setText(R.string.show_support_13);
						show_support_desc.setText(R.string.show_support_desc_13);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_13);
						settings_title.setText(R.string.settings_title_13);
						about_title.setText(R.string.about_title_13);
						maintenance.setText(R.string.maintenance_13);
						maintenance_desc.setText(R.string.maintenance_desc_13);
						thanks.setText(R.string.thanks_13);
						language.setText(R.string.language_13);
					  website.setText(R.string.website_13);
					
					discord.setText(R.string.discord_13);
					COUNTER = 1;
				}
				if (_position == 14) {
					LANGUAGE.edit().putString("LANGUAGE", "14").commit();
					    title_1.setText(R.string.spotify_regular_14);
						title_2.setText(R.string.spotify_amoled_14);
						sub_text_2.setText(R.string.installed_14);
						sub_text_4.setText(R.string.installed_14);
						sub_text_1.setText(R.string.latest_14);
						sub_text_3.setText(R.string.latest_14);
						version_switch_1.setText(R.string.versions_14);
						version_switch_2.setText(R.string.versions_14);
						changelogs.setText(R.string.changelogs_14);
						title_sub.setText(R.string.manager_tools_14);
						device_cpu.setText(R.string.device_cpu_14);
						source.setText(R.string.source_14);
						support.setText(R.string.support_14);
						donate.setText(R.string.donate_14);
						about.setText(R.string.about_14);
						list_auto_refresh.setText(R.string.list_auto_refresh_14);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_14);
						force_auto_install.setText(R.string.force_auto_install_14);
						force_auto_install_info.setText(R.string.force_auto_install_desc_14);
						copy_url_mode.setText(R.string.copy_url_mode_14);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_14);
						navigation_bar.setText(R.string.hide_navigation_bar_14);
						theme.setText(R.string.show_themes_14);
						apk_location.setText(R.string.apk_location_14);
						apk_location_info.setText(R.string.apk_location_desc_14);
						clear_directory_folders.setText(R.string.clear_directory_folders_14);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_14);
						reset_settings.setText(R.string.reset_settings_14);
						sub_title.setText(R.string.about_sub_14);
						developer_manager.setText(R.string.xmanager_dev_14);
						developer_spotify.setText(R.string.spotify_mod_devs_14);
						support_team.setText(R.string.telegram_support_team_14);
						mod_testers_1.setText(R.string.manager_testers_14);
						mod_testers_2.setText(R.string.manager_hosting_14);
						mobilism_team.setText(R.string.mobilism_team_14);
						forum_team.setText(R.string.forum_team_14);
						manager_team.setText(R.string.xspotify_team_14);
						contributors_1.setText(R.string.contributors_14);
						download_selected.setText(R.string.download_selected_14);
						download_ready.setText(R.string.download_ready_14);
						download_ready_desc.setText(R.string.download_ready_desc_14);
						downloading_file.setText(R.string.downloading_file_14);
						download_success.setText(R.string.download_success_14);
						copy_url_desc.setText(R.string.copy_url_desc_14);
						file_directory.setText(R.string.file_directory_14);
						new_update.setText(R.string.new_update_14);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_14);
						continue_1.setText(R.string.continue_1_14);
						cancel.setText(R.string.cancel_14);
						download.setText(R.string.download_14);
						later.setText(R.string.later_14);
						directory.setText(R.string.directory_14);
						install_now.setText(R.string.install_now_14);
						install_update.setText(R.string.install_update_14);
						go_back.setText(R.string.go_back_14);
						download_update.setText(R.string.download_update_14);
						not_now.setText(R.string.not_now_14);
						show_support.setText(R.string.show_support_14);
						show_support_desc.setText(R.string.show_support_desc_14);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_14);
						settings_title.setText(R.string.settings_title_14);
						about_title.setText(R.string.about_title_14);
						maintenance.setText(R.string.maintenance_14);
						maintenance_desc.setText(R.string.maintenance_desc_14);
						thanks.setText(R.string.thanks_14);
						language.setText(R.string.language_14);
					  website.setText(R.string.website_14);
					
					discord.setText(R.string.discord_14);
					COUNTER = 1;
				}
				if (_position == 15) {
					LANGUAGE.edit().putString("LANGUAGE", "15").commit();
					    title_1.setText(R.string.spotify_regular_15);
						title_2.setText(R.string.spotify_amoled_15);
						sub_text_2.setText(R.string.installed_15);
						sub_text_4.setText(R.string.installed_15);
						sub_text_1.setText(R.string.latest_15);
						sub_text_3.setText(R.string.latest_15);
						version_switch_1.setText(R.string.versions_15);
						version_switch_2.setText(R.string.versions_15);
						changelogs.setText(R.string.changelogs_15);
						title_sub.setText(R.string.manager_tools_15);
						device_cpu.setText(R.string.device_cpu_15);
						source.setText(R.string.source_15);
						support.setText(R.string.support_15);
						donate.setText(R.string.donate_15);
						about.setText(R.string.about_15);
						list_auto_refresh.setText(R.string.list_auto_refresh_15);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_15);
						force_auto_install.setText(R.string.force_auto_install_15);
						force_auto_install_info.setText(R.string.force_auto_install_desc_15);
						copy_url_mode.setText(R.string.copy_url_mode_15);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_15);
						navigation_bar.setText(R.string.hide_navigation_bar_15);
						theme.setText(R.string.show_themes_15);
						apk_location.setText(R.string.apk_location_15);
						apk_location_info.setText(R.string.apk_location_desc_15);
						clear_directory_folders.setText(R.string.clear_directory_folders_15);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_15);
						reset_settings.setText(R.string.reset_settings_15);
						sub_title.setText(R.string.about_sub_15);
						developer_manager.setText(R.string.xmanager_dev_15);
						developer_spotify.setText(R.string.spotify_mod_devs_15);
						support_team.setText(R.string.telegram_support_team_15);
						mod_testers_1.setText(R.string.manager_testers_15);
						mod_testers_2.setText(R.string.manager_hosting_15);
						mobilism_team.setText(R.string.mobilism_team_15);
						forum_team.setText(R.string.forum_team_15);
						manager_team.setText(R.string.xspotify_team_15);
						contributors_1.setText(R.string.contributors_15);
						download_selected.setText(R.string.download_selected_15);
						download_ready.setText(R.string.download_ready_15);
						download_ready_desc.setText(R.string.download_ready_desc_15);
						downloading_file.setText(R.string.downloading_file_15);
						download_success.setText(R.string.download_success_15);
						copy_url_desc.setText(R.string.copy_url_desc_15);
						file_directory.setText(R.string.file_directory_15);
						new_update.setText(R.string.new_update_15);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_15);
						continue_1.setText(R.string.continue_1_15);
						cancel.setText(R.string.cancel_15);
						download.setText(R.string.download_15);
						later.setText(R.string.later_15);
						directory.setText(R.string.directory_15);
						install_now.setText(R.string.install_now_15);
						install_update.setText(R.string.install_update_15);
						go_back.setText(R.string.go_back_15);
						download_update.setText(R.string.download_update_15);
						not_now.setText(R.string.not_now_15);
						show_support.setText(R.string.show_support_15);
						show_support_desc.setText(R.string.show_support_desc_15);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_15);
						settings_title.setText(R.string.settings_title_15);
						about_title.setText(R.string.about_title_15);
						maintenance.setText(R.string.maintenance_15);
						maintenance_desc.setText(R.string.maintenance_desc_15);
						thanks.setText(R.string.thanks_15);
						language.setText(R.string.language_15);
					  website.setText(R.string.website_15);
					
					discord.setText(R.string.discord_15);
					COUNTER = 1;
				}
				if (_position == 16) {
					LANGUAGE.edit().putString("LANGUAGE", "16").commit();
					    title_1.setText(R.string.spotify_regular_16);
						title_2.setText(R.string.spotify_amoled_16);
						sub_text_2.setText(R.string.installed_16);
						sub_text_4.setText(R.string.installed_16);
						sub_text_1.setText(R.string.latest_16);
						sub_text_3.setText(R.string.latest_16);
						version_switch_1.setText(R.string.versions_16);
						version_switch_2.setText(R.string.versions_16);
						changelogs.setText(R.string.changelogs_16);
						title_sub.setText(R.string.manager_tools_16);
						device_cpu.setText(R.string.device_cpu_16);
						source.setText(R.string.source_16);
						support.setText(R.string.support_16);
						donate.setText(R.string.donate_16);
						about.setText(R.string.about_16);
						list_auto_refresh.setText(R.string.list_auto_refresh_16);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_16);
						force_auto_install.setText(R.string.force_auto_install_16);
						force_auto_install_info.setText(R.string.force_auto_install_desc_16);
						copy_url_mode.setText(R.string.copy_url_mode_16);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_16);
						navigation_bar.setText(R.string.hide_navigation_bar_16);
						theme.setText(R.string.show_themes_16);
						apk_location.setText(R.string.apk_location_16);
						apk_location_info.setText(R.string.apk_location_desc_16);
						clear_directory_folders.setText(R.string.clear_directory_folders_16);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_16);
						reset_settings.setText(R.string.reset_settings_16);
						sub_title.setText(R.string.about_sub_16);
						developer_manager.setText(R.string.xmanager_dev_16);
						developer_spotify.setText(R.string.spotify_mod_devs_16);
						support_team.setText(R.string.telegram_support_team_16);
						mod_testers_1.setText(R.string.manager_testers_16);
						mod_testers_2.setText(R.string.manager_hosting_16);
						mobilism_team.setText(R.string.mobilism_team_16);
						forum_team.setText(R.string.forum_team_16);
						manager_team.setText(R.string.xspotify_team_16);
						contributors_1.setText(R.string.contributors_16);
						download_selected.setText(R.string.download_selected_16);
						download_ready.setText(R.string.download_ready_16);
						download_ready_desc.setText(R.string.download_ready_desc_16);
						downloading_file.setText(R.string.downloading_file_16);
						download_success.setText(R.string.download_success_16);
						copy_url_desc.setText(R.string.copy_url_desc_16);
						file_directory.setText(R.string.file_directory_16);
						new_update.setText(R.string.new_update_16);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_16);
						continue_1.setText(R.string.continue_1_16);
						cancel.setText(R.string.cancel_16);
						download.setText(R.string.download_16);
						later.setText(R.string.later_16);
						directory.setText(R.string.directory_16);
						install_now.setText(R.string.install_now_16);
						install_update.setText(R.string.install_update_16);
						go_back.setText(R.string.go_back_16);
						download_update.setText(R.string.download_update_16);
						not_now.setText(R.string.not_now_16);
						show_support.setText(R.string.show_support_16);
						show_support_desc.setText(R.string.show_support_desc_16);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_16);
						settings_title.setText(R.string.settings_title_16);
						about_title.setText(R.string.about_title_16);
						maintenance.setText(R.string.maintenance_16);
						maintenance_desc.setText(R.string.maintenance_desc_16);
						thanks.setText(R.string.thanks_16);
						language.setText(R.string.language_16);
					  website.setText(R.string.website_16);
					
					discord.setText(R.string.discord_16);
					COUNTER = 1;
				}
				if (_position == 17) {
					LANGUAGE.edit().putString("LANGUAGE", "17").commit();
					    title_1.setText(R.string.spotify_regular_17);
						title_2.setText(R.string.spotify_amoled_17);
						sub_text_2.setText(R.string.installed_17);
						sub_text_4.setText(R.string.installed_17);
						sub_text_1.setText(R.string.latest_17);
						sub_text_3.setText(R.string.latest_17);
						version_switch_1.setText(R.string.versions_17);
						version_switch_2.setText(R.string.versions_17);
						changelogs.setText(R.string.changelogs_17);
						title_sub.setText(R.string.manager_tools_17);
						device_cpu.setText(R.string.device_cpu_17);
						source.setText(R.string.source_17);
						support.setText(R.string.support_17);
						donate.setText(R.string.donate_17);
						about.setText(R.string.about_17);
						list_auto_refresh.setText(R.string.list_auto_refresh_17);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_17);
						force_auto_install.setText(R.string.force_auto_install_17);
						force_auto_install_info.setText(R.string.force_auto_install_desc_17);
						copy_url_mode.setText(R.string.copy_url_mode_17);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_17);
						navigation_bar.setText(R.string.hide_navigation_bar_17);
						theme.setText(R.string.show_themes_17);
						apk_location.setText(R.string.apk_location_17);
						apk_location_info.setText(R.string.apk_location_desc_17);
						clear_directory_folders.setText(R.string.clear_directory_folders_17);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_17);
						reset_settings.setText(R.string.reset_settings_17);
						sub_title.setText(R.string.about_sub_17);
						developer_manager.setText(R.string.xmanager_dev_17);
						developer_spotify.setText(R.string.spotify_mod_devs_17);
						support_team.setText(R.string.telegram_support_team_17);
						mod_testers_1.setText(R.string.manager_testers_17);
						mod_testers_2.setText(R.string.manager_hosting_17);
						mobilism_team.setText(R.string.mobilism_team_17);
						forum_team.setText(R.string.forum_team_17);
						manager_team.setText(R.string.xspotify_team_17);
						contributors_1.setText(R.string.contributors_17);
						download_selected.setText(R.string.download_selected_17);
						download_ready.setText(R.string.download_ready_17);
						download_ready_desc.setText(R.string.download_ready_desc_17);
						downloading_file.setText(R.string.downloading_file_17);
						download_success.setText(R.string.download_success_17);
						copy_url_desc.setText(R.string.copy_url_desc_17);
						file_directory.setText(R.string.file_directory_17);
						new_update.setText(R.string.new_update_17);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_17);
						continue_1.setText(R.string.continue_1_17);
						cancel.setText(R.string.cancel_17);
						download.setText(R.string.download_17);
						later.setText(R.string.later_17);
						directory.setText(R.string.directory_17);
						install_now.setText(R.string.install_now_17);
						install_update.setText(R.string.install_update_17);
						go_back.setText(R.string.go_back_17);
						download_update.setText(R.string.download_update_17);
						not_now.setText(R.string.not_now_17);
						show_support.setText(R.string.show_support_17);
						show_support_desc.setText(R.string.show_support_desc_17);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_17);
						settings_title.setText(R.string.settings_title_17);
						about_title.setText(R.string.about_title_17);
						maintenance.setText(R.string.maintenance_17);
						maintenance_desc.setText(R.string.maintenance_desc_17);
						thanks.setText(R.string.thanks_17);
						language.setText(R.string.language_17);
					    website.setText(R.string.website_17);
					    discord.setText(R.string.discord_17);
					COUNTER = 1;
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		apk_path_location.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				PATH = _charSeq;
				_Default_Path();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		box_reset_settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				version_switch_01.setChecked(false);
				version_switch_02.setChecked(false);
				changelogs_switch.setChecked(false);
				list_auto_refresh_switch.setChecked(false);
				force_auto_install_switch.setChecked(false);
				copy_url_mode_switch.setChecked(false);
				navigation_switch.setChecked(false);
				apk_path_location.setText("/storage/emulated/0/xManager/");
				
				
				
				    title_1.setText(R.string.spotify_regular);
					title_2.setText(R.string.spotify_amoled);
					sub_text_2.setText(R.string.installed);
					sub_text_4.setText(R.string.installed);
					sub_text_1.setText(R.string.latest);
					sub_text_3.setText(R.string.latest);
					version_switch_1.setText(R.string.versions);
					version_switch_2.setText(R.string.versions);
					changelogs.setText(R.string.changelogs);
					title_sub.setText(R.string.manager_tools);
					device_cpu.setText(R.string.device_cpu);
					source.setText(R.string.source);
					support.setText(R.string.support);
					donate.setText(R.string.donate);
					about.setText(R.string.about);
					list_auto_refresh.setText(R.string.list_auto_refresh);
					list_auto_refresh_info.setText(R.string.list_auto_refresh_desc);
					force_auto_install.setText(R.string.force_auto_install);
					force_auto_install_info.setText(R.string.force_auto_install_desc);
					copy_url_mode.setText(R.string.copy_url_mode);
					copy_file_url_mode_info.setText(R.string.copy_url_mode_desc);
					navigation_bar.setText(R.string.hide_navigation_bar);
					theme.setText(R.string.show_themes);
					apk_location.setText(R.string.apk_location);
					apk_location_info.setText(R.string.apk_location_desc);
					clear_directory_folders.setText(R.string.clear_directory_folders);
					clear_directory_folders_info.setText(R.string.clear_directory_folders_desc);
					reset_settings.setText(R.string.reset_settings);
					sub_title.setText(R.string.about_sub);
					developer_manager.setText(R.string.xmanager_dev);
					developer_spotify.setText(R.string.spotify_mod_devs);
					support_team.setText(R.string.telegram_support_team);
					mod_testers_1.setText(R.string.manager_testers);
					mod_testers_2.setText(R.string.manager_hosting);
					mobilism_team.setText(R.string.mobilism_team);
					forum_team.setText(R.string.forum_team);
					manager_team.setText(R.string.xspotify_team);
					contributors_1.setText(R.string.contributors);
					download_selected.setText(R.string.download_selected);
					download_ready.setText(R.string.download_ready);
					download_ready_desc.setText(R.string.download_ready_desc);
					downloading_file.setText(R.string.downloading_file);
					download_success.setText(R.string.download_success);
					copy_url_desc.setText(R.string.copy_url_desc);
					file_directory.setText(R.string.file_directory);
					new_update.setText(R.string.new_update);
					download_selected_0 = download_selected.getText().toString();
					download_ready_0 = download_ready.getText().toString();
					download_ready_desc_0 = download_ready_desc.getText().toString();
					downloading_file_0 = downloading_file.getText().toString();
					download_success_0 = download_success.getText().toString();
					copy_url_desc_0 = copy_url_desc.getText().toString();
					file_directory_0 = file_directory.getText().toString();
					copy_url.setText(R.string.copy_url);
					continue_1.setText(R.string.continue_1);
					cancel.setText(R.string.cancel);
					download.setText(R.string.download);
					later.setText(R.string.later);
					directory.setText(R.string.directory);
					install_now.setText(R.string.install_now);
					install_update.setText(R.string.install_update);
					go_back.setText(R.string.go_back);
					download_update.setText(R.string.download_update);
					not_now.setText(R.string.not_now);
					show_support.setText(R.string.show_support);
					show_support_desc.setText(R.string.show_support_desc);
					copy_url_0 = copy_url.getText().toString();
					download_0 = download.getText().toString();
					continue_0 = continue_1.getText().toString();
					cancel_0 = cancel.getText().toString();
					later_0 = later.getText().toString();
					directory_0 = directory.getText().toString();
					install_now_0 = install_now.getText().toString();
					go_back_0 = go_back.getText().toString();
					install_update_0 = install_update.getText().toString();
					main_title.setText(R.string.main_title);
					settings_title.setText(R.string.settings_title);
					about_title.setText(R.string.about_title);
					maintenance.setText(R.string.maintenance);
					maintenance_desc.setText(R.string.maintenance_desc);
					thanks.setText(R.string.thanks);
					language.setText(R.string.language);
				  website.setText(R.string.website);
				
				discord.setText(R.string.discord);
				select_language.setSelection((int)(0));
				select_theme.setSelection((int)(0));
				if (COUNTER == 1) {
					
				}
				COUNTER = 0;
			}
		});
		
		box_icon_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				RippleAnimation.create(box_icon_close).setDuration((long)700).start();
				main_body_optimization.setVisibility(View.GONE);
				main_scroll_settings.setVisibility(View.GONE);
				main_scroll_about.setVisibility(View.GONE);
				main_refresh_layout.setVisibility(View.VISIBLE);
				box_update.setVisibility(View.VISIBLE);
				box_switch.setVisibility(View.VISIBLE);
				title_header.setText(main_title.getText().toString());
				title_header_beta.setVisibility(View.VISIBLE);
				Animation header_beta;
				header_beta = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
				header_beta.setDuration(200); title_header_beta.startAnimation(header_beta);
				header_beta = null;
				CLOSER_1 = 0;
				_Animation_0();
				_Url_Mode();
			}
		});
		
		version_switch_01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				try {
					if (_isChecked) {
						try {
							version_switch_02.setChecked(false);
							changelogs_switch.setChecked(false);
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
									sub_1.setText(VERSIONS.getString("REGULAR", ""));
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
						}
						catch(Exception e) {
							SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Fetching failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
						}
						main_refresh_layout.setEnabled(false);
						if (true) {
							com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "Slow or No Internet Connection. Try again later.", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
											@Override
											public void onClick(View _view) {
											}
									}).show();
						}
						_Switches();
					}
					else {
						main_refresh_layout.setEnabled(true);
						list_menu_1.setVisibility(View.GONE);
						list_menu_1.setAdapter(new List_menu_1Adapter(listdata));
						((BaseAdapter)list_menu_1.getAdapter()).notifyDataSetChanged();
					}
				}
				catch(Exception e) {
				}
			}
		});
		
		version_switch_02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				try {
					if (_isChecked) {
						try {
							version_switch_01.setChecked(false);
							changelogs_switch.setChecked(false);
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
									sub_3.setText(VERSIONS.getString("AMOLED", ""));
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
						}
						catch(Exception e) {
							SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Fetching failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
						}
						main_refresh_layout.setEnabled(false);
						if (true) {
							com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "Slow or No Internet Connection. Try again later.", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
											@Override
											public void onClick(View _view) {
											}
									}).show();
						}
						_Switches();
					}
					else {
						main_refresh_layout.setEnabled(true);
						list_menu_2.setVisibility(View.GONE);
						list_menu_2.setAdapter(new List_menu_2Adapter(listdata));
						((BaseAdapter)list_menu_2.getAdapter()).notifyDataSetChanged();
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
				try {
					if (_isChecked) {
						try {
							box_6_sub_2.setVisibility(View.VISIBLE);
							version_switch_01.setChecked(false);
							version_switch_02.setChecked(false);
							if (true) {
								com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "Slow or No Internet Connection. Try again later.", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
												@Override
												public void onClick(View _view) {
												}
										}).show();
							}
							main_refresh_layout.setEnabled(false);
							_Switches();
						}
						catch(Exception e) {
							SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Fetching failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
						}
					}
					else {
						box_6_sub_2.setVisibility(View.GONE);
						main_refresh_layout.setEnabled(true);
					}
					Animation changelogs;
					changelogs = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
					changelogs.setDuration(200); box_changelogs_1.startAnimation(changelogs);
					changelogs = null;
				}
				catch(Exception e) {
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
						_timer.schedule(Timer, (int)(2000));
						if (FileUtil.isExistFile("/storage/emulated/0/Android/data/com.spotify.music/")) {
							FileUtil.deleteFile("/storage/emulated/0/Android/data/com.spotify.music/");
							
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
					Donation.setTitle(show_support.getText().toString());
					Donation.setMessage(show_support_desc.getText().toString());
					Donation.setPositiveButton(donate.getText().toString(), new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							_RequiredDialog(Donation, true);
							Donate.setAction(Intent.ACTION_VIEW);
							Donate.setData(Uri.parse("https://www.paypal.me/mrvnce"));
							startActivity(Donate);
						}
					});
					Donation.setNeutralButton(not_now.getText().toString(), new DialogInterface.OnClickListener() {
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
				RippleAnimation.create(box_about).setDuration((long)700).start();
				main_body_optimization.setVisibility(View.GONE);
				main_scroll_settings.setVisibility(View.GONE);
				main_scroll_about.setVisibility(View.VISIBLE);
				main_refresh_layout.setVisibility(View.GONE);
				box_update.setVisibility(View.GONE);
				box_switch.setVisibility(View.GONE);
				title_header.setText(about_title.getText().toString());
				title_header_beta.setVisibility(View.GONE);
				CLOSER_1 = 1;
				_Animation_2();
			}
		});
		
		box_discord.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					Support.setAction(Intent.ACTION_VIEW);
					Support.setData(Uri.parse("https://discord.gg/sZWsVvC3pu"));
					startActivity(Support);
				}
				catch(Exception e) {
				}
			}
		});
		
		box_website.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					Source.setAction(Intent.ACTION_VIEW);
					Source.setData(Uri.parse("https://xmanager-v2.github.io/"));
					startActivity(Source);
				}
				catch(Exception e) {
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
						
						sub_1.setText(VERSIONS_REGULAR);
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
						
						sub_3.setText(VERSIONS_AMOLED);
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
				com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "Slow or No Internet Connection. Try again later.", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
								}
						}).show();
				
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
				xManager_Update.addListenerForSingleValueEvent(new ValueEventListener() {
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
						try {
							hidden_download.setText(_childValue.get("Links").toString());
						}
						catch(Exception e) {
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
						try {
							changelogs_x.setText(_childValue.get("Changelogs").toString());
						}
						catch(Exception e) {
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		
		xManager_Notification_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.getResult().getToken();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				try {
				}
				catch(Exception e) {
					SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Failed to receive notification", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
				}
			}
		};
		
		_xManager_Changelogs_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
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
						try {
							app_changelogs.setText(_childValue.get("App_Changelogs").toString());
						}
						catch(Exception e) {
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
						try {
							listdata.add(_childValue);
							sub_1.setText(_childKey.replace("-", ".").replace("Spotify v", " ").replace("(Armeabi.v7a)", " ").replace("(Arm64.v8a)", " "));
							VERSIONS.edit().putString("REGULAR", _childKey.replace("-", ".").replace("Spotify v", " ").replace("(Armeabi.v7a)", "").replace("(Arm64.v8a)", "")).commit();
							list_menu_1.setAdapter(new List_menu_1Adapter(listdata));
							((BaseAdapter)list_menu_1.getAdapter()).notifyDataSetChanged();
						}
						catch(Exception e) {
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
				try {
					Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName() ); 
					
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
					startActivity(intent);
				}
				catch(Exception e) {
				}
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
						try {
							listdata.add(_childValue);
							sub_3.setText(_childKey.replace("-", ".").replace("Spotify v", " ").replace("(Armeabi.v7a)", " ").replace("(Arm64.v8a)", " "));
							VERSIONS.edit().putString("AMOLED", _childKey.replace("-", ".").replace("Spotify v", " ").replace("(Armeabi.v7a)", "").replace("(Arm64.v8a)", "")).commit();
							list_menu_2.setAdapter(new List_menu_2Adapter(listdata));
							((BaseAdapter)list_menu_2.getAdapter()).notifyDataSetChanged();
						}
						catch(Exception e) {
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
				try {
					Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName() ); 
					
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
					startActivity(intent);
				}
				catch(Exception e) {
				}
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
			_Dark_Navigation();
			_Language_Pack();
			_Theme_Pack();
			_Informations();
			_Animation_0();
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
		try {
			if (CLOSER_1 == 1) {
				CHECK = 0;
				
			}
			else {
				if (CLOSER_2 == 1) {
					CHECK = 0;
					
				}
			}
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
				_timer.schedule(Timer, (int)(3000));
				
			}
			else {
				finishAndRemoveTask();
				finishAffinity();
			}
		}
		catch(Exception e) {
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
							SketchwareUtil.CustomToast(getApplicationContext(), "Spotify not installed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
						}
						cpu.setText(Build.CPU_ABI);
						cpu.setText(cpu.getText().toString().toUpperCase());
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
				
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
				
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
				prog.setTitle(downloading_file_0);
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
											
											prog.setTitle(downloading_file_0);
											prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
											prog.setProgress(bytes_downloaded);
											prog.setMax(bytes_total);
											prog.setButton(DialogInterface.BUTTON_NEGATIVE, cancel_0, new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface dialog, int which) {
													SketchwareUtil.CustomToast(getApplicationContext(), "Download cancelled", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
													manager.remove(downloadId);
													Timer = new TimerTask() {
																@Override
																public void run() {
																		runOnUiThread(new Runnable() {
																				@Override
																				public void run() {
																						prog.cancel();
																				}
																		});
																}
														};
														_timer.schedule(Timer, (int)(0));
												}
											});
											prog.show();
											
											if (bytes_downloaded == bytes_total) {
												
												Timer = new TimerTask() {
														@Override
														public void run() {
																runOnUiThread(new Runnable() {
																		@Override
																		public void run() {
																
																try {
																	FileUtil.copyFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk", apk_path_location.getText().toString().concat("Spotify Mod (Official).apk"));
																}
																catch(Exception e) {
																	SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Copying failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																}
																
																_RequiredDialog(Success_Download, false);
																Success_Download.setTitle(download_success_0);
																Success_Download.setPositiveButton(install_now_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
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
																Success_Download.setNegativeButton(directory_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
																				_RequiredDialog(Directory, false);
																				Directory.setTitle(file_directory_0);
																				Directory.setMessage("<".concat(apk_path_location.getText().toString().concat(">")));
																				Directory.setPositiveButton(go_back_0, new DialogInterface.OnClickListener() {
																						@Override
																						public void onClick(DialogInterface _dialog, int _which) {
																								_RequiredDialog(Directory, true);
																								_RequiredDialog(Success_Download, false);
																								Success_Download.create().show();
																						}
																				});
																				Directory.create().show();
																		
																	}
																});
																Success_Download.setNeutralButton(later_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
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
																
																prog.cancel();
																
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
				com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "No Internet Connection", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
								}
						}).show();
			}
		}
		catch(Exception e) {
		}
	}
	
	
	private void _File_Remover () {
		if (FileUtil.isExistFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk")) {
			FileUtil.deleteFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk");
		}
		if (FileUtil.isExistFile(apk_path_location.getText().toString().concat("Spotify Mod (Official).apk"))) {
			FileUtil.deleteFile(apk_path_location.getText().toString().concat("Spotify Mod (Official).apk"));
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
		sub_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_text_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_text_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_text_3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_text_4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		title_sub.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		device_cpu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		cpu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		support.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		donate.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		about.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		source.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		website.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		discord.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		version_switch_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		version_switch_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		theme.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		title_about.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		developer_manager.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		developer_spotify.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		support_team.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		mod_testers_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		mod_testers_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		mobilism_team.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		forum_team.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_team.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		developer_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		developer_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		support_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		testers_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		testers_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		mobilism_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		forum_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		contributors_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		changelogs.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		changelogs_x.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		sub_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		app_version.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		navigation_bar.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		list_auto_refresh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		list_auto_refresh_info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		apk_location_info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		apk_location.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		reset_settings.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		clear_directory_folders.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		force_auto_install.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		force_auto_install_info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		copy_url_mode.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		copy_file_url_mode_info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		clear_directory_folders_info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		language.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		regular_info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 2);
		amoled_info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 2);
		title_header_beta.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 3);
		manager_lang_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		manager_lang_16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_7_1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		translator_16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
		
		
		
		
		
		
		
		
		
		
		
		
		list_menu_1.setVisibility(View.GONE);
		list_menu_2.setVisibility(View.GONE);
		box_6_sub_2.setVisibility(View.GONE);
		list_menu_1.smoothScrollToPosition((int)(0));
		list_menu_2.smoothScrollToPosition((int)(0));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if (!ON_SCREEN.getString("ON_SCREEN", "").equals("ON_SCREEN")) {
			try {
				box_header.setVisibility(View.GONE);
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
												box_header.setVisibility(View.VISIBLE);
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
						
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										sub_1.setText(VERSIONS.getString("REGULAR", ""));
										list_menu_1.smoothScrollToPosition((int)(999));
										version_switch_01.setChecked(true);
										version_switch_02.setChecked(false);
										changelogs_switch.setChecked(false);
										main_body.setAlpha((float)(0.65d));
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(300));
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
						
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										sub_3.setText(VERSIONS.getString("AMOLED", ""));
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(300));
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										list_menu_2.smoothScrollToPosition((int)(999));
										version_switch_01.setChecked(false);
										version_switch_02.setChecked(true);
										changelogs_switch.setChecked(false);
										main_body.setAlpha((float)(0.65d));
										Timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														version_switch_01.setChecked(false);
														version_switch_02.setChecked(false);
														changelogs_switch.setChecked(true);
														main_body.setAlpha((float)(0.65d));
														Timer = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		
																		version_switch_01.setChecked(false);
																		version_switch_02.setChecked(false);
																		changelogs_switch.setChecked(false);
																		main_body.setEnabled(true);
																		main_body.setAlpha((float)(1.0d));
																	}
																});
															}
														};
														_timer.schedule(Timer, (int)(900));
													}
												});
											}
										};
										_timer.schedule(Timer, (int)(800));
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
				main_body_optimization.setVisibility(View.VISIBLE);
				main_scroll_settings.setVisibility(View.GONE);
				main_scroll_about.setVisibility(View.GONE);
				main_refresh_layout.setVisibility(View.GONE);
				box_switch.setVisibility(View.GONE);
				box_update.setVisibility(View.GONE);
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
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										
										sub_1.setText(VERSIONS.getString("REGULAR", ""));
										list_menu_1.setAdapter(new List_menu_1Adapter(listdata));
										((BaseAdapter)list_menu_1.getAdapter()).notifyDataSetChanged();
										main_body.setEnabled(false);
										main_body.setAlpha((float)(0.65d));
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(300));
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
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										sub_3.setText(VERSIONS.getString("AMOLED", ""));
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(300));
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
				main_scroll_settings.setVisibility(View.GONE);
				main_scroll_about.setVisibility(View.GONE);
				main_refresh_layout.setVisibility(View.VISIBLE);
				box_update.setVisibility(View.VISIBLE);
				box_switch.setVisibility(View.VISIBLE);
				icon_update.setAlpha((float)(1.0d));
				icon_switch.setAlpha((float)(1.0d));
				_Updater();
			}
			catch(Exception e) {
			}
		}
		
		apk_path_location.setText(APK_PATH.getString("PATH", ""));
		
		CHECK = 0;
		_Update_Remover();
		_Updater_Check();
		_Switch_Fixer();
		_Animation_5();
		_List_Updater();
		_Language_UI();
		_Theme_UI();
		_Effects();
		_Url_Mode();
	}
	
	
	private void _Theme_UI () {
		if (THEME.getString("THEME", "").equals("0")) {
			
			
			
			select_theme.setSelection((int)(0));
		}
		else {
			if (THEME.getString("THEME", "").equals("1")) {
				
				
				
				select_theme.setSelection((int)(1));
			}
			else {
				if (THEME.getString("THEME", "").equals("2")) {
					
					
					
					select_theme.setSelection((int)(2));
				}
				else {
					if (THEME.getString("THEME", "").equals("3")) {
						
						
						
						select_theme.setSelection((int)(3));
					}
					else {
						if (THEME.getString("THEME", "").equals("4")) {
							
							
							
							select_theme.setSelection((int)(4));
						}
						else {
							if (THEME.getString("THEME", "").equals("5")) {
								
								
								
								select_theme.setSelection((int)(5));
							}
							else {
								if (THEME.getString("THEME", "").equals("6")) {
									
									
									
									select_theme.setSelection((int)(6));
								}
								else {
									if (THEME.getString("THEME", "").equals("7")) {
										
										
										
										select_theme.setSelection((int)(7));
									}
									else {
										if (THEME.getString("THEME", "").equals("8")) {
											
											
											
											select_theme.setSelection((int)(8));
										}
										else {
											if (THEME.getString("THEME", "").equals("9")) {
												
												
												
												select_theme.setSelection((int)(9));
											}
											else {
												if (THEME.getString("THEME", "").equals("10")) {
													
													
													
													select_theme.setSelection((int)(10));
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
						_RequiredDialog(Update_Authorized, false);
						Update_Authorized.setTitle("NEW MANAGER UPDATE");
						Update_Authorized.setPositiveButton("DOWNLOAD UPDATE", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								try {
									_RequiredDialog(Update_Authorized, true);
									if (FORCE_INSTALL_UPDATE.getString("FORCE_INSTALL_UPDATE", "").equals("XX")) {
										_Download_Update_Install(hidden_download.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/");
									}
									else {
										if (FORCE_INSTALL_UPDATE.getString("FORCE_INSTALL_UPDATE", "").equals("YY")) {
											_Download_Update(hidden_download.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Update/");
										}
									}
									_Update_Remover();
								}
								catch(Exception e) {
								}
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
					else {
						if (Double.parseDouble(Current_Version) > Double.parseDouble(Latest_Version)) {
							try {
								main_body_optimization.setVisibility(View.VISIBLE);
								box_header.setVisibility(View.GONE);
								main_body_settings.setVisibility(View.GONE);
								main_scroll_about.setVisibility(View.GONE);
								main_refresh_layout.setVisibility(View.GONE);
								_RequiredDialog(Update_Unauthorized, false);
								Update_Unauthorized.setTitle(maintenance.getText().toString());
								Update_Unauthorized.setMessage(maintenance_desc.getText().toString());
								Update_Unauthorized.setPositiveButton(thanks.getText().toString(), new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										_RequiredDialog(Update_Unauthorized, true);
										finishAndRemoveTask();
										finishAffinity();
									}
								});
								Update_Unauthorized.create().show();
							}
							catch(Exception e) {
							}
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
				
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
				
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
				prog.setTitle(downloading_file_0);
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
											
											prog.setTitle(downloading_file_0);
											prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
											prog.setProgress(bytes_downloaded);
											prog.setMax(bytes_total);
											prog.setButton(DialogInterface.BUTTON_NEGATIVE, cancel_0, new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface dialog, int which) {
													SketchwareUtil.CustomToast(getApplicationContext(), "Download cancelled", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
													manager.remove(downloadId);
													Timer = new TimerTask() {
																@Override
																public void run() {
																		runOnUiThread(new Runnable() {
																				@Override
																				public void run() {
																						prog.cancel();
																				}
																		});
																}
														};
														_timer.schedule(Timer, (int)(0));
												}
											});
											prog.show();
											
											if (bytes_downloaded == bytes_total) {
												
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
																Success_Download.setTitle(download_success_0);
																Success_Download.setPositiveButton(install_update_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
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
																Success_Download.setNegativeButton(directory_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
																				_RequiredDialog(Directory, false);
																				Directory.setTitle(file_directory_0);
																		    Directory.setMessage("</storage/emulated/0/xManager/Update/>");
																				Directory.setPositiveButton(go_back_0, new DialogInterface.OnClickListener() {
																						@Override
																						public void onClick(DialogInterface _dialog, int _which) {
																								_RequiredDialog(Directory, true);
																								_RequiredDialog(Success_Download, false);
																								Success_Download.create().show();
																						}
																				});
																				Directory.create().show();
																		
																	}
																});
																Success_Download.setNeutralButton(later_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
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
																
																prog.cancel();
																
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
				com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "No Internet Connection", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
								}
						}).show();
			}
		}
		catch(Exception e) {
		}
	}
	
	
	private void _Effects () {
		_Ripple(box_update, "#9E9E9E");
		_Ripple(box_switch, "#9E9E9E");
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
			if (NAVIGATION_BAR.getString("NAVIGATION", "").equals("1")) {
				getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
				navigation_switch.setChecked(true);
			}
			else {
				if (NAVIGATION_BAR.getString("NAVIGATION", "").equals("0")) {
					getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
					
					if (Build.VERSION.SDK_INT >= 21) {
						getWindow().setNavigationBarColor(Color.parseColor("#212121"));
					}
					navigation_switch.setChecked(false);
				}
			}
		}
		catch(Exception e) {
		}
	}
	
	
	private void _Animation_0 () {
		Animation a;
		a = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		a.setDuration(200); main_box_1.startAnimation(a);
		a = null;
		Animation b;
		b = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		b.setDuration(300); main_box_2.startAnimation(b);
		b = null;
		Animation c;
		c = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		c.setDuration(400); main_box_6.startAnimation(c);
		c = null;
		Animation d;
		d = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		d.setDuration(500); box_sub_header.startAnimation(d);
		d = null;
		Animation e;
		e = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		e.setDuration(600); main_box_4.startAnimation(e);
		e = null;
		Animation bbb;
		bbb = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		bbb.setDuration(700); main_box_15.startAnimation(bbb);
		bbb = null;
		Animation f;
		f = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		f.setDuration(300); title_header.startAnimation(f);
		f = null;
		Animation g;
		g = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		g.setDuration(400); box_switch.startAnimation(g);
		g = null;
		Animation h;
		h = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		h.setDuration(500); box_update.startAnimation(h);
		h = null;
	}
	
	
	private void _Animation_1 () {
		Animation i;
		i = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		i.setDuration(200); box_settings_close.startAnimation(i);
		i = null;
		Animation j;
		j = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		j.setDuration(600); main_box_7.startAnimation(j);
		j = null;
		Animation k;
		k = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		k.setDuration(700); main_box_5.startAnimation(k);
		k = null;
		Animation l;
		l = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		l.setDuration(300); title_header.startAnimation(l);
		l = null;
		Animation z;
		z = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		z.setDuration(300); main_box_8.startAnimation(z);
		z = null;
		Animation hh;
		hh = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		hh.setDuration(900); main_box_9.startAnimation(hh);
		hh = null;
		Animation ii;
		ii = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		ii.setDuration(1000); main_box_10.startAnimation(ii);
		ii = null;
		Animation jj;
		jj = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		jj.setDuration(1100); main_box_13.startAnimation(jj);
		jj = null;
		Animation kk;
		kk = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		kk.setDuration(400); main_box_11.startAnimation(kk);
		kk = null;
		Animation ll;
		ll = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		ll.setDuration(500); main_box_12.startAnimation(ll);
		ll = null;
		Animation mm;
		mm = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		mm.setDuration(800); main_box_14.startAnimation(mm);
		mm = null;
	}
	
	
	private void _Animation_2 () {
		Animation m;
		m = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		m.setDuration(200); box_about_close.startAnimation(m);
		m = null;
		Animation n;
		n = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		n.setDuration(300); box_about_header.startAnimation(n);
		n = null;
		Animation o;
		o = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		o.setDuration(400); sub_title.startAnimation(o);
		o = null;
		Animation p;
		p = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		p.setDuration(500); box_about_1.startAnimation(p);
		p = null;
		Animation q;
		q = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		q.setDuration(600); box_about_2.startAnimation(q);
		q = null;
		Animation r;
		r = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		r.setDuration(700); box_about_3.startAnimation(r);
		r = null;
		Animation s;
		s = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		s.setDuration(800); box_about_4.startAnimation(s);
		s = null;
		Animation t;
		t = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		t.setDuration(900); box_about_5.startAnimation(t);
		t = null;
		Animation u;
		u = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		u.setDuration(1000); box_about_6.startAnimation(u);
		u = null;
		Animation v;
		v = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		v.setDuration(1100); box_about_7.startAnimation(v);
		v = null;
		Animation w;
		w = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		w.setDuration(1200); contributors_1.startAnimation(w);
		w = null;
		Animation x;
		x = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		x.setDuration(300); title_header.startAnimation(x);
		x = null;
	}
	
	
	private void _Animation_4 () {
		Animation a;
		a = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		a.setDuration(200); main_box_1.startAnimation(a);
		a = null;
		Animation b;
		b = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		b.setDuration(300); main_box_2.startAnimation(b);
		b = null;
		Animation c;
		c = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		c.setDuration(400); main_box_6.startAnimation(c);
		c = null;
		Animation d;
		d = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		d.setDuration(500); box_sub_header.startAnimation(d);
		d = null;
		Animation e;
		e = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		e.setDuration(600); main_box_4.startAnimation(e);
		e = null;
		Animation bbb;
		bbb = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
		bbb.setDuration(700); main_box_15.startAnimation(bbb);
		bbb = null;
	}
	
	
	private void _Dark_Navigation () {
		if (Build.VERSION.SDK_INT >= 21) {
			getWindow().setNavigationBarColor(Color.parseColor("#212121"));
		}
	}
	
	
	private void _Linear_Animation (final boolean _clickanim, final double _animDuration, final View _view) {
		_view.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()){
					case MotionEvent.ACTION_DOWN:{
						ObjectAnimator scaleX = new ObjectAnimator();
						scaleX.setTarget(_view);
						scaleX.setPropertyName("scaleX");
						scaleX.setFloatValues(0.9f);
						scaleX.setDuration((int)_animDuration);
						scaleX.start();
						
						ObjectAnimator scaleY = new ObjectAnimator();
						scaleY.setTarget(_view);
						scaleY.setPropertyName("scaleY");
						scaleY.setFloatValues(0.9f);
						scaleY.setDuration((int)_animDuration);
						scaleY.start();
						break;
					}
					case MotionEvent.ACTION_UP:{
						
						ObjectAnimator scaleX = new ObjectAnimator();
						scaleX.setTarget(_view);
						scaleX.setPropertyName("scaleX");
						scaleX.setFloatValues((float)1);
						scaleX.setDuration((int)_animDuration);
						scaleX.start();
						
						ObjectAnimator scaleY = new ObjectAnimator();
						scaleY.setTarget(_view);
						scaleY.setPropertyName("scaleY");
						scaleY.setFloatValues((float)1);
						scaleY.setDuration((int)_animDuration);
						scaleY.start();
						
						break;
					}
				}
				return false;
			}
		});
	}
	
	
	private void _Animation_5 () {
		_Linear_Animation(true, 100, box_uninstall);
		_Linear_Animation(true, 100, box_settings);
		_Linear_Animation(true, 100, box_cache);
		_Linear_Animation(true, 100, box_open);
		_Linear_Animation(true, 100, box_website);
		_Linear_Animation(true, 100, box_source);
		_Linear_Animation(true, 100, box_support);
		_Linear_Animation(true, 100, box_discord);
		_Linear_Animation(true, 100, box_donate);
		_Linear_Animation(true, 100, box_about);
		_Linear_Animation(true, 100, box_switch);
		_Linear_Animation(true, 100, box_update);
		_Linear_Animation(true, 100, main_box_10);
		_Linear_Animation(true, 100, box_icon_close);
		_Linear_Animation(true, 100, box_reset_settings);
		_Linear_Animation(true, 100, box_settings_icon_close);
	}
	
	
	private void _List_Updater () {
		if (LIST_REFRESH.getString("UPDATE", "").equals("ON")) {
			try {
				main_body.setEnabled(false);
				list_auto_refresh_switch.setChecked(true);
				
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
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										sub_1.setText(VERSIONS.getString("REGULAR", ""));
										list_menu_1.smoothScrollToPosition((int)(999));
										version_switch_01.setChecked(true);
										version_switch_02.setChecked(false);
										changelogs_switch.setChecked(false);
										main_body.setAlpha((float)(0.65d));
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(300));
						if (!force_auto_install_switch.isChecked() && !copy_url_mode_switch.isChecked()) {
							com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "Refreshing List...", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
											@Override
											public void onClick(View _view) {
											}
									}).show();
						}
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
						
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										sub_3.setText(VERSIONS.getString("AMOLED", ""));
									}
								});
							}
						};
						_timer.schedule(Timer, (int)(300));
						Timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										list_menu_2.smoothScrollToPosition((int)(999));
										version_switch_01.setChecked(false);
										version_switch_02.setChecked(true);
										changelogs_switch.setChecked(false);
										main_body.setAlpha((float)(0.65d));
										Timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														version_switch_01.setChecked(false);
														version_switch_02.setChecked(false);
														changelogs_switch.setChecked(true);
														main_body.setAlpha((float)(0.65d));
														Timer = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		
																		version_switch_01.setChecked(false);
																		version_switch_02.setChecked(false);
																		changelogs_switch.setChecked(false);
																		main_body.setEnabled(true);
																		main_body.setAlpha((float)(1.0d));
																		if (!force_auto_install_switch.isChecked() && !copy_url_mode_switch.isChecked()) {
																			com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "List Updated", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
																							@Override
																							public void onClick(View _view) {
																							}
																					}).show();
																		}
																	}
																});
															}
														};
														_timer.schedule(Timer, (int)(900));
													}
												});
											}
										};
										_timer.schedule(Timer, (int)(800));
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
				main_scroll_settings.setVisibility(View.GONE);
				main_scroll_about.setVisibility(View.GONE);
				main_refresh_layout.setVisibility(View.VISIBLE);
				box_update.setVisibility(View.VISIBLE);
				box_switch.setVisibility(View.VISIBLE);
				icon_update.setAlpha((float)(1.0d));
				icon_switch.setAlpha((float)(1.0d));
			}
			catch(Exception e) {
			}
		}
		else {
			if (LIST_REFRESH.getString("UPDATE", "").equals("OFF")) {
				try {
					list_auto_refresh_switch.setChecked(false);
					
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
							Timer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											sub_1.setText(VERSIONS.getString("REGULAR", ""));
											
											list_menu_1.setAdapter(new List_menu_1Adapter(listdata));
											((BaseAdapter)list_menu_1.getAdapter()).notifyDataSetChanged();
											main_body.setEnabled(false);
											main_body.setAlpha((float)(0.65d));
										}
									});
								}
							};
							_timer.schedule(Timer, (int)(300));
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
							Timer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											sub_3.setText(VERSIONS.getString("AMOLED", ""));
										}
									});
								}
							};
							_timer.schedule(Timer, (int)(300));
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
					main_scroll_settings.setVisibility(View.GONE);
					main_scroll_about.setVisibility(View.GONE);
					main_refresh_layout.setVisibility(View.VISIBLE);
					box_update.setVisibility(View.VISIBLE);
					box_switch.setVisibility(View.VISIBLE);
					icon_update.setAlpha((float)(1.0d));
					icon_switch.setAlpha((float)(1.0d));
					
					_Updater();
				}
				catch(Exception e) {
				}
			}
		}
	}
	
	
	private void _Default_Path () {
		if (PATH.equals("")) {
			apk_path_location.setText("/storage/emulated/0/xManager/");
		}
		else {
			APK_PATH.edit().putString("PATH", apk_path_location.getText().toString()).commit();
		}
	}
	
	
	private void _Download_Install (final String _url, final String _path) {
		try {
			FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
			
			android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				
				
				final String urlDownload = _url;
				
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
				
				final String fileName = URLUtil.guessFileName(urlDownload, null, null);
				
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
				
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
				prog.setTitle(downloading_file_0);
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
											
											prog.setTitle(downloading_file_0);
											prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
											prog.setProgress(bytes_downloaded);
											prog.setMax(bytes_total);
											prog.setButton(DialogInterface.BUTTON_NEGATIVE, cancel_0, new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface dialog, int which) {
													SketchwareUtil.CustomToast(getApplicationContext(), "Download cancelled", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
													manager.remove(downloadId);
													Timer = new TimerTask() {
																@Override
																public void run() {
																		runOnUiThread(new Runnable() {
																				@Override
																				public void run() {
																						prog.cancel();
																				}
																		});
																}
														};
														_timer.schedule(Timer, (int)(0));
												}
											});
											prog.show();
											
											if (bytes_downloaded == bytes_total) {
												
												Timer = new TimerTask() {
														@Override
														public void run() {
																runOnUiThread(new Runnable() {
																		@Override
																		public void run() {
																
																try {
																	FileUtil.copyFile("/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/Spotify Mod (Official).apk", apk_path_location.getText().toString().concat("Spotify Mod (Official).apk"));
																}
																catch(Exception e) {
																	SketchwareUtil.CustomToast(getApplicationContext(), "Null 404: Copying failed", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
																}
																
																_RequiredDialog(Success_Download, false);
																Success_Download.setTitle(download_success_0);
																Success_Download.setPositiveButton(install_now_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
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
																Success_Download.setNegativeButton(directory_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
																				_RequiredDialog(Directory, false);
																				Directory.setTitle(file_directory_0);
																				Directory.setMessage("<".concat(apk_path_location.getText().toString().concat(">")));
																				Directory.setPositiveButton(go_back_0, new DialogInterface.OnClickListener() {
																						@Override
																						public void onClick(DialogInterface _dialog, int _which) {
																								_RequiredDialog(Directory, true);
																								_RequiredDialog(Success_Download, false);
																								Success_Download.create().show();
																						}
																				});
																				Directory.create().show();
																		
																	}
																});
																Success_Download.setNeutralButton(later_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
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
																
																prog.cancel();
																
																Success_Download.create().dismiss();
																
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
				com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "No Internet Connection", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
								}
						}).show();
			}
		}
		catch(Exception e) {
		}
	}
	
	
	private void _Download_Update_Install (final String _url, final String _path) {
		try {
			FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
			
			android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				
				
				final String urlDownload = _url;
				
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
				
				final String fileName = URLUtil.guessFileName(urlDownload, null, null);
				
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
				
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
				prog.setTitle(downloading_file_0);
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
											
											prog.setTitle(downloading_file_0);
											prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
											prog.setProgress(bytes_downloaded);
											prog.setMax(bytes_total);
											prog.setButton(DialogInterface.BUTTON_NEGATIVE, cancel_0, new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface dialog, int which) {
													SketchwareUtil.CustomToast(getApplicationContext(), "Download cancelled", 0xFF000000, 14, 0xFFE0E0E0, 30, SketchwareUtil.BOTTOM);
													manager.remove(downloadId);
													Timer = new TimerTask() {
																@Override
																public void run() {
																		runOnUiThread(new Runnable() {
																				@Override
																				public void run() {
																						prog.cancel();
																				}
																		});
																}
														};
														_timer.schedule(Timer, (int)(0));
												}
											});
											prog.show();
											
											if (bytes_downloaded == bytes_total) {
												
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
																Success_Download.setTitle(download_success_0);
																Success_Download.setPositiveButton(install_update_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
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
																Success_Download.setNegativeButton(directory_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
																				_RequiredDialog(Directory, false);
																				Directory.setTitle(file_directory_0);
																		    Directory.setMessage("</storage/emulated/0/xManager/Update/>");
																				Directory.setPositiveButton(go_back_0, new DialogInterface.OnClickListener() {
																						@Override
																						public void onClick(DialogInterface _dialog, int _which) {
																								_RequiredDialog(Directory, true);
																								_RequiredDialog(Success_Download, false);
																								Success_Download.create().show();
																						}
																				});
																				Directory.create().show();
																		
																	}
																});
																Success_Download.setNeutralButton(later_0, new DialogInterface.OnClickListener() {
																		@Override
																		public void onClick(DialogInterface _dialog, int _which) {
																				_RequiredDialog(Success_Download, true);
																		
																		prog.cancel();
																		
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
																
																prog.cancel();
																
																Success_Download.create().dismiss();
																
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
				com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "No Internet Connection", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
								}
						}).show();
			}
		}
		catch(Exception e) {
		}
	}
	
	
	private void _Url_Mode () {
		if (COPY_URL_MODE.getString("COPY_URL_MODE", "").equals("URL_ON")) {
			copy_url_mode_switch.setChecked(true);
			title_header.setText("xManager (UM)");
		}
		else {
			if (COPY_URL_MODE.getString("COPY_URL_MODE", "").equals("URL_OFF")) {
				copy_url_mode_switch.setChecked(false);
				title_header.setText("xManager");
			}
		}
	}
	
	
	private void _Switches () {
		if (copy_url_mode_switch.isChecked()) {
			COPY_URL_MODE.edit().putString("COPY_URL_MODE", "URL_ON").commit();
		}
		else {
			COPY_URL_MODE.edit().putString("COPY_URL_MODE", "URL_OFF").commit();
		}
		if (force_auto_install_switch.isChecked()) {
			FORCE_INSTALL.edit().putString("FORCE_INSTALL", "X").commit();
			FORCE_INSTALL_UPDATE.edit().putString("FORCE_INSTALL_UPDATE", "XX").commit();
		}
		else {
			FORCE_INSTALL.edit().putString("FORCE_INSTALL", "Y").commit();
			FORCE_INSTALL_UPDATE.edit().putString("FORCE_INSTALL_UPDATE", "YY").commit();
		}
	}
	
	
	private void _Switch_Fixer () {
		if (FORCE_INSTALL.getString("FORCE_INSTALL", "").equals("X") && FORCE_INSTALL_UPDATE.getString("FORCE_INSTALL_UPDATE", "").equals("XX")) {
			force_auto_install_switch.setChecked(true);
		}
		else {
			if (FORCE_INSTALL.getString("FORCE_INSTALL", "").equals("Y") && FORCE_INSTALL_UPDATE.getString("FORCE_INSTALL_UPDATE", "").equals("YY")) {
				force_auto_install_switch.setChecked(false);
			}
		}
	}
	
	
	private void _Switch_Checker () {
		if (force_auto_install_switch.isChecked()) {
			com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "AUTO-INSTALL ENABLED", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("SETTINGS", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
								RippleAnimation.create(box_switch).setDuration((long)700).start();
								main_body_optimization.setVisibility(View.GONE);
								main_scroll_settings.setVisibility(View.VISIBLE);
								main_scroll_about.setVisibility(View.GONE);
								main_refresh_layout.setVisibility(View.GONE);
								box_update.setVisibility(View.GONE);
								box_switch.setVisibility(View.GONE);
								apk_path_location.setEnabled(true);
								title_header.setText("Settings");
								_Animation_1();
						}
				}).show();
		}
		if (copy_url_mode_switch.isChecked()) {
			com.google.android.material.snackbar.Snackbar.make(main_refresh_layout, "URL MODE ENABLED", com.google.android.material.snackbar.Snackbar.LENGTH_LONG).setAction("SETTINGS", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
								RippleAnimation.create(box_switch).setDuration((long)700).start();
								main_body_optimization.setVisibility(View.GONE);
								main_scroll_settings.setVisibility(View.VISIBLE);
								main_scroll_about.setVisibility(View.GONE);
								main_refresh_layout.setVisibility(View.GONE);
								box_update.setVisibility(View.GONE);
								box_switch.setVisibility(View.GONE);
								apk_path_location.setEnabled(true);
								title_header.setText("Settings");
								_Animation_1();
						}
				}).show();
		}
	}
	
	
	private void _Language_UI () {
		if (LANGUAGE.getString("LANGUAGE", "").equals("0")) {
			    title_1.setText(R.string.spotify_regular);
				title_2.setText(R.string.spotify_amoled);
				sub_text_2.setText(R.string.installed);
				sub_text_4.setText(R.string.installed);
				sub_text_1.setText(R.string.latest);
				sub_text_3.setText(R.string.latest);
				version_switch_1.setText(R.string.versions);
				version_switch_2.setText(R.string.versions);
				changelogs.setText(R.string.changelogs);
				title_sub.setText(R.string.manager_tools);
				device_cpu.setText(R.string.device_cpu);
				source.setText(R.string.source);
				support.setText(R.string.support);
				donate.setText(R.string.donate);
				about.setText(R.string.about);
				list_auto_refresh.setText(R.string.list_auto_refresh);
				list_auto_refresh_info.setText(R.string.list_auto_refresh_desc);
				force_auto_install.setText(R.string.force_auto_install);
				force_auto_install_info.setText(R.string.force_auto_install_desc);
				copy_url_mode.setText(R.string.copy_url_mode);
				copy_file_url_mode_info.setText(R.string.copy_url_mode_desc);
				navigation_bar.setText(R.string.hide_navigation_bar);
				theme.setText(R.string.show_themes);
				apk_location.setText(R.string.apk_location);
				apk_location_info.setText(R.string.apk_location_desc);
				clear_directory_folders.setText(R.string.clear_directory_folders);
				clear_directory_folders_info.setText(R.string.clear_directory_folders_desc);
				reset_settings.setText(R.string.reset_settings);
					sub_title.setText(R.string.about_sub);
				developer_manager.setText(R.string.xmanager_dev);
				developer_spotify.setText(R.string.spotify_mod_devs);
				support_team.setText(R.string.telegram_support_team);
				mod_testers_1.setText(R.string.manager_testers);
				mod_testers_2.setText(R.string.manager_hosting);
				mobilism_team.setText(R.string.mobilism_team);
				forum_team.setText(R.string.forum_team);
				manager_team.setText(R.string.xspotify_team);
				contributors_1.setText(R.string.contributors);
				download_selected.setText(R.string.download_selected);
				download_ready.setText(R.string.download_ready);
				download_ready_desc.setText(R.string.download_ready_desc);
				downloading_file.setText(R.string.downloading_file);
				download_success.setText(R.string.download_success);
				copy_url_desc.setText(R.string.copy_url_desc);
				file_directory.setText(R.string.file_directory);
				new_update.setText(R.string.new_update);
				download_selected_0 = download_selected.getText().toString();
				download_ready_0 = download_ready.getText().toString();
				download_ready_desc_0 = download_ready_desc.getText().toString();
				downloading_file_0 = downloading_file.getText().toString();
				download_success_0 = download_success.getText().toString();
				copy_url_desc_0 = copy_url_desc.getText().toString();
				file_directory_0 = file_directory.getText().toString();
				copy_url.setText(R.string.copy_url);
				continue_1.setText(R.string.continue_1);
				cancel.setText(R.string.cancel);
				download.setText(R.string.download);
				later.setText(R.string.later);
				directory.setText(R.string.directory);
				install_now.setText(R.string.install_now);
				install_update.setText(R.string.install_update);
				go_back.setText(R.string.go_back);
				download_update.setText(R.string.download_update);
				not_now.setText(R.string.not_now);
				show_support.setText(R.string.show_support);
				show_support_desc.setText(R.string.show_support_desc);
				copy_url_0 = copy_url.getText().toString();
				download_0 = download.getText().toString();
				continue_0 = continue_1.getText().toString();
				cancel_0 = cancel.getText().toString();
				later_0 = later.getText().toString();
				directory_0 = directory.getText().toString();
				install_now_0 = install_now.getText().toString();
				go_back_0 = go_back.getText().toString();
				install_update_0 = install_update.getText().toString();
				main_title.setText(R.string.main_title);
				settings_title.setText(R.string.settings_title);
				about_title.setText(R.string.about_title);
				maintenance.setText(R.string.maintenance);
				maintenance_desc.setText(R.string.maintenance_desc);
				thanks.setText(R.string.thanks);
				language.setText(R.string.language);
			  website.setText(R.string.website);
			
			discord.setText(R.string.discord);
			select_language.setSelection((int)(0));
		}
		else {
			if (LANGUAGE.getString("LANGUAGE", "").equals("1")) {
				    title_1.setText(R.string.spotify_regular_01);
					title_2.setText(R.string.spotify_amoled_01);
					sub_text_2.setText(R.string.installed_01);
					sub_text_4.setText(R.string.installed_01);
					sub_text_1.setText(R.string.latest_01);
					sub_text_3.setText(R.string.latest_01);
					version_switch_1.setText(R.string.versions_01);
					version_switch_2.setText(R.string.versions_01);
					changelogs.setText(R.string.changelogs_01);
					title_sub.setText(R.string.manager_tools_01);
					device_cpu.setText(R.string.device_cpu_01);
					source.setText(R.string.source_01);
					support.setText(R.string.support_01);
					donate.setText(R.string.donate_01);
					about.setText(R.string.about_01);
					list_auto_refresh.setText(R.string.list_auto_refresh_01);
					list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_01);
					force_auto_install.setText(R.string.force_auto_install_01);
					force_auto_install_info.setText(R.string.force_auto_install_desc_01);
					copy_url_mode.setText(R.string.copy_url_mode_01);
					copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_01);
					navigation_bar.setText(R.string.hide_navigation_bar_01);
					theme.setText(R.string.show_themes_01);
					apk_location.setText(R.string.apk_location_01);
					apk_location_info.setText(R.string.apk_location_desc_01);
					clear_directory_folders.setText(R.string.clear_directory_folders_01);
					clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_01);
					reset_settings.setText(R.string.reset_settings_01);
					sub_title.setText(R.string.about_sub_01);
					developer_manager.setText(R.string.xmanager_dev_01);
					developer_spotify.setText(R.string.spotify_mod_devs_01);
					support_team.setText(R.string.telegram_support_team_01);
					mod_testers_1.setText(R.string.manager_testers_01);
					mod_testers_2.setText(R.string.manager_hosting_01);
					mobilism_team.setText(R.string.mobilism_team_01);
					forum_team.setText(R.string.forum_team_01);
					manager_team.setText(R.string.xspotify_team_01);
					contributors_1.setText(R.string.contributors_01);
					download_selected.setText(R.string.download_selected_01);
					download_ready.setText(R.string.download_ready_01);
					download_ready_desc.setText(R.string.download_ready_desc_01);
					downloading_file.setText(R.string.downloading_file_01);
					download_success.setText(R.string.download_success_01);
					copy_url_desc.setText(R.string.copy_url_desc_01);
					file_directory.setText(R.string.file_directory_01);
					new_update.setText(R.string.new_update_01);
					download_selected_0 = download_selected.getText().toString();
					download_ready_0 = download_ready.getText().toString();
					download_ready_desc_0 = download_ready_desc.getText().toString();
					downloading_file_0 = downloading_file.getText().toString();
					download_success_0 = download_success.getText().toString();
					copy_url_desc_0 = copy_url_desc.getText().toString();
					file_directory_0 = file_directory.getText().toString();
					copy_url.setText(R.string.copy_url_01);
					continue_1.setText(R.string.continue_1_01);
					cancel.setText(R.string.cancel_01);
					download.setText(R.string.download_01);
					later.setText(R.string.later_01);
					directory.setText(R.string.directory_01);
					install_now.setText(R.string.install_now_01);
					install_update.setText(R.string.install_update_01);
					go_back.setText(R.string.go_back_01);
					download_update.setText(R.string.download_update_01);
					not_now.setText(R.string.not_now_01);
					show_support.setText(R.string.show_support_01);
					show_support_desc.setText(R.string.show_support_desc_01);
					copy_url_0 = copy_url.getText().toString();
					download_0 = download.getText().toString();
					continue_0 = continue_1.getText().toString();
					cancel_0 = cancel.getText().toString();
					later_0 = later.getText().toString();
					directory_0 = directory.getText().toString();
					install_now_0 = install_now.getText().toString();
					go_back_0 = go_back.getText().toString();
					install_update_0 = install_update.getText().toString();
					main_title.setText(R.string.main_title_01);
					settings_title.setText(R.string.settings_title_01);
					about_title.setText(R.string.about_title_01);
					maintenance.setText(R.string.maintenance_01);
					maintenance_desc.setText(R.string.maintenance_desc_01);
					thanks.setText(R.string.thanks_01);
					language.setText(R.string.language_01);
				  website.setText(R.string.website_01);
				
				discord.setText(R.string.discord_01);
				select_language.setSelection((int)(1));
			}
			else {
				if (LANGUAGE.getString("LANGUAGE", "").equals("2")) {
					    title_1.setText(R.string.spotify_regular_02);
						title_2.setText(R.string.spotify_amoled_02);
						sub_text_2.setText(R.string.installed_02);
						sub_text_4.setText(R.string.installed_02);
						sub_text_1.setText(R.string.latest_02);
						sub_text_3.setText(R.string.latest_02);
						version_switch_1.setText(R.string.versions_02);
						version_switch_2.setText(R.string.versions_02);
						changelogs.setText(R.string.changelogs_02);
						title_sub.setText(R.string.manager_tools_02);
						device_cpu.setText(R.string.device_cpu_02);
						source.setText(R.string.source_02);
						support.setText(R.string.support_02);
						donate.setText(R.string.donate_02);
						about.setText(R.string.about_02);
						list_auto_refresh.setText(R.string.list_auto_refresh_02);
						list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_02);
						force_auto_install.setText(R.string.force_auto_install_02);
						force_auto_install_info.setText(R.string.force_auto_install_desc_02);
						copy_url_mode.setText(R.string.copy_url_mode_02);
						copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_02);
						navigation_bar.setText(R.string.hide_navigation_bar_02);
						theme.setText(R.string.show_themes_02);
						apk_location.setText(R.string.apk_location_02);
						apk_location_info.setText(R.string.apk_location_desc_02);
						clear_directory_folders.setText(R.string.clear_directory_folders_02);
						clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_02);
						reset_settings.setText(R.string.reset_settings_02);
						sub_title.setText(R.string.about_sub_02);
						developer_manager.setText(R.string.xmanager_dev_02);
						developer_spotify.setText(R.string.spotify_mod_devs_02);
						support_team.setText(R.string.telegram_support_team_02);
						mod_testers_1.setText(R.string.manager_testers_02);
						mod_testers_2.setText(R.string.manager_hosting_02);
						mobilism_team.setText(R.string.mobilism_team_02);
						forum_team.setText(R.string.forum_team_02);
						manager_team.setText(R.string.xspotify_team_02);
						contributors_1.setText(R.string.contributors_02);
						download_selected.setText(R.string.download_selected_02);
						download_ready.setText(R.string.download_ready_02);
						download_ready_desc.setText(R.string.download_ready_desc_02);
						downloading_file.setText(R.string.downloading_file_02);
						download_success.setText(R.string.download_success_02);
						copy_url_desc.setText(R.string.copy_url_desc_02);
						file_directory.setText(R.string.file_directory_02);
						new_update.setText(R.string.new_update_02);
						download_selected_0 = download_selected.getText().toString();
						download_ready_0 = download_ready.getText().toString();
						download_ready_desc_0 = download_ready_desc.getText().toString();
						downloading_file_0 = downloading_file.getText().toString();
						download_success_0 = download_success.getText().toString();
						copy_url_desc_0 = copy_url_desc.getText().toString();
						file_directory_0 = file_directory.getText().toString();
						copy_url.setText(R.string.copy_url_02);
						continue_1.setText(R.string.continue_1_02);
						cancel.setText(R.string.cancel_02);
						download.setText(R.string.download_02);
						later.setText(R.string.later_02);
						directory.setText(R.string.directory_02);
						install_now.setText(R.string.install_now_02);
						install_update.setText(R.string.install_update_02);
						go_back.setText(R.string.go_back_02);
						download_update.setText(R.string.download_update_02);
						not_now.setText(R.string.not_now_02);
						show_support.setText(R.string.show_support_02);
						show_support_desc.setText(R.string.show_support_desc_02);
						copy_url_0 = copy_url.getText().toString();
						download_0 = download.getText().toString();
						continue_0 = continue_1.getText().toString();
						cancel_0 = cancel.getText().toString();
						later_0 = later.getText().toString();
						directory_0 = directory.getText().toString();
						install_now_0 = install_now.getText().toString();
						go_back_0 = go_back.getText().toString();
						install_update_0 = install_update.getText().toString();
						main_title.setText(R.string.main_title_02);
						settings_title.setText(R.string.settings_title_02);
						about_title.setText(R.string.about_title_02);
						maintenance.setText(R.string.maintenance_02);
						maintenance_desc.setText(R.string.maintenance_desc_02);
						thanks.setText(R.string.thanks_02);
						language.setText(R.string.language_02);
					  website.setText(R.string.website_02);
					
					discord.setText(R.string.discord_02);
					select_language.setSelection((int)(2));
				}
				else {
					if (LANGUAGE.getString("LANGUAGE", "").equals("3")) {
						    title_1.setText(R.string.spotify_regular_03);
							title_2.setText(R.string.spotify_amoled_03);
							sub_text_2.setText(R.string.installed_03);
							sub_text_4.setText(R.string.installed_03);
							sub_text_1.setText(R.string.latest_03);
							sub_text_3.setText(R.string.latest_03);
							version_switch_1.setText(R.string.versions_03);
							version_switch_2.setText(R.string.versions_03);
							changelogs.setText(R.string.changelogs_03);
							title_sub.setText(R.string.manager_tools_03);
							device_cpu.setText(R.string.device_cpu_03);
							source.setText(R.string.source_03);
							support.setText(R.string.support_03);
							donate.setText(R.string.donate_03);
							about.setText(R.string.about_03);
							list_auto_refresh.setText(R.string.list_auto_refresh_03);
							list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_03);
							force_auto_install.setText(R.string.force_auto_install_03);
							force_auto_install_info.setText(R.string.force_auto_install_desc_03);
							copy_url_mode.setText(R.string.copy_url_mode_03);
							copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_03);
							navigation_bar.setText(R.string.hide_navigation_bar_03);
							theme.setText(R.string.show_themes_03);
							apk_location.setText(R.string.apk_location_03);
							apk_location_info.setText(R.string.apk_location_desc_03);
							clear_directory_folders.setText(R.string.clear_directory_folders_03);
							clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_03);
							reset_settings.setText(R.string.reset_settings_03);
							sub_title.setText(R.string.about_sub_03);
							developer_manager.setText(R.string.xmanager_dev_03);
							developer_spotify.setText(R.string.spotify_mod_devs_03);
							support_team.setText(R.string.telegram_support_team_03);
							mod_testers_1.setText(R.string.manager_testers_03);
							mod_testers_2.setText(R.string.manager_hosting_03);
							mobilism_team.setText(R.string.mobilism_team_03);
							forum_team.setText(R.string.forum_team_03);
							manager_team.setText(R.string.xspotify_team_03);
							contributors_1.setText(R.string.contributors_03);
							download_selected.setText(R.string.download_selected_03);
							download_ready.setText(R.string.download_ready_03);
							download_ready_desc.setText(R.string.download_ready_desc_03);
							downloading_file.setText(R.string.downloading_file_03);
							download_success.setText(R.string.download_success_03);
							copy_url_desc.setText(R.string.copy_url_desc_03);
							file_directory.setText(R.string.file_directory_03);
							new_update.setText(R.string.new_update_03);
							download_selected_0 = download_selected.getText().toString();
							download_ready_0 = download_ready.getText().toString();
							download_ready_desc_0 = download_ready_desc.getText().toString();
							downloading_file_0 = downloading_file.getText().toString();
							download_success_0 = download_success.getText().toString();
							copy_url_desc_0 = copy_url_desc.getText().toString();
							file_directory_0 = file_directory.getText().toString();
							copy_url.setText(R.string.copy_url_03);
							continue_1.setText(R.string.continue_1_03);
							cancel.setText(R.string.cancel_03);
							download.setText(R.string.download_03);
							later.setText(R.string.later_03);
							directory.setText(R.string.directory_03);
							install_now.setText(R.string.install_now_03);
							install_update.setText(R.string.install_update_03);
							go_back.setText(R.string.go_back_03);
							download_update.setText(R.string.download_update_03);
							not_now.setText(R.string.not_now_03);
							show_support.setText(R.string.show_support_03);
							show_support_desc.setText(R.string.show_support_desc_03);
							copy_url_0 = copy_url.getText().toString();
							download_0 = download.getText().toString();
							continue_0 = continue_1.getText().toString();
							cancel_0 = cancel.getText().toString();
							later_0 = later.getText().toString();
							directory_0 = directory.getText().toString();
							install_now_0 = install_now.getText().toString();
							go_back_0 = go_back.getText().toString();
							install_update_0 = install_update.getText().toString();
							main_title.setText(R.string.main_title_03);
							settings_title.setText(R.string.settings_title_03);
							about_title.setText(R.string.about_title_03);
							maintenance.setText(R.string.maintenance_03);
							maintenance_desc.setText(R.string.maintenance_desc_03);
							thanks.setText(R.string.thanks_03);
							language.setText(R.string.language_03);
						  website.setText(R.string.website_03);
						
						discord.setText(R.string.discord_03);
						select_language.setSelection((int)(3));
					}
					else {
						if (LANGUAGE.getString("LANGUAGE", "").equals("4")) {
							    title_1.setText(R.string.spotify_regular_04);
								title_2.setText(R.string.spotify_amoled_04);
								sub_text_2.setText(R.string.installed_04);
								sub_text_4.setText(R.string.installed_04);
								sub_text_1.setText(R.string.latest_04);
								sub_text_3.setText(R.string.latest_04);
								version_switch_1.setText(R.string.versions_04);
								version_switch_2.setText(R.string.versions_04);
								changelogs.setText(R.string.changelogs_04);
								title_sub.setText(R.string.manager_tools_04);
								device_cpu.setText(R.string.device_cpu_04);
								source.setText(R.string.source_04);
								support.setText(R.string.support_04);
								donate.setText(R.string.donate_04);
								about.setText(R.string.about_04);
								list_auto_refresh.setText(R.string.list_auto_refresh_04);
								list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_04);
								force_auto_install.setText(R.string.force_auto_install_04);
								force_auto_install_info.setText(R.string.force_auto_install_desc_04);
								copy_url_mode.setText(R.string.copy_url_mode_04);
								copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_04);
								navigation_bar.setText(R.string.hide_navigation_bar_04);
								theme.setText(R.string.show_themes_04);
								apk_location.setText(R.string.apk_location_04);
								apk_location_info.setText(R.string.apk_location_desc_04);
								clear_directory_folders.setText(R.string.clear_directory_folders_04);
								clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_04);
								reset_settings.setText(R.string.reset_settings_04);
								sub_title.setText(R.string.about_sub_04);
								developer_manager.setText(R.string.xmanager_dev_04);
								developer_spotify.setText(R.string.spotify_mod_devs_04);
								support_team.setText(R.string.telegram_support_team_04);
								mod_testers_1.setText(R.string.manager_testers_04);
								mod_testers_2.setText(R.string.manager_hosting_04);
								mobilism_team.setText(R.string.mobilism_team_04);
								forum_team.setText(R.string.forum_team_04);
								manager_team.setText(R.string.xspotify_team_04);
								contributors_1.setText(R.string.contributors_04);
								download_selected.setText(R.string.download_selected_04);
								download_ready.setText(R.string.download_ready_04);
								download_ready_desc.setText(R.string.download_ready_desc_04);
								downloading_file.setText(R.string.downloading_file_04);
								download_success.setText(R.string.download_success_04);
								copy_url_desc.setText(R.string.copy_url_desc_04);
								file_directory.setText(R.string.file_directory_04);
								new_update.setText(R.string.new_update_04);
								download_selected_0 = download_selected.getText().toString();
								download_ready_0 = download_ready.getText().toString();
								download_ready_desc_0 = download_ready_desc.getText().toString();
								downloading_file_0 = downloading_file.getText().toString();
								download_success_0 = download_success.getText().toString();
								copy_url_desc_0 = copy_url_desc.getText().toString();
								file_directory_0 = file_directory.getText().toString();
								copy_url.setText(R.string.copy_url_04);
								continue_1.setText(R.string.continue_1_04);
								cancel.setText(R.string.cancel_04);
								download.setText(R.string.download_04);
								later.setText(R.string.later_04);
								directory.setText(R.string.directory_04);
								install_now.setText(R.string.install_now_04);
								install_update.setText(R.string.install_update_04);
								go_back.setText(R.string.go_back_04);
								download_update.setText(R.string.download_update_04);
								not_now.setText(R.string.not_now_04);
								show_support.setText(R.string.show_support_04);
								show_support_desc.setText(R.string.show_support_desc_04);
								copy_url_0 = copy_url.getText().toString();
								download_0 = download.getText().toString();
								continue_0 = continue_1.getText().toString();
								cancel_0 = cancel.getText().toString();
								later_0 = later.getText().toString();
								directory_0 = directory.getText().toString();
								install_now_0 = install_now.getText().toString();
								go_back_0 = go_back.getText().toString();
								install_update_0 = install_update.getText().toString();
								main_title.setText(R.string.main_title_04);
								settings_title.setText(R.string.settings_title_04);
								about_title.setText(R.string.about_title_04);
								maintenance.setText(R.string.maintenance_04);
								maintenance_desc.setText(R.string.maintenance_desc_04);
								thanks.setText(R.string.thanks_04);
								language.setText(R.string.language_04);
							  website.setText(R.string.website_04);
							
							discord.setText(R.string.discord_04);
							select_language.setSelection((int)(4));
						}
						else {
							if (LANGUAGE.getString("LANGUAGE", "").equals("5")) {
								    title_1.setText(R.string.spotify_regular_05);
									title_2.setText(R.string.spotify_amoled_05);
									sub_text_2.setText(R.string.installed_05);
									sub_text_4.setText(R.string.installed_05);
									sub_text_1.setText(R.string.latest_05);
									sub_text_3.setText(R.string.latest_05);
									version_switch_1.setText(R.string.versions_05);
									version_switch_2.setText(R.string.versions_05);
									changelogs.setText(R.string.changelogs_05);
									title_sub.setText(R.string.manager_tools_05);
									device_cpu.setText(R.string.device_cpu_05);
									source.setText(R.string.source_05);
									support.setText(R.string.support_05);
									donate.setText(R.string.donate_05);
									about.setText(R.string.about_05);
									list_auto_refresh.setText(R.string.list_auto_refresh_05);
									list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_05);
									force_auto_install.setText(R.string.force_auto_install_05);
									force_auto_install_info.setText(R.string.force_auto_install_desc_05);
									copy_url_mode.setText(R.string.copy_url_mode_05);
									copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_05);
									navigation_bar.setText(R.string.hide_navigation_bar_05);
									theme.setText(R.string.show_themes_05);
									apk_location.setText(R.string.apk_location_05);
									apk_location_info.setText(R.string.apk_location_desc_05);
									clear_directory_folders.setText(R.string.clear_directory_folders_05);
									clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_05);
									reset_settings.setText(R.string.reset_settings_05);
									sub_title.setText(R.string.about_sub_05);
									developer_manager.setText(R.string.xmanager_dev_05);
									developer_spotify.setText(R.string.spotify_mod_devs_05);
									support_team.setText(R.string.telegram_support_team_05);
									mod_testers_1.setText(R.string.manager_testers_05);
									mod_testers_2.setText(R.string.manager_hosting_05);
									mobilism_team.setText(R.string.mobilism_team_05);
									forum_team.setText(R.string.forum_team_05);
									manager_team.setText(R.string.xspotify_team_05);
									contributors_1.setText(R.string.contributors_05);
									download_selected.setText(R.string.download_selected_05);
									download_ready.setText(R.string.download_ready_05);
									download_ready_desc.setText(R.string.download_ready_desc_05);
									downloading_file.setText(R.string.downloading_file_05);
									download_success.setText(R.string.download_success_05);
									copy_url_desc.setText(R.string.copy_url_desc_05);
									file_directory.setText(R.string.file_directory_05);
									new_update.setText(R.string.new_update_05);
									download_selected_0 = download_selected.getText().toString();
									download_ready_0 = download_ready.getText().toString();
									download_ready_desc_0 = download_ready_desc.getText().toString();
									downloading_file_0 = downloading_file.getText().toString();
									download_success_0 = download_success.getText().toString();
									copy_url_desc_0 = copy_url_desc.getText().toString();
									file_directory_0 = file_directory.getText().toString();
									copy_url.setText(R.string.copy_url_05);
									continue_1.setText(R.string.continue_1_05);
									cancel.setText(R.string.cancel_05);
									download.setText(R.string.download_05);
									later.setText(R.string.later_05);
									directory.setText(R.string.directory_05);
									install_now.setText(R.string.install_now_05);
									install_update.setText(R.string.install_update_05);
									go_back.setText(R.string.go_back_05);
									download_update.setText(R.string.download_update_05);
									not_now.setText(R.string.not_now_05);
									show_support.setText(R.string.show_support_05);
									show_support_desc.setText(R.string.show_support_desc_05);
									copy_url_0 = copy_url.getText().toString();
									download_0 = download.getText().toString();
									continue_0 = continue_1.getText().toString();
									cancel_0 = cancel.getText().toString();
									later_0 = later.getText().toString();
									directory_0 = directory.getText().toString();
									install_now_0 = install_now.getText().toString();
									go_back_0 = go_back.getText().toString();
									install_update_0 = install_update.getText().toString();
									main_title.setText(R.string.main_title_05);
									settings_title.setText(R.string.settings_title_05);
									about_title.setText(R.string.about_title_05);
									maintenance.setText(R.string.maintenance_05);
									maintenance_desc.setText(R.string.maintenance_desc_05);
									thanks.setText(R.string.thanks_05);
									language.setText(R.string.language_05);
								  website.setText(R.string.website_05);
								
								discord.setText(R.string.discord_05);
								select_language.setSelection((int)(5));
							}
							else {
								if (LANGUAGE.getString("LANGUAGE", "").equals("6")) {
									    title_1.setText(R.string.spotify_regular_06);
										title_2.setText(R.string.spotify_amoled_06);
										sub_text_2.setText(R.string.installed_06);
										sub_text_4.setText(R.string.installed_06);
										sub_text_1.setText(R.string.latest_06);
										sub_text_3.setText(R.string.latest_06);
										version_switch_1.setText(R.string.versions_06);
										version_switch_2.setText(R.string.versions_06);
										changelogs.setText(R.string.changelogs_06);
										title_sub.setText(R.string.manager_tools_06);
										device_cpu.setText(R.string.device_cpu_06);
										source.setText(R.string.source_06);
										support.setText(R.string.support_06);
										donate.setText(R.string.donate_06);
										about.setText(R.string.about_06);
										list_auto_refresh.setText(R.string.list_auto_refresh_06);
										list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_06);
										force_auto_install.setText(R.string.force_auto_install_06);
										force_auto_install_info.setText(R.string.force_auto_install_desc_06);
										copy_url_mode.setText(R.string.copy_url_mode_06);
										copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_06);
										navigation_bar.setText(R.string.hide_navigation_bar_06);
										theme.setText(R.string.show_themes_06);
										apk_location.setText(R.string.apk_location_06);
										apk_location_info.setText(R.string.apk_location_desc_06);
										clear_directory_folders.setText(R.string.clear_directory_folders_06);
										clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_06);
										reset_settings.setText(R.string.reset_settings_06);
										sub_title.setText(R.string.about_sub_06);
										developer_manager.setText(R.string.xmanager_dev_06);
										developer_spotify.setText(R.string.spotify_mod_devs_06);
										support_team.setText(R.string.telegram_support_team_06);
										mod_testers_1.setText(R.string.manager_testers_06);
										mod_testers_2.setText(R.string.manager_hosting_06);
										mobilism_team.setText(R.string.mobilism_team_06);
										forum_team.setText(R.string.forum_team_06);
										manager_team.setText(R.string.xspotify_team_06);
										contributors_1.setText(R.string.contributors_06);
										download_selected.setText(R.string.download_selected_06);
										download_ready.setText(R.string.download_ready_06);
										download_ready_desc.setText(R.string.download_ready_desc_06);
										downloading_file.setText(R.string.downloading_file_06);
										download_success.setText(R.string.download_success_06);
										copy_url_desc.setText(R.string.copy_url_desc_06);
										file_directory.setText(R.string.file_directory_06);
										new_update.setText(R.string.new_update_06);
										download_selected_0 = download_selected.getText().toString();
										download_ready_0 = download_ready.getText().toString();
										download_ready_desc_0 = download_ready_desc.getText().toString();
										downloading_file_0 = downloading_file.getText().toString();
										download_success_0 = download_success.getText().toString();
										copy_url_desc_0 = copy_url_desc.getText().toString();
										file_directory_0 = file_directory.getText().toString();
										copy_url.setText(R.string.copy_url_06);
										continue_1.setText(R.string.continue_1_06);
										cancel.setText(R.string.cancel_06);
										download.setText(R.string.download_06);
										later.setText(R.string.later_06);
										directory.setText(R.string.directory_06);
										install_now.setText(R.string.install_now_06);
										install_update.setText(R.string.install_update_06);
										go_back.setText(R.string.go_back_06);
										download_update.setText(R.string.download_update_06);
										not_now.setText(R.string.not_now_06);
										show_support.setText(R.string.show_support_06);
										show_support_desc.setText(R.string.show_support_desc_06);
										copy_url_0 = copy_url.getText().toString();
										download_0 = download.getText().toString();
										continue_0 = continue_1.getText().toString();
										cancel_0 = cancel.getText().toString();
										later_0 = later.getText().toString();
										directory_0 = directory.getText().toString();
										install_now_0 = install_now.getText().toString();
										go_back_0 = go_back.getText().toString();
										install_update_0 = install_update.getText().toString();
										main_title.setText(R.string.main_title_06);
										settings_title.setText(R.string.settings_title_06);
										about_title.setText(R.string.about_title_06);
										maintenance.setText(R.string.maintenance_06);
										maintenance_desc.setText(R.string.maintenance_desc_06);
										thanks.setText(R.string.thanks_06);
										language.setText(R.string.language_06);
									  website.setText(R.string.website_06);
									
									discord.setText(R.string.discord_06);
									select_language.setSelection((int)(6));
								}
								else {
									if (LANGUAGE.getString("LANGUAGE", "").equals("7")) {
										    title_1.setText(R.string.spotify_regular_07);
											title_2.setText(R.string.spotify_amoled_07);
											sub_text_2.setText(R.string.installed_07);
											sub_text_4.setText(R.string.installed_07);
											sub_text_1.setText(R.string.latest_07);
											sub_text_3.setText(R.string.latest_07);
											version_switch_1.setText(R.string.versions_07);
											version_switch_2.setText(R.string.versions_07);
											changelogs.setText(R.string.changelogs_07);
											title_sub.setText(R.string.manager_tools_07);
											device_cpu.setText(R.string.device_cpu_07);
											source.setText(R.string.source_07);
											support.setText(R.string.support_07);
											donate.setText(R.string.donate_07);
											about.setText(R.string.about_07);
											list_auto_refresh.setText(R.string.list_auto_refresh_07);
											list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_07);
											force_auto_install.setText(R.string.force_auto_install_07);
											force_auto_install_info.setText(R.string.force_auto_install_desc_07);
											copy_url_mode.setText(R.string.copy_url_mode_07);
											copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_07);
											navigation_bar.setText(R.string.hide_navigation_bar_07);
											theme.setText(R.string.show_themes_07);
											apk_location.setText(R.string.apk_location_07);
											apk_location_info.setText(R.string.apk_location_desc_07);
											clear_directory_folders.setText(R.string.clear_directory_folders_07);
											clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_07);
											reset_settings.setText(R.string.reset_settings_07);
											sub_title.setText(R.string.about_sub_07);
											developer_manager.setText(R.string.xmanager_dev_07);
											developer_spotify.setText(R.string.spotify_mod_devs_07);
											support_team.setText(R.string.telegram_support_team_07);
											mod_testers_1.setText(R.string.manager_testers_07);
											mod_testers_2.setText(R.string.manager_hosting_07);
											mobilism_team.setText(R.string.mobilism_team_07);
											forum_team.setText(R.string.forum_team_07);
											manager_team.setText(R.string.xspotify_team_07);
											contributors_1.setText(R.string.contributors_07);
											download_selected.setText(R.string.download_selected_07);
											download_ready.setText(R.string.download_ready_07);
											download_ready_desc.setText(R.string.download_ready_desc_07);
											downloading_file.setText(R.string.downloading_file_07);
											download_success.setText(R.string.download_success_07);
											copy_url_desc.setText(R.string.copy_url_desc_07);
											file_directory.setText(R.string.file_directory_07);
											new_update.setText(R.string.new_update_07);
											download_selected_0 = download_selected.getText().toString();
											download_ready_0 = download_ready.getText().toString();
											download_ready_desc_0 = download_ready_desc.getText().toString();
											downloading_file_0 = downloading_file.getText().toString();
											download_success_0 = download_success.getText().toString();
											copy_url_desc_0 = copy_url_desc.getText().toString();
											file_directory_0 = file_directory.getText().toString();
											copy_url.setText(R.string.copy_url_07);
											continue_1.setText(R.string.continue_1_07);
											cancel.setText(R.string.cancel_07);
											download.setText(R.string.download_07);
											later.setText(R.string.later_07);
											directory.setText(R.string.directory_07);
											install_now.setText(R.string.install_now_07);
											install_update.setText(R.string.install_update_07);
											go_back.setText(R.string.go_back_07);
											download_update.setText(R.string.download_update_07);
											not_now.setText(R.string.not_now_07);
											show_support.setText(R.string.show_support_07);
											show_support_desc.setText(R.string.show_support_desc_07);
											copy_url_0 = copy_url.getText().toString();
											download_0 = download.getText().toString();
											continue_0 = continue_1.getText().toString();
											cancel_0 = cancel.getText().toString();
											later_0 = later.getText().toString();
											directory_0 = directory.getText().toString();
											install_now_0 = install_now.getText().toString();
											go_back_0 = go_back.getText().toString();
											install_update_0 = install_update.getText().toString();
											main_title.setText(R.string.main_title_07);
											settings_title.setText(R.string.settings_title_07);
											about_title.setText(R.string.about_title_07);
											maintenance.setText(R.string.maintenance_07);
											maintenance_desc.setText(R.string.maintenance_desc_07);
											thanks.setText(R.string.thanks_07);
											language.setText(R.string.language_07);
										  website.setText(R.string.website_07);
										
										discord.setText(R.string.discord_07);
										select_language.setSelection((int)(7));
									}
									else {
										if (LANGUAGE.getString("LANGUAGE", "").equals("8")) {
											    title_1.setText(R.string.spotify_regular_08);
												title_2.setText(R.string.spotify_amoled_08);
												sub_text_2.setText(R.string.installed_08);
												sub_text_4.setText(R.string.installed_08);
												sub_text_1.setText(R.string.latest_08);
												sub_text_3.setText(R.string.latest_08);
												version_switch_1.setText(R.string.versions_08);
												version_switch_2.setText(R.string.versions_08);
												changelogs.setText(R.string.changelogs_08);
												title_sub.setText(R.string.manager_tools_08);
												device_cpu.setText(R.string.device_cpu_08);
												source.setText(R.string.source_08);
												support.setText(R.string.support_08);
												donate.setText(R.string.donate_08);
												about.setText(R.string.about_08);
												list_auto_refresh.setText(R.string.list_auto_refresh_08);
												list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_08);
												force_auto_install.setText(R.string.force_auto_install_08);
												force_auto_install_info.setText(R.string.force_auto_install_desc_08);
												copy_url_mode.setText(R.string.copy_url_mode_08);
												copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_08);
												navigation_bar.setText(R.string.hide_navigation_bar_08);
												theme.setText(R.string.show_themes_08);
												apk_location.setText(R.string.apk_location_08);
												apk_location_info.setText(R.string.apk_location_desc_08);
												clear_directory_folders.setText(R.string.clear_directory_folders_08);
												clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_08);
												reset_settings.setText(R.string.reset_settings_08);
												sub_title.setText(R.string.about_sub_08);
												developer_manager.setText(R.string.xmanager_dev_08);
												developer_spotify.setText(R.string.spotify_mod_devs_08);
												support_team.setText(R.string.telegram_support_team_08);
												mod_testers_1.setText(R.string.manager_testers_08);
												mod_testers_2.setText(R.string.manager_hosting_08);
												mobilism_team.setText(R.string.mobilism_team_08);
												forum_team.setText(R.string.forum_team_08);
												manager_team.setText(R.string.xspotify_team_08);
												contributors_1.setText(R.string.contributors_08);
												download_selected.setText(R.string.download_selected_08);
												download_ready.setText(R.string.download_ready_08);
												download_ready_desc.setText(R.string.download_ready_desc_08);
												downloading_file.setText(R.string.downloading_file_08);
												download_success.setText(R.string.download_success_08);
												copy_url_desc.setText(R.string.copy_url_desc_08);
												file_directory.setText(R.string.file_directory_08);
												new_update.setText(R.string.new_update_08);
												download_selected_0 = download_selected.getText().toString();
												download_ready_0 = download_ready.getText().toString();
												download_ready_desc_0 = download_ready_desc.getText().toString();
												downloading_file_0 = downloading_file.getText().toString();
												download_success_0 = download_success.getText().toString();
												copy_url_desc_0 = copy_url_desc.getText().toString();
												file_directory_0 = file_directory.getText().toString();
												copy_url.setText(R.string.copy_url_08);
												continue_1.setText(R.string.continue_1_08);
												cancel.setText(R.string.cancel_08);
												download.setText(R.string.download_08);
												later.setText(R.string.later_08);
												directory.setText(R.string.directory_08);
												install_now.setText(R.string.install_now_08);
												install_update.setText(R.string.install_update_08);
												go_back.setText(R.string.go_back_08);
												download_update.setText(R.string.download_update_08);
												not_now.setText(R.string.not_now_08);
												show_support.setText(R.string.show_support_08);
												show_support_desc.setText(R.string.show_support_desc_08);
												copy_url_0 = copy_url.getText().toString();
												download_0 = download.getText().toString();
												continue_0 = continue_1.getText().toString();
												cancel_0 = cancel.getText().toString();
												later_0 = later.getText().toString();
												directory_0 = directory.getText().toString();
												install_now_0 = install_now.getText().toString();
												go_back_0 = go_back.getText().toString();
												install_update_0 = install_update.getText().toString();
												main_title.setText(R.string.main_title_08);
												settings_title.setText(R.string.settings_title_08);
												about_title.setText(R.string.about_title_08);
												maintenance.setText(R.string.maintenance_08);
												maintenance_desc.setText(R.string.maintenance_desc_08);
												thanks.setText(R.string.thanks_08);
												language.setText(R.string.language_08);
											  website.setText(R.string.website_08);
											
											discord.setText(R.string.discord_08);
											select_language.setSelection((int)(8));
										}
										else {
											if (LANGUAGE.getString("LANGUAGE", "").equals("9")) {
												    title_1.setText(R.string.spotify_regular_09);
													title_2.setText(R.string.spotify_amoled_09);
													sub_text_2.setText(R.string.installed_09);
													sub_text_4.setText(R.string.installed_09);
													sub_text_1.setText(R.string.latest_09);
													sub_text_3.setText(R.string.latest_09);
													version_switch_1.setText(R.string.versions_09);
													version_switch_2.setText(R.string.versions_09);
													changelogs.setText(R.string.changelogs_09);
													title_sub.setText(R.string.manager_tools_09);
													device_cpu.setText(R.string.device_cpu_09);
													source.setText(R.string.source_09);
													support.setText(R.string.support_09);
													donate.setText(R.string.donate_09);
													about.setText(R.string.about_09);
													list_auto_refresh.setText(R.string.list_auto_refresh_09);
													list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_09);
													force_auto_install.setText(R.string.force_auto_install_09);
													force_auto_install_info.setText(R.string.force_auto_install_desc_09);
													copy_url_mode.setText(R.string.copy_url_mode_09);
													copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_09);
													navigation_bar.setText(R.string.hide_navigation_bar_09);
													theme.setText(R.string.show_themes_09);
													apk_location.setText(R.string.apk_location_09);
													apk_location_info.setText(R.string.apk_location_desc_09);
													clear_directory_folders.setText(R.string.clear_directory_folders_09);
													clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_09);
													reset_settings.setText(R.string.reset_settings_09);
													sub_title.setText(R.string.about_sub_09);
													developer_manager.setText(R.string.xmanager_dev_09);
													developer_spotify.setText(R.string.spotify_mod_devs_09);
													support_team.setText(R.string.telegram_support_team_09);
													mod_testers_1.setText(R.string.manager_testers_09);
													mod_testers_2.setText(R.string.manager_hosting_09);
													mobilism_team.setText(R.string.mobilism_team_09);
													forum_team.setText(R.string.forum_team_09);
													manager_team.setText(R.string.xspotify_team_09);
													contributors_1.setText(R.string.contributors_09);
													download_selected.setText(R.string.download_selected_09);
													download_ready.setText(R.string.download_ready_09);
													download_ready_desc.setText(R.string.download_ready_desc_09);
													downloading_file.setText(R.string.downloading_file_09);
													download_success.setText(R.string.download_success_09);
													copy_url_desc.setText(R.string.copy_url_desc_09);
													file_directory.setText(R.string.file_directory_09);
													new_update.setText(R.string.new_update_09);
													download_selected_0 = download_selected.getText().toString();
													download_ready_0 = download_ready.getText().toString();
													download_ready_desc_0 = download_ready_desc.getText().toString();
													downloading_file_0 = downloading_file.getText().toString();
													download_success_0 = download_success.getText().toString();
													copy_url_desc_0 = copy_url_desc.getText().toString();
													file_directory_0 = file_directory.getText().toString();
													copy_url.setText(R.string.copy_url_09);
													continue_1.setText(R.string.continue_1_09);
													cancel.setText(R.string.cancel_09);
													download.setText(R.string.download_09);
													later.setText(R.string.later_09);
													directory.setText(R.string.directory_09);
													install_now.setText(R.string.install_now_09);
													install_update.setText(R.string.install_update_09);
													go_back.setText(R.string.go_back_09);
													download_update.setText(R.string.download_update_09);
													not_now.setText(R.string.not_now_09);
													show_support.setText(R.string.show_support_09);
													show_support_desc.setText(R.string.show_support_desc_09);
													copy_url_0 = copy_url.getText().toString();
													download_0 = download.getText().toString();
													continue_0 = continue_1.getText().toString();
													cancel_0 = cancel.getText().toString();
													later_0 = later.getText().toString();
													directory_0 = directory.getText().toString();
													install_now_0 = install_now.getText().toString();
													go_back_0 = go_back.getText().toString();
													install_update_0 = install_update.getText().toString();
													main_title.setText(R.string.main_title_09);
													settings_title.setText(R.string.settings_title_09);
													about_title.setText(R.string.about_title_09);
													maintenance.setText(R.string.maintenance_09);
													maintenance_desc.setText(R.string.maintenance_desc_09);
													thanks.setText(R.string.thanks_09);
													language.setText(R.string.language_09);
												  website.setText(R.string.website_09);
												
												discord.setText(R.string.discord_09);
												select_language.setSelection((int)(9));
											}
											else {
												if (LANGUAGE.getString("LANGUAGE", "").equals("10")) {
													    title_1.setText(R.string.spotify_regular_10);
														title_2.setText(R.string.spotify_amoled_10);
														sub_text_2.setText(R.string.installed_10);
														sub_text_4.setText(R.string.installed_10);
														sub_text_1.setText(R.string.latest_10);
														sub_text_3.setText(R.string.latest_10);
														version_switch_1.setText(R.string.versions_10);
														version_switch_2.setText(R.string.versions_10);
														changelogs.setText(R.string.changelogs_10);
														title_sub.setText(R.string.manager_tools_10);
														device_cpu.setText(R.string.device_cpu_10);
														source.setText(R.string.source_10);
														support.setText(R.string.support_10);
														donate.setText(R.string.donate_10);
														about.setText(R.string.about_10);
														list_auto_refresh.setText(R.string.list_auto_refresh_10);
														list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_10);
														force_auto_install.setText(R.string.force_auto_install_10);
														force_auto_install_info.setText(R.string.force_auto_install_desc_10);
														copy_url_mode.setText(R.string.copy_url_mode_10);
														copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_10);
														navigation_bar.setText(R.string.hide_navigation_bar_10);
														theme.setText(R.string.show_themes_10);
														apk_location.setText(R.string.apk_location_10);
														apk_location_info.setText(R.string.apk_location_desc_10);
														clear_directory_folders.setText(R.string.clear_directory_folders_10);
														clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_10);
														reset_settings.setText(R.string.reset_settings_10);
														sub_title.setText(R.string.about_sub_10);
														developer_manager.setText(R.string.xmanager_dev_10);
														developer_spotify.setText(R.string.spotify_mod_devs_10);
														support_team.setText(R.string.telegram_support_team_10);
														mod_testers_1.setText(R.string.manager_testers_10);
														mod_testers_2.setText(R.string.manager_hosting_10);
														mobilism_team.setText(R.string.mobilism_team_10);
														forum_team.setText(R.string.forum_team_10);
														manager_team.setText(R.string.xspotify_team_10);
														contributors_1.setText(R.string.contributors_10);
														download_selected.setText(R.string.download_selected_10);
														download_ready.setText(R.string.download_ready_10);
														download_ready_desc.setText(R.string.download_ready_desc_10);
														downloading_file.setText(R.string.downloading_file_10);
														download_success.setText(R.string.download_success_10);
														copy_url_desc.setText(R.string.copy_url_desc_10);
														file_directory.setText(R.string.file_directory_10);
														new_update.setText(R.string.new_update_10);
														download_selected_0 = download_selected.getText().toString();
														download_ready_0 = download_ready.getText().toString();
														download_ready_desc_0 = download_ready_desc.getText().toString();
														downloading_file_0 = downloading_file.getText().toString();
														download_success_0 = download_success.getText().toString();
														copy_url_desc_0 = copy_url_desc.getText().toString();
														file_directory_0 = file_directory.getText().toString();
														copy_url.setText(R.string.copy_url_10);
														continue_1.setText(R.string.continue_1_10);
														cancel.setText(R.string.cancel_10);
														download.setText(R.string.download_10);
														later.setText(R.string.later_10);
														directory.setText(R.string.directory_10);
														install_now.setText(R.string.install_now_10);
														install_update.setText(R.string.install_update_10);
														go_back.setText(R.string.go_back_10);
														download_update.setText(R.string.download_update_10);
														not_now.setText(R.string.not_now_10);
														show_support.setText(R.string.show_support_10);
														show_support_desc.setText(R.string.show_support_desc_10);
														copy_url_0 = copy_url.getText().toString();
														download_0 = download.getText().toString();
														continue_0 = continue_1.getText().toString();
														cancel_0 = cancel.getText().toString();
														later_0 = later.getText().toString();
														directory_0 = directory.getText().toString();
														install_now_0 = install_now.getText().toString();
														go_back_0 = go_back.getText().toString();
														install_update_0 = install_update.getText().toString();
														main_title.setText(R.string.main_title_10);
														settings_title.setText(R.string.settings_title_10);
														about_title.setText(R.string.about_title_10);
														maintenance.setText(R.string.maintenance_10);
														maintenance_desc.setText(R.string.maintenance_desc_10);
														thanks.setText(R.string.thanks_10);
														language.setText(R.string.language_10);
													  website.setText(R.string.website_10);
													
													discord.setText(R.string.discord_10);
													select_language.setSelection((int)(10));
												}
												else {
													if (LANGUAGE.getString("LANGUAGE", "").equals("11")) {
														    title_1.setText(R.string.spotify_regular_11);
															title_2.setText(R.string.spotify_amoled_11);
															sub_text_2.setText(R.string.installed_11);
															sub_text_4.setText(R.string.installed_11);
															sub_text_1.setText(R.string.latest_11);
															sub_text_3.setText(R.string.latest_11);
															version_switch_1.setText(R.string.versions_11);
															version_switch_2.setText(R.string.versions_11);
															changelogs.setText(R.string.changelogs_11);
															title_sub.setText(R.string.manager_tools_11);
															device_cpu.setText(R.string.device_cpu_11);
															source.setText(R.string.source_11);
															support.setText(R.string.support_11);
															donate.setText(R.string.donate_11);
															about.setText(R.string.about_11);
															list_auto_refresh.setText(R.string.list_auto_refresh_11);
															list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_11);
															force_auto_install.setText(R.string.force_auto_install_11);
															force_auto_install_info.setText(R.string.force_auto_install_desc_11);
															copy_url_mode.setText(R.string.copy_url_mode_11);
															copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_11);
															navigation_bar.setText(R.string.hide_navigation_bar_11);
															theme.setText(R.string.show_themes_11);
															apk_location.setText(R.string.apk_location_11);
															apk_location_info.setText(R.string.apk_location_desc_11);
															clear_directory_folders.setText(R.string.clear_directory_folders_11);
															clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_11);
															reset_settings.setText(R.string.reset_settings_11);
															sub_title.setText(R.string.about_sub_11);
															developer_manager.setText(R.string.xmanager_dev_11);
															developer_spotify.setText(R.string.spotify_mod_devs_11);
															support_team.setText(R.string.telegram_support_team_11);
															mod_testers_1.setText(R.string.manager_testers_11);
															mod_testers_2.setText(R.string.manager_hosting_11);
															mobilism_team.setText(R.string.mobilism_team_11);
															forum_team.setText(R.string.forum_team_11);
															manager_team.setText(R.string.xspotify_team_11);
															contributors_1.setText(R.string.contributors_11);
															download_selected.setText(R.string.download_selected_11);
															download_ready.setText(R.string.download_ready_11);
															download_ready_desc.setText(R.string.download_ready_desc_11);
															downloading_file.setText(R.string.downloading_file_11);
															download_success.setText(R.string.download_success_11);
															copy_url_desc.setText(R.string.copy_url_desc_11);
															file_directory.setText(R.string.file_directory_11);
															new_update.setText(R.string.new_update_11);
															download_selected_0 = download_selected.getText().toString();
															download_ready_0 = download_ready.getText().toString();
															download_ready_desc_0 = download_ready_desc.getText().toString();
															downloading_file_0 = downloading_file.getText().toString();
															download_success_0 = download_success.getText().toString();
															copy_url_desc_0 = copy_url_desc.getText().toString();
															file_directory_0 = file_directory.getText().toString();
															copy_url.setText(R.string.copy_url_11);
															continue_1.setText(R.string.continue_1_11);
															cancel.setText(R.string.cancel_11);
															download.setText(R.string.download_11);
															later.setText(R.string.later_11);
															directory.setText(R.string.directory_11);
															install_now.setText(R.string.install_now_11);
															install_update.setText(R.string.install_update_11);
															go_back.setText(R.string.go_back_11);
															download_update.setText(R.string.download_update_11);
															not_now.setText(R.string.not_now_11);
															show_support.setText(R.string.show_support_11);
															show_support_desc.setText(R.string.show_support_desc_11);
															copy_url_0 = copy_url.getText().toString();
															download_0 = download.getText().toString();
															continue_0 = continue_1.getText().toString();
															cancel_0 = cancel.getText().toString();
															later_0 = later.getText().toString();
															directory_0 = directory.getText().toString();
															install_now_0 = install_now.getText().toString();
															go_back_0 = go_back.getText().toString();
															install_update_0 = install_update.getText().toString();
															main_title.setText(R.string.main_title_11);
															settings_title.setText(R.string.settings_title_11);
															about_title.setText(R.string.about_title_11);
															maintenance.setText(R.string.maintenance_11);
															maintenance_desc.setText(R.string.maintenance_desc_11);
															thanks.setText(R.string.thanks_11);
															language.setText(R.string.language_11);
														  website.setText(R.string.website_11);
														
														discord.setText(R.string.discord_11);
														select_language.setSelection((int)(11));
													}
													else {
														if (LANGUAGE.getString("LANGUAGE", "").equals("12")) {
															    title_1.setText(R.string.spotify_regular_12);
																title_2.setText(R.string.spotify_amoled_12);
																sub_text_2.setText(R.string.installed_12);
																sub_text_4.setText(R.string.installed_12);
																sub_text_1.setText(R.string.latest_12);
																sub_text_3.setText(R.string.latest_12);
																version_switch_1.setText(R.string.versions_12);
																version_switch_2.setText(R.string.versions_12);
																changelogs.setText(R.string.changelogs_12);
																title_sub.setText(R.string.manager_tools_12);
																device_cpu.setText(R.string.device_cpu_12);
																source.setText(R.string.source_12);
																support.setText(R.string.support_12);
																donate.setText(R.string.donate_12);
																about.setText(R.string.about_12);
																list_auto_refresh.setText(R.string.list_auto_refresh_12);
																list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_12);
																force_auto_install.setText(R.string.force_auto_install_12);
																force_auto_install_info.setText(R.string.force_auto_install_desc_12);
																copy_url_mode.setText(R.string.copy_url_mode_12);
																copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_12);
																navigation_bar.setText(R.string.hide_navigation_bar_12);
																theme.setText(R.string.show_themes_12);
																apk_location.setText(R.string.apk_location_12);
																apk_location_info.setText(R.string.apk_location_desc_12);
																clear_directory_folders.setText(R.string.clear_directory_folders_12);
																clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_12);
																reset_settings.setText(R.string.reset_settings_12);
																sub_title.setText(R.string.about_sub_12);
																developer_manager.setText(R.string.xmanager_dev_12);
																developer_spotify.setText(R.string.spotify_mod_devs_12);
																support_team.setText(R.string.telegram_support_team_12);
																mod_testers_1.setText(R.string.manager_testers_12);
																mod_testers_2.setText(R.string.manager_hosting_12);
																mobilism_team.setText(R.string.mobilism_team_12);
																forum_team.setText(R.string.forum_team_12);
																manager_team.setText(R.string.xspotify_team_12);
																contributors_1.setText(R.string.contributors_12);
																download_selected.setText(R.string.download_selected_12);
																download_ready.setText(R.string.download_ready_12);
																download_ready_desc.setText(R.string.download_ready_desc_12);
																downloading_file.setText(R.string.downloading_file_12);
																download_success.setText(R.string.download_success_12);
																copy_url_desc.setText(R.string.copy_url_desc_12);
																file_directory.setText(R.string.file_directory_12);
																new_update.setText(R.string.new_update_12);
																download_selected_0 = download_selected.getText().toString();
																download_ready_0 = download_ready.getText().toString();
																download_ready_desc_0 = download_ready_desc.getText().toString();
																downloading_file_0 = downloading_file.getText().toString();
																download_success_0 = download_success.getText().toString();
																copy_url_desc_0 = copy_url_desc.getText().toString();
																file_directory_0 = file_directory.getText().toString();
																copy_url.setText(R.string.copy_url_12);
																continue_1.setText(R.string.continue_1_12);
																cancel.setText(R.string.cancel_12);
																download.setText(R.string.download_12);
																later.setText(R.string.later_12);
																directory.setText(R.string.directory_12);
																install_now.setText(R.string.install_now_12);
																install_update.setText(R.string.install_update_12);
																go_back.setText(R.string.go_back_12);
																download_update.setText(R.string.download_update_12);
																not_now.setText(R.string.not_now_12);
																show_support.setText(R.string.show_support_12);
																show_support_desc.setText(R.string.show_support_desc_12);
																copy_url_0 = copy_url.getText().toString();
																download_0 = download.getText().toString();
																continue_0 = continue_1.getText().toString();
																cancel_0 = cancel.getText().toString();
																later_0 = later.getText().toString();
																directory_0 = directory.getText().toString();
																install_now_0 = install_now.getText().toString();
																go_back_0 = go_back.getText().toString();
																install_update_0 = install_update.getText().toString();
																main_title.setText(R.string.main_title_12);
																settings_title.setText(R.string.settings_title_12);
																about_title.setText(R.string.about_title_12);
																maintenance.setText(R.string.maintenance_12);
																maintenance_desc.setText(R.string.maintenance_desc_12);
																thanks.setText(R.string.thanks_12);
																language.setText(R.string.language_12);
															  website.setText(R.string.website_12);
															
															discord.setText(R.string.discord_12);
															select_language.setSelection((int)(12));
														}
														else {
															if (LANGUAGE.getString("LANGUAGE", "").equals("13")) {
																    title_1.setText(R.string.spotify_regular_13);
																	title_2.setText(R.string.spotify_amoled_13);
																	sub_text_2.setText(R.string.installed_13);
																	sub_text_4.setText(R.string.installed_13);
																	sub_text_1.setText(R.string.latest_13);
																	sub_text_3.setText(R.string.latest_13);
																	version_switch_1.setText(R.string.versions_13);
																	version_switch_2.setText(R.string.versions_13);
																	changelogs.setText(R.string.changelogs_13);
																	title_sub.setText(R.string.manager_tools_13);
																	device_cpu.setText(R.string.device_cpu_13);
																	source.setText(R.string.source_13);
																	support.setText(R.string.support_13);
																	donate.setText(R.string.donate_13);
																	about.setText(R.string.about_13);
																	list_auto_refresh.setText(R.string.list_auto_refresh_13);
																	list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_13);
																	force_auto_install.setText(R.string.force_auto_install_13);
																	force_auto_install_info.setText(R.string.force_auto_install_desc_13);
																	copy_url_mode.setText(R.string.copy_url_mode_13);
																	copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_13);
																	navigation_bar.setText(R.string.hide_navigation_bar_13);
																	theme.setText(R.string.show_themes_13);
																	apk_location.setText(R.string.apk_location_13);
																	apk_location_info.setText(R.string.apk_location_desc_13);
																	clear_directory_folders.setText(R.string.clear_directory_folders_13);
																	clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_13);
																	reset_settings.setText(R.string.reset_settings_13);
																	sub_title.setText(R.string.about_sub_13);
																	developer_manager.setText(R.string.xmanager_dev_13);
																	developer_spotify.setText(R.string.spotify_mod_devs_13);
																	support_team.setText(R.string.telegram_support_team_13);
																	mod_testers_1.setText(R.string.manager_testers_13);
																	mod_testers_2.setText(R.string.manager_hosting_13);
																	mobilism_team.setText(R.string.mobilism_team_13);
																	forum_team.setText(R.string.forum_team_13);
																	manager_team.setText(R.string.xspotify_team_13);
																	contributors_1.setText(R.string.contributors_13);
																	download_selected.setText(R.string.download_selected_13);
																	download_ready.setText(R.string.download_ready_13);
																	download_ready_desc.setText(R.string.download_ready_desc_13);
																	downloading_file.setText(R.string.downloading_file_13);
																	download_success.setText(R.string.download_success_13);
																	copy_url_desc.setText(R.string.copy_url_desc_13);
																	file_directory.setText(R.string.file_directory_13);
																	new_update.setText(R.string.new_update_13);
																	download_selected_0 = download_selected.getText().toString();
																	download_ready_0 = download_ready.getText().toString();
																	download_ready_desc_0 = download_ready_desc.getText().toString();
																	downloading_file_0 = downloading_file.getText().toString();
																	download_success_0 = download_success.getText().toString();
																	copy_url_desc_0 = copy_url_desc.getText().toString();
																	file_directory_0 = file_directory.getText().toString();
																	copy_url.setText(R.string.copy_url_13);
																	continue_1.setText(R.string.continue_1_13);
																	cancel.setText(R.string.cancel_13);
																	download.setText(R.string.download_13);
																	later.setText(R.string.later_13);
																	directory.setText(R.string.directory_13);
																	install_now.setText(R.string.install_now_13);
																	install_update.setText(R.string.install_update_13);
																	go_back.setText(R.string.go_back_13);
																	download_update.setText(R.string.download_update_13);
																	not_now.setText(R.string.not_now_13);
																	show_support.setText(R.string.show_support_13);
																	show_support_desc.setText(R.string.show_support_desc_13);
																	copy_url_0 = copy_url.getText().toString();
																	download_0 = download.getText().toString();
																	continue_0 = continue_1.getText().toString();
																	cancel_0 = cancel.getText().toString();
																	later_0 = later.getText().toString();
																	directory_0 = directory.getText().toString();
																	install_now_0 = install_now.getText().toString();
																	go_back_0 = go_back.getText().toString();
																	install_update_0 = install_update.getText().toString();
																	main_title.setText(R.string.main_title_13);
																	settings_title.setText(R.string.settings_title_13);
																	about_title.setText(R.string.about_title_13);
																	maintenance.setText(R.string.maintenance_13);
																	maintenance_desc.setText(R.string.maintenance_desc_13);
																	thanks.setText(R.string.thanks_13);
																	language.setText(R.string.language_13);
																  website.setText(R.string.website_13);
																
																discord.setText(R.string.discord_13);
																select_language.setSelection((int)(13));
															}
															else {
																if (LANGUAGE.getString("LANGUAGE", "").equals("14")) {
																	    title_1.setText(R.string.spotify_regular_14);
																		title_2.setText(R.string.spotify_amoled_14);
																		sub_text_2.setText(R.string.installed_14);
																		sub_text_4.setText(R.string.installed_14);
																		sub_text_1.setText(R.string.latest_14);
																		sub_text_3.setText(R.string.latest_14);
																		version_switch_1.setText(R.string.versions_14);
																		version_switch_2.setText(R.string.versions_14);
																		changelogs.setText(R.string.changelogs_14);
																		title_sub.setText(R.string.manager_tools_14);
																		device_cpu.setText(R.string.device_cpu_14);
																		source.setText(R.string.source_14);
																		support.setText(R.string.support_14);
																		donate.setText(R.string.donate_14);
																		about.setText(R.string.about_14);
																		list_auto_refresh.setText(R.string.list_auto_refresh_14);
																		list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_14);
																		force_auto_install.setText(R.string.force_auto_install_14);
																		force_auto_install_info.setText(R.string.force_auto_install_desc_14);
																		copy_url_mode.setText(R.string.copy_url_mode_14);
																		copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_14);
																		navigation_bar.setText(R.string.hide_navigation_bar_14);
																		theme.setText(R.string.show_themes_14);
																		apk_location.setText(R.string.apk_location_14);
																		apk_location_info.setText(R.string.apk_location_desc_14);
																		clear_directory_folders.setText(R.string.clear_directory_folders_14);
																		clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_14);
																		reset_settings.setText(R.string.reset_settings_14);
																		sub_title.setText(R.string.about_sub_14);
																		developer_manager.setText(R.string.xmanager_dev_14);
																		developer_spotify.setText(R.string.spotify_mod_devs_14);
																		support_team.setText(R.string.telegram_support_team_14);
																		mod_testers_1.setText(R.string.manager_testers_14);
																		mod_testers_2.setText(R.string.manager_hosting_14);
																		mobilism_team.setText(R.string.mobilism_team_14);
																		forum_team.setText(R.string.forum_team_14);
																		manager_team.setText(R.string.xspotify_team_14);
																		contributors_1.setText(R.string.contributors_14);
																		download_selected.setText(R.string.download_selected_14);
																		download_ready.setText(R.string.download_ready_14);
																		download_ready_desc.setText(R.string.download_ready_desc_14);
																		downloading_file.setText(R.string.downloading_file_14);
																		download_success.setText(R.string.download_success_14);
																		copy_url_desc.setText(R.string.copy_url_desc_14);
																		file_directory.setText(R.string.file_directory_14);
																		new_update.setText(R.string.new_update_14);
																		download_selected_0 = download_selected.getText().toString();
																		download_ready_0 = download_ready.getText().toString();
																		download_ready_desc_0 = download_ready_desc.getText().toString();
																		downloading_file_0 = downloading_file.getText().toString();
																		download_success_0 = download_success.getText().toString();
																		copy_url_desc_0 = copy_url_desc.getText().toString();
																		file_directory_0 = file_directory.getText().toString();
																		copy_url.setText(R.string.copy_url_14);
																		continue_1.setText(R.string.continue_1_14);
																		cancel.setText(R.string.cancel_14);
																		download.setText(R.string.download_14);
																		later.setText(R.string.later_14);
																		directory.setText(R.string.directory_14);
																		install_now.setText(R.string.install_now_14);
																		install_update.setText(R.string.install_update_14);
																		go_back.setText(R.string.go_back_14);
																		download_update.setText(R.string.download_update_14);
																		not_now.setText(R.string.not_now_14);
																		show_support.setText(R.string.show_support_14);
																		show_support_desc.setText(R.string.show_support_desc_14);
																		copy_url_0 = copy_url.getText().toString();
																		download_0 = download.getText().toString();
																		continue_0 = continue_1.getText().toString();
																		cancel_0 = cancel.getText().toString();
																		later_0 = later.getText().toString();
																		directory_0 = directory.getText().toString();
																		install_now_0 = install_now.getText().toString();
																		go_back_0 = go_back.getText().toString();
																		install_update_0 = install_update.getText().toString();
																		main_title.setText(R.string.main_title_14);
																		settings_title.setText(R.string.settings_title_14);
																		about_title.setText(R.string.about_title_14);
																		maintenance.setText(R.string.maintenance_14);
																		maintenance_desc.setText(R.string.maintenance_desc_14);
																		thanks.setText(R.string.thanks_14);
																		language.setText(R.string.language_14);
																	  website.setText(R.string.website_14);
																	
																	discord.setText(R.string.discord_14);
																	select_language.setSelection((int)(14));
																}
																else {
																	if (LANGUAGE.getString("LANGUAGE", "").equals("15")) {
																		    title_1.setText(R.string.spotify_regular_15);
																			title_2.setText(R.string.spotify_amoled_15);
																			sub_text_2.setText(R.string.installed_15);
																			sub_text_4.setText(R.string.installed_15);
																			sub_text_1.setText(R.string.latest_15);
																			sub_text_3.setText(R.string.latest_15);
																			version_switch_1.setText(R.string.versions_15);
																			version_switch_2.setText(R.string.versions_15);
																			changelogs.setText(R.string.changelogs_15);
																			title_sub.setText(R.string.manager_tools_15);
																			device_cpu.setText(R.string.device_cpu_15);
																			source.setText(R.string.source_15);
																			support.setText(R.string.support_15);
																			donate.setText(R.string.donate_15);
																			about.setText(R.string.about_15);
																			list_auto_refresh.setText(R.string.list_auto_refresh_15);
																			list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_15);
																			force_auto_install.setText(R.string.force_auto_install_15);
																			force_auto_install_info.setText(R.string.force_auto_install_desc_15);
																			copy_url_mode.setText(R.string.copy_url_mode_15);
																			copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_15);
																			navigation_bar.setText(R.string.hide_navigation_bar_15);
																			theme.setText(R.string.show_themes_15);
																			apk_location.setText(R.string.apk_location_15);
																			apk_location_info.setText(R.string.apk_location_desc_15);
																			clear_directory_folders.setText(R.string.clear_directory_folders_15);
																			clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_15);
																			reset_settings.setText(R.string.reset_settings_15);
																			sub_title.setText(R.string.about_sub_15);
																			developer_manager.setText(R.string.xmanager_dev_15);
																			developer_spotify.setText(R.string.spotify_mod_devs_15);
																			support_team.setText(R.string.telegram_support_team_15);
																			mod_testers_1.setText(R.string.manager_testers_15);
																			mod_testers_2.setText(R.string.manager_hosting_15);
																			mobilism_team.setText(R.string.mobilism_team_15);
																			forum_team.setText(R.string.forum_team_15);
																			manager_team.setText(R.string.xspotify_team_15);
																			contributors_1.setText(R.string.contributors_15);
																			download_selected.setText(R.string.download_selected_15);
																			download_ready.setText(R.string.download_ready_15);
																			download_ready_desc.setText(R.string.download_ready_desc_15);
																			downloading_file.setText(R.string.downloading_file_15);
																			download_success.setText(R.string.download_success_15);
																			copy_url_desc.setText(R.string.copy_url_desc_15);
																			file_directory.setText(R.string.file_directory_15);
																			new_update.setText(R.string.new_update_15);
																			download_selected_0 = download_selected.getText().toString();
																			download_ready_0 = download_ready.getText().toString();
																			download_ready_desc_0 = download_ready_desc.getText().toString();
																			downloading_file_0 = downloading_file.getText().toString();
																			download_success_0 = download_success.getText().toString();
																			copy_url_desc_0 = copy_url_desc.getText().toString();
																			file_directory_0 = file_directory.getText().toString();
																			copy_url.setText(R.string.copy_url_15);
																			continue_1.setText(R.string.continue_1_15);
																			cancel.setText(R.string.cancel_15);
																			download.setText(R.string.download_15);
																			later.setText(R.string.later_15);
																			directory.setText(R.string.directory_15);
																			install_now.setText(R.string.install_now_15);
																			install_update.setText(R.string.install_update_15);
																			go_back.setText(R.string.go_back_15);
																			download_update.setText(R.string.download_update_15);
																			not_now.setText(R.string.not_now_15);
																			show_support.setText(R.string.show_support_15);
																			show_support_desc.setText(R.string.show_support_desc_15);
																			copy_url_0 = copy_url.getText().toString();
																			download_0 = download.getText().toString();
																			continue_0 = continue_1.getText().toString();
																			cancel_0 = cancel.getText().toString();
																			later_0 = later.getText().toString();
																			directory_0 = directory.getText().toString();
																			install_now_0 = install_now.getText().toString();
																			go_back_0 = go_back.getText().toString();
																			install_update_0 = install_update.getText().toString();
																			main_title.setText(R.string.main_title_15);
																			settings_title.setText(R.string.settings_title_15);
																			about_title.setText(R.string.about_title_15);
																			maintenance.setText(R.string.maintenance_15);
																			maintenance_desc.setText(R.string.maintenance_desc_15);
																			thanks.setText(R.string.thanks_15);
																			language.setText(R.string.language_15);
																		  website.setText(R.string.website_15);
																		
																		discord.setText(R.string.discord_15);
																		select_language.setSelection((int)(15));
																	}
																	else {
																		if (LANGUAGE.getString("LANGUAGE", "").equals("16")) {
																			    title_1.setText(R.string.spotify_regular_16);
																				title_2.setText(R.string.spotify_amoled_16);
																				sub_text_2.setText(R.string.installed_16);
																				sub_text_4.setText(R.string.installed_16);
																				sub_text_1.setText(R.string.latest_16);
																				sub_text_3.setText(R.string.latest_16);
																				version_switch_1.setText(R.string.versions_16);
																				version_switch_2.setText(R.string.versions_16);
																				changelogs.setText(R.string.changelogs_16);
																				title_sub.setText(R.string.manager_tools_16);
																				device_cpu.setText(R.string.device_cpu_16);
																				source.setText(R.string.source_16);
																				support.setText(R.string.support_16);
																				donate.setText(R.string.donate_16);
																				about.setText(R.string.about_16);
																				list_auto_refresh.setText(R.string.list_auto_refresh_16);
																				list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_16);
																				force_auto_install.setText(R.string.force_auto_install_16);
																				force_auto_install_info.setText(R.string.force_auto_install_desc_16);
																				copy_url_mode.setText(R.string.copy_url_mode_16);
																				copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_16);
																				navigation_bar.setText(R.string.hide_navigation_bar_16);
																				theme.setText(R.string.show_themes_16);
																				apk_location.setText(R.string.apk_location_16);
																				apk_location_info.setText(R.string.apk_location_desc_16);
																				clear_directory_folders.setText(R.string.clear_directory_folders_16);
																				clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_16);
																				reset_settings.setText(R.string.reset_settings_16);
																				sub_title.setText(R.string.about_sub_16);
																				developer_manager.setText(R.string.xmanager_dev_16);
																				developer_spotify.setText(R.string.spotify_mod_devs_16);
																				support_team.setText(R.string.telegram_support_team_16);
																				mod_testers_1.setText(R.string.manager_testers_16);
																				mod_testers_2.setText(R.string.manager_hosting_16);
																				mobilism_team.setText(R.string.mobilism_team_16);
																				forum_team.setText(R.string.forum_team_16);
																				manager_team.setText(R.string.xspotify_team_16);
																				contributors_1.setText(R.string.contributors_16);
																				download_selected.setText(R.string.download_selected_16);
																				download_ready.setText(R.string.download_ready_16);
																				download_ready_desc.setText(R.string.download_ready_desc_16);
																				downloading_file.setText(R.string.downloading_file_16);
																				download_success.setText(R.string.download_success_16);
																				copy_url_desc.setText(R.string.copy_url_desc_16);
																				file_directory.setText(R.string.file_directory_16);
																				new_update.setText(R.string.new_update_16);
																				download_selected_0 = download_selected.getText().toString();
																				download_ready_0 = download_ready.getText().toString();
																				download_ready_desc_0 = download_ready_desc.getText().toString();
																				downloading_file_0 = downloading_file.getText().toString();
																				download_success_0 = download_success.getText().toString();
																				copy_url_desc_0 = copy_url_desc.getText().toString();
																				file_directory_0 = file_directory.getText().toString();
																				copy_url.setText(R.string.copy_url_16);
																				continue_1.setText(R.string.continue_1_16);
																				cancel.setText(R.string.cancel_16);
																				download.setText(R.string.download_16);
																				later.setText(R.string.later_16);
																				directory.setText(R.string.directory_16);
																				install_now.setText(R.string.install_now_16);
																				install_update.setText(R.string.install_update_16);
																				go_back.setText(R.string.go_back_16);
																				download_update.setText(R.string.download_update_16);
																				not_now.setText(R.string.not_now_16);
																				show_support.setText(R.string.show_support_16);
																				show_support_desc.setText(R.string.show_support_desc_16);
																				copy_url_0 = copy_url.getText().toString();
																				download_0 = download.getText().toString();
																				continue_0 = continue_1.getText().toString();
																				cancel_0 = cancel.getText().toString();
																				later_0 = later.getText().toString();
																				directory_0 = directory.getText().toString();
																				install_now_0 = install_now.getText().toString();
																				go_back_0 = go_back.getText().toString();
																				install_update_0 = install_update.getText().toString();
																				main_title.setText(R.string.main_title_16);
																				settings_title.setText(R.string.settings_title_16);
																				about_title.setText(R.string.about_title_16);
																				maintenance.setText(R.string.maintenance_16);
																				maintenance_desc.setText(R.string.maintenance_desc_16);
																				thanks.setText(R.string.thanks_16);
																				language.setText(R.string.language_16);
																			  website.setText(R.string.website_16);
																			
																			discord.setText(R.string.discord_16);
																			select_language.setSelection((int)(16));
																		}
																		else {
																			if (LANGUAGE.getString("LANGUAGE", "").equals("17")) {
																				    title_1.setText(R.string.spotify_regular_17);
																					title_2.setText(R.string.spotify_amoled_17);
																					sub_text_2.setText(R.string.installed_17);
																					sub_text_4.setText(R.string.installed_17);
																					sub_text_1.setText(R.string.latest_17);
																					sub_text_3.setText(R.string.latest_17);
																					version_switch_1.setText(R.string.versions_17);
																					version_switch_2.setText(R.string.versions_17);
																					changelogs.setText(R.string.changelogs_17);
																					title_sub.setText(R.string.manager_tools_17);
																					device_cpu.setText(R.string.device_cpu_17);
																					source.setText(R.string.source_17);
																					support.setText(R.string.support_17);
																					donate.setText(R.string.donate_17);
																					about.setText(R.string.about_17);
																					list_auto_refresh.setText(R.string.list_auto_refresh_17);
																					list_auto_refresh_info.setText(R.string.list_auto_refresh_desc_17);
																					force_auto_install.setText(R.string.force_auto_install_17);
																					force_auto_install_info.setText(R.string.force_auto_install_desc_17);
																					copy_url_mode.setText(R.string.copy_url_mode_17);
																					copy_file_url_mode_info.setText(R.string.copy_url_mode_desc_17);
																					navigation_bar.setText(R.string.hide_navigation_bar_17);
																					theme.setText(R.string.show_themes_17);
																					apk_location.setText(R.string.apk_location_17);
																					apk_location_info.setText(R.string.apk_location_desc_17);
																					clear_directory_folders.setText(R.string.clear_directory_folders_17);
																					clear_directory_folders_info.setText(R.string.clear_directory_folders_desc_17);
																					reset_settings.setText(R.string.reset_settings_17);
																					sub_title.setText(R.string.about_sub_17);
																					developer_manager.setText(R.string.xmanager_dev_17);
																					developer_spotify.setText(R.string.spotify_mod_devs_17);
																					support_team.setText(R.string.telegram_support_team_17);
																					mod_testers_1.setText(R.string.manager_testers_17);
																					mod_testers_2.setText(R.string.manager_hosting_17);
																					mobilism_team.setText(R.string.mobilism_team_17);
																					forum_team.setText(R.string.forum_team_17);
																					manager_team.setText(R.string.xspotify_team_17);
																					contributors_1.setText(R.string.contributors_17);
																					download_selected.setText(R.string.download_selected_17);
																					download_ready.setText(R.string.download_ready_17);
																					download_ready_desc.setText(R.string.download_ready_desc_17);
																					downloading_file.setText(R.string.downloading_file_17);
																					download_success.setText(R.string.download_success_17);
																					copy_url_desc.setText(R.string.copy_url_desc_17);
																					file_directory.setText(R.string.file_directory_17);
																					new_update.setText(R.string.new_update_17);
																					download_selected_0 = download_selected.getText().toString();
																					download_ready_0 = download_ready.getText().toString();
																					download_ready_desc_0 = download_ready_desc.getText().toString();
																					downloading_file_0 = downloading_file.getText().toString();
																					download_success_0 = download_success.getText().toString();
																					copy_url_desc_0 = copy_url_desc.getText().toString();
																					file_directory_0 = file_directory.getText().toString();
																					copy_url.setText(R.string.copy_url_17);
																					continue_1.setText(R.string.continue_1_17);
																					cancel.setText(R.string.cancel_17);
																					download.setText(R.string.download_17);
																					later.setText(R.string.later_17);
																					directory.setText(R.string.directory_17);
																					install_now.setText(R.string.install_now_17);
																					install_update.setText(R.string.install_update_17);
																					go_back.setText(R.string.go_back_17);
																					download_update.setText(R.string.download_update_17);
																					not_now.setText(R.string.not_now_17);
																					show_support.setText(R.string.show_support_17);
																					show_support_desc.setText(R.string.show_support_desc_17);
																					copy_url_0 = copy_url.getText().toString();
																					download_0 = download.getText().toString();
																					continue_0 = continue_1.getText().toString();
																					cancel_0 = cancel.getText().toString();
																					later_0 = later.getText().toString();
																					directory_0 = directory.getText().toString();
																					install_now_0 = install_now.getText().toString();
																					go_back_0 = go_back.getText().toString();
																					install_update_0 = install_update.getText().toString();
																					main_title.setText(R.string.main_title_17);
																					settings_title.setText(R.string.settings_title_17);
																					about_title.setText(R.string.about_title_17);
																					maintenance.setText(R.string.maintenance_17);
																					maintenance_desc.setText(R.string.maintenance_desc_17);
																					thanks.setText(R.string.thanks_17);
																					language.setText(R.string.language_17);
																				    website.setText(R.string.website_17);
																				    discord.setText(R.string.discord_17);
																				select_language.setSelection((int)(17));
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
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _Language_Pack () {
		Language.add("English (Default)");
		Language.add("Bengali");
		Language.add("Chinese (Simplified)");
		Language.add("French");
		Language.add("Greek");
		Language.add("Indonesian");
		Language.add("Italian");
		Language.add("Polish");
		Language.add("Portuguese (Brazil)");
		Language.add("Portuguese (Portugal)");
		Language.add("Russian");
		Language.add("Spanish");
		Language.add("Ukranian");
		Language.add("Turkish");
		Language.add("Arabic");
		Language.add("Slovenian");
		Language.add("Romanian");
		Language.add("Korean");
		select_language.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Language));
		((ArrayAdapter)select_language.getAdapter()).notifyDataSetChanged();
		select_language.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, Language) {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView textViewv = (TextView) super.getView(position, convertView, parent);
				textViewv.setTextColor(Color.parseColor("#FFFFFF"));
				return textViewv; }
			
			@Override
			public View getDropDownView(int position, View convertView, ViewGroup parent) {
				TextView textViewv = (TextView) super.getDropDownView(position, convertView, parent); textViewv.setTextColor(Color.parseColor("#FFFFFF"));
				textViewv.setBackgroundColor(Color.parseColor("#212121"));
				
				
				return textViewv; }
		});
	}
	
	
	private void _Theme_Pack () {
		Theme.add("Black (Default)");
		Theme.add("Green");
		Theme.add("Purple");
		Theme.add("Red");
		Theme.add("Blue");
		Theme.add("Orange");
		Theme.add("Yellow");
		Theme.add("Grey");
		Theme.add("Blue Grey");
		Theme.add("Pink");
		Theme.add("Cyan");
		select_theme.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Theme));
		((ArrayAdapter)select_theme.getAdapter()).notifyDataSetChanged();
		select_theme.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, Theme) {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView textViewv = (TextView) super.getView(position, convertView, parent);
				textViewv.setTextColor(Color.parseColor("#FFFFFF"));
				return textViewv; }
			
			@Override
			public View getDropDownView(int position, View convertView, ViewGroup parent) {
				TextView textViewv = (TextView) super.getDropDownView(position, convertView, parent); textViewv.setTextColor(Color.parseColor("#FFFFFF"));
				textViewv.setBackgroundColor(Color.parseColor("#212121"));
				
				
				return textViewv; }
		});
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
				if (_position < 2) {
					title.setText(title.getText().toString().replace("(Armeabi.v7a)", "(Armeabi-v7a)").replace("(Arm64.v8a)", "(Arm64-v8a)"));
					title.setText(title.getText().toString().replace("Spotify v", "[LATEST] "));
					title.setTextColor(0xFFFF1744);
				}
				else {
					title.setText(title.getText().toString().replace("(Armeabi.v7a)", "(Armeabi-v7a)").replace("(Arm64.v8a)", "(Arm64-v8a)"));
					title.setText(title.getText().toString().replace("Spotify v", "[OLDER] "));
					title.setTextColor(0xFFBDBDBD);
				}
				title.setText(title.getText().toString().toUpperCase());
				title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
				if (_position == 0) {
					VERSIONS_REGULAR = listdata.get((int)(listdata.size() - 1) - _position).get("title").toString().replace("-", ".").replace("Spotify v", " ").replace("(Armeabi.v7a)", " ").replace("(Arm64.v8a)", " ");
				}
				box.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						if (COPY_URL_MODE.getString("COPY_URL_MODE", "").equals("URL_ON")) {
							_RequiredDialog(Selected_Spotify, false);
							Selected_Spotify.setTitle(title.getText().toString().toUpperCase().replace("SPOTIFY V", "SPOTIFY "));
							Selected_Spotify.setMessage(copy_url_desc_0);
							Selected_Spotify.setPositiveButton(copy_url_0, new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									try {
										_RequiredDialog(Selected_Spotify, true);
										((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", link.getText().toString()));
										
									}
									catch(Exception e) {
									}
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
							Selected_Spotify.setNeutralButton(cancel_0, new DialogInterface.OnClickListener() {
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
							DELETE = 1;
						}
						else {
							if (COPY_URL_MODE.getString("COPY_URL_MODE", "").equals("URL_OFF")) {
								_RequiredDialog(Selected_Spotify, false);
								Selected_Spotify.setTitle(title.getText().toString().toUpperCase().replace("SPOTIFY V", "SPOTIFY "));
								Selected_Spotify.setMessage(download_selected_0);
								Selected_Spotify.setPositiveButton(continue_0, new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										_RequiredDialog(Selected_Spotify, true);
										_RequiredDialog(Download_Spotify, false);
										Download_Spotify.setTitle(download_ready_0);
										Download_Spotify.setMessage(download_ready_desc_0);
										Download_Spotify.setPositiveButton(download_0, new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												try {
													_RequiredDialog(Download_Spotify, true);
													if (FORCE_INSTALL.getString("FORCE_INSTALL", "").equals("X")) {
														_Download_Install(link.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/");
													}
													else {
														if (FORCE_INSTALL.getString("FORCE_INSTALL", "").equals("Y")) {
															_Download(link.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/");
														}
													}
													_File_Remover();
												}
												catch(Exception e) {
												}
											}
										});
										Download_Spotify.setNeutralButton(cancel_0, new DialogInterface.OnClickListener() {
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
								Selected_Spotify.setNeutralButton(cancel_0, new DialogInterface.OnClickListener() {
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
								DELETE = 1;
							}
						}
					}
				});
				Animation animation;
				animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
				animation.setDuration(200); box.startAnimation(animation);
				animation = null;
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
				if (_position < 2) {
					title.setText(title.getText().toString().replace("(Armeabi.v7a)", "(Armeabi-v7a)").replace("(Arm64.v8a)", "(Arm64-v8a)"));
					title.setText(title.getText().toString().replace("Spotify v", "[LATEST] "));
					title.setTextColor(0xFFFF1744);
				}
				else {
					title.setText(title.getText().toString().replace("(Armeabi.v7a)", "(Armeabi-v7a)").replace("(Arm64.v8a)", "(Arm64-v8a)"));
					title.setText(title.getText().toString().replace("Spotify v", "[OLDER] "));
					title.setTextColor(0xFFBDBDBD);
				}
				title.setText(title.getText().toString().toUpperCase());
				title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/base_font.ttf"), 1);
				if (_position == 0) {
					VERSIONS_AMOLED = listdata.get((int)(listdata.size() - 1) - _position).get("title").toString().replace("-", ".").replace("Spotify v", " ").replace("(Armeabi.v7a)", " ").replace("(Arm64.v8a)", " ");
				}
				box.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						if (COPY_URL_MODE.getString("COPY_URL_MODE", "").equals("URL_ON")) {
							_RequiredDialog(Selected_Spotify, false);
							Selected_Spotify.setTitle(title.getText().toString().toUpperCase().replace("SPOTIFY V", "SPOTIFY "));
							Selected_Spotify.setMessage(copy_url_desc_0);
							Selected_Spotify.setPositiveButton(copy_url_0, new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									try {
										_RequiredDialog(Selected_Spotify, true);
										((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", link.getText().toString()));
										
									}
									catch(Exception e) {
									}
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
							Selected_Spotify.setNeutralButton(cancel_0, new DialogInterface.OnClickListener() {
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
							DELETE = 1;
						}
						else {
							if (COPY_URL_MODE.getString("COPY_URL_MODE", "").equals("URL_OFF")) {
								_RequiredDialog(Selected_Spotify, false);
								Selected_Spotify.setTitle(title.getText().toString().toUpperCase().replace("SPOTIFY V", "SPOTIFY "));
								Selected_Spotify.setMessage(download_selected_0);
								Selected_Spotify.setPositiveButton(continue_0, new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										_RequiredDialog(Selected_Spotify, true);
										_RequiredDialog(Download_Spotify, false);
										Download_Spotify.setTitle(download_ready_0);
										Download_Spotify.setMessage(download_ready_desc_0);
										Download_Spotify.setPositiveButton(download_0, new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												try {
													_RequiredDialog(Download_Spotify, true);
													if (FORCE_INSTALL.getString("FORCE_INSTALL", "").equals("X")) {
														_Download_Install(link.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/");
													}
													else {
														if (FORCE_INSTALL.getString("FORCE_INSTALL", "").equals("Y")) {
															_Download(link.getText().toString(), "/storage/emulated/0/Android/data/com.xc3fff0e.xmanager/files/Download/");
														}
													}
													_File_Remover();
												}
												catch(Exception e) {
												}
											}
										});
										Download_Spotify.setNeutralButton(cancel_0, new DialogInterface.OnClickListener() {
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
								Selected_Spotify.setNeutralButton(cancel_0, new DialogInterface.OnClickListener() {
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
								DELETE = 1;
							}
						}
					}
				});
				Animation animation;
				animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
				animation.setDuration(200); box.startAnimation(animation);
				animation = null;
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
