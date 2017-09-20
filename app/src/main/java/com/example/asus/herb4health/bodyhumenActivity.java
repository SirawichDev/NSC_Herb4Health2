package com.example.asus.herb4health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bodyhumenActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyhumen);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bodyhumenActivity.this,Disease.class);
                startActivity(intent);
            }
        });

    }



    public void GoMain2(View v) {
        Intent b = new Intent(this, MainActivity.class);
        startActivity(b);
    }

    public void GoDisease(View v) {
        Intent c = new Intent(this, Disease.class);
        startActivity(c);
    }
}
