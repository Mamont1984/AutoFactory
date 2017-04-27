package ThreadPool;

import Model.Storage;

abstract class Producer<T> implements Runnable {
    protected Storage storage;
    protected T product;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                product = produce();
                storage.put(product);
                System.out.println(getClass().getSimpleName() + Thread.currentThread().getId() + " create: " + product);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract T produce();
}
