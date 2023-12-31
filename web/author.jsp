<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page import="kz.bitlab.techorda.db.Author" %>
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
            <div class="row mt-3">
              <div class="col-12">
                <%
                  if(currentUser!=null){
                %>
                <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#addAuthor">
                  + Add Author

                </button>

                <!-- Modal -->
                <div class="modal fade" id="addAuthor" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Add Book</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                        <%@ page import="kz.bitlab.techorda.db.Author" %>
                        <form action="/add-author" method="post">
                          <div class="row">
                            <div class="col-12">
                              <label>FIRST_NAME: </label>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <div class="col-12">
                              <input type="text" class="form-control" name="first_name">
                            </div>
                          </div>

                          <div class="row mt-3">
                            <div class="col-12">
                              <label>LAST_NAME: </label>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <div class="col-12">
                              <input type="text" class="form-control" name="last_name">
                            </div>
                          </div>

                          <div class="row mt-3">
                            <div class="col-12">
                              <label>INSTAGRAM: </label>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <div class="col-12">
                              <input type="text" class="form-control" name="instagram">
                            </div>
                          </div>
                          <div class="row mt-3">
                            <div class="col-12">
                              <button class="btn btn-success">ADD AUTHOR</button>
                            </div>
                          </div>


                        </form>

                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                      </div>
                    </div>
                  </div>
                </div>
                <%
                  }
                %>

              </div>

          </div>

        </div>
        <div class="row mt-3">
          <div class="col-12">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>FIRST_NAME</th>
                  <th>LAST_NAME</th>
                  <th>INSTAGRAM</th>

                </tr>
              </thead>
              <tbody>
                <%
                  ArrayList<Author> authors = (ArrayList<Author>) request.getAttribute("avtory");

                  if(authors!=null){
                    for(Author author:authors){
                %>

                <tr>
                  <td><%=author.getId()%></td>
                  <td><%=author.getFirstName()%></td>
                  <td><%=author.getLastName()%></td>
                  <td><%=author.getInstagram()%></td>

                  <td>
                    <a class="btn btn-success btn-sm" href="/">DETAILS</a>
                  </td>
                </tr>

                <%
                    }
                  }
                %>
              </tbody>

            </table>

          </div>
        </div>
      </div>
      </div>

    </body>
</html>
