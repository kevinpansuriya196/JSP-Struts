<%@ page import="org.apache.struts2.ServletActionContext" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24-11-2023
  Time: 03:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Update Details</title>
</head>
<body>
<center>
    <h2>update</h2>
    <form action=updatedetails method="post">
        <script></script>
        <pre>
<b>Name:         </b><input type="text" name="uname" value='<s:property value="uname" />' required="true">


<b>Email:        </b><input type="email" name="uemail" value='<s:property value="uemail" />' required="true">
		            <input type="hidden" name="uemailhidden" value='<s:property value="uemail"/>' required="true">

<b>Password:     </b><input type="password" name="upass" value='<s:property value="upass"/>' required="true">


<b>Designation:  </b><input type="text" name="udeg" value='<s:property value="udeg"/>' required="true">
             <%
                 HttpServletRequest request1 = ServletActionContext.getRequest();
                 String password1 = (String) request1.getAttribute("exceptionMsg");
                 if (password1 != null) {
             %>
    <p>  Email already exists ... </p>
        <%
            }
        %>
		<button name="submitType" value="update" type="submit">Update</button>
		</pre>
    </form>




    <%--
        <s:if test="check == 3">
        <p> some  error accord</p>
        </s:if>
          <s:if test="check = 3">
              <s:property value="msg"/>
          </s:if>
        <s:if test="ctr!>0">
            <s:actionmessage/>
        </s:if>
    --%>

</body>
</html>