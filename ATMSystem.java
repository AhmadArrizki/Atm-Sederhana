import java.util.List;
import java.util.Scanner;

public class ATMSystem {
    private Bank bank;
    private Card currentCard;
    private Account currentAccount;
    private Scanner scanner;

    public ATMSystem(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public Bank getBank() {
        return bank;
    }
    
    public void insertCard(Card card) {
        this.currentCard = card;
        System.out.println("Kartu dimasukkan. Silakan masukkan PIN Anda.");
        String pin = scanner.nextLine();
        startSession(pin);
    }

    public void ejectCard() {
        this.currentCard = null;
        this.currentAccount = null;
        System.out.println("Kartu dikeluarkan. Terima kasih!");
    }

    public void startSession(String pin) {
        String cardNumber = currentCard.getCardNumber();
        currentAccount = bank.getAccountByCard(cardNumber);

        if (currentAccount != null && currentAccount.validatePin(pin)) {
            showMainMenu();
        } else {
            System.out.println("Nomor kartu atau pin salah. Silakan coba lagi.");
            ejectCard();
        }
    }

    public void endSession() {
        currentAccount = null;
        System.out.println("Terima kasih! Sampai jumpa.");
    }

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Deposit");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Riwayat Transaksi");
            System.out.println("5. Keluar");
            if (currentAccount.getUserType() == UserType.ADMIN) {
                System.out.println("6. Lihat Info Nasabah (Admin Only)");
            }
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    endSession();
                    break;
                case 6:
                    if (currentAccount.getUserType() == UserType.ADMIN) {
                        showAllCustomerInfo();
                    } else {
                        System.out.println("Anda tidak memiliki akses.");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 5);
    }

    public void checkBalance() {
        System.out.println("Saldo Anda: $" + currentAccount.getBalance());
    }

    public void deposit() {
        System.out.print("Masukkan jumlah yang akan dideposit: $");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
        System.out.println("Deposit berhasil. Saldo Anda sekarang: $" + currentAccount.getBalance());
    }

    public void withdraw() {
        System.out.print("Masukkan jumlah yang akan ditarik: $");
        double amount = scanner.nextDouble();
        if (currentAccount.withdraw(amount)) {
            System.out.println("Penarikan berhasil. Saldo Anda sekarang: $" + currentAccount.getBalance());
        }
    }

    public void showTransactionHistory() {
        List<Transaction> transactions = currentAccount.getTransactions();
        System.out.println("\nRiwayat Transaksi:");
        for (Transaction transaction : transactions) {
            System.out.println("Tanggal: " + transaction.getDate() +
                    ", Jumlah: $" + transaction.getAmount() +
                    ", Tipe: " + transaction.getType());
        }
    }

    public void showAllCustomerInfo() {
        bank.showAllCustomerInfo();
    }
}
