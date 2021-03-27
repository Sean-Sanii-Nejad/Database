public class User {
    private final String firstName;
    private final String secondName;
    private final String username;
    private final String password;

    public User(String firstName, String secondName, String username, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
