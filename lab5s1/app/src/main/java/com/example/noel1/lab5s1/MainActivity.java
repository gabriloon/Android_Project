package com.example.noel1.lab5s1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.dimg1);//첫번째 이미지
        imageView2 = (ImageView) findViewById(R.id.dimg2);//두번째 이미지
        editText = (EditText) findViewById(R.id.editlog);//이미지가 변화하는 내용을 알려주는 부분.
        button = (Button) findViewById(R.id.btn);//이미지 변화 시작 버튼
        button.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
DogThread thread1 = new DogThread(0);//각각의 이미지에 쓰레드를 할당해준다.
DogThread thread2= new DogThread(1);
thread1.start();//thread 2 개를 시작해준다.
thread2.start();
            }}
            );

    }


class DogThread extends Thread{//Thread 를 상속받은 특유의 Thread
int Dindex; //thread 를 비교하기 위해서.
int stateindex;//그림이 어떤 그림인지 확인.
        ArrayList<Integer>images = new ArrayList<Integer>();//이미지들을 저장하는 list

        public DogThread(int index){
           Dindex=index;
            images.add(R.drawable.dog1);//이미지들을 하나씩 저장.
            images.add(R.drawable.dog2);
            images.add(R.drawable.dog3);
        }
        public void run(){ //Thread 를 실행시키면 하는 행동을 정하는 메소드.
            stateindex=0;//초기의 값은 0
            for(int i=0;i<9;i++){
final String msg = "dog#"+ Dindex+"state"+stateindex;//그림의 변화를 알려주는 String문
handler.post(new Runnable(){//handler 로 run 문장을 자동으로 처리해준다.
    public void run(){
editText.append(msg+" \n");//하나씩 다음 문장이 이전문장의 다음줄에 생성.
if(Dindex==0){
    imageView1.setImageResource(images.get(stateindex));//이미지 설정1.
}
else if(Dindex==1){
    imageView2.setImageResource(images.get(stateindex));//이미지 설정2.
}}
});
              try{int sleepTime= getRandomTime(500,3000);//임의의 랜덤값 생성.
              Thread.sleep(sleepTime);//sleepTime 만큼 행동을 하지 않는다.
              } catch (InterruptedException e){
                  e.printStackTrace();
              }
            stateindex++;//그림이 한 단계씩 변화.
            if(stateindex >= images.size()){stateindex=0;}//혹시 모를 예외상황을 대비해서 선언해준다.


            }



                }

            }
        public int getRandomTime(int min,int max){//Math 함수를 통해서 랜덤한 시간이 나오는데 특별한 계산을 통해 결과를 내보낸다.
            return min+(int)(Math.random()*(max-min));
        }
}



