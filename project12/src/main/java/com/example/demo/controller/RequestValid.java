package com.example.demo.controller;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import com.example.demo.model.SurveyRequestData;
@Component("beforeCreateWebsiteUserValidator")
public class RequestValid implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SurveyRequestData.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors err) {
		
		 SurveyRequestData user = (SurveyRequestData) target;
		
		 if (checkInputString(user.getEname())) {
	            err.rejectValue("ename", "");
	        }
	    
	        if (checkInputString(user.getEtype())) {
	            err.rejectValue("etype", "etype.empty");
	        }
	     

	   Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	            Pattern.CASE_INSENSITIVE);
	      if (!(pattern.matcher(user.getEmail()).matches())) { 
	         err.rejectValue("email", "user.email.invalid");
	      }
	      

}
	private boolean checkInputString(String input) {
	    return (input == null || input.trim().length() == 0);}

}
