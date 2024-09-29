package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.Employee;

public interface IEmployeeService {
	
	Integer saveEmp(Employee emp);
	List<Employee> getAllEmp();
	Optional<Employee> getOneEmp(Integer id);
	void updateEmp(Employee emp);
	void deleteEmp(Integer id);
	boolean isPresent(Integer id);

}
