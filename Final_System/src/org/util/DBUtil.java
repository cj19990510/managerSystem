package org.util;

import java.sql.*;

public abstract class DBUtil {
	public static void main(String[] args){
		getConnection();
	}
	public static Connection getConnection(){ 
		try
	    {
            Class.forName("com.mysql.jdbc.Driver") ;
            String url ="jdbc:mysql://www.wxggt.xyz/managesystem?characterEncoding=utf8";
           Connection conn = DriverManager.getConnection(url,"root","root") ;
            
           // String url ="jdbc:mysql://127.0.0.1:3306/corp_message?characterEncoding=utf8" ;
          //  Connection conn = DriverManager.getConnection(url,"root","123456") ;
            return conn;
		}
	    catch (Exception e){
	        e.printStackTrace();
	        }
	    return null;
		
	}
	
	public static void free(Connection conn, PreparedStatement pre, ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		if(pre!=null){
			try {
				pre.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

	public static void free(Connection conn, PreparedStatement pre){
	if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	if(pre!=null){
		try {
			pre.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}
		
	
}
	
}
