/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import interfaces.IitemDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import data.DBConnector;
/**
 *
 * @author Christian
 */
public class ItemBottomandTop implements IitemDAO {

    @Override
    public List<Cupcake> ItemButton() {
        List<Cupcake> ItemBottom = new ArrayList();
        String sql = "SELECT `itemBottomName`,`priceBottom` FROM `itemBottom`";
        Connection c = null;
        Cupcake item = null;
        try {
            c = new DBConnector().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                ItemBottom.add(new Cupcake("", rs.getString("itemBottomName"), rs.getInt("priceBottom")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ItemBottom;
    }

    @Override
    public List<Cupcake> ItemTop() {
        List<Cupcake> ItemTop = new ArrayList();
        String sql = "SELECT `itemTopName`,`priceTop` FROM `itemTop`";
        Connection c = null;
        Cupcake item = null;
        try {
            c = new DBConnector().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                //item.setTopping(rs.getString("itemTopName"));
                ItemTop.add(new Cupcake(rs.getString("itemTopName"), "", rs.getInt("priceTop")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemBottomandTop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ItemTop;
    }

}
