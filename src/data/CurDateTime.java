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

    public LocalDateTime getRawTime() {
        return dateTime;
    }
}
