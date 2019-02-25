package Question.question15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockExample {
    Lock lock=new ReentrantLock(true);
    Condition condition=lock.newCondition();
    public void worker1(){
            lock.lock();
            System.out.println("worker1 started");
            try {
                condition.await();
                System.out.println("worker1 ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    public void worker2(){
            lock.lock();
            System.out.println("worker2 started");
            try {
                condition.await();
            System.out.println("worker2 ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }


    public void worker3(){
           try {
               lock.lock();
               System.out.println("worekr3 started");
               System.out.println("worker3 ended");
               condition.signalAll();
           }finally{
               lock.unlock();
        }

        }

    public static void main(String[] args) {
        ReetrantLockExample reetrantLockExample=new ReetrantLockExample();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reetrantLockExample.worker1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reetrantLockExample.worker2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reetrantLockExample.worker3();
            }
        }).start();
    }
}
