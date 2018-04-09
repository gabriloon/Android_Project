package com.example.noel1.lab2s1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;//EditText의 입력한 값을 저장하기 위한 변수.
    String age;//나이, EditText의 입력한 값을 저장하기 위한 변수.
    EditText ed;//EditText 첫번째
    EditText ed2;//EditText 두번째
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//activity 지정, 객체를 메모리에 객체화 시켜주는 역할.

ed=findViewById(R.id.Edt1);//Id 를 통해 XML에서의 EditText와 매칭.
ed2=findViewById(R.id.Edt2);//Id 를 통해 XML에서의 EditText와 매칭.


        Button button=findViewById(R.id.btn1);//Id 를 통해 XML에서의 추가버튼과 매칭.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=ed.getText().toString();//EditText에 적은 내용을 String으로 바꿔서 다른 변수에 저장.
                age=ed2.getText().toString();//EditText에 적은 내용을 String으로 바꿔서 다른 변수에 저장.
                intent=new Intent(getApplicationContext(),MyActivity.class);//MyActivity라는 클래스를 intent로 지목한다.
                intent.putExtra("name",name);//name 카테고리(?)로 변수를 집어넣고.
                intent.putExtra("age", age);//age 카테고리(?)로 변수를 집어넣고.

                startActivity(intent);//Activity 를 실행시킨다.

            }
        });


    }
}
