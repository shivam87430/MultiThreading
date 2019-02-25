package Question.question9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolExample implements Runnable{
    int id;
    public NewFixedThreadPoolExample(int id){
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Thread Name : "+Thread.currentThread().getName()+" and Start id is : "+id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Name : "+Thread.currentThread().getName()+" and End id is : "+id);
    }
}

class ExecuterServiceDemo{
    public static void main(String[] args) {
        ExecutorService executorService1=Executors.newCachedThreadPool();
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        for(int i=0;i<=15;i++){
            executorService1.submit(new NewFixedThreadPoolExample(i));
        }
        executorService1.shutdown();
    }
}
