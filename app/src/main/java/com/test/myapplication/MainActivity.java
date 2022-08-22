package com.test.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.test.myapplication.Network.Interface;
import com.test.myapplication.Network.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    Interface apiInterface;
    private List<Latlong> latlongList;
    DatabaseHandler db = new DatabaseHandler(MainActivity.this);
    RecyclerView recyclerView;
    HlistAdapter hlistAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.Re_shows);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GetData();

    }

    private void GetData() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
            getCurrentLocation();



        } else {
            getCurrentLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

            case 100:

                break;
        }
    }

    private void getCurrentLocation() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.getFusedLocationProviderClient(MainActivity.this)
                .requestLocationUpdates(locationRequest, new LocationCallback() {

                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(getApplicationContext())
                                .removeLocationUpdates(this);
                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            int latestlocIndex = locationResult.getLocations().size() - 1;
                            double lati = locationResult.getLocations().get(latestlocIndex).getLatitude();
                            double longi = locationResult.getLocations().get(latestlocIndex).getLongitude();
                            fetchLoc(lati,longi);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "i", Toast.LENGTH_SHORT).show();

                        }
                    }
                }, Looper.getMainLooper());

    }

    private void fetchLoc(double lati, double longi) {
            String lat= String.valueOf(lati);
            String lon= String.valueOf(longi);

        StringTokenizer tokens = new StringTokenizer(lat, "\\.");
        String lat1 = tokens.nextToken();
        StringTokenizer token1 = new StringTokenizer(lon, "\\.");
        String lon1 = token1.nextToken();


            try {

                Map<String, String> params = new HashMap<String, String>();
                params.put("lat", "8");
                params.put("lon", "76");

                apiInterface= RetrofitClient.getClient().create(Interface.class);
                Call<List<Latlong>> call = apiInterface.getData(params);

                call.enqueue(new Callback<List<Latlong>>() {
                    @Override

                    public void onResponse(Call<List<Latlong>> call, Response<List<Latlong>> response) {
                        if (response.isSuccessful()) {
                            latlongList = response.body();
                            CreateOfflineDb(latlongList);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Latlong>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
            } catch (Exception e){
            System.err.println(e.getMessage());
        }
        }

    private void CreateOfflineDb(List<Latlong> latlongList) {
        db.insertDetails(latlongList);
        List<Latlong> latlongs = db.listContacts();
        hlistAdapter = new HlistAdapter(getApplicationContext(),latlongs);
        recyclerView.setAdapter(hlistAdapter);

    }


}