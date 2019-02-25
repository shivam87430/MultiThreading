package Question.question6;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future=executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        executorService.shutdown();
        if(future.isDone()){
            System.out.println(future.get());
        }if(future.isCancelled()){
            System.out.println("Thread is cancelled");
        }
    }
}
