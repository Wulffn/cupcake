/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import DTO.User;
import model.UserDAO;

/**
 *
 * @author mwn
 */
public class UserController {

    private static User currentUser = null;
    

    public boolean checkPassword(String username, String password) {
        User user = new UserDAO().getUser(username);
        if (password == null || username.equals(password)) {
            return false;
        }
        return password.equals(user.getPassword());
    }

    public void addUser(String name, String userName, String password) {
        new UserDAO().addUser(new User(name, userName, password, 100));
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String username) {
        UserController.currentUser = new UserDAO().getUser(username);
    }

    public static void setUser(User currentUser) {
        UserController.currentUser = currentUser;
    }
    
    

}
