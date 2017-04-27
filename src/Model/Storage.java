package Model;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage<T> {

    private final Queue<T> queue = new LinkedBlockingQueue<T>();
    private final int MAX_CAPACITY;

    public Storage(int max_capacity) {
        this.MAX_CAPACITY = max_capacity;
    }

    public synchronized void put(T product) {
        while (queue.size() == MAX_CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(product);
        notify();
    }

    public synchronized T get() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        return queue.poll();
    }
}
