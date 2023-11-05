<%@ page import="java.util.Scanner" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    </head>
    <body>
       <div class="container mt-3">
           <div class="row">
               <div class="col-3 mx-auto">
                   <%
                       for (int i = 0; i <= 10 ; i++) {


                   %>
                   <div class="card mb-3 " style="width: 18rem;">
                       <img src="https://picsum.photos/300/300" class="card-img-top" >
                       <div class="card-body">
                           <h5 class="card-title">Karakat Almasova</h5>
                           <a href="#" class="btn btn-primary">Text message</a>
                       </div>
                   </div>
                   <%
                       }
                   %>
               </div>
           </div>
       </div>
    </body>
</html>
