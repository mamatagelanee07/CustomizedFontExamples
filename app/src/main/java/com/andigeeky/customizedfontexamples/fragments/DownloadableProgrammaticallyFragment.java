package com.andigeeky.customizedfontexamples.fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.provider.FontRequest;
import android.support.v4.provider.FontsContractCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.andigeeky.customizedfontexamples.MainActivity;
import com.andigeeky.customizedfontexamples.R;
import com.andigeeky.customizedfontexamples.common.QueryBuilder;

/**
 * Created by Mamata on 9/17/2017.
 */

public class DownloadableProgrammaticallyFragment extends Fragment {
    public static final String TAG = DownloadableProgrammaticallyFragment.class.getSimpleName();
    private View view;
    private TextView textFont;
    private Button btnApplyFont;
    private RadioGroup fontGroup;
    private String selectedFont = "Dosis";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_downloadable_programmatically, container, false);
        Toast.makeText(getActivity(), getString(R.string.msg_font_downloadable_programmatically), Toast.LENGTH_SHORT).show();
        initUI();
        return view;
    }

    private void initUI() {
        textFont = view.findViewById(R.id.textFont);
        btnApplyFont = view.findViewById(R.id.btnApplyFont);
        fontGroup = view.findViewById(R.id.radio_font_group);
        btnApplyFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFontForSupport(selectedFont);
            }
        });
        fontGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int viewId) {
                switch (viewId) {
                    case R.id.radioButtonDosis:
                        selectedFont = "Dosis";
                        break;
                    case R.id.radioButtonJosephin:
                        selectedFont = "Josefin Sans";
                        break;
                    case R.id.radioButtonLobster:
                        selectedFont = "Lobster";
                        break;
                    default:
                        selectedFont = "Dosis";
                        break;
                }
            }
        });

    }

    /**
     * Downloads fonts
     * <p>Note: For Android O, just use FontRequest and FontsContract from support library 26</p>
     * @param familyName Font family name
     */
    private void downloadFontForSupport(String familyName) {
        requestDownload(familyName);
    }

    private void requestDownload(String familyName) {
        QueryBuilder queryBuilder = new QueryBuilder(familyName)
                .withWidth(QueryBuilder.WIDTH_DEFAULT)
                .withWeight(QueryBuilder.WEIGHT_DEFAULT)
                .withItalic(QueryBuilder.ITALIC_DEFAULT)
                .withBestEffort(true);
        String query = queryBuilder.build();

        FontRequest request = new FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                query,
                R.array.com_google_android_gms_fonts_certs);

        final ProgressBar progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        FontsContractCompat.FontRequestCallback callback = new FontsContractCompat
                .FontRequestCallback() {
            @Override
            public void onTypefaceRetrieved(Typeface typeface) {
                textFont.setTypeface(typeface);
                progressBar.setVisibility(View.GONE);
                btnApplyFont.setEnabled(true);
            }

            @Override
            public void onTypefaceRequestFailed(int reason) {
                Toast.makeText(getActivity(),
                        getString(R.string.msg_font_request_failed) + reason, Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
                btnApplyFont.setEnabled(true);
            }
        };
        FontsContractCompat
                .requestFont(getActivity(), request, callback,
                        getHandlerThreadHandler());
    }

    private Handler getHandlerThreadHandler() {
        HandlerThread handlerThread = new HandlerThread("fonts");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }
}
