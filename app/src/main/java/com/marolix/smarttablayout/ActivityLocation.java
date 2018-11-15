package com.marolix.smarttablayout;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLng;
import com.marolix.smarttablayout.app.Config;
import com.marolix.smarttablayout.apphelper.AppConstant;
import com.marolix.smarttablayout.apphelper.AppShare;
import com.marolix.smarttablayout.customui.RecyclerViewEmptySupport;
import com.marolix.smarttablayout.gpshelper.GPSTracker;
import com.marolix.smarttablayout.gpshelper.ObservableObject;
import com.marolix.smarttablayout.model.LocationSerachModel;
import com.marolix.smarttablayout.model.StoreListModelNew;
import com.marolix.smarttablayout.utils.FontUtils;
import com.marolix.smarttablayout.utils.NotificationUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

public class ActivityLocation extends AppCompatActivity
        implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        Observer {

    private static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 200;
    private static final int GPS_ON_ACTION = 202;
    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 201;
    GPSTracker gpsTracker = null;
    LocationManager locationManager;
    String provider;
    List<StoreListModelNew> storeList = new ArrayList<StoreListModelNew>();
    private EditText txtSearchArea;
    private LinearLayout layoutCurrentLocation;
    private TextView lblCurrentLocation;
    private ImageView imgLocation;
    private LinearLayout layoutSelect = null;
    private TextView txtSelect = null;
    private LocationRequest mLocationRequest = null;
    private GoogleApiClient googleApiClient;
    private boolean isGPSEnabled = false;
    private boolean isNetworkEnabled = false;
    private RecyclerViewEmptySupport recyclerView = null;
    private List<LocationSerachModel> listOfStores = new ArrayList<LocationSerachModel>();
    //    private StoreListAdapter adapter;
    private double currLat = 0.0;
    private double currLng = 0.0;
    private TextView emptyText = null;
    private AlertDialog dialogExitAppWarning = null;
    //Firebase
    private static final String TAG = ActivityLocation.class.getSimpleName();
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private TextView txtRegId, txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        txtSearchArea = findViewById(R.id.txtSearchArea);
        emptyText = findViewById(R.id.emptyText);
        layoutCurrentLocation = findViewById(R.id.layoutCurrentLocation);
        imgLocation = findViewById(R.id.imgLocation);
        lblCurrentLocation = findViewById(R.id.lblCurrentLocation);
        recyclerView = findViewById(R.id.recyclerView);
        layoutSelect = findViewById(R.id.layoutSelect);
        txtSelect = findViewById(R.id.txtSelect);
        txtSelect.setTypeface(FontUtils.getInstance(ActivityLocation.this).getRegularTypeFace());
        txtSearchArea.setOnClickListener(this);
        lblCurrentLocation.setTypeface(FontUtils.getInstance(ActivityLocation.this).getRegularTypeFace());
        emptyText.setTypeface(FontUtils.getInstance(ActivityLocation.this).getRegularTypeFace());
        txtSearchArea.setTypeface(FontUtils.getInstance(ActivityLocation.this).getChivoTypeFace());
        imgLocation.setOnClickListener(this);
        layoutCurrentLocation.setOnClickListener(this);
        gpsTracker = new GPSTracker(ActivityLocation.this);
        ObservableObject.getInstance().addObserver(this);
//      A list of rewarded video adapters to initialize
        List<String> networksToInit = new ArrayList<String>();
//        networksToInit.add("com.mopub.mobileads.VungleRewardedVideo");

        locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            emptyText.setText(R.string.gps_off);
        }

        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(2000);
        mLocationRequest.setFastestInterval(2000);

        googleApiClient = new GoogleApiClient.Builder(this, this, this).addApi(LocationServices.API).build();
        if (googleApiClient != null) {
            googleApiClient.connect();
        }
        /*mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                    displayFirebaseRegId();

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received

                    String message = intent.getStringExtra("message");

                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();

                    //txtMessage.setText(message);
                }
            }
        };*/

