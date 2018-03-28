package com.example.noel1.lab1_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    ImageView imageView ;//ImageView 를 layout 에서 받아오기 위한 변수 선언.
    ImageView imageView2;//ImageView 를 layout 에서 받아오기 위한 변수 선언.
    int imageIndex =0;//이 변수의 값을 통해 버튼이 눌려서 어떤 그림이 나와야 되는지를 알 수 있다.
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//기존의 onCreate 함수를 상속 받는다.
        setContentView(R.layout.activity_main);//우리가 작성한 layout resources을 배치.


        imageView = (ImageView)findViewById(R.id.redI);//레이아웃의 그림을 연결하기 위한 ImageView 변수
        imageView2=(ImageView)findViewById(R.id.blueI);//레이아웃의 그림을 연결하기 위한 ImageView 변수

        Button button =(Button)findViewById(R.id.button); //레이아웃의 change image 버튼과의 연결
        button.setOnClickListener(new View.OnClickListener(){ //change image 버튼이 눌렸을 경우 .
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); //xml 문서의 리소스를 받아 객체를 생성해준다.
                imageIndex++;
                changeImage(); //changeImage 함수 호출
            }

            private void changeImage() {//change image 버튼이 눌릴때마다 imageIndex 값이 증가해서 어떤게 Visible 해야하고, 어떤것이 inVisible 하는지 판단해준다.
                if (imageIndex % 2 == 0) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                } else if (imageIndex % 2 == 1) {
                    imageView.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);};
            }
        });
    }

}