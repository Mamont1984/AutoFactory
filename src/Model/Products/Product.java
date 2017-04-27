package Model.Products;

public abstract class Product {
    protected int id;

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "id=" + id +
                '}';
    }
}
