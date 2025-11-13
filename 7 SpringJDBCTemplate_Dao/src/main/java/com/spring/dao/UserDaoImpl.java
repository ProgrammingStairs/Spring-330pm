// ###################### jdbcTemplate ###########################
//package com.spring.dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.spring.model.User;
//
//@Repository
//public class UserDaoImpl implements UserDao{
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	RowMapper<User> rowMapper = new RowMapper<User>(){
//		@Override
//		public User mapRow(ResultSet rs,int rowNo) throws SQLException{
//			User user = new User();
//			user.setUid(rs.getInt("id"));
//			user.setName(rs.getString("name"));
//			user.setEmail(rs.getString("email"));
//			return user;
//		}
//	};
//	
//	
//	@Override
//	public void addUser(User user) {
//		String query = "insert into student(name,email) values(?,?)";
//		jdbcTemplate.update(query, user.getName(),user.getEmail());
//	}
//	
//	@Override
//	public void updateUser(User user) {
//		String query = "update student set name=? where id=?";
//		jdbcTemplate.update(query,user.getName(),user.getUid());
//	}
//	
//	@Override
//	public void deleteUser(int userId) {
//		String query = "delete from student where id=?";
//		jdbcTemplate.update(query,userId);
//	}
//	
//	@Override
//	public User getById(int userId) {
//		String query = "select * from student where id=?";
//		return jdbcTemplate.queryForObject(query, rowMapper, userId);
//	}
//	
//	@Override
//	public List<User> getAllUser(){
//		String query = "select * from student";
//		return jdbcTemplate.query(query, rowMapper);
//	}
//}

// ################### NamedParameterJdbcTemplate ##################

package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	RowMapper<User> rowMapper = new RowMapper<User>(){
		@Override
		public User mapRow(ResultSet rs,int rowNo) throws SQLException{
			User user = new User();
			user.setUid(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			return user;
		}
	};
	
	
	@Override
	public void addUser(User user) {
		String query = "insert into student(name,email) values(:name,:email)";
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", user.getName());
		param.put("email", user.getEmail());
		npjt.update(query, param);
	}
	
	@Override
	public void updateUser(User user) {
		String query = "update student set name=:name where id=:id";
		MapSqlParameterSource msps = new MapSqlParameterSource()
				.addValue("name", user.getName())
				.addValue("id", 1);
		npjt.update(query,msps);
	}
	
	@Override
	public void deleteUser(int userId) {
		String query = "delete from student where id=:id";
		MapSqlParameterSource msps = new MapSqlParameterSource("id",userId);
		npjt.update(query,msps);
	}
	
	@Override
	public User getById(int userId) {
		String query = "select * from student where id=:id";
		MapSqlParameterSource msps = new MapSqlParameterSource("id",userId);
		return npjt.queryForObject(query, msps, rowMapper);
	}
	
	@Override
	public List<User> getAllUser(){
		String query = "select * from student";
		return npjt.query(query, rowMapper);
	}
}