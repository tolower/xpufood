package connection;
import java.sql.*;
public class XPU_Connection {
	private Connection _connection=null;
	private Statement _statement=null;
	private ResultSet _resultset=null;
	
	private static final String _className="com.mysql.jdbc.Driver";
	//private static final String _url="jdbc:mysql://sqld.duapp.com:4050/rFVYfgQlHptAeKQitkrQ?user=4X8AiM2f2hqI7Ad7Y2estV6o&password=kQsZLOl3Tc6ChFd0VtWsRcaTWf6qaRkO";
	private static final String _url="jdbc:mysql://localhost:3306/xpufood?user=root&password=sui923874";
	//constructor
	
	public XPU_Connection(){
		try{
			Class.forName(_className);
	    	
	    	//String u1="jdbc:mysql://sqld.duapp.com:4050/rFVYfgQlHptAeKQitkrQ?";
	    	//String u2="user=4X8AiM2f2hqI7Ad7Y2estV6o&password=kQsZLOl3Tc6ChFd0VtWsRcaTWf6qaRkO";
	    	//String url1=u1+u2;
	    	_connection=DriverManager.getConnection(_url);
	    	_statement=_connection.createStatement();
	    	//String sql="select * from users";
	    	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection get_connection() {
		return _connection;
	}
	public void set_connection(Connection _connection) {
		this._connection = _connection;
	}
	public Statement get_statement() {
		return _statement;
	}
	public void set_statement(Statement _statement) {
		this._statement = _statement;
	}
	public ResultSet get_resultset() {
		return _resultset;
	}
	public void set_resultset(ResultSet _resultset) {
		this._resultset = _resultset;
	}
	public static String getClassname() {
		return _className;
	}
//	public static String getUrl() {
//		return _url;
//	}
	
}
