package Question.question1;

public class ThreadEx implements Runnable {

    @Override
    public void run() {
        System.out.println("This is through Runnable");
    }
}
class ThreadEx1 implements Runnable {

    @Override
    public void run() {
        System.out.println("This is through Runnable2");
    }
}

class Main{
    public static void main(String[] args) {
        ThreadEx threadEx=new ThreadEx();
        ThreadEx1 threadEx1=new ThreadEx1();
        Thread t=new Thread(threadEx);
        Thread t1=new Thread(threadEx1);
        t.start();
        t1.start();
    }
}
