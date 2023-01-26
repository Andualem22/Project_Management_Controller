package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.dto.ChartData;
import com.example.dto.TimeChartData;
import com.example.entities.Project;

@RepositoryRestResource(collectionResourceRel = "apieprojects", path = "apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>{
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " + 
			"FROM project " + 
			"GROUP BY stage")
	public List<ChartData> getProjectStatus();

	public Project findByProjectId(long projectId); 
	
	@Query(nativeQuery=true, value="SELECT name as projectName, start_date as startDate, end_date as endDate " +
						"FROM project WHERE start_date is not null")
	public List<TimeChartData> getTimeData();
}