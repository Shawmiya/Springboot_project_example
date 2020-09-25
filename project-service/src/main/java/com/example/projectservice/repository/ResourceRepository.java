package com.example.projectservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectservice.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
