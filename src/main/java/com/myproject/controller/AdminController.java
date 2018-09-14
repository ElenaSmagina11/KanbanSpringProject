package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class AdminController {

	// Configurated In ApplicationContextConfig.
	@Autowired
	private ResourceBundleMessageSource messageSource;

	// GET: Show Login Page
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginGet(Model model) {

		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String loginPost(Model model) {

		return "login";
	}

	@RequestMapping(value = { "/accountInfo" }, method = RequestMethod.GET)
	public String accountInfo(Model model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetails.getPassword());
		System.out.println(userDetails.getUsername());
		System.out.println(userDetails.isEnabled());
		model.addAttribute("userDetails", userDetails);
		return "accountInfo";
	}

	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String indexPage(Model model) {
		return "index";
	}

}