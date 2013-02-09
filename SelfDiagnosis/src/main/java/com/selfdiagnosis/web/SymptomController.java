package com.selfdiagnosis.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.selfdiagnosis.core.dao.BodyPartDAO;
import com.selfdiagnosis.core.dao.SymptomDAO;
import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.SymptomEntity;

@Controller
public class SymptomController {
	@Autowired
	private BodyPartDAO bodyPartDAO;

	@Autowired
	private SymptomDAO symptomDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(BodyPartEntity.class, new BodyPartEditor(bodyPartDAO));
	}
	
	@ModelAttribute("bodyParts")
	public List<BodyPartEntity> findAllBodyParts() {
		return bodyPartDAO.findAll(); 
	}
	
	@RequestMapping(value = "/symptom", method = RequestMethod.GET)
	public String addNewSymptom(Model model)  {
		SymptomEntity symptom = new SymptomEntity();
		model.addAttribute("symptom", symptom);
		return "symptom";
	}
	
	@RequestMapping(value = "/symptom", method = RequestMethod.POST)
	public String saveSymptom(@Valid @ModelAttribute("symptom") SymptomEntity symptom, BindingResult result) {
		if (result.hasErrors()) {
			return "editSymptom";
		}
		symptomDAO.saveOrUpdate(symptom);
		return "symptom";
	}

}
