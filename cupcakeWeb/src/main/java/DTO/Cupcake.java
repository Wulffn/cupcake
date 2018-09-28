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
public class Cupcake {
    private String topping;
    private String bottom; 
    private double bottomPrice;
    private double toppingPrice;

    public Cupcake(String topping, String bottom) {
        this.topping = topping;
        this.bottom = bottom;
    }
    
    
    public Cupcake(String topping, String bottom, double price) {
        this.topping = topping;
        this.bottom = bottom;
        this.bottomPrice = price;
        this.toppingPrice = price;
    }

    public String getTopping() {
        return topping;
    }

    public String getBottom() {
        return bottom;
    }

    public double getBottomPrice() {
        return bottomPrice;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setBottomPrice(double bottomPrice) {
        this.bottomPrice = bottomPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }
}
