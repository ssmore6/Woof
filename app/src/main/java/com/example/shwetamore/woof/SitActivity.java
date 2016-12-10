package com.example.shwetamore.woof;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SitActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap googleMap;
    MarkerOptions currentLocation;
    MarkerOptions s2;
    MarkerOptions s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(SitActivity.this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        LatLng currLoc = new LatLng(37.335793, -121.885009);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currLoc, 14.0f));
        currentLocation = new MarkerOptions().position(currLoc);
        googleMap.addMarker(currentLocation);


        LatLng sitter1 = new LatLng(37.333016, -121.879280);
        s1 = new MarkerOptions().position(sitter1);
        s1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        s1.title("Location 1");
        googleMap.addMarker(s1);

        LatLng sitter2 = new LatLng(37.333172, -121.878647);
        s2 = new MarkerOptions().position(sitter2);
        s2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        s2.title("Location 2");
        googleMap.addMarker(s2);

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("Location 1")) {
                    Intent profile1 = new Intent(SitActivity.this, Profile1Activity.class);
                    startActivity(profile1);
                } else if (marker.getTitle().equals("Location 2")) {
                    Intent profile2 = new Intent(SitActivity.this, Profile2Activity.class);
                    startActivity(profile2);
                }
                return true;
            }
        });

    }
}
