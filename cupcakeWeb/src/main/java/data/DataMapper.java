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
import model.DBConnector;

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
            return order;
    }
    
    public void getAllOrdersFromUser(int userID) {
        return;
    }

    public void getAllOrders() {
    }
    
    public List<topping> getItemTops(String topping) {
        List<topping> topping = new ArrayList<>();
        
    }
    
    public List<bottom> getItemBottoms(String bottom) throws Exception {
       Connection c = new DBConnector().getConnection();
       
       List<bottom> Bottom = new ArrayList<>(); 
       
    }
    
    public int getItemTopPrice() {
        return price;
    } 

    public int getItemBottomPrice() {
        return price;
    }
    
    public void addUser(User user) {
    }
    
    public void addOrder(Order order) {
    }
}