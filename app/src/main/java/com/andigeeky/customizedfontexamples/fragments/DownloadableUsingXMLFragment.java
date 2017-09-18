package com.andigeeky.customizedfontexamples.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andigeeky.customizedfontexamples.R;

/**
 * Created by Mamata on 9/17/2017.
 */

public class DownloadableUsingXMLFragment extends Fragment {
    public static final String TAG = DownloadableUsingXMLFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_downloadable_using_xmll, container, false);
        Toast.makeText(getActivity(), getString(R.string.msg_font_downloadable_using_xml), Toast.LENGTH_SHORT).show();
        return view;
    }
}
