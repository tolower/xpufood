<%@ page language="java" contentType="text/html; charset=UTF-8" import="manage.*,restaurant.*,food.*,comment.*,java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	ShowInfo show=new ShowInfo();
	Integer food_id=Integer.parseInt(request.getParameter("food_id"));
	Food food=show.showFood(food_id);
	List<Comment> comList=show.showComment(food_id);
	session.setAttribute("food_id", food.getFoodId());
 %>
<title><%=food.getFoodName()%>信息</title>
<link rel="stylesheet" type="text/css" href="/static/show.css"/>
</head>
<body>
	<div class="description">
		<h2>饭菜信息</h2>
	</div>
  <div class="description">
		名称：<%=food.getFoodName() %>
		<%
			///ShowInfo show=new ShowInfo();
			//读取点喜欢的cookie，显示已喜欢餐馆的人数
			Cookie[] cookies=request.getCookies();
			if(cookies!=null){
			boolean isFoodLiked=false;
				for(Cookie cookie : cookies){
				//out.println(cookie.getName());
					if(cookie.getName().equals(String.valueOf("lovefood"+food_id))){
						isFoodLiked=true;	%>
						<b>已有<%=show.showFood(food_id).getFoodLovecount() %>人喜欢</b><br>
					<%break;}}
					if(!isFoodLiked){ %>
							<a href="/servlet/LoveFoodServlet?food_id=<%=food_id %>">我喜欢</a><br>					
				<%} }%>	
		
		
	</div>
	
  
	
	
<div style="width:100%;height:390px;">
		
          <div style="float:left;margin-left: 20px;margin-bottom:10px;">
		饭菜真相：<br>
	<%
		List<FoodPicture> foodPicList=show.showFoodPicture(food_id);
		//处理分页
		int page_count=1;
		int page_total=foodPicList.size();
		int cur_page=0;
		if(request.getParameter("cur_page")!=null){
			cur_page=Integer.parseInt(request.getParameter("cur_page"));
		}
		int start_res=cur_page*page_count;
		for(int i=start_res;(i<start_res+page_count)&&i<page_total;i++){
			FoodPicture foodPic=foodPicList.get(i);
			//
		//for(FoodPicture foodPic : foodPicList){
	 %>
            
      		<img alt="food" src="<%=foodPic.getFoodPicUrl() %> " height="300px">
           <br>
	<%} %>
	<!-- 处理分页 -->
	<table border="0" align="left">
		<tr><td style="width:200px;" >
			<% if(cur_page >0){ %>
			<a href="/show/showfood.jsp?food_id=<%=food_id %>&cur_page=<%=cur_page-1 %>">上一张</a>
		<%} %></td>
		
		<td width="200px">
			<% if((cur_page+1)*page_count < page_total){ %>
			<a href="/show/showfood.jsp?food_id=<%=food_id %>&cur_page=<%=cur_page+1%>">下一张</a>
		<%} %></td>
		</tr>
	</table>
	<br>
	<form action="/show/addpicture.jsp" method="post" id="addpicture" enctype="multipart/form-data">
		<br>添加图片：<input type="file" name="food_picture" /><br>
		
		<input type="submit" value="添加" />
		
	</form>
	</div>
    
          
          <div style="margin-top:20px;float:left;">
        	  <div class="description">
				类型：<%=food.getFoodType() %><br>
			</div>
			
				<div class="description">
					价格：<%=food.getFoodPrice() %>￥<br>
				</div>
    			<form action="/servlet/FoodGradeServlet" method="post">
	    			<div class="description">                  
						综合评分：<%=food.getFoodLevel() %>分不能再多了<br></div>				
					<div class="description"> 
	                  饭菜味道：<input type="number" name="food_taste" value="0" min="0" max="10"/>
	  				</div>
	  				<div class="description"> 
	  					上菜速度：<input type="number" name="food_speed" width="90px" height="20px" value="0" min="0" max="10"/>
	  				</div>
	  				<div class="description"> 
	  					价格份量：<input type="number" name="food_price" value="0" min="0" max="10"/>
	  				</div>
	  				<div class="description"> 
	  					<input type="hidden" value="<%=food_id %>" name="food_id">
	  					<% //Cookie[] cookies=request.getCookies();
	  						boolean isGrade=false;
	  						for(Cookie cookie : cookies){
	  							if(cookie.getName().equals("food"+food_id)){ 
	  								isGrade=true; %>
	  								您已经成功打分啦！	  							
	  						<%break;}}if(!isGrade){ %>
	  							<input type="submit" value="求打分">
	  						<%} %>	  					
	  				</div>
	  				
  				</form>
  			</div><br>
 	</div>
 </div>
  <br>
  <div class="description">
    <br>
    
  		所有评论：
  	
	<table border="0" width="100%" >
	<%//处理评论分页
		int comment_page_count=5;
		int comment_page_total=comList.size();
		int comment_cur_page=0;
		if(request.getParameter("comment_cur_page")!=null){
			comment_cur_page=Integer.parseInt(request.getParameter("comment_cur_page"));
		}
		int comment_start_res=comment_cur_page*comment_page_count;
		for(int i=comment_start_res;(i<comment_start_res+comment_page_count)&&i<comment_page_total;i++){
			Comment com=comList.get(i);
	//for(Comment com : comList){ 
	%>
		<tr>
		<td><b><%=show.showUsers(com.getUsersId()).getUserName() %></b>
				说：<%=com.getCommentText() %>		
		</td>
          <td style="color:#bbb;text-align:right;width:100px">
			<%=com.getCommentDate() %><br>
		</td>
		</tr>
	<%} %>
	</table>
	<!-- 处理评论分页 -->
	<table border="0" align="left">
		<tr><td style="width:200px;" >
			<% 
			//out.println(comment_cur_page);
			if(comment_cur_page >0){ %>
			<a href="/show/showfood.jsp?food_id=<%=food_id %>&comment_cur_page=<%=comment_cur_page-1%>">上一页</a>
		<%} %></td>
		
		<td width="200px">
			<% if((comment_cur_page+1)*comment_page_count < comment_page_total){ %>
			<a href="/show/showfood.jsp?food_id=<%=food_id %>&comment_cur_page=<%=comment_cur_page+1%>">下一页</a>
		<%} %></td>
		</tr>
	</table>
	<br>
	
	</div>
	
	
	<jsp:include page="/add/addcomment.jsp">
		<jsp:param value="<%=food_id %>" name="food_id"/>
	</jsp:include>
	
	
	
</body>
</html>