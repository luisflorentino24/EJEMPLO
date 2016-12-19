package com.infosyst.dao;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
	import com.infosyst.bean.*;


	public class UserDao {
	public static Connection getConnection(){
		Connection con=null;
				
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:8080/examen","",
					"root");
			
		}catch(Exception e){System.out.println(e);}
		return con;
		
	}

	public static int save(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(
					"insert into infosyst(name, ap, am, email, edad, ingresosmens, fechaing) values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getAp());
			ps.setString(3,u.getAm());
			ps.setString(4,u.getEmail());
			ps.setInt(5, u.getEdad());
			ps.setInt(6, u.getIngresosMens());
			ps.setString(7, u.getFechaIng());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int update(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(
					"update infosyst set name=?,ap=?,am=?,email=?,edad=?,ingresosmens=?,fechaing=?  where id=?");
			ps.setString(1,u.getName());
			ps.setString(2,u.getAp());
			ps.setString(3,u.getAm());
			ps.setString(4,u.getEmail());
			ps.setInt(5,u.getEdad());
			ps.setInt(6,u.getIngresosMens());
			ps.setString(7,u.getFechaIng());
			ps.setInt(8,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from infosyst where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static List<User>getAllRecords(){
		List<User> list=new ArrayList<User>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select*from infosyst");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAp(rs.getString("ap"));
				u.setAm(rs.getString("am"));
				u.setEmail(rs.getString("email"));
				u.setEdad(rs.getInt("edad"));
				u.setIngresomens(rs.getInt("ingresosmens"));
				u.setFechaIng(rs.getString("fechaing"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static User getRecordById(int id){
		User u=null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select*from infosyst where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAp(rs.getString("Ap"));
				u.setAm(rs.getString("am"));
				u.setEmail(rs.getString("email"));
				u.setEdad(rs.getInt("edad"));
				u.setIngresomens(rs.getInt("ingresosmens"));
				u.setFechaIng(rs.getString("fechaing"));
			}
		}catch(Exception e){System.out.println(e);}
		return u;
	}
}
