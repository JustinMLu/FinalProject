package data;

public class Clock {

    private CurDateTime data;
    private int year;
    private String month;
    private int day;
    private int hour;
    private int minute;
    private boolean runOnce = true;
    private long elapsedMs;
    private long startMs;
    private int[] clockData;

    /*
    Upon initialization, all local variables pertaining to date and time are assigned their
    respective values by using the CurDateTime Object, referenced here as 'data'.
     */
    public Clock() {
        data = CurDateTime.getInstance();
        year = data.getRawDateTime().getYear();
        month = data.getRawDateTime().getMonth().toString();
        day = data.getRawDateTime().getDayOfMonth();
        hour = data.getRawDateTime().getHour();
        minute = data.getRawDateTime().getMinute();

        //integer array for conveniently assigning and accessing clock data.
        clockData = new int[4];
    }

    //Retrieves the month as a String
    public String getMonth() {
        return month;
    }

    //Retrieves the other date time variables inside the clockData array.
    public int getData(int var) {
        return clockData[var];
    }

    /*
    When called, records the startMs time ONCE as well as a running counter of
    the current time (milliseconds). By subtracting these two variables and then,
    dividing by 1000, one is able to figure out how many seconds have elapsed
    since the method was initially called in a loop.
     */
    public void update() {
        if (runOnce) {
            startMs = System.currentTimeMillis();
            runOnce = false;
        }

        elapsedMs = (System.currentTimeMillis() - startMs) / 1000;

        /*
        If the elapsed seconds are greater than 5,
        update all variables and reset the timer mechanism
        */
        if (elapsedMs >= 5) {
            data.update();
            year = data.getRawDateTime().getYear();
            month = data.getRawDateTime().getMonth().toString();
            day = data.getRawDateTime().getDayOfMonth();
            hour = data.getRawDateTime().getHour();
            minute = data.getRawDateTime().getMinute();

            elapsedMs = 0;
            runOnce = true;
        }

        //Store data inside clockData array except for month which is a String.
        clockData[0] = year;
        clockData[1] = day;
        clockData[2] = hour;
        clockData[3] = minute;
    }
}
