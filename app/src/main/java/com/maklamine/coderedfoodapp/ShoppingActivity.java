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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingActivity extends AppCompatActivity implements View.OnClickListener {

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
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private Button scanBtn;
    private TextView formatTxt, contentTxt, textView;
    private ImageView coupon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        loadData();
        //Bottom Navigation Button
        LinearLayout homeButton = (LinearLayout) findViewById(R.id.homeButton);
        LinearLayout inventoryButton = (LinearLayout) findViewById(R.id.inventoryButton);
        LinearLayout shoppingButton = (LinearLayout) findViewById(R.id.shoppingButton);
        LinearLayout chartButton = (LinearLayout) findViewById(R.id.chartButton);
        LinearLayout favoriteButton = (LinearLayout) findViewById(R.id.favoriteButton);

        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        textView = (TextView)findViewById(R.id.textView);
        coupon = (ImageView)findViewById(R.id.coupon);

        scanBtn.setOnClickListener(this);


        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ShoppingActivity.this, HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ShoppingActivity.this, InventoryActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
       /* shoppingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ShoppingActivity.this, ShoppingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });*/
        chartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ShoppingActivity.this, ChartActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ShoppingActivity.this, FavoriteActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
    }

    public void onClick(View v){
        if(v.getId()==R.id.scan_button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
        //respond to clicks
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            try{
            String scanContent = scanningResult.getContents();
            String[] scanVars = scanContent.split(",");
            DBHelper dbHelper = new DBHelper(this);
            dbHelper.insertShoppingList(scanVars[0],Integer.parseInt(scanVars[1]),scanVars[2]);
                textView.setText(textView.getText()+"\n"+scanVars[0] +" " + Integer.parseInt(scanVars[1])+" " + scanVars[2]);
            if(scanVars[0].equals("milk")){
                coupon.setImageResource(R.drawable.milkcoupon);
            }
            } catch(Exception e){

            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void loadData(){
//        DBHelper dbHelper = new DBHelper(this);
//        ArrayList<Inventory> Shopping = dbHelper.getShopping();
//        com.maklamine.coderedfoodapp.ShoppingAdapter ShoppingAdapter = new ShoppingAdapter(this, Shopping);
//        ListView listView = (ListView)findViewById(R.id.listviewInv);
//        listView.setAdapter(ShoppingAdapter);
    }


}
