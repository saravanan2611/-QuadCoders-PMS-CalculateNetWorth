package com.portfolio.calculateeNetworth.exception;

import java.io.IOException;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.portfolio.calculateeNetworth.model.MutualFundDTO;
import com.portfolio.calculateeNetworth.model.StockDetailsDTO;
import com.portfolio.calculateeNetworth.utils.MasterClass;

import static com.portfolio.calculateeNetworth.utils.TestUtils.quadCodersAssert;
import static com.portfolio.calculateeNetworth.utils.TestUtils.boundaryTestFile;
import static com.portfolio.calculateeNetworth.utils.TestUtils.currentTest;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {

	private static final long serialVersionUID = -6544854658457780865L;

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testStockDetailsDTOId() throws Exception
	{
		try
		{
			StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
			stockDetails.setId(null);
			Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testStockDetailsDTOStockId() throws Exception
	{
		try
		{
			StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
			stockDetails.setStockId(0);
			Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testStockDetailsDTOStockName() throws Exception
	{
		try
		{
			StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
			stockDetails.setStockName(null);
			Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testStockDetailsDTOStockCount() throws Exception
	{
		try
		{
			StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
			stockDetails.setStockCount(0);
			Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testStockDetailDTOIdLengthNegative() throws Exception
	{
		try
		{
			StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
			stockDetails.setStockName("S");
			Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testStockDetailDTOIdLengthPositive() throws Exception
	{
		try
		{
			StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
			stockDetails.setStockName("S1");
			Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testMutualFundDTOId() throws Exception
	{
		try
		{
			MutualFundDTO mutualFund = MasterClass.getMutualFundDTO();
			mutualFund.setId(null);
			Set<ConstraintViolation<MutualFundDTO>> violations = validator.validate(mutualFund);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testMutualFundDTOMutualFundId() throws Exception
	{
		try
		{
			MutualFundDTO mutualFund = MasterClass.getMutualFundDTO();
			mutualFund.setMutual_fund_id(0);
			Set<ConstraintViolation<MutualFundDTO>> violations = validator.validate(mutualFund);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testMutualFundDTOMutualFundName() throws Exception
	{
		try
		{
			MutualFundDTO mutualFund = MasterClass.getMutualFundDTO();
			mutualFund.setMutualFundName(null);
			Set<ConstraintViolation<MutualFundDTO>> violations = validator.validate(mutualFund);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testMutualFundDTOIdLengthNegative() throws Exception
	{
		try
		{
			MutualFundDTO mutualFund = MasterClass.getMutualFundDTO();
			mutualFund.setMutualFundName("M");
			Set<ConstraintViolation<MutualFundDTO>> violations = validator.validate(mutualFund);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testMutualFundDTOIdLengthPositive() throws Exception
	{
		try
		{
			MutualFundDTO mutualFund = MasterClass.getMutualFundDTO();
			mutualFund.setMutualFundName("MF");
			Set<ConstraintViolation<MutualFundDTO>> violations = validator.validate(mutualFund);
			quadCodersAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testPostStockDetailsSuccess() throws IOException
	{
		StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
		Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
		quadCodersAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPostStockDetailsFailed() throws IOException
	{
		StockDetailsDTO stockDetails = MasterClass.getStockDetailsDTO();
		stockDetails.setId(null);
		Set<ConstraintViolation<StockDetailsDTO>> violations = validator.validate(stockDetails);
		quadCodersAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPostMutualFundSuccess() throws IOException
	{
		MutualFundDTO mutualFund = MasterClass.getMutualFundDTO();
		Set<ConstraintViolation<MutualFundDTO>> violations = validator.validate(mutualFund);
		quadCodersAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPostMutualFundFailed() throws IOException
	{
		MutualFundDTO mutualFund = MasterClass.getMutualFundDTO();
		mutualFund.setId(null);
		Set<ConstraintViolation<MutualFundDTO>> violations = validator.validate(mutualFund);
		quadCodersAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}
}