package com.example.noel1.lab4s1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}
class MyView extends View {
    private float x, y,x2,y2;
    ArrayList<Float> xlist = new ArrayList<Float>();//마우스를 눌렀을때 x 의 시작점 좌표들을 저장합니다.
    ArrayList<Float> ylist = new ArrayList<Float>();//마우스를 눌렀을때 y 의 시작점 좌표들을 저장합니다.

    ArrayList<Float> xlist2 = new ArrayList<Float>();//마우스를 땠을때 x 의 좌표들을 저장합니다.
    ArrayList<Float> ylist2 = new ArrayList<Float>();//마우스를 땠을때 y 의 좌표들을 저장합니다.

    public MyView(Context context) {
        super(context);
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);//Canvas 의 배경 화면은 하얀색.
        Paint pnt = new Paint();
        pnt.setColor(Color.RED);//Paint 의 색깔은 빨간색으로 지정
        pnt.setStrokeWidth(20);//선의 굵기 설정.
        pnt.setStyle(Paint.Style.FILL_AND_STROKE);//선의 스타일 설정.
        for(int i=0;i<xlist2.size();i++){//반복해서 사용자가 마우스 클릭한 곳부터 마우스의 클릭을 놓는 부분까지 그려준다.
            x=xlist.get(i);//list에 저장해논 x의 좌표값을 받는다
            y=ylist.get(i);//list에 저장해논 y의 좌표값을 받는다
            x2=xlist2.get(i);//x의 마우스를 놓았을때 좌표값을 받는다
            y2=ylist2.get(i);//y의 마우스를 놓았을때 좌표값을 받는다
            canvas.drawLine(x, y,x2,y2,pnt);//canvas에 그려준다.
        }

//canvas.drawRect(a,a,a,a,pnt)
    }


    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN) {//마우스가 눌러졌을 경우
            x = (float) event.getX();//x의 좌표값 저장.
            y = (float) event.getY();//y의 좌표값 저장.
            xlist.add(x);//x 의 좌표값을 저장하는 list에다가 값을 추가해준다.
            ylist.add(y);//y 의 좌표값을 저장하는 list에다가 값을 추가해준다.
        }
        if(event.getAction()==MotionEvent.ACTION_UP) {//마우스가 놓아졌을 경우
            x2 = (float) event.getX();//x의 좌표값 저장.
            y2 = (float) event.getY();//y의 좌표값 저장.
            xlist2.add(x2);//x 의 좌표값을 저장하는 list에다가 값을 추가해준다.
            ylist2.add(y2);//y 의 좌표값을 저장하는 list에다가 값을 추가해준다.
        }
            invalidate();//시작.

        return true;
    }
}

