package com.example.noel1.lab1_2;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //LinearLayout container;
    public EditText edit_name; //내가 입력할 내용을 받기 위한 EditText 변수
    public Button btn_print;//print 내용을 연결하기 위한 버튼
    public Button btn_clear;//clear 내용을 연결하기 위한 버튼
    public TextView view_print; //아래쪽에 작은 글자를 입력하기 위한 TextView 를 연결하기 위한 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //기존의 onCreate 함수를 상속받고
        setContentView(R.layout.activity_main);//우리가 작성한 layout resources을 배치.
        init();

        btn_print.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                printClicked(v);}
        });//print 버튼 클릭시 printClicked 함수 실행

        btn_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearClicked(v);}

        });//clear 버튼 클릭시 clearClicked 함수 실행
    }



    public void init(){//layout 과 activity를 연결하기 위한 함수
        btn_print=(Button)findViewById(R.id.button3); //자바 코드에서 선언한 버튼을 layout 의 버튼과 연결하기 위해서 id를 통해 연결한다.
        btn_clear=(Button)findViewById(R.id.button2);//clear 버튼을 id 를 통해 연결.
        edit_name=(EditText)findViewById(R.id.Eid);//layout 의 EditText 부분을 id 를 통해 연결.
        view_print=(TextView)findViewById(R.id.text1);//layout 의 TextView 부분을 id 를 통해 연결.

    }//init end

    public void clearClicked(View v){//EditText 부분을 Clear 버튼을 누르면 아무것도 없는것으로 만들면서 밑에 TextView 부븐을 contents 로 Set.
        edit_name.setText("");
        view_print.setText("contents");
    }

    public void printClicked(View v){//EditText 쪽에 있는 내용을 getText 로 받아서 String으로 변형 후에,아래쪽에 Textview 에 다가 값을 전달.
        String text="";
        text= edit_name.getText().toString();
        view_print.setText(text);
    }

}
