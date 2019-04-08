package com.bean.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;


@Repository
public class DB {
	private Connection conn;//	���ݿ����Ӷ���
	private String driver;//com.jdbc.mysql.driver
	private String url;//jdbc:mysql://127.1.1.2:3306/tedu ����
	private String name;//root
	private String pwd;	//root
	
	
	public void init() throws Exception{
		//1.����jdbc���������ڴ���;��Ϊjdbc�Ŀ��� ���ǻ��ڽӿڵ�
//		System.out.println("���Խ���connection���ӵĳ�ʼ������"+this.driver);
		Class.forName(driver);
//		2.ͨ��url��name��pwd���л�ȡ���ݿ�����
		conn=DriverManager.getConnection(url,name,pwd);
	}

	public void destroy(){
		System.out.println("���� "+this.driver);
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
//
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		return conn.createStatement();
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return conn.prepareStatement(sql);
	}

	public void setAutoCommit(boolean b) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(b);
	}
	
	@Override
	public String toString() {
		return "DB [conn=" + conn + ", driver=" + driver + ", url=" + url + ", name=" + name + ", pwd=" + pwd + "]";
	}

	public DB(){
		System.out.println("DB");
	}
}
