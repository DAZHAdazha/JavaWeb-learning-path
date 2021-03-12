<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el 获取域中数据</title>
</head>
<body>

<%
    //在域中存储数据
    request.setAttribute("name","dazha");
    session.setAttribute("age","21");
    session.setAttribute("name","aiya");
    pageContext.setAttribute("age","4");
%>

${ sessionScope.name }
${ sessionScope.age }
${ sessionScope.hahaha }
${ name }
${ age }

</body>
</html>
