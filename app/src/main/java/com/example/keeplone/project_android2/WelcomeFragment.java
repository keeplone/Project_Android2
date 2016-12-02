package com.example.keeplone.project_android2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    final static String LAYOUT_ID = "layoutId";


    public WelcomeFragment() {
        // Required empty public constructor
    }

    public static WelcomeFragment newInstance(int layoutId) {

        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID, layoutId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(getArguments().getInt(LAYOUT_ID,-1),
                container, false);
        return root;
    }
}
