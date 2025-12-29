

public class Main {
    public static void main(String[] args) {
        Category cat1 = new Category(5, "cat1"); // Vegetate
        Category cat2 = new Category(3, "cat2"); // Bread
        Category cat3 = new Category(4, "cat3"); // Meat
        User user_1 = new User(6, "Charlotte", "f157");
        User user_2 = new User(3, "Camilla", "t284");
        User user_3 = new User(5,"John", "m426");
        Product[] bask1 = new Product[cat1.vol]; // vol - количество товаров в кат-рии
        bask1[0]= new Product("Tomatoes",50.4,7);
        bask1[1]= new Product("Cucumber", 40.8, 6);
        bask1[2]= new Product("Carrot", 30.7, 4); // морковь
        bask1[3]= new Product("Onion", 28.6, 5); //  репчатый лук
        bask1[4]= new Product("Cabbage", 24.5, 4); // капуста
        Product[] bask2 = new Product[cat2.vol];
        bask2[0]= new Product("Loaf", 19.7, 6);
        bask2[1]= new Product("Rye_bread", 21.8, 7);  // ржаной
        bask2[2]= new Product("Oatmeal_bread", 41.3, 5);  // овсяный
        Product[] bask3 = new Product[cat3.vol];
        bask3[0]= new Product("Sausage", 130, 7);
        bask3[1]= new Product("Brisket", 180, 8);
        bask3[2]= new Product("Chicken", 120, 6);
        bask3[3]= new Product("Cutlets", 150, 7);
        cat1.setGoods(bask1);
        cat1.forPrint(cat1.goods);
        cat2.setGoods(bask2);
        cat2.forPrint(cat2.goods);
        cat3.setGoods(bask3);
        cat3.forPrint(cat3.goods);
        user_1.bask.basket[0]=bask1[1];
        user_1.bask.basket[1]=bask1[0];
        user_1.bask.basket[2]=bask2[1];
        user_1.bask.basket[3]=bask3[3];
        user_1.bask.basket[4]=bask3[0];
        user_1.bask.basket[5]=bask1[2];
        user_2.bask.basket[0]=bask2[0];
        user_2.bask.basket[1]=bask3[0];
        user_2.bask.basket[2]=bask1[0];
        user_3.bask.basket[0]=bask3[2];
        user_3.bask.basket[1]=bask1[2];
        user_3.bask.basket[2]=bask1[4];
        user_3.bask.basket[3]=bask2[1];
        user_3.bask.basket[4]=bask1[3];
        System.out.println("The buyer "+user_1.Login+", "+user_1.Password + "bought the following "+user_1.numb +" items: ");
        for (Product exam : user_1.bask.basket) {
            System.out.println(exam.getName()+"  "+ exam.value);
        }
        System.out.println();
        System.out.println("The buyer "+user_2.Login+", "+user_2.Password + "bought the following "+user_2.numb +" items: ");
        for (Product exam : user_2.bask.basket) {
            System.out.println(exam.getName()+"  "+ exam.value);
        }
        System.out.println();
        System.out.println("The buyer "+user_3.Login+", "+user_3.Password + "bought the following "+user_3.numb +" items: ");
        for (Product exam : user_3.bask.basket) {
            System.out.println(exam.getName()+"  "+ exam.value);
        }
    }
}
