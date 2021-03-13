<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>

<%--
    c:if标签（该标签没有else）
    1.属性：
        test必须属性，接受Boolean表达式
            如果表达式为true,则显示标签体内容，false则不显示
            ！！！注意test=" xxx"不对！ 不能有空格！！！！
--%>

<c:if test="true">
    <h1>
        true
        </h1>
</c:if>
<c:if test="false">
    <h1>
        false
    </h1>
</c:if>

<%
    //判断request域中一个list集合是否为空,如果不为null则显示遍历集合
    List list = new ArrayList();
    list.add("aa");
    request.setAttribute("list",list);

    request.setAttribute("number",3);
%>

<c:if test="${ not empty list }">
    要遍历集合
</c:if>

<c:if test="${ number % 2 != 0 }">
    基数
</c:if>

<c:if test="${ number % 2 == 0 }">
    偶数
</c:if>

</body>
</html>
