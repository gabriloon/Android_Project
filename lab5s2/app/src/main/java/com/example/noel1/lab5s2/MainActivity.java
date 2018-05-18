package com.example.noel1.lab5s2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edit1;//사용자가 원하는 인수값을 입력.
Button button;//시작 버튼.
TextView changeT;//한개씩 숫자가 뜨는 걸 보여주기 위한 TextView
        TextView resultT;//결과 값이 출력되는 TextView
static String str1;//사용자가 입력한 값을 옮겨받기 위한 String문.
static int num1=1;//factorial 실행시에 계산의 결과를 알기 위해서 필요한 변수.

    static int start=0;//사용자가 입력한 값을 int로 저장하기 위한 변수.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1= findViewById(R.id.edit1);//하나씩 아이디를 할당해준다.
        button = findViewById(R.id.btn1);
        changeT = findViewById(R.id.changeText);
        resultT = findViewById(R.id.resultText);
str1=edit1.getText().toString();//사용자가 입력한 내용을 옮겨받는다.
button.setOnClickListener(new View.OnClickListener(){
public void onClick(View v){//만약에 시작버튼이 눌린다면,

start=Integer.parseInt(edit1.getText().toString());//String을 int 값으로  변경.
    str1=" ";//str1 초기화.
new CountDownTask().execute();//CountDownTask 함수 실행
}
});

    }


    public void calculate(int x){//사용자한테 값을 입력받고 계산하는 factorial 을 구현한 함수.
        for(int i=x;i>0;i--){//반복문을 통해 하나씩 곱셈을 해준다.
num1*=i;
}
    }

    private class CountDownTask extends AsyncTask<Void, Integer, Void>{
          protected void onPreExecute() {
    resultT.setText("?");
          }//AsyncTask가 실행되기전에 결과를 나타내는 View 를 ?로 변경.
    @Override
    protected Void doInBackground(Void... params)
    {            for(int i=start; i>=1; i--){//사용자가 입력한 값만큼 반복
        try{Thread.sleep(500);//500millis 마다 값이 나타난다.

            publishProgress(i); //Invokes onProgressUpdate();

        }catch (Exception e){}

    }
                return null;}


protected void onProgressUpdate(Integer... values) {
              str1= str1.concat(" "+Integer.toString(values[0].intValue()));//concat 함수로 String 뒤에 하나씩 바뀌는 숫자를 붙여넣는다.
changeT.setText(str1);//TextView에 설정.
      }//여기에 숫자 값 하나씩 줄어드는 걸 입력.
        @Override


        protected void onPostExecute(Void aVoid) {
              calculate(start);//factorial 계산
        resultT.setText(String.valueOf(num1));//값의 결과를 화면에 뛰운다.
num1=1;//결과값을 저장했던 변수를 1로 설정.
start=0;
          }
    }
}
