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
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>AJAX</title>
</head>
<body>
ajax



</body>
<script>

    $(function () {
        var person = {
            "name": "bob",
            "age": 11
        };

        $.ajax({
            url: "/handler",
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(person),
            success: function (data) {
                console.log(data);
            },
            error: function () {
                console.log('Error');
            }
        });


    });


</script>
</html>
