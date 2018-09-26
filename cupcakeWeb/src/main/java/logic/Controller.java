/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataMapper;



/**
 *
 * @author Mark
 */
public class Controller {

    public String getTop() throws Exception {
        String str = "";
        DataMapper DM = new DataMapper();
        for (int i = 0; i < DM.getAllItemTops().size(); i++) {
            str += "<option value=\"Item1\">" + DM.getAllItemTops().get(i).getTopping() + " " + DM.getAllItemTops().get(i).getToppingPrice() + "</option>";
        }
        return str;
    }

    public String getBottom() throws Exception {
        String str = "";
        DataMapper DM = new DataMapper();
        for (int i = 0; i < DM.getAllItemBottoms().size(); i++) {
            str += "<option value=\"Item1\">" + DM.getAllItemBottoms().get(i).getBottom() + " " + DM.getAllItemBottoms().get(i).getBottomPrice() + "</option>";
        }
        return str;
    }
}
