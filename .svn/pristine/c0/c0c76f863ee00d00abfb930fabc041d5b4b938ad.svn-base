<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.List,food.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="show" class="manage.ShowInfo"></jsp:useBean>
	<h3>饭菜最新评分TOP15排名</h3>
	<ol>
	<%
		List<Food> list=show.showTop15Food();
		   for(Food food : list){
	%>
	<li>
		<a href="/show/showfood.jsp?food_id=<%=food.getFoodId() %>" target="iFrame1"><%=food.getFoodName() %>
	</a></li>
	
	<% }%>
	</ol>
</body>
</html>