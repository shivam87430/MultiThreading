package Question.question13;

public class WaitAndNotifyExample {
    public void worker1(){
        synchronized(this){
            System.out.println("this is worker1 started");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker1 ended");
        }
    }

    public void worker2(){
        synchronized (this){
            System.out.println("worker2 started");
            System.out.println("worker2 ended");
            notify();
        }
    }

    public static void main(String[] args) {
        WaitAndNotifyExample waitAndNotifyExample=new WaitAndNotifyExample();
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
        thread.start();
        thread1.start();
    }

}
