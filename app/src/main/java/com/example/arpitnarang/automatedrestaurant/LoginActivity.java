package com.example.arpitnarang.automatedrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button submit_button;
    EditText name_input;
    EditText mobile_input;
    String name;
    long mobile_no;
    boolean no_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name_input = findViewById(R.id.name_input);
        mobile_input = findViewById(R.id.mobile_input);

        submit_button = findViewById(R.id.submit_button);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_error = true;
                try {
                    name = name_input.getText().toString();
                    mobile_no = Long.parseLong(mobile_input.getText().toString());
                } catch (Exception e) {
                    no_error = false;
                    Toast.makeText(getApplicationContext(), "Error! Try Again.", Toast.LENGTH_SHORT).show();
                    name_input.setText(null);
                    mobile_input.setText(null);
                }

                if (no_error) {
                    int tempLength = (String.valueOf(mobile_no)).length();

                    if (name.length() < 3) {
                        Toast.makeText(getApplicationContext(), "Name too short!", Toast.LENGTH_SHORT).show();
                        no_error = false;
                    }

                        if (tempLength < 10) {
                            Toast.makeText(getApplicationContext(), "Incomplete Number!", Toast.LENGTH_SHORT).show();
                        } else if (tempLength > 10) {
                            Toast.makeText(getApplicationContext(), "Check for extra digits!", Toast.LENGTH_SHORT).show();
                        } else {
                            if (no_error) {
                                Toast.makeText(getApplicationContext(), "Details Submitted.", Toast.LENGTH_SHORT).show();
                                name_input.setText(null);
                                mobile_input.setText(null);
                                Intent i = new Intent(LoginActivity.this, MainMenuActivity.class);
                                startActivity(i);
                            }
                        }
                    }
                }

        });

        submit_button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent i = new Intent(LoginActivity.this, ManagerLoginActivity.class);
                startActivity(i);
                return false;
            }
        });

    }
}