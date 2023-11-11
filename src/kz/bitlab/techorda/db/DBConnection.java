package kz.bitlab.techorda.db;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:8889/tech_orda_db","root","root");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Book> getBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "select bo.id, bo.name, bo.genre, bo.description, bo.price, bo.author_id, au.first_name, au.last_name, au.instagram " +
                    "from books as bo " +
                    "inner join authors au on bo.author_id = au.id "+
                    "order by bo.price desc");
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setName(resultSet.getString("name"));
                book.setId(resultSet.getInt("id"));
                book.setGenre(resultSet.getString("genre"));
                book.setDescription(resultSet.getString("description"));
                book.setPrice(resultSet.getDouble("price"));

                Author author = new Author();
                author.setId(resultSet.getInt("author_id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setInstagram(resultSet.getString("instagram"));

                book.setAuthor(author);


                books.add(book);


            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }
    public static void addBook(Book book){
        try {
            PreparedStatement statement = connection.prepareStatement(""+"insert into books (name, price, author_id, genre, description) "+"values (?, ?, ?, ?, ?)");

            statement.setString(1,book.getName());
            statement.setDouble(2,book.getPrice());
            statement.setInt(3,book.getAuthor().getId());
            statement.setString(4,book.getGenre());
            statement.setString(5,book.getDescription());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public static Book getBook(int id){
        Book book = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" + " select bo.id, bo.name, bo.genre, bo.description, bo.price, bo.author_id, au.first_name, au.last_name, au.instagram " +
                                       "from books as bo " +
                                        "inner join authors au on bo.author_id = au.id " +
                                      "where bo.id=?");
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();
            if(resultSet.next()){
                book = new Book();
                book.setName(resultSet.getString("name"));
                book.setId(resultSet.getInt("id"));
                book.setGenre(resultSet.getString("genre"));
                book.setDescription(resultSet.getString("description"));
                book.setPrice(resultSet.getDouble("price"));

                Author author = new Author();
                author.setId(resultSet.getInt("author_id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setInstagram(resultSet.getString("instagram"));

                book.setAuthor(author);


            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }
    public static Book updateBook(Book book){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "update books "+
                    "set  name = ?, "+
                    "price = ?, "+
                    "genre = ?, "+
                    "description = ?, "+
                    "author_id = ? "+
                    "where id = ?");
            statement.setString(1,book.getName());
            statement.setDouble(2,book.getPrice());
            statement.setString(3,book.getGenre());
            statement.setString(4,book.getDescription());
            statement.setInt(5,book.getAuthor().getId());
            statement.setInt(6,book.getId());
            statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }
    public static void deleteBook(int id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "delete from books where id=?");
            statement.setInt(1,id);


            statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Author> getAuthors(){
        ArrayList<Author> authors = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(""+"select * from authors order by first_name ASC;"
                    );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getInt("id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setInstagram(resultSet.getString("instagram"));

                authors.add(author);

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return authors;
    }
    public static Author getAuthor(int id){
        Author author = null;
        try{
            PreparedStatement statement = connection.prepareStatement(""+"select * from authors where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                author = new Author();
                author.setLastName(resultSet.getString("last_name"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setInstagram(resultSet.getString("instagram"));
                author.setId(resultSet.getInt("id"));


            }
            statement.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return author;
    }

    public static void addAuthor(Author author){
        try {
            PreparedStatement statement = connection.prepareStatement(""+"insert into authors (first_name, last_name, instagram) "+"values (?, ?, ?)");

            statement.setString(1,author.getFirstName());
            statement.setString(2,author.getLastName());
            statement.setString(3,author.getInstagram());


            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static User getUser(String email){
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement(""+"select * from users where email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));


            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public static void addNews(News news){
        try{
            PreparedStatement statement = connection.prepareStatement(""+"insert into news (title,content,post_date,user_id) values (?,?,NOW(),?)");
            statement.setString(1,news.getTitle() );
            statement.setString(2,news.getContent() );
            statement.setLong(3,news.getUser().getId() );

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<News> getNews(){
        ArrayList<News> news = new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement(""+"select n.id n.title, n.content, n.user_id, u.full_name, n.post_date from news n inner join users u on u.id=n.user_id order by n.post_date desc ");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                News n = new News();
                n.setId(resultSet.getLong("id"));
                n.setTitle(resultSet.getString("title"));
                n.setContent(resultSet.getString("content"));
                n.setPostDate(resultSet.getTimestamp("post_date"));

                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                n.setUser(user);

                news.add(n);
            }
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }
}
