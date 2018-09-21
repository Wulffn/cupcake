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
   private List<LineItem> cupcakes = new ArrayList(); 

    public List<LineItem> getCupcakes() {
        return cupcakes;
    }
   
    public void addCupcake(LineItem lineItem) {
        cupcakes.add(lineItem);
    }
    
}
