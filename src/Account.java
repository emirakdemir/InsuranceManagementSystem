import java.util.ArrayList;
public abstract class Account implements Comparable<Account> {
    private AuthenticationStatus authenticationStatus;
    private User user;
    private ArrayList<Insurance> insurances;

    public Account(User user) {
        this.authenticationStatus = AuthenticationStatus.FAIL;
        this.user = user;
        this.insurances = new ArrayList<>();
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            authenticationStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Hatalı E-Mail veya Şifre.");
        }
    }

    public void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }

    public abstract void showAccountType();

    public void showUserInfo() {
        System.out.println("Ad: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Meslek: " + user.getOccupation());
        System.out.println("Yaş: " + user.getAge());
        System.out.println("Son Giriş Tarihi: " + user.getLastLoginDate());
        System.out.println("Adres:");
        for (Address address : user.getAddresses()) {
            System.out.println(address.getAddressInfo());
        }
        System.out.println("Sigortalar:");
        for (Insurance insurance : insurances) {
            System.out.println("Sigorta Adı: " + insurance.getName());
            System.out.println("Sigorta Fiyatı: " + insurance.getPrice());
            System.out.println("Sigorta Başlama Tarihi: " + insurance.getStartDate());
            System.out.println("Sigorta Bitiş Tarihi: " + insurance.getEndDate());
            System.out.println("Hesaplanan Tutar: " + insurance.calculate());
            System.out.println("-----------------------");
        }
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    @Override
    public int compareTo(Account other) {
        return user.getLastLoginDate().compareTo(other.getUser().getLastLoginDate());
    }
}