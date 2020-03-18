package com.example.spapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvShoow;
    private Button btnClick;
    private int counte=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShoow=(TextView)findViewById(R.id.tvShow);
        btnClick=(Button)findViewById(R.id.btnClick);

        lodeData();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counte++;
                tvShoow.setText(String.valueOf(counte));
                saveData();
            }
        });
    }

    public void saveData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putInt("Counter",counte);

        editor.apply();

    }

    public void lodeData()
    {

        SharedPreferences sharedPreferences=getSharedPreferences("saveCounter",MODE_PRIVATE);

        counte=sharedPreferences.getInt("Counter",MODE_PRIVATE);

        tvShoow.setText(String.valueOf(counte));
    }
}
