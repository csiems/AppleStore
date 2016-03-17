package com.epicodus.mysteryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemActivity extends AppCompatActivity {
    @Bind(R.id.productImage) ImageView productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

        int position = getIntent().getIntExtra("product", -1);
        if (position != -1) {
            Picasso.with(ItemActivity.this)
                    .load(StoreActivity.finalPictureArray[position])
                    .noFade()
                    .resize(800,800)
                    .centerCrop()
                    .into(productImage);
        }
    }
}
