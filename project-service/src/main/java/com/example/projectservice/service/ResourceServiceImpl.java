package com.example.projectservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectservice.model.Resource;

import com.example.projectservice.repository.ResourceRepository;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	ResourceRepository resourceRepo;

	@Override
	public Resource save(Resource res) {
		// TODO Auto-generated method stub
		return resourceRepo.save(res);
	}

	@Override
	public List<Resource> getAll() {
		// TODO Auto-generated method stub
		return resourceRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if (resourceRepo.findById(id).isPresent()) {
			resourceRepo.deleteById(id);
		}
	}

	@Override
	public Resource getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Resource> res = resourceRepo.findById(id);
		return res.get();
	}

	@Override
	public void updateResource(Resource resource) {
		// TODO Auto-generated method stub
		resourceRepo.save(resource);
	}

}
