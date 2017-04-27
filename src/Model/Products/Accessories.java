package Model.Products;

public class Accessories extends Product{
    private static volatile Integer idCounter = 1;

    public Accessories() {
        synchronized (idCounter) {
            this.id = idCounter++;
        }
    }
}
