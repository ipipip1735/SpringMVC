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
    <title>Resources</title>
  </head>
  <body>

<%--方式一：使用标签库--%>
    <spring:url value="/resources/aa/bb/x.png"/> <br/>
    <spring:url value="/resources/x.png"/> <br/>

<%--方式二：使用Model变量--%>
<%--  ${urlDM5} <br/>--%>
<%--  ${urlVersion} <br/>--%>



<%--方式三：使用mvcResourceUrlProvider--%>
  ${mvcResourceUrlProvider.getForLookupPath("/resources/x.png")} <br/>
  ${mvcResourceUrlProvider.getForLookupPath("/resources/aa/bb/x.png")} <br/>


  </body>
</html>
