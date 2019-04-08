package com.bean.service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.db.DB;
import com.bean.vo.UserBean;

@Service
public class UserService {
	// 应该注入 DB
	@Autowired // 注入的注解
	private DB db;

	public UserService() {
		System.out.println("UserService");
	}

	public void setDb(DB db) {
		this.db = db;
		System.out.println(this.db.toString());
	}

	public boolean insert(UserBean uservo) throws Exception {
		// TODO Auto-generated method stub
		String username = uservo.getName();
		String password = uservo.getPassword();
		String sql = "insert into user(username,password) values(" + "\"" + username + "\"" + "," + "\"" + password
				+ "\");";
		System.out.println(sql);
		db.init();
		Statement sta = null;

		try {
			sta = db.createStatement();
			int x = sta.executeUpdate(sql);
			// 返回的整型代表本次sql语句操作影响了多少条数据
			System.out.println("已经访问到数据库。。。");
			// boolean x="你爸爸".equals(name);
			// int x="你爸爸".equals(name)?1:0;
			//// if(x){
			if (x != 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public List<UserBean> query() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from user;";
		System.out.println(sql);
		db.init();
		Statement sta = null;
		ResultSet rs;
		List<UserBean> list=new ArrayList<UserBean>();

		try {
			sta = db.createStatement();
			rs = sta.executeQuery(sql);
			while (rs.next()) {
				//便于数据的传输、管理
				UserBean userBean=new UserBean();
				userBean.setName(rs.getString("username"));
				userBean.setPassword(rs.getString(2));
				System.out.println(userBean);
				list.add(userBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
