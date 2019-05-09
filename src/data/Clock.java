package data;

public class Clock {

    private CurDateTime data;
    private long year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public Clock() {
        data = CurDateTime.getInstance();

        year = data.getYear();
        month = data.getMonth();
        day = data.getDay();
        hour = data.getHour();
        minute = data.getMinute();
        second = data.getSecond();
    }

    public void update() {
        year = data.getYear();
        month = data.getMonth();
        day = data.getDay();
        hour = data.getHour();
        minute = data.getMinute();
    }

    public static void main(String[] args) {
        Clock clock = new Clock();

        while (true) {
            clock.update();

            System.out.println("sec: " + clock.second);
        }
    }
}
