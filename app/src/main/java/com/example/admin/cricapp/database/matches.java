package com.example.admin.cricapp.database;

/**
 * Created by admin on 12/21/2017.
 */

public class matches {
    private String tournament_id;
    private String match_no;
    private String mom;
    private String match_name;
    private String date;
    private Integer total_overs;

    public matches(String tournament_id, String match_no, String mom, String match_name, String date, Integer total_overs) {
        this.tournament_id = tournament_id;
        this.match_no = match_no;
        this.mom = mom;
        this.match_name = match_name;
        this.date = date;
        this.total_overs = total_overs;
    }

    public String getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(String tournament_id) {
        this.tournament_id = tournament_id;
    }


    public String getMatch_no() {
        return match_no;
    }

    public void setMatch_no(String match_no) {
        this.match_no = match_no;
    }

    public String getMom() {
        return mom;
    }

    public void setMom(String mom) {
        this.mom = mom;
    }

    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTotal_overs() {
        return total_overs;
    }

    public void setTotal_overs(Integer total_overs) {
        this.total_overs = total_overs;
    }
}
