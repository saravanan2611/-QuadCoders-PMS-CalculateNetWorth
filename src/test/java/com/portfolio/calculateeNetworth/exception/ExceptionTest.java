package com.portfolio.calculateeNetworth.exception;

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
	void testShareNotFoundException() {
		SellServiceNotFoundException dailyMutualFundException=new SellServiceNotFoundException("Error occured");
		assertEquals("Error occured",dailyMutualFundException.getMessage());
	}


}
