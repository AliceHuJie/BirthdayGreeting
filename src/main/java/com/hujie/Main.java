package com.hujie;

import java.util.Timer;


public class Main {
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;


    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new DailyTask(), 0, PERIOD_DAY);
    }
}
