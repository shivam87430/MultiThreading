package Question.question4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinglethreadExecutionShutdownNowEx1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try{
         executorService.submit(new Runnable() {
             @Override
             public void run() {
                 System.out.println("Thread 1");
             }
         });
         executorService.submit(new Runnable() {
             @Override
             public void run() {
                 try {
                     Thread.sleep(1000L);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println("Thread 2");
             }
         });

        }finally{
            executorService.shutdownNow();
        }
        System.out.println("End");
    }
}
