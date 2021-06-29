package com.cg.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.dao.UserRepo;
import com.cg.springboot.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Override
	public void register(User user) {
		
		userRepo.save(user);
		
	}

}
