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
public class ShoppingCart {
    private int invoice_id;
    private List<LineItem> lineitem;
    private int Quantity;
    private double totalPrice;

    public ShoppingCart(List<LineItem> lineitem, int Quantity, double totalPrice) {
        this.lineitem = lineitem;
        this.Quantity = Quantity;
        this.totalPrice = totalPrice;
    }

    public ShoppingCart() {
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public List<LineItem> getLineitem() {
        return lineitem;
    }

    public void setLineitem(List<LineItem> lineitem) {
        this.lineitem = lineitem;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

   
    
}
