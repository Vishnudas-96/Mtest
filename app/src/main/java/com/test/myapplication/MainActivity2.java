package com.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    TextView tv_details;
    private List<Latlong> latlongArrayList;
    private DatabaseHandler dbHandler;
    String detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_details = findViewById(R.id.tv_details);
        Bundle extras = getIntent().getExtras();
        String id1 = extras.getString("id");
        String name = extras.getString("name");
        String web = extras.getString("web");
        String mob = extras.getString("mob");

        dbHandler = new DatabaseHandler(MainActivity2.this);
        latlongArrayList = dbHandler.readData(id1);

        for (Latlong cn : latlongArrayList) {
            detail = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getMobile()+", website :" +cn.getWebsite();
        }
        tv_details.setText(detail);


    }
}