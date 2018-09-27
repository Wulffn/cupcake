package presentation;

import DTO.Cupcake;
import DTO.User;
import data.DataMapper;
import logic.Controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark
 */
@WebServlet(name = "Controller", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /* SE PÅ URL PATTERN */

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String itemTop = request.getParameter("top");
        String itemBottom = request.getParameter("bottom");
        String quantity = request.getParameter("quantity");

        setCurrentUser(username, password, request, response);

        try {
            String origin = request.getParameter("origin");
            if (origin != null) {
                switch (origin) {
                    case "login":
                        request.setAttribute("message", "not yet implemented");
                        request.getRequestDispatcher("login.html").forward(request, response);
                        break;
                    case "registration":
                        request.setAttribute("message", "not yet implemented");
                        request.getRequestDispatcher("registration.jsp").forward(request, response);
                        break;
                    case "orders":
                        request.setAttribute("message", "not yet implemented");
                        request.getRequestDispatcher("login.html").forward(request, response);
                        break;
                    case "products":
                        if (request.getSession().getAttribute("currentUser") == null) {
                            request.getRequestDispatcher("login.html").forward(request, response);
                        } else {
                            DataMapper DM = new DataMapper();
                            List<Cupcake> listbottom = DM.getAllItemBottoms();
                            List<Cupcake> listtop = DM.getAllItemTops();
                            request.setAttribute("productlistsbottom", listbottom);
                            request.setAttribute("productliststop", listtop);
                            request.getRequestDispatcher("products.jsp").forward(request, response);
                        }
                        break;
                    case "confirmed":
                        double price = 0;
                        request.setAttribute("confirmationprice", price);
                        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
                        break;
                    // more cases 
                    default:
                        throw new AssertionError("Error");

                }
            }
        } catch (Exception e) {
        }
    }

    private void setCurrentUser(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean isValid = false;
        if (username != null) {
            isValid = new Controller().checkPassword(username, password);
            if (isValid) {
                User u = new DataMapper().getUser(username);
                request.getSession().setAttribute("currentUser", u);
            }
        } else {
            request.getRequestDispatcher("login.html").forward(request, response);
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
