package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.AddInfo;

public class LoveFoodServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoveFoodServlet() {
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
		Integer foodId=Integer.parseInt(request.getParameter("food_id"));
		try{
			//使food的喜欢人数增1
			AddInfo add=new AddInfo();
			add.incFoodLoveCount(foodId);
			//用cookie记录用户点过喜欢
			Cookie cookie=new Cookie("lovefood"+foodId,"lovefood"+foodId);
			cookie.setMaxAge(360*24*60*60);
			cookie.setPath("/");
			response.addCookie(cookie);
			response.sendRedirect("/show/showfood.jsp?food_id="+foodId);
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
