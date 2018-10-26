package presentation;

import DTO.Cupcake;
import DTO.LineItem;
import DTO.ShoppingCart;
import DTO.User;
import data.DataMapper;
import java.io.IOException;
import java.util.ArrayList;
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
 /*
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String productTop = request.getParameter("top");
        String productBottom = request.getParameter("bottom");

        newShoppingCart(request);

        addToShoppingCart(productBottom, productTop, request);
        if (request.getSession().getAttribute("currentUser") == null) {
            setCurrentUser(username, password, request, response);
        }
        /**
         * Ikke færdig - men giver en ide om hvor vi skal hen
         *
         * if(itemTop != null) { Cupcake cupcake = new Cupcake(itemTop,
         * itemBottom, 1.0); LineItem lineItem = new
         * LineItem(Integer.valueOf(quantity), 1, 1, cupcake); ShoppingCart
         * shoppingCart = new ShoppingCart(); }
         *
         * //aktuel ide men ved ikke hvordan jeg skulle få price- Christian if
         * (itemTop != null && itemBottom != null) { List<LineItem> list = new
         * ArrayList(); Cupcake cupcake = new Cupcake(itemTop, itemBottom,
         * Double.valueOf(quantity)); LineItem lineItem = new
         * LineItem(Integer.valueOf(quantity), cupcake); list.add(lineItem);
         * ShoppingCart shoppingCart = new ShoppingCart(list,
         * Integer.valueOf(quantity), Integer.valueOf(price)); }
         */
        try {
            String origin = request.getParameter("origin");
            if (origin != null) {
                switch (origin) {
                    case "login":
                        //String username = request.getParameter("username");
                        //String password = request.getParameter("password");
                        request.setAttribute("message", "not yet implemented");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        break;
                    case "registration":
                        request.setAttribute("message", "not yet implemented");
                        request.getRequestDispatcher("registration.jsp").forward(request, response);
                        break;
                    case "orders":
                        request.setAttribute("message", "not yet implemented");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        break;
                    case "products":
                        if (request.getSession().getAttribute("currentUser") == null) {
                            request.getRequestDispatcher("login.jsp").forward(request, response);
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
                        //skal ændres
                        double l_dprice = 0;
                        request.setAttribute("confirmationprice", l_dprice);
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

    private void addToShoppingCart(String productBottom, String productTop, HttpServletRequest request) throws NumberFormatException {
        if (productBottom != null && productTop != null) {
            int qty = Integer.valueOf(request.getParameter("quantity"));
            String[] arr = productBottom.split(",");
            String itemBottomName = arr[0];
            double itemBottomPrice = Double.valueOf(arr[1]);
            arr = productTop.split(",");
            String itemTopName = arr[0];
            double itemTopPrice = Double.valueOf(arr[1]);
            LineItem lt = new LineItem(qty, itemBottomPrice + itemTopPrice, new Cupcake(itemTopName, itemBottomName));
            ShoppingCart sc = (ShoppingCart) request.getSession().getAttribute("shoppingcart");
            sc.getLineitem().add(lt);
            request.getSession().setAttribute("shoppingcart", sc);
            System.out.println("LOOK HERE" + sc.getLineitem().get(0).getCupcake().getBottom().toString());
        }
    }

    private void newShoppingCart(HttpServletRequest request) {
        if (request.getSession().getAttribute("shoppingcart") == null) {
            request.getSession().setAttribute("shoppingcart", new ShoppingCart());
        }
    }

    private void setCurrentUser(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean isValid = false;
        if (username != null) {
            isValid = checkPassword(username, password);
            if (isValid) {
                /*TODO
                request instead of username/pw
                 */
                User u = new DataMapper().getUser(username);
                request.getSession().setAttribute("currentUser", u);
            }
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean checkPassword(String username, String password) {
        User user = new DataMapper().getUser(username);
        if (password == null || username.equals(password)) {
            return false;
        }
        return password.equals(user.getPassword());
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
