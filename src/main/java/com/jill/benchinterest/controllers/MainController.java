package com.jill.benchinterest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jill.benchinterest.models.Experiment;
import com.jill.benchinterest.models.Sample;
import com.jill.benchinterest.services.ExpService;

@Controller
public class MainController {
	
	@Autowired
	ExpService expService;
	
	@GetMapping("/")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@GetMapping("/exp/new")
	public String showNewExpForm(@ModelAttribute("exp") Experiment exp) {
		return "newexp.jsp";
	}
	
	@GetMapping("/exp/{id}")
	public String showOneExp(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
		Experiment theExp = expService.getExp(id);
		if (theExp == null) {
			redirectAttributes.addFlashAttribute("noSuchExp", "The experiment does not exist!");
			return "redirect:/exp/new";
		}
		
//		List<Sample> samplesToUse;
		
		model.addAttribute("theExp", theExp);
//		model.addAttribute("samplesToUse", samplesToUse);
		
		return "showoneexp.jsp";
	}
	
	@PostMapping("/exp/new")
	public String createNewExp(@Valid @ModelAttribute("exp") Experiment exp, BindingResult result) {
		if (result.hasErrors()) {
			return "newexp.jsp";
		}
		Experiment newExp = expService.createExp(exp);
		return "redirect:/exp/" + newExp.getId();
	}
}