//        displayFirebaseRegId();
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityLocation.this));
        recyclerView.setEmptyView(findViewById(R.id.emptyView));
        currLat = AppConstant.currLat;
        //currLat = new AppShare(ActivityLocation.this).getCurrLat();
        currLng = AppConstant.currLng;
        //currLng = new AppShare(ActivityLocation.this).getCurrLng();

        /*if (!TextUtils.isEmpty(new AppShare(ActivityLocation.this).getCurrentLocation())) {
            txtSearchArea.setText(new AppShare(ActivityLocation.this).getCurrentLocation());
        }*/

        /*if (currLat > 0 && currLng > 0) {
            GetNearByStoresRequest request = new GetNearByStoresRequest();
            request.setLatitude(String.valueOf(currLat));
            request.setLongitude(String.valueOf(currLng));

            new AsyncTaskExecutor<A2BRequest, Void, A2BResponse>().execute(
                    new RequestProcessor(ActivityLocation.this, ActivityLocation.this, true), request);
        }*/

       /* try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }*/

        checkPermissions();

        dialogExitAppWarning = new AlertDialog.Builder(ActivityLocation.this)
                /*.setTitle(getString(R.string.str_app_exit))*/
                .setMessage(getString(R.string.str_app_exit))
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (storeList.size() > 0) {
                            setResult(0);
                            //finish();

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                            finish();
                            //System.exit(0);
                            overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);

                        } else {
                            setResult(1);
                            finish();
                            //super.onBackPressed();
                            overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
                        }
                        //overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
                    }
                })
                .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();

    }// End of onCreate


    public void findPlace() {
        try {
            AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                    .setTypeFilter(AutocompleteFilter.TYPE_FILTER_GEOCODE)
                    .build();
            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                    .setBoundsBias(AppConstant.BOUNDS_INDIA)
                    .setFilter(typeFilter)
                    .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    public boolean check() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ("com.marolix.smarttablayout.gpshelper.TrackLoc"
                    .equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                if (place != null)
                    txtSearchArea.setText("" + place.getName() + "," + place.getAddress());
                Log.e("Selected Loc LatLon", "" + place.getLatLng());

                LatLng latLng = place.getLatLng();
                if (latLng != null) {
                    AppConstant.currLat = latLng.latitude;
                    AppConstant.currLng = latLng.longitude;

                    /*new AppShare(ActivityLocation.this).setCurrLat(latLng.latitude);
                    new AppShare(ActivityLocation.this).setCurrLng(latLng.longitude);*/

                    new AppShare(ActivityLocation.this).setCurrentLocation(txtSearchArea.getText().toString());

                    /*GetNearByStoresRequest request = new GetNearByStoresRequest();
                    request.setLatitude(String.valueOf(latLng.latitude));
                    request.setLongitude(String.valueOf(latLng.longitude));

                    new AsyncTaskExecutor<A2BRequest, Void, A2BResponse>().execute(
                            new RequestProcessor(ActivityLocation.this,
                                    ActivityLocation.this, true), request);*/

                }

                //AppConstant.currentLocation = place.getAddress().toString();
                new AppShare(ActivityLocation.this).setCurrentLocation(place.getAddress().toString());
                //onBackPressed();
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.i("Home Activity", status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        } else if (requestCode == GPS_ON_ACTION) {
            //GPS ENABLED
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (isGPSEnabled) {
                emptyText.setText(R.string.no_delivery_at_this_location);
                getCurrentLocation();
            } else {
                emptyText.setText(R.string.gps_off);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    // Fetches reg id from shared preferences
    // and displays on the screen

    /*private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e(TAG, "Firebase reg id: " + regId);

      *//*  if (!TextUtils.isEmpty(regId))
            //txtRegId.setText("Firebase Reg Id: " + regId);
            Toast.makeText(this, "Firebase Reg Id: " + regId, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Firebase Reg Id is not received yet!", Toast.LENGTH_SHORT).show();
        //txtRegId.setText("Firebase Reg Id is not received yet!");*//*
    }*/

    @Override
    public void onBackPressed() {
        Log.e("storeList", "" + storeList.size());
        dialogExitAppWarning.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtSearchArea:
                findPlace();
                break;
            case R.id.imgLocation:
                onBackPressed();
                break;
            case R.id.layoutCurrentLocation:
                checkPermissions();
                break;
        }
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERMISSION_ACCESS_COARSE_LOCATION);

        } else {
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (isGPSEnabled) {
                getCurrentLocation();
                emptyText.setText(R.string.no_delivery_at_this_location);
            } else {
                emptyText.setText(R.string.gps_off);
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(intent, GPS_ON_ACTION);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    if (isGPSEnabled) {
                        emptyText.setText(R.string.no_delivery_at_this_location);
                        getCurrentLocation();
                    } else {
                        emptyText.setText(R.string.gps_off);
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, GPS_ON_ACTION);
                        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                    }
                } else {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getApplicationContext().getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                    overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                    Toast.makeText(this, "Need your location!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (googleApiClient != null) {
            googleApiClient.connect();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    /*@Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }*/

    @Override
    protected void onDestroy() {
        googleApiClient.disconnect();
//        mInterstitial.destroy();
        super.onDestroy();
    }

    private void getCurrentLocation() {
        Log.e("Button Click", "Working");
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            Log.e("inside", "this");
            Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

            if (mLastLocation != null) {
                double lat = mLastLocation.getLatitude(),
                        lon = mLastLocation.getLongitude();
                Log.e("Current LatLng >> ",lat + "," + lon);
                AppConstant.currLat = lat;
                //new AppShare(ActivityLocation.this).setCurrLat(lat);
                AppConstant.currLng = lon;
                //new AppShare(ActivityLocation.this).setCurrLng(lon);
                /*currLat = new AppShare(ActivityLocation.this).getCurrLat();
                currLng = new AppShare(ActivityLocation.this).getCurrLng();*/
                currLat = lat;
                currLng = lon;
                if (currLat > 0 && currLng > 0) {
                    //if (currentaddress != null && !TextUtils.isEmpty(currentaddress))
                    if (!TextUtils.isEmpty(locationDetails())) {

                        Log.e("loc", locationDetails());

                        txtSearchArea.setText(locationDetails());
                    } else {
                        txtSearchArea.setText("");
                    }

                    /*GetNearByStoresRequest request = new GetNearByStoresRequest();
                    request.setLatitude(String.valueOf(currLat));
                    request.setLongitude(String.valueOf(currLng));
                    new AsyncTaskExecutor<A2BRequest, Void, A2BResponse>().execute(
                            new RequestProcessor(ActivityLocation.this, ActivityLocation.this, true), request);*/

                }
            }
        }
    }

    /*@Override
    public void requestProcessed(A2BRequest guiRequest, A2BResponse guiResponse, RequestStatus status) {
        if (status.equals(RequestStatus.SUCCESS)) {
            if (guiResponse.isStatus()) {
                try {
                    GetNearByStoresResponse strResponse = (GetNearByStoresResponse) guiResponse;
                    if (strResponse != null && strResponse.getStoreListModels() != null) {
                        layoutSelect.setVisibility(View.VISIBLE);
                        storeList.clear();
                        storeList = strResponse.getStoreListModels();
                        adapter = new StoreListAdapter(ActivityLocation.this, storeList);
                        recyclerView.setAdapter(adapter);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // Empty
                //Toast.makeText(ActivityLocation.this,getString(R.string.no_store),Toast.LENGTH_SHORT).show();
                storeList.clear();
                layoutSelect.setVisibility(View.GONE);
                adapter = new StoreListAdapter(ActivityLocation.this, storeList);
                recyclerView.setAdapter(adapter);
            }
        } else {
            // network error
            Toast.makeText(ActivityLocation.this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }*/

    @Override
    public void onLocationChanged(Location location) {
        Log.e("Location Changed", " Called");
        getCurrentLocation();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
        // stopService(new Intent(ActivityLocation.this, TrackLoc.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        //AppConstant.currentLocation = new GPSTracker(ActivityLocation.this).getAddressLine(ActivityLocation.this);

        new AppShare(ActivityLocation.this).setCurrentLocation(new GPSTracker(ActivityLocation.this).getAddressLine(ActivityLocation.this));

        /*if (!TextUtils.isEmpty(new AppShare(ActivityLocation.this).getCurrentLocation())) {
            txtSearchArea.setText(new AppShare(ActivityLocation.this).getCurrentLocation());
        }*/
        // register GCM registration complete receiver

        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    private String locationDetails() {
        String address = "";
        Geocoder gcd = new Geocoder(ActivityLocation.this, Locale.getDefault());
        List<android.location.Address> addresses = null;
        try {
            addresses = gcd.getFromLocation(currLat, currLng, 1);
            if (addresses.size() > 0)
                address = addresses.get(0).getAddressLine(0) + "," + addresses.get(0).getAddressLine(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public void update(Observable observable, Object o) {
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSEnabled) {
            emptyText.setText(R.string.no_delivery_at_this_location);
            getCurrentLocation();
        } else {
            emptyText.setText(R.string.gps_off);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}