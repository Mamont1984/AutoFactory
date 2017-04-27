package ThreadPool;

import Model.Products.Auto;
import Model.Storage;

public class Dealer implements Runnable {
    private Storage<Auto> autoStorage;
    private Auto auto;

    public Dealer(Storage<Auto> autoStorage) {
        this.autoStorage = autoStorage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                auto = autoStorage.get();
                sell();
                Thread.sleep(555);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sell() {
        System.out.println(getClass().getSimpleName() + Thread.currentThread().getId() + " soled: " + auto);
    }
}
