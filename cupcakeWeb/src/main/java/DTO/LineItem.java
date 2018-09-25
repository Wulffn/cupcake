/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Markj
 */
public class LineItem {
    private int quantity; 
    private int price; 
    private int invoiceid; 
    private Cupcake cupcake;  
    
    public LineItem(int quantity, int price, int invoiceid, Cupcake cupcake) {
        this.quantity = quantity;
        this.price = price;
        this.invoiceid = invoiceid;
        this.cupcake = cupcake;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price * quantity;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public void setCupcake(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

   
}
