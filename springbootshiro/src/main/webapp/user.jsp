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
<body>
<%--<form method="post">--%>
    <%--<span class='span'>id<input name='userId' type="text"/></span><br/>--%>
    <%--<span class='span'>name<input name='userName' type="text"/></span><br/>--%>
    <%--<span class='span'>age<input name='userAge' type="text"/></span><br/>--%>
    <%--<span class='span'>gender<input name='userGender' type="text"/></span><br/>--%>
    <%--<span class='span'>telphone<input name='userTelphone' type="text"/></span><br/>--%>
    <%--<span class='span'>password<input name='password' type="text"/></span><br/>--%>
    <%--<span class='span_1'><input type="button" id="save"  value="新增用户"/></span>--%>
<%--</form>--%>
<button onclick="window.location.href='/userDelete.jsp'">删除用户</button>
<button onclick="window.location.href='/userUpdate.jsp'">更改用户</button>
<button onclick="window.location.href='/upPassword.jsp'">修改密码</button>
<form method="post">
    <span class='span'>id<input name='id' type="text"/></span>
    <span class='span_1'><input type="button" id="get"  value="查询用户"/></span>
</form>


<!--begin: add by danfeng to list json's datas-->
<table cellspacing="1" class="table">
    <thead align="center">
    <tr>
        <td>userId</td>
        <td>userName</td>
        <td>userAge</td>
        <td>userGender</td>
        <td>userTelphone</td>
        <td>updateAt</td>
        <td>createAt</td>
        <td>deleteAt</td>
    </tr>
    </thead>
    <tbody id="datas">
    </tbody>
</table>

<!--end: add by danfeng to list json's datas-->


</body>
<script type="text/javascript">
    $(function () {
        $("#get").click(function() {
            $.ajax({
                url: "user/get",//向后台对应函数路径发送请求
                type: "POST",
                contentType: 'application/json',
                dataType: "json",
                data: JSON.stringify({
                    id: $("input[name='id']").val(),
                }),
                success: function (data) {
                    // var str= JSON.stringify(data);
                    //  alert(str);

                    var html;//用一个变量来存储json中的数据
                    //    $.each(data, function (i, item) {//用foreach循环遍历list集合将数据显示table表中

                    html = "<tr>" +
                        "<td>"+data.data.userId+"</td>"
                        + "<td>"+data.data.userName+"</td>"
                        + "<td>"+data.data.userAge+"</td>"
                        + "<td>"+data.data.userGender+"</td>"
                        + "<td>"+data.data.userTelphone+"</td>"
                        + "<td>"+data.data.updateAt+"</td>"
                        + "<td>"+data.data.createAt+"</td>"
                        + "<td>"+data.data.deleteAt+"</td>"
                        + "</tr>"
                    //  })


                    $("#datas").html(html);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.readyState + ">>>>>>\n" + XMLHttpRequest.status + ">>>>>>\n" + XMLHttpRequest.responseText);
                }
            })
        });
    });

    <!--end: add by danfeng to list json's datas-->

</script>

</html>