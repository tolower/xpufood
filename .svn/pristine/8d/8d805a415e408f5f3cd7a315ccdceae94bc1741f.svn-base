<%@page import="java.io.File,manage.*,food.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.jspsmart.upload.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>	
	<%
	SmartUpload mySmartUpload = new SmartUpload();
	mySmartUpload.initialize(pageContext);
	mySmartUpload.upload();
%>


	<%
		final String UpFileType = "png|jpg|gif|bmp"; //上传文件类型
		final int MaxFileSize = 102400; //上传文件大小限制
		Integer foodId=(Integer)session.getAttribute("food_id");
		boolean ERR = false; //错误标志
		// 取当前文件
		com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(
				0);

		//文件效验
		// 取得文件并保存
		if (!myFile.isMissing()) {
			//得到文件扩展名
			String FileType = myFile.getFileExt();
			FileType = FileType.toLowerCase(); //将扩展名转换成小写
			if (UpFileType.indexOf(FileType) == -1) {
				ERR = true;
				out.println("文件格式不对");
				//response.sendRedirect("xwb_error.jsp?err=type");//文件格式不对
			}
			//得到文件大小
			int FileSize = myFile.getSize();
			if (ERR == false && FileSize > MaxFileSize) {
				ERR = true;
				out.println("文件太大");
				//response.sendRedirect("xwb_error.jsp?err=size");//文件太大
			}
		} else {
			out.println("文件错误");
		}

		//上传文件
		String filename = "";
		filename = myFile.getFileName();
		//out.println(filename);
		try {
			if (!myFile.isMissing()){
				filename = myFile.getFileName();
				java.util.Date date = new java.util.Date();
				long time = date.getTime();
				String title = String.valueOf(time);
				String extn = filename.substring(filename.lastIndexOf('.'),
						filename.length());
				filename = title + extn;
				String apath=new File(application.getRealPath(request.getRequestURI())).getParent();
				myFile.saveAs(apath+"/"+filename);
				String pic_url=basePath+"show/"+filename;
				//out.println(pic);
				
				//out.println(foodId);
				//存入图片url到数据库中
				AddInfo addpic=new AddInfo();
				FoodPicture foodPicture=new FoodPicture(foodId,pic_url);
				//out.println(foodPicture);
				addpic.addFoodPicture(foodPicture);
				
			} //END OF IF 
		}
		catch (Exception e){
			//out.println(new File(application.getRealPath(request.getRequestURI())).getParent());
			out.println("<b>Wrong selection : </b>" + e.toString());
		}
		response.sendRedirect("/show/showfood.jsp?food_id="+foodId);
	%>
	
</body>
</html>