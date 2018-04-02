package com.example.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	private static final Logger LOGGER = LogManager.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getOne(int id) {
		return userRepository.getOne(id);
	}

	public boolean add(User user) {
		LOGGER.debug("add user instance");
		try {
			userRepository.save(user);
			LOGGER.debug("add successfull");
			return true;
		} catch (RuntimeException e) {
			// TODO: handle exception
			LOGGER.error("add failed", e);
			return false;
		}
	}

	public boolean edit(User user) {
		LOGGER.debug("edit User instance");
		try {
			userRepository.saveAndFlush(user);
			LOGGER.debug("edit successful");
			return true;
		} catch (RuntimeException e) {
			// TODO: handle exception
		LOGGER.error("edit failed", e);
		return false;
		}
	}
	
	
	public boolean deleteById(int id) {
		LOGGER.debug("delete User instance");
		try {
			userRepository.deleteById(id);
			LOGGER.debug("delete successfull");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("deleted failed", e);
			return false;
		}
	}
	
}
