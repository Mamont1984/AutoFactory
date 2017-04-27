package ThreadPool;

import Model.Products.Engine;
import Model.Storage;

public class EnginesProducer extends Producer implements Runnable {

    public EnginesProducer(Storage storage) {
        super(storage);
    }

    @Override
    protected Object produce() {
        return new Engine();
    }
}
