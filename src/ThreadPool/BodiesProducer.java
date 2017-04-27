package ThreadPool;

import Model.Products.Body;
import Model.Storage;

public class BodiesProducer extends Producer implements Runnable {

    public BodiesProducer(Storage storage) {
        super(storage);
    }

    @Override
    protected Object produce() {
        return new Body();
    }

}

