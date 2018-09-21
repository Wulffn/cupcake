/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTO.User;
import model.UserDAO;

/**
 *
 * @author Mark
 */
public class Controller {

    public boolean checkPassword(String username, String password) {
        System.out.println(username + " " + password);
        User user = new UserDAO().getUser(username); //ret IUserDAO til lille "getUser"
        if (password == null || username.equals(password)) {
            return false;
        }
        return password.equals(user.getPassword());
    }

    public void addUser(String name, String userName, String password) {
        System.out.println("User: " + name + ", Username: " + userName + ", Pass: " + password);
        new UserDAO().addUser(new User(name, userName, password, 100));
    }

}
