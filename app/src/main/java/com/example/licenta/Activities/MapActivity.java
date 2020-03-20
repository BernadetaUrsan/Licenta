package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.licenta.Helpers.StorageHelper;
import com.example.licenta.Models.LocationModel;
import com.example.licenta.R;
import com.facebook.appevents.ml.Utils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private LocationModel locatie;
    private SupportMapFragment mapFragment;
    private GoogleMap googleMap;
    private boolean isLocationSet;
    private LatLng position;
    private MarkerOptions markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initializeViews();
        mapFragment.getMapAsync(this);
    }

    private void displayLocations(){
        Drawable circleDrawable = getResources().getDrawable(R.drawable.ic_map_pin);

        for (LocationModel location: StorageHelper.mockLocations()) {
            Marker marker = googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(location.getLatitude(), location.getLongitude()))
                    .title(location.getNumeLocatie()));
            marker.setTag(location);
        }
    }
//
//    private BitmapDescriptor bitmapDescriptorFromVector(Drawable drawable) {
//        Canvas canvas = new Canvas();
//        Bitmap bitmap = Bitmap.createBitmap(50 , 50, Bitmap.Config.ARGB_8888);
//        canvas.setBitmap(bitmap);
//        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        drawable.draw(canvas);
//        return BitmapDescriptorFactory.fromBitmap(bitmap);
//    }

    private BitmapDescriptor getBitmapDescriptor(int id) {
        Drawable vectorDrawable = this.getDrawable(id);
        int h = ((int) convertDpToPixel(42));
        int w = ((int) convertDpToPixel(25));
        vectorDrawable.setBounds(0, 0, w, h);
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bm);
    }

    public float  convertDpToPixel(int dp){
        return dp * this.getResources().getDisplayMetrics().density;
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        this.googleMap = googleMap;
        displayLocations();

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(45.7494, 21.2272), 13));
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                isLocationSet = !isLocationSet;
                if (isLocationSet){
                    markerOptions = new MarkerOptions();
                    position = latLng;
                    markerOptions.position(new LatLng(latLng.latitude, latLng.latitude));
                    googleMap.addMarker(markerOptions);
                    markerOptions.visible(true);
                }
                else
                {
                    markerOptions.visible(false);
                }
            }
        });
    }

    private void initializeViews()
    {
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);
    }
}