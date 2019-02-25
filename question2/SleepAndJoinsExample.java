package Question.question2;

public class SleepAndJoinsExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                    System.out.println("Running 1st thread");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                    System.out.println("Running 2nd thread");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        thread.start();
        thread.join();
        thread1.start();
        thread1.join();

    }
}
