package com.online.googlemapsbasics

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        val cbPitampura = LatLng(28.6969421,77.1401938)
        val cbDwarka = LatLng(28.5864285,77.0456845 )
        val cbNoida = LatLng(28.5268661,77.1309632)
        val cbDehradun = LatLng(30.3098484,78.0189797)
        mMap.addMarker(MarkerOptions().position(cbPitampura).title("Coding Blocks"))
        // If we use moveCamera instead of animateCamera then there is no animation
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                        cbPitampura,
                        14f
                )
        )
        mMap.addPolyline(PolylineOptions()
                .add(cbPitampura)
                .add(cbDwarka)
                .add(cbNoida)
                .add(cbDehradun)
                .width(8f)
                .color(Color.RED)

        )
        mMap.addCircle(
                CircleOptions()
                        .center(cbPitampura)
                        .radius(500.0)
                        .strokeWidth(3f)
                        .fillColor(Color.argb(70,150,50,50))
        )
//        mMap.isTrafficEnabled = true
        mMap.isBuildingsEnabled = true

        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isRotateGesturesEnabled =true


    }
}
