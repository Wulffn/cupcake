/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package presentation;

import logic.Controller;
import logic.UserController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark
 
@WebServlet(name = "ShopServlet", urlPatterns = {"/ShopServlet"})
public class ShopServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UserController uc = new UserController();
        Controller c = new Controller();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "            <div align=\"right\">\n"
                    + "                <h5>Current User:</h5>\n"
                    + "                <p>Name: " + uc.getCurrentUser().getName() + "</p>\n"
                    + "                <p>Balance: " + uc.getCurrentUser().getBalance() + "</p>\n"
                    + "                <form action=\"registration?logout\" method=\"post\">\n"
                    + "                    <input type=\"submit\" value=\"Logout\"/>\n"
                    + "                </form>\n"
                    + "            </div>\n"
                    + "        <div>\n"
                    + "            <div align=\"center\">\n"
                    + "                <h4>Top</h4>\n"
                    + "                <select>\n"
                    + "                    <option value=\"Item1\">" + c.getTop() + "</option>\n"
                    + "                </select>\n"
                    + "            </div>\n"
                    + "            <div align=\"center\">\n"
                    + "                <h4>Bottom</h4>\n"
                    + "                <select>\n"
                    + "                    <option value=\"Item1\">" + c.getBottom() + "</option>\n"
                    + "                </select>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
*/