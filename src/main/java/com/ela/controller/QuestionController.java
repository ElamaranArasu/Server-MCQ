package com.ela.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ela.Questions;
import com.ela.User;
import com.ela.Dto.Authenticated;
import com.ela.Dto.login;
import com.ela.Service.PSService;
import com.ela.repo.PsRepo;

@CrossOrigin(origins = "*")
@RestController
public class QuestionController {
	@Autowired
	PsRepo repo;
	
	@Autowired
	PSService ps;
	
	@RequestMapping("/{no}")
	public Iterable<Questions> questionList(@PathVariable int no)
	{	
		int value1=((no-1)*10)+1;
		int value2=no*10;
		//System.out.println(Thread.currentThread());
		System.out.println(value1+"  "+ value2);
		return repo.find(value1, value2);
	}
	
	@PostMapping("/login")
	public Authenticated login(@RequestBody login lg) {
				return ps.autentication(lg);
	}
	
	@PostMapping("/signup")
	public boolean signup(@RequestBody User us){
		
		return ps.signupService(us);
	}
	
	@CrossOrigin
	@PostMapping("/question")
	public Iterable<Questions> question(@RequestBody Authenticated au)
	{	
		if(ps.isAuthentic(au)) {
			System.out.println("Questins ......");
			return repo.findAll();
		}
		System.out.println("Failed");
		return null;
	}
	
	@PostMapping("/question/{no}")
	public Iterable<Questions> questionSet(@RequestBody Authenticated au,@PathVariable int no)
	{	
		if(ps.isAuthentic(au)) {
			int value1=((no-1)*10)+1;
			int value2=no*10;
			//System.out.println(Thread.currentThread());
			//System.out.println(value1+"  "+ value2);
			return repo.find(value1, value2);
		}
		System.out.println("Failed");
		return null;
	}
}