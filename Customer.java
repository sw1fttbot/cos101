public class Customer {

    private String name;
    private String surname;
    private String email;
    private int number;
    private String password;

    // constructor
    public Customer(String name, String surname, String email, int number, String password) {
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
        this.setNumber(number);
        this.setPassword(password);
    }

    // getters
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public int getNumber() {
        return number;
    }
    public String getPassword() {
        return password;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
