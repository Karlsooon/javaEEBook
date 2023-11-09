package kz.bitlab.techorda.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Author;
import kz.bitlab.techorda.db.Book;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.User;

import java.io.IOException;

@WebServlet("/add-author")
public class AddAuthorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            String name = request.getParameter("first_name");
            String surname = request.getParameter("last_name");
            String instagram = request.getParameter("instagram");

            Author author = new Author();
            author.setFirstName(name);
            author.setLastName(surname);
            author.setInstagram(instagram);
            DBConnection.addAuthor(author);


            response.sendRedirect("/authors");
        }else{
            response.sendRedirect("/login");
        }
    }
}

