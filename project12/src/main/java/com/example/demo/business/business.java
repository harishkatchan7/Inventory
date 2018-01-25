package com.example.demo.business;

import org.springframework.stereotype.Service;

import com.example.demo.model.SurveyRequestData;
//import com.example.demo.model.SurveyRequestData;

@Service
public interface business {

	public String captureSurveyDtls(SurveyRequestData reqData);
	public SurveyRequestData fetchSurveyDtls(int user);
	public SurveyRequestData captureSurvey(SurveyRequestData reqData);
	}
