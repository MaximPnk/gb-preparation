package lesson3.task1;

public class Main {

    public static void main(String[] args) {
        PingPong pp = new PingPong();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pp.ping();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pp.pong();
            }
        }).start();
    }

}
