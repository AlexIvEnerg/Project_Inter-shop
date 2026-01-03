import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Authentication buyer = new Authentication();
        System.out.print("Введите логин и пароль: ");
        buyer.requisites();
        List<Product> list1 = new ArrayList<>();
        list1.add(new Product("Tomatoes", 50.4, 7));
        list1.add(new Product("Cucumber", 40.8, 6));
        list1.add(new Product("Carrot", 30.7, 4));
        list1.add(new Product("Onion", 28.6, 5));
        list1.add(new Product("Cabbage", 24.5, 4));
        list1.sort(new ProductValueComparator());
        List<Product> list2 = new ArrayList<>();
        list2.add(new Product("Loaf", 19.7, 6));
        list2.add(new Product("Rye_bread", 21.8, 7));
        list2.add(new Product("Oatmeal_bread", 41.3, 5));
        list2.sort(new ProductValueComparator());
        List<Product> list3 = new ArrayList<>();
        list3.add(new Product("Sausage", 130, 7));
        list3.add(new Product("Brisket", 180, 8));
        list3.add(new Product("Chicken", 120, 6));
        list3.add(new Product("Cutlets", 150, 7));
        list3.sort(new ProductValueComparator());
        Map<String,List<Product>> goods = Map.ofEntries(Map.entry("Vegetate",list1),Map.entry("Bread",
                list2),Map.entry("Meat",list3));
        System.out.print("Список каталогов товаров: ");
        System.out.println(goods.keySet());
        System.out.print("Укажите количество приобретаемых товаров: ");
        Scanner scanner1 = new Scanner(System.in);
        buyer.n = scanner1.nextInt();   System.out.println(buyer.n);  buyer.assign();
        System.out.println("Выберите каталог: ");   Scanner scanner2 = new Scanner(System.in);
        String name_cat = scanner2.nextLine();    String name_prod;
        for (int i = 0; i < buyer.n; i++) {
            switch (name_cat) {
                case "Vegetate":
                    forPrint(list1);   System.out.println("Выберите по имени нужные товары ");
                    Scanner scanner3 = new Scanner(System.in);
                    name_prod = scanner3.nextLine();
                    switch (name_prod) {
                        case "Tomatoes":
                            buyer.user.bask.baskList.add(list1.get(detection(list1, "Tomatoes")));
                            break;
                        case "Cucumber":
                            buyer.user.bask.baskList.add(list1.get(detection(list1, "Cucumber")));
                            break;
                        case "Carrot":
                            buyer.user.bask.baskList.add(list1.get(detection(list1, "Carrot")));
                            break;
                        case "Onion":
                            buyer.user.bask.baskList.add(list1.get(detection(list1, "Onion")));
                            break;
                        case "Cabbage":
                            buyer.user.bask.baskList.add(list1.get(detection(list1, "Cabbage")));
                            break;
                    }
                    break;
                case "Bread":
                    forPrint(list2);   System.out.println("Выберите по имени нужные товары ");
                    Scanner scanner4 = new Scanner(System.in);
                    name_prod = scanner4.nextLine();
                    switch (name_prod) {
                        case "Loaf":
                            buyer.user.bask.baskList.add(list2.get(detection(list2, "Loaf")));
                            break;
                        case "Rye_bread":
                            buyer.user.bask.baskList.add(list2.get(detection(list2, "Rye_bread")));
                            break;
                        case "Oatmeal_bread":
                            buyer.user.bask.baskList.add(list2.get(detection(list2, "Oatmeal_bread")));
                            break;
                    }
                    break;
                case "Meat":
                    forPrint(list3);   System.out.println("Выберите по имени нужные товары ");
                    Scanner scanner5 = new Scanner(System.in);
                    name_prod = scanner5.nextLine();
                    switch (name_prod) {
                        case "Sausage":
                            buyer.user.bask.baskList.add(list3.get(detection(list3, "Sausage")));
                            break;
                        case "Brisket":
                            buyer.user.bask.baskList.add(list3.get(detection(list3, "Brisket")));
                            break;
                        case "Chicken":
                            buyer.user.bask.baskList.add(list3.get(detection(list3, "Chicken")));
                            break;
                        case "Cutlets":
                            buyer.user.bask.baskList.add(list3.get(detection(list3, "Cutlets")));
                            break;
                    }
                    break;
            }
            if (i == buyer.n - 1) break;
            System.out.println("Попробуйте выбрать требуемые товары в других каталогах");
            Scanner scanner6 = new Scanner(System.in);
            name_cat = scanner6.nextLine();
        }

        System.out.println("Пожалуйста, внесите оплату за каждый выбранный товар");
        List<Double> pays = new ArrayList<>();
        Scanner scan_pay = new Scanner(System.in);
        for (int n = 0; n< buyer.n; n++) {
            double cost = buyer.user.bask.baskList.get(n).value;
            System.out.println(buyer.user.bask.baskList.get(n).getName() + "=" + cost);
            boolean validInput = false;
            do {
                while (!validInput) {
                    if(scan_pay.hasNextDouble()) {
                        pays.add(scan_pay.nextDouble());    System.out.println(" ");
                        String phrase1 = "введённая величина ";    String phrase2 = "требуемой, внесите верную оплату ";
                        if (pays.get(n)<cost)  System.out.println(phrase1 + "меньше " + phrase2);
                        else if (pays.get(n)>cost)  System.out.println(phrase1 + "больше " + phrase2);
                        else  validInput = true;
                    }  else  {   System.out.println("Ошибка: введено не число. Пожалуйста, введите число.");
                        scan_pay.next();
                    }
                }
            } while (pays.get(n) != cost);
        }

        Locale locale = Locale.getDefault();
        boolean validInput1 = false;    System.out.println("Выберите язык отчёта ");
        Scanner scan_lang = new Scanner(System.in);
        while (!validInput1) {
            if (scan_lang.hasNextLine()) {
                String lang = scan_lang.nextLine();
                switch (lang) {
                    case "en":
                        locale = Locale.of("en");
                        break;
                    case "ru":
                        locale = Locale.of("ru");
                        break;
                    case "fr":
                        locale = Locale.of("fr");
                        break;
                    default:
                        System.out.println("Неправильный язык");
                        break;
                }
                validInput1 = true;
            }  else  {
                System.out.print("Введите наименование языка");
                scan_lang.next();
            }
        }
        ResourceBundle print = ResourceBundle.getBundle("Report", locale);
        String string_1, string_2, string_3, string_4;
        string_1 = print.getString("Prod");    string_2 = print.getString("Val");
        string_3 = print.getString("Curr");    string_4 = print.getString("Res");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Дата: "+dateTime.format(formatter));    System.out.println();
        System.out.printf("%-8s     %-5s%n", string_1, string_2);   System.out.format("----------------%n");
        double sum = 0;
        for (int i = 0; i < buyer.n; i++) {
            System.out.format("%-8s     %-5s    %-1s%n", buyer.user.bask.baskList.get(i).getName(),
                    buyer.user.bask.baskList.get(i).value, string_3);    sum += buyer.user.bask.baskList.get(i).value;
        }
        System.out.format("----------------%n");   System.out.printf("%-8s     %.2f   %-1s%n", string_4, sum, string_3);
    }

    public static void forPrint(List<Product> list) {
        for (Product prod : list) System.out.println(prod.getName()+" "+prod.value+" "+prod.rating+", ");
        System.out.println();
    }

    public static int detection(List<Product> list, String nameProd) {
        int ind = 0;
        for (Product prod : list) {
            if (prod.getName().equals(nameProd)) {
                ind = list.indexOf(prod);
            }
        }
        return ind;
    }
}

class ProductValueComparator implements Comparator<Product>{
    public int compare(Product a, Product b){
        return (int) (a.value - b.value);
    }
}