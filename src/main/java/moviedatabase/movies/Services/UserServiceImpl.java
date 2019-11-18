package moviedatabase.movies.Services;

import moviedatabase.movies.Models.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private List<User> userList = new ArrayList<>();

    public UserServiceImpl() {
        generateUsers();
    }

    public void addNewUser(String firstName, String lastName, String userName, String passWord, boolean admin) {
        userList.add(new User(firstName, lastName, userName, passWord, admin));
    }

    public List<User> getUserList() {
        return userList;
    }

    public User checkLogin(String userName, String passWord) {
        for (User current: userList) {
            if (userName.equals(current.getUserName()) && passWord.equals(current.getPassWord())) {
                return current;
            }
        }
        return null;
    }

    public void editUser(User user, String firstName, String lastName, String userName, String passWord, boolean admin) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassWord(passWord);
        user.setAdmin(admin);
    }

    public void deleteUser(User user) {
        userList.remove(user);
    }

    public User findById(int id) {
        for (User current: userList) {
            if (current.getId() == id) {
                return current;
            }
        }
        return null;
    }

    private void generateUsers() {
        userList.add(new User("Martin", "Holmqvist", "Shawk", "1234", true));
        userList.add(new User("Preben", "Elkjær", "Prelk", "1234", false));
        userList.add(new User("Anders", "Mikkelsen", "Andemik", "1234", false));
        userList.add(new User("Søren", "Jensen", "Sørjen", "1234", true));
        userList.add(new User("Niels", "Thomsen", "Nithom", "1234", false));
    }
}
