package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.AddInfo;

import comment.*;
import food.*;
import users.*;
import restaurant.*;
public class AddRestaurantServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddRestaurantServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String res_name=request.getParameter("restaurant_name");
		Integer restaurantLovecount=0;
		String res_info=request.getParameter("restaurant_info");
		String res_type=request.getParameter("restaurant_type");
		//res_type=new String(res_type.getBytes(),"utf-8");
		//out.println(res_type);
		
		Restaurant res=new Restaurant(res_name,restaurantLovecount,res_type,res_info);
		try{
			if(res!=null){
				AddInfo addRestaurant=new AddInfo();
				addRestaurant.addRestaurantInfo(res);
				
				//查询刚添加的餐馆信息，然后跳转到显示页面
				RestaurantDAO dao=new RestaurantDAO();				
				Integer res_id=dao.findByNameAndType(res_name, res_type).getRestaurantId();
				response.sendRedirect("/show/showrestaurant.jsp?res_id="+res_id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//out.flush();
		//out.close();
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
