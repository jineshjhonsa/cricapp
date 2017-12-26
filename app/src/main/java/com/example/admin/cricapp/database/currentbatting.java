package com.example.admin.cricapp.database;

/**
 * Created by admin on 12/20/2017.
 */

public class currentbatting {

    private Integer Tid;
    private Integer matchid;
    private Integer innings;
    private String team_name;
    private String name;
    private Integer runs;
    private Integer balls;
    private Integer ones;
    private Integer twos;
    private Integer threes;
    private Integer fours;
    private Integer fives;
    private Integer sixs;

    public currentbatting(Integer tid, Integer matchid, Integer innings, String team_name, String name, Integer runs, Integer balls, Integer ones, Integer twos, Integer threes, Integer fours, Integer fives, Integer sixs) {
        Tid = tid;
        this.matchid = matchid;
        this.innings = innings;
        this.team_name = team_name;
        this.name = name;
        this.runs = runs;
        this.balls = balls;
        this.ones = ones;
        this.twos = twos;
        this.threes = threes;
        this.fours = fours;
        this.fives = fives;
        this.sixs = sixs;
    }

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public Integer getTid() {
        return Tid;
    }

    public void setTid(Integer tid) {
        Tid = tid;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    public Integer getInnings() {
        return innings;
    }

    public void setInnings(Integer innings) {
        this.innings = innings;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getOnes() {
        return ones;
    }

    public void setOnes(Integer ones) {
        this.ones = ones;
    }

    public Integer getTwos() {
        return twos;
    }

    public void setTwos(Integer twos) {
        this.twos = twos;
    }

    public Integer getThrees() {
        return threes;
    }

    public void setThrees(Integer threes) {
        this.threes = threes;
    }

    public Integer getFours() {
        return fours;
    }

    public void setFours(Integer fours) {
        this.fours = fours;
    }

    public Integer getFives() {
        return fives;
    }

    public void setFives(Integer fives) {
        this.fives = fives;
    }

    public Integer getSixs() {
        return sixs;
    }

    public void setSixs(Integer sixs) {
        this.sixs = sixs;
    }
}
