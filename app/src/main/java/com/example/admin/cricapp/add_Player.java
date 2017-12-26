package com.example.admin.cricapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class add_Player extends AppCompatActivity {
    private DatabaseHandler databaseHandler = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__player);
        final ListView listView = (ListView) findViewById(R.id.showit);

        final EditText name = (EditText) findViewById(R.id.fullname);
        final EditText team_name = (EditText) findViewById(R.id.team_name_data);

        Button add = (Button) findViewById(R.id.addit);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

      }


}
