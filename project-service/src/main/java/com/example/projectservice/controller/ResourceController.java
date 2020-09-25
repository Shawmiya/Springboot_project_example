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

import com.example.projectservice.model.Resource;
import com.example.projectservice.service.ResourceService;

@RestController
public class ResourceController {

	@Autowired
	ResourceService resourceservice;

	@PostMapping("/resources")
	public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
		resourceservice.save(resource);

		return new ResponseEntity<Resource>(resource, HttpStatus.CREATED);
	}

	@GetMapping("/resources")
	public ResponseEntity<List<Resource>> getAllResources() {
		List<Resource> resources = resourceservice.getAll();

		return new ResponseEntity<>(resources, HttpStatus.OK);

	}

	@DeleteMapping("/resources/{id}")
	public ResponseEntity<String> deleteResorce(@PathVariable(value = "id") Long id) {
		resourceservice.delete(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

	}

	@GetMapping("/resources/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<Object>(resourceservice.getById(id), HttpStatus.OK);
	}

	@PutMapping("/resources/{id}")
	public ResponseEntity<Resource> updateResource(@RequestBody Resource resource, @PathVariable(name = "id") Long id) {
		Resource res = resourceservice.getById(id);
		if (res != null) {
			resourceservice.updateResource(resource);
		}
		return new ResponseEntity<Resource>(resource, HttpStatus.OK);
	}

}
