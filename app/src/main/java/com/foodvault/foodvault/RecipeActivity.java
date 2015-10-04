package com.foodvault.foodvault;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        DatabaseHandler db = new DatabaseHandler(this);
        db.addRecipe(new Recipe(1, "Enchiladas", "https://allrecipes.com", "40", "flour", "5",
                "Great Recipe"));
        Recipe thisRecipe = db.getRecipe(1);

        TextView recipeName = (TextView) findViewById(R.id.textView1);
        recipeName.setText(thisRecipe.getName());
        TextView recipeUrl = (TextView) findViewById(R.id.textView2);
        recipeUrl.setText(thisRecipe.getUrl());
        TextView recipePrepTime = (TextView) findViewById(R.id.textView3);
        recipePrepTime.setText(thisRecipe.getPrepTime());
        TextView recipeIngredients = (TextView) findViewById(R.id.textView4);
        recipeIngredients.setText(thisRecipe.getIngredients());
        TextView recipeRating = (TextView) findViewById(R.id.textView5);
        recipeRating.setText(thisRecipe.getRating());
        TextView recipeComments = (TextView) findViewById(R.id.textView6);
        recipeComments.setText(thisRecipe.getComments());
    }
}
