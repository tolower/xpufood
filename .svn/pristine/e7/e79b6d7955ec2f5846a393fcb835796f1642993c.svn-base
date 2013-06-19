<%@ page language="java" import="manage.*,food.*,java.util.*,comment.*,food.*,java.net.URL,java.sql.*,connection.*,users.*,restaurant.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="icon" type="image/x-icon" href="/img/slogo.png"/>
  	<link rel="shortcut" type="image/x-icon" href="/img/slogo.png"/>
  	<link rel="bookmark" type="image/x-icon" href="/img/slogo.png"/>
    <base href="<%=basePath%>">
    <link herf="/static/mainstyle.css" rel="stylesheet" type="text/css"/>
    <title>吃货点评|西安工程大学非官方统计中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="/static/home.css">
  </head>
  
  <body>
    <div class="header" >
        <div style="height:110px;">
            <div>
                  <div style="float:left;"><a href=""><img src="/img/1.gif"></a>
                    <div style="margin-left:10px">工程大的吃货们快来～</div>
           		  </div>
            	  <div style="float:right;margin-top:10px;margin-right:10px;" >
                   <% if(session.getAttribute("user_id")!=null){
                   		int uId=(Integer)session.getAttribute("user_id");
                   		String uName=new ShowInfo().showUsers(uId).getUserName(); %>
                   		嗨,吃货<b><%=uName %></b>
                   	<% }else{ %>
                    <a href="/jsp/login.jsp" >登陆</a><%} %>
                    <a href="/jsp/register.jsp">注册</a>
            	  </div>
       	    </div>          
        </div>
        <div class="menu1">
	        <div style="margin-left:20px;">
	        <div class="menuitem1"><a href=""><span style="color:#fff;">吃货主页</span></a></div>
	        <div class="menuitem1"><a href="/jsp/restaurant.jsp" target="iFrame1"><span style="color:#fff;">餐馆</span></a></div>
	        <div class="menuitem1"><a href="/jsp/food.jsp" target="iFrame1"><span style="color:#fff;">饭菜</span></a></div>
	        </div>
	        <div style="float:right;margin-top:5px;margin-right:40px;" >
	        	<input type="text" class="inputres">
	        	<input type="submit" class="search" value="搜 索">
	        </div>
        </div>    
    </div>
    <div id="mInfo" name="mInfo" class="maininfo">
      <div id="fInfo" name="fInfo" class="foodinfo">
   		<div style="margin-left:301px;background-color: #eee;">      		
              <iframe id="iFrame1" name="iFrame1" src="/static/help.html" height="900px" width="100%" scrolling="no" frameborder="0"></iframe>        
        </div>
   	  </div>
      <div class="qortinfo">
    	 <div class="resfood">
    	    <iframe src="/show/showTop15Restaurant.jsp" height="100%" width="100%" scrolling="no" frameborder="0"></iframe>
    	 </div><hr>
         <div class="resfood">
             <iframe src="/show/showTop15Food.jsp" height="100%" width="100%" scrolling="no" frameborder="0"></iframe>
         </div>
      </div>
    </div>
   <div class="footer">
   	
   	<table style="margin:auto;width:40%;"> 
    	<tr>
          <td><a href="http://www.tolower.net">我的博客</a></td>
        <td><a href="http://tieba.baidu.com/f?kw=%CE%F7%B0%B2%B9%A4%B3%CC%B4%F3%D1%A7">学校贴吧</a></td>
          <td><a href="http://www.xpu.edu.cn">学校网站</a></td>
          <td><a href="mailto:lower_scoring@126.com">联系我们</a></td>
        </tr>
    </table>
    <hr>
     <p style="text-align:center">lower_scoring</p>
   
   </div> 
  </body>
</html>
