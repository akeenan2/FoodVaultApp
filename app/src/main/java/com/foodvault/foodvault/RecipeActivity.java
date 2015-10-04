package com.foodvault.foodvault;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    float rating = Float.parseFloat(string);
    ratingBar.setRating(rating);
}
