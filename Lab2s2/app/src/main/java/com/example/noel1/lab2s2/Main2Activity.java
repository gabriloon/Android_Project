package com.example.noel1.lab2s2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class Main2Activity extends AppCompatActivity {
    String Surl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);//activity 지정
    TextView text1=findViewById(R.id.Tex1);//TextView 를  id를 통해 XML 과 java와 연결.
    Button button1 = findViewById(R.id.bt1);//GO 버튼을  id를 통해 XML 과 java와 연결.
        Button button2 = findViewById(R.id.bt2);//BACK 버튼을  id를 통해 XML 과 java와 연결.

        Intent intent=getIntent(); //Intent 지목당한것을 get 해준다.
Surl=intent.getStringExtra("URL");//Intent 안에 존재하는 URL 카테고리에 있는 값을 다른 String 문장에 저장.
        text1.setText(Surl);//TextView 의 써져있는것을 위에 String 문장안에 값으로 바꾼다.


button1.setOnClickListener(new View.OnClickListener() { //GO 버튼이 눌러졌을경우,
    @Override
    public void onClick(View v) {

        if(Surl.equals("")){//만약에 MainActivity 에서 URL 값을 입력하지 않은경우.
            Toast.makeText(getApplicationContext(),"주소를 다시 입력해주세요",Toast.LENGTH_LONG).show();}//다시 입력하라고 알려준다.
        else{
Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+Surl));//입력한 EditText 의 URL 값을 통해 인터넷 연결을 한다.
startActivity(intent);
    }
    }
});



button2.setOnClickListener(new View.OnClickListener() {//BACK 버튼이 눌러졌을경우,
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);//MainActivity 를 지목해주고.
        intent.putExtra("Extra","Ex");//처음 시작할때의 화면과 BACK버튼이 눌려졌을 경우의 Activity 를 구별하기 위해서 값을 집어넣는다.
        startActivity(intent);//Activity 실행.
    }
});
    }}
