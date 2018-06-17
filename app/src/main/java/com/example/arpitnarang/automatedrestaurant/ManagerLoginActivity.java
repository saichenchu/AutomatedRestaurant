package com.example.arpitnarang.automatedrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManagerLoginActivity extends AppCompatActivity {

    private final String USERID = "m";
    private final String PASSWORD = "m";

    String userid,password;
    EditText userid_input, password_input;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login);

        userid_input = findViewById(R.id.userid_input);
        password_input = findViewById(R.id.password_input);

        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid = userid_input.getText().toString();
                password = password_input.getText().toString();

                if (userid.equals(USERID) && password.equals(PASSWORD)) {
                    Toast.makeText(getApplicationContext(), "Login Successful.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),ManagarAreaActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Login Details!", Toast.LENGTH_SHORT).show();
                }
                userid_input.setText(null);
                password_input.setText(null);
            }

        });

    }
}
