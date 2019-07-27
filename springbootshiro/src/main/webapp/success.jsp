<%@ page import="com.alibaba.fastjson.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/3/29
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
  >
</head>
<body>

    <button onclick="window.location.href='/role.jsp'">role</button>
    <button onclick="window.location.href='/user.jsp'">user</button>
    <button onclick="window.location.href='/menu.jsp'">menu</button>
    <button onclick="window.location.href='/userRole.jsp'">userRole</button>
    <button onclick="window.location.href='/roleMenu.jsp'">roleMenu</button>

    <table cellspacing="1" class="table">
        <thead align="center">
        <tr>
            <td>menuId</td>
            <td>menuName</td>
            <td>menuUrl</td>
            <td>parentId</td>
            <td>updateAt</td>
            <td>createAt</td>
            <td>deleteAt</td>
            <td>nodes</td>
        </tr>
        </thead>
        <tbody id="datas">
        </tbody>
    </table>

    <button onclick="nodes()">nodes</button>
    <button onclick="window.location.href='/success.jsp'">返回主菜单</button>

</body>
<script type="text/javascript">
    var me = sessionStorage.getItem("menu");
    alert(me);
    var nu=JSON.parse(me);
    var html;//用一个变量来存储json中的数据
    var data1=nu.data;
    //  $.each(nu, function (i,item) {//用foreach循环遍历list集合将数据显示table表中
    html = "<tr>" +
        "<td>"+data1.menuId+"</td>"
        + "<td>"+data1.menuName+"</td>"
        + "<td>"+data1.menuUrl+"</td>"
        + "<td>"+data1.parentId+"</td>"
        + "<td>"+data1.updateAt+"</td>"
        + "<td>"+data1.createAt+"</td>"
        + "<td>"+data1.deleteAt+"</td>"
        + "<td>"+data1.nodes+"</td>"
        + "</tr>"
    //   })
    function nodes() {
    var html;//用一个变量来存储json中的数据
    var data2=data1.nodes;
      $.each(data2, function (i,item) {//用foreach循环遍历list集合将数据显示table表中
        console.log(item);
          html += "<tr>" +
              "<td>" + item.menuId + "</td>"
              + "<td>" + item.menuName + "</td>"
              + "<td>" + item.menuUrl + "</td>"
              + "<td>" + item.parentId + "</td>"
              + "<td>" + item.updateAt + "</td>"
              + "<td>" + item.createAt + "</td>"
              + "<td>" + item.deleteAt + "</td>"
              + "<td>" + item.nodes + "</td>"
              + "</tr>"
             })
        $("#datas").html(html);

      }
    $("#datas").html(html);


</script>
</html>
