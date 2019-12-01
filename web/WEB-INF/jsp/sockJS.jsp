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
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
</head>
<body>
<div id="context"></div>
<button id="send">send</button>
<button id="close">close</button>


</body>


<script>
    //创建实例
    var sock = new SockJS('http://192.168.0.126:8080/skJS');
    // var sock = new SockJS('http://192.168.0.126:8080/skJS', null, {"server":"xxx"});
    // var sock = new SockJS('http://192.168.0.126:8080/skJS', null, {"server":"xxx", "sessionId":4});
    sock.onopen = function(event) {
        console.log('open');

        console.log("binaryType is " + sock.binaryType);
        console.log("bufferedAmount is " + sock.bufferedAmount);
        console.log("extensions is " + sock.extensions);
        console.log("protocol is " + sock.protocol);
        console.log("readyState is " + sock.readyState);
        console.log("url is " + sock.url);

    };

    sock.onmessage = function(messageEvent) {
        console.log("message", messageEvent.data);
    };

    sock.onerror = function(event) {
        console.log("error");
    };

    sock.onclose = function() {
        console.log("close");
    };




    $(function () {
        $("#send").on("click", function () {

            if (sock.readyState == SockJS.OPEN) {

                console.log("sending!");
                sock.send('test');
                // webSocket.send("ok");
                // sock.send("close");
            }
        });
        $("#close").on("click", function () {

            if (sock.readyState != SockJS.CONNECTING && SockJS.readyState == SockJS.OPEN) {
                console.log("closeing");
                sock.close(1000, "ttt");
            }
        });
    });

</script>

</html>
