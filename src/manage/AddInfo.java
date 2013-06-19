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
}
