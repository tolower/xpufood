<%@ page language="java" contentType="text/html; charset=UTF-8" import="manage.*,restaurant.*,food.*,java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="show" class="manage.ShowInfo"/>
		<%
			Integer res_id=Integer.parseInt(request.getParameter("res_id"));
			Restaurant res=show.showRestarant(res_id);			
		 %>
<title><%=res.getRestaurantName()%>详细信息</title>
	<link rel="stylesheet" type="text/css" href="/static/show.css"/>
</head>
<body>	
	<div class="" >	
		<div class="description">
			<h3>餐馆信息</h3>
		</div>
		
		<div class="description">
			餐馆名称：<%=res.getRestaurantName() %>
			<%
			///ShowInfo show=new ShowInfo();
			//读取点喜欢的cookie，显示已喜欢餐馆的人数
			Cookie[] cookies=request.getCookies();
			if(cookies!=null){
			boolean isLiked=false;
				for(Cookie cookie : cookies){
				//out.println(cookie.getName());
					if(cookie.getName().equals(String.valueOf(res_id))){
						isLiked=true;	%>
						<b>已有<%=show.showRestarant(res_id).getRestaurantLovecount() %>人喜欢</b><br>
					<%break;}}
					if(!isLiked){ %>
							<a href="/servlet/LoveRestaurantServlet?res_id=<%=res_id %>">我喜欢</a><br>					
				<%} }%>			
		</div> 
		<div class="description">
			餐馆地点：<%=res.getRestaurantType() %><br>
		</div> 
		<div class="description">
			详细信息：<%=res.getRestaurantInfo() %><br>
		</div> 
		<div class="description">
			餐馆里面的饭菜：<br>
		<table>
			
		<%
			List<Food> list=show.showFoods(res_id);			
			
			//处理分页
		int page_count=10;
		int page_total=list.size();
		int cur_page=0;
		if(request.getParameter("cur_page")!=null){
			cur_page=Integer.parseInt(request.getParameter("cur_page"));
		}
		int start_res=cur_page*page_count;
		for(int i=start_res;(i<start_res+page_count)&&i<page_total;i++){
			Food food=list.get(i);
			//for(Food food : list){
			String url="showfood.jsp?food_id="+food.getFoodId();
		 %>
		 <tr style="margin-bottom:5px;">
		 	<td style="width:250px;">
		 		<a href=<%=url%>><%=food.getFoodName() %></a></td>
		 	<td><%=food.getFoodType() %><br></td>
		 </tr>
		 <% } %>
		 	
		 </table>
		 <!-- 处理分页 -->
	<table border="0" align="left">
		<tr><td style="width:200px;" >
			<% if(cur_page >0){ %>
			<a href="/show/showrestaurant.jsp?res_id=<%=res_id %>&cur_page=<%=cur_page-1 %>">上一页</a>
		<%} %></td>
		
		<td width="200px">
			<% if((cur_page+1)*page_count < page_total){ %>
			<a href="/show/showrestaurant.jsp?res_id=<%=res_id %>&cur_page=<%=cur_page+1%>">下一页</a>
		<%} %></td>
		</tr>
	</table>
	
		</div> <br>
	</div>
		<jsp:include page="/add/addfood.jsp">
			<jsp:param value="<%=res_id%>" name="res_id"/>
		</jsp:include>
</body>
</html>