package com.example.admin.cricapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.admin.cricapp.database.currentbatting;
import com.example.admin.cricapp.database.ball;
import com.example.admin.cricapp.database.currentbowling;
import com.example.admin.cricapp.database.innings;
import com.example.admin.cricapp.database.matches;
import com.example.admin.cricapp.database.over;
import com.example.admin.cricapp.database.player;
import com.example.admin.cricapp.database.team;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by admin on 12/1/2017.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private String current_innings;
    private static final int DATABASE_VERSION = 13;
    private static Context mcontext;
int count =0;
    // Database Name
    private static final String DATABASE_NAME = "Cricket";

    // Contacts table name
    private static final String TABLE_over_score = "peroverscore";
    private static final String TABLE_player = "players";
    // Contacts Table Columns
    private static final String Ball_no = "Ball_no";
    private static final String Ball_runs = "Ball_runs";
    private static final String Per_ball_runs = "Per_ball_runs";
    private static final String First_Team = "First_Team";
    private static final String Second_team = "Second_team";
    private static final String Batsman_name = "Batsman_name";
    private static final String Bowler_name = "Bowler_name";
    private static final String Batsman_id = "Batsman_id";
    private static final String Bowler_id = "Bowler_id";
    private static final String Wicket_No = "Wicket_no";
    private static final String Ball_comment = "Ball_comment";
    private String current_ball;


    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mcontext = context;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String ball = "CREATE TABLE ball(ball_id TEXT PRIMARY KEY, tournament_id TEXT , match_id TEXT , innings_id TEXT , over_no INTEGER , ballno INTEGER , valid_ball INTEGER , runs INTEGER , striker TEXT , non_striker TEXT , bowler_name TEXT , wicket INTEGER , extra INTEGER , prev_balls TEXT )";
        String over = "CREATE TABLE over(over_id TEXT PRIMARY KEY, tournament_id TEXT , match_id TEXT , innings_id TEXT , over_no INTEGER , runs INTEGER , prev_ball_runs TEXT , wicket INTEGER )";
        String Innings ="CREATE TABLE innings_select(innings_id TEXT PRIMARY KEY, match_id TEXT , tournament_id TEXT , innings_no INTEGER , batting_team TEXT , bowling_team TEXT , total_overs REAL , total_runs INTEGER , total_wkt INTEGER )";
        String match = "CREATE TABLE match_select(matches_id INTEGER PRIMARY KEY, tournament_id TEXT , match_no TEXT , mom INTEGER , match_name TEXT , date TEXT , total_overs INTEGER )";
        String Player_Table= "CREATE TABLE player(player_id TEXT PRIMARY KEY, playername TEXT , team_name TEXT , playertype TEXT , playerstyle TEXT , totalruns INTEGER , wickets INTEGER , totalovers REAL , age INTEGER , match_select INTEGER , Innings INTEGER , notout INTEGER , Highest_score INTEGER , Avg REAL , Ball_Faced INTEGER , Strikerate REAL , fours INTEGER , sixs INTEGER , catches INTEGER , stumps INTEGER )";
       String Current_batting_Table="CREATE TABLE currentbatting(currentbatting_id TEXT PRIMARY KEY, Tid INTEGER , matchid INTEGER , innings INTEGER , team_name TEXT , name TEXT , runs INTEGER , balls INTEGER , ones INTEGER , twos INTEGER , threes INTEGER , fours INTEGER , fives INTEGER , sixs INTEGER )";
        String Current_bowling_Table= "CREATE TABLE currentbowling(currentbowling_id TEXT PRIMARY KEY, Tid INTEGER , matchid INTEGER , innings INTEGER , team_name TEXT , name TEXT , over INTEGER , maiden INTEGER , runs INTEGER , wicket INTEGER , zeros INTEGER , fours INTEGER , sixs INTEGER , wide INTEGER , nb INTEGER , economyrate INTEGER )";
        String current_over_details= "CREATE TABLE current_over_details(over_id TEXT PRIMARY KEY, T_id INTEGER, Match_id INTEGER,Innings INTEGER,over_no INTEGER,runs INTEGER,Batting_team TEXT,Total_runs INTEGER,Total_wkt INTEGER)";
      //String matchdetails= "CREATE TABLE players(Full_name TEXT PRIMARY KEY, team_name TEXT)";
        String team ="CREATE TABLE team(team_id TEXT PRIMARY KEY, tournament_name TEXT , team_owner TEXT , team_no TEXT , team_name TEXT , team_colour TEXT , captain TEXT , player2 TEXT , player3 TEXT , player4 TEXT , player5 TEXT , player6 TEXT , player7 TEXT , player8 TEXT , player9 TEXT , player10 TEXT , player11 TEXT , player12 TEXT )";
        db.execSQL(ball);
        db.execSQL(over);
        db.execSQL(Innings);
        db.execSQL(match);
        db.execSQL(current_over_details);
        db.execSQL(Current_batting_Table);
        db.execSQL(Current_bowling_Table);
        db.execSQL(team);
        db.execSQL(Player_Table);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS ball");
        db.execSQL("DROP TABLE IF EXISTS over");
        db.execSQL("DROP TABLE IF EXISTS innings_select");
        db.execSQL("DROP TABLE IF EXISTS match_select");
        db.execSQL("DROP TABLE IF EXISTS player");
        db.execSQL("DROP TABLE IF EXISTS currentbatting");
        db.execSQL("DROP TABLE IF EXISTS currentbowling");
        db.execSQL("DROP TABLE IF EXISTS current_over_details");
        db.execSQL("DROP TABLE IF EXISTS team");
        // Create tables again
        onCreate(db);
    }

    public void Insert_ball(ball ball ){
        SQLiteDatabase db = this.getWritableDatabase();

        current_ball  =ball.getTournament_id()+"_"+ball.getMatch_id()+"_"+ball.getInnings_id()+"_"+ball.getOver_no()+"_"+ball.getBallno();
        SharedPreferences pref = mcontext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("ball_id", current_ball);  // Saving string

        // Save the changes in SharedPreferences
        editor.commit(); // commit changes
        ContentValues values = new ContentValues();

        values.put("ball_id", current_ball);
        values.put("tournament_id", ball.getTournament_id());
        values.put("match_id", ball.getMatch_id());
        values.put("innings_id", ball.getInnings_id());
        values.put("over_no", ball.getOver_no());
        values.put("ballno", ball.getBallno());
        values.put("valid_ball", ball.getValid_ball());
        values.put("runs", ball.getRuns());
        values.put("striker", ball.getStriker());
        values.put("non_striker", ball.getNon_striker());
        values.put("bowler_name", ball.getBowler_name());
        values.put("wicket", ball.getWicket());
        values.put("extra", ball.getExtra());
        values.put("prev_balls", ball.getPrev_balls());
        db.insert("ball", null, values); db.close();

    }
    public ArrayList<ball> Read_all_ball(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ball> ball_list = new ArrayList<ball>();
        // Select All Query
        String selectQuery = "SELECT  * FROM ball";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ball ball = new ball(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getInt(11),cursor.getInt(12),cursor.getString(13));
                ball_list.add(ball);
            } while (cursor.moveToNext());
        }
        db.close();

        return ball_list;
    }

    public ball Read_current_ball(){

        SQLiteDatabase db = this.getReadableDatabase();
        SharedPreferences pref = mcontext.getSharedPreferences("MyPref", MODE_PRIVATE);

        current_ball = pref.getString("ball_id",null);
        String selectQuery = "SELECT  * FROM ball WHERE ball_id = ?";


        Cursor cursor = db.rawQuery(selectQuery,  new String[] {current_ball});
        ball ball = null;
        cursor.moveToNext();

        ball = new ball(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getInt(11),cursor.getInt(12),cursor.getString(13));



        db.close();

        return ball;
    }

    public void Insert_player(player player ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("player_id", ++count+player.getPlayername());
        values.put("playername", player.getPlayername());
        values.put("team_name", player.getTeam_name());
        values.put("playertype", player.getPlayertype());
        values.put("playerstyle", player.getPlayerstyle());
        values.put("totalruns", player.getTotalruns());
        values.put("wickets", player.getWickets());
        values.put("totalovers", player.getTotalovers());
        values.put("age", player.getAge());
        values.put("match_select", player.getMatches());
        values.put("Innings", player.getInnings());
        values.put("notout", player.getNotout());
        values.put("Highest_score", player.getHighest_score());
        values.put("Avg", player.getAvg());
        values.put("Ball_Faced", player.getBall_Faced());
        values.put("Strikerate", player.getStrikerate());
        values.put("fours", player.getFours());
        values.put("sixs", player.getSixs());
        values.put("catches", player.getCatches());
        values.put("stumps", player.getStumps());
        db.insert("player", null, values); db.close();

    }
    public ArrayList<player> Read_all_player(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<player> player_list = new ArrayList<player>();
        // Select All Query
        String selectQuery = "SELECT  * FROM player";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Log.e("Hi1","Player id is "+cursor.getString(0));
                player player = new player(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6),cursor.getDouble(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10),cursor.getInt(11),cursor.getInt(12),cursor.getDouble(13),cursor.getInt(14),cursor.getDouble(15),cursor.getInt(16),cursor.getInt(17),cursor.getInt(18),cursor.getInt(19));
                player_list.add(player);
            } while (cursor.moveToNext());
        }
        db.close();

        return player_list;
    }
    public void Insert_team(team team){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("team_id",team.getTournament_name()+"_"+team.getTeam_name());
        values.put("tournament_name", team.getTournament_name());
        values.put("team_owner", team.getTeam_owner());
        values.put("team_no", team.getTeam_no());
        values.put("team_name", team.getTeam_name());
        values.put("team_colour", team.getTeam_colour());
        values.put("captain", team.getCaptain());
        values.put("player2", team.getPlayer2());
        values.put("player3", team.getPlayer3());
        values.put("player4", team.getPlayer4());
        values.put("player5", team.getPlayer5());
        values.put("player6", team.getPlayer6());
        values.put("player7", team.getPlayer7());
        values.put("player8", team.getPlayer8());
        values.put("player9", team.getPlayer9());
        values.put("player10", team.getPlayer10());
        values.put("player11", team.getPlayer11());
        values.put("player12", team.getPlayer12());
        db.insert("team", null, values); db.close();

    }

