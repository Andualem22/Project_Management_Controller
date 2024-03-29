package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProjectRepository;
import com.example.dto.ChartData;
import com.example.dto.TimeChartData;
import com.example.entities.Project;

@Service
public class ProjectService {
	
	@Autowired	
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll(){
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}

	public Project findByProjectId(long projectId) {
		// TODO Auto-generated method stub
		return proRepo.findByProjectId(projectId);
	}

	public void delete(Project theProject) {
		proRepo.delete(theProject);
		
	}
	
	public List<TimeChartData> getTimeData() {
		return proRepo.getTimeData();
	}
}
