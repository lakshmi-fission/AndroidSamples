package com.fission.sample.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Spinner spinner = (Spinner) findViewById(R.id.mySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    // ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,R.array.planets_array,android.R.layout.simple_spinner_item);
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {


       String item= (String) arg0.getItemAtPosition(position);

        Toast.makeText(getApplicationContext(),"selectedItem"+item,Toast.LENGTH_SHORT).show();

    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

}