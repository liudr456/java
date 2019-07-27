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
                    url: "menu/update",
                    type: 'POST',
                    data: JSON.stringify({
                        menuId:     $("input[name='menuId']").val(),
                        menuName:   $("input[name='menuName']").val(),
                        menuUrl:    $("input[name='menuUrl']").val(),
                        parentId:   $("input[name='parentId']").val(),
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
        <span class='span'>id<input name='menuId' type="text"/></span><br/>
        <span class='span'>name<input name='menuName' type="text"/></span><br/>
        <span class='span'>url<input name='menuUrl' type="text"/></span><br/>
        <span class='span'>parentId<input name='parentId' type="text"/></span><br/>
        <span class='span_1'><input type="button" id="update"  value="更改菜单"/></span>
    </form>
</div>
</body>
</html>
