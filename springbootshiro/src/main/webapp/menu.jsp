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
                    url: "menu/insert",
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
<body>
<form method="post">
    <span class='span'>id<input name='menuId' type="text"/></span><br/>
    <span class='span'>name<input name='menuName' type="text"/></span><br/>
    <span class='span'>url<input name='menuUrl' type="text"/></span><br/>
    <span class='span'>parentId<input name='parentId' type="text"/></span><br/>
    <span class='span_1'><input type="button" id="save"  value="新增菜单"/></span>
</form>
<button onclick="window.location.href='/menuDelete.jsp'">删除角色</button>
<button onclick="window.location.href='/menuUpdate.jsp'">更改角色</button>
<%--<form method="post">--%>
    <%--<span class='span'>id<input name='id' type="text"/></span>--%>
    <%--<span class='span_1'><input type="button" id="get"  value="查询菜单"/></span>--%>
<%--</form>--%>


<!--begin: add by danfeng to list json's datas-->
<%--<table cellspacing="1" class="table">--%>
    <%--<thead align="center">--%>
    <%--<tr>--%>
        <%--<td>menuId</td>--%>
        <%--<td>menuName</td>--%>
        <%--<td>menuUrl</td>--%>
        <%--<td>parentId</td>--%>
        <%--<td>updateAt</td>--%>
        <%--<td>createAt</td>--%>
        <%--<td>deleteAt</td>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<tbody id="datas">--%>
    <%--</tbody>--%>
<%--</table>--%>

<!--end: add by danfeng to list json's datas-->


</body>
<%--<script type="text/javascript">--%>
    <%--$(function () {--%>
        <%--$("#get").click(function() {--%>
            <%--$.ajax({--%>
                <%--url: "menu/get",//向后台对应函数路径发送请求--%>
                <%--type: "POST",--%>
                <%--contentType: 'application/json',--%>
                <%--dataType: "json",--%>
                <%--data: JSON.stringify({--%>
                    <%--id: $("input[name='id']").val(),--%>
                <%--}),--%>
                <%--success: function (data) {--%>
                    <%--// var str= JSON.stringify(data);--%>
                    <%--//  alert(str);--%>
                    <%--console.log(data);--%>

                    <%--var html;//用一个变量来存储json中的数据--%>
                    <%--//    $.each(data, function (i, item) {//用foreach循环遍历list集合将数据显示table表中--%>

                    <%--html = "<tr>" +--%>
                        <%--"<td>"+data1.menuId+"</td>"--%>
                        <%--+ "<td>"+data1.menuName+"</td>"--%>
                        <%--+ "<td>"+data1.menuUrl+"</td>"--%>
                        <%--+ "<td>"+data1.parentId+"</td>"--%>
                        <%--+ "<td>"+data1.updateAt+"</td>"--%>
                        <%--+ "<td>"+data1.createAt+"</td>"--%>
                        <%--+ "<td>"+data1.deleteAt+"</td>"--%>
                        <%--+ "</tr>"--%>
                    <%--//  })--%>


                    <%--$("#datas").html(html);--%>
                <%--},--%>
                <%--error: function (XMLHttpRequest, textStatus, errorThrown) {--%>
                    <%--alert(XMLHttpRequest.readyState + ">>>>>>\n" + XMLHttpRequest.status + ">>>>>>\n" + XMLHttpRequest.responseText);--%>
                <%--}--%>
            <%--})--%>
        <%--});--%>
    <%--});--%>

    <!--end: add by danfeng to list json's datas-->

 <%-- </script>--%>
</html>