package com.example.fuffy.ee461lhomework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enter = findViewById(R.id.enter_location_button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
        //startActivity(new Intent(), MapsActivity);
    }
}
