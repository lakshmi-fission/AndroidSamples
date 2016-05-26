package com.fission.sample.asynctaskapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    Button btnShowProgress;
    ImageView myImage;
    private ProgressDialog progressDialog;
    public static final int progressBarType=0;
    private static String imageUrl = "http://api.androidhive.info/progressdialog/hive.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowProgress=(Button)findViewById(R.id.button);
        myImage=(ImageView) findViewById(R.id.imageView);
        btnShowProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new DownLoadFileFromUrl().execute(imageUrl);
            }
        });
    }
    public class DownLoadFileFromUrl extends AsyncTask<String,String,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progressBarType);
        }

        @Override
        protected String doInBackground(String... furl) {
            int count;
            try{
                URL url = new URL(furl[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                int lenghtOfFile = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                OutputStream output = new FileOutputStream("/sdcard/downloadedfile.jpg");
                byte data[] = new byte[1024];
                long total = 0;
                while((count=input.read(data))!=-1){
                    total= total+count;
                    publishProgress(""+(int)((total*100)/lenghtOfFile));
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
            }catch (Exception e) {
                    Log.e("Error: ", e.getMessage());
            }
           return null;

        }
        @Override
        protected void onPostExecute(String imageUrl) {
            super.onPostExecute(s);
        }
    }

}
