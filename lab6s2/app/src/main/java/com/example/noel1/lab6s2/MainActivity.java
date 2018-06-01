package com.example.noel1.lab6s2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText student; //학번 EditText
    EditText name;//이름 EditText

    Button readB;//불러오기 버튼
Button saveB;//저장하기 버튼
Button clearB;//초기화 버튼
SharedPreferences sh_pref;//임시 저장하기 위한 선언.
SharedPreferences.Editor sh_edit;

String username,studentNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student = findViewById(R.id.sn);//Id 와 Layout의 뷰,버튼 들을 매칭.
        name= findViewById(R.id.sn2);

        readB= findViewById(R.id.btn1);
        saveB = findViewById(R.id.btn2);
        clearB= findViewById(R.id.btn3);


        readB.setOnClickListener(new View.OnClickListener(){//불러오기 버튼이 눌린다면,
public void onClick(View v){

sh_pref=getSharedPreferences("Login Credent",MODE_PRIVATE);//Login Credent 라는 이름의 임시저장소.
if(sh_pref !=null &&sh_pref.contains("UserName")&&sh_pref.contains("StudentNumber")){//null이 아니며,
// 이름과 학번이 등록되어있는지 확인
    String Sname= sh_pref.getString("UserName","noname");//key가 UserName 인것을 통해 이름을 불러온다
    name.setText(Sname);//EditText 에 저장되어 있는 이름을 적는다.

    String number= sh_pref.getString("StudentNumber","noname");//Key를 통해 학번을 불러온다.
    student.setText(number);//EditText 에 저장되어 있는 학번을 적는다.
}
}

        });


        saveB.setOnClickListener(new View.OnClickListener(){//저장하기 버튼이 눌린다면,
            public void onClick(View v){
username=name.getText().toString();//EditText 에서 이름을 읽어와서 변수에 할당.
studentNumber=student.getText().toString();//EditText 에서 학번을 읽어와서 변수에 할당.
sh_pref=getSharedPreferences("Login Credent",MODE_PRIVATE);
sh_edit=sh_pref.edit();//sh_pref의 내용을 수정
sh_edit.putString("StudentNumber",studentNumber);//학번과 이름을 key값을 대입하면서 저장한다.
sh_edit.putString("UserName",username);
sh_edit.commit();//임시로 바뀐 내용을 저장.
            }

        });


        clearB.setOnClickListener(new View.OnClickListener() {//초기화 버튼이 눌린다면,
            @Override
            public void onClick(View v) {
                student.setText("");//EditText를 ""로 초기화
                name.setText("");
            }
        });

    }
}
