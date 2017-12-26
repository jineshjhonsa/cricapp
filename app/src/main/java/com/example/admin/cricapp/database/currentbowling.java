package com.example.admin.cricapp.database;

/**
 * Created by admin on 12/20/2017.
 */

public class currentbowling {
    private Integer Tid;
    private Integer matchid;
    private Integer innings;
    private String team_name;
    private String name;
    private Integer over;
    private Integer maiden;
    private Integer runs;
    private Integer wicket;
    private Integer zeros;
    private Integer fours;
    private Integer sixs;
    private Integer wide;
    private Integer nb;
    private Integer economyrate;

    public currentbowling(Integer tid, Integer matchid, Integer innings, String team_name, String name, Integer over, Integer maiden, Integer runs, Integer wicket, Integer zeros, Integer fours, Integer sixs, Integer wide, Integer nb, Integer economyrate) {
        Tid = tid;
        this.matchid = matchid;
        this.innings = innings;
        this.team_name = team_name;
        this.name = name;
        this.over = over;
        this.maiden = maiden;
        this.runs = runs;
        this.wicket = wicket;
        this.zeros = zeros;
        this.fours = fours;
        this.sixs = sixs;
        this.wide = wide;
        this.nb = nb;
        this.economyrate = economyrate;
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

    public Integer getOver() {
        return over;
    }

    public void setOver(Integer over) {
        this.over = over;
    }

    public Integer getMaiden() {
        return maiden;
    }

    public void setMaiden(Integer maiden) {
        this.maiden = maiden;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getWicket() {
        return wicket;
    }

    public void setWicket(Integer wicket) {
        this.wicket = wicket;
    }

    public Integer getZeros() {
        return zeros;
    }

    public void setZeros(Integer zeros) {
        this.zeros = zeros;
    }

    public Integer getFours() {
        return fours;
    }

    public void setFours(Integer fours) {
        this.fours = fours;
    }

    public Integer getSixs() {
        return sixs;
    }

    public void setSixs(Integer sixs) {
        this.sixs = sixs;
    }

    public Integer getWide() {
        return wide;
    }

    public void setWide(Integer wide) {
        this.wide = wide;
    }

    public Integer getNb() {
        return nb;
    }

    public void setNb(Integer nb) {
        this.nb = nb;
    }

    public Integer getEconomyrate() {
        return economyrate;
    }

    public void setEconomyrate(Integer economyrate) {
        this.economyrate = economyrate;
    }
}
