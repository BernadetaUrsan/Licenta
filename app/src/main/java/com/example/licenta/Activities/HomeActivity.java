package com.example.licenta.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.licenta.Fragments.HomeFragment;
import com.example.licenta.Fragments.NotificationsFragment;
import com.example.licenta.Fragments.ProfileFragment;
import com.example.licenta.Fragments.SettingsFragment;
import com.example.licenta.R;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private HomeFragment fragmentHome;
    private NotificationsFragment fragmentNotifications;
    private SettingsFragment fragmentSettings;
    private ProfileFragment fragmentProfile;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        navigation=findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        initializeViews();
        LoadFragment(fragmentHome);
    }

    private void initializeViews(){
        fragmentHome=new HomeFragment();
        fragmentNotifications= new NotificationsFragment();
        fragmentProfile=new ProfileFragment();
        fragmentSettings=new SettingsFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = fragmentHome;
                break;
            case R.id.navigation_notifications:
                fragment = fragmentNotifications;
                break;
            case R.id.navigation_settings:
                fragment = fragmentSettings;
                break;
            case R.id.navigation_profile:
                fragment = fragmentProfile;
                break;
        }
        return LoadFragment(fragment);
    }

    private boolean LoadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        } else
            return false;
    }
}
