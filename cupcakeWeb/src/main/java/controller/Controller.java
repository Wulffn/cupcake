/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTO.ItemBottomandTop;
import DTO.User;
import java.util.List;
import model.UserDAO;

/**
 *
 * @author Mark
 */
public class Controller {
    public String getTop()
    {
        String str = null;
        ItemBottomandTop ibt = new ItemBottomandTop();
        //List l_lList = ibt.ItemTop();
        for (int i = 0; i < ibt.ItemTop().size(); i++)
        {
            System.out.println("INSIDE LOOP");
            str += "<option value=\"Item1\">" + ibt.ItemTop().get(i).getTopping() + "</option>";
        }
        return str;
    }
}
