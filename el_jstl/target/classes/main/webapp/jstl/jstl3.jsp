<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>for each</title>
</head>
<body>

<%--
    foreach 相当于java代码中的for语句
    1.完成重复操作
        for(int i = 0; i < 10; i++){

        }
        *属性
            begin:开始值(循环包含开始与结束值)
            end: 结束值
            var:临时变量(i)
            step:步长
            varStatus:循环状态对象
                index:容器中元素的索引
                count:循环次数

    2.遍历容器
        List<User> list;
        for(User user : list){

        }

        属性：
            items：容器对象(list)
            var:容器中的临时变量(user)
            varStatus:循环状态对象
                index:容器中元素的索引
                count:循环次数

--%>

<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
%>

<c:forEach begin="2" end="9" var="i" step="2" varStatus="s">
    ${ i } &nbsp ${ s.index } &nbsp ${ s.count }<br>
</c:forEach>
<hr>
<c:forEach items="${ list }" var="str" varStatus="s">
    ${ s.index } ${ s.count } ${ str } <br>
</c:forEach>

</body>
</html>
