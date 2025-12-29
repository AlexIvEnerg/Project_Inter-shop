
public class User {
    String Login;
    String Password;
    int numb;
    Basket bask;
    public User(int n, String log, String pass) {
        this.numb = n;
        this.Login = log;
        this.Password = pass;
        bask = new Basket(numb);
    }

}
