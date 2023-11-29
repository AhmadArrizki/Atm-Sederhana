import java.util.ArrayList;
import java.util.List;

// Class untuk merepresentasikan bank
public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountByCard(String cardNumber) {
        for (Account account : accounts) {
            if (account.getCard().getCardNumber().equals(cardNumber)) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public void showAllCustomerInfo() {
        for (Account account : accounts) {
            System.out.println("Nomor Rekening: " + account.getAccountNumber() +
                    ", Saldo: $" + account.getBalance() +
                    ", Tipe Pengguna: " + account.getUserType());
        }
    }
}
