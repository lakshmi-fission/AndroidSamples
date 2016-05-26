package com.fission.sample.gelleryimage1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_IMAGE_GET = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.mainbtn);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent launchGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(launchGallery, REQUEST_IMAGE_GET);
                }

            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {

            Uri selectedImage = data.getData();

            String mCurrentPhotoPath = null;

            if (selectedImage.toString().contains("content:")) {
                mCurrentPhotoPath = getPathFromURI(this, selectedImage);

            } else if (selectedImage.toString().contains("file:")) {
                mCurrentPhotoPath = selectedImage.getPath();
            }


            Log.e("A", "uri = " + selectedImage);

            Intent sendIntent = new Intent(MainActivity.this, ImageViewActivity.class);
            sendIntent.putExtra("path", mCurrentPhotoPath);
            startActivity(sendIntent);

            Log.e("A", "path = " + mCurrentPhotoPath);
        }
    }

    public String getPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        String path = null;
        try {
            String[] projection = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, projection, null, null, null);
            int column_index;
            if (cursor != null) {
                column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                path = cursor.getString(column_index);
            }
            return path;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
