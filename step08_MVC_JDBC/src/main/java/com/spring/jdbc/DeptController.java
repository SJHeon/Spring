package com.spring.jdbc;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@Controller
public class DeptController {

	@Autowired
	private DeptServiceImpl deptService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		System.out.println(deptService.getDeptByDeptno(10));
//		model.addAttribute("deptno", deptService.getDeptByDeptno(10));
//		return "home";
//	}
	@GetMapping("searchInfo.do")
	public String searchInfo(Locale locale, Model model, @RequestParam("deptno") int deptno) {
		Dept dept = deptService.getDeptByDeptno(deptno);

		if (deptno != 0) {
			model.addAttribute("deptno", dept.getDeptno());
			model.addAttribute("dname", dept.getDname());
			model.addAttribute("loc", dept.getLoc());
			System.out.println(dept);
//			return "forward:/searchResult.jsp";
			return "redirect:/searchResult.jsp";
//			return "../../searchResult";
		}
		return "home";
	}

}
