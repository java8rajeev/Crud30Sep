package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.repo.IEmployeeRepo;
import com.app.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public Integer saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		return repo(emp).getEmpId();
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Employee> getOneEmp(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
	}

	@Override
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public boolean isPresent(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

}
