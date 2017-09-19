package com.example.asus.herb4health;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by sirawich on 9/6/2017 AD.
 */

public class ImageListAdapter extends ArrayAdapter {
    private Activity context;
    private int resource;
    private List<ImageUploadConfig> listimg;

    public ImageListAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        listimg=  objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(resource,null);
        TextView tvName = (TextView)v.findViewById(R.id.tvImagename);
        TextView tvOption = (TextView)v.findViewById(R.id.tvImageoption);
        ImageView img = (ImageView)v.findViewById(R.id.imgView);

        tvName.setText("ชื่อสมุนไพร :"+listimg.get(position).getname());
        tvOption.setText("สรรพคุณ :"+listimg.get(position).getOption());

        Glide.with(context).load(listimg.get(position).geturl()).into(img);
        return v;

    }
}
