package com.example.admin.cricapp;


public class scorename {

    private String name;
    private String runs;
    private String balls;


    public scorename(String name, String runs, String balls) {
        this.name = name;
        this.runs = runs;
        this.balls = balls;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getBalls() {
        return balls;
    }

    public void setBalls(String balls) {
        this.balls = balls;
    }
}
