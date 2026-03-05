package com.android.covid19stats.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.android.covid19stats.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//assigning to the activity main layout
        BottomNavigationView navView = findViewById(R.id.nav_view); //assigning the main activity to the bottom navigation bar

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); //main activity layout acts as the host fragment of the home fragment
        NavigationUI.setupWithNavController(navView, navController);

    }



}
