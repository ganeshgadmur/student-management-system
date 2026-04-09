package com.Daniel.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	
	// Showing from
	@RequestMapping("/student")
	
	public String student(Model model) {
		List<Student> list = repo.findAll();
		model.addAttribute("students" , list);
		return "student";
	}
	
	@RequestMapping("/findStudent")
	public String findStudent(
			@RequestParam int sid,
			Model model
			
			) {
		
		Optional<Student> optional = repo.findById(sid);
		
		if(optional.isPresent()) {	
			Student s = optional.get();
			    model.addAttribute("student" , s);
	         	}
	      	else {
			throw new StudentNotFoundException("student not found with ID" + sid);
		} 
		
		List<Student> list = repo.findAll();         
	    model.addAttribute("students", list);          
	   
		return "student";
	}
	
	@RequestMapping("/findByName")
	public String findByName(@RequestParam String sname,
			Model model) {
		
		List<Student> list = repo.findByName(sname);
		
		model.addAttribute("students", list);
		return "student";
	}
	
	// Show edit form
	@RequestMapping("/editStudent")
	public String editStudent(
	        @RequestParam int sid,
	        Model model) {

	    Student s = repo.findById(sid).get();
	 
	    
	    model.addAttribute("student", s);
	    List<Student> list = repo.findAll();
	    model.addAttribute("students", list);
	    return "student";
	}

	// Save updated student
	@RequestMapping("/updateStudent")
	public String updateStudent(
	        @RequestParam int id,
	        @RequestParam String name,
	        @RequestParam String email,
	        Model model) {

	    Student s = repo.findById(id).get();
	    s.setName(name);
	    s.setEmail(email);
	    repo.save(s);

	    List<Student> list = repo.findAll();
	    model.addAttribute("students", list);
	    model.addAttribute("message",
	        "Student Updated Successfully!");
	    return "student";
	}
	
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int sid,
			Model model) {
		repo.deleteById(sid);
		
		List<Student> list = repo.findAll();
		model.addAttribute("students", list);
		model.addAttribute("message" , "Student Deleted Successfully!");
		return "student";
	}

	@RequestMapping("/saveStudent")
	
	public String saveStudent(
			@Valid Student s,
			BindingResult result,
			Model model)
	
	{
		if(result.hasErrors()) {
			if(result.getFieldError("name") !=null){
				model.addAttribute("nameError",
						result.getFieldError("name")
						.getDefaultMessage());
			}
			
			if(result.getFieldError("email") !=null) {
				model.addAttribute("emailError",
						result.getFieldError("email")
						.getDefaultMessage());
			}
		
		
		List<Student> list = repo.findAll();
		model.addAttribute("students" , list);
		return "student";
		}
		
		repo.save(s);
		List<Student> list = repo.findAll();
		model.addAttribute("students" , list);
		
		model.addAttribute("message", "Student Saved Successfully!");
		
		return "student";	
		
	}

}
