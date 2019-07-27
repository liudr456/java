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
    <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#save").click(function() {
                $.ajax({
                    url: "role/insert",
                    type: 'POST',
                    data: JSON.stringify({
                        roleId: $("input[name='roleId']").val(),
                        roleName: $("input[name='roleName']").val()
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
        <span class='span'>role<input name='roleId' type="text"/></span><br/>
        <span class='span'>name<input name='roleName' type="text"/></span><br/>
        <span class='span_1'><input type="button" id="save"  value="新增角色"/></span>
    </form>
    <button onclick="window.location.href='/roleDelete.jsp'">删除角色</button>
    <button onclick="window.location.href='/roleUpdate.jsp'">更改角色</button>

</div>
<form method="post">
    <span class='span'>id<input name='id' type="text"/></span>
    <span class='span_1'><input type="button" id="get"  value="查看角色"/></span>
</form>
<!--begin: add by danfeng to list json's datas-->
<table cellspacing="1" class="table">
    <thead align="center">
    <tr>
        <td>menuId</td>
        <td>menuName</td>
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
                url: "role/get",//向后台对应函数路径发送请求
                type: "POST",
                contentType: 'application/json',
                dataType: "json",
                data: JSON.stringify({
                    id: $("input[name='id']").val(),
                }),
                success: function (data) {
                    var html;//用一个变量来存储json中的数据
                    //    $.each(data, function (i, item) {//用foreach循环遍历list集合将数据显示table表中
                    html = "<tr>" +
                        "<td>"+data.data.roleId+"</td>"
                        + "<td>"+data.data.roleName+"</td>"
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
