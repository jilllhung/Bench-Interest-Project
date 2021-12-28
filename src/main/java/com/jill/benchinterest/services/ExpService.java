package com.jill.benchinterest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jill.benchinterest.models.Experiment;
import com.jill.benchinterest.repositories.ExpRepository;

@Service
public class ExpService {
	@Autowired
	private ExpRepository expRepo;
	
	//Get Exp
	public List<Experiment> getAllExps(){
		return expRepo.findAll();
	}
	
	public Experiment getExp(Long id) {
		Optional<Experiment> opExp = expRepo.findById(id);
		return opExp.orElse(null);
	}
	
	//Create New Exp
	public Experiment createExp(Experiment exp) {
		return expRepo.save(exp);
	}
	
	//Update Exp
	
	
	//Delete Exp
}
