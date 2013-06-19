package comment;
import java.sql.ResultSet;
import java.util.*;

import connection.*;
public class CommentDAO {
	private XPU_Connection connection;
	
	//coustructor
	
	public CommentDAO(){
			this.connection=new XPU_Connection();
	}
	
	public CommentDAO(XPU_Connection con){
			this.connection=con;
	}
	
	//save
	public void save(Comment comment) {		
		String sql1="insert into comment(user_id,comment_date,comment_text,food_id) values(";
		String sql2=comment.getUsersId()+",'"+comment.getCommentDate()+"','"+comment.getCommentText()+"',"+comment.getFoodId()+")";
		String sql=sql1+sql2;
		try {
			this.connection.get_statement().executeUpdate(sql);
		} catch (Exception re) {
				re.printStackTrace();
		}
	}
	//delete
	public void delete(Comment comment) {		
		String sql="delete from comment where comment_id="+comment.getCommentId();
		try {
			this.connection.get_statement().executeUpdate(sql);
		} catch (Exception re) {
			re.printStackTrace();
		}
	}
	
	public List<Comment> findByProperty(String sql){
		List<Comment> list=new ArrayList<Comment>();
		try{
			ResultSet rs=this.connection.get_statement().executeQuery(sql);
			while(rs.next()){
				Integer commentId=rs.getInt(1);
				Integer usersId=rs.getInt(2);
				Date date=rs.getDate(3);
				String commentText=rs.getString(4);
				Integer foodId=rs.getInt(5);
				Comment comment=new Comment(usersId,foodId,date,commentText);
				comment.setCommentId(commentId);
				list.add(comment);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Comment> findAll(){
		String sql="select * from comment";
		List<Comment> list=new ArrayList<Comment>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Comment> findByIdl(Integer id){
		String sql="select * from comment where comment_id="+id;
		List<Comment> list=new ArrayList<Comment>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Comment> findByUsersId(Integer id){
		String sql="select * from comment where user_id="+id;
		List<Comment> list=new ArrayList<Comment>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<Comment> findByDate(Date date){
		String sql="select * from comment where comment_date='"+date+"'";
		List<Comment> list=new ArrayList<Comment>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Comment> findByFoodId(Integer id){
		String sql="select * from comment where food_id="+id;
		List<Comment> list=new ArrayList<Comment>();
		try{
			list=findByProperty(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
