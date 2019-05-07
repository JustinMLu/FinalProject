package view;

public class StopwatchTab {

    private static StopwatchTab instance;

    public static StopwatchTab getInstance() {
        if (instance == null) {
            instance = new StopwatchTab();
        }
        return instance;
    }
}
