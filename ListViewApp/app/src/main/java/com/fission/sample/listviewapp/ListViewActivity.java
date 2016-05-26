package com.fission.sample.listviewapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


public class ListViewActivity extends AppCompatActivity {
ListView mlistView;
    ImageView mimageView;
    //static ImageView mimageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mlistView = (ListView)findViewById(R.id.image_list);
        mimageView = (ImageView) findViewById(R.id.imageview);

        ImageAdapter  adapter = new ImageAdapter(this);


        mlistView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new  Intent(ListViewActivity.this,MyImageViewActivity.class);
                intent.putExtra("imageposition",position);
                startActivity(intent);


            }
        });

    }




    }

