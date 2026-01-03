import java.util.ArrayList;
import java.util.List;

public class Basket {
    int vol;
    Product[] basket;
    List<Product> baskList = new ArrayList<>();
    public Basket(int v) {
        this.vol = v;
        basket = new Product[vol];
    }
}
