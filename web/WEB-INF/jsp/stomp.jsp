<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/2
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Websocket</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/webstomp-client@1.2.6/dist/webstomp.min.js"></script>

</head>
<body>
<div id="context"></div>
<button id="send">send</button>
<button id="close">close</button>


</body>


<script>


    var socket = new WebSocket("ws://192.168.0.126:8080/ep");

    var stompClient = Stomp.over(socket);


    console.log(stompClient);

    // stompClient.connect({}, function(e,f,g) {
    //
    //     console.log(e);
    //     console.log(f);
    //     console.log(g);
    // });


</script>

</html>
