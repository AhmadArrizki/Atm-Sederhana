import java.util.ArrayList;
import java.util.List;

// Class untuk merepresentasikan riwayat transaksi
public class TransactionHistory {
    private List<Transaction> transactions;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void showTransactionHistory() {
        System.out.println("\nRiwayat Transaksi:");
        for (Transaction transaction : transactions) {
            System.out.println("Tanggal: " + transaction.getDate() +
                    ", Jumlah: $" + transaction.getAmount() +
                    ", Tipe: " + transaction.getType());
        }
    }
}
