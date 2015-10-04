package com.foodvault.foodvault;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    private EditText name;
    private EditText url;
    private EditText time;
    private EditText ingredients;
    //private EditText rating;  how to read from a rating?? data? class?
    private EditText comments;

    public void buttonOnClick(View v) {
        // do something when button is clicked
        Button button = (Button) v;

        name = (EditText) findViewById(R.id.editTitle);
        url = (EditText) findViewById(R.id.editURL);
        time = (EditText) findViewById(R.id.editTime);
        ingredients = (EditText) findViewById(R.id.editIngredients);
        //name = () findViewById(R.id.ratingBar);
        comments = (EditText) findViewById(R.id.editComments);

        String editTitleStr = name.getText().toString();
        String editURLStr = url.getText().toString();
        String editTimeStr = time.getText().toString();
        String editIngredientsStr = ingredients.getText().toString();
        String editCommentsStr = comments.getText().toString();

        DatabaseHandler db = new DatabaseHandler(this);
        Recipe myRecipe = new Recipe(editTitleStr, editURLStr, editTimeStr, editIngredientsStr, "0", editCommentsStr);
        db.addRecipe(myRecipe);
        Intent intent = new Intent(this, RecipeActivity.class);
        String idString = Integer.toString(myRecipe.getID());
        intent.putExtra("id",idString);
        startActivity(intent);

    }

}
