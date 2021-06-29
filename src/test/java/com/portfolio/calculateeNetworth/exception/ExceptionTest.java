package com.portfolio.calculateeNetworth.exception;

//import static com.iiht.StockMarket.utilTestClass.TestUtils.currentTest;
//import static com.iiht.StockMarket.utilTestClass.TestUtils.exceptionTestFile;
//import static com.iiht.StockMarket.utilTestClass.TestUtils.yakshaAssert;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.service.SellService;

class ExceptionTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@MockBean
	private SellService sellService;
	
	@ExceptionHandler(SellServiceNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="Invalid Portfolio_id")
	public void portfolioNotFound(){
		
		
	}
}
