package com.merini.agendaspring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public String homePage()
	{
		return "index";
	}
}
