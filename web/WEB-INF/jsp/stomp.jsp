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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/webstomp-client@1.2.6/dist/webstomp.min.js"></script>


</head>
<body>

</body>


<script>
    //使用WebStomp.js
    var client = webstomp.client("ws://192.168.0.126:8080/ep");
    var subscription;
    var n = 0;
    // client.connect({"heart-beat": [0,0]}, (frame) => {
    client.connect({login: "uuu", passcode: "ppp"}, (frame) => {
        console.log("~~connect~~");
        console.log(frame);


        // subscription = client.subscribe("/topic/something", (message) => {
        // subscription = client.subscribe("/user/ooo", (message) => {
        subscription = client.subscribe("/app/appUser", (message) => {
            console.log("~~subscribe~~");
            console.log(message);
        }, {});



        setTimeout(() => {
            // client.send("/app/appSendThree", body = 'ccc' + (n++), {});
            client.send("/app/appUser", body = 'ccc' + (n++), {});
        }, 3000);
    });


    client.onreceive = function (frame) {
        console.log("~~onreceive~~");
        console.log(frame);
    };


    // var number = setInterval(() => {
    //     console.log("subscription is " + subscription.id);
    //         client.send("/app/appSendThree", body = 'ccc' + (n++), {});
    //         // client.send("/app/appSendOne", body = 'ccc' + (n++), {});
    //         // client.send("/app/appSendTwo", body = 'ccc' + (n++), {});
    //         // client.send("/app/sub", body = 'ccc' + (n++), {});
    // }, 3000);


    // setTimeout(() => {
    //     clearInterval(number);
    //
    //     subscription.unsubscribe();
    //     client.disconnect(() => {
    //         console.log("~~disconnect~~");
    //         console.log("the client has closed!");
    //     }, {})
    //
    // }, 8000);


</script>



<script>
    //使用Stomp.js
    // var client = Stomp.client("ws://192.168.0.126:8080/ep");
    //
    // var subscription;
    // client.connect({}, (frame) => {
    //     console.log("~~connect~~");
    //     console.log(frame);
    //
    //     subscription = client.subscribe("/topic/something", (frame) => {
    //         console.log("~~subscribe~~");
    //         console.log(frame);
    //     });
    // });
    //
    //
    // var number = setInterval(() => {
    //     client.send("/topic/something", headers = {}, body = 'ccccc');
    // }, 3000);
    //
    //
    // setTimeout(() => {
    //     clearInterval(number);
    //     subscription.unsubscribe();
    //     client.disconnect(() => {
    //         console.log("the client has closed!");
    //     }, {})
    //
    // }, 7000);
</script>

</html>
