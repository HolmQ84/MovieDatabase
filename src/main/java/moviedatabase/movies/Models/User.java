package moviedatabase.movies.Models;

import java.util.Random;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean admin;

    public User(int id, String firstName, String lastName, String userName, String passWord, boolean admin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.admin = admin;
    }

    public User(String firstName, String lastName, String userName, String passWord, boolean admin) {
        Random random = new Random();
        this.id = random.nextInt(89999998)+10000001;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.admin = admin;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public String toString() {
        return id +" "+firstName+" "+lastName+" "+userName+" "+passWord+" "+admin;
    }
}
