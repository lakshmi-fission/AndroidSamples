package com.fission.sample.gelleryimage1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by lakshmi on 24/5/16.
 */
public class ImageViewActivity extends Activity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        imageView = (ImageView)findViewById(R.id.img);

        Bundle extras = getIntent().getExtras();

        if(extras != null) {

            String path = extras.getString("path");



            Bitmap bitmap = BitmapFactory.decodeFile(path);
            imageView.setImageBitmap(bitmap);
        }


    }


}
