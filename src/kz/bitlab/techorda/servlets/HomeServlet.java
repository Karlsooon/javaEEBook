package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.techorda.db.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/home.html")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String text = (String) session.getAttribute("username");
        System.out.println(text);
        ArrayList<Book> books = DBConnection.getBooks();
        request.setAttribute("knigi", books);
        ArrayList<Author> authors = DBConnection.getAuthors();
        request.setAttribute("avtory", authors);
        request.getRequestDispatcher("/books.jsp").forward(request,response);


    }
}
