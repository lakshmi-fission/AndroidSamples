package com.fission.sample.tillnow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by lakshmi on 23/5/16.
 */
public class ImageAdapter extends BaseAdapter{
    Context mContext;
    public ImageAdapter(Context c){
        mContext = c;

    }

    Integer[] imageArray = new Integer[]{
            R.drawable.eight,R.drawable.five,R.drawable.four,R.drawable.nine,R.drawable.one,R.drawable.seven,R.drawable.six,R.drawable.three,R.drawable.two
    };
    @Override
    public int getCount() {

        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        ImageView imageView;
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.myimageview, null, false);
       /* if(convertView==null){
            //LayoutInflater inflater = getActivity().getLayoutInflater();

            imageView = (ImageView) row.findViewById(R.id.myimageview);
       }
        else{*/
          imageView = (ImageView)row.findViewById(R.id.myimageview);
            //imageView.setPadding(8,8,8,8);

        imageView.setImageResource(imageArray[position]);
        return imageView;
    }

}
