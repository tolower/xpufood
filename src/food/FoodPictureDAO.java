package food;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.XPU_Connection;

public class FoodPictureDAO {
	private XPU_Connection connection;
	//
	public FoodPictureDAO(){
		this.connection=new XPU_Connection();
	}
	//
	public FoodPictureDAO(XPU_Connection con){
		this.connection=con;
	}
	//save
	public void save(FoodPicture foodPicture){
		String sql="insert into food_picture(food_pic_url,food_id) values('"+foodPicture.getFoodPicUrl()+"',"+foodPicture.getFoodId()+")";
		try{
			this.connection.get_statement().executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//delete 
	public void delete(FoodPicture foodPicture){
		String sql="delete from food_picture where food_pic_id="+foodPicture.getFoodId();
		try{
			this.connection.get_statement().executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//delete by food_id
	public void deleteByFoodId(Integer food_id){
		String sql="delete from food_picture where food_id="+food_id;
		try{
			this.connection.get_statement().executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//find all
	public List<FoodPicture> findAll(){
		String sql="select * from food_picture";
		List<FoodPicture> list=new ArrayList<FoodPicture>();
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//find by property
	public List<FoodPicture> findByProperty(String sql){
		
		List<FoodPicture> list=new ArrayList<FoodPicture>();
		try{
			ResultSet rs=this.connection.get_statement().executeQuery(sql);
			while(rs.next()){
				Integer foodPicId=rs.getInt(1);
				String foodPicUrl=rs.getString(2);
				Integer foodId=rs.getInt(3);
				FoodPicture foodPicture=new FoodPicture(foodId,foodPicUrl);
				foodPicture.setFoodId(foodPicId);
				list.add(foodPicture);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//find by id
	public FoodPicture findById(Integer foodPicId){
		String sql="select * from food_picture where food_pic_id="+foodPicId;
		List<FoodPicture> list=new ArrayList<FoodPicture>();
		try{
			list=this.findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list.get(0);
	}
	//find by food_id
	public List<FoodPicture> findByFoodId(Integer foodId){
		String sql="select * from food_picture where food_id="+foodId;
		List<FoodPicture> list=new ArrayList<FoodPicture>();
		try{
			list=this.findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
