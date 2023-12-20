<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24-11-2023
  Time: 03:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Register</title>

</head>
<body>
<center>
<h2>ADD EMPLOYEE DETAILS</h2>
<s:form action="registeruser.action" method="post">
    <s:textfield label="Full Name" name="uname" required="true"/>
    <s:textfield label="Email" name="uemail" required="true"/>
    <s:password label="Password" name="upass" required="true"/>
    <s:textfield label="Designation" name="udeg" required="true"/>
    <s:submit cssClass="button-register" align="center" value="Resgister" />
</s:form>
<s:if test="ctr>0">
    <span style="color: green;"><s:property value="msg" /></span>
</s:if>
<s:else>
    <span style="color: red;"><s:property value="msg" /></span>
</s:else>
</body>
</html>
