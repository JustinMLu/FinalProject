package data;

public class Stopwatch {

   private long elapsedSeconds;
   private long pausedSeconds;
   private long seconds;
   private long startMs;
   private long minutes;
   private boolean runOnce = true;

   public void timekeep(boolean shouldStart, boolean shouldPause) {

       if (runOnce && !shouldPause) {
           elapsedSeconds = 0;
           startMs = System.currentTimeMillis();
           runOnce = false;
       }

       if (shouldStart && !shouldPause) {

           elapsedSeconds = (long) ((System.currentTimeMillis() - startMs) / 1000);
           seconds = elapsedSeconds + pausedSeconds;

           if (elapsedSeconds >= 60) {
               minutes++;
               runOnce = true;
           }
       }

       else if (shouldPause) {
           pausedSeconds = seconds;
           runOnce = true;
       }

       else if (!shouldStart) {
           elapsedSeconds = 0;
           runOnce = true;
           pausedSeconds = 0;
           startMs = 0;
           minutes = 0;
           seconds = 0;
       }
   }

   public long getSeconds() {
       return seconds;
   }

   public long getMinutes() {
       return minutes;
   }
}

