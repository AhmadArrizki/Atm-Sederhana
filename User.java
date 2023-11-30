public class User {
    protected UserType userType;

    public User(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void greet() {
        System.out.println("Selamat datang, pengguna tipe: " + userType);
    }

    public void displayUserType() {
        System.out.println("Tipe Pengguna: " + userType);
    }
}
