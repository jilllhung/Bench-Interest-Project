package com.jill.benchinterest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jill.benchinterest.models.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long>{
	
}
