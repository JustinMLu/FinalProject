package data;

import java.util.HashMap;

public class Clock {

    private CurDateTime data;
    private int year;
    private String month;
    private int day;
    private int hour;
    private int minute;
    private boolean runOnce = true;
    private long elapsedSeconds;
    private long startMs;
    private int[] clockData;


    public Clock() {
        data = CurDateTime.getInstance();
        year = data.getRawDateTime().getYear();
        month = data.getRawDateTime().getMonth().toString();
        day = data.getRawDateTime().getDayOfMonth();
        hour = data.getRawDateTime().getHour();
        minute = data.getRawDateTime().getMinute();

        clockData = new int[4];
    }

    public String getMonth() {
        return month;
    }

    public int getData(int var) {
        return clockData[var];
    }

    public void update() {
        if (runOnce) {
            startMs = System.currentTimeMillis();
            runOnce = false;
        }

        elapsedSeconds = (long) ((System.currentTimeMillis() - startMs) / 1000);

        if (elapsedSeconds >= 5) {
            data.update();
            year = data.getRawDateTime().getYear();
            month = data.getRawDateTime().getMonth().toString();
            day = data.getRawDateTime().getDayOfMonth();
            hour = data.getRawDateTime().getHour();
            minute = data.getRawDateTime().getMinute();

            elapsedSeconds = 0;
            runOnce = true;
        }
        clockData[0] = year;
        clockData[1] = day;
        clockData[2] = hour;
        clockData[3] = minute;
    }
}
