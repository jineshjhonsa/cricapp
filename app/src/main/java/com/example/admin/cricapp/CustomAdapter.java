package com.example.admin.cricapp;
import com.example.admin.cricapp.database.player;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 12/19/2017.
 */

public class CustomAdapter extends ArrayAdapter<player> {

    private ArrayList<player> player;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtteam;

    }

    public CustomAdapter(ArrayList<player> player, Context context) {
        super(context, R.layout.showplayers, player);
        this.player = player;
        this.mContext=context;

    }



    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        player players = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.showplayers, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.full_nam);
            viewHolder.txtteam = (TextView) convertView.findViewById(R.id.team_nam);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        lastPosition = position;

        viewHolder.txtName.setText(players.getTeam_name());
        viewHolder.txtteam.setText(players.getPlayername());

        // Return the completed view to render on screen
        return convertView;
    }
}