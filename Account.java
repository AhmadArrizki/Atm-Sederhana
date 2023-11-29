import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private Card card;
    private List<Transaction> transactions;
    private UserType userType;
    private int attemptsRemaining;
    private static final int MAX_ATTEMPTS = 3;

    public Account(String accountNumber, String pin, UserType userType) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
        this.card = null;
        this.transactions = new ArrayList<>();
        this.userType = userType;
        this.attemptsRemaining = MAX_ATTEMPTS;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction(new Transaction(amount, TransactionType.DEPOSIT));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction(new Transaction(amount, TransactionType.WITHDRAWAL));
            return true;
        } else {
            System.out.println("Saldo tidak mencukupi.");
            return false;
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public UserType getUserType() {
        return userType;
    }

    public int getAttemptsRemaining() {
        return attemptsRemaining;
    }

    public void decreaseAttempts() {
        attemptsRemaining--;
    }

    public void resetAttempts() {
        attemptsRemaining = MAX_ATTEMPTS;
    }
}
