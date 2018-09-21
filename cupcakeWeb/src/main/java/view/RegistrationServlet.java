package view;

import DTO.User;
import controller.Controller;
import controller.UserController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
    
    private String path = "registration?login";

    private String loginHtml() {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Login</title>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div align=\"center\">\n"
                + "        <h1>Login</h1>\n"
                + "        <form action=" + path +" method=\"post\"> \n"
                + "            Username:<br>\n"
                + "            <input type=\"text\" name=\"username\" value=\"\">\n"
                + "            <br>\n"
                + "            Password:<br>\n"
                + "            <input type=\"text\" name=\"password\" value=\"\">\n"
                + "            <br><br>\n"
                + "            <input type=\"submit\" value=\"Submit\">\n"
                + "        </form>\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>\n"
                + "";
    }

    private String regHtml() {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Registration</title>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div align=\"center\">\n"
                + "        <h1>Registration</h1>\n"
                + "        <form action=\"registration?login\" method=\"post\"> \n"
                + "            Name:<br>\n"
                + "            <input type=\"text\" name=\"name\" value=\"\">\n"
                + "            <br>\n"
                + "            Username:<br>\n"
                + "            <input type=\"text\" name=\"username\" value=\"\">\n"
                + "            <br>\n"
                + "            Password:<br>\n"
                + "            <input type=\"text\" name=\"password\" value=\"\">\n"
                + "            <br><br>\n"
                + "            <input type=\"submit\" value=\"Submit\">\n"
                + "        </form> \n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>\n"
                + "";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UserController uc = new UserController();
        RequestDispatcher dispatcher = null;

        String username = null;
        String password = null;

        boolean isValid = false;

        //Checks if request contains a parameter named "username" and authenticate the username and password if it does
        if (request.getParameter("username") != null) {
            username = request.getParameter("username");
            password = request.getParameter("password");
            isValid = uc.checkPassword(username, password);
        }

        //If isValid is changed to true, the response redirects to the shop. Sets current user to user
        if (isValid) {
            this.path = "/shop";
            uc.setCurrentUser(request.getParameter("username"));
            response.sendRedirect("shop");
        }

        //Checks if request contains a parameter named "name" and adds a new user to the database
        if (request.getParameter("name") != null) {
            uc.addUser(request.getParameter("name"), request.getParameter("username"), request.getParameter("password"));
        }

        //Checks if request contains a parameter named "login", if false, registration html is printed. Else, login html is printed
        if (request.getParameter("login") == null) {
            try (PrintWriter out = response.getWriter()) {
                out.println(regHtml());
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println(loginHtml());
            }
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
     */
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
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
