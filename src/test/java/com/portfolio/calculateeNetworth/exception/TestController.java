package com.portfolio.calculateeNetworth.exception;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.portfolio.calculateeNetworth.utils.TestUtils.boundaryTestFile;
import static com.portfolio.calculateeNetworth.utils.TestUtils.businessTestFile;
import static com.portfolio.calculateeNetworth.utils.TestUtils.currentTest;
import com.portfolio.calculateeNetworth.controller.CalculateNetWorthController;
import com.portfolio.calculateeNetworth.model.StockDetailsDTO;
import com.portfolio.calculateeNetworth.service.SellService;
import com.portfolio.calculateeNetworth.utils.MasterClass;
import com.portfolio.calculateeNetworth.utils.TestUtils;

import static com.portfolio.calculateeNetworth.utils.TestUtils.quadCodersAssert;
@AutoConfigureMockMvc
@SpringBootTest(classes =CalculateNetWorthController.class)
public class TestController {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private CalculateNetWorthController stockPriceController;

	@MockBean
	private SellService sellService;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCalculateNetWorth() throws Exception
	{
		when(sellService.getAssetService((long)101, (String)"aghdghd")).thenReturn(50.00);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/calculateNetworth/10001")
				.content(MasterClass.asJsonString(MasterClass.getStockDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		TestUtils.quadCodersAssert(TestUtils.currentTest(), (result.getResponse().getStatus() == HttpStatus.OK.value()? "true" : "false"), TestUtils.businessTestFile);

	}

	@Test
	public void testSellAssets() throws Exception
	{  String  token="aghdghd";
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Authorization", token);
		HttpEntity<?> httpEntity= new HttpEntity<>(httpHeaders);
		when(sellService.getAssetService((long)101,"aghdghd")).thenReturn(50.00);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/SellAssets")
				.content(MasterClass.asJsonString(MasterClass.getStockDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		TestUtils.quadCodersAssert(TestUtils.currentTest(), (result.getResponse().getStatus() == HttpStatus.OK.value()? "true" : "false"), TestUtils.businessTestFile);

	}
}