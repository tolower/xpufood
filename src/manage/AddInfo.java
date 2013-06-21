package manage;
import java.util.*;

import comment.*;
import food.*;
import users.*;
import restaurant.*;
public class AddInfo {
	//添加food评论信息
	public void addCommentInfo(Comment comment){
		try{
			CommentDAO dao=new CommentDAO();
			dao.save(comment);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//添加餐馆信息
	public void addRestaurantInfo(Restaurant res){
		try{
			RestaurantDAO dao=new RestaurantDAO();
			dao.save(res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//添加food信息
	public void addFoodInfo(Food food){
		try{
			FoodDAO dao=new FoodDAO();
			dao.save(food);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//添加用户信息
	public void addUserInfo(Users user){
		try{
			UsersDAO dao=new UsersDAO();
			dao.register_proc(user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//添加food_picture信息
	public void addFoodPicture(FoodPicture foodPicture){
		try{
			FoodPictureDAO dao=new FoodPictureDAO();
			dao.save(foodPicture);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//根据res_id使对应的餐馆喜欢数增1
	public void incRestaurantLoveCount(Integer res_id){
		try{
			RestaurantDAO dao=new RestaurantDAO();
			dao.incLovecount(res_id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//根据food_id使food喜欢数加1
	public void incFoodLoveCount(Integer foodId){
		try{
			FoodDAO dao=new FoodDAO();
			dao.incLovecount(foodId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//设置food评分,参数为foodId和grade分数
	public void setFoodLevel(Integer foodId,Integer grade){
		ShowInfo show=new ShowInfo();
		Food food=show.showFood(foodId);
		//将原来的评分与现在的评分取平均值
		grade=(grade+food.getFoodLevel())/2;
		food.setFoodLevel(grade);
		try{
			FoodDAO dao=new FoodDAO();
			dao.setFoodLevel(food);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
