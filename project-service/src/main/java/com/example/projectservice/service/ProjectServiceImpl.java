package com.example.projectservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectservice.model.Project;
import com.example.projectservice.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectRepository projectRepo;

	@Override
	public Project save(Project pro) {
		// TODO Auto-generated method stub
		return projectRepo.save(pro);
	}

	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if (projectRepo.findById(id).isPresent()) {
			projectRepo.deleteById(id);
		}
	}

	@Override
	public Project getById(Long id) {
		// TODO Auto-generated method stub

		Optional<Project> pro = projectRepo.findById(id);
		return pro.get();
	}

	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		projectRepo.save(project);
	}

}
