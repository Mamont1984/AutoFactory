package Model.Products;

public class Engine extends Product{
    private static volatile Integer idCounter = 1;

    public Engine() {
        synchronized (idCounter) {
            this.id = idCounter++;
        }
    }

}
