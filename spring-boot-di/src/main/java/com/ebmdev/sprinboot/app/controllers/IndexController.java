package com.ebmdev.sprinboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ebmdev.sprinboot.app.models.services.IndexService;

@Controller
public class IndexController {

	@Autowired
	@Qualifier("indexServiceImpl")
	private IndexService indexService;

	@GetMapping({ "/", "", "/index" })
	public String index(Model model) {
		model.addAttribute("objeto", indexService.ejemplo());
		return "index";
	}

}
