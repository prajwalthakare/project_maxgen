package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.java.entity.Addcard;
import com.java.entity.Stock;
import com.java.entity.User;
import com.java.ser.service;

@ComponentScan("com.java")
@Controller
@EnableWebMvc

public class controller {
	@Autowired
	 service mvcser;
 //Student detail controller 
	@RequestMapping("/loginpage")
	public String openloginpage() {
		
		return "login";
	}
	
	
	@RequestMapping("/login")
	public ModelAndView checkloging(@ModelAttribute User user){
		ModelAndView mv=new ModelAndView();
		
		boolean result=mvcser.checklogin(user);
		System.out.println("7777");
		
		if(result){
			System.out.println(user.getUsername());
			
			mv.setViewName("redirect:/home");
		}
		else{
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping("/home")
	public  ModelAndView openhomepage(){
		System.out.println("1111111");
		ModelAndView mv=new ModelAndView();
		List<Stock> liststock=mvcser.getstock();
		if(!liststock.isEmpty()){
			mv.addObject("list",liststock);
			mv.setViewName("home");
		}
		else{
			
			mv.addObject("list",liststock);
			mv.setViewName("login");
		}
	
		return mv;
		
	}
	
	@RequestMapping("/addmed")
	public String openAdduser()
	{
		return "addmed";
	}
	
	
	@RequestMapping("/addmedpage")
	public ModelAndView adduser(@ModelAttribute Stock stock)
	{
		ModelAndView mv=new ModelAndView();
		if(mvcser.addmed(stock))
		{
			 List<Stock> liststock=mvcser.getstock();
			 mv.addObject("list", liststock);
			 mv.setViewName("redirect:/home");
		}
		else
		{
			mv.addObject("msg", "something Went Wrong!");
		}
		return mv;
	}
	
	@RequestMapping("/deleteuser")
	public ModelAndView deleteuser(@RequestParam("id") String id){
		
		ModelAndView mv=new ModelAndView();
		int stid=Integer.parseInt(id);
		//mvcser.deleteuser(userid);
		
		if(mvcser.deletestock(stid)){
			
			List<Stock> listuser=mvcser.getstock();
			mv.addObject("list",listuser);
			mv.setViewName("home");
			//mv.addObject("msg", "delete sucessfully");
		}
		else{
			mv.addObject("msg", "something wnt wrong");
		}
		
		
		return mv;
		
		
	}
	
	@RequestMapping("/addcard")
	public String openAddcard()
	{
		return "addcard";
	}
	
	
	@RequestMapping("/addcardpage")
	public ModelAndView addcard(@ModelAttribute Addcard card)
	{System.out.println("add11111");
		ModelAndView mv=new ModelAndView();
		if(mvcser.addcard(card))
		{
			 List<Addcard> listcard=mvcser.getcard();
			 mv.addObject("list", listcard);
			 mv.setViewName("redirect:/home");
		}
		else
		{
			mv.addObject("msg", "something Went Wrong!");
		}
		return mv;
	}

}
