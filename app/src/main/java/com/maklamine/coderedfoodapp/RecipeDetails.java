package com.maklamine.coderedfoodapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        String opt = getIntent().getExtras().getString("opt","main");

        ListView listView = (ListView) findViewById(R.id.list);


        ArrayList<Recipe> recipes;

        if(opt.equals("main")){
            recipes = new Recipes().getLunch();
        }
        else{
            recipes = new Recipes().getBreakfast();
        }

        ArrayList<String> titles = new ArrayList<>();
        for (Recipe recipe:recipes) {
            titles.add(recipe.getTitle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(adapter);
    }


}
