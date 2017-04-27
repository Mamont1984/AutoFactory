package Model.Products;

public class Auto extends Product{
    private static volatile Integer idCounter = 1;
    public Body body;
    public Engine engine;
    public Accessories accessories;

    public Auto(Body body, Engine engine, Accessories accessories) {
        synchronized (idCounter) {
            this.id = idCounter++;
        }
        this.body = body;
        this.engine = engine;
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " VIN=" + id +'{' + body + engine + accessories + '}';
    }
}
