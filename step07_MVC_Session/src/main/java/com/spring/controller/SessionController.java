package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.domain.Customer;

@Controller
//@RequestMapping("session")
@SessionAttributes({ "job", "id", "age", "customer", "password" })
public class SessionController {

	// Cookie
	@RequestMapping("/cookieTest.do")
	public String cookieTest(@CookieValue("id") String ids) { // ids로는 원래 안되지만 "id"를 주면가
		System.out.println("Cookie : " + ids);
		return "redirect:/cookieView.jsp";
	}

	// Session
	@GetMapping("session/sessionTest1.do")
	public String sessionTest1(HttpSession session) {
//	public String stssionTest1(@SessionAttribute("id") String id, @SessionAttribute int age) {
//		System.out.println("Session - id : " + id + " age : " + age);
		System.out.println(session.getAttribute("id"));
		System.out.println(session.getAttribute("age"));
		session.setAttribute("job", "programer");
		System.out.println(session.getAttribute("job"));
		return "redirect:/sessionView1.jsp";
	}

	// job 세션 데이터 삭제
//	@GetMapping("session/jobDelete.do")
//	public String jobDelete(HttpSession session) {
//		session.removeAttribute("job");
//		return "redirect:/sessionView1.jsp";
//	}

//	강사님 코드 ---------------------------------------------------------------------------
	@GetMapping("session/jobDelete.do")

	// @ModelAttribute(지정값)
	// session 인식을 위해 상단에 @sessionAttributes(지정값) 선언해야 한다
	public String jobDelete(@ModelAttribute("job") String job, SessionStatus status) {
//		System.out.println(job);
		status.setComplete(); // session 무효화
		return "redirect:/sessionView1.jsp";
	}

	// id, age 세션 데이터 삭제
	@GetMapping("session/idAgeDelete.do")
	public String idAgeDelete(HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("age");
		return "redirect:/sessionView1.jsp";
	}

//	강사님 코드 ---------------------------------------------------------------------------
	@GetMapping("session/sessionDelete.do")
	public String sessionDelete(@ModelAttribute("id") String id, @ModelAttribute("age") int age, SessionStatus status) {
		status.setComplete(); // session 무효화
		return "redirect:/sessionView1.jsp";
	}

	@GetMapping("session/sessionTest2.do")
	public String sessionTest2DTO(Model model, Customer customer) {
		System.out.println(customer);
		model.addAttribute("customer", customer);
		return "redirect:/sessionView2.jsp";
	}

	@GetMapping("session/customerDelete.do")
	public String customerDelete(@ModelAttribute("customer") Customer customer, SessionStatus status) {
		status.setComplete(); // session 무효화
		return "redirect:/sessionView2.jsp";
	}

	@GetMapping("session/loginForm.do")
	public String moveLoginForm() {
		return "loginForm";
	}

//	------------------------------------------------------------------------------------------
//	@RequestMapping(value = "session/login.do", method = RequestMethod.POST)
////	@PostMapping("session/login.do")
//	public String login(HttpSession session, HttpServletRequest request) {
//		// 조건 : 비밀번호가 1234 일 때, admin 인정
//		// 비밀번호가 1234 가 아닐 때, index.jsp로 화면 전환
//		String inputPw = request.getParameter("password");
//		System.out.println(inputPw);
//		if (inputPw.equals("1234")) {
//			session.setAttribute("password", inputPw);
//			System.out.println("admin login");
//			return "redirect:/";
//		}
//		System.out.println("you're not admin");
//		return "redirect:/loginForm";
//	}
//
//	@RequestMapping(value = "session/login.do", method = RequestMethod.GET)
////	@PostMapping("session/login.do")
//	public String login(@RequestParam("password") String password, HttpSession session) {
//		// 조건 : 비밀번호가 1234 일 때, admin 인정
//		// 비밀번호가 1234 가 아닐 때, index.jsp로 화면 전환
//		if ("1234".equals(password)) {
//			session.setAttribute("isAdmin", true);
//		} else {
//			System.out.println("you're not admin");
//			return "redirect:/loginForm";
//		}
//		System.out.println("admin login");
//		return "redirect:/";
//	}
//
//	@RequestMapping("session/logout.do")
////	public String logout(HttpSession session) {
//	public String logout(SessionStatus status) {
//		// index.jsp의 logout 버튼 클릭 시
//		// 해당 세션은 해제 후 -> index.jsp로 화면 전
////		session.removeAttribute("isAdmin");
////		session.removeAttribute("password");
//		status.setComplete();
//		return "redirect:/";
//	}

//	------------------------------------------------------------------------------------------
//  @RequestMapping(value = "session/login.do", method= RequestMethod.POST)
	@PostMapping("session/login.do")
	public String login(@RequestParam("password") String password, HttpSession session) {
		// 조건 : pw가 1234일때, admin 인정
		// 만약 아니라면, index.jsp로 화면 전환
		if ("1234".equals(password)) {
			session.setAttribute("admin", "true");
		} else {
			return "redirect:/loginForm";
		}
		return "redirect:/";
	}

	@RequestMapping("session/logout.do")
	public String logout(HttpSession session) {
		// index.jsp의 로그아웃 버튼 클릭 시
		// 해당 세션은 해제 후 -> index.jsp로 화면 전환
		session.removeAttribute("admin");
		return "redirect:/";
	}

}