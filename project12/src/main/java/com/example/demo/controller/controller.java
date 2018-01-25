package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.business;
import com.example.demo.model.SurveyRequestData;

@RestController
@RequestMapping("/api")
public class controller {
	
	@Autowired
	business ans; 
	
	@Autowired
	RequestValid RequestValidator;
	@RequestMapping(value="/hello")
	public String test()
	{
		return "test";
	}
	@InitBinder
	protected void initBinder(WebDataBinder b)
	{
		b.setValidator(RequestValidator);
	}
	
	@RequestMapping(value="/entity",method=RequestMethod.POST,headers="Accept=application/json")
	public String captureSurveyDetails(@RequestBody @Valid SurveyRequestData reqData){
		System.out.println("Request data: "+ reqData.toString());
		return ans.captureSurveyDtls(reqData);	
	}
	@RequestMapping(value="/fetchsurveydetails/{userId}")
	public SurveyRequestData getSurveyDetails(@PathVariable int userId) {
		return ans.fetchSurveyDtls(userId);
	}
}
