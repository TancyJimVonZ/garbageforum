<%--
  Created by IntelliJ IDEA.
  User: ex_fengjm3
  Date: 2020/3/3
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        p {
            font-size: 30px;
        }
    </style>
</head>

<body>
    <h1>AdduserForm</h1>
    <form action="${pageContext.request.contextPath}/user/adduser.do" method="post">
        <p >姓名：<input type=text  name="name"/></p>
        <p >用户名：<input  type=text name="username"/></p>
        <p >密码：<input  type=password name="password"/></p>

        <button type="submit">提交</button>
    </form>
</body>
</html>
