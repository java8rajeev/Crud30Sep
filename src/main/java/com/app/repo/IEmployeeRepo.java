package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;
@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer>{

}
