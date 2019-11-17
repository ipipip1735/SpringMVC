<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/29
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
  <head>
    <title>URI</title>
  </head>
  <body>

  <h1>${uri}</h1>


  <%--由视图构建 URI--%>
<%--  <h1>${s:mvcUrl('UC#uriBuilder').arg(0, null).arg(1, 222).arg(2, null).buildAndExpand(111)}</h1>--%>
<%--  <h1>${s:mvcUrl('UC#uriBuilder').arg(0, null).arg(1, Integer.valueOf(11)).build()}</h1>--%>
<%--  <h1>${s:mvcUrl('UC#uriBuilder').buildAndExpand(111, 222)}</h1>--%>
<%--  <h1>${s:mvcUrl('UC#uriBuilder').arg(0, Integer.valueOf(222)).buildAndExpand(111)}</h1>--%>


  </body>
</html>
