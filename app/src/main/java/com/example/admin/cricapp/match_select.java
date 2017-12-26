package com.example.admin.cricapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.admin.cricapp.database.matches;
import com.example.admin.cricapp.database.team;

import java.util.ArrayList;
import java.util.Date;

public class match_select extends AppCompatActivity {
    private DatabaseHandler mydb;
    private ArrayList<String> data;
    private Spinner MySpinner1;
    private Spinner MySpinner2;
    private Spinner MySpinner3;
    private ArrayList<String> add_team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);
        add_team = new ArrayList<String>();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mydb = new DatabaseHandler(this);
        data = new ArrayList<>();
        ArrayList<team> teams = mydb.Read_all_team();
        for(int i =0;i<teams.size();i++)
            data.add(teams.get(i).getTeam_name());


        MySpinner1 = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter1 = new
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data );
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MySpinner1.setAdapter(myAdapter1);


                MySpinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MySpinner2.setAdapter(myAdapter2);


        Button done = (Button)findViewById(R.id.button);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ArrayList<matches> x = mydb.Read_all_matches();
               String team1 = MySpinner1.getSelectedItem().toString();
                String team2 = MySpinner2.getSelectedItem().toString();
                String team = team1 + " vs " + team2;
                if(x.size()==0){
                    mydb.Insert_matches(new matches("1","1","none",team,new Date().toString(),10),1);
                }else{
                    Integer match_no = x.size()+1;
                    mydb.Insert_matches(new matches("1","1","none",team,new Date().toString(),10),match_no);

                }
                Log.e("Hi1","team is "+ team);
                Intent i = new Intent(match_select.this,add_Player.class);
                startActivity(i);
            }
        });
    }

}
