package com.fission.sample.internalmemoryexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText mEditxt1,mEditxt2;
    Button mReadbtn,mSavebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditxt1=(EditText) findViewById(R.id.edittxt1);
        mEditxt2 =(EditText) findViewById(R.id.edittxt2);
        mReadbtn= (Button) findViewById(R.id.readbtn);
        mSavebtn=(Button) findViewById(R.id.savebtn);
        mSavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String fileName = mEditxt1.getText().toString();
                String data = mEditxt2.getText().toString();
                try{
                FileOutputStream fout= openFileOutput(fileName,Context.MODE_PRIVATE);
                    fout.write(data.getBytes());
                    fout.close();
                    Toast.makeText(getApplicationContext(),fileName+ "  saved",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
        mReadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName=mEditxt1.getText().toString();
                StringBuffer string = new StringBuffer();
                try{
                   // FileInputStream fileInputStream = openFileInput(fileName);
                    BufferedReader inputStream = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
                    String inputString;
                    while((inputString=inputStream.readLine())!=null){
                        string.append(inputString+"\n");
                        Log.e("String==>",""+string);
                        Toast.makeText(getApplicationContext(),"internallystoreddata   "+ string.toString(),Toast.LENGTH_LONG).show();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                /*try{
                FileInputStream fileInputStream = openFileInput(fileName);
                    int i=0;
                    while((i=fileInputStream.read())!=-1){
                      System.out.print((char)i);

                    }
                    fileInputStream.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }*/
            }
        });
    }
}
