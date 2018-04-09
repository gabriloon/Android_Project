package com.example.noel1.lab2s1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);//activity 지정
        Button button = findViewById(R.id.button2);//Id 를 통해 XML에서의 닫기버튼과 매칭.
        Intent intent = getIntent();//Main에서 Intent 지목당한것을 get.
        if (intent != null) { //intent지목당한것이 있다면,
            String name = intent.getStringExtra("name");//putExtra로 저장되어 있는 값을 받는다.
            String age = intent.getStringExtra("age");//putExtra로 저장되어 있는 값을 받는다.
            Toast.makeText(getApplicationContext(), "Student Info:" + name + " , " + age, Toast.LENGTH_LONG).show();//Toast 문장 Student Info: name, age
        }

        button.setOnClickListener(new View.OnClickListener() {//닫기 버튼이 눌린다면,
            @Override
            public void onClick(View v) {
                finish();//Activity 종료.
            }
        });

    }
}




