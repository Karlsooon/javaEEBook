<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page import="kz.bitlab.techorda.db.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </head>
    <body>
      <%@include file="navbar.jsp"%>

      <div class="container mt-5">
        <div class="row mt-3">
          <div class="col-12">
            <%
              ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
              if(news!=null){
                for(News n:news){


            %>
            <div>
              <h3><%=n.getTitle()%></h3>
              <p><%=n.getContent()%></p>

            </div>
            <%
                }
              }
            %>

          </div>
        </div>
      </div>

    </body>
</html>
