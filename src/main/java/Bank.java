import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bank {
    List<Client> clients = new ArrayList<>();

    public List<String> getPrivateData(String telephoneNumber) {
        for (Client client : clients) {
            if (client.telephoneNumber == telephoneNumber) {
                return List.of(client.name, client.surname, telephoneNumber);
            }
        }
        return List.of("User is not found");
    }

    public void addUser(Client client) {
        clients.add(client);
    }

    public void removeUser(Client client) {
        clients.remove(client);
    }

    public int getSumOfAllAccounts() {
        int sum = 0;
        for (Client client : clients) {
            sum += client.sumOfAccountsOfOneUser();
        }
        return sum;
    }
}
