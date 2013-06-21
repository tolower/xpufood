package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.AddInfo;

public class FoodGradeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FoodGradeServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获取3类打分数据
		Integer foodTaste=Integer.parseInt(request.getParameter("food_taste"));
		Integer foodSpeed=Integer.parseInt(request.getParameter("food_speed"));
		Integer foodPrice=Integer.parseInt(request.getParameter("food_price"));
		Integer foodId=Integer.parseInt(request.getParameter("food_id"));
		//out.println(foodTaste+","+foodSpeed+","+foodPrice);
		Integer grade=(int) (foodTaste*0.4+foodSpeed*0.3+foodPrice*0.3);
		try{
			AddInfo add=new AddInfo();
			add.setFoodLevel(foodId, grade);
			//设置cookie，记录用户是否已经评分
			Cookie cookie=new Cookie("food"+foodId,"food"+foodId);
			cookie.setMaxAge(360*24*60*60);
			cookie.setPath("/");
			//写回cookie
			response.addCookie(cookie);
			response.sendRedirect("/show/showfood.jsp?food_id="+foodId);
		}catch(Exception e){
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
