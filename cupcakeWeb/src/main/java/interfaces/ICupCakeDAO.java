/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DTO.ItemTop;
import DTO.ItemBottom;
import DTO.Item;

/**
 *
 * @author mwn
 */
public interface ICupCakeDAO {
    public Item GetItem(ItemTop IT, ItemBottom IB);
}