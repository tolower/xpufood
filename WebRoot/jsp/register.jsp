<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>吃货请注册</title>
  <link href="/static/logincss.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/servlet/RegisterServlet" method="post">
	<%
		String isexist=request.getParameter("isexist");
		if((isexist!=null)&&(isexist.equals("1"))){
			out.println("用户信息重复，请换一个用户名");
		}
	 %>
	 <h3 id="loginh3">吃货注册（这真的是注册页面哦！）</h3>
	<table class="logintable" width="450" height="167">
    <tr>
    			<td width="30%"><div align="right">吃货</div></td>
    			<td width="70%"><div align="center">
    			  <input name="name" class="inputlogin"/>
  			  </div></td>
    		</tr>
    		<tr>
    			<td><div align="right">密码</div></td>
    			<td><div align="center">
    			  <input name="pwd" type="password" class="inputlogin"/>
  			  </div></td>
    		</tr>
    		<tr>
    			<td><div align="center"></div></td>
    			<td><div align="center">
    			  <input id="ok" class="btn" value="注册" type="submit"/>
    		</td>
    		</tr>
    	</table>
    	
    </form>
</body>
</html>