<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新餐馆信息</title>
  <link href="/static/addinfo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="/servlet/AddRestaurantServlet" method="post">
	
	<div class="addrestaurant" >
    <div class="description">
    <h3>添加新餐馆</h3>
    </div>
    <div class="description">
        餐馆名称：<input class="inputres" name="restaurant_name" /><br>
     </div>
     <div class="description">
       餐馆类型：<select class="restype" name="restaurant_type">
                        <option value="临潼校外">临潼校外</option>
                        <option value="临潼校内">临潼校内</option>
                        <option value="金花校内">金花校内</option>
                        <option value="金花校外">金花校外</option>					
                        </select>
      </div>
      <div class="description">
        餐馆详细描述：<br><textarea name="restaurant_info" class="radius" rows="10" cols="55"></textarea>
        <br>
        <input type="submit" class="addbtn" value="添加餐馆" name="addrestaurant" />
        </div>
	</div>
    </form>
</body>
</html>