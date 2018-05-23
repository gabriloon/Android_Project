package com.example.android.hotkey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by noel1 on 2018-05-24.
 */

public class settingbattle extends AppCompatActivity {

    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;
    String ipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingbattle);
        btn1=findViewById(R.id.iv1);
        btn2=findViewById(R.id.iv2);
        btn3=findViewById(R.id.iv3);
        btn4=findViewById(R.id.iv4);
        ipStr = getIntent().getStringExtra("ip");


        Intent intent2 = getIntent();
        if(intent2!=null){}

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent1 = new Intent (getApplicationContext(),battleset.class);
                intent1.putExtra("ip",ipStr);
                startActivity(intent1);

            }

        });


        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent1 = new Intent (getApplicationContext(),battleset2.class);
                intent1.putExtra("ip",ipStr);
                startActivity(intent1);

            }

        });


        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent1 = new Intent (getApplicationContext(),battleset3.class);
                intent1.putExtra("ip",ipStr);
                startActivity(intent1);

            }

        });
        btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent1 = new Intent (getApplicationContext(),battleset4.class);
                intent1.putExtra("ip",ipStr);
                startActivity(intent1);

            }

        });


    }
}