package com.example.arpitnarang.automatedrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    DatabaseHelper db;

    Button waiter_button,veg_button,nonveg_button,drinks_button,desserts_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        db = new DatabaseHelper(this);

        waiter_button = findViewById(R.id.waiter_button);

        veg_button = findViewById(R.id.veg_button);
        veg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),VegMenuActivity.class);
                startActivity(i);
            }
        });

        waiter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Waiter has been called. Please wait.", Toast.LENGTH_LONG).show();
            }
        });

    }

}
