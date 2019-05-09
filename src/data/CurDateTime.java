package data;

import java.time.LocalDateTime;

public class CurDateTime {

    private LocalDateTime dateTime;
    private static CurDateTime instance;

    public static CurDateTime getInstance() {
        if (instance == null) {
            instance = new CurDateTime();
        }
        return instance;
    }

    private CurDateTime() {
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getRawDateTime() {
        return dateTime;

    }

    public int getHour() {
        return dateTime.getHour();
    }

    public int getMinute() {
        return dateTime.getMinute();
    }

    public int getSecond() {
        return dateTime.getSecond();
    }

    public long getYear() {
        return dateTime.getYear();
    }

    public int getMonth() {
        return dateTime.getMonth().getValue();
    }

    public int getDay() {
        return dateTime.getDayOfMonth();
    }

}
