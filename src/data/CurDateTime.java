package data;

public class CurDateTime {

    private static CurDateTime instance;

    public static CurDateTime getInstance() {
        if (instance == null) {
            instance = new CurDateTime();
        }
        return instance;
    }

    private CurDateTime() {

    }
}
