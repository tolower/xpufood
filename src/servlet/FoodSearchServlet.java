package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.Food;

import manage.SearchInfo;

public class FoodSearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FoodSearchServlet() {
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
		String foodType=request.getParameter("food_type");
		Integer foodLevel=Integer.parseInt(request.getParameter("food_level"));
		Integer foodLoveCount=Integer.parseInt(request.getParameter("food_lovecount"));
		String foodName="dd";
		if(request.getParameter("food_name").equals("")){
			foodName=request.getParameter("foodName");
		}
		//out.println(foodType+","+foodLevel+","+foodLoveCount+","+foodName);
		//调用查询
		SearchInfo searchInfo=new SearchInfo();
		List<Food> list=searchInfo.foodResult(foodType, foodLevel, foodLoveCount, foodName);
		//封装到session里面，用session保存查询到的数据集合
		HttpSession session=request.getSession();
		session.setAttribute("foodlist", list);
		response.sendRedirect("/search/foodsearch.jsp");
		out.flush();
		out.close();
	}

}
