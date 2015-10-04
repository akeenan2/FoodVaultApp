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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

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
                myIntent.putExtra("ID",idString);
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