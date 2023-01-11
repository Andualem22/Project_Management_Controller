//package com.example.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.dao.UserAccountRepository;
//import com.example.entities.UserAccount;
//
//@Controller
//public class SecurityController {
//
//	@Autowired
//	UserAccountRepository accountRepo;
//	
//	@Autowired
//	BCryptPasswordEncoder bCryptEncoder;
//	
//	
//	@GetMapping("/register")
//	public String register(Model model) {
//		UserAccount userAccount = new UserAccount();
//		model.addAttribute("userAccount", userAccount);
//		
//		return "security/register";
//	}
//	
//	@PostMapping("/register/save")
//	public String saveUser(Model model, UserAccount user) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String encodedPassword = encoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//		accountRepo.save(user);
//		
//		return "security/register_success";
//	}
//	
//	@GetMapping("/list_users")
//	public String viewUsersListing(Model model) {
//		List<UserAccount> listUsers = (List<UserAccount>) accountRepo.findAll();
//		model.addAttribute("listUsers", listUsers);
//		
//		return "security/users";
//	}
//}
