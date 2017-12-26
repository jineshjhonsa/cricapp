package com.example.admin.cricapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.admin.cricapp.database.ball;
import com.example.admin.cricapp.database.innings;

import java.util.ArrayList;
import java.util.Arrays;

public class first_select extends AppCompatActivity {
private ArrayList<String> striker_list = new ArrayList();
    private ArrayList<String> non_striker_list = new ArrayList();
    private String bowling;
    private String batting;
    
    private DatabaseHandler mydb;
    private String[] striker_String;
    private String[] non_striker_String;
    private String[] bowler_String;
    private ArrayList<String> bowler_list;
    private String striker_selected;
    private String bowler_selected;
    private String non_striker_selected;
    private String match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mydb =  new DatabaseHandler(this.getApplicationContext());
        ArrayList<innings> in = mydb.Read_all_innings();
        Log.v("Hi1","size is "+in.size());
        Intent i =getIntent();
         batting =i.getStringExtra("Batting_team");
        match = i.getStringExtra("match");
        striker_list = mydb.Read_all_playing11_batsman();
        non_striker_list = mydb.Read_all_playing11_batsman();
        bowler_list = mydb.Read_all_playing11_bowler();
        striker_String = new String[striker_list.size()];
        striker_String= striker_list.toArray(new String[striker_list.size()]);
        i.getStringExtra("Bowling_team");
        
        Button striker_but = (Button) findViewById(R.id.Striker_batsman);
        final TextView striker = (TextView)findViewById(R.id.Striker_select) ;

        striker_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker = new NumberPicker(first_select.this);


                numberPicker.setDisplayedValues(striker_String);
                numberPicker.setMaxValue(striker_String.length-1);
                final AlertDialog.Builder builder = new AlertDialog.Builder(first_select.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                builder.setTitle("Select Striker");
                builder.setView(numberPicker);
                builder.setMessage("Choose a Batsman :");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer  val = numberPicker.getValue();
                        striker_selected = striker_String[val];
                        striker.setText(striker_String[val]);
                        non_striker_list.remove(striker_String[val]);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        
        non_striker_String = new String[non_striker_list.size()];
        non_striker_String= non_striker_list.toArray(new String[non_striker_list.size()]);
        i.getStringExtra("Bowling_team");

        Button non_striker_but = (Button) findViewById(R.id.non_striker_batsman);
        final TextView non_striker = (TextView)findViewById(R.id.Non_Striker_select) ;

        non_striker_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker = new NumberPicker(first_select.this);


                numberPicker.setDisplayedValues(non_striker_String);
                numberPicker.setMaxValue(non_striker_String.length-1);
                final AlertDialog.Builder builder = new AlertDialog.Builder(first_select.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                builder.setTitle("Select Non Striker");
                builder.setView(numberPicker);
                builder.setMessage("Choose a Batsman :");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer  val = numberPicker.getValue();
                        non_striker_selected = non_striker_String[val];
                        non_striker.setText(non_striker_String[val]);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        bowler_String = new String[bowler_list.size()];
        bowler_String= bowler_list.toArray(new String[bowler_list.size()]);
        i.getStringExtra("Bowling_team");

        Button bowler_but = (Button) findViewById(R.id.bowler);
        final TextView bowler = (TextView)findViewById(R.id.bowler_select) ;

        bowler_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker = new NumberPicker(first_select.this);


                numberPicker.setDisplayedValues(bowler_String);
                numberPicker.setMaxValue(bowler_String.length-1);
                final AlertDialog.Builder builder = new AlertDialog.Builder(first_select.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                builder.setTitle("Select run");
                builder.setView(numberPicker);
                builder.setMessage("Choose a Batsman :");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer  val = numberPicker.getValue();
                        bowler_selected = bowler_String[val];
                        bowler.setText(bowler_String[val]);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        Button but = (Button) findViewById(R.id.select_done);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(first_select.this,final_tabs.class);
                j.putExtra("striker",striker_selected);
                j.putExtra("non_striker",non_striker_selected);
                j.putExtra("bowler",bowler_selected);
                mydb.Insert_ball(new ball("1",match,"1",0,0,0,0,striker_selected,non_striker_selected,bowler_selected,0,0,""));

                startActivity(j);
            }
        });
        setSupportActionBar(toolbar);


    }

}
