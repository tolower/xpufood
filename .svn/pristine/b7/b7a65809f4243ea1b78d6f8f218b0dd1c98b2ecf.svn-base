package food;
import java.sql.ResultSet;
import java.util.*;

import connection.*;


public class FoodDAO {
	private XPU_Connection connection;
	
	//constructor
	
	public FoodDAO(){
		this.connection=new XPU_Connection();
	}
	
	public FoodDAO(XPU_Connection con){
		this.connection=con;
	}
	//save food
	public void save(Food food) {
		String sql1="insert into food(food_name,restaurant_id,food_price,food_type) values('";
		String sql2=food.getFoodName()+"',"+food.getRestaurantId()+",'"+food.getFoodPrice()+"','"+food.getFoodType()+"')";
		String sql=sql1+sql2;
		try {
			this.connection.get_statement().executeUpdate(sql);
		} catch (Exception re) {
			re.printStackTrace();
		}
	}

	//delete food
	public void delete(Food food) {
		String sql="delete from food where food_name='"+food.getFoodName()+"'";
		try {
			this.connection.get_statement().executeUpdate(sql);
		} catch (Exception re) {
			re.printStackTrace();
		}
	}
	
	//query
	public List<Food> findByProperty(String sql){
		List<Food> list=new ArrayList<Food>();
		try{
			ResultSet rs=this.connection.get_statement().executeQuery(sql);
			while(rs.next()){
				Integer foodId=rs.getInt(2);
				Integer restaurantId=rs.getInt(3);
				String foodName=rs.getString(1);
				Integer foodPrice=rs.getInt(4);
				String foodType=rs.getString(5);
				Integer foodLevel=rs.getInt(6);
				Integer foodLovecount=rs.getInt(7);
				Integer foodEatedcount=rs.getInt(8);
				Integer foodWanteatcount=rs.getInt(9);
				Food food=new Food(restaurantId,foodName,foodPrice,foodType,foodLevel,foodLovecount,foodEatedcount,foodWanteatcount);
				food.setFoodId(foodId);
				list.add(food);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Food> findById(Integer id){
		String sql="select * from food where food_id="+id;
		List<Food> list=new ArrayList<Food>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Food> findByName(String name){
		String sql="select * from food where food_name='"+name+"'";
		List<Food> list=new ArrayList<Food>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Food> findByPrice(String price){
		String sql="select * from food where food_price='"+price+"'";
		List<Food> list=new ArrayList<Food>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Food> findByType(String type){
		String sql="select * from food where food_type='"+type+"'";
		List<Food> list=new ArrayList<Food>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Food> findByRestaurantId(Integer id){
		String sql="select * from food where restaurant_id="+id;
		List<Food> list=new ArrayList<Food>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<Food> findByRestaurantIdAndName(Integer res_id,String food_name){
		String sql="select * from food where restaurant_id="+res_id+" and food_name='"+food_name+"'";
		List<Food> list=new ArrayList<Food>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<Food> findByLevel(Integer level){
		String sql="select * from food where food_level="+level;
		List<Food> list=new ArrayList<Food>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Food> findAll(){
		String sql="select * from food";
		List<Food> list=new ArrayList<Food>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	//饭菜的喜欢数增加1
	public void incLovecount(Food food){
		String sql="update food set food_lovecount=food_lovecount+1 where food_id="+food.getFoodId();
		try{
			this.connection.get_statement().executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//吃过该饭菜的人数增加1
	public void incEatedcount(Food food){
		String sql="update food set food_eatedcount=food_eatedcount+1 where food_id="+food.getFoodId();
		try{
			this.connection.get_statement().executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	//该饭菜想吃人数增加1
	public void incWanteatcount(Food food){
		String sql="update food set food_wanteatcount=food_wanteatcount+1 where food_id="+food.getFoodId();
		try{
			this.connection.get_statement().executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
