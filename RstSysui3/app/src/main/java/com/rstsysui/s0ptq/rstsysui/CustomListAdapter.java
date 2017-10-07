package com.rstsysui.s0ptq.rstsysui;

/**
 * Created by S0ptq on 2017/10/5.
 */

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.NonNull;

/**
 * Created by S0ptq on 2017/10/5.
 */



public class CustomListAdapter extends ArrayAdapter {

    int[] imageArray;
    String[] titleArray;
    String[] descArray;
    public  CustomListAdapter(Context context, String[] title1, String[] descrip1, int [] img1){
        super(context, R.layout.mylist,R.id.item,title1);
        this.imageArray=img1;
        this.titleArray=title1;
        this.descArray=descrip1;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.mylist,parent,false);

        ImageView myImage = (ImageView) row.findViewById(R.id.icon);
        TextView myTitle = (TextView) row.findViewById(R.id.item);
        TextView myDescription = (TextView) row.findViewById(R.id.textView1);

        myImage.setImageResource(imageArray[position]);
        myTitle.setText(titleArray[position]);
        myDescription.setText(descArray[position]);
        return row;
    }
}