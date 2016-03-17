package com.epicodus.mysteryapp;


import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.GridView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity {
    ArrayList<Integer> pictureResIdArray = new ArrayList<>();
    @Bind(R.id.gridView) GridView mGridView;
    private TypedArray mProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);

        mGridView.setAdapter(new PictureAdapter(StoreActivity.this, prepareArrayOfIds()));
    }

    public Integer[] prepareArrayOfIds() {
        mProducts = getResources().obtainTypedArray(R.array.products);
        for (int i = 0; i < mProducts.length(); i++) {
            pictureResIdArray.add(mProducts.getResourceId(i, -1));
        }

        Integer finalPictureArray[] = new Integer[pictureResIdArray.size()];
        finalPictureArray = pictureResIdArray.toArray(finalPictureArray);
        return finalPictureArray;
    }
}
