package com.spring.intro;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.intro.model.Student;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
//	http://localhost:8080/intro/mappingTest1?name=busan&age=29
	@RequestMapping(value = "/mappingTest1", method = RequestMethod.GET)
	public String mappingTest1(Student student) {
		logger.info("" + student);
		return "mappingTest1";
	}
	
//	http://localhost:8080/intro/mappingTest2?name=busan&age=29
	@RequestMapping(value = "/mappingTest2", method = RequestMethod.GET)
	public String mappingTest2(@RequestParam("name") String name, @RequestParam("age") int age) {
		logger.info("" + name);
		logger.info("" + age);
		return "mappingTest2";
	}
	
//	http://localhost:8080/intro/mappingTest3?values=1&values=2
		@RequestMapping(value = "/mappingTest3", method = RequestMethod.GET)
		public String mappingTest3(@RequestParam("values") ArrayList<String> values) {
			logger.info("" + values);
			return "mappingTest3";
	}
		
//	http://localhost:8080/intro/mappingTest4?name=busan&age=29&studentNumber=1
		@RequestMapping(value = "/mappingTest4", method = RequestMethod.GET)
//		public String mappingTest4(Student student, int studentNumber) {
		public String mappingTest4(Student student, @ModelAttribute("studentNumber") int studentNumber) { // jsp ??? ????????? ?????? @ModelAttribute
			logger.info("" + student);
			logger.info("" + studentNumber);
			return "mappingTest4";
		}
		
		// Controller??? ?????? ??????
		/*
		 * String : jsp????????? ????????? ??????
		 * void : ???????????? URL??? ????????? ????????? jsp
		 * VO, DTO : JSON ????????? ????????? ??????
		 * ResponseEntity : ????????? HTTP ?????? ??????
		 * Model, ModelAndView : ????????? ??????????????? ???????????? ???????????? ??????
		 * HttpHeaders : ?????? ?????? ?????? HTTP ?????? ???????????? ??????????????? ??????
		 */
		
//		http://localhost:8080/intro/mappingTest5
		@RequestMapping(value = "/mappingTest5", method = RequestMethod.GET)
		public void mappingTest5() {}
		
//		http://localhost:8080/intro/mappingTest6
		@RequestMapping(value = "/mappingTest6", method = RequestMethod.GET)
		public @ResponseBody Student mappingTest6() {
			Student student = new Student("busan", 29);
			logger.info(""+ student);
			
			return student;
		}
		
		@RequestMapping(value = "mappingTest7")
		public ResponseEntity<String> mappingTest7() {
			String data = "{\"name\" : \"busan\"}";
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json;charset=UTF-8");
			logger.info(""+headers);
			
			return new ResponseEntity<String>(data, headers, HttpStatus.OK);
		}
		
}
