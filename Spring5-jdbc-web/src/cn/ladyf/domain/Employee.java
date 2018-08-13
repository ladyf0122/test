package cn.ladyf.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	private Long id;
	private int age;
	private String password;
	private String username;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date hiredate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", password=" + password + ", username=" + username
				+ ", hiredate=" + hiredate + "]";
	}
	
	
}
