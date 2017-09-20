package com.example.asus.herb4health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetail extends AppCompatActivity {

    private ImageView image;
    private TextView tvBreed, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        image = (ImageView) findViewById(R.id.image);
        tvBreed = (TextView) findViewById(R.id.tvBreed);
        tvDescription = (TextView) findViewById(R.id.tvDescription);

        int resId = getIntent().getIntExtra("image", 0);
        String breed = getIntent().getStringExtra("breed");
        String description = getIntent().getStringExtra("description");

        image.setImageResource(resId);
        tvBreed.setText(breed);
        tvDescription.setText(description);

        //Log.d("Herb","resID ="+resId);
        //Log.d("Herb","breed ="+breed);
        // Log.d("Herb","description ="+description);


    }
}
