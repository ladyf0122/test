package cn.ladyf.service;

import java.util.List;

import cn.ladyf.domain.Employee;

public interface IEmployeeService {

	void save(Employee e);

	void update(Employee e);

	void delete(Long id);

	Employee get(Long id);

	List<Employee> listAll();

	void login(String username, String password);
}
