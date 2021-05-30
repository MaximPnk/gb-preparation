package lesson3.task2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CountService {

    long count;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void increase() {
        lock.writeLock().lock();
        count++;
        System.out.println(count);
        lock.writeLock().unlock();
    }

}
