package com.example.projectservice.service;

import java.util.List;

import com.example.projectservice.model.Project;

public interface ProjectService {

	Project save(Project project);

	List<Project> getAll();

	void delete(Long id);

	Project getById(Long id);

	void updateProject(Project project);

}
