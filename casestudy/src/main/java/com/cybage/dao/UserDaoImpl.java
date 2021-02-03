package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.User;
import com.cybage.util.DbUtil;

public class UserDaoImpl implements UserDao {

	public int addUer(User user) throws Exception {

		String sql = "insert into user values(? , ? , ? , ?)";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getAddress());

		return ps.executeUpdate();
	}

	public List<User> findUser() throws Exception {
		Connection con = DbUtil.getCon();

		String sql = "select id, username, address from user";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setAddress(rs.getString(3));

			users.add(user);
		}
		return users;
	}

	public User findUserById(int id) throws Exception{
		Connection con = DbUtil.getCon();

		String sql = "select id, username, password, address from user where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setAddress(rs.getString(4));

		return user;
	}

	public int deleteUser(int id) throws Exception {
		String sql = "delete from user where id = ?";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);

		return ps.executeUpdate();

	}

	public int udpateUser(User user) throws Exception {
		String sql = "update user set username = ?, password=?, address=? where id = ? ";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);

		 
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getAddress());
		ps.setInt(4, user.getId());

		return ps.executeUpdate();
	}

}
