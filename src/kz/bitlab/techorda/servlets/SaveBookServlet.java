package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.*;

import java.io.IOException;

@WebServlet("/save-book")
public class SaveBookServlet extends HomeServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");

        if(user!=null) {
            int id = Integer.parseInt(request.getParameter("book_id"));
            String name = request.getParameter("book_name");
            int authorId = Integer.parseInt(request.getParameter("book_author"));
            String genre = request.getParameter("book_genre");
            String price = request.getParameter("book_price");
            double bookPrice = Double.parseDouble(price);

            String description = request.getParameter("book_description");
            Author author = DBConnection.getAuthor(authorId);

            Book book = DBConnection.getBook(id);
            if (book != null && author != null) {
                book.setName(name);
                book.setGenre(genre);
                book.setDescription(description);
                book.setPrice(bookPrice);
                book.setAuthor(author);
                DBConnection.updateBook(book);

                response.sendRedirect("/details?book_id=" + id);
            } else {
                response.sendRedirect("/");

            }
        }else{
            response.sendRedirect("/login");
        }

    }
}
