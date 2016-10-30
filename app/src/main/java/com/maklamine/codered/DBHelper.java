package com.maklamine.codered;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
            int quantity = Integer.parseInt(result.getString(result.getColumnIndexOrThrow("quantity")));
            String units = result.getString(result.getColumnIndex("units"));

            Inventory item = new Inventory(title, quantity, units);
            inventory.add(item);

            result.moveToNext();
        }

        result.close();

        return inventory;
    }

    public void insertInventory(String title, int quantity, String units){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues item = new ContentValues();

        item.put("title", title);
        item.put("quantity", quantity);
        item.put("units", units);
        db.insert("Inventory", null, item);
    }

    public void deleteInventory(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Inventory", "id = " + id, null);
    }

}
