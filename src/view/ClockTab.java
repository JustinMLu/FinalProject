package view;

public class ClockTab {

    private static ClockTab instance;

    public static ClockTab getInstance() {
        if (instance == null) {
            instance = new ClockTab();
        }
        return instance;
    }
}
