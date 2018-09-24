/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import DTO.User;
import interfaces.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mwn
 */
public class UserDAO implements IUserDAO {

    @Override
    public User getUser(String searchUserName) {
        String sql = "select * from user where userName = ?;";
        int id = 0;
        String name = null;
        String userName = null;
        String password = null;
        double balance = 0;
        try {
            Connection c = new DBConnector().getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, searchUserName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("iduser");
                name = rs.getString("personName");
                userName = rs.getString("userName");
                password = rs.getString("password");
                balance = rs.getDouble("balance");
            }
            
            c.close();
        } catch (Exception ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
       
        
        return new User(id, name, userName, password, balance);
    }

    @Override
    public void addUser(User u) {
        String sql = "insert into user(personName, userName, password, balance) values(?,?,?,?);";
        try {
            Connection c = new DBConnector().getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, u.getName());
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.setString(3, u.getPassword());
            preparedStatement.setDouble(4, u.getBalance());
            
            preparedStatement.executeUpdate();
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
