package Model.Products;

public class Body extends Product{
    private static volatile Integer idCounter = 1;

    public Body() {
        synchronized (idCounter) {
            this.id = idCounter++;
        }
    }
}
