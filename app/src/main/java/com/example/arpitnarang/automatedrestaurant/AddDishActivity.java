package com.example.arpitnarang.automatedrestaurant;


import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddDishActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText dishname_input,price_input;
    Button add_dish_button,view_dish_button;
    Spinner category_spinner;
    String dishname,category;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        dishname_input = findViewById(R.id.dishname_input);
        price_input = findViewById(R.id.price_input);

        add_dish_button = findViewById(R.id.add_dish_button);
        view_dish_button = findViewById(R.id.view_dish_button);

        category_spinner = findViewById(R.id.category_spinner);


        addDish();
        viewData();

        db = new DatabaseHelper(this);
    }

    public void addDish()
    {
        add_dish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishname = dishname_input.getText().toString();
                price = Integer.parseInt(price_input.getText().toString());
                category = category_spinner.getSelectedItem().toString();

                boolean isInserted = db.insertData(dishname, price, category);
                if (isInserted)
                    Toast.makeText(getApplicationContext(), "Dish Added.", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Error.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewData(){
     view_dish_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    Cursor resultSet = db.getData(category);
    if(resultSet.getCount() == 0){
    showMessage(null, "No Dishes Found !");
    }
    else{
    StringBuffer stringBuffer = new StringBuffer();
    while(resultSet.moveToNext()){
    stringBuffer.append("S.No. : " + resultSet.getString(0)+"\n");
    stringBuffer.append("Dish Name : " + resultSet.getString(1)+"\n");
    stringBuffer.append("Price : " + resultSet.getString(2)+"\n\n");
    }
    showMessage("Dishes",stringBuffer.toString());
    }
    }
    });
     }


    public String message_from_db;

     /**public void viewData(){
     view_dish_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    showMessage("TITLE",message_from_db);
    }
    });
     }
      **/
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}