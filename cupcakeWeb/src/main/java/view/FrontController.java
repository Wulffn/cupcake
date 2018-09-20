package view;

import controller.Controller;
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
@WebServlet(name = "FrontController", urlPatterns = {"/*"})
public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Controller c = new Controller();
        boolean isValid = false;
        RequestDispatcher dispatcher = null;

        if (request.getParameter("username") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("From request parameters: " + username + password);
            isValid = c.checkPassword(username, password);
        }

        String path = request.getPathInfo();

        switch (path.substring(1)) {
            case "registration":
                request.getSession().setAttribute("login", request.getParameter("login"));
                request.getSession().setAttribute("username", request.getParameter("username"));
                request.getSession().setAttribute("password", request.getParameter("password"));
                dispatcher = this.getServletContext().getRequestDispatcher("/RegistrationServlet");
                dispatcher.forward(request, response);
                break;
            case "orders":
                dispatcher = this.getServletContext().getRequestDispatcher("/OrderServlet");
                dispatcher.forward(request, response);
                break;
            case "shop":

                if (isValid) {
                    dispatcher = this.getServletContext().getRequestDispatcher("/ShopServlet");
                    dispatcher.forward(request, response);
                } else {
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("   <head>");
                        out.println("       <title> en title </title>");
                        out.println("   </head>");
                        out.println("   <body>");
                        out.println("       <h1> fejlede IsValid check i shop</h1>");
                        out.println("   </body>");
                        out.println("</html>");

                    }

                }
                break;
            default:
                throw new AssertionError();
//                try (PrintWriter out = response.getWriter()) {
//
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("   <head>");
//                    out.println("       <title> en title </title>");
//                    out.println("   </head>");
//                    out.println("   <body>");
//                    out.println("       <form action=\"/cupcakeWeb/registration/\">");
//                    out.println("           <input type=\"submit\">");
//                    out.println("       </form>");
//                    out.println("       <h1>Servlet </h1>");
//                    out.println("   </body>");
//                    out.println("</html>");
//
//                }
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
