package cn.ladyf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.ladyf.dao.IEmployeeDAO;
import cn.ladyf.domain.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO{

	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public void save(Employee employee) {
		jdbctemplate.update("insert into employee(username,password,age,hiredate) values (?,?,?,?)", 
				employee.getUsername(), employee.getPassword(), employee.getAge(), employee.getHiredate());
	}

	public void update(Employee employee) {
		jdbctemplate.update("update employee set username=?,password=?,age=?,hiredate=? where id = ?", 
				employee.getUsername(), employee.getPassword(), employee.getAge(), employee.getHiredate(), employee.getId());
	}

	public void delete(Long id) {
		jdbctemplate.update("delete from employee where id = ?", id);
	}

	public Employee get(Long id) {
		List<Employee> list = jdbctemplate.query("select id,username,password,age,hiredate from employee where id = ?", new Object[] {id}, new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setAge(rs.getInt("age"));
				employee.setHiredate(rs.getDate("hiredate"));
				return employee;
			}
		});
		return list.size() == 1 ? list.get(0) : null;
	}

	public List<Employee> listAll() {
		return jdbctemplate.query("select id,username,password,age,hiredate from employee", new Object[] {}, new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setAge(rs.getInt("age"));
				employee.setHiredate(rs.getDate("hiredate"));
				return employee;
			}
			
		});
	}

	public Employee checkLogin(String username, String password) {
		List<Employee> list = jdbctemplate.query("select id,username,password,age,hiredate from employee where username = ? and password = ?", 
				new Object[] {username,password}, new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setAge(rs.getInt("age"));
				employee.setHiredate(rs.getDate("hiredate"));
				return employee;
			}
		});
		return list.size() == 1 ? list.get(0) : null;
	}

}
