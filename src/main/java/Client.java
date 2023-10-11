import java.util.HashMap;
import java.util.Map;

public class Client {
    protected String name;
    protected String surname;
    protected String telephoneNumber;
    public Map<String, Integer> accounts = new HashMap<>();

    public Client(String name, String surname, String telephoneNumber) {
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
    }

    public void addAccount(Account account) {
        try {
            accounts.put(account.currency, account.money);
        } catch (NullPointerException e) {
            System.out.println("Account is null");
        };
    }
    public int sumOfAccountsOfOneUser() {
        int sum = 0;
        for (Map.Entry<String, Integer> item: accounts.entrySet()) {
            sum += item.getValue();
        }
        return sum;
    }
}
