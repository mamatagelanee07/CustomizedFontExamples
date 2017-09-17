package com.andigeeky.customizedfontexamples.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.andigeeky.customizedfontexamples.R;

/**
 * Created by Mamata on 9/17/2017.
 */

public class FontInXMLProgrammeticallyFragment extends Fragment {
    public static final String TAG = FontInXMLProgrammeticallyFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_font_in_xml_programmetically, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            applyCustomFontsProgrammatically(view);
        } else {
            applyCustomFontsProgrammaticallyForSupport(view);
        }

        Toast.makeText(getActivity(), getString(R.string.msg_font_in_xml_programmatically), Toast.LENGTH_SHORT).show();

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void applyCustomFontsProgrammatically(View view) {
        TextView textFont1 = view.findViewById(R.id.textFont1);
        TextView textFont2 = view.findViewById(R.id.textFont2);
        TextView textFont3 = view.findViewById(R.id.textFont3);
        TextView textFont4 = view.findViewById(R.id.textFont4);
        TextView textFont5 = view.findViewById(R.id.textFont5);

        textFont1.setTypeface(getActivity().getResources().getFont(R.font.encode_sans_expanded_light));
        textFont2.setTypeface(getActivity().getResources().getFont(R.font.encode_sans_expanded_regular));
        textFont3.setTypeface(getActivity().getResources().getFont(R.font.encode_sans_expanded_medium));
        textFont4.setTypeface(getActivity().getResources().getFont(R.font.encode_sans_expanded_semi_bold));
        textFont5.setTypeface(getActivity().getResources().getFont(R.font.encode_sans_expanded_bold));
    }

    private void applyCustomFontsProgrammaticallyForSupport(View view) {
        TextView textFont1 = view.findViewById(R.id.textFont1);
        TextView textFont2 = view.findViewById(R.id.textFont2);
        TextView textFont3 = view.findViewById(R.id.textFont3);
        TextView textFont4 = view.findViewById(R.id.textFont4);
        TextView textFont5 = view.findViewById(R.id.textFont5);

        textFont1.setTypeface(ResourcesCompat.getFont(getActivity(), R.font.encode_sans_expanded_light));
        textFont2.setTypeface(ResourcesCompat.getFont(getActivity(), R.font.encode_sans_expanded_regular));
        textFont3.setTypeface(ResourcesCompat.getFont(getActivity(), R.font.encode_sans_expanded_medium));
        textFont4.setTypeface(ResourcesCompat.getFont(getActivity(), R.font.encode_sans_expanded_semi_bold));
        textFont5.setTypeface(ResourcesCompat.getFont(getActivity(), R.font.encode_sans_expanded_bold));
    }
}
