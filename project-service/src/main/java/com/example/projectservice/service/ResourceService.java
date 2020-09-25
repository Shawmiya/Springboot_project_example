package com.example.projectservice.service;

import java.util.List;

import com.example.projectservice.model.Resource;

public interface ResourceService {

	Resource save(Resource resource);

	List<Resource> getAll();

	void delete(Long id);

	Resource getById(Long id);

	void updateResource(Resource resource);
}
