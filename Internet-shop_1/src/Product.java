

public class Product {
    private final String name;
    double value;
    int rating;
    public Product(String name) { this.name = name; }
    public Product(String name, double val, int rat) {
        this.name=name;
        this.value=val;
        this.rating=rat;
    }

    public String getName() {
        return name;
    }
}
