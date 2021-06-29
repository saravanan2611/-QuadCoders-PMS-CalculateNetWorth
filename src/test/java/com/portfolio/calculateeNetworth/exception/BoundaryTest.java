package com.portfolio.calculateeNetworth.exception;

import static org.junit.Assert.*;

import java.util.Set;
//import javax.validation.ConstraintViolation;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.portfolio.calculateeNetworth.model.MutualfundsMicroDTO;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.StockDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@ExtendWith(SpringExtension.class)
//@RunWith(JUnitPlatform.class)
public class BoundaryTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
//	private Validator validator;

    //----------------------------------------------------------------------------------------------
  /*  @BeforeEach
    public void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }*/

	/*
	 * @Test
	public void testCompanyCodeLength() throws Exception 
	{
		StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
		companyDetails.setId(null);
		Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}*/
	@Test
	public void testCompanyCodeLength() throws Exception 
	{
		MutualfundsMicroDTO companyDetails = MasterClass.getMutualfundsMicroDTO();
		companyDetails.setMutualFundId(null);
		//Set<ConstraintViolation<MutualfundsMicroDTO>> violations = validator.validate(companyDetails);
		//yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
}
