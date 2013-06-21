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
				<option value="汤类饮料">汤类饮料</option>
				<option value="砂锅">砂锅</option>
				<option value="清真菜">清真菜</option>
				<option value="甜点">甜点</option>
				<option value="炒米/面">炒米</option>       			
				<option value="快餐小吃">快餐小吃</option>
				<option value="川菜">川菜</option>
				<option value="湘菜">湘菜</option>
				<option value="粤菜">粤菜</option>
      			<option value="海鲜">海鲜</option>
				<option value="火锅">火锅</option>
				<option value="烧烤自助">烧烤自助</option>
      			<option value="西餐料理">西餐料理</option>				
				<option value="其他">其他</option>
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