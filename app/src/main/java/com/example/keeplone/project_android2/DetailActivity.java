package com.example.keeplone.project_android2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private TextView menu, direction;
    private ImageView imgFood;
    private String strMenu, strImage, strDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        menu = (TextView) findViewById(R.id.txt_menu);
        direction = (TextView) findViewById(R.id.txt_direc);
        imgFood = (ImageView) findViewById(R.id.img);

        strMenu = getIntent().getStringExtra("menu");
        menu.setText(strMenu);

        strImage = getIntent().getStringExtra("image");
        Glide.with(getApplicationContext()).load(strImage).into(imgFood);

        strDirection = getIntent().getStringExtra("direction");
        direction.setText(strDirection);
    }
}
