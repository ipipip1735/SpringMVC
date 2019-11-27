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
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
</head>
<body>

<button id="send">send</button>
<button id="close">close</button>


</body>


<script>
    var webSocket = new WebSocket("ws://192.168.0.126:8080/wss");
    // var webSocket = new WebSocket("ws://192.168.0.126:8080/wss", "soap");
    // var webSocket = new WebSocket("ws://192.168.0.126:8080/wss", ["soap", "wamp"]);

    webSocket.addEventListener("open", function (e) {
        console.log("~~open~~");
        console.log("binaryType is " + webSocket.binaryType);
        console.log("bufferedAmount is " + webSocket.bufferedAmount);
        console.log("extensions is " + webSocket.extensions);
        console.log("protocol is " + webSocket.protocol);
        console.log("readyState is " + webSocket.readyState);
        console.log("url is " + webSocket.url);


    });
    webSocket.addEventListener("message", function (e, f, g, h) {
        console.log("~~message~~");

    });
    webSocket.addEventListener("close", function (e) {
        console.log("~~close~~");

    });
    webSocket.addEventListener("error", function (e) {
        console.log("~~error~~");

    });
    $(function () {
        $("#send").on("click", function () {

            if (webSocket.readyState == webSocket.OPEN) {
                console.log("send ok!");
                webSocket.send("ok");
            }
        });
        $("#close").on("click", function () {

            if (webSocket.readyState != webSocket.CONNECTING && webSocket.readyState == webSocket.OPEN) {
                console.log("closeing");
                webSocket.close();
            }
        });



    });

</script>

</html>
