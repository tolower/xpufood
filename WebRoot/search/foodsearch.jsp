<%@ page language="java" contentType="text/html; charset=UTF-8" import="manage.*,java.util.*,food.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
  <link href="/static/addinfo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="/servlet/FoodSearchServlet" method="post">
		<div>
			<div class="description">
			<h3>查找饭菜</h3>
			</div>
			<div class="description">
				类型：<select class="restype" name="food_type">
				<option value="盖饭">盖饭</option>
				<option value="面食">面食</option>
				<option value="汤类饮料">汤类饮料</option>
				<option value="砂锅">砂锅</option>
				<option value="清真菜">清真菜</option>
				<option value="甜点">甜点</option>
				<option value="炒米/面">炒米/面</option>       			
				<option value="快餐小吃">快餐小吃</option>
				<option value="川菜">川菜</option>
				<option value="湘菜">湘菜</option>
				<option value="粤菜">粤菜</option>
      			<option value="海鲜">海鲜</option>
				<option value="火锅">火锅</option>
				<option value="烧烤自助">烧烤自助</option>
      			<option value="西餐料理">西餐料理</option>				
				<option value="其他">其他</option>
				</select>
			</div>
			<div class="description">
				评分：<select class="restype" name="food_level">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							</select>
			</div>
			<div class="description">
				喜欢人数：<input type="number" min="0" value="0" name="food_lovecount" >
			</div>
			<div class="description">
				名称：<input type="text" name="food_name" >
			</div>
			<div class="description">
				<input type="submit" value="搜索">
			</div>
		</div>
	</form>
	<%	List<Food> list=null; 
		ShowInfo show=new ShowInfo();
		int cur_page=0;
		if(session.getAttribute("foodlist")!=null){
			list=(List<Food>)session.getAttribute("foodlist");    %>
	<div style="margin-left:20px;margin-bottom:10px">
		<h3>搜索结果</h3>共有<%=list.size() %>个结果
	</div>
	<% 
		
		//List list=searchInfo.searchResult(kw);
		int page_count=5;
		int page_total=list.size();
		
		if(list.size()==0){
			out.println("换个关键字再搜搜～");
		}else{
		//处理分页
		
		if(request.getParameter("cur_page")!=null){
			cur_page=Integer.parseInt(request.getParameter("cur_page"));
		}
		int start_res=cur_page*page_count;
		for(int i=start_res;(i<start_res+page_count)&&i<page_total;i++){			
				Food food=list.get(i);%>
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
		<%}} 
		%>
	 <!-- 处理分页 -->
	<table border="0" align="center">
		<tr><td style="width:200px;" >
			<% if(cur_page >0){ %>
			<a href="/search/foodsearch.jsp?cur_page=<%=cur_page-1 %>">上一页</a>
		<%} %></td>
		
		<td width="200px">
			<% if((cur_page+1)*page_count < page_total){ %>
			<a href="/search/foodsearch.jsp?cur_page=<%=cur_page+1 %>">下一页</a>
		<%}} %></td>
		</tr>
	</table>
</body>
</html>