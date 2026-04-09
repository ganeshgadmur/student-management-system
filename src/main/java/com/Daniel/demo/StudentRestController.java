package com.Daniel.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
	 
	 
	 @Autowired
	 StudentRepository repo;
	 
	 @GetMapping("/api/students")
	 
	 public List<Student> getStudents(){
		 return repo.findAll();
	 }
	 
	 @GetMapping("/api/students/{id}")
	 public Student getStudent(@PathVariable int id) {
		 return repo.findById(id).get();
	 }
	 @PostMapping("/api/students")
	 public Student addStudent(@RequestBody Student s) {
		 return repo.save(s);
	 }
	 
	 @DeleteMapping("/api/students/{id}")
	 public String deleteStudent(@PathVariable int id) {
		 repo.deleteById(id);
		 return "Student Delete Successfully";
	 }

}
