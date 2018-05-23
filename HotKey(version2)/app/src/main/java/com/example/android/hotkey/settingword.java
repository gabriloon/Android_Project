package com.example.android.hotkey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by noel1 on 2018-05-24.
 */

public class settingword extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button back2;
    String ipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingword);
        Intent intent2 = getIntent();
        if(intent2!=null){}

    }

}
