package com.maklamine.codered;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        //Bottom Navigation Button
        LinearLayout homeButton = (LinearLayout) findViewById(R.id.homeButton);
        LinearLayout inventoryButton = (LinearLayout) findViewById(R.id.inventoryButton);
        LinearLayout shoppingButton = (LinearLayout) findViewById(R.id.shoppingButton);
        LinearLayout chartButton = (LinearLayout) findViewById(R.id.chartButton);
        LinearLayout favoriteButton = (LinearLayout) findViewById(R.id.favoriteButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(FavoriteActivity.this, HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(FavoriteActivity.this, InventoryActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(FavoriteActivity.this, ShoppingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        chartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(FavoriteActivity.this, ChartActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
       /* favoriteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(FavoriteActivity.this, FavoriteActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });*/
    }
}
