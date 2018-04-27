package com.example.noel1.lab3s3;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment {

    //This method will create Fragment activity displayed on activity_main.xml -> FrameLayout
    @Nullable
 public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
                ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_second_fragment, container, false);
                return rootView;
         }
}
