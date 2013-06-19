package manage;

import java.util.*;

import comment.*;
import food.*;
import users.*;
import restaurant.*;

public class ShowInfo {
	
	//根据餐馆id查找一个餐馆的信息
	public Restaurant showRestarant(Integer id) throws Exception{
		List<Restaurant> list=new ArrayList<Restaurant>();
		RestaurantDAO resDAO=new RestaurantDAO();
		list=resDAO.findById(id);
		Restaurant res=list.get(0);
		if(res==null){
			throw new Exception("restaurant is null!");
		}
		return res;
	}
	
	//根据餐馆的id查找它所有的food信息
	public List<Food> showFoods(Integer res_id){
		List<Food> list=new ArrayList<Food>();
		FoodDAO foodDAO=new FoodDAO();
		list=foodDAO.findByRestaurantId(res_id);
		return list;
	}
	
	//根据food的id查找对应的food信息
	public Food showFood(Integer food_id){
		FoodDAO dao=new FoodDAO();
		return dao.findById(food_id).get(0);
	}
	
	//根据food的res_id和food_name查找对应的food信息
	public List<Food> showFood(Integer res_id,String food_name){
		FoodDAO dao=new FoodDAO();
		return dao.findByRestaurantIdAndName(res_id,food_name);
	}
	
	//根据food的id查找它所有的评论信息
	public List<Comment> showComment(Integer food_id){
		List<Comment> list=new ArrayList<Comment>();
		CommentDAO comDAO=new CommentDAO();
		list=comDAO.findByFoodId(food_id);
		return list;
	}
	//根据comment的user_id查找对应的用户
	public Users showUsers(Integer user_id){
		UsersDAO dao=new UsersDAO();
		return dao.findById(user_id).get(0);
	}
	//根据用户名和密码，查询用户表信息
	public int userLogin(Users user){
		UsersDAO dao=new UsersDAO();
		return dao.login_proc(user);
	}
	//根据food_id查找food_picture信息
	public List<FoodPicture> showFoodPicture(Integer food_id){
		List<FoodPicture> list=new ArrayList<FoodPicture>();
		FoodPictureDAO dao=new FoodPictureDAO();
		list=dao.findByFoodId(food_id);
		return list;
	}
	//根据评分排名，查找top15的餐馆信息
	public List<Restaurant> showTop15Restaurant(){
		String sql="select * from restaurant order by restaurant_lovecount desc limit 15";
		List<Restaurant> list=null;
		try{
			RestaurantDAO dao=new RestaurantDAO();
			list=dao.findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//根据评分查找top15的饭菜信息
	public List<Food> showTop15Food(){
		String sql="select * from food order by food_level desc limit 15";
		List<Food> list=null;
		try{
			FoodDAO dao=new FoodDAO();
			list=dao.findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
