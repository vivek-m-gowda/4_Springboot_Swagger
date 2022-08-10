package com.example.springbootswagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootswagger.exception.ResourceNotFoundException;
import com.example.springbootswagger.model.Employee;
import com.example.springbootswagger.repository.EmployeeRepository;

@RestController
@RequestMapping(path= "/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employee
	@GetMapping("/AllEmployees")
	public List<Employee> getAllEmployees(){
		return this.employeeRepository.findAll();
	}
	
	//get employee by id
	@GetMapping("/GetEmployeeById/{id}")
	public Employee getEmployeeById (@PathVariable (value = "id") long employeeId) {
		
		return this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + employeeId));
		
	}
	
	//create employee
	@PostMapping("/Save")
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	//update employee
	@PutMapping("/Update/{id}")
	public Employee updatEmployee (@RequestBody Employee employee, @PathVariable ("id") long employeeId) {
		Employee existingEmployee = this.employeeRepository.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id :" +employeeId));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		return this.employeeRepository.save(existingEmployee);
	}
	
	//delete employee
	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<String> deleteEmpoyee(@PathVariable ("id") long employeeId){
		Employee existingEmployee = this.employeeRepository.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id :" +employeeId));
		this.employeeRepository.delete(existingEmployee);
		return ResponseEntity.ok("1 row deleted");
		//return ResponseEntity.ok().build();
		
	}
}
