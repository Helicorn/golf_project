package com.golforyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golforyou.dao.ClassDAO;

@Service
public class ClassServiceImpl implements ClassService {

	//@Autowired
	private ClassDAO classDAO;
}
