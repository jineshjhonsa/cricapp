package com.example.admin.cricapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.cricapp.database.currentbatting;

import java.util.ArrayList;

/**
 * Created by admin on 11/16/2017.
 */

public class scorecard extends Fragment{

private DatabaseHandler mydb;
    private ArrayList<currentbatting> batting;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mydb = new DatabaseHandler(this.getContext());
        batting = mydb.Read_all_currentbatting();
                View rootview = inflater.inflate(R.layout.scorecard,container,false);

        ListView list =(ListView)rootview.findViewById(R.id.batting_list);
        list.setAdapter(new battingadapter(batting,this.getContext()));



        return rootview;


    }
}
