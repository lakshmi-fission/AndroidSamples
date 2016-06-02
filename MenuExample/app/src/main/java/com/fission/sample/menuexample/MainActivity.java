package com.fission.sample.menuexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alertDialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.alertDialog);
                builder.setTitle(R.string.alertDialogTitle);
                int icon = R.drawable.index;
                builder.setIcon(icon);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "you selected yes", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "you selected no", Toast.LENGTH_SHORT).show();
                    }

                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            case R.id.item1:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder1.setView(inflater.inflate(R.layout.activity_main,null));
                builder1.setTitle(R.string.Title);
                builder1.setPositiveButton(R.string.forPositiveBtn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "you selected required", Toast.LENGTH_SHORT).show();
                    }
                });
                builder1.setNegativeButton(R.string.forNegativeBtn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "you selected no", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog1 = builder1.create();
                dialog1.show();
                    return true;
            case R.id.dialogextended:
               // Button button1,button2;
                final Dialog dialog3 = new Dialog(this);
                dialog3.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog3.setContentView(R.layout.dialogextendlayout);
               // dialog3.setTitle("Dialog");

                Button button1=(Button) dialog3.findViewById(R.id.btnSave);
                Button  button2 = (Button) dialog3.findViewById(R.id.btnCancel);

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog3.dismiss();
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog3.dismiss();

                    }
                });

                dialog3.show();
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }
}