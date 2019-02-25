package Question.question14;

public class WaitAndNotifyAllExample {
    public void worker1(){
        synchronized (this){
            System.out.println("thread1 started");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 ended");
        }
    }
    public void worker2(){
        synchronized (this){
            System.out.println("thread2 started");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 ended");
        }
    }

    public void worker3(){
        synchronized (this){
            System.out.println("thread3 started");
            System.out.println("thread3 ended");
            notifyAll();
        }
    }

    public static void main(String[] args) {
        WaitAndNotifyAllExample waitAndNotifyExample=new WaitAndNotifyAllExample();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                waitAndNotifyExample.worker1();
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                waitAndNotifyExample.worker2();
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                waitAndNotifyExample.worker3();
            }
        });
        thread.start();
        thread1.start();
        thread2.start();
    }
}
