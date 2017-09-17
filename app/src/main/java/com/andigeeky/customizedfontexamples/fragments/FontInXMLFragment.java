package com.andigeeky.customizedfontexamples.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andigeeky.customizedfontexamples.R;

/**
 * Created by Mamata on 9/17/2017.
 */

public class FontInXMLFragment extends Fragment {
    public static final String TAG = FontInXMLFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_font_in_xml, container, false);
    }
}
