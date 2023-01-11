package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dto.ChartData;
import com.example.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " + 
			"FROM project " + 
			"GROUP BY stage")
	public List<ChartData> getProjectStatus(); 
}


//@Query(nativeQuery=true, value="""
//
//SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount
//FROM employee e left join project_employee pe 
//ON pe.employee_id = e.employee_id 
//GROUP BY e.first_name, e.last_name ORDER BY 3 DESC""")