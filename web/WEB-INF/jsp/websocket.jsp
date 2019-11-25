<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/25
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Websocket</title>
  </head>
  <body>

  <button id="go">go</button>



  </body>




  <script>
    var webSocket = new WebSocket("wss://www.example.com/");

    webSocket.addEventListener("open", function (e) {
      console.log("~~open~~");
      console.log(e);
    });

    webSocket.addEventListener("message", function (e) {
      console.log("~~message~~");
      console.log(e);
    });

    webSocket.addEventListener("close", function (e) {
      console.log("~~close~~");
      console.log(e);
    });

    webSocket.addEventListener("error", function (e) {
      console.log("~~error~~");
      console.log(e);
    });


    $(function () {
      $("#go").on("click", function () {

        // webSocket.send("ok");
      })
    });

  </script>

</html>
