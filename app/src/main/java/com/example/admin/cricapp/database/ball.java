package com.example.admin.cricapp.database;

/**
 * Created by admin on 12/5/2017.
 */

public class ball {
    private String tournament_id;
    private String match_id;
    private String innings_id;
    private Integer over_no;
    private Integer ballno;
    private Integer valid_ball;
    private Integer runs;
    private String striker;
    private String non_striker;
    private String bowler_name;
    private Integer wicket;
    private Integer extra;
    private String prev_balls;

    public ball(String tournament_id, String match_id, String innings_id, Integer over_no, Integer ballno, Integer valid_ball, Integer runs, String striker, String non_striker, String bowler_name, Integer wicket, Integer extra, String prev_balls) {
        this.tournament_id = tournament_id;
        this.match_id = match_id;
        this.innings_id = innings_id;
        this.over_no = over_no;
        this.ballno = ballno;
        this.valid_ball = valid_ball;
        this.runs = runs;
        this.striker = striker;
        this.non_striker = non_striker;
        this.bowler_name = bowler_name;
        this.wicket = wicket;
        this.extra = extra;
        this.prev_balls = prev_balls;
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

    public Integer getBallno() {
        return ballno;
    }

    public void setBallno(Integer ballno) {
        this.ballno = ballno;
    }

    public Integer getValid_ball() {
        return valid_ball;
    }

    public void setValid_ball(Integer valid_ball) {
        this.valid_ball = valid_ball;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public String getStriker() {
        return striker;
    }

    public void setStriker(String striker) {
        this.striker = striker;
    }

    public String getNon_striker() {
        return non_striker;
    }

    public void setNon_striker(String non_striker) {
        this.non_striker = non_striker;
    }

    public String getBowler_name() {
        return bowler_name;
    }

    public void setBowler_name(String bowler_name) {
        this.bowler_name = bowler_name;
    }

    public Integer getWicket() {
        return wicket;
    }

    public void setWicket(Integer wicket) {
        this.wicket = wicket;
    }

    public Integer getExtra() {
        return extra;
    }

    public void setExtra(Integer extra) {
        this.extra = extra;
    }

    public String getPrev_balls() {
        return prev_balls;
    }

    public void setPrev_balls(String prev_balls) {
        this.prev_balls = prev_balls;
    }
}
