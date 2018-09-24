/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import DTO.ItemBottomandTop;
import DTO.User;
import java.util.List;
import data.UserDAO;

/**
 *
 * @author Mark
 */
public class Controller {

    public String getTop() {
        String str = "";
        ItemBottomandTop ibt = new ItemBottomandTop();
        for (int i = 0; i < ibt.ItemTop().size(); i++) {
            str += "<option value=\"Item1\">" + ibt.ItemTop().get(i).getTopping() + " " + ibt.ItemTop().get(i).getToppingPrice() + "</option>";
        }
        return str;
    }

    public String getBottom() {
        String str = "";
        ItemBottomandTop ibt = new ItemBottomandTop();
        for (int i = 0; i < ibt.ItemButton().size(); i++) {
            str += "<option value=\"Item1\">" + ibt.ItemButton().get(i).getBottom() + " " + ibt.ItemButton().get(i).getBottomPrice() + "</option>";
        }
        return str;
    }
}
