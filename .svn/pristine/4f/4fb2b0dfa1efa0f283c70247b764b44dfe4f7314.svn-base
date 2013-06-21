package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.AddInfo;

public class LoveRestaurantServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoveRestaurantServlet() {
		super();
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer res_id=Integer.parseInt(request.getParameter("res_id"));
		try{
			//使对应id的餐馆喜欢数增1
			AddInfo addInfo=new AddInfo();
			addInfo.incRestaurantLoveCount(res_id);
			//用cookie记录该用户已经点过喜欢
			Cookie cookie=new Cookie(String.valueOf(res_id),String.valueOf(res_id));
			cookie.setMaxAge(360*24*60*60);
			cookie.setPath("/");
			response.addCookie(cookie);
			//out.println(cookie.getName());
			//response.flushBuffer();
			response.sendRedirect("/show/showrestaurant.jsp?res_id="+res_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		out.flush();
		out.close();
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
		this.doGet(request, response);
	}

}
