<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新饭菜信息</title>
  <link href="/static/addinfo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="/servlet/AddFoodServlet" method="post">
    <div class="addrestaurant">
    <div class="description">
		<h3>添加饭菜</h3>
        </div>
        <div class="description">
	饭菜名称：<input type="text" class="inputres" name="food_name" /><br>
    </div>
    <div class="description">
	饭菜类型：<select class="restype" name="food_type">
				<option value="盖饭">盖饭</option>
				<option value="面食">面食</option>
				<option value="汤类">汤类</option>
				<option value="砂锅">砂锅</option>
				<option value="饮品">饮品</option>
				</select><br>
      </div>
      <div class="description">
	饭菜价格：<input type="text" class="price" name="food_price" />元<br>
    </div>
	<div class="description">
	<input type="submit" class="addbtn" name="addfood" value="添加饭菜"/>
    </div>
	<input type="hidden" name="res_id" value="<%=Integer.parseInt(request.getParameter("res_id"))%>"/>
    </div>
	</form>

</body>
</html>