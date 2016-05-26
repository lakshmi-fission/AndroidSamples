package com.fission.sample.listviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by lakshmi on 23/5/16.
 */
public class MyImageViewActivity extends Activity{
    int position;
    Integer[] imageArray = new Integer[]{ R.drawable.eight,R.drawable.five,R.drawable.four,R.drawable.nine,R.drawable.one,R.drawable.seven,R.drawable.six,R.drawable.three,R.drawable.two

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myimageview_activity);
        position = getIntent().getExtras().getInt("imageposition");
        ImageView mIVimageView;
        mIVimageView = (ImageView)findViewById(R.id.imageview);
        mIVimageView.setImageResource(imageArray[position]);

    }



}
