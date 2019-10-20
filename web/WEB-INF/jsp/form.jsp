<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/29
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Form</title>
</head>
<body>


<h2>${employee.name} - ${employee.id} - ${employee.sex}</h2>
Spring:bind <br/>
<spring:bind path="employee.name">
  status.toString : ${status.toString()} <br/>
  status.error : ${status.error} <br/>
  status.path : ${status.path} <br/>
  status.errorMessages : ${status.errorMessages[0]} <br/>
  status.value : ${status.value} <br/>
  status.valueType : ${status.valueType} <br/>
  status.actualValue : ${status.actualValue} <br/>
  status.displayValue : ${status.displayValue} <br/>
</spring:bind>
<br/>

<%--  使用标签库--%>
  <form:form method="POST" action="/addEmployee" modelAttribute="employee">
    <table>
      <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name"/><form:errors path="name"/></td>
      </tr>
      <tr>
        <td><form:label path="id">Id</form:label></td>
        <td><form:input path="id"/></td>
      </tr>
      <tr>
        <td><form:label path="sex">sex</form:label></td>
        <td><form:checkbox path="sex"/></td>
      </tr>
<%--      <tr>--%>
<%--        <td><form:label path="sex">interests</form:label></td>--%>
<%--        <td><form:checkboxes path="interests" items="${interestList}"/></td>--%>
<%--      </tr>--%>
      <tr>
        <td><input type="submit" value="Submit"/></td>
      </tr>
    </table>
  </form:form>


<%--  方法转换(Post转DELETE)--%>
<%--  <form:form method="delete">--%>
<%--    <p class="submit"><input type="submit" value="Delete Pet"/></p>--%>
<%--  </form:form>--%>



</body>
</html>
