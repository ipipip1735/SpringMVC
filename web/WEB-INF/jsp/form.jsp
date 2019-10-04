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


  <h2>${employee.name} - ${employee.id} - ${employee.sex}</h2>


<%--  使用标签库--%>
<%--  <form:form method="POST" action="/addEmployee" modelAttribute="employee">--%>
<%--    <table>--%>
<%--      <tr>--%>
<%--        <td><form:label path="name">Name</form:label></td>--%>
<%--        <td><form:input path="name"/><form:errors /></td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td><form:label path="id">Id</form:label></td>--%>
<%--        <td><form:input path="id"/></td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td><form:label path="sex">sex</form:label></td>--%>
<%--        <td><form:checkbox path="sex"/></td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td><form:label path="sex">interests</form:label></td>--%>
<%--        <td><form:checkboxes path="interests" items="${interestList}"/></td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td><input type="submit" value="Submit"/></td>--%>
<%--      </tr>--%>
<%--    </table>--%>
<%--  </form:form>--%>


<%--  方法转换--%>
<%--  <form:form method="delete">--%>
<%--    <p class="submit"><input type="submit" value="Delete Pet"/></p>--%>
<%--  </form:form>--%>




  </body>
</html>