public ArrayList<String> Read_team(String team){
    ArrayList<String> team_list = new ArrayList<String>();


    SQLiteDatabase db = this.getReadableDatabase();


    String selectQuery = "SELECT  * FROM team WHERE team_name = ?";
    Cursor cursor = db.rawQuery(selectQuery,  new String[] {team});

    cursor.moveToNext();
    for(int i=6;i<=17;i++){
        team_list.add(cursor.getString(i));
        Log.e("Hi1",";player  is "+ cursor.getString(i));
    }


    return team_list;
}

    public ArrayList<team> Read_all_team(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<team> team_list = new ArrayList<team>();
        // Select All Query
        String selectQuery = "SELECT  * FROM team";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                team team = new team(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12),cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16),cursor.getString(17));
                team_list.add(team);
            } while (cursor.moveToNext());
        }
        db.close();

        return team_list;
    }

    public void Insert_over(over over ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("tournament_id", over.getTournament_id());
        values.put("match_id", over.getMatch_id());
        values.put("innings_id", over.getInnings_id());
        values.put("over_no", over.getOver_no());
        values.put("runs", over.getRuns());
        values.put("prev_ball_runs", over.getPrev_ball_runs());
        values.put("wicket", over.getWicket());
        db.insert("over", null, values); db.close();

    }

    public void Insert_data(){

    }
    public ArrayList<over> Read_all_over(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<over> over_list = new ArrayList<over>();
        // Select All Query
        String selectQuery = "SELECT  * FROM over";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                over over = new over(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getInt(6));
                over_list.add(over);
            } while (cursor.moveToNext());
        }
        db.close();

        return over_list;
    }




    public void Insert_innings(innings innings ){
        SQLiteDatabase db = this.getWritableDatabase();
         current_innings =innings.getTournament_id()+"_"+innings.getMatch_id()+"_"+ innings.getInnings_no();
        SharedPreferences pref = mcontext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("innings_id", current_innings);  // Saving string
        Log.e("Hi1","genearted is "+current_innings);
        // Save the changes in SharedPreferences
        editor.commit(); // commit changes
        ContentValues values = new ContentValues();
        values.put("innings_id",current_innings);
        values.put("match_id", innings.getMatch_id());
        values.put("tournament_id", innings.getTournament_id());
        values.put("innings_no", innings.getInnings_no());
        values.put("batting_team", innings.getBatting_team());
        values.put("bowling_team", innings.getBowling_team());
        values.put("total_overs", innings.getTotal_overs());
        values.put("total_runs", innings.getTotal_runs());
        values.put("total_wkt", innings.getTotal_wkt());
        db.insert("innings_select", null, values);
        db.close();

    }

    public ArrayList<innings> Read_all_innings(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<innings> innings_list = new ArrayList<innings>();
        // Select All Query
        String selectQuery = "SELECT  * FROM innings_select";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                innings innings = new innings(cursor.getString(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4),cursor.getDouble(5),cursor.getInt(6),cursor.getInt(7));
                innings_list.add(innings);
            } while (cursor.moveToNext());
        }
        db.close();

        return innings_list;
    }
    public void update_innings(Integer runs,Double over, Integer wkt){

        SQLiteDatabase db = this.getWritableDatabase();
        SharedPreferences pref = mcontext.getSharedPreferences("MyPref", MODE_PRIVATE);

        current_innings = pref.getString("innings_id",null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("total_runs",runs);
        contentValues.put("total_overs",over);
        contentValues.put("total_wkt",wkt);
        db.update("innings_select", contentValues, "innings_id = ?",new String[] { current_innings });
    }
    public innings Read_innings() {


        SharedPreferences pref = mcontext.getSharedPreferences("MyPref", MODE_PRIVATE);

        current_innings = pref.getString("innings_id",null);
        ArrayList<innings> innings_list = new ArrayList<innings>();


        SQLiteDatabase db = this.getReadableDatabase();
        Log.e("Hi1","consumed is "+current_innings);

        String selectQuery = "SELECT  * FROM innings_select WHERE innings_id = ?";

        Cursor cursor =db.query("innings_select", null, "innings_id = ?", new String[] {current_innings}, null, null, null);
        innings innings = null;
       cursor.moveToFirst();
        innings = new innings(cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getDouble(6), cursor.getInt(7), cursor.getInt(8));
        Log.e("Hi1","data is "+ cursor.getString(1));
        Log.e("Hi1","data is "+ innings.getTotal_overs());

        return innings;


    }

    public void Insert_currentbatting(currentbatting currentbatting ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("currentbatting_id", currentbatting.getName());
        values.put("Tid", currentbatting.getTid());
        values.put("matchid", currentbatting.getMatchid());
        values.put("innings", currentbatting.getInnings());
        values.put("team_name", currentbatting.getTeam_name());
        values.put("name", currentbatting.getName());
        values.put("runs", currentbatting.getRuns());
        values.put("balls", currentbatting.getBalls());
        values.put("ones", currentbatting.getOnes());
        values.put("twos", currentbatting.getTwos());
        values.put("threes", currentbatting.getThrees());
        values.put("fours", currentbatting.getFours());
        values.put("fives", currentbatting.getFives());
        values.put("sixs", currentbatting.getSixs());
        db.insert("currentbatting", null, values);
        db.close();

    }
    public ArrayList<currentbatting> Read_all_currentbatting(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<currentbatting> currentbatting_list = new ArrayList<currentbatting>();
        // Select All Query
        String selectQuery = "SELECT  * FROM currentbatting";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                currentbatting currentbatting = new currentbatting(cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5),cursor.getInt(6),cursor.getInt(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10),cursor.getInt(11),cursor.getInt(12),cursor.getInt(13));
                currentbatting_list.add(currentbatting);
            } while (cursor.moveToNext());
        }
        db.close();

        return currentbatting_list;
    }
    public currentbatting Read_batting(String name){

        SQLiteDatabase db = this.getReadableDatabase();
      currentbatting bat = null;
        // Select All Query
        String selectQuery = "SELECT * FROM currentbatting WHERE currentbatting_id = ? ";


        Cursor cursor = db.rawQuery(selectQuery, new String[]{name});
        cursor.moveToNext();
        bat = new currentbatting(cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5),cursor.getInt(6),cursor.getInt(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10),cursor.getInt(11),cursor.getInt(12),cursor.getInt(13));


        db.close();

        return bat;
    }

    public void update_currentbatting(String name,Integer runs,Integer ball){
        SQLiteDatabase db = this.getWritableDatabase();
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"ones");
        map.put(2,"twos");
        map.put(3,"threes");
        map.put(4,"fours");
        map.put(5,"fives");
        map.put(6,"sixs");
        ContentValues contentValues = new ContentValues();
        contentValues.put("runs",runs);
        contentValues.put("balls",ball);
       // contentValues.put("numb",wkt);
        db.update("currentbatting", contentValues, "currentbatting_id = ?",new String[] { name });
    }

    public void delete_all_current(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("delete from currentbatting");
        db.execSQL("delete from currentbowling");
    }
    public ArrayList<String> Read_all_playing11_batsman(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> currentbatsman_list = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM currentbatting";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Log.e("Hi1","play11 is "+ cursor.getString(5));
                currentbatsman_list.add(cursor.getString(5));
            } while (cursor.moveToNext());
        }
        db.close();

        return currentbatsman_list;
    }
    public void Read_score(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] x =  new String[]{};
        //Cursor cursor = db.rawQuery(TABLE_over_score,"=?",null, null, null, null, null);

    }

    public void Insert_matches(matches matches,Integer matchno ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("matches_id", matchno);
        values.put("tournament_id", matches.getTournament_id());
        values.put("match_no", matches.getMatch_no());
        values.put("mom", matches.getMom());
        values.put("match_name", matches.getMatch_name());
        values.put("date", matches.getDate());
        values.put("total_overs", matches.getTotal_overs());
        db.insert("match_select", null, values);
        db.close();

    }
    public ArrayList<matches> Read_all_matches(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<matches> matches_list = new ArrayList<matches>();
        // Select All Query
        String selectQuery = "SELECT  * FROM match_select";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                matches matches = new matches(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
                matches_list.add(matches);
            } while (cursor.moveToNext());
        }
        db.close();

        return matches_list;
    }
    public void Insert_currentbowling(currentbowling currentbowling ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("currentbowling_id", currentbowling.getName());
        values.put("Tid", currentbowling.getTid());
        values.put("matchid", currentbowling.getMatchid());
        values.put("innings", currentbowling.getInnings());
        values.put("team_name", currentbowling.getTeam_name());
        values.put("name", currentbowling.getName());
        values.put("over", currentbowling.getOver());
        values.put("maiden", currentbowling.getMaiden());
        values.put("runs", currentbowling.getRuns());
        values.put("wicket", currentbowling.getWicket());
        values.put("zeros", currentbowling.getZeros());
        values.put("fours", currentbowling.getFours());
        values.put("sixs", currentbowling.getSixs());
        values.put("wide", currentbowling.getWide());
        values.put("nb", currentbowling.getNb());
        values.put("economyrate", currentbowling.getEconomyrate());
        db.insert("currentbowling", null, values); db.close();

    }
    public ArrayList<currentbowling> Read_all_currentbowling(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<currentbowling> currentbowling_list = new ArrayList<currentbowling>();
        // Select All Query
        String selectQuery = "SELECT  * FROM currentbowling";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                currentbowling currentbowling = new currentbowling(cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5),cursor.getInt(6),cursor.getInt(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10),cursor.getInt(11),cursor.getInt(12),cursor.getInt(13),cursor.getInt(14),cursor.getInt(15));
                currentbowling_list.add(currentbowling);
            } while (cursor.moveToNext());
        }
        db.close();

        return currentbowling_list;
    }
    public ArrayList<String> Read_all_playing11_bowler(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> currentbowling_list = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM currentbowling";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                currentbowling_list.add(cursor.getString(5));
            } while (cursor.moveToNext());
        }
        db.close();

        return currentbowling_list;
    }
}