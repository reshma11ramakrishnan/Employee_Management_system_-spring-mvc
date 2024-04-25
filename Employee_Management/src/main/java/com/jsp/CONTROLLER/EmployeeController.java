package com.jsp.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.DAO.EmployeeDAO;
import com.jsp.DTO.Employee;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeDAO dao;
	
	@RequestMapping("/add")
	public ModelAndView saveEmployee()                       //modelandview returns two objects one for model and one for view
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("addEmployee.jsp");
		return mv;
	}
	
	@RequestMapping("/save")
	public ModelAndView createEmployee(@ModelAttribute Employee employee)
	{
		
		dao.saveEmployee(employee);
		ModelAndView view = new ModelAndView();
		view.setViewName("index.jsp");
		return view;
		//return"employee details added.....";
	}
	
	@RequestMapping("/search")
	public ModelAndView findEmployee()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("employee", new Employee());
		mav.setViewName("getEmp.jsp");
		return mav;
	}
	
	@RequestMapping("/fetch")
	public ModelAndView searchEmployee(@ModelAttribute Employee employee)
	{
		ModelAndView mav = new ModelAndView();
		Employee emp = dao.findEmployee(employee.getId());
		mav.addObject("employee",emp);
		mav.setViewName("display.jsp");
		return mav;
		
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteEmployee()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("delEmp.jsp");
		return mv;			
	}
	@RequestMapping ("/remove")
	public ModelAndView removeEmployee(@ModelAttribute Employee employee)
	{
		
		dao.deleteEmployee(employee.getId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
		
	}
	
	@RequestMapping("update")
	public ModelAndView updateEmployee()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("update.jsp");
		return mv;
	}
	@RequestMapping("alter")
	public ModelAndView alterEmployee(@ModelAttribute Employee employee)
	{
		dao.updateEmployee(employee);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	
	
	@RequestMapping("displayAll")
	public ModelAndView display()
	{
		ModelAndView m = new ModelAndView();
		m.addObject("employeelist",dao.getAllEmployee());
		m.setViewName("displayAll.jsp");
		return m;
		
	}
	

}
