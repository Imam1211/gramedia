package com.example.gramedia;

import androidx.fragment.app.FragmentActivity;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.location_map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //  tambah koordinat marker
        LatLng imam = new LatLng (-0.900629, 119.893371);
        LatLng gramedia = new LatLng(-0.896861, 119.874917);

//    atur ukuran marker
        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.imam);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.gramedia);

        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();

        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

//    tambahkan marker ke map
        mMap.addMarker(new MarkerOptions().position(imam).title("Marker in UNTAD")
                .snippet("Ini Kampus Panas")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(gramedia).title("Marker in WALKOT")
                .snippet("Ini Walkot Dong")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                imam,
                new LatLng(-0.900629, 119.893371),
                new LatLng(-0.900621, 119.892036),
                new LatLng(-0.900859, 119.888113),
                new LatLng(-0.897825, 119.887358),
                new LatLng(-0.897192, 119.885030),
                new LatLng(-0.897046, 119.879230),
                new LatLng(-0.896857, 119.874960),
                gramedia
        ).width(10)
                .color(Color.RED));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(imam, 11.5f));
    }
}