package com.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.myproject.dao.AccountDAO;
import com.myproject.dao.DeveloperDAO;
import com.myproject.dao.EmployerDAO;
import com.myproject.dao.KanbanDAO;
import com.myproject.entity.Kanban;
import com.myproject.model.AccountInfo;
import com.myproject.model.DeveloperInfo;
import com.myproject.model.EmployerInfo;
import com.myproject.model.KanbanInfo;
import com.myproject.model.PaginationResult;
import com.myproject.validator.AccountInfoValidator;
import com.myproject.validator.DeveloperInfoValidator;
import com.myproject.validator.EmployerInfoValidator;
import com.myproject.validator.KanbanInfoValidator;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class MainController {

	@Autowired
	private EmployerDAO employerDAO;

	@Autowired
	private DeveloperDAO developerDAO;

	@Autowired
	private KanbanDAO kanbanDAO;

	@Autowired
	private AccountDAO accountDAO;

	private String jobName;

	@RequestMapping("/403")
	public String accessDenied() {
		return "/403";
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/toDo")
	public String toDo() {
		return "toDo";
	}
	// NEW ACCOUNT
	@RequestMapping(value = { "/account" }, method = RequestMethod.GET)
	public String account(Model model,
			@RequestParam(value = "userName", defaultValue = "") String userName)

	{
		AccountInfo accountInfo = null;
		if (accountInfo == null) {
			accountInfo = new AccountInfo();
			accountInfo.setNewAccount(true);
			accountInfo.setIsActiv(true);
		}
		accountInfo.setIsActiv(true);
		model.addAttribute("accountForm", accountInfo);
		System.out.println("accountInfo.getUserName()v GET:"
				+ accountInfo.getUserName());
		return "account";
	}

	@RequestMapping(value = { "/account" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String accountSave(Model model,
			@ModelAttribute("accountForm") @Validated AccountInfo accountInfo,
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "account";
		}
		try {
			System.out.println("accountInfo.getUserName() iz POST:"
					+ accountInfo.getUserName());
			accountDAO.save(accountInfo);
			System.out.println("accountInfo.getUserRole() iz POST:"
					+ accountInfo.getUserRole());
		} catch (Exception e) {

			String message = e.getMessage();
			model.addAttribute("message", message);
			return "account";
		}
		return "redirect:/registrationFinalize";
	}

	// FOR DEVELOPER
	// employersList
	@RequestMapping({ "/employersList" })
	public String listEmployerHandler(
			Model model, //
			@RequestParam(value = "city", defaultValue = "") String likeCity,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 5;
		final int maxNavigationPage = 10;
		PaginationResult<EmployerInfo> result = employerDAO.queryEmployer(page, //
				maxResult, maxNavigationPage, likeCity);
		model.addAttribute("paginationProducts", result);
		return "employersList";
	}
	// employerAccount
	@RequestMapping(value = { "/employerAccount" }, method = RequestMethod.GET)
	public String employerAccount(Model model,
			@RequestParam(value = "emplName", defaultValue = "") String emplName) {
		EmployerInfo employerInfo = null;
		if (employerInfo == null) {
			employerInfo = new EmployerInfo();
			employerInfo.setNewEmployer(true);
		}
		model.addAttribute("employerForm", employerInfo);
		return "employerAccount";
	}

	@RequestMapping(value = { "/employerAccount" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String employerAccountSave(
			Model model,
			@ModelAttribute("employerForm") @Validated EmployerInfo employerInfo,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "employerAccount";
		}
		try {
			employerDAO.save(employerInfo);
		} catch (Exception e) {
			String message = e.getMessage();
			model.addAttribute("message", message);
			System.out.println("!!!!!!!!!!!" + "exception here  599");
			return "employerAccount";
		}
		return "redirect:/registrationFinalize";
	}
	// employerChoose + devKanban
	@RequestMapping(value = { "/employerChoose" }, method = RequestMethod.GET)
	public String employeeChoose2(Model model,
			@RequestParam(value = "emplName", defaultValue = "") String emplName) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		EmployerInfo employerInfo = null;
		KanbanInfo kanbanInfo = null;

		if (emplName != null && emplName.length() > 0) {
			employerInfo = employerDAO.findEmployerInfo(emplName);
			System.out.println("employerInfo.: " + employerInfo.getEmplName());
			System.out.println("userDetails.getUsername( :"
					+ userDetails.getUsername());

			kanbanInfo = kanbanDAO.findKanbanInfo(userDetails.getUsername(),
					employerInfo.getEmplName());

			if (kanbanInfo == null) {
				kanbanInfo = new KanbanInfo();
				kanbanInfo.setNewKanban(true);
				System.out.println("kanbanInfo==null : "
						+ kanbanInfo.getUserName());
			}
			// for data kanban save
			kanbanInfo.setUserName(userDetails.getUsername());
			System.out.println("kanbanInfo.setUserName : "
					+ kanbanInfo.getUserName());
			kanbanInfo.setJobName(employerInfo.getEmplName());
			jobName = employerInfo.getEmplName();
			System.out.println("String jobName : " + jobName);
			System.out.println("kanbanInfo.getJobName : "
					+ kanbanInfo.getJobName());

			kanbanInfo.getCVDate();
			kanbanInfo.getInterviewDate();
			kanbanInfo.getJobOfferDate();
			kanbanInfo.getIsJobOffer();
			System.out.println("kanbanInfo.setCVDate : "
					+ kanbanInfo.getCVDate());
		}
		System.out.println("kanbanInfo.getJobName is GET: "
				+ kanbanInfo.getJobName());
		model.addAttribute("employerForm", employerInfo);
		model.addAttribute("kanbanForm", kanbanInfo);
		return "devkanban";
	}

	// POST devkanban
	@RequestMapping(value = { "/employerChoose" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String kanbanSave(Model model,
			@ModelAttribute("kanbanForm") @Validated KanbanInfo kanbanInfo,
			BindingResult result) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		kanbanInfo.setUserName(userDetails.getUsername());
		kanbanInfo.setJobName(jobName);

		System.out.println("userName is metoda POST "
				+ kanbanInfo.getUserName());// uber sysouti bse!!!
		System.out.println("jobName is metoda POST " + kanbanInfo.getJobName());
		System.out.println("CVDate is metoda POST " + kanbanInfo.getCVDate());

		if (kanbanInfo.getCVDate() != null) {
			System.out.println("!!! " + kanbanInfo.getCVDate().toString());
		} else {
			try {
				kanbanInfo.setCVDate(java.sql.Date.valueOf("0000-00-00"));
			} catch (Exception e) {
			}
		}
		if (kanbanInfo.getInterviewDate() != null) {
			System.out.println("!!! "
					+ kanbanInfo.getInterviewDate().toString());
		} else {
			try {
				{
					kanbanInfo.setInterviewDate(java.sql.Date
							.valueOf("0000-00-00"));
				}
			} catch (Exception e) {
			}
		}

		if (kanbanInfo.getJobOfferDate() != null) {
			System.out
					.println("!!! " + kanbanInfo.getJobOfferDate().toString());
			// kanbanInfo.setCVDate(kanbanInfo.getInterviewCompletedDate());
		} else {
			try {
				{
					kanbanInfo.setJobOfferDate(java.sql.Date
							.valueOf("0000-00-00"));
				}
			} catch (Exception e) {
			}
		}

		kanbanDAO.save(kanbanInfo);
		return "index";
	}

	// FOR EMPLOYER
	// developersList
	@RequestMapping({ "/developersList" })
	public String listDevelopersHandler(
			Model model, //
			@RequestParam(value = "city", defaultValue = "") String likeCity,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 5;
		final int maxNavigationPage = 10;
		PaginationResult<DeveloperInfo> result = developerDAO
				.queryDeveloperByCity(page, //
						maxResult, maxNavigationPage, likeCity);
		model.addAttribute("paginationProducts", result);
		return "developersList";
	}

	// GET: NEW developer
	@RequestMapping(value = { "/developerAccount" }, method = RequestMethod.GET)
	public String developerAccount(Model model,
			@RequestParam(value = "devName", defaultValue = "") String devName) {
		DeveloperInfo developerInfo = null;

		if (developerInfo == null) {
			developerInfo = new DeveloperInfo();
			developerInfo.setNewDeveloper(true);
		}
		model.addAttribute("developerForm", developerInfo);
		System.out.println("developerInfo.getDevName()v GET:"
				+ developerInfo.getDevName());
		return "developerAccount";
	}

	@RequestMapping(value = { "/developerAccount" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String developerAccountSave(
			Model model,
			@ModelAttribute("developerForm") @Validated DeveloperInfo developerInfo,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "developerAccount";
		}
		try {
			System.out.println("developerInfo.getDevName() iz POST:"
					+ developerInfo.getDevName());
			developerDAO.save(developerInfo);

		} catch (Exception e) {

			String message = e.getMessage();
			model.addAttribute("message", message);
			return "developerAccount";
		}

		return "redirect:/registrationFinalize";
	}

	// developerChoose + emplkanban
	@RequestMapping(value = { "/developerChoose" }, method = RequestMethod.GET)
	public String developerChoose(Model model,
			@RequestParam(value = "devName", defaultValue = "") String devName) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		DeveloperInfo developerInfo = null;
		KanbanInfo kanbanInfo = null;

		if (devName != null && devName.length() > 0) {
			developerInfo = developerDAO.findDeveloperInfo(devName);
			kanbanInfo = kanbanDAO.findKanbanInfo(userDetails.getUsername(),
					developerInfo.getDevName());

			if (kanbanInfo == null) {
				kanbanInfo = new KanbanInfo();
				kanbanInfo.setNewKanban(true);
				System.out.println("kanbanInfo==null : "
						+ kanbanInfo.getUserName());
			}
			// data kanban for save
			kanbanInfo.setUserName(userDetails.getUsername());
			System.out.println("kanbanInfo.setUserName : "
					+ kanbanInfo.getUserName());
			kanbanInfo.setJobName(developerInfo.getDevName());
			jobName = developerInfo.getDevName();
			kanbanInfo.getCVDate();
			kanbanInfo.getInterviewDate();
			kanbanInfo.getJobOfferDate();
			kanbanInfo.getIsJobOffer();
			System.out.println("IsJobOffe is metoda GET "
					+ kanbanInfo.getIsJobOffer());
		}
		System.out.println("kanbanInfo.getJobName is GET: "
				+ kanbanInfo.getJobName());
		model.addAttribute("developerForm", developerInfo);
		model.addAttribute("kanbanForm", kanbanInfo);
		return "emplkanban";
	}

	// POST devkanban
	@RequestMapping(value = { "/developerChoose" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String kanbanEmplSave(Model model,
			@ModelAttribute("kanbanForm") @Validated KanbanInfo kanbanInfo,
			BindingResult result) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		kanbanInfo.setUserName(userDetails.getUsername());
		kanbanInfo.setJobName(jobName);

		if (kanbanInfo.getCVDate() != null) {
			System.out.println("!!! " + kanbanInfo.getCVDate().toString());
			// kanbanInfo.setCVDate(kanbanInfo.getCVDate());
		} else {
			try {
				kanbanInfo.setCVDate(java.sql.Date.valueOf("0000-00-00"));
			} catch (Exception e) {
			}
		}

		if (kanbanInfo.getInterviewDate() != null) {
			System.out.println("!!! "
					+ kanbanInfo.getInterviewDate().toString());

		} else {
			try {
				{
					kanbanInfo.setInterviewDate(java.sql.Date
							.valueOf("0000-00-00"));
				}
			} catch (Exception e) {
			}
		}

		if (kanbanInfo.getJobOfferDate() != null) {
			System.out
					.println("!!! " + kanbanInfo.getJobOfferDate().toString());
		} else {
			try {
				{
					kanbanInfo.setJobOfferDate(java.sql.Date
							.valueOf("0000-00-00"));
				}
			} catch (Exception e) {
			}
		}
		kanbanDAO.save(kanbanInfo);
		return "index";
	}

	// FOR KANBAN
	// kanbanList
	@RequestMapping(value = { "/kanbanList" }, method = RequestMethod.GET)
	public String kanbanListHandler(Model model,
			@RequestParam(value = "userName", defaultValue = "") String userName) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		ArrayList<Kanban> kanbanInfo = kanbanDAO
				.findKanbanListByUserName(userDetails.getUsername());
		System.out.println(" !!userDetails.getUsername(): "
				+ userDetails.getUsername());
		model.addAttribute("kanbanForm", kanbanInfo);
		return "kanbanList";
	}

	// kanbanDelete
	@RequestMapping(value = { "/kanbanDelete" }, method = RequestMethod.GET)
	public String listKanbanDelete(Model model,
			@RequestParam(value = "jobName", defaultValue = "") String jobName) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		KanbanInfo kanbanInfo = kanbanDAO.findKanbanInfo(
				userDetails.getUsername(), jobName);
		kanbanDAO.remove(kanbanInfo.getUserName(), kanbanInfo.getJobName());
		return "index";
	}

	@RequestMapping(value = { "/registrationFinalize" }, method = RequestMethod.GET)
	public String shoppingCartFinalize2(HttpServletRequest request, Model model) {
		return "registrationFinalize";
	}

	// registrations info account
	@Autowired
	private AccountInfoValidator accountInfoValidator;

	// Configurated In ApplicationContextConfig.
	@Autowired
	private ResourceBundleMessageSource messageSource;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == AccountInfo.class) {
			dataBinder.setValidator(accountInfoValidator);
			// / For upload Image. fllt ubrat etu stroku
			dataBinder.registerCustomEditor(byte[].class,
					new ByteArrayMultipartFileEditor());
		}
	}

	// registrations info employer
	@Autowired
	private EmployerInfoValidator employerInfoValidator;
	// Configurated In ApplicationContextConfig.
	@Autowired
	private ResourceBundleMessageSource messageSourceEmpl; // eto nasvanie
															// metoda dla
															// employerInfo

	@InitBinder
	public void myInitBinderEmpl(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == EmployerInfo.class) {
			dataBinder.setValidator(employerInfoValidator);
			// / For upload Image.
			dataBinder.registerCustomEditor(byte[].class,
					new ByteArrayMultipartFileEditor());
		}
	}



	@Autowired
	private DeveloperInfoValidator developerInfoValidator;

	// Configurated In ApplicationContextConfig.
	@Autowired
	private ResourceBundleMessageSource messageSourceDev;

	@InitBinder
	public void myInitBinderDev(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == DeveloperInfo.class) {
			dataBinder.setValidator(developerInfoValidator);
			// / For upload Image.
			dataBinder.registerCustomEditor(byte[].class,
					new ByteArrayMultipartFileEditor());
		}
	}
}
