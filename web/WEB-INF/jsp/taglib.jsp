<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/29
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Taglib</title>
</head>
<body>

Spring:bind <br/>
<spring:bind path="employee.name">
  status.toString : ${status.toString()} <br/>
  status.error : ${status.error} <br/>
  status.path : ${status.path} <br/>


  <c:forEach items="${status.errorMessages}" var="error">
    Error code: <c:out value="${error}"/><br>
  </c:forEach>
  status.value : ${status.value} <br/>
  status.valueType : ${status.valueType} <br/>
  status.actualValue : ${status.actualValue} <br/>
  status.displayValue : ${status.displayValue} <br/>
</spring:bind>
<br/>

</body>
</html>
