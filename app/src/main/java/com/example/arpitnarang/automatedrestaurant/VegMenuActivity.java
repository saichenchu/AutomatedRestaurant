package com.example.arpitnarang.automatedrestaurant;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VegMenuActivity extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);

    ListView veg_list_view;
    TextView no_dishes_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_menu);

        veg_list_view = findViewById(R.id.veg_list_view);
        no_dishes_text_view = findViewById(R.id.no_dishes_text_view);

        Cursor resultSet = db.getData("Veg");

        String[] fromFieldNames = new String[] {};

        if(resultSet.getCount()==0){
            no_dishes_text_view.setText("No Dishes");
        }
        else{

            }
        }
    }
