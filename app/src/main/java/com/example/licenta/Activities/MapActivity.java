package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.Adapters.LocationAdapter;
import com.example.licenta.Adapters.TimetableAdapter;
import com.example.licenta.Helpers.StorageHelper;
import com.example.licenta.Interfaces.MapClickListener;
import com.example.licenta.Models.LocationModel;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.TimetabelModel;
import com.example.licenta.Models.TimetableRowModel;
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

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends BaseActivity implements OnMapReadyCallback, MapClickListener {
    private LocationModel locatie;
    private List<LocationModel> listaLocatii;
    private SupportMapFragment mapFragment;
    private GoogleMap googleMap;
    private boolean isLocationSet;
    private LatLng position;
    private MarkerOptions markerOptions;
    private RecyclerView recyclerView;
    private LocationAdapter locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        listaLocatii = new ArrayList<>();
        initializeViews();
        setToolbarTitle("Hartă campus");
        mapFragment.getMapAsync(this);
        SetRecyclerView(listaLocatii);
    }

    public void OnLocatie(LocationModel locatie){
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(locatie.getLatitude(), locatie.getLongitude()),15.0f));
    }

    private void SetRecyclerView(List<LocationModel> listaLocatii)
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        locationAdapter = new LocationAdapter(listaLocatii, getApplicationContext(), this);
        recyclerView.setAdapter(locationAdapter);
    }

    private void displayLocations(){
        Drawable circleDrawable = getResources().getDrawable(R.drawable.ic_map_pin);

        for (LocationModel location: StorageHelper.mockLocations()) {
            Marker marker = googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(location.getLatitude(), location.getLongitude()))
                    .icon(getMarkerIconFromDrawable(circleDrawable))
                    .title(location.getNumeLocatie()));
            marker.setTag(location);
        }
    }

    private BitmapDescriptor getMarkerIconFromDrawable(Drawable drawable) {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
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
        recyclerView = findViewById(R.id.rv_lista_locatii);


        for (LocationModel location: StorageHelper.mockLocations()){
            listaLocatii.add(location);
        }
    }

    @Override
    public void OnClick(LocationModel location) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()),17.0f));
    }
}