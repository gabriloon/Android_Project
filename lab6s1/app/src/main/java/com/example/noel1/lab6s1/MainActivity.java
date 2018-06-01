package com.example.noel1.lab6s1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText txt1;//글의 내용을 쓰기 위한 EditText
    Button writeBtn;//저장 버튼
    Button readBtn;//불러오기 버튼
    Button clearSc;//초기화 버튼
    Button finishB;//종료 버튼
FileInputStream fis=null;//txt 파일을 읽어 오기 위한 Stream
FileOutputStream fous=null;//txt 파일에 보내기 위한 Stream
InputStreamReader input;//좀더 inputStream 을 편하게 해준다.
    OutputStreamWriter output;//좀더 outputStream 을 편하게 해준다.

    char[] buffer;//임시 저장 공간 선언
    int cnt =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    txt1=findViewById(R.id.txtData);//Id와 레이아웃의 view,Button을 매칭
    writeBtn= findViewById(R.id.btn1);
    readBtn = findViewById(R.id.btn3);
    clearSc=findViewById(R.id.btn2);
    finishB = findViewById(R.id.btn4);





        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//저장 버튼이 눌렸을시에,

                try {
                    File sdCard = Environment.getExternalStorageDirectory();//외부의 SD 카드에서 읽어오고,
                    File directory = new File (sdCard.getAbsolutePath() +
                            "/MyFiles");//경로를 지정해준다.
                    directory.mkdirs();
                    File file = new File(directory, "textfile.txt");//textfile 이라는 txt 파일을 가리킨다.
                    FileOutputStream fOut = new FileOutputStream(file);//outputStream 으로 연결 및 행동 결정.
                    output = new OutputStreamWriter(fOut);
                    BufferedWriter bufw = new BufferedWriter(output);
                    bufw.write(txt1.getText().toString());//EditText 의 적혀 있는 내용을 보낸다.

                    bufw.close();// 할당해준거 종료.
                }catch(IOException e){
                    e.printStackTrace();
                }

//output.write(txt1.getText());
                Toast.makeText(getApplicationContext(),"Done writing SD 'data.txt",Toast.LENGTH_LONG).show(); //저장 버튼을 눌렀을시에 알림.
            }
        });

        readBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                try {
                    File sdCard = Environment.getExternalStorageDirectory();//외부의 SD 카드에서 읽어오고,
                    File directory = new File (sdCard.getAbsolutePath() +
                            "/MyFiles");//경로 지정.
                    directory.mkdirs();
                    File file = new File(directory, "textfile.txt");//textfile 이라는 이름의 txt 파일을 가리킨다.
                    FileInputStream fIn = new FileInputStream(file);//inputStream 으로 연결 및 행동 결정.
                    input= new InputStreamReader(fIn);
                    BufferedReader bufr = new BufferedReader(input);
                    String temp;

                    while((temp= bufr.readLine())!=null){//한줄씩 null 일때까지 읽어온다.
                        txt1.append(temp);//읽어온것을 이어서 붙인다.
                    }
                    bufr.close();//할당해준것을 원래대로 종료.
                }catch(IOException e){
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),"Done reading SD 'data.txt",Toast.LENGTH_LONG).show();//불러오기 버튼을 눌렀을시에 알림.
            }
        });


        clearSc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        txt1.setText("");
    }
});//초기화 버튼이 눌렸을 시에 EditText를 ""로 바꾼다..
finishB.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v) {
        finish();
    }
});//Finish 버튼이 눌렸을 시에 앱 종료.

//        input = new FileInputStream("C:/Temp/data.txt", true);
  //      output = new FileOutputStream("C:/MyJava/data.txt", true);

    }
}
