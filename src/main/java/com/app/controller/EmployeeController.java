package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmp(Employee emp){
		ResponseEntity<String> rsp=null;
		try {
		Integer id=service.saveEmp(emp);
		String msg="employee saved with this '"+id+"' number";
		rsp=new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}catch(Exception e) {
		rsp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		e.printStackTrace();
		}
		return rsp;
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmp(@PathVariable("id") Integer id,@RequestBody Employee emp){
		ResponseEntity<String> rsp=null;
		boolean present=service.isPresent(id);
		if(present) {
		service.updateEmp(emp);
		rsp=new ResponseEntity<String>("emp '"+id +"' updated successfullyu",HttpStatus.OK);
		}else {
		rsp=new ResponseEntity<String>("emp '"+id +"' not exist",HttpStatus.BAD_REQUEST);
		}
		return rsp;
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Integer id){
		ResponseEntity<String> rsp=null;
		boolean present=service.isPresent(id);
		if(present) {
		service.deleteEmp(id);
		rsp=new ResponseEntity<String>("emp '"+id +"' deleted successfullyu",HttpStatus.OK);
		}else {
		rsp=new ResponseEntity<String>("emp '"+id +"' not exist",HttpStatus.BAD_REQUEST);
		}
		return rsp;
		
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> rsp=null;
		List<Employee> list=service.getAllEmp();
		if(list.isEmpty()||list==null) {
		rsp=new ResponseEntity<String>("emp list is empty ",HttpStatus.BAD_REQUEST);
		}else {
		rsp=new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		}
		return rsp;
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<?> getOneEmp(@PathVariable("id") Integer id){
		ResponseEntity<?> rsp=null;
		boolean present=service.isPresent(id);
		if(present) {
		Optional<Employee> emp=service.getOneEmp(id);
		rsp=new ResponseEntity<Optional<Employee>>(emp,HttpStatus.OK);
		}else {
		rsp=new ResponseEntity<String>("emp with '"+id+"' not found",HttpStatus.BAD_REQUEST);
		}
		return rsp;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
