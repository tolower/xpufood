<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
  <link href="/static/addinfo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="/servlet/AddCommentServlet" method="post">
<div class="addrestaurant">
	<div class="description">
	<br>
    评论内容：<br>
    </div>
    <div class="description">
	<textarea name="comment_text" class="radius" rows="5" cols="40"></textarea><br>
    </div>
    <div class="description">
	<input name="sub_comment" class="addbtn" value="提交评论" type="submit"></input>
	</div>	
	<input type="hidden" name="food_id" value="<%=request.getParameter("food_id")%>" />
    </div>
</div>	
    </form>
</body>
</html>