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
    <title>CORS</title>
  </head>

  <script
          src="https://code.jquery.com/jquery-3.4.1.min.js"
          integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
          crossorigin="anonymous"></script>

  <body>

  <div id="ajax">XXX</div>


  <div>${res}</div>

  </body>

  <script>
    $("#ajax").on("click", function () {

      //方式一：同步
      // htmlobj=$.ajax({url:"/corsHandler",async:false});
      // $(this).html(htmlobj.responseText);

      //方式二：异步
      // $.ajax({
      //   url: "http://example.com/",
      //   // url: "/corsHandler",
      //     setHeader: {},
      //   success: function (data) {
      //     console.log(data);
      //     $("#ajax").html(data);
      //   },
      //   error: function () {
      //     console.log('Error');
      //   }
      // });

        var xhr = new XMLHttpRequest();
        var url = 'http://example.com/25';

        xhr.open('GET', url);
        xhr.onreadystatechange = function (ev) {
            console.log("[info]" + ev);
        };
        xhr.send();




    });
  </script>
</html>
