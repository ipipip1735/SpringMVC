<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/29
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Advice</title>
  </head>

  <script
          src="https://code.jquery.com/jquery-3.4.1.min.js"
          integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
          crossorigin="anonymous"></script>

  <body>

  <div id="ajax">XXX</div>

  </body>

  <script>
    $("#ajax").on("click", function () {


      htmlobj=$.ajax({url:"/uri.jsp",async:false});
      $("this").html(htmlobj.responseText);


    });
  </script>
</html>
