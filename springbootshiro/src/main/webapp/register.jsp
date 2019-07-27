<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/3/30
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#save").click(function() {
                $.ajax({
                    url: "user/insert",
                    type: 'POST',
                    data: JSON.stringify({
                        userId:     $("input[name='userId']").val(),
                        userName:   $("input[name='userName']").val(),
                        userAge:    $("input[name='userAge']").val(),
                        userGender: $("input[name='userGender']").val(),
                        userTelphone: $("input[name='userTelphone']").val(),
                        password:   $("input[name='password']").val()
                    }),
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        alert(data.status);
                        alert(data.data);
                        window.location.href='/login.jsp';
                    },
                    error: function (data) {
                        alert("错误"+data.data);
                    },
                });
            });
        });
    </script>
</head>
<body>
<form method="post">
    <span class='span'>id<input name='userId' type="text"/></span><br/>
    <span class='span'>name<input name='userName' type="text"/></span><br/>
    <span class='span'>age<input name='userAge' type="text"/></span><br/>
    <span class='span'>gender<input name='userGender' type="text"/></span><br/>
    <span class='span'>telphone<input name='userTelphone' type="text"/></span><br/>
    <span class='span'>password<input name='password' type="text"/></span><br/>
    <span class='span_1'><input type="button" id="save"  value="注册"/></span>
</form>

</body>


</html>