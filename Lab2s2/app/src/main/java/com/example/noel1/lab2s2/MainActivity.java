package com.example.noel1.lab2s2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    String config;//기존 String 값은 null이다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//activity 지정

        Button button= (Button)findViewById(R.id.mbt);//Next버튼 id를 통해 XML 과 java와 연결.
        edit=(EditText)findViewById(R.id.Edt1);//UML 을 입력하는 부분 id를 통해 XML 과 java와 연결.

    Intent intent=getIntent();//Main2Activity 에서 뒤로가기 버튼을 눌렀을 경우 지목당한 Intent를 받아주기 위한 문장.
        config=intent.getStringExtra("Extra");//String 변수에 값을 넣음으로써 뒤로가기 버튼을 눌린후에 이 Activity로 온건지 확인하기 위한 문장.
if(!(config == null)){
    Toast.makeText(getApplicationContext(),"뒤로가기버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();//Toast 문장.
}



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Next 버튼이 눌렸을시에,
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);//Main2Activity를 지목한다.
                String str=edit.getText().toString();//EditText 칸에 입력한 UML 값을 str로 저장후에.
               intent.putExtra("URL",str);//intent 안에 값을 넣는다.
                startActivity(intent);//activity를 불러온다..
            }
        });
    }
}
