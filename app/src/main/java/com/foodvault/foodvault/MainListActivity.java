package com.foodvault.foodvault;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainListActivity extends Activity {
    /*private String[] recipesArray = {"cake", "soup", "smoothie", "salad"};

    private ListView RecipesListView;
    private ArrayAdapter arrayAdapter;

    /** Called when the activity is first created. */

    ListView list;
    String [] foodTitles;
    String [] foodDescriptions;
    int [] images={R.drawable.foodvaultbutton};

    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        db.addRecipe(new Recipe("Enchiladas","https://allrecipes.com","40","flour","4","Great Recipe"));
        db.addRecipe(new Recipe("Nutella Cookies",
                "http://kirbiecravings.com/2014/05/4-ingredient-chewy-nutella-cookies.html","30",
                "all purpose flour, extra large egg, Nutella, baking powder","4.5","Really soft."));
        db.addRecipe(new Recipe("White Chocolate Macadamia Nut Cookies",
                "http://allrecipes.com/recipe/10025/white-chocolate-macadamia-nut-cookies-iii/",
                "45","butter, light brown sugar, white sugar, eggs, vanilla extract, almond extract, " +
                "all purpose flour, baking soda, salt, macadamia nuts, white chocolate","5","The " +
                "thinner the better!"));
        db.addRecipe(new Recipe("Peanut Butter Cookies",
                "http://allrecipes.com/recipe/10275/classic-peanut-butter-cookies/","85","unsalted " +
                "butter, peanut butter, white sugar, brown sugar, eggs, all purpose flour, baking " +
                "powder, salt, baking soda","4","Chunky PB is da bomb."));
        db.addRecipe(new Recipe("Chocolate Chip Cookies",
                "http://allrecipes.com/recipe/10813/best-chocolate-chip-cookies/", "60", "butter " +
                "white sugar, brown sugar, eggs, vanilla extract, all purpose flour, baking soda, " +
                "hot water, salt, chocolate chips, walnuts", "4.5", "Harden quickly!"));
        db.addRecipe(new Recipe("Sugar Cookies", "http://allrecipes.com/recipe/9870/easy-sugar-cookies/",
                "25", "all purpose floud, baking soda, baking powder, butter, white sugar, egg, " +
                "vanilla extract", "4", "Make sure butter is completely softed!"));

        Resources res=getResources();
        foodTitles=res.getStringArray(R.array.Titles);
        foodDescriptions=res.getStringArray(R.array.Description);

        list = (ListView) findViewById(R.id.listView);
        ListTestAdapter adapter=new ListTestAdapter(this, foodTitles, images, foodDescriptions);
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RecipeActivity.class);
                startActivity(intent);
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(view.getContext(), RecipeActivity.class);
                int idInt = (int) id; // from 0 to ~
                String idString = Integer.toString(idInt);
                myIntent.putExtra("id",idString);
                //intent.putExtra("chosen", position);
                startActivity(myIntent);
            }
        });
    }
        /*RecipesListView = (ListView) findViewById(R.id.recipes_list);

        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recipesArray);
        RecipesListView.setAdapter(arrayAdapter);*/
}


class ListTestAdapter extends ArrayAdapter<String>
{
    Context context;
    int [] images;
    String[] titleArray;
    String[] descriptionArray;
    ListTestAdapter(Context c, String[] Titles, int imgs[], String[] desc)
    {
        super(c, R.layout.single_row, R.id.textView1, Titles);
        this.context=c;
        this.images=imgs;
        this.titleArray=Titles;
        this.descriptionArray=desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,parent, false);

        ImageView myImage= (ImageView) row.findViewById(R.id.imageView1);
        TextView myTitle= (TextView) row.findViewById(R.id.textView1);
        TextView myDescription= (TextView) row.findViewById(R.id.textView3);

        myImage.setImageResource(images[0]);
        myTitle.setText(titleArray[position]);
        myDescription.setText(descriptionArray[position]);

        return row;
    }

}