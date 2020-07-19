package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Feedback;
import com.springboot.service.FeedbackService;



@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService service;
	
	@org.springframework.web.bind.annotation.RequestMapping("/feedback")
	public String FeedBack(){
		return "feedback";
	}
	
//to list all the stored feedbacks
	@GetMapping("/feedback-list")
	public Iterable<Feedback> list(){
		return service.listAll();
	}

	@PostMapping("/add-feedback")
	public String addFeedback(@RequestParam ("name")String name,@RequestParam ("email") String email,@RequestParam("facultyName") String facultyName, @RequestParam ("comment") String comment, @RequestParam("rating") int rating){
			Feedback fb = new Feedback(name,email,facultyName,comment,rating);
			boolean data = service.save(fb);
			
			if(data)
				return "Feedback saved Successfully";

			else
				return "Oops.. Try again";
	
}


}