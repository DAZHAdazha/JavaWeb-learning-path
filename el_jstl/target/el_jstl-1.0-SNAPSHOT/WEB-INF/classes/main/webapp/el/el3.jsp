<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    User user = new User();
    user.setName("dazha");
    user.setAge(21);
    user.setBirthday(new Date());

    request.setAttribute("u", user);

    ArrayList list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);

    request.setAttribute("list",list);

    Map map = new HashMap();
    map.put("sname","Dazha");
    map.put("gender","男");
    map.put("user",user);

    request.setAttribute("map",map);
%>

${ requestScope.u }
${ requestScope.u.name }
${ u.age }
${ u.birthday }
<%-- Date对象的getYear方法 --%>
${ u.birthday.month }
${ u.birStr }
<%--
    通过的是对象的属性来获取
    setter 或 getter 方法， 去掉set或get， 再将剩余部分首字母变小写
    setName -> Name -> name
--%>
<br>
${ list }<br>
${ list[0] }<br>
${ list[1] }<br>
<%-- 数组越界只会显示空字符串 --%>
${ list[10] }<br>
${ list[2].name }<br>
${ list[2].birStr }<br>

<h3>el获取Map值</h3>
${ map["sname"] }<br>
${ map.gender }<br>
${ map.user.name }<br>

</body>
</html>
