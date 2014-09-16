package servlet;

import jpa.AdminEntity;
import jpa.DAO.AdminDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Override;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1l;


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String errorMsg = null;

        if ( email == null || email.equals("") ) {
            errorMsg = "User email can not be null or empty";
        }

        if ( password == null || password.equals("") ) {
            errorMsg = "Password can not be null or empty";
        }

        if ( errorMsg != null ) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println(" <font color=red>" + errorMsg + "</font>");
            dispatcher.include(request, response);
        } else {
            AdminEntity admin = AdminDAO.getInstance().getAdminById(1);
            System.out.println(admin);
            if ( admin == null ) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.html");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>No user fount with this email and password</font>");
                dispatcher.include(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                response.sendRedirect("home.jsp");
            }
        }
    }
}
