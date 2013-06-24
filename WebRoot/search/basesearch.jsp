<%@ page language="java" contentType="text/html; charset=UTF-8" import="manage.*,java.util.List,restaurant.*,food.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="/static/show.css"/>
</head>
<body>
	<jsp:useBean id="searchInfo" class="manage.SearchInfo"></jsp:useBean>
	<jsp:useBean id="show" class="manage.ShowInfo"></jsp:useBean>
	<% String kw=request.getParameter("kw"); 
	   List list=searchInfo.searchResult(kw); %>
	<div style="margin-left:20px;margin-bottom:10px">
		<h3>搜索结果</h3>共有<%=list.size() %>个结果
	</div>
	<% 
		
		//List list=searchInfo.searchResult(kw);
		int page_count=10;
		int page_total=list.size();
		int cur_page=0;
		if(list.size()==0){
			out.println("换个关键字再搜搜～");
		}else{
		//处理分页
		
		if(request.getParameter("cur_page")!=null){
			cur_page=Integer.parseInt(request.getParameter("cur_page"));
		}
		int start_res=cur_page*page_count;
		for(int i=start_res;(i<start_res+page_count)&&i<page_total;i++){
			Object o=list.get(i);	
			if(o instanceof Restaurant){
				Restaurant res=(Restaurant)o; %>
				<div style="margin-left:20px;margin-bottom:10px" >
					餐馆：<a href="/show/showrestaurant.jsp?res_id=<%=res.getRestaurantId() %>">
						<%=res.getRestaurantName() %>
					</a><br>
					<div style="float:left;width:160px">
						地点:<%=res.getRestaurantType() %>
					</div>
					<div>
						喜欢人数：<%=res.getRestaurantLovecount() %>
					</div>
				</div>
			<% }else{
				Food food=(Food)o;%>
				<div style="margin-left:20px;margin-bottom:10px">
					饭菜：<a href="/show/showfood.jsp?food_id=<%=food.getFoodId() %>">
						<%=food.getFoodName() %>
					</a><br>
					<div style="float:left;width:160px">
						餐馆：<%=show.showRestarant(food.getRestaurantId()).getRestaurantName() %>
					</div>
					<div>
						类型：<%=food.getFoodType() %>
					</div>					
				</div>
		<%}}} %>
	 <!-- 处理分页 -->
	<table border="0" align="center">
		<tr><td style="width:200px;" >
			<% if(cur_page >0){ %>
			<a href="/search/basesearch.jsp?kw=<%=kw %>&cur_page=<%=cur_page-1 %>">上一页</a>
		<%} %></td>
		
		<td width="200px">
			<% if((cur_page+1)*page_count < page_total){ %>
			<a href="/search/basesearch.jsp?kw=<%=kw %>&cur_page=<%=cur_page+1 %>">下一页</a>
		<%} %></td>
		</tr>
	</table>
</body>
</html>