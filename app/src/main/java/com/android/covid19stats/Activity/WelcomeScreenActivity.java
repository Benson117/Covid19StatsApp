package com.android.covid19stats.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.android.covid19stats.R;
import com.android.covid19stats.model.GlobalVar;
import com.android.covid19stats.util.Constant;
import com.android.covid19stats.util.FontUtils;
import com.android.covid19stats.util.Utility;
import com.android.covid19stats.util.service.AsyncTaskCompleteListener;
import com.android.covid19stats.util.service.CallService;

import org.json.JSONException;
import org.json.JSONObject;

public class WelcomeScreenActivity extends AppCompatActivity implements AsyncTaskCompleteListener {
    LinearLayout loading, error;
    TextView loadingText, errorMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        loading     = findViewById(R.id.loading);
        error       = findViewById(R.id.error);
        loadingText = findViewById(R.id.loadingText);
        errorMessage= findViewById(R.id.errorMessage);

        loadingText.setTypeface(FontUtils.loadFontFromAssets(this, Constant.FONT_BOLD));
        errorMessage.setTypeface(FontUtils.loadFontFromAssets(this, Constant.FONT_BOLD));

        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = mSettings.getString("lang", "en");
        Utility.setLocale(lang,getBaseContext(),this);

        boolean darkMode = mSettings.getBoolean("darkMode", false);
        if(darkMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        CallService callService = new CallService(this,this, Constant.SERVICE_NO_LOADING);
        callService.execute("dayone/country/south africa", Constant.METHOD_GET);
    }

    @Override
    public void onTaskComplete(Object[] params) {
        String result = (String) params[0];
        if(Utility.cekValidResult(result, this)){
            if(result.equals("You have reached maximum request limit.")){
                CallService callService = new CallService(this,this, Constant.SERVICE_NO_LOADING);
                callService.execute("dayone/country/south africa", Constant.METHOD_GET);
            }else{
                GlobalVar.getInstance().setDataStatsCountry(Utility.buildDataStats(result));
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }else{
            try {
                JSONObject jsonObject = new JSONObject(result);
                String message = jsonObject.getString("fullMessage");

                loading.setVisibility(View.GONE);
                error.setVisibility(View.VISIBLE);

                errorMessage.setText(message);
            }catch (JSONException e){

            }
        }
    }
}
