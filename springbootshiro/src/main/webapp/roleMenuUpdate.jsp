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
            $("#update").click(function() {
                $.ajax({
                    url: "roleMenu/update",
                    type: 'POST',
                    data: JSON.stringify({
                        roleMenuId:     $("input[name='roleMenuId']").val(),
                        roleId:   $("input[name='roleId']").val(),
                        menuId:    $("input[name='menuId']").val(),
                    }),
                    contentType: 'application/json',
                    dataType: 'json',

                    success: function (data) {
                        alert(data.status);
                        alert(data.data);
                        window.location.href='/success.jsp';
                    },
                    error: function (data) {
                        alert("错误"+data.data);
                    },
                });
            });
        });
    </script>
</head>
<body style=" background-color:#F96">
<div>
    <form method="post">
        <span class='span'>id<input name='roleMenuId' type="text"/></span><br/>
        <span class='span'>roleId<input name='roleId' type="text"/></span><br/>
        <span class='span'>menuId<input name='menuId' type="text"/></span><br/>
        <span class='span_1'><input type="button" id="update"  value="更改角色菜单"/></span>
    </form>
</div>
</body>
</html>
