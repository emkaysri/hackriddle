package com.maklamine.coderedfoodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by davidcruz on 10/29/16.
 */

public class InventoryAdapter extends ArrayAdapter<Inventory> {

    public InventoryAdapter(Context context, ArrayList<Inventory> inventory){
        super(context, 0, inventory);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Inventory item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_inventory, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView quantity = (TextView) convertView.findViewById(R.id.quantity);
        TextView units = (TextView) convertView.findViewById(R.id.units);
        // Populate the data into the template view using the data object
        title.setText(item.getTitle());
        quantity.setText(item.getQuantity() + " ");
        units.setText(item.getUnits());
        // Return the completed view to render on screen
        return convertView;
    }
    
}
