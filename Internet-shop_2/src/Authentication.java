import java.util.Scanner;

public class Authentication {
    int n;
    private String log;
    private String pass;
    Scanner scanner = new Scanner(System.in);
    User user ;

    public String getLog() {
        return log;
    }
    public String getPass() {
        return pass;
    }
    public void setLog(String log) {
        this.log = log;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void requisites() {
        boolean check;
        do {
            check = false;
            if (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                setLog(name);
                System.out.println(getLog());
            } else {
                System.out.println("Имя не введено, повторите ввод: ");
                check = true;
            }
        } while (check);
        System.out.println("Пароль : ");
        do {
            check = false;
            if (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                setPass(string);
                System.out.println(getPass());
            } else {
                System.out.println("Пароль не введён, повторите ввод: ");
                check = true;
            }
        } while (check);
    }

    public void assign() {
        user = new User(n, getLog(), getPass());
    }

}
