package com.epicodus.mysteryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.appleButton) ImageButton appleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        appleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == appleButton) {
            Intent intent = new Intent(MainActivity.this, StoreActivity.class);
            startActivity(intent);
        }
    }
}
