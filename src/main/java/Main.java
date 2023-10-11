public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Иван", "Петров", "+79875645581");
        Account acc1 = new Account("RU", 1500);
        client1.addAccount(acc1);
        Client client2 = new Client("Даша", "Сидорова", "+79999456781");
        Account acc2 = new Account("KZ", 200);
        client2.addAccount(acc2);
        Client client3 = new Client("Greg", "Gerteq", "9987560001");
        Account acc3 = new Account("EUR", 70);
        client3.addAccount(acc3);
        Bank bank = new Bank();
        bank.addUser(client1);
        bank.addUser(client3);
        System.out.println(bank.getPrivateData("9987560001"));
        Account acc = new Account("KZ", 150);
        client2.addAccount(acc);
        System.out.println(client2.sumOfAccountsOfOneUser());
        System.out.println(bank.getSumOfAllAccounts());
    }
}
