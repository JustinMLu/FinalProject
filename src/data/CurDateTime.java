package data;

//LocalDateTime class stores the System's current date and time to be used.
import java.time.LocalDateTime;

public class CurDateTime {

    private LocalDateTime dateTime;
    private static CurDateTime instance;

    /*
    If there is another CurDateTimeInstance already instantiated, return that instance,
    otherwise, instantiate a new one.
     */
    public static CurDateTime getInstance() {
        if (instance == null) {
            instance = new CurDateTime();
        }
        return instance;
    }

    //Constructor initially assigns dateTime the date and time of instantiation.
    private CurDateTime() {
        dateTime = LocalDateTime.now();
    }

    //Updates the dateTime variable with the date and time in which the method was called.
    public void update() {
        dateTime = LocalDateTime.now();
    }

    //Returns the dateTime variable, storing date and time.
    public LocalDateTime getRawDateTime() {
        return dateTime;
    }
}
