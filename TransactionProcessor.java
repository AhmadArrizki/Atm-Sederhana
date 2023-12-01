public class TransactionProcessor {
    @SuppressWarnings("unused")
    private ATMSystem atmSystem;

    public TransactionProcessor(ATMSystem atmSystem) {
        this.atmSystem = atmSystem;
    }

    public void processDeposit(Account account, double amount) {
        account.deposit(amount);
        Transaction transaction = new Transaction(amount, TransactionType.DEPOSIT);
        account.addTransaction(transaction);
        System.out.println("Deposit berhasil. Saldo Anda sekarang: $" + account.getBalance());
    }

    public boolean processWithdrawal(Account account, double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            Transaction transaction = new Transaction(amount, TransactionType.WITHDRAWAL);
            account.addTransaction(transaction);
            System.out.println("Penarikan berhasil. Saldo Anda sekarang: $" + account.getBalance());
        }
        return success;
    }

    public void processTransaction(Account account, Transaction transaction) {
        account.addTransaction(transaction);
        System.out.println("Transaksi berhasil. Saldo Anda sekarang: $" + account.getBalance());
    }
}
