package cn.ladyf.dao;

import java.util.List;

import cn.ladyf.domain.Employee;


public interface IEmployeeDAO {
	void save(Employee e);
	
	void update(Employee e);
	
	void delete(Long id);
	
	Employee get(Long id);
	
	List<Employee> listAll();

	Employee checkLogin(String username, String password);
	
}
