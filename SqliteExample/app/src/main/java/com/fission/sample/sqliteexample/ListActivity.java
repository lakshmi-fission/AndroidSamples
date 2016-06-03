package com.fission.sample.sqliteexample;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by lakshmi on 3/6/16.
 */
public class ListActivity extends Activity {
    ExampleDBHelper myData = new ExampleDBHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showall_layout);
        ListView mListView = (ListView)findViewById(R.id.listView);
        Cursor res = myData.showAll();
        if(res.getCount()==0){
            Toast.makeText(getApplicationContext(),"There is No Data",Toast.LENGTH_SHORT).show();
        }
        res.moveToFirst();
        String[] columns = new String[]{ExampleDBHelper.PERSON_COLUMN_ID,ExampleDBHelper.PERSON_COLUMN_BRANCH,
                ExampleDBHelper.PERSON_COLUMN_NAME,ExampleDBHelper.PERSON_COLUMN_PHNO
        };
        int[] rows = new int[]{
                R.id.personIdTxt,R.id.personBranchTxt,R.id.personNameTxt,R.id.personPhnoTxt
        };
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,R.layout.adapter_view,res,columns,rows,0);
        mListView.setAdapter(cursorAdapter);


}}
