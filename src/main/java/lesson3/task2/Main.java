package lesson3.task2;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountService countService = new CountService();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    countService.increase();
                }
            }).start();
        }

    }

}
