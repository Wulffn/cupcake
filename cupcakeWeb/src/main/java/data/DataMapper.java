package data;

import DTO.Item;
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
    private final String GET_ALL_ORDERS_FROM_USER = "";
    //  private final String GET_ALL_ORDERS = "";
    private final String GET_TOP_BY_ID = "";
    private final String GET_BOTTOM_BY_ID = "";
    private final String GET_ALL_TOPS = "";
    private final String GET_ALL_BOTTOMS = "";
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
    
    public void getAllOrdersFromUser(int userID) {
        return;
    }

    public void getAllOrders() {
    }
    
    public List<Item> getItemTops(String topping) {
        List<Item> toppingI = new ArrayList<>();
        return toppingI;
    }
    
    public List<Item> getItemBottoms(String bottom) throws Exception {
       Connection c = new DBConnector().getConnection();
       
       List<Item> Bottom = new ArrayList<>(); 
       return Bottom;
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