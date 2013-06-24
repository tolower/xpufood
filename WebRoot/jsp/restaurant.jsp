<%@ page language="java" contentType="text/html; charset=UTF-8" import="restaurant.*,java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示餐馆信息</title>
<link rel="stylesheet" type="text/css" href="/static/show.css"/>
</head>
<body>
	
	<jsp:useBean id="resDAO" class="restaurant.RestaurantDAO" ></jsp:useBean>
	<div class="description">
		<h3>所有餐馆</h3>
	</div>
	<table border="0" class="description" >
		<tr style="background-color:#6cf;">
			<td class="showtd">餐馆名字</td>
			<td class="showtd">餐馆地点</td>
			<!-- <td style="width:250px;">餐馆信息</td> -->
			<td class="showtd">喜欢人数</td>
		</tr>
	<% 	List<Restaurant> list=resDAO.findAll();
		//处理分页
		int page_count=10;
		int page_total=list.size();
		int cur_page=0;
		if(request.getParameter("cur_page")!=null){
			cur_page=Integer.parseInt(request.getParameter("cur_page"));
		}
		int start_res=cur_page*page_count;
		for(int i=start_res;(i<start_res+page_count)&&i<page_total;i++){
			Restaurant res=list.get(i);
		
		
		//for(Restaurant res:list){
		String url=request.getContextPath()+"/show/showrestaurant.jsp?res_id="+res.getRestaurantId(); %>
	<tr style="margin-left: 20px;margin-bottom:10px;">
		<td class="showtd"><a href=<%=url%>><%=res.getRestaurantName() %></a></td>
		<td  class="showtd"><%=res.getRestaurantType() %></td>
		
		<td class="showtd"><%=res.getRestaurantLovecount() %></td>
	</tr>
	<% } 
		
	%>
	</table>
	<!-- 处理分页 -->
	<table border="0" align="center">
		<tr><td style="width:200px;" >
			<% if(cur_page >0){ %>
			<a href="/jsp/restaurant.jsp?cur_page=<%=cur_page-1 %>">上一页</a>
		<%} %></td>
		
		<td width="200px">
			<% if((cur_page+1)*page_count < page_total){ %>
			<a href="/jsp/restaurant.jsp?cur_page=<%=cur_page+1%>">下一页</a>
		<%} %></td>
		</tr>
	</table>
		
		
	
	<jsp:include page="/add/addrestaurant.jsp"/>

</body>
</html>