<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/26
  Time: 17:26
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
<div id="context"></div>
<button id="send">send</button>
<button id="close">close</button>


</body>


<script>
    //创建实例
    var webSocket = new WebSocket("ws://192.168.0.126:8080/wss");

    //方式一：使用监听器
    webSocket.addEventListener("open", function (event) {
        console.log("~~open~~");
        console.log(event);

        console.log("binaryType is " + webSocket.binaryType);
        console.log("bufferedAmount is " + webSocket.bufferedAmount);
        console.log("extensions is " + webSocket.extensions);
        console.log("protocol is " + webSocket.protocol);
        console.log("readyState is " + webSocket.readyState);
        console.log("url is " + webSocket.url);

    });
    webSocket.addEventListener("message", function (messageEvent) {
        console.log("~~message~~");
        console.log(messageEvent);

        console.log("data is " + messageEvent.data);
        console.log("origin is " + messageEvent.origin);
        console.log("lastEventId is " + messageEvent.lastEventId);
        console.log("source is " + messageEvent.source);
        console.log("ports is " + messageEvent.ports);
    });
    webSocket.addEventListener("close", function (closeEvent) {
        console.log("~~close~~");
        console.log(closeEvent);

        console.log("code is " + closeEvent.code);
        console.log("reason is " + closeEvent.reason);
        console.log("wasClean is " + closeEvent.wasClean);
    });
    webSocket.addEventListener("error", function (event) {
        console.log("~~error~~");
        console.log(event);
    });


    //方式二：使用周期函数




    $(function () {
        $("#send").on("click", function () {

            if (webSocket.readyState == webSocket.OPEN) {
                console.log("sending!");
                // webSocket.send("ok");
                webSocket.send("close");
            }
        });
        $("#close").on("click", function () {

            if (webSocket.readyState != webSocket.CONNECTING && webSocket.readyState == webSocket.OPEN) {
                console.log("closeing");
                webSocket.close(1000, "ttt");
            }
        });
    });

</script>

</html>
