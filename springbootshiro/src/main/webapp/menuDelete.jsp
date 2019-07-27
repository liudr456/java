<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/1
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
    <script type="text/javascript">

        $(function() {
            $("#delete").click(function() {
                $.ajax({
                    url: "menu/delete",
                    type: 'POST',
                    data: JSON.stringify({
                        id: $("input[name='id']").val(),
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
<body style=" background-color:#D75">
<div>
    <form method="post">
        <span class='span'>id<input name='id' type="text"/></span><br/>
        <span class='span_1'><input type="button" id="delete"  value="点击"/></span>
    </form>

</div>
</body>
</html>