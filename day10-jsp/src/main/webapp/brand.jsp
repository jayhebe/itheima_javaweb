<%@ page import="cn.mycloudway.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=utf8" language="java" %>
<%
    List<Brand> brands = new ArrayList<Brand>();
    brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
    brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
    brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));
%>
<html>
<body>
    <input type="button" value="新增"><br>
    <hr>
    <table border="1" cellspacing="0" width="800">
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <%
            for (Brand brand : brands) {
        %>
        <tr align="center">
            <td><%= brand.getId() %></td>
            <td><%= brand.getBrandName() %></td>
            <td><%= brand.getCompanyName() %></td>
            <td><%= brand.getOrdered() %></td>
            <td><%= brand.getDescription() %></td>
            <td><%= brand.getStatus() %></td>
            <td><a href="#">修改</a> <a href="#">删除</a></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>