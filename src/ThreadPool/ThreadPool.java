package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool<T> {

    private ExecutorService service;

    public ThreadPool() {
        this.service = Executors.newCachedThreadPool();
    }

    public void submit(Runnable r) {
        service.submit(r);
    }
}
