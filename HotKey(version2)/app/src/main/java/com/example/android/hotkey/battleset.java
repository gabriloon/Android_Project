package com.example.android.hotkey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by noel1 on 2018-05-24.
 */

public class battleset extends AppCompatActivity {

    Button btn1;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battleset);

        btn1 = findViewById(R.id.set1);
    }
}