package com.andigeeky.customizedfontexamples.common;

import android.support.v7.app.AppCompatActivity;

import com.andigeeky.customizedfontexamples.R;
import com.andigeeky.customizedfontexamples.fragments.DownloadableProgrammaticallyFragment;
import com.andigeeky.customizedfontexamples.fragments.DownloadableUsingXMLFragment;
import com.andigeeky.customizedfontexamples.fragments.FontInXMLFragment;
import com.andigeeky.customizedfontexamples.fragments.FontInXMLProgrammeticallyFragment;
import com.andigeeky.customizedfontexamples.fragments.LegacyFragment;

/**
 * Created by Mamata on 9/17/2017.
 */

public class FragmentLoader {
    public void loadLegacyFragment(AppCompatActivity context) {
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new LegacyFragment(), LegacyFragment.TAG).commit();
    }

    public void loadFontInXMLFragment(AppCompatActivity context) {
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new FontInXMLFragment(), FontInXMLFragment.TAG).commit();
    }

    public void loadFontInXMLProgrammaticallyFragment(AppCompatActivity context) {
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new FontInXMLProgrammeticallyFragment(), FontInXMLProgrammeticallyFragment.TAG).commit();
    }

    public void loadDownloadableUsingXMLFragment(AppCompatActivity context) {
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new DownloadableUsingXMLFragment(), DownloadableUsingXMLFragment.TAG).commit();
    }

    public void loadDownloadableProgrammaticallyFragment(AppCompatActivity context) {
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new DownloadableProgrammaticallyFragment(), DownloadableProgrammaticallyFragment.TAG).commit();
    }
}
