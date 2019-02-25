package Question.question4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorShutDownEx1 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
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
                System.out.println("Thread 2");
            }
        });

        }finally {
            executorService.shutdown();
        }

        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        System.out.println("End");
    }
}
