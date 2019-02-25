package Question.question12;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClassExample {
    AtomicInteger count=new AtomicInteger();

     public void worker1(){
         for(int i=1;i<=1000;i++)
         count.incrementAndGet();
     }

    public void worker2(){
        for(int i=1;i<=1000;i++)
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicClassExample atomicClassExample=new AtomicClassExample();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                atomicClassExample.worker1();
            }
        });

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                atomicClassExample.worker2();
            }
        });
            thread.start();
            thread1.start();
            thread.join();
            thread1.join();
        System.out.println(atomicClassExample.count);
     }


}
