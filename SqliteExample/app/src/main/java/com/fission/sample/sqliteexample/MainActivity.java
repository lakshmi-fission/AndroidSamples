package com.fission.sample.sqliteexample;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by lakshmi on 1/6/16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ExampleDBHelper mydatabase;
    private EditText mNameEdt,mPhnoEdt,mBranchEdt;
    Button mInsertBtn,mDeleteBtn,mShowOneBtn,mShowAllBtn;
    ListView mListView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEdt = (EditText)findViewById(R.id.usernameEdt) ;
        mPhnoEdt = (EditText)findViewById(R.id.phnodEdt);
        mBranchEdt = (EditText)findViewById(R.id.personBranchEdt);
        mInsertBtn = (Button)findViewById(R.id.insert);
        mDeleteBtn = (Button)findViewById(R.id.delete);
        mShowOneBtn = (Button)findViewById(R.id.showone);
        mShowAllBtn = (Button)findViewById(R.id.showall);
        mInsertBtn.setOnClickListener(this);
        mDeleteBtn.setOnClickListener(this);
        mShowAllBtn.setOnClickListener(this);
        mShowOneBtn.setOnClickListener(this);
        mydatabase = new ExampleDBHelper(this);
        }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.delete:
                Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.delete_dialog);
                dialog.show();
               final EditText deleteName =(EditText)dialog.findViewById(R.id.deleteName);
                Button okbtn = (Button)dialog.findViewById(R.id.okBtn);
                if (okbtn != null)
                    okbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = deleteName.getText().toString();
                            mydatabase.deleteContact(name);
                            Toast.makeText(getApplicationContext(), name + " Related data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                break;
            case R.id.insert:
                String name = mNameEdt.getText().toString();
                String phno = mPhnoEdt.getText().toString();
               String  branch = mBranchEdt.getText().toString();
                boolean inserted = mydatabase.insertPerson(name,phno,branch);
                if(inserted){
                Toast.makeText(getApplicationContext(),"Data inserted Successfully",Toast.LENGTH_SHORT).show();}
                else
                {
                    Toast.makeText(getApplicationContext()," Duplicate data not allowed ",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.showall:
                Intent intent =new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
                /*setContentView(R.layout.showall_layout);
                mListView = (ListView) findViewById(R.id.listView);
               Cursor res = mydatabase.showAll();


                res.moveToFirst();
                String[] columns = new String[]{ExampleDBHelper.PERSON_COLUMN_ID,ExampleDBHelper.PERSON_COLUMN_BRANCH,
                      ExampleDBHelper.PERSON_COLUMN_NAME,ExampleDBHelper.PERSON_COLUMN_PHNO
                };
                int[] rows = new int[]{
                        R.id.personIdTxt,R.id.personBranchTxt,R.id.personNameTxt,R.id.personPhnoTxt
                };
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,R.layout.adapter_view,res,columns,rows,0);
                mListView.setAdapter(cursorAdapter);*/
                break;
            case R.id.showone:
                Dialog dialog1 = new Dialog(this);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.showone_dialog);
                dialog1.show();
                final EditText showName= (EditText)dialog1.findViewById(R.id.showName);
                Button okbtn1 = (Button) dialog1.findViewById(R.id.showBtn);
                if (okbtn1 != null)
                    okbtn1.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Cursor res = mydatabase.showOne(showName.getText().toString());
                            if(res.getCount()==0){
                                Toast.makeText(getApplicationContext()," There is No details for entered name ",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                res.moveToFirst();
                            String personBranch=res.getString(res.getColumnIndex(ExampleDBHelper.PERSON_COLUMN_BRANCH));
                            String personPhno=res.getString(res.getColumnIndex(ExampleDBHelper.PERSON_COLUMN_PHNO));
                            String personName=res.getString(res.getColumnIndex(ExampleDBHelper.PERSON_COLUMN_NAME));
                            Toast.makeText(getApplicationContext(),showName.getText().toString()+ " related data",Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),personName,Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),personBranch,Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),personPhno,Toast.LENGTH_SHORT).show();
                            }
                           // Log.e("A","personName"+personName);
                            //Log.e("A","personBranch"+personBranch);
                           // Log.e("A","personPhno"+personPhno);
                           // Log.e("personName",personName);
                            //Log.e("personbranch",personBranch);
                            //Log.e("personPhno",personPhno);
                            if(!res.isClosed()){
                                res.close();
                            }
                        }
                    });
                break;
        }

    }

   /* @Override
   public void onBackPressed() {
        super.onBackPressed();
        setContentView(R.layout.activity_main);
    }*/
}

