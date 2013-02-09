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
import com.selfdiagnosis.core.entity.BodyPartEntity;

@Controller
public class BodyPartController {
	
	@Autowired
	private BodyPartDAO bodyPartDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(BodyPartEntity.class, new BodyPartEditor(bodyPartDAO));
	}
	
	@ModelAttribute("bodyParts")
	public List<BodyPartEntity> findAllBodyParts() {
		return bodyPartDAO.findAll(); 
	}
	
	@RequestMapping(value = "/bodyPart", method = RequestMethod.GET)
	public String create(Model model)  {
		BodyPartEntity bodyPart = new BodyPartEntity();
		model.addAttribute("bodyPart", bodyPart);
		return "bodyPart";
	}
	
	@RequestMapping(value = "/bodyPart", method = RequestMethod.POST)
	public String saveBodyPart(@Valid @ModelAttribute("bodyPart") BodyPartEntity bodyPart, BindingResult result) {
		if (result.hasErrors()) {
			return "bodyPart";
		}
		bodyPartDAO.saveOrUpdate(bodyPart);
		return "bodyPart";
	}
}
