package com.example.projectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectservice.model.Project;
import com.example.projectservice.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectservice;

	@PostMapping("/projects")
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		projectservice.save(project);

		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}

	@GetMapping("/projects")
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectservice.getAll();

		return new ResponseEntity<>(projects, HttpStatus.OK);

	}

	@DeleteMapping("/projects/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable(value = "id") Long id) {
		projectservice.delete(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

	}

	@GetMapping("/projects/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<Object>(projectservice.getById(id), HttpStatus.OK);
	}

	@PutMapping("/projects/{id}")
	public ResponseEntity<Project> updateProject(@RequestBody Project project, @PathVariable(name = "id") Long id) {
		Project pro = projectservice.getById(id);
		if (pro != null) {
			projectservice.updateProject(project);
		}
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

}
