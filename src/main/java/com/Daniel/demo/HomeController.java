package com.Daniel.demo;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	// Home page  -show from
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	
	 // ->Receives from data
//	  @RequestMapping("/submit")
//	  public String submit(@RequestParam String uname, Model model) {
//		       model.addAttribute("name" ,uname);
//		       return "result";
	//  }
	
	//ModelAndView way!
	
	@RequestMapping("/submit")
	   
	public ModelAndView submit(@RequestParam  String uname)
	{
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("name", uname);
	    mv.setViewName("result");
	    return mv;
	    
	}
	
}
