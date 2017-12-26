package com.example.admin.cricapp.database;

/**
 * Created by admin on 12/23/2017.
 */

public class team {
    private String tournament_name;
    private String team_owner;
    private String team_no;
    private String team_name;
    private String team_colour;
    private String captain;
    private String player2;
    private String player3;
    private String player4;
    private String player5;
    private String player6;
    private String player7;
    private String player8;
    private String player9;
    private String player10;
    private String player11;
    private String player12;

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public String getTeam_owner() {
        return team_owner;
    }

    public void setTeam_owner(String team_owner) {
        this.team_owner = team_owner;
    }

    public String getTeam_no() {
        return team_no;
    }

    public void setTeam_no(String team_no) {
        this.team_no = team_no;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_colour() {
        return team_colour;
    }

    public void setTeam_colour(String team_colour) {
        this.team_colour = team_colour;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public String getPlayer5() {
        return player5;
    }

    public void setPlayer5(String player5) {
        this.player5 = player5;
    }

    public String getPlayer6() {
        return player6;
    }

    public void setPlayer6(String player6) {
        this.player6 = player6;
    }

    public String getPlayer7() {
        return player7;
    }

    public void setPlayer7(String player7) {
        this.player7 = player7;
    }

    public String getPlayer8() {
        return player8;
    }

    public void setPlayer8(String player8) {
        this.player8 = player8;
    }

    public String getPlayer9() {
        return player9;
    }

    public void setPlayer9(String player9) {
        this.player9 = player9;
    }

    public String getPlayer10() {
        return player10;
    }

    public void setPlayer10(String player10) {
        this.player10 = player10;
    }

    public String getPlayer11() {
        return player11;
    }

    public void setPlayer11(String player11) {
        this.player11 = player11;
    }

    public String getPlayer12() {
        return player12;
    }

    public void setPlayer12(String player12) {
        this.player12 = player12;
    }

    public team(String tournament_name, String team_owner, String team_no, String team_name, String team_colour, String captain, String player2, String player3, String player4, String player5, String player6, String player7, String player8, String player9, String player10, String player11, String player12) {
        this.tournament_name = tournament_name;
        this.team_owner = team_owner;
        this.team_no = team_no;
        this.team_name = team_name;
        this.team_colour = team_colour;
        this.captain = captain;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.player6 = player6;
        this.player7 = player7;
        this.player8 = player8;
        this.player9 = player9;
        this.player10 = player10;
        this.player11 = player11;
        this.player12 = player12;
    }

    @Override
    public String toString() {
        return "team{" +
                "tournament_name='" + tournament_name + '\'' +
                ", team_owner='" + team_owner + '\'' +
                ", team_no='" + team_no + '\'' +
                ", team_name='" + team_name + '\'' +
                ", team_colour='" + team_colour + '\'' +
                ", captain='" + captain + '\'' +
                ", player2='" + player2 + '\'' +
                ", player3='" + player3 + '\'' +
                ", player4='" + player4 + '\'' +
                ", player5='" + player5 + '\'' +
                ", player6='" + player6 + '\'' +
                ", player7='" + player7 + '\'' +
                ", player8='" + player8 + '\'' +
                ", player9='" + player9 + '\'' +
                ", player10='" + player10 + '\'' +
                ", player11='" + player11 + '\'' +
                ", player12='" + player12 + '\'' +
                '}';
    }
}
