package com.infinity.ezlearn;

/**
 * Created by Ivan Liu on 05/12/2018.
 */

public class Match {
    private String title, competition, time;
    private boolean bigmatch;

    public Match() {
    }

    public Match(String t, boolean bm, String c, String tm) {
        this.title = t;
        this.competition = c;
        this.bigmatch = bm;
        this.time = tm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public boolean getBigmatch() {
        return bigmatch;
    }

    public void setBigmatch(boolean bm) {
        this.bigmatch = bm;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String c) {
        this.competition = c;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String t) {
        this.time = t;
    }
}


