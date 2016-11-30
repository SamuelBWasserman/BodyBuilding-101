package com.samuelstudios.gainsmaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class DietPlan extends AppCompatActivity {

    EditText input;
    TextView list;
    MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);

        input=(EditText) findViewById(R.id.editText);
        list=(TextView) findViewById(R.id.list);
        dbHandler=new MyDBHandler(this,null,null,1);
        printDatabase();
    }

    public void printDatabase()
    {
        String dbString=dbHandler.databaseToString();
        list.setText(dbString);
        input.setText("");
    }

    //add a product to the database
    public void addButtonClicked(View view)
    {
        FoodItems food=new FoodItems(input.getText().toString());
        dbHandler.addFood(food);
        printDatabase();
    }
    //delete a product from the database
    public void deleteButtonClicked(View view)
    {
        String inputText=input.getText().toString();
        dbHandler.deleteFood(inputText);
        printDatabase();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_diet_plan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
