package cn.ladyf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ladyf.dao.IEmployeeDAO;
import cn.ladyf.domain.Employee;
import cn.ladyf.service.IEmployeeService;
import cn.ladyf.util.UserContext;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeDAO dao;

	public void save(Employee e) {
		dao.save(e);
	}

	public void update(Employee e) {
		dao.update(e);
	}

	public void delete(Long id) {
		dao.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Employee get(Long id) {
		return dao.get(id);
	}

	@Transactional(readOnly=true)
	public List<Employee> listAll() {
		return dao.listAll();
	}

	@Transactional(readOnly=true)
	public void login(String username, String password) {
		Employee current = dao.checkLogin(username,password);
		if(current == null) {
			throw new RuntimeException("’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°");
		}
		UserContext.setCurrentUser(current);
	}

}
