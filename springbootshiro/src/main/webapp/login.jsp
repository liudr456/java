<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/3/29
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#save").click(function() {

                $.ajax({

                    url: "/login",
                    type: 'POST',
                    data: JSON.stringify({
                        username: $("input[name='username']").val(),
                        password: $("input[name='password']").val()
                    }),
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        sessionStorage.setItem("menu",JSON.stringify(data));
                        window.location.href='/success.jsp';
                    },
                    error: function (data) {
                        alert("错误"+data.data);
                        window.location.href='/login.jsp';
                    },
                });
            });
        });
    </script>
</head>
<body style=" background-color:#F96">
<div>
    <span style="margin-left:180px; margin-top:100px; font-size:30px; color:#03F">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎登陆</span>
    <form method="post">
        <span class='span'>用户名<input name='username' type="text"/></span><br/>
        <span class='span'>密&nbsp;码<input name='password' type="password"/></span><br/>
        <span class='span_1'><input type="button" id="save"  value="登    陆"/></span>
    </form>
    <button onclick="window.location.href='/register.jsp'">注册</button>
</div>
</body>
</html>
