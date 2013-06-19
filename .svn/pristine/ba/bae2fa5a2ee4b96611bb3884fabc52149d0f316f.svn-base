package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.AddInfo;

import java.util.*;

import comment.*;
import food.*;
import users.*;
import restaurant.*;
public class AddCommentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCommentServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//PrintWriter pw=response.getWriter();
	//pw.println(request.getLocalAddr()+request.getLocalPort()+request.getContextPath());
	
		String comment_text=request.getParameter("comment_text");
		Integer food_id=Integer.parseInt(request.getParameter("food_id"));
		//java.util.Date dates=new java.util.Date();
    	java.sql.Date dates=new java.sql.Date(new java.util.Date().getTime());
		//Integer user_id=Integer.parseInt()
    	//pw.println(comment_text);
    	//pw.println(food_id+dates.toString());
    	HttpSession session=request.getSession();
    	try{
    		//添加一个food评论到数据库中
    		if((session.getAttribute("user_id")!=null)){
    			Integer user_id=Integer.parseInt(session.getAttribute("user_id").toString());
        		Comment comment=new Comment(user_id,food_id,dates,comment_text);
        		AddInfo addInfo=new AddInfo();
        		addInfo.addCommentInfo(comment);
        		//pw.println("userid:"+comment.getUsersId()+","+comment.getFoodId());
        		response.sendRedirect("/show/showfood.jsp?food_id="+food_id);
    		}else{
    			response.sendRedirect("/jsp/login.jsp");
    			
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
