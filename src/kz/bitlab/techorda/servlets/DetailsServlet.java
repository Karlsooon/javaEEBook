package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/details")
public class DetailsServlet extends HomeServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= -1;
        try {
             id = Integer.parseInt(request.getParameter("book_id"));
        }catch (Exception e){

        }
        Book book = DBConnection.getBook(id);

        request.setAttribute("kniga", book);

        ArrayList<Author> authors = DBConnection.getAuthors();
        request.setAttribute("avtory", authors);
        request.getRequestDispatcher("/details.jsp").forward(request,response);

    }
}
