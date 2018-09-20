/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DTO.User;

/**
 *
 * @author mwn
 */
public interface IUserDAO {
    public void addUser(User u);
    public User getUser(String Username);
    
}
