public class Passenger extends User {

    private int age;
    private String gender;

    public Passenger(String name, String phone, int age, String gender) {
        super(name, phone);
        this.age = age;
        this.gender = gender;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Passenger");
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void displayDetails() {
        System.out.println("\n--- Passenger Details ---");
        System.out.println("Name   : " + name);
        System.out.println("Phone  : " + phone);
        System.out.println("Age    : " + age);
        System.out.println("Gender : " + gender);
    }
}