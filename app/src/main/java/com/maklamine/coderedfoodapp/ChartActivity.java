package com.maklamine.coderedfoodapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ChartActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series1, series2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);


        double x, y;
        x = 0.0;


        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 10),
                new DataPoint(3, 5),
                new DataPoint(5, 8)
        });
        series1.setTitle("Your Cholesterol");
        series1.setColor(Color.CYAN);
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>();
        for(int i =0 ; i<500;i++){
            x += .01;
            y = 2*x +1;
            series2.appendData(new DataPoint(x,y),true,500);
        }

        series2.setColor(Color.GREEN);
        // series2.setTitle("Avg. Cholesterol");

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 6),
                new DataPoint(2, 7),
                new DataPoint(6, 15)
        });
        graph.addSeries(series1);
        graph.addSeries(series2);
        graph.addSeries(series3);



        GraphView graph1 = (GraphView) findViewById(R.id.graph1);
        LineGraphSeries<DataPoint> series11 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(3, 8),
                new DataPoint(2, 9),
                new DataPoint(4, 7)
        });
        series1.setTitle("Your Cholesterol");
        series1.setColor(Color.CYAN);
        LineGraphSeries<DataPoint> series21 = new LineGraphSeries<>();
        for(int i =0 ; i<500;i++){
            x += .01;
            y = 2*x +1;
            series2.appendData(new DataPoint(x,y),true,500);
        }

        series2.setColor(Color.GREEN);
        // series2.setTitle("Avg. Cholesterol");

        LineGraphSeries<DataPoint> series31 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 5),
                new DataPoint(3, 9),
                new DataPoint(7, 16)
        });
        graph1.addSeries(series11);
        graph1.addSeries(series21);
        graph1.addSeries(series31);

        /*series1 = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < 500; i++)
        {
            x = x+0.1;
            y = Math.sin(0.5*x); //Change this function from sin
            series1.appendData(new DataPoint(x,y), true, 500);
        }

        x = -5.0;
        y = 0.0;
        series2 = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < 500; i++)
        {
            x = x+0.1;
            y = 0.5*x + 2; //Change this function from cos
            series2.appendData(new DataPoint(x,y), true, 500);
        }

        graph.addSeries(series1);
        graph.addSeries(series2);*/


        //Bottom Navigation Button
        LinearLayout homeButton = (LinearLayout) findViewById(R.id.homeButton);
        LinearLayout inventoryButton = (LinearLayout) findViewById(R.id.inventoryButton);
        LinearLayout shoppingButton = (LinearLayout) findViewById(R.id.shoppingButton);
        LinearLayout chartButton = (LinearLayout) findViewById(R.id.chartButton);
        LinearLayout favoriteButton = (LinearLayout) findViewById(R.id.favoriteButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ChartActivity.this, HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ChartActivity.this, InventoryActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ChartActivity.this, ShoppingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
       /* chartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ChartActivity.this, ChartActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });*/
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ChartActivity.this, FavoriteActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
    }

    public void createChart()
    {

    }
}
