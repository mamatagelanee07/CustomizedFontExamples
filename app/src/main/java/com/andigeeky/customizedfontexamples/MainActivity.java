package com.andigeeky.customizedfontexamples;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.andigeeky.customizedfontexamples.common.FragmentLoader;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        Toolbar toolbar = getToolbar();
        setUpDrawer(toolbar);
        setUpNavigationView();
        loadInitialScreen();
    }

    private void loadInitialScreen() {
        new FragmentLoader().loadLegacyFragment(this);
    }

    private void setUpNavigationView() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setUpDrawer(Toolbar toolbar) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private Toolbar getToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_legacy:
                new FragmentLoader().loadLegacyFragment(this);
                break;
            case R.id.nav_xml_o:
                new FragmentLoader().loadFontInXMLFragment(this);
                break;
            case R.id.nav_xml_programmatically:
                new FragmentLoader().loadFontInXMLProgrammaticallyFragment(this);
                break;
            case R.id.nav_downloadable_xml:
                new FragmentLoader().loadDownloadableUsingXMLFragment(this);
                break;
            case R.id.nav_downloadable_programmatically:
                new FragmentLoader().loadDownloadableProgrammaticallyFragment(this);
                break;
        }

        closeDrawer();
        return true;
    }

    private void closeDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
