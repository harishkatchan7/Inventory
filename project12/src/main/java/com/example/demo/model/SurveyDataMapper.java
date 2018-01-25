package com.example.demo.model;


import org.springframework.stereotype.Component;
import com.example.demo.model.SurveyData;
import com.example.demo.model.SurveyRequestData;

@Component
public class SurveyDataMapper {
	public SurveyData mapSurveyResponse(SurveyRequestData ui) {
		System.out.println("Inside mapper class!");	
			SurveyData db = new SurveyData();
			db.setAdd1(ui.getAdd1());
			db.setAdd2(ui.getAdd2());
			db.setAdd3(ui.getAdd3());
			db.setCity(ui.getCity());
			db.setEmail(ui.getEmail());
			db.setEname(ui.getEname());
			db.setEtype(ui.getEtype());
			db.setFname(ui.getFname());
			db.setGst(ui.getGst());
			db.setLname(ui.getLname());
			db.setMobile(ui.getMobile());
			db.setPin(ui.getPin());
			db.setState(ui.getState());
			return db;
	}
	public SurveyRequestData mapDBData(SurveyData db) {
		SurveyRequestData ui = new SurveyRequestData();
		ui.setAdd1(db.getAdd1());
		ui.setAdd2(db.getAdd2());
		ui.setAdd3(db.getAdd3());
		ui.setCity(db.getCity());
		ui.setEmail(db.getEmail());
		ui.setEname(db.getEname());
		ui.setEtype(db.getEtype());
		ui.setFname(db.getFname());
		ui.setGst(db.getGst());
		ui.setLname(db.getLname());
		ui.setMobile(db.getMobile());
		ui.setPin(db.getPin());
		ui.setState(db.getState());
		return ui;
	}
}
