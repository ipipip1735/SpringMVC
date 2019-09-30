<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/29
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>Form</title>
  </head>
  <body>

  <h2>${employee.name} - ${employee.id}</h2>

  <form:form method="POST" action="/addEmployee" modelAttribute="employee" >
    <table>
      <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name"/></td>
      </tr>
      <tr>
        <td><form:label path="id">Id</form:label></td>
        <td><form:input path="id"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit"/></td>
      </tr>
    </table>
  </form:form>




  </body>
</html>
