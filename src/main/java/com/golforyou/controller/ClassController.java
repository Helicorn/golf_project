package com.golforyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.golforyou.service.ClassService;

@Controller
public class ClassController {

	@Autowired
	private ClassService classService;
	
	
}
