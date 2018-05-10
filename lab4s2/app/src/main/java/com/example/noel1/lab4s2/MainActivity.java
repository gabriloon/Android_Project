package com.example.noel1.lab4s2;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear2;//두번째 초록생 창
    Button btn;//Animation 을 통해 버튼의 text를 바꾸기 위한 Button
    int index=0;//처음에 버튼을 누르지 않았을 경우 INDEX=0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear2=(LinearLayout)findViewById(R.id.Lin2);//xml 의 두번째 linear 지정.
        btn=(Button)findViewById(R.id.button);//Button 지정.

        btn.setOnClickListener(new View.OnClickListener(){//버튼을 눌렀을 경우
            public void onClick(View v){
                if(index==0){//첫 linear Layout 창이 떠있는 상태에서 버튼을 누를경우,
                    Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.leftslide);//leftslide Animation  호출.
                    linear2.setVisibility(View.VISIBLE);//두번째 linear Layout 창을 gone -> Visible
                    linear2.startAnimation(anim1);//Animation 시작.
                    btn.setText("CLOSE PAGE");//Button 의 Text 변경.
                    index=1;//index 값 변경
                }//if문 index 0
                else if(index ==1){//두번째 linear Layout 창이 Visible 한 상태에서 버튼을 누를경우,
                    Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rightslide);//rightslide Animation  호출.
                    linear2.startAnimation(anim2);//Animation 시작.
                    linear2.setVisibility(View.GONE);//두번째 linear Layout 창을  Visible -> gone
                    btn.setText("OPEN PAGE");//Button 의 Text 변경.
                    index=0;
                }//if 문 index 1

            }

        });
    }

}