package ThreadPool;

import Model.Products.*;
import Model.Storage;

public class Worker implements Runnable {
    private Storage<Accessories> accessoriesStorage;
    private Storage<Engine> engineStorage;
    private Storage<Body> bodyStorage;
    private Storage<Auto> autoStorage;
    private Accessories accessories;
    private Engine engine;
    private Body body;
    private Auto auto;

    public Worker(Storage<Accessories> accessoriesStorage, Storage<Engine> engineStorage,
                  Storage<Body> bodyStorage, Storage<Auto> autoStorage) {
        this.accessoriesStorage = accessoriesStorage;
        this.engineStorage = engineStorage;
        this.bodyStorage = bodyStorage;
        this.autoStorage = autoStorage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                getPieces();
                produce();
                putToStorage();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getPieces() {
        accessories = accessoriesStorage.get();
        System.out.println(getClass().getSimpleName() + Thread.currentThread().getId() + " take: " +  accessories);
        engine = engineStorage.get();
        System.out.println(getClass().getSimpleName() + Thread.currentThread().getId() + " take: " +  engine);
        body = bodyStorage.get();
        System.out.println(getClass().getSimpleName() + Thread.currentThread().getId() + " take: " +  body);
    }

    private void produce() {
        auto = new Auto(body, engine, accessories);
        System.out.println(getClass().getSimpleName() + Thread.currentThread().getId() + " produced: " + auto);
    }

    private void putToStorage() {
        autoStorage.put(auto);
        System.out.println(getClass().getSimpleName() + Thread.currentThread().getId() + " received: " + auto);
    }
}
