package com.example.ck.apttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.annotation.Util;

public class MainActivity extends AppCompatActivity {

    @Util
    Object object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
