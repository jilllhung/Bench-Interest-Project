package com.jill.benchinterest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jill.benchinterest.models.Experiment;

@Repository
public interface ExpRepository extends JpaRepository<Experiment, Long>{
	// JPA Repository supports delete records in a batch
	List<Experiment> findAll();
}