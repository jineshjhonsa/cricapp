package com.example.admin.cricapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.cricapp.database.currentbatting;

import java.util.ArrayList;

/**
 * Created by admin on 12/24/2017.
 */

public class battingadapter extends ArrayAdapter<com.example.admin.cricapp.database.currentbatting> {

    private ArrayList<currentbatting> currentbatting = new ArrayList<>();
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView Name;
        TextView runs;
        TextView ball;
        TextView four;
        TextView six;
        TextView econ;
    }

    public battingadapter(ArrayList<currentbatting> currentbatting, Context context) {
        super(context, R.layout.batsman_file, currentbatting);
        this.currentbatting = currentbatting;
        this.mContext=context;

    }



    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        currentbatting currentbattings = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        battingadapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new battingadapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.batsman_file, parent, false);
            viewHolder.Name = (TextView) convertView.findViewById(R.id.batsman_file);
            viewHolder.runs = (TextView) convertView.findViewById(R.id.runs_file);
            viewHolder.ball = (TextView) convertView.findViewById(R.id.bowl_file);
            viewHolder.four = (TextView) convertView.findViewById(R.id.fours_file);
            viewHolder.six = (TextView) convertView.findViewById(R.id.sixs_file);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (battingadapter.ViewHolder) convertView.getTag();
            result=convertView;
        }


        lastPosition = position;

        viewHolder.Name.setText(currentbattings.getName());
        viewHolder.runs.setText(currentbattings.getRuns().toString());
        viewHolder.ball.setText(currentbattings.getOnes().toString());
        viewHolder.four.setText(currentbattings.getFours().toString());
        viewHolder.six.setText(currentbattings.getSixs().toString());


        // Return the completed view to render on screen
        return convertView;
    } 
}
