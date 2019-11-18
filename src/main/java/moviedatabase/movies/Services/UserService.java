package moviedatabase.movies.Services;

import moviedatabase.movies.Models.User;

import java.util.List;

public interface UserService {

    void addNewUser(String firstName, String lastName, String userName, String passWord, boolean admin);
    List<User> getUserList();
    User checkLogin(String userName, String passWord);
    void editUser(User user, String firstName, String lastName, String userName, String passWord, boolean admin);
    void deleteUser(User user);
    User findById(int id);
}
