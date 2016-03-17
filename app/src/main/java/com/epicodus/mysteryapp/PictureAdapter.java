package com.epicodus.mysteryapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by Guest on 3/17/16.
 */


public class PictureAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private Integer[] imageUrls;

    public PictureAdapter(Context context, Integer[] imageUrls) {
        super(context, R.layout.gridview_item_image, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.gridview_item_image, parent, false);
        }

        Picasso
                .with(context)
                .load(imageUrls[position])
                .fit() // will explain later
                .into((ImageView) convertView);

        return convertView;
    }
}


