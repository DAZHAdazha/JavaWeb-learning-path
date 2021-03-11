<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    服务器开小差了...
</h1>
<%
    String message = exception.getMessage();
    out.print(message);
%>

</body>
</html>
