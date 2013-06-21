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
       餐馆地点：<select class="restype" name="restaurant_type">
                        <option value="临潼东后门">临潼东后门</option>
                        <option value="临潼校内食堂">临潼校内食堂</option>
                        <option value="吊庄国际">吊庄国际</option>
                        <option value="芷阳湖商业街">芷阳湖商业街</option>
                        <option value="金花校内食堂">金花校内食堂</option> 
                        <option value="金花校外南门">金花校外南门</option>
                               <option value="金花校外北门">金花校外北门</option>
                               <option value="金花校外西门">金花校外西门</option>				
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