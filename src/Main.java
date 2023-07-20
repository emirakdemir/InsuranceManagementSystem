import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidAuthenticationException {
        AccountManager accountManager = new AccountManager();
        Scanner scanner = new Scanner(System.in);

        // Create individual account
        User individualUser = new User("Emir", "Akdemir", "emir@deneme.com", "password", "Student", 22);
        Account individualAccount = new Individual(individualUser);
        accountManager.addAccount(individualAccount);

        // Create enterprise account
        User enterpriseUser = new User("Sigortaci", "Müdür", "sigortaci@example.com", "password", "Manager", 35);
        Account enterpriseAccount = new Enterprise(enterpriseUser);
        accountManager.addAccount(enterpriseAccount);

        // Login
        System.out.print("E-Mail Adresinizi Giriniz: ");
        String email = scanner.nextLine();
        System.out.print("Şifrenizi Giriniz: ");
        String password = scanner.nextLine();

        Account loggedInAccount = accountManager.login(email, password);
        if (loggedInAccount != null) {
            System.out.println("Giriş Başarılı!");
            loggedInAccount.showUserInfo();
        } else {
            System.out.println("Hatalı E-Mail veya Şifre Girdiniz!");
        }
    }
}