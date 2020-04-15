<%--
  Created by IntelliJ IDEA.
  User: ex_fengjm3
  Date: 2020/3/9
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadtest</title>
</head>
<body>
<h3>传统文件上传</h3>

<form action="/forum-web/user/file.do" method="post" enctype="multipart/form-data">
<%--<form action="${pageContext.request.contextPath}/user/file.do" method="post" enctype="multipart/form-data">--%>
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传" />
</form>

<h3>Springmvc文件上传</h3>

<form action="/forum-web/user/fileupload2.do" method="post"  enctype="multipart/form-data">
<%--<form action="${pageContext.request.contextPath}/user/fileupload2.do" method="post" enctype="multipart/form-data" content="multipart/form-data">--%>
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>

<h3>跨服务器文件上传</h3>

<form action="/user/fileupload3" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
