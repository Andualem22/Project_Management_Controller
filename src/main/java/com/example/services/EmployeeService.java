package com.example.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.dto.EmployeeProject;
import com.example.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired	
	EmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects(){
		return empRepo.employeeProjects();
	}

	public Employee findByEmployeeId(long theId) {
		return empRepo.findByEmployeeId(theId);
	}

	public void delete(Employee theEmp) {
		// TODO Auto-generated method stub
		empRepo.delete(theEmp);
	}
}
