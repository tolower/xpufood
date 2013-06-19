package restaurant;
import java.sql.*;
import java.util.*;


import connection.*;
public class RestaurantDAO {
	private XPU_Connection _xpuConnection=null;
	
	//constructor
	
	public RestaurantDAO(){
		this._xpuConnection=new XPU_Connection();
	}
	
	public RestaurantDAO(XPU_Connection connection){
		this._xpuConnection=connection;
	}
	
	public void save(Restaurant r) {
		String sql1="insert into restaurant(restaurant_name,restaurant_lovecount,restaurant_type,restaurant_info)";
		String sql2=" values('"+r.getRestaurantName()+"',"+r.getRestaurantLovecount()+",'";
		String sql3=r.getRestaurantType()+"','"+r.getRestaurantInfo()+"')";
		String sql=sql1+sql2+sql3;
		try {
			this._xpuConnection.get_statement().executeUpdate(sql);
		} catch (Exception re) {
			re.printStackTrace();
		}
	}

	public void delete(Restaurant restaurant) {
		String sql="delete from restaurant where restaurant_name='"+restaurant.getRestaurantName()+"'";
		try {
			this._xpuConnection.get_statement().executeUpdate(sql);
		} catch (Exception re) {
			re.printStackTrace();
		}
	}
	
	public List<Restaurant> findByProperty(String sql){
		List<Restaurant> list=new ArrayList<Restaurant>();
		try{
			ResultSet rs=this._xpuConnection.get_statement().executeQuery(sql);
			while(rs.next()){

				Integer restaurantId=rs.getInt(1);
				String restaurantName=rs.getString(2);
				Integer restaurantLovecount=rs.getInt(3);
				String restaurantType=rs.getString(4);
				String restaurantInfo=rs.getString(5);
				Restaurant res=new Restaurant(restaurantName,restaurantLovecount,restaurantType,restaurantInfo);
				res.setRestaurantId(restaurantId);
				list.add(res);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> findById(Integer id){
		String sql="select * from restaurant where restaurant_id="+id;
		List<Restaurant> list=new ArrayList<Restaurant>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
//		List<Restaurant> list=new ArrayList<Restaurant>();
//		try{
//			ResultSet rs=this._xpuConnection.get_statement().executeQuery(sql);
//			while(rs.next()){
//
//				Integer restaurantId=rs.getInt(0);
//				String restaurantName=rs.getString(1);
//				Integer restaurantLovecount=rs.getInt(2);
//				String restaurantType=rs.getString(3);
//				String restaurantInfo=rs.getString(4);
//				Restaurant res=new Restaurant(restaurantName,restaurantLovecount,restaurantType,restaurantInfo);
//				res.setRestaurantId(restaurantId);
//				list.add(res);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return list;
	}
	public List<Restaurant> findByName(String name){
		String sql="select * from restaurant where restaurant_name='"+name+"'";
		List<Restaurant> list=new ArrayList<Restaurant>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			
		}
		return list;
	}
	public Restaurant findByNameAndType(String name,String type){
		String sql="select * from restaurant where restaurant_name='"+name+"' and restaurant_type='"+type+"'";
		List<Restaurant> list=new ArrayList<Restaurant>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			
		}
		return list.get(0);
	}
	
	public List<Restaurant> findByType(String type){
		String sql="select * from restaurant where restaurant_type='"+type+"'";
		List<Restaurant> list=new ArrayList<Restaurant>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			
		}
		return list;
	}
	public List<Restaurant> findByLoveCount(Integer lovecount){
		String sql="select * from restaurant where restaurant_lovecount="+lovecount;
		List<Restaurant> list=new ArrayList<Restaurant>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			
		}
		return list;
	}
	public List<Restaurant> findAll(){
		String sql="select * from restaurant";
		List<Restaurant> list=new ArrayList<Restaurant>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			
		}
		return list;
	}
	//餐馆的喜欢人数增加1
	public void incLovecount(Integer id){
		String sql="update restaurant set restaurant_lovecount=restaurant_lovecount+1 where restaurant_id="+id;
		try{
			this._xpuConnection.get_statement().executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
