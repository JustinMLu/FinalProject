package data;

public class Stopwatch {

   private long elapsedSeconds;
   private long startMs;
    private long minutes;

   public void timekeep(boolean shouldStart, boolean shouldPause, boolean shouldStop) {
       boolean runOnce = true;

       if (shouldStart && !shouldStop) {

           if (runOnce) {
               startMs = System.currentTimeMillis();
               runOnce = false;
           }

           elapsedSeconds = (long) ((System.currentTimeMillis() - startMs) / 1000);

           if (elapsedSeconds >= 60) {
               minutes++;
               elapsedSeconds = 0;
               runOnce = true;
           }
       }
   }
}
