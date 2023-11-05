package kz.bitlab.techorda.db;


import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Book> books = new ArrayList();
    private static int id = 6;

    public DBManager() {
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static void addBook(Book book) {
        book.setId(id);
        books.add(book);
        ++id;
    }
    public static Book getBook(int id){
        return books.stream().filter(book -> book.getId()==id).findFirst().orElse(null);

    }
    public static void updateBook(Book kitap){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId()==kitap.getId()){
                books.set(i, kitap);
                break;
            }

        }


    }
    public static void deleteBook(int id){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId()==id){
                books.remove(i);
                break;
            }
        }
    }

    static {
        books.add(new Book(1, "Harry Potter and Philosophy stone", "Joane Rowling", "Fantasy", 6000.0,"Harry Potters survive after azkaban attack"));
        books.add(new Book(2, "Harry Potter and Azkaban Prison", "Joane Rowling", "Fantasy", 5000.0,"siruis black escaped from azkaban "));
        books.add(new Book(3, "Twilight", "Steffany Mayer", "Fantasy", 7000.0,"Bella noves to Alyaska from Aryzona to her dad"));
        books.add(new Book(4, "Abay Zholy", "Mukhtar Auezov", "Roman", 50000.0,"Abay biography"));
        books.add(new Book(5, "I am Zlatan", "Steffany Mayer", "Biography", 8000.0,"Story about zlatan childhood and AJAX"));
    }
}

