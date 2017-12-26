package com.example.admin.cricapp.database;

/**
 * Created by admin on 12/7/2017.
 */

public class player {


    private String playername;
    private String team_name;
    private String playertype;
    private String playerstyle;
    private Integer totalruns;
    private Integer wickets;
    private Double totalovers;
    private Integer age;
    private Integer matches;
    private Integer Innings;
    private Integer notout;
    private Integer Highest_score;
    private Double Avg;
    private Integer Ball_Faced;
    private Double Strikerate;
    private Integer fours;
    private Integer sixs;
    private Integer catches;
    private Integer stumps;

    public player(String playername, String team_name, String playertype, String playerstyle, Integer totalruns, Integer wickets, Double totalovers, Integer age, Integer matches, Integer innings, Integer notout, Integer highest_score, Double avg, Integer ball_Faced, Double strikerate, Integer fours, Integer sixs, Integer catches, Integer stumps) {

        this.playername = playername;
        this.team_name = team_name;
        this.playertype = playertype;
        this.playerstyle = playerstyle;
        this.totalruns = totalruns;
        this.wickets = wickets;
        this.totalovers = totalovers;
        this.age = age;
        this.matches = matches;
        Innings = innings;
        this.notout = notout;
        Highest_score = highest_score;
        Avg = avg;
        Ball_Faced = ball_Faced;
        Strikerate = strikerate;
        this.fours = fours;
        this.sixs = sixs;
        this.catches = catches;
        this.stumps = stumps;
    }


    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getPlayertype() {
        return playertype;
    }

    public void setPlayertype(String playertype) {
        this.playertype = playertype;
    }

    public String getPlayerstyle() {
        return playerstyle;
    }

    public void setPlayerstyle(String playerstyle) {
        this.playerstyle = playerstyle;
    }

    public Integer getTotalruns() {
        return totalruns;
    }

    public void setTotalruns(Integer totalruns) {
        this.totalruns = totalruns;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Double getTotalovers() {
        return totalovers;
    }

    public void setTotalovers(Double totalovers) {
        this.totalovers = totalovers;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getInnings() {
        return Innings;
    }

    public void setInnings(Integer innings) {
        Innings = innings;
    }

    public Integer getNotout() {
        return notout;
    }

    public void setNotout(Integer notout) {
        this.notout = notout;
    }

    public Integer getHighest_score() {
        return Highest_score;
    }

    public void setHighest_score(Integer highest_score) {
        Highest_score = highest_score;
    }

    public Double getAvg() {
        return Avg;
    }

    public void setAvg(Double avg) {
        Avg = avg;
    }

    public Integer getBall_Faced() {
        return Ball_Faced;
    }

    public void setBall_Faced(Integer ball_Faced) {
        Ball_Faced = ball_Faced;
    }

    public Double getStrikerate() {
        return Strikerate;
    }

    public void setStrikerate(Double strikerate) {
        Strikerate = strikerate;
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

    public Integer getCatches() {
        return catches;
    }

    public void setCatches(Integer catches) {
        this.catches = catches;
    }

    public Integer getStumps() {
        return stumps;
    }

    public void setStumps(Integer stumps) {
        this.stumps = stumps;
    }

    @Override
    public String toString() {
        return "player{" +

                ", playername='" + playername + '\'' +
                ", team_name='" + team_name + '\'' +
                ", playertype='" + playertype + '\'' +
                ", playerstyle='" + playerstyle + '\'' +
                ", totalruns=" + totalruns +
                ", wickets=" + wickets +
                ", totalovers=" + totalovers +
                ", age=" + age +
                ", match_select=" + matches +
                ", Innings=" + Innings +
                ", notout=" + notout +
                ", Highest_score=" + Highest_score +
                ", Avg=" + Avg +
                ", Ball_Faced=" + Ball_Faced +
                ", Strikerate=" + Strikerate +
                ", fours=" + fours +
                ", sixs=" + sixs +
                ", catches=" + catches +
                ", stumps=" + stumps +
                '}';
    }
}
