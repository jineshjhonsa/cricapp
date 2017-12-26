package com.example.admin.cricapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.admin.cricapp.database.currentbatting;
import com.example.admin.cricapp.database.currentbowling;
import com.example.admin.cricapp.database.innings;
import com.example.admin.cricapp.database.matches;
import com.example.admin.cricapp.database.team;

import java.util.ArrayList;
import java.util.Date;

public class innings_select extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<>();
    private Spinner MySpinner1;
    private DatabaseHandler mydb;
    private String[] team1_array;
    private String[] team2_array;
    private String team2;
    private String team1;
    private String batting_first;
    private String bowling_first;
    private String team2_rem1;
    private String team1_rem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innings);
        mydb = new DatabaseHandler(this);
         Intent i = getIntent();
       
         team1 = i.getStringExtra("team1");
        ArrayList<String> team1_list = mydb.Read_team(team1);
        team1_array = new String[team1_list.size()];
        team1_array= team1_list.toArray(new String[team1_list.size()]);
        Button team1_rem = (Button) findViewById(R.id.batsman_team1_playing11);
        final TextView team1_removed = (TextView)findViewById(R.id.batsman_remove_team1) ;
        team1_rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker = new NumberPicker(innings_select.this);


                numberPicker.setDisplayedValues(team1_array);
                numberPicker.setMaxValue(team1_array.length-1);
                final AlertDialog.Builder builder = new AlertDialog.Builder(innings_select.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                builder.setTitle("Select Batsman");
                builder.setView(numberPicker);
                builder.setMessage("Choose a Batsman :");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer  val = numberPicker.getValue();
                        team1_rem1 = team1_array[val];
                        team1_removed.setText(team1_array[val]);
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
        team2 = i.getStringExtra("team2");
        ArrayList<String> team2_list = mydb.Read_team(team2);
        team2_array = new String[team2_list.size()];
        team2_array= team2_list.toArray(new String[team2_list.size()]);
        Button team2_rem = (Button) findViewById(R.id.batsman_team2_playing11);
        final TextView team2_removed = (TextView)findViewById(R.id.batsman_remove_team2) ;
        team2_rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker1 = new NumberPicker(innings_select.this);


                numberPicker1.setDisplayedValues(team2_array);
                numberPicker1.setMaxValue(team2_array.length-1);
                final AlertDialog.Builder builder = new AlertDialog.Builder(innings_select.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                builder.setTitle("Select Batsman");
                builder.setView(numberPicker1);
                builder.setMessage("Choose a Batsman :");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer  val = numberPicker1.getValue();
                        team2_rem1 = team2_array[val];
                        team2_removed.setText(team2_array[val]);
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
        final String[] batting =  new String[]{team1,team2};
        Button bat = (Button) findViewById(R.id.batting_first);
        final TextView team_select = (TextView)findViewById(R.id.team_select) ;
        bat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker3 = new NumberPicker(innings_select.this);


                numberPicker3.setDisplayedValues(batting);
                numberPicker3.setMaxValue(batting.length-1);
                final AlertDialog.Builder builder = new AlertDialog.Builder(innings_select.this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                builder.setTitle("Select Batsman");
                builder.setView(numberPicker3);
                builder.setMessage("Choose a Batsman :");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer  val = numberPicker3.getValue();
                        batting_first =  batting[val];
                        if(batting_first.equals(team1))bowling_first =team2;
                        else bowling_first = team1;
                        team_select.setText(batting[val]);
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
        final String match =  i.getStringExtra("match");


        Button done = (Button)findViewById(R.id.inning_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mydb.delete_all_current();

                    mydb.Insert_innings(new innings("1",match,1,team1,team2,10.0,0,0));
                ArrayList<String> batting_list = mydb.Read_team(batting_first);
                for(int i=0;i<batting_list.size();i++){
                    if(batting_list.get(i).equals(team1_rem1) || batting_list.get(i).equals(team2_rem1) )continue;
                mydb.Insert_currentbatting(new currentbatting(1,Integer.valueOf(match),1,batting_first,batting_list.get(i),0,0,0,0,0,0,0,0));

                }
                ArrayList<String> bowling_list = mydb.Read_team(bowling_first);
                for(int i=0;i<batting_list.size();i++){
                    if(bowling_list.get(i).equals(team1_rem1) || bowling_list.get(i).equals(team2_rem1) )continue;
                    mydb.Insert_currentbowling(new currentbowling(1,Integer.valueOf(match),1,bowling_first,bowling_list.get(i),0,0,0,0,0,0,0,0,0,0));

                }
                Log.e("Hi1","team is "+ team1);
                Intent j = new Intent(innings_select.this,first_select.class);
                j.putExtra("Batting_team",batting_first);
                j.putExtra("Bowling_team",bowling_first);
                j.putExtra("match",match);

                startActivity(j);

            }
        });
    }

}
