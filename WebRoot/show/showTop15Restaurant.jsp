<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.List,restaurant.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="show" class="manage.ShowInfo"></jsp:useBean>
	<h3>餐馆喜欢人数TOP15排名</h3>
	<ol>
	<%
		List<Restaurant> list=show.showTop15Restaurant();
		   for(Restaurant res : list){
	%>
	<li>
		<a href="/show/showrestaurant.jsp?res_id=<%=res.getRestaurantId() %>" target="iFrame1"><%=res.getRestaurantName() %>
	</a></li>
	
	<% }%>
	</ol>
</body>
</html>