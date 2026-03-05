package com.android.covid19stats.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.covid19stats.util.Constant;
import com.android.covid19stats.util.FontUtils;
import com.android.covid19stats.util.Utility;

import com.android.covid19stats.R;

public class ChangeLanguageActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title, isizuluText, englishText;
    private ImageView back, checkIsizulu, checkEnglish;
    private LinearLayout layoutIsizulu, layoutEnglish;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);

        title           = findViewById(R.id.title);
        back            = findViewById(R.id.back);
        checkIsizulu  = findViewById(R.id.checkIsizulu);
        checkEnglish    = findViewById(R.id.checkEnglish);
        layoutIsizulu = findViewById(R.id.layoutIsizulu);
        layoutEnglish   = findViewById(R.id.layoutEnglish);
        isizuluText   = findViewById(R.id.isizuluText);
        englishText     = findViewById(R.id.englishText);

        title.setTypeface(FontUtils.loadFontFromAssets(this, Constant.FONT_BOLD));
        isizuluText.setTypeface(FontUtils.loadFontFromAssets(this, Constant.FONT_BOLD));
        englishText.setTypeface(FontUtils.loadFontFromAssets(this, Constant.FONT_BOLD));

        back.setOnClickListener(this);
        layoutIsizulu.setOnClickListener(this);
        layoutEnglish.setOnClickListener(this);

        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        String lang= mSettings.getString("lang", "en");
        if(lang.equals(Constant.ISIZULU)){
            checkIsizulu.setVisibility(View.VISIBLE);
        }else if(lang.equals(Constant.ENGLISH)){
            checkEnglish.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back){
            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            finish();
        }else if(v.getId() == R.id.layoutIsizulu){
            changeLanguage(Constant.ISIZULU);
        }else if(v.getId() == R.id.layoutEnglish){
            changeLanguage(Constant.ENGLISH);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }

    public void changeLanguage(String language){
        if(language == Constant.ISIZULU){
            checkIsizulu.setVisibility(View.VISIBLE);
            checkEnglish.setVisibility(View.GONE);
        }else if(language == Constant.ENGLISH){
            checkIsizulu.setVisibility(View.GONE);
            checkEnglish.setVisibility(View.VISIBLE);
        }
        Utility.setLocale(language, getBaseContext(), this);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }
}
