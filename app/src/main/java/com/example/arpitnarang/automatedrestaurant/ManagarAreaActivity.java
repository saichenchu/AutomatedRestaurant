package com.example.arpitnarang.automatedrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagarAreaActivity extends AppCompatActivity {

    Button add_dish_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managar_area);

        add_dish_button = findViewById(R.id.add_dish_button);

        add_dish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManagarAreaActivity.this,AddDishActivity.class);
                startActivity(i);
            }
        });

    }
}
