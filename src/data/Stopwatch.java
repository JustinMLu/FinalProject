package data;

public class Stopwatch {

   private long elapsedSeconds;
   private long seconds;
   private long startMs;
   private long minutes;
   private boolean runOnce = true;

   public void timekeep(boolean shouldStart, boolean shouldPause) {

       if (runOnce && !shouldPause) {
           startMs = System.currentTimeMillis();
           runOnce = false;
       }

       if (shouldStart && !shouldPause) {

           elapsedSeconds = (long) ((System.currentTimeMillis() - startMs) / 1000);
           seconds = elapsedSeconds;

           if (elapsedSeconds >= 60) {
               minutes++;
               elapsedSeconds = 0;
               runOnce = true;
           }
       }

       else if (shouldPause) {
           elapsedSeconds = 0;
           runOnce = true;
       }

       else if (!shouldStart) {
           elapsedSeconds = 0;
           runOnce = true;
           startMs = 0;
           minutes = 0;
       }
   }
}

