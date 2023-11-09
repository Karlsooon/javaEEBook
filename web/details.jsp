<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page import="kz.bitlab.techorda.db.Author" %>
<%@ page import="java.util.ArrayList" %>
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
        <div class="row">
          <div class="col-6 mx-auto">
            <%
              Book book = (Book) request.getAttribute("kniga");
              if(book!=null){
            %>

              <div class="row">
                <div class="col-12">
                  <label>NAME: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" readonly value="<%=book.getName()%>">
                </div>
              </div>

              <div class="row mt-3">
                <div class="col-12">
                  <label>AUTHOR: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" readonly value="<%=book.getAuthor().getFirstName()+book.getAuthor().getLastName()%>">
                </div>
              </div>

              <div class="row mt-3">
                <div class="col-12">
                  <label>GENRE: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" readonly value="<%=book.getGenre()%>">

                </div>
              </div>

              <div class="row mt-3">
                <div class="col-12">
                  <label>PRICE: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" readonly value="<%=book.getPrice()%>">

                </div>
              </div>

            <div class="row mt-3">
              <div class="col-12">
                <label>DESCRIPTION: </label>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
                <textarea class="form-control" readonly rows="10"><%=book.getDescription()%></textarea>

              </div>
            </div>
            <div class="row mt-3">
              <div class="col-12">
                <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editBook">
                  Edit Book
                </button>

                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger btn-sm ms-2" data-bs-toggle="modal" data-bs-target="#deleteBook">
                  DELETE BOOOK
                </button>

                <!-- Modal -->

              </div>
            </div>
            <div class="modal fade" id="deleteBook" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <form action="/delete-book" method="post">
                    <input type="hidden" name="id" value="<%=book.getId()%>">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5">Confirm Delete</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <h5 class="text-center">Are you sure?</h5>

                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                    <button class="btn btn-danger">YES</button>
                  </div>
                  </form>
                </div>

              </div>
            </div>

                <!-- Modal -->
                <div class="modal fade" id="editBook" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                        <form action="/save-book" method="post">
                          <input type="hidden" name="book_id" value="<%=book.getId()%>">
                          <div class="row">
                            <div class="col-12">
                              <label>NAME: </label>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <div class="col-12">
                              <input type="text" class="form-control" name="book_name" value="<%=book.getName()%>">
                            </div>
                          </div>

                          <div class="row mt-3">
                            <div class="col-12">
                              <label>AUTHOR: </label>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <div class="col-12">
                              <select class="form-select" name="book_author">
                                <%
                                  ArrayList<Author> authors = (ArrayList<Author>) request.getAttribute("avtory");
                                  if(authors!=null){
                                    for(Author author:authors){



                                %>
                                <option <%=(author.getId()==book.getAuthor().getId()?"selected":"")%> value="<%=author.getId()%>"><%=author.getFirstName() +" "+ author.getLastName()%></option>
                                <%
                                    }
                                  }
                                %>
                              </select>                            </div>
                          </div>

                          <div class="row mt-3">
                            <div class="col-12">
                              <label>GENRE: </label>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <div class="col-12">
                              <select class="form-select" name="book_genre">
                                <option <%=(book.getGenre().equals("Fantasy")?"selected":"")%>>Fantasy</option>
                                <option <%=(book.getGenre().equals("Roman")?"selected":"")%>>Roman</option>
                                <option <%=(book.getGenre().equals("Biography")?"selected":"")%>>Biography</option>
                                <option <%=(book.getGenre().equals("Horror")?"selected":"")%>>Horror</option>
                                <option <%=(book.getGenre().equals("Comics")?"selected":"")%>>Comics</option>

                              </select>
                            </div>
                          </div>

                          <div class="row mt-3">
                            <div class="col-12">
                              <label>PRICE: </label>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <div class="col-12">
                              <select class="form-select" name="book_price">
                                <%
                                  for (int i = 0; i < 100000; i+=100) {


                                %>
                                <option <%=(i==book.getPrice()?"selected":"")%>><%=i%></option>
                                <%
                                  }

                                %>
                              </select>
                            </div>
                          </div>

                          <div class="row mt-3">
                            <div class="col-12">
                              <label>DESCRIPTION: </label>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <div class="col-12">
                              <textarea class="form-control" type="text" name="book_description" rows="10"><%=book.getDescription()%></textarea>
                            </div>
                          </div>

                          <div class="row mt-3">
                            <div class="col-12">
                              <button class="btn btn-primary">SAVE BOOK</button>
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

              </div>
            </div>


            <%
              }else{
            %>
                 <h3 class="text-center">BOOK NOT FOUND</h3>
            <%
              }
            %>



          </div>

        </div>
      </div>

    </body>
</html>
