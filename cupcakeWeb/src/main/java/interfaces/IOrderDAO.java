/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DTO.Order;

/**
 *
 * @author mwn
 */
public interface IOrderDAO {
    public Order order(int id);
}
