package com.fission.sample.progressbar;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        Drawable drawable = getResources().getDrawable(R.drawable.customprogressbar);
        ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setProgressDrawable(drawable);
        progressBar.setSecondaryProgress(10);
        progressBar.setMax(100);

        progressBar.setProgress(0);
        progressBar.setTitle("");
        progressBar.setMessage("File downloading...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.show();
    }
}
