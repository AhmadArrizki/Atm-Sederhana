public class Admin extends User {
    private ATMSystem atmSystem;

    public Admin(ATMSystem atmSystem) {
        super(UserType.ADMIN);
        this.atmSystem = atmSystem;
    }

    public void showAllCustomerInfo() {
        atmSystem.showAllCustomerInfo();
    }

    public void manageUsers() {
        System.out.println("Admin dapat mengelola pengguna lainnya.");
    }
}
