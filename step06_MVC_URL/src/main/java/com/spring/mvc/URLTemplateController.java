package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class URLTemplateController {

//	http://localhost:8080/mvc/urlTest.do/1
//	@GetMapping(value = "urlTest.do/{id}")
//	public String urlTest1(@PathVariable int id) {
//		System.out.println("value - " + id);
//		return "forward:../view.jsp";
//	}

	// Model API 활용하기
//	http://localhost:8080/mvc/urlTest.do/1/home/27 -> id/age -> view.jsp
	@GetMapping(value = "urlTest.do/{id}/home/{age}")
//	public String urlTest2(@PathVariable int id, @PathVariable int age) {
	public String urlTest2(@ModelAttribute("id") int id, @ModelAttribute("age") int age) {
		System.out.println("value - " + id + " - " + age);
		return "forward:/view.jsp";
	}

}
