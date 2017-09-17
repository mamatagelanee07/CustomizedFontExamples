package com.andigeeky.customizedfontexamples.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
        applyCustomFonts(view);
        Toast.makeText(getActivity(), getString(R.string.msg_font_downloadable_using_xml), Toast.LENGTH_SHORT).show();

        return view;
    }

    private void applyCustomFonts(View view) {
        TextView textFont1 = view.findViewById(R.id.textFont1);
        TextView textFont2 = view.findViewById(R.id.textFont2);
        TextView textFont3 = view.findViewById(R.id.textFont3);
        TextView textFont4 = view.findViewById(R.id.textFont4);
        TextView textFont5 = view.findViewById(R.id.textFont5);

        Typeface typeface1 = Typeface.createFromAsset(getActivity().getAssets(), "EncodeSansExpanded-Light.ttf");
        Typeface typeface2 = Typeface.createFromAsset(getActivity().getAssets(), "EncodeSansExpanded-Regular.ttf");
        Typeface typeface3 = Typeface.createFromAsset(getActivity().getAssets(), "EncodeSansExpanded-Medium.ttf");
        Typeface typeface4 = Typeface.createFromAsset(getActivity().getAssets(), "EncodeSansExpanded-SemiBold.ttf");
        Typeface typeface5 = Typeface.createFromAsset(getActivity().getAssets(), "EncodeSansExpanded-Bold.ttf");

        textFont1.setTypeface(typeface1);
        textFont2.setTypeface(typeface2);
        textFont3.setTypeface(typeface3);
        textFont4.setTypeface(typeface4);
        textFont5.setTypeface(typeface5);
    }
}
