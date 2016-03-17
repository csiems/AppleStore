package com.epicodus.mysteryapp;


import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity {
    ArrayList<Integer> pictureResIdArray = new ArrayList<>();
    static Integer[] finalPictureArray;
    @Bind(R.id.gridView) GridView mGridView;
    private TypedArray mProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);

        prepareArrayOfIds();

        mGridView.setAdapter(new PictureAdapter(StoreActivity.this, finalPictureArray));

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(StoreActivity.this, ItemActivity.class);
                intent.putExtra("product", position);
                startActivity(intent);
            }
        });
    }

    public void prepareArrayOfIds() {
        mProducts = getResources().obtainTypedArray(R.array.products);
        for (int i = 0; i < mProducts.length(); i++) {
            pictureResIdArray.add(mProducts.getResourceId(i, -1));
        }

        finalPictureArray = new Integer[pictureResIdArray.size()];
        finalPictureArray = pictureResIdArray.toArray(finalPictureArray);
    }
}
