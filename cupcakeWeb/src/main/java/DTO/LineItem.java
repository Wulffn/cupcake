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
    private int price; 
    private Cupcake cupcake;  

    public LineItem(int price, Cupcake cupcake) {
        this.price = price;
        this.cupcake = cupcake;
    }

    public int getPrice() {
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
    
    
   
}
