package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("entity")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/user")
	public List<User> findAll() {
		return userRepository.findAll();
	}
	@GetMapping(value = "/user/{id}")
	public Optional<User> findOne(@PathVariable int id) {
		return userRepository.findById(id);
	}

	@PostMapping(value = "/user")
	public User add(@RequestParam("fileData") MultipartFile file, @RequestParam("address") String address, @RequestParam("age") int age) throws IOException {
		User user = new User();
		user.setAddress(address);
		user.setAge(age);
		user.setFileData(file.getBytes());
//		System.out.println(file.getBytes().hashCode());
//		byte[] bFile = new byte[(int) file.length()];
		return userRepository.saveAndFlush(user);
	}
	
	@PutMapping(value="/user")
	public ResponseEntity<Object> update(@PathVariable int id, @RequestBody User user) {
		Optional<User> updateUser = userRepository.findById(id);
		if (!updateUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		user.setId(id);
		userRepository.save(user);
		return null;
	}
	
	@DeleteMapping(value="/user/{id}")
	public void delete(@PathVariable int id) {
		userRepository.deleteById(id);
	}
}
