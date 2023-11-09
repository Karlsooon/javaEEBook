package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Author;
import kz.bitlab.techorda.db.DBConnection;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/add-book-page")
public class AddBookPageServlet extends HomeServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Author> authors = DBConnection.getAuthors();
        request.setAttribute("avtory", authors);
        request.getRequestDispatcher("/addbook.jsp").forward(request,response);
    }
}
