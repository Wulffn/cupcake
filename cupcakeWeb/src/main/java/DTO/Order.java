/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Christian
 */
public class Order {
    private int Orderid;
    private double totalprice;
    private int iduser;

    public Order(int OrderID, double totalprice, int iduser) {
        this.Orderid = OrderID;
        this.totalprice = totalprice;
        this.iduser = iduser;
    }

    public int getOrderid() {
        return Orderid;
    }

    public void setOrderid(int Orderid) {
        this.Orderid = Orderid;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    
}
