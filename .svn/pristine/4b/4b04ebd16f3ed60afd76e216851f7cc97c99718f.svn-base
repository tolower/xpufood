<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>吃货请登陆</title>
  <link href="/static/logincss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="/servlet/LoginServlet" method="post">
	<%
		String isLogin=(String)session.getAttribute("isLogin");
		if(isLogin!=null){
		if(isLogin.equals("failure")){
		//out.println(isLogin);
		out.println("用户名或者密码不正确");}
		}
		///String reqUri=request.getParameter("reqUri");
		//out.println(reqUri);
		
	 %>
     <div class="login">
	 <h3 id="loginh3">吃货登陆</h3>
		<table width="30%" height="167" class="logintable">
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
    			  <input id="ok" class="btn" value="登陆" type="submit"/>
    			  <a href="/jsp/register.jsp">用户注册</a>
  			  </div></td>
    		</tr>
</table>
    	</div>
    </form>
</body>
</html>