package com.maklamine.coderedfoodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Console;
import java.util.ArrayList;

/**
 * Created by davidcruz on 10/29/16.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Codered.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table if not exists Inventory " +
                "(id integer primary key, title text, quantity int, units string)");
        db.execSQL("create table if not exists ShoppingList " +
                "(id integer primary key, title text, quantity int, units string, price string)");
        db.execSQL("create table if not exists Favorites " +
                "(id integer primary key, title text, quantity int, units string, price string)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Inventory");
        db.execSQL("drop table if exists ShoppingList");
        db.execSQL("drop table if exists Favorites");
        onCreate(db);
    }

    // Inventory CRUD

    public ArrayList<Inventory> getInventory(){ //might just give beacon uuid, max, and min here.
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Inventory", null);
        result.moveToFirst();
        ArrayList<Inventory> inventory = new ArrayList<>();

        for (int i = 0; i < result.getCount(); ++i){
            String title = result.getString(result.getColumnIndex("title"));
            int quantity = Integer.parseInt(result.getString(result.getColumnIndex("quantity")));
            String units = result.getString(result.getColumnIndex("units"));

            Inventory item = new Inventory(title, quantity, units);
            inventory.add(item);

            result.moveToNext();
        }

        result.close();

        return inventory;
    }

    public void insertInventory(String title, int quantity, String units) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues item = new ContentValues();
        int q = quantity;

        Cursor result = db.rawQuery("SELECT * FROM Inventory WHERE title = '" + title + "'", null);
        Log.i("RRR", result.getCount() + " ");
        if (result.getCount() == 1) {

            q += Integer.parseInt(result.getString(result.getColumnIndexOrThrow("quantity")));
            db.execSQL("UPDATE Inventory SET quantity='"+ q +"' WHERE title=" + title);

//                item.put("title", title);
//                item.put("quantity", q);
//                item.put("units", units);
//                db.update("Inventory", item, null, null);
        } else {
            result = db.rawQuery("SELECT * FROM Inventory", null);
            result.moveToFirst();
            item.put("title", title);
            item.put("quantity", quantity);
            item.put("units", units);
            db.insert("Inventory", null, item);
        }

    }

    public void deleteInventory(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Inventory", "id = " + id, null);
    }
    public ArrayList<Inventory> getShoppingList(){ //might just give beacon uuid, max, and min here.
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from ShoppingList", null);
        result.moveToFirst();
        ArrayList<Inventory> ShoppingList = new ArrayList<>();

        for (int i = 0; i < result.getCount(); ++i){
            String title = result.getString(result.getColumnIndex("title"));
            int quantity = Integer.parseInt(result.getString(result.getColumnIndex("quantity")));
            String units = result.getString(result.getColumnIndex("units"));

            Inventory item = new Inventory(title, quantity, units);
            ShoppingList.add(item);

            result.moveToNext();
        }

        result.close();

        return ShoppingList;
    }

    public void insertShoppingList(String title, int quantity, String units) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues item = new ContentValues();
        int q = quantity;
        try {
            Cursor result = db.rawQuery("SELECT * FROM ShoppingList WHERE title = '" + title + "'", null);
            if (result.getCount() == 1) {

                q += Integer.parseInt(result.getString(result.getColumnIndexOrThrow("quantity")));
                db.execSQL("UPDATE ShoppingList SET quantity='"+ q +"' WHERE title=" + title);

//                item.put("title", title);
//                item.put("quantity", q);
//                item.put("units", units);
//                db.update("ShoppingList", item, null, null);
            } else {
                //error
            }
        } catch (Exception e) {
            Cursor result = db.rawQuery("SELECT * FROM ShoppingList", null);
            result.moveToFirst();
            item.put("title", title);
            item.put("quantity", quantity);
            item.put("units", units);
            db.insert("ShoppingList", null, item);


        }
    }

    public void deleteShoppingList(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("ShoppingList", "id = " + id, null);
    }


}
