package com.example.admin.cricapp;

/**
 * Created by admin on 11/16/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Scoreadapter extends ArrayAdapter<scorename> {

    ArrayList<scorename> scorelist = new ArrayList<>();

    public Scoreadapter(Context context, int textViewResourceId, ArrayList<scorename> objects) {
        super(context, textViewResourceId, objects);
        scorelist = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.batlist, null);
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView ball = (TextView) v.findViewById(R.id.tempballs);
        TextView runs = (TextView) v.findViewById(R.id.tempruns);
        ball.setText(scorelist.get(position).getBalls());
        runs.setText(scorelist.get(position).getRuns());
        name.setText(scorelist.get(position).getName());
        return v;

    }
}