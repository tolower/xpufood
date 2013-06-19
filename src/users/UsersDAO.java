package users;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.*;

import connection.*;

public class UsersDAO {
	private XPU_Connection _xpuConnection = null;

	// constructor

	public UsersDAO() {
		this._xpuConnection = new XPU_Connection();
	}

	public UsersDAO(XPU_Connection con) {
		this._xpuConnection = con;
	}

	// save user

	public void save(Users user) {
		String sql = "insert into users(user_name,user_pwd) values('"
				+ user.getUserName() + "','" + user.getUserPwd() + "')";
		try {
			// 调用数据库更新方法
			this._xpuConnection.get_statement().executeUpdate(sql);
		} catch (Exception re) {
			re.printStackTrace();
		}
	}

	// delete user

	public void delete(Users user) {
		String sql = "delete from users where user_name='" + user.getUserName()
				+ "'";
		try {
			this._xpuConnection.get_statement().executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Users> findByProperty(String sql) {
		List<Users> list = new ArrayList<Users>();
		try {
			ResultSet rs = this._xpuConnection.get_statement()
					.executeQuery(sql);
			while (rs.next()) {
				// 转化查询结果为一个user对象
				Integer id = rs.getInt(1);
				String u = rs.getString(2);
				String p = rs.getString(3);
				Users user = new Users(id, u, p);
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Users> findById(Integer id) {
		String sql = "select * from users where user_id="+id;
		// 用一个list来保存查询到的用户数据
		List<Users> list = new ArrayList<Users>();
		try {
			list = findByProperty(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// find all user

	public List<Users> findAllUsers() {
		String sql = "select * from users";
		// 用一个list来保存查询到的用户数据
		List<Users> list = new ArrayList<Users>();
		try {
			list = findByProperty(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// find by user_name

	public List<Users> findByName(String name) {
		String sql = "select * from users where users_name='" + name + "'";
		List<Users> list = new ArrayList<Users>();
		try {
			list = findByProperty(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//call login procedure
	public int login_proc(Users user){
		//bae的mysql目前不支持stored procedure
		//String sql="{call login(?,?)}";
		String sql="select user_id from users where user_name=? and user_pwd=md5(?)";
		ResultSet rs=null;
		int result=0;
		try{
			//调用登陆存储过程
			CallableStatement cst=this._xpuConnection.get_connection().prepareCall(sql);
			cst.setString(1, user.getUserName());
			cst.setString(2, user.getUserPwd());
			rs=cst.executeQuery();	
			while(rs.next()){
				result=rs.getInt(1);		
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	//call register procedure
	public void register_proc(Users user){
		//String sql="{call register(?,?)}";
		String sql="insert into users(user_name,user_pwd) values(?,md5(?))";
		try{
			CallableStatement cst=this._xpuConnection.get_connection().prepareCall(sql);
			cst.setString(1, user.getUserName());
			cst.setString(2, user.getUserPwd());
			cst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
