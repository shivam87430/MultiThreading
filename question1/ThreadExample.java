package Question.question1;

public class ThreadExample extends Thread{
    public void run(){
        System.out.println("this is thread Example");
    }

    public static void main(String[] args) {
        ThreadExample threadExample=new ThreadExample();
        threadExample.start();
    }
}
