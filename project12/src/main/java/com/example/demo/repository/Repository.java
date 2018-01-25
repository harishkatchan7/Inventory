package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.SurveyData;

public interface Repository extends CrudRepository<SurveyData,Integer>,JpaSpecificationExecutor<SurveyData> 
{
	SurveyData findById(int id);
}
	