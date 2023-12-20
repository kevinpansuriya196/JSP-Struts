<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24-11-2023
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<s:actionmessage/>

<h2>delete</h2>
<span><s:property value="msg" /></span><br><br>
<a href="report">
    <button type="button">BACK TO LIST</button>
</a>
</body>
</html>