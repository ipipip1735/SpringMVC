<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/29
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
  <head>
    <title>Message</title>
  </head>
  <body>
  ${msg} <br/>
  <spring:message code="msg" arguments="one" />

  </body>
</html>
