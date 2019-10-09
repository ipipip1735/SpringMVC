<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/29
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
</head>
<body>



<form method="POST" action="/uploadFile" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label>Select a file to upload</label></td>
            <td><input type="file" name="file"/></td>
<%--            <td><input type="file" name="file1"/></td>--%>
<%--            <td><input type="file" name="file2"/></td>--%>
<%--            <td><input type="file" name="file3"/></td>--%>
        </tr>
        <tr>
            <td><label>name</label></td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>


</body>
</html>
