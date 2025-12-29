import java.util.Scanner;

public class Authentication {
    int n;
    String log;
    String pass;
    Scanner scanner = new Scanner(System.in);
    User user ;
    public void requisites() {
        boolean check;
        do {
            check = false;
            if (scanner.hasNextLine()) {
                log = scanner.nextLine();
                System.out.println(log);
            } else {
                System.out.println("Имя не введено, повторите ввод: ");
                check = true;
            }
        } while (check);
        System.out.println("Пароль : ");
        do {
            check = false;
            if (scanner.hasNextLine()) {
                pass = scanner.nextLine();
                System.out.println(pass);
            } else {
                System.out.println("Пароль не введён, повторите ввод: ");
                check = true;
            }
        } while (check);
    }

    public void assign() {
        user = new User(n, log, pass);
    }

}
