package com.fission.sample.tillnow;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class ListViewFragment extends Fragment{
ListView mListView;
    ImageView mImageView;

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        setHasOptionsMenu(true);
        final View listView = inflater.inflate(R.layout.listview_layout,container,false);
        mListView = (ListView)listView.findViewById(R.id.image_list);
        mImageView = (ImageView)listView.findViewById(R.id.onClickImage);
        ImageAdapter  adapter = new ImageAdapter(getActivity());
        setHasOptionsMenu(true);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListView.setVisibility(View.VISIBLE);
                mImageView.setVisibility(View.GONE);
            }
        });
        mListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListView.setVisibility(View.GONE);
                mImageView.setVisibility(View.VISIBLE);
                ImageAdapter imageAdapter = new ImageAdapter(getActivity());
                mImageView.setImageResource(imageAdapter.imageArray[position]);

    }
    });
        return  listView;
}
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.alertDialog);
        builder.setTitle(R.string.alertDialogTitle);
        int icon = R.drawable.index;
        builder.setIcon(icon);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("preference", Context.MODE_PRIVATE);
               SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putBoolean("isLogin",false);
                editor1.commit();
                Toast.makeText(getActivity(), "you selected yes", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                LoginFragment loginFragment = new LoginFragment();
                fragmentTransaction.replace(R.id.container,loginFragment);
                fragmentTransaction.commit();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "you selected no", Toast.LENGTH_SHORT).show();
            }

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
        return true;


}}