<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${ 3 > 4 }

    \${ 3 > 4 }

<hr>
    <h3>算数运算符</h3>
    ${ 3 + 4 }
    ${ 3 / 4 }
    ${ 3 div 4 }
    ${ 3 % 4 }
    ${ 3 mod 4 }

    <h3>比较运算符</h3>
    ${ 3 == 4 }

    <h3>逻辑运算符</h3>
    ${ 3 > 4 && 3 < 4 }
    ${ 3 > 4 and 3 < 4 }
<h4>
    empty运算符
</h4>
<%
    String str = "abc";
    String str1 = null;
    String str2 = "";
    request.setAttribute("str",str);
    request.setAttribute("str1",str1);
    request.setAttribute("str2",str2);
%>

${ empty str }
${ not empty str }
${ empty str1 }
${ empty str2 }

<%--获取request对象--%>
${ pageContext.request }
    <h4>在jsp中动态获取虚拟目录</h4>
${ pageContext.request.contextPath }
<%--因此表单可以这么动态写虚拟目录--%>
<form action="${ pageContext.request.contextPath }/xxxxServlet" method="post">
    xxx
</form>

</body>
</html>
