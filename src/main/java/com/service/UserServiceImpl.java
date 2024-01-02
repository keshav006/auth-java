package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.User;

public class UserServiceImpl implements UserService{

	@Override
	public void signup(User user) {
		
		String sql = "insert into user(fname,lname,username,password)values(?,?,?,?)";
		try {
			PreparedStatement pstm = DB.getDbCon().prepareStatement(sql);
			
			pstm.setString(1, user.getFname());
			pstm.setString(2, user.getLname());
			pstm.setString(3, user.getUsername());
			pstm.setString(4, user.getPassword());
			
			pstm.execute();
		
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		
	}

	@Override
	public boolean login(String un, String psw) {
		
		String sql = "select * from user where username = '"+un+"' and password = '"+psw+"' ";
		try {
			Statement stm = DB.getDbCon().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			if(rs.next()) {
				return true;
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> ulist = new ArrayList<User>();
		
		String sql = "select * from user";
		
		try {
			Statement stm = DB.getDbCon().createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				// table row mapping to object
				User u = new User();
				
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				ulist.add(u);
				
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
		return ulist;
	}

}
