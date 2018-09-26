package data;

import DTO.Cupcake;
import DTO.Order;
import DTO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import data.DBConnector;

public class DataMapper {

    /*
    Methods:
    getUsers;
    getUser(int userID);
    getOrderAndDetails(int userID);
    getAllOrdersFromUser(int userID);
    getAllOrders();
    getItemTops
    getItemBottoms
    getItemTopPrice
    getItemBottomPrice
    
    --------------
    addUser(User user);
    addOrder(Order order);
    
    
     */
    private final String GET_ALL_USERS = "";
    private final String GET_USER_BY_ID = "";
    private final String GET_ORDER_AND_DETAIL = "";
    private final String GET_ALL_ORDERS_FROM_USER = "SELECT `idorder` FROM `order` WHERE order.iduser = ?;";
    //  private final String GET_ALL_ORDERS = "";
    private final String GET_TOP_BY_ID = "SELECT `itemTopName`,`priceTop` FROM `itemTop` WHERE itemTop.iditemTop ? ?;";
    private final String GET_BOTTOM_BY_ID = "";
    private final String GET_ALL_TOPS = "SELECT `itemTopName`,`priceTop` FROM `itemTop`";
    private final String GET_ALL_BOTTOMS = "SELECT `itemBottomName`,`priceBottom` FROM `itemBottom`";
    private final String GET_TOP_PRICE = "";
    private final String GET_BOTTOM_PRICE = "";

    public List<String> getAllUsers() throws Exception {
        List<String> users = new ArrayList();
        try {
            Connection c = new DBConnector().getConnection();
            PreparedStatement pstmt = c.prepareStatement(GET_ALL_USERS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(rs.getString("userName"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public void getOrderAndDetails(int iduser) {

    }

    public List<Order> getAllOrdersFromUser(int userID) throws Exception {
        List<Order> orders = new ArrayList();
        Connection c = new DBConnector().getConnection();
        PreparedStatement stmt = c.prepareStatement(GET_ALL_ORDERS_FROM_USER);
        stmt.setInt(1, userID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next())
        {
            orders.add(new Order(rs.getInt(1)));
        }
        return orders;
    }

    public void getAllOrders() {
    }

    public List<Cupcake> getItemTops(String topping) throws Exception {
        List<Cupcake> toppingI = new ArrayList<>();
        Connection c = new DBConnector().getConnection();
        PreparedStatement stmt = c.prepareStatement("");
        ResultSet rs = stmt.executeQuery();
         
        return toppingI;
    }

    public List<Cupcake> getItemBottoms(String bottom) throws Exception {
        Connection c = new DBConnector().getConnection();
        List<Cupcake> Bottom = new ArrayList<>();
        return Bottom;
    }

    public List<Cupcake> getAllItemBottoms() throws Exception {
        Connection c = new DBConnector().getConnection();
        List<Cupcake> Bottom = new ArrayList<>();
        PreparedStatement stmt = c.prepareStatement(GET_ALL_BOTTOMS);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Bottom.add(new Cupcake("", rs.getString("itemBottomName"), rs.getInt("priceBottom")));
        }
        c.close();
        return Bottom;
    }

    public List<Cupcake> getAllItemTops() throws Exception {
        Connection c = new DBConnector().getConnection();
        List<Cupcake> Tops = new ArrayList<>();
        PreparedStatement stmt = c.prepareStatement(GET_ALL_TOPS);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Tops.add(new Cupcake("", rs.getString("itemTopName"), rs.getInt("priceTop")));
        }
        c.close();
        return Tops;
    }

    public int getItemTopPrice() {
        return 0;
    }

    public int getItemBottomPrice() {
        return 0;
    }

    public void addUser(User user) {
    }

    public void addOrder(Order order) {
    }
}
