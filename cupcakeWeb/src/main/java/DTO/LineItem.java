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
    
    private int qty;
    private double price; 
    private Cupcake cupcake;  

    public LineItem(int qty, double price, Cupcake cupcake) {
        this.qty = qty;
        this.price = price * qty;
        this.cupcake = cupcake;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public void setCupcake(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
   
}
