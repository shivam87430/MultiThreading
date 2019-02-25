package Question.question7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SubmitListExample {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<Integer>> runnablelist = new ArrayList<>();

        runnablelist.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        runnablelist.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });
        runnablelist.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 3;
            }
        });
        runnablelist.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 4;
            }
        });
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<Integer>> futureList = executorService.invokeAll(runnablelist);
        futureList.forEach((e)->{
            if(e.isDone()){
                try{
                    System.out.println(e.get());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (ExecutionException e1) {
                    e1.printStackTrace();
                }
            }
            });
    }
}
