
public class Basket {
    int vol;
    Product[] basket;
    public Basket(int v) {
        this.vol = v;
        basket = new Product[vol];
    }
}
