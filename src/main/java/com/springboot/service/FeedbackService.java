package com.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MyRepo;
import com.springboot.model.Feedback;

@Service
public class FeedbackService {
	@Autowired
	private MyRepo repo;
	
	
public FeedbackService(MyRepo repo) {
		super();
		this.repo = repo;
	}


	public boolean save(Feedback fb) {
		repo.save(fb);
		return true;
		
	}

	public Iterable<Feedback> listAll(){
		return repo.findAll();
	}

}



