import Model.Products.Accessories;
import Model.Products.Auto;
import Model.Products.Body;
import Model.Products.Engine;
import Model.Storage;
import ThreadPool.*;

public class AutoFactory {
    public static void main(String[] args) {
        Storage<Accessories> accessoriesStorage = new Storage<>(5);
        Storage<Engine> enginesStorage = new Storage<>(5);
        Storage<Body> bodiesStorage = new Storage<>(5);
        Storage<Auto> autoStorage = new Storage<>(5);

        new Thread(new BodiesProducer(bodiesStorage)).start();
        new Thread(new EnginesProducer(enginesStorage)).start();
        ThreadPool<AccessoriesProducer> suppliersThreadPool = new ThreadPool<AccessoriesProducer>();
        ThreadPool<Worker> workersThreadPool = new ThreadPool<Worker>();
        ThreadPool<Dealer> dealersThreadPool = new ThreadPool<Dealer>();

        for (int i = 0; i < 3; i++) {
            dealersThreadPool.submit(new Dealer(autoStorage));
            workersThreadPool.submit(new Worker(accessoriesStorage, enginesStorage, bodiesStorage, autoStorage));
            for (int j = 0; j < 3; j++) {
                suppliersThreadPool.submit(new AccessoriesProducer(accessoriesStorage));
            }
        }
    }
}
