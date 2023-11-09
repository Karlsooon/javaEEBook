package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.DBManager;
import kz.bitlab.techorda.db.User;

import java.io.IOException;

@WebServlet("/delete-book")
public class DeleteBookServlet extends HomeServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");

        if(user!=null) {
            int id = Integer.parseInt(request.getParameter("id"));
            DBConnection.deleteBook(id);
            response.sendRedirect("/");
        }else{
            response.sendRedirect("/login");
        }
    }
}
