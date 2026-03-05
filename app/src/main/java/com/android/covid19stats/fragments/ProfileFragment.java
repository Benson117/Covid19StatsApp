package com.android.covid19stats.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.android.covid19stats.Activity.AboutApp;
import com.android.covid19stats.Activity.MainActivity2;
import com.android.covid19stats.Activity.covid19Hist;
import com.android.covid19stats.R;



public class ProfileFragment extends Fragment {
    Button b2,b3,b4; //button declaration

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_profile, container, false);


        b2 = v.findViewById(R.id.button2);
        b3 = v.findViewById(R.id.button3);
        b4 = v.findViewById(R.id.button4);
        //assigning the buttons
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity2.class));


            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), covid19Hist.class));


            }

        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AboutApp.class));


            }

        });


        return v;
    }

}

