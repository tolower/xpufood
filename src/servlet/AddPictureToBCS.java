package servlet;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.Iterator;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.jspsmart.upload.*;


import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.log4j.Logger;

public class AddPictureToBCS extends HttpServlet {
	
	/**
	 * Constructor of the object.
	 */
	public AddPictureToBCS() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	private static final long serialVersionUID = -2201219701121037194L;  
	  
	private ServletConfig config;  
    private static final String CONTENT_TYPE = "text/html; charset=GB2312";  
    //protected final Logger log = Logger.getLogger(ExcelUpload.class.getName());  
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();  
		 // 变量定义  
		  int count = 0;  
		  //创建一个SmartUpload类  
		  SmartUpload mySmartUpload = new SmartUpload();  
		  try {  
		        //初始化     
		        mySmartUpload.initialize(this.getServletConfig(),request,response);  
		       //上传  
		       mySmartUpload.upload();  
		       for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {  
		        com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(i);  
		        String fileName = myfile.getFileName();  
		        //保存  
		        count = mySmartUpload.save("/upload");  
		        //count = mySmartUpload.save(null);  
		       }  
		       out.println(count + " file uploaded.");  
		  } catch (Exception e) {  
			  e.printStackTrace();
		       out.println("Unable to upload the file.<br>");  
		       out.println("Error : " + e.toString());  
		  }  
	   //JspFactory f=new JspFactory();
		/*

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// BCSCredentials credential=new
		// BCSCredentials("4X8AiM2f2hqI7Ad7Y2estV6o","kQsZLOl3Tc6ChFd0VtWsRcaTWf6qaRkO");
		// BaiduBCS bcs=new BaiduBCS(credential,"bcs.duapp.com" );
		// bcs.putObject("xpufood", , arg2)
		// /*

		// String ima = request.getParameter("food_picture");
		// ServletOutputStream ot=response.getOutputStream();
		// out.println(request.getRequestURL());
		// out.println(img + request.getLocale());
		// ServletFileUpload f=new ServletFileUpload();

		// String ima = request.getParameter("image");
		/*
		String uploadPath = this.getServletContext().getRealPath("/")+"img";
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart == true) {
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items =new ArrayList<FileItem>();
				items=upload.parseRequest(request);// 得到所有的文件
				if(items.size()==0){
					out.println("null");
					return;
				}
				Iterator<FileItem> itr = items.iterator();
				while (itr.hasNext()) {// 依次处理每个文件
					FileItem item = (FileItem) itr.next();
					String fileName = item.getName();// 获得文件名，包括路径
					out.println(fileName+"<br>");
					if (fileName != null) {
						File fullFile = new File(item.getName());
						File savedFile = new File(uploadPath,
						fullFile.getName());
						item.write(savedFile);
					}
				}
				out.print("upload succeed");

				/*
				 * String path = this.getServletContext().getRealPath("/");
				 * //request.getRealPath("/"); ///* FileOutputStream ot = new
				 * FileOutputStream(path +"/img/"+ ima); //ServletOutputStream
				 * ot=response.getOutputStream(); //也可以直接输出显示 ServletInputStream
				 * in =request.getInputStream();// new FileInputStream(ima);
				 * JPEGImageDecoder jpgCodec = JPEGCodec.createJPEGDecoder(in);
				 * BufferedImage image = jpgCodec.decodeAsBufferedImage();
				 * JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(ot);
				 * encoder.encode(image);
				 */

				// ot.write(in.read());
				// / */
				// byte[] b=new byte[2048];
				// in.read(b);
				// ot.println();
				// ot.write(b);
				// in.close();
				// ot.close();
				// out.print("JSP上传图片成功！<BR>");
				// 加载上传成功的图片
				// out.print("<IMG width=200 height=200 src='"+"/1.jpg' />");//+path+"/"
				// + ima+" />");	
		/*
			} catch (Exception e) {
				e.printStackTrace();
			}			 
			out.close();			
		}// /
		 */
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		// Put your code here
		super.init();
	}

}
