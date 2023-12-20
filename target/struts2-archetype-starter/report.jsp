<%@ page import="org.apache.struts2.ServletActionContext" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24-11-2023
  Time: 03:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sh" uri="/struts-tags" %>


<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Report</title>
    <style>
        table, td, th {
            border: 1px solid black;
        }

        table {
            border-collapse: collapse;
            width: 60%;
        }

        th {
            height: 30px;
        }

        .button-update {
            background-color: #008CBA;
            color: white;
        }

        .button-delete {
            background-color: red;
            color: white;
        }
    </style>
</head>
<body>
<center>
    <h2>LIST DATA</h2>
    <div style="margin-top: 40px;">
        <s:if test="noData==true">
            <table>
                <thead>
                <tr style="background-color: #F0F2E9;">
                    <th>Sr.No.</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Designation</th>
                    <th>Action</th>
                </tr>
                </thead>
                <s:iterator value="beanList">
                    <tr>
                        <td><s:property value="srNo"/></td>
                        <td><s:property value="uname"/></td>
                        <td><s:property value="uemail"/></td>
                        <td><s:property value="upass"/></td>
                        <td><s:property value="udeg"/></td>
                        <td>

                            <a
                                    href="updatedetails.action?submitType=updatedata&uemail=<s:property value="uemail"/>">
                                <button class="button-update">Update</button>
                            </a>
                            <a afterclick onclick="return confirm('Are you sure you want to delete?')"
                               href="deleterecord.action?uemail=<s:property value="uemail"/>">
                                <button class="button-delete">Delete</button>

                            </a>
                        </td>
                    </tr>
                </s:iterator>
            </table>

        </s:if>
        <span><s:property value="msg"/></span>
        <s:else>
            <div>No Data Found.</div>
        </s:else>


        <%-- <%
             HttpServletRequest request1 = ServletActionContext.getRequest();
             Object password1 = request1.getAttribute("delete");
             if (password1 != null){
         %>
         <p > Record has been deleted </p>
         <% } else { %>
         <p>    </p>
         <% } %>
         <%
             Object password2 = request1.getAttribute("updateMsg");
 //            String message = request1.getAttribute("updateMsg").toString();

             if (password2 != null){
         %>
         <p> Record has been updated </p>

         <% } else { %>
         <p>    </p>
         <% } %>--%>
        <%--         =================================================  --%>


        <%
            HttpServletRequest request1 = ServletActionContext.getRequest();

            String password1 = (String) request1.getAttribute("delete");
            String password2 = (String) request1.getAttribute("updateMsg");

            if (password1 != null && !password1.isEmpty()) {
        %>
        <p> <%= password1 %></p>
        <%
            }
            if (password2 != null && !password2.isEmpty()) {
        %>
        <p> <%= password2 %></p>
        <%
            }
        %>

        <%--  =========================================================  --%>
        <%--        <s:if test="check = true">--%>
        <%--            <span style="color: green;"><s:property value="delete"/></span>--%>
        <%--        </s:if>--%>
        <%--        <s:else>--%>
        <%--            <span style="color: red;"><s:property value="delete"/></span>--%>
        <%--        </s:else>--%>
    </div>
    <br>

    <a href="register.jsp">
        <button type="button">ADD NEW USER</button>
    </a>
</center>

</body>
</html>