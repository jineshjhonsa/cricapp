package com.example.admin.cricapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.admin.cricapp.database.ball;
import com.example.admin.cricapp.database.currentbatting;
import com.example.admin.cricapp.database.innings;
import com.example.admin.cricapp.database.player;
import com.example.admin.cricapp.database.team;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by admin on 11/16/2017.
 */

public class Input extends Fragment {
    ArrayList<scorename> scorelist=new ArrayList<>();
    private TextView temprun2;
    private TextView name1;
    private TextView temprun1;
    private TextView tempball1;
    private TextView name2;
    private TextView tempball2;
    private TextView perover;
    private TextView overallrun;
    private TextView totalwkt;
    private TextView tempover;
    private TextView team;
    private DatabaseHandler mydb;
    final  private String[] data = {"0","1","2","3","4","5","6","Byes","Wkt"};
    final  private String[] wktdata = {"0","1","2","3","4","5","6"};
    private String bowler;
    private String striker;
    private String non_striker;
    private Integer ball_extra;
    private String total_over;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mydb =  new DatabaseHandler(getContext());
          striker = getActivity().getIntent().getStringExtra("striker");
         non_striker = getActivity().getIntent().getStringExtra("non_striker");
        bowler = getActivity().getIntent().getStringExtra("bowler");
      //  insertdata();
  View rootview = inflater.inflate(R.layout.inputdata,container,false);

        temprun1= (TextView) rootview.findViewById(R.id.tempruns1);
         temprun2 = (TextView)rootview.findViewById(R.id.tempruns2);
         tempball1 = (TextView)rootview.findViewById(R.id.tempballs1);
         tempball2 = (TextView)rootview.findViewById(R.id.tempballs2);
         name1 = (TextView)rootview.findViewById(R.id.name1);
         name2 = (TextView)rootview.findViewById(R.id.name2);
         perover = (TextView)rootview.findViewById(R.id.perover);
        team = (TextView)rootview.findViewById(R.id.team);

        overallrun = (TextView)rootview.findViewById(R.id.overallrun);
        tempover = (TextView)rootview.findViewById(R.id.tempover);
         totalwkt = (TextView) rootview.findViewById(R.id.wkt);

        Button one = (Button) rootview.findViewById(R.id.one);
       one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incrementrun("1");
             }
        });

        Button two = (Button) rootview.findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incrementrun("2");
                update_all();
            }
        });
        Button three = (Button) rootview.findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incrementrun("3");
            }
        });
        Button four = (Button) rootview.findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incrementrun("4");
            }
        });
        Button five = (Button) rootview.findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incrementrun("5");
            }
        });
        Button six = (Button) rootview.findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incrementrun("6");
            }
        });
        Button wkt = (Button) rootview.findViewById(R.id.wicket);
        wkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Hi1","I am in wicket");
               final  NumberPicker numberPicker3 = new NumberPicker(getActivity());
                numberPicker3.setMaxValue(data.length - 1);
                numberPicker3.setDisplayedValues(data);

                final AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                builder2.setTitle("Select run");
                builder2.setView(numberPicker3);
                builder2.setMessage("Choose a value :");
                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer  val = numberPicker3.getValue();
                        incrementrun(val.toString()+"wkt");
                    }
                });
                builder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder2.show();
            }

        });


        Button noball = (Button) rootview.findViewById(R.id.No);

        noball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final NumberPicker numberPicker = new NumberPicker(getActivity());
                numberPicker.setMaxValue(data.length-1);
                numberPicker.setDisplayedValues(data);

                final AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                builder3.setTitle("Select run");
                builder3.setView(numberPicker);
                builder3.setMessage("Choose a value :");

                builder3.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Integer  val = numberPicker.getValue();
                        if(val.intValue() == 8){
                            final NumberPicker numberPicker2 = new NumberPicker(getActivity());
                            numberPicker2.setMaxValue(data.length-1);
                            numberPicker2.setDisplayedValues(data);

                            final AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                            builder2.setTitle("Select run");
                            builder2.setView(numberPicker2);
                            builder2.setMessage("Choose a value :");
                            builder2.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Integer  val = numberPicker.getValue();
                                    incrementrun(val.toString()+"wkt");
                                }
                            });
                        }else if(val.intValue() == 7){

                            incrementrun("0B");

                        }else {

                            incrementrun(numberPicker.getValue() + "N");

                        }
                    }
                });
                builder3.setNegativeButton("CANCEL", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder3.show();

            }
        });

       Button wide = (Button) rootview.findViewById(R.id.wide);
        wide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              createdialog();
            }
        });


        return rootview;


    }

    private void update_all() {

    }

    @Override
    public void onStart() {
        super.onStart();

        setzero();
    }

    private void createdialog(){
        Log.i("Hi1","I am in wide");
        final NumberPicker numberPicker = new NumberPicker(getActivity());
        numberPicker.setMaxValue(data.length - 1);
        numberPicker.setDisplayedValues(data);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
        builder.setTitle("Select run");
        builder.setView(numberPicker);
        builder.setMessage("Choose a value :");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Integer  val = numberPicker.getValue();
                incrementrun(val.toString()+"Wi");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private void read_all(){
       ArrayList<team> x = mydb.Read_all_team();
        ArrayList<player> y = mydb.Read_all_player();
        for(int i=0;i<x.size();i++){
            Log.v("Hi1",x.get(i).toString());
        }

        for(int j=0;j<y.size();j++){
            Log.v("Hi1",y.get(j).toString());
        }
    }

    private void incrementrun(String num) {


        ball prev_ball =mydb.Read_current_ball();
        innings prev_inning = mydb.Read_innings();
        currentbatting curr = mydb.Read_batting(striker);
            Integer numb = Integer.valueOf(num.substring(0,1));


            Integer overallruns = prev_inning.getTotal_runs();
            ball_extra = 0;
          Integer wicket =0;
        Integer total_wick = prev_inning.getTotal_wkt();


        Integer valid_ball = prev_ball.getValid_ball();


            Integer striker_run = curr.getRuns() ;
        Integer striker_ball = curr.getBalls();
        if(num.contains("N")){
            ball_extra++;
            overallruns++;
            striker_run = striker_run+numb;
            striker_ball++;


        }else if(num.contains("Wi")) {
            ball_extra++;
            overallruns++;


        }else if(num.contains("wkt")) {
            striker_run = striker_run+numb;
            total_wick++;
            striker_ball++;
            valid_ball++;
            wicket++;

        } else
         {
             //perball.setBall_runs(tempruns);
             striker_run = striker_run+numb;
             valid_ball++;
             striker_ball++;


        }
        if(prev_ball.getValid_ball().intValue()==5) {

            mydb.Insert_ball(new ball(prev_ball.getTournament_id(), prev_ball.getMatch_id(), prev_ball.getInnings_id(), prev_ball.getOver_no()+1,0,0,numb,striker,non_striker,bowler,0,0,num+","));
            Integer y = prev_ball.getOver_no()+1;
            total_over = y+".0";
            tempover.setText(y+".0");
            perover.setText(num + ",");
        }else{
            mydb.Insert_ball(new ball(prev_ball.getTournament_id(), prev_ball.getMatch_id(), prev_ball.getInnings_id(), prev_ball.getOver_no(),valid_ball,prev_ball.getBallno()+1,numb,striker,non_striker,bowler,0,0, prev_ball.getPrev_balls()+num+","));
            tempover.setText(prev_ball.getOver_no()+"."+valid_ball);
            total_over = prev_ball.getOver_no()+"."+valid_ball;
            perover.setText(mydb.Read_current_ball().getPrev_balls());
        }



        overallruns = overallruns + numb;
        mydb.update_innings(overallruns,Double.valueOf(total_over),total_wick);
        mydb.update_currentbatting(striker,striker_run,striker_ball);
        temprun1.setText(striker_run.toString());
        overallrun.setText(overallruns.toString());
        tempball1.setText(striker_ball.toString());
        totalwkt.setText(total_wick.toString());
        if(numb%2 ==1) {
                Log.i("Hi1", "Striker is "+striker);
               Log.i("Hi1", "Non Striker is "+non_striker);
            String temp =  striker;

            striker = non_striker;
            non_striker =temp;
            String tempballs1 = tempball1.getText().toString();
            String tempruns1  = temprun1.getText().toString();
            name1.setText(non_striker);
            name2.setText(striker);
            temprun1.setText(temprun2.getText());
            temprun2.setText(tempruns1.toString());
            tempball1.setText(tempball2.getText());
            tempball2.setText(tempballs1);
            Log.i("Hi1", "Striker is "+striker);
            Log.i("Hi1", "Non Striker is "+non_striker);
           // mydb.Read_team("x");
        }

    }

    private void incrementball() {


        Integer tempballs = Integer.valueOf(tempball1.getText().toString());
        tempballs = tempballs + 1;
        tempball1.setText(tempballs.toString());

    }

    private void setzero() {
        ball bal =mydb.Read_current_ball();
        striker = bal.getStriker();
        non_striker =bal.getNon_striker();
        innings in = mydb.Read_innings();
        currentbatting striker_bat = mydb.Read_batting(bal.getStriker());
        currentbatting non_striker_bat = mydb.Read_batting(bal.getNon_striker());
        Log.e("Hi1","innings is  "+in.toString());
        name1.setText(bal.getStriker());
        name2.setText(bal.getNon_striker());
        perover.setText(bal.getPrev_balls());
        temprun1.setText(striker_bat.getRuns().toString());
        temprun2.setText(non_striker_bat.getRuns().toString());
        tempball1.setText(striker_bat.getBalls().toString());
        tempball2.setText(non_striker_bat.getBalls().toString());
        team.setText(in.getBatting_team().substring(0,2));
        String y = in.getTotal_runs().toString();
        Log.e("Hi1","data is d "+y);
        tempover.setText(bal.getOver_no().toString());
        overallrun.setText(in.getTotal_runs().toString());
        totalwkt.setText(in.getTotal_wkt().toString());


    }
}
