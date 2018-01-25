package com.example.demo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.SurveyData;
import com.example.demo.model.SurveyDataMapper;
import com.example.demo.model.SurveyRequestData;
import com.example.demo.repository.Repository;


@Service
@Component
public class businessimplem implements business {

	@Autowired
	SurveyDataMapper survDataMap;
	
	@Autowired
	Repository user;
	
	@Override
	public String captureSurveyDtls(SurveyRequestData reqData) {
		System.out.println("Inside business class!");
		SurveyData survData = survDataMap.mapSurveyResponse(reqData);
		 String status="Failed to store the details!";
		try {
				System.out.println("Mapped Data: " +survData.toString());
				user.save(survData);
			}
			catch (Exception e) {
			 System.out.println("Exception" + e);
			 }
		status="Successfully stored the details!";	
		return status;
	}
	public SurveyRequestData captureSurvey(SurveyRequestData reqData) {
		System.out.println("Inside business class!");
		SurveyData survData = survDataMap.mapSurveyResponse(reqData);
		 //String status="Failed to store the details!";
		try {
				System.out.println("Mapped Data: " +survData.toString());
				user.save(survData);
			}
			catch (Exception e) {
			 System.out.println("Exception" + e);
			 }
		//status="Successfully stored the details!";	
		return reqData;
	}
	@Override
	public SurveyRequestData fetchSurveyDtls(int userId) {

		SurveyRequestData survRetData = new SurveyRequestData();
		SurveyData survDataDB= user.findById(userId);
		survRetData=survDataMap.mapDBData(survDataDB);
		System.out.println("Data is parsed from Db");
		return survRetData;
	}

}
