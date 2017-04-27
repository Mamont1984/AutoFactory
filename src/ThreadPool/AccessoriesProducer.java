package ThreadPool;

import Model.Products.Accessories;
import Model.Storage;

public class AccessoriesProducer extends Producer implements Runnable {

    public AccessoriesProducer(Storage storage) {
        super(storage);
    }

    @Override
    protected Object produce() {
        return new Accessories();
    }

}
