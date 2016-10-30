package com.maklamine.coderedfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Bottom Navigation Button
        LinearLayout homeButton = (LinearLayout) findViewById(R.id.homeButton);
        LinearLayout inventoryButton = (LinearLayout) findViewById(R.id.inventoryButton);
        LinearLayout shoppingButton = (LinearLayout) findViewById(R.id.shoppingButton);
        LinearLayout chartButton = (LinearLayout) findViewById(R.id.chartButton);
        LinearLayout favoriteButton = (LinearLayout) findViewById(R.id.favoriteButton);

        LinearLayout mainButton = (LinearLayout) findViewById(R.id.btnMain);
        LinearLayout breakfastButton = (LinearLayout) findViewById(R.id.btnBreakfast);
        LinearLayout saladButton = (LinearLayout) findViewById(R.id.btnSalad);
        LinearLayout soupButton = (LinearLayout) findViewById(R.id.btnSoup);
        LinearLayout dessertButton = (LinearLayout) findViewById(R.id.btnDessert);
        LinearLayout drinksButton = (LinearLayout) findViewById(R.id.btnDrinks);

      /* homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });*/
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, InventoryActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ShoppingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        chartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ChartActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, FavoriteActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, RecipeDetails.class);
                i.putExtra("opt", "main");
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        breakfastButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, RecipeDetails.class);
                i.putExtra("opt", "breakfast");
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        saladButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toast();
            }
        });

        soupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toast();
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toast();
            }
        });

        drinksButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toast();
            }
        });
    }

        public void toast(){
            Toast.makeText(this, "No recipe found!", Toast.LENGTH_SHORT).show();
    }
}

