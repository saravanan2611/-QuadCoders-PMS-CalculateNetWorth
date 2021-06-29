package com.portfolio.calculateeNetworth;

import org.junit.jupiter.api.Test;
import org.junit.runner.Result;
import org.springframework.boot.test.context.SpringBootTest;

import com.portfolio.calculateeNetworth.model.PortfolioTest;

import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;

@SpringBootTest
public class CalculateeNetworthApplicationTests {

	/*
	 * PortfolioTest 	:  7
	 * MutualFundTest 	:  9The package org.junit.runner is accessible from more than one module: <unnamed>, junit
	 * StockDetauilsTest:  9
	 * Total 			: 24
	 * Target			: 50
	 * */
	public static void main(String[] args) {									
	    Result result = JUnitCore.runClasses(PortfolioTest.class);					
		for (Failure failure : result.getFailures()) {							
	    System.out.println(failure.toString());					
	}		
	System.out.println("Result=="+result.wasSuccessful());							
	}		
		
}     