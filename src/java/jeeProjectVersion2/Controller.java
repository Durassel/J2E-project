package jeeProjectVersion2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrateur
 */
public class Controller extends HttpServlet {
    private final static String MESSAGE = "Invalid credentials. Please try again.";
    private User userDB = null; 
    private DBTransac dbtransac = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            ServletContext sc = getServletContext();  
            String login = sc.getInitParameter("adminLogin");  
            String pwd = sc.getInitParameter("adminPassword");

            userDB = new User();
            userDB.setLogin(login);
            userDB.setPassword(pwd);
            User userForm = new User();
            userForm.setLogin(request.getParameter("login"));
            userForm.setPassword(request.getParameter("password"));
             
            HttpSession session = request.getSession();
             
            dbtransac = new DBTransac();
            
            // Compare user form to admin logins (from the context)
            if (request.getParameter("signIn") != null && userDB.getLogin().equals(userForm.getLogin()) && userDB.getPassword().equals(userForm.getPassword())) {
                session.setAttribute("connected", userForm.getLogin());
                request.getRequestDispatcher("/WEB-INF/members.jsp").forward(request, response);
            }
             
            if (request.getParameter("submit") != null) {
                String submit = request.getParameter("submit");
                if (request.getParameter("selectMember") == null) {
                    request.getRequestDispatcher("/WEB-INF/members.jsp").forward(request, response);
                }

                if (submit.equals("details")) {
                    request.getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);
                } else if (submit.equals("delete")) {
                    String tmp = request.getParameter("selectMember");
                    int id = Integer.parseInt(tmp);
                    dbtransac.delMember(id);
                    request.getRequestDispatcher("/WEB-INF/members.jsp").forward(request, response);
                } else if (submit.equals("add")) {
                    request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
                }
            } else if (request.getParameter("details") != null) {
                String submit = request.getParameter("details");
                if(submit.equals("Cancel")) {
                     request.getRequestDispatcher("/WEB-INF/members.jsp").forward(request, response);
                } else if (submit.equals("Save")) {
                    if (submit.equals("Save")) {
                        String idS=request.getParameter("id");
                        int id= Integer.parseInt(idS);
                        dbtransac.changeMember(new Member(id,request.getParameter("firstname"),
                            request.getParameter("lastname"),request.getParameter("homeNumber")
                            ,request.getParameter("mobileNumber"),request.getParameter("workNumber"),request.getParameter("address")
                            ,Integer.parseInt(request.getParameter("postalCode")),request.getParameter("city"),request.getParameter("email")));
                    }
                   request.getRequestDispatcher("/WEB-INF/members.jsp").forward(request, response);
                }
            } else if(request.getParameter("add") != null) {
                String submit = request.getParameter("add");
                if (submit.equals("Add")) {
                    dbtransac.addMember(new Member(0,request.getParameter("firstname"),
                        request.getParameter("lastname"),request.getParameter("homeNumber")
                        ,request.getParameter("mobileNumber"),request.getParameter("workNumber"),request.getParameter("address")
                        ,Integer.parseInt(request.getParameter("postalCode")),request.getParameter("city"),request.getParameter("email")));
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }
            } else {
                if(request.getParameter("signIn")!=null) { //|| !request.getParameter("Submit").equals(""))
                    session.setAttribute("error", MESSAGE);
                }
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
      try {
          processRequest(request, response);
      } catch (SQLException ex) {
          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
      }
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
      try {
          processRequest(request, response);
      } catch (SQLException ex) {
          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
      }
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
