package com.example.admin.cricapp.database;

/**
 * Created by admin on 12/21/2017.
 */

public class innings {
    private String tournament_id;
    private String match_id;
    private Integer innings_no;
    private String batting_team;
    private String bowling_team;
    private Double total_overs;
    private Integer total_runs;
    private Integer total_wkt;


    public innings(String tournament_id,String match_id, Integer innings_no, String batting_team, String bowling_team, Double total_overs, Integer total_runs, Integer total_wkt) {
        this.match_id = match_id;
        this.tournament_id = tournament_id;
        this.innings_no = innings_no;
        this.batting_team = batting_team;
        this.bowling_team = bowling_team;
        this.total_overs = total_overs;
        this.total_runs = total_runs;
        this.total_wkt = total_wkt;
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(String tournament_id) {
        this.tournament_id = tournament_id;
    }

    public Integer getInnings_no() {
        return innings_no;
    }

    public void setInnings_no(Integer innings_no) {
        this.innings_no = innings_no;
    }

    public String getBatting_team() {
        return batting_team;
    }

    public void setBatting_team(String batting_team) {
        this.batting_team = batting_team;
    }

    public String getBowling_team() {
        return bowling_team;
    }

    public void setBowling_team(String bowling_team) {
        this.bowling_team = bowling_team;
    }

    public Double getTotal_overs() {
        return total_overs;
    }

    public void setTotal_overs(Double total_overs) {
        this.total_overs = total_overs;
    }

    public Integer getTotal_runs() {
        return total_runs;
    }

    public void setTotal_runs(Integer total_runs) {
        this.total_runs = total_runs;
    }

    public Integer getTotal_wkt() {
        return total_wkt;
    }

    public void setTotal_wkt(Integer total_wkt) {
        this.total_wkt = total_wkt;
    }

    @Override
    public String toString() {
        return "innings{" +
                "tournament_id='" + tournament_id + '\'' +
                ", match_id='" + match_id + '\'' +
                ", innings_no=" + innings_no +
                ", batting_team='" + batting_team + '\'' +
                ", bowling_team='" + bowling_team + '\'' +
                ", total_overs=" + total_overs +
                ", total_runs=" + total_runs +
                ", total_wkt=" + total_wkt +
                '}';
    }
}
