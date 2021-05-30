package lesson3.task1;

public class PingPong {

    private boolean isPing;

    public synchronized void ping() {
        try {
            while (isPing) {
                wait();
            }
            System.out.println("ping");
            isPing = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void pong() {
        try {
            while (!isPing) {
                wait();
            }
            System.out.println("pong");
            isPing = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
