package com.example.admin.cricapp.database;

/**
 * Created by admin on 12/21/2017.
 */

public class over {

    private String tournament_id;
    private String match_id;
    private String innings_id;
    private Integer over_no;
    private Integer runs;
    private String prev_ball_runs;
    private Integer wicket;

    public over(String tournament_id, String match_id, String innings_id, Integer over_no, Integer runs, String prev_ball_runs, Integer wicket) {
        this.tournament_id = tournament_id;
        this.match_id = match_id;
        this.innings_id = innings_id;
        this.over_no = over_no;
        this.runs = runs;
        this.prev_ball_runs = prev_ball_runs;
        this.wicket = wicket;
    }

    public String getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(String tournament_id) {
        this.tournament_id = tournament_id;
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getInnings_id() {
        return innings_id;
    }

    public void setInnings_id(String innings_id) {
        this.innings_id = innings_id;
    }

    public Integer getOver_no() {
        return over_no;
    }

    public void setOver_no(Integer over_no) {
        this.over_no = over_no;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public String getPrev_ball_runs() {
        return prev_ball_runs;
    }

    public void setPrev_ball_runs(String prev_ball_runs) {
        this.prev_ball_runs = prev_ball_runs;
    }

    public Integer getWicket() {
        return wicket;
    }

    public void setWicket(Integer wicket) {
        this.wicket = wicket;
    }
}
