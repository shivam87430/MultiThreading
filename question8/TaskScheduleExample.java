package Question.question8;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskScheduleExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task exceuted After 1 sec");
            }
        },1, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
