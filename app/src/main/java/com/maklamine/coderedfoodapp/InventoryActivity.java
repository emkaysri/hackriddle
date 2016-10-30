package com.maklamine.coderedfoodapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_addItem) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.inventory_dialog, null);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setTitle("Add new innventory item");


            dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                    EditText title = (EditText) dialogView.findViewById(R.id.val1);
                    EditText qty = (EditText) dialogView.findViewById(R.id.val2);
                    EditText unit = (EditText) dialogView.findViewById(R.id.val3);

                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    dbHelper.insertInventory(title.getText().toString(), Integer.parseInt(qty.getText().toString()), unit.getText().toString());

                    loadData();

                }
            });
            dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                }
            });
            AlertDialog b = dialogBuilder.create();
            b.show();
            return true;
        }
        if (id == R.id.action_scanner) {

            return true;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        loadData();


        //Bottom Navigation Button
        LinearLayout homeButton = (LinearLayout) findViewById(R.id.homeButton);
        LinearLayout inventoryButton = (LinearLayout) findViewById(R.id.inventoryButton);
        LinearLayout shoppingButton = (LinearLayout) findViewById(R.id.shoppingButton);
        LinearLayout chartButton = (LinearLayout) findViewById(R.id.chartButton);
        LinearLayout favoriteButton = (LinearLayout) findViewById(R.id.favoriteButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(InventoryActivity.this, HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
       /* inventoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(InventoryActivity.this, InventoryActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });*/
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(InventoryActivity.this, ShoppingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        chartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(InventoryActivity.this, ChartActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(InventoryActivity.this, FavoriteActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });


    }

    public void loadData(){
        com.maklamine.coderedfoodapp.DBHelper dbHelper = new com.maklamine.coderedfoodapp.DBHelper(this);
        ArrayList<Inventory> inventory = dbHelper.getInventory();
        com.maklamine.coderedfoodapp.InventoryAdapter inventoryAdapter = new com.maklamine.coderedfoodapp.InventoryAdapter(this, inventory);
        ListView listView = (ListView)findViewById(R.id.listviewInv);
        listView.setAdapter(inventoryAdapter);
    }
}
