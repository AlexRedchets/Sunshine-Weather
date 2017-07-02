package com.alexredchets.sunshineweather.mvp.main;

import android.app.Application;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alexredchets.sunshineweather.App;
import com.alexredchets.sunshineweather.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;


public class SplashActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 161;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    @BindView(R.id.activity_splash) protected View mView;
    @Inject protected SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.i("OnCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        Application app = (App)getApplication();

        ((App)getApplication()).provideAppComponent().inject(this);

        ButterKnife.bind(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10000)        // 10 seconds, in milliseconds
                .setFastestInterval(5000); // 5 seconds, in milliseconds
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGoogleApiClient.disconnect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App)getApplication()).releaseAppComponent();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Timber.i("Location services connected.");

        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Location permissions are not available.
            requestLocationPermission();
        } else {
            // Location permissions are already available.
            Timber.i("Location permission already granted.");
            Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (location == null){
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                        mLocationRequest,
                        this);
            }
            else {
                handleNewLocation(location);
            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Timber.i("Location services suspended. Please reconnect.");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        /*
         * Google Play services can resolve some errors it detects.
         * If the error has a resolution, try sending an Intent to
         * start a Google Play services activity that can resolve
         * error.
         */
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(this,
                        CONNECTION_FAILURE_RESOLUTION_REQUEST);
                /*
                 * Thrown if Google Play services canceled the original
                 * PendingIntent
                 */
            } catch (IntentSender.SendIntentException e) {
                // Log the error
                e.printStackTrace();
                Timber.e(e);
            }
        } else {
            /*
             * If no resolution is available, display a dialog to the
             * user with the error.
             */
            Timber.i("Location services connection failed with code "
                    + connectionResult.getErrorCode());
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        handleNewLocation(location);
    }

    private void requestLocationPermission() {
        Timber.i("Location permission NOT granted. Requesting permission.");

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example if the user has previously denied the permission.
            Timber.i("Displaying location permission rationale to provide additional context.");

            Snackbar.make(mView, R.string.permission_location_rationale,
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat.requestPermissions(SplashActivity.this,
                                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                    MY_PERMISSIONS_REQUEST_LOCATION);
                        }
                    })
                    .show();

        } else {
            // Location permission has not been granted yet. Request it directly.
            Timber.i("Location permission has not been granted yet. Request it directly.");

            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        // Received permission result for location permission.
        Timber.i("Received response for Location permission request.");

        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Location permission has been granted, preview can be displayed
                    Timber.i("LOCATION permission has now been granted.");
                    // permission was granted
                } else {
                    Timber.i("LOCATION permission was NOT granted.");
                    boolean showRationale = shouldShowRequestPermissionRationale(permissions[0]);

                    if (!showRationale){
                        Intent i = new Intent(SplashActivity.this,
                                PermissionsDeniedActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        }
    }

    private void handleNewLocation(Location location) {
        Timber.i(location.toString());

        String currentLatitude = String.valueOf(location.getLatitude());
        String currentLongitude = String.valueOf(location.getLongitude());

        Timber.i("currentLatitude: " + currentLatitude);
        Timber.i("currentLongitude: " + currentLongitude);

        mPreferences
                .edit()
                .putString("latitude", currentLatitude)
                .putString("longitude", currentLongitude)
                .apply();

        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashActivity.this,
                    WeatherActivity.class);
            startActivity(i);
            finish();
        }, 3000);
    }
}