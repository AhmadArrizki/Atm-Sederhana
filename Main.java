import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATMSystem atmSystem = new ATMSystem(bank);

        Account account1 = new Account("123456", "1234", UserType.USER);
        account1.deposit(1000.0);
        Card card1 = new Card("1111222233334444", "12/25", "123");
        account1.setCard(card1);

        Account account2 = new Account("789012", "5678", UserType.ADMIN);
        account2.deposit(500.0);
        Card card2 = new Card("5555666677778888", "06/23", "456");
        account2.setCard(card2);

        bank.addAccount(account1);
        bank.addAccount(account2);

        ATM atm = new ATM(atmSystem);

        System.out.println("Pilih akun:");
        System.out.println("1. Akun 1 (USER)");
        System.out.println("2. Akun 2 (ADMIN)");
        System.out.print("Masukkan pilihan Anda: ");

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.insertCard(card1); 
                    break;
                case 2:
                    atm.insertCard(card2); 
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
