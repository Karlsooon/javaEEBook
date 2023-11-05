package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.*;

import java.io.IOException;

@WebServlet("/details")
public class DetailsServlet extends HomeServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= -1;
        try {
             id = Integer.parseInt(request.getParameter("book_id"));
        }catch (Exception e){

        }
        Book book = DBManager.getBook(id);

        request.setAttribute("kniga", book);
        request.getRequestDispatcher("/details.jsp").forward(request,response);

    }
}
