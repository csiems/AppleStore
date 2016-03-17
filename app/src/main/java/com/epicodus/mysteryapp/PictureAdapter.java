package com.epicodus.mysteryapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by Guest on 3/17/16.
 */


public class PictureAdapter extends ArrayAdapter<Image> {

    private Context mContext;
    private TypedArray mProducts;


    public PictureAdapter (Context context, TypedArray products) {
        super(context, 0);
        this.mContext = context;
        this.mProducts = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext)
                .load(mProducts.getResourceId(position, 0))
                .noFade().resize(150, 150)
                .centerCrop()
                .into(imageView);
        return imageView;
    }


}


