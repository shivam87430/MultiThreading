package Question.question8;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskScheduleAtFixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    System.out.println("SceduledAtFixedRate Scheduled task at fixed Interval");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, 0, 1, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    System.out.println("SceduleAtFixedDelay scheduled task at fixed Interval");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
      //  executorService.shutdown();
    }
}
