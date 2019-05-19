package data;

public class Stopwatch {

    private long elapsedMs;
    private long pausedSeconds;
    private long seconds;
    private long startMs;
    private long minutes;
    private boolean runOnce = true;

    public void timekeep(boolean shouldStart, boolean shouldPause) {
       /*
       If recently unpaused or started, reset the initial ms storage count
       as well as the elapsed ms.
        */
        if (runOnce && !shouldPause) {
            elapsedMs = 0;
            startMs = System.currentTimeMillis();
            runOnce = false;
        }

        //If start variable is true, start the counter for elapsed seconds
        if (shouldStart && !shouldPause) {

            elapsedMs = (System.currentTimeMillis() - startMs) / 1000;
            seconds = elapsedMs + pausedSeconds;

            //If more than 60 seconds has passed, increment the minutes counter and reset seconds counter.
            if (elapsedMs >= 60) {
                minutes++;
                runOnce = true;
            }
        }
        //If paused, store current seconds and reset initial ms count.
        else if (shouldPause) {
            pausedSeconds = seconds;
            runOnce = true;
        }
        //If shouldStart is false, STOP the timer and reset all states and variables.
        else if (!shouldStart) {
            elapsedMs = 0;
            runOnce = true;
            pausedSeconds = 0;
            startMs = 0;
            minutes = 0;
            seconds = 0;
        }
    }

    //Return seconds elapsed.
    public long getSeconds() {
        return seconds;
    }

    //Return minutes elapsed.
    public long getMinutes() {
        return minutes;
    }
}

