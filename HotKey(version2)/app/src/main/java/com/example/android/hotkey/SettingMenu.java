package com.example.android.hotkey;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SettingMenu extends AppCompatActivity {

Button btn1;
    Button btn2;
    Button btn3;
    Button back2;
    String ipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        btn1=findViewById(R.id.sbtn1);
        btn2=findViewById(R.id.sbtn2);
        btn3=findViewById(R.id.sbtn3);
        back2 = findViewById(R.id.sbackBtn);
        ipStr = getIntent().getStringExtra("ip");


        Intent intent2 = getIntent();
        if(intent2!=null){}

        btn1.setOnClickListener(new View.OnClickListener(){
public void onClick(View v){

    Intent intent1 = new Intent (getApplicationContext(),settingword.class);
    intent1.putExtra("ip",ipStr);
    startActivity(intent1);

}

        });


        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent1 = new Intent (getApplicationContext(),settingbattle.class);
                intent1.putExtra("ip",ipStr);
                startActivity(intent1);

            }

        });


        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent1 = new Intent (getApplicationContext(),settingtouchpad.class);
                intent1.putExtra("ip",ipStr);
                startActivity(intent1);

            }

        });


        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}