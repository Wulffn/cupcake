/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    public void addUser(User u) {
        Connection c = null;

        try {
            c = new DBConnector().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "Insert into `cupcake`(`iduser`,`userName`,`password`,`balance`) values (?,?,?,?)";
        PreparedStatement cupcakePstmt = null;
        try {
            cupcakePstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        int iduser = 0;
        try {
            cupcakePstmt.setInt(1, u.getId());
            cupcakePstmt.setString(2, u.getUsername());
            cupcakePstmt.setString(3, u.getPassword());
            cupcakePstmt.setDouble(4, u.getBalance());

            //To create a transaction we need to not have automatic commit after each statement.
            // conn.setAutoCommit(false);
            //int result = personPstmt.executeUpdate();
            cupcakePstmt.executeUpdate();
            /*
            rs = personPstmt.getGeneratedKeys();
            rs.next();
            personId = rs.getInt(1);
             */
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User getUser(String userName) {
        String sql = "select * from user where userName = ?;";
        int id = 0;
        String name = null;
        String password = null;
        double balance = 0;
        try {
            Connection c = new DBConnector().getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("iduser");
                name = rs.getString("userName");
                password = rs.getString("password");
                balance = rs.getDouble("balance");
            }

        } catch (Exception ex) {
            System.out.println("error");
        }
        return new User(id, name, password, balance);
    }
}
