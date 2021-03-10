<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //1.获取所有cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if(cookies != null && cookies.length > 0){
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            //判断是否是lastTime
            if("lastTime".equals(name)){
                //有该cookie，不是第一次访问

                //设置cookies的value
                Date date = new Date();
                //注意空格等特殊字符需要URL编码！！！
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);

                //URL编码
                str_date = URLEncoder.encode(str_date,"utf-8");

                cookie.setValue(str_date);
                cookie.setMaxAge(60*60*24*30);//一个月
                response.addCookie(cookie);

                //相应数据
                //获取cookie的value
                String value = cookie.getValue();

                //URL解码
                value = URLDecoder.decode(value,"utf-8");

                %>
<!-- jsp 可以截断 -->

                <h1>欢迎欢迎回来,上次访问时间为： <%= value %> <h1>
        <%
                flag = true;
                break;
            }
        }
    }

    if(cookies == null || cookies.length==0 || flag == false){
        //设置cookies的value
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        //URL编码
        str_date = URLEncoder.encode(str_date,"utf-8");
        Cookie cookie = new Cookie("lastTime", str_date);
        cookie.setValue(str_date);
        cookie.setMaxAge(60*60*24*30);//一个月
        response.addCookie(cookie);
%>
        <h1>欢迎第一次登录<h1>

<%
    }
%>

<input>

</body>
</html>
