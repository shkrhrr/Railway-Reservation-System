public abstract class User {
    protected String name;
    protected String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public abstract void displayRole();

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}