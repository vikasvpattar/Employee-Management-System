package com.prog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	@GetMapping("/")
	public String home(Model m){
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index"; 
	}
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add-emp";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg","employee added sucessfully");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e= service.getEMpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg","data updated sucessfully");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session) {
		service.deleteEMp(id);
		session.setAttribute("msg","data deleted sucessfully");
		return "redirect:/";
	}
	

}
