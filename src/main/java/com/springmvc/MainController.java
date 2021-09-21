package com.springmvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	

	@ResponseBody
	@RequestMapping("/test")
	public String test() {
		return "index";
	}

	@RequestMapping("/form1")
	public String form1() {
		return "form1";
	}

	@RequestMapping("/form2")
	public String form2() {
		return "form2";
	}

	@RequestMapping(value = "/formreq1", method = RequestMethod.POST)
	public String formreq1(Model model, User user) {

		model.addAttribute("fname", user.getFname());
		model.addAttribute("lname", user.getLname());

		return "output1";
	}

	@RequestMapping(value = "/formreq2", method = RequestMethod.GET)
	public String formreq2(@RequestParam("fname") String fname, @RequestParam("lname") String lname, Model model) {

		model.addAttribute("fname", fname);
		model.addAttribute("lname", lname);

		return "output1";
	}

	@RequestMapping("/form3")
	public String display(Model m) {
		m.addAttribute("emp", new Employee());
		return "form3";
	}	

	@RequestMapping("/formreq3")
	public String submitForm(@Valid @ModelAttribute("emp") Employee e, BindingResult br) {
		
		
		if (br.hasErrors()) {
			return "form3";
		} else {
			return "output2";
		}
	}


	//Query Param
	
	@ResponseBody
	@RequestMapping("/user/{username}/{city}")
	public String userUsername(@PathVariable String username,@PathVariable String city) {
		return "Username is "+username+"city is "+city;
	}	

}
