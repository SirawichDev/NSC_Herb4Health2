package com.example.asus.herb4health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Disease extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
    }



    public void GoBody4(View v) {
        Intent c = new Intent(this, bodyhumenActivity.class);
        startActivity(c);
    }
}
