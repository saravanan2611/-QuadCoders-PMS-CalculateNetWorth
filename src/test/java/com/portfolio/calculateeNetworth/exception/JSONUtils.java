package com.portfolio.calculateeNetworth.exception;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.calculateeNetworth.model.MutualfundsMicroDTO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class JSONUtils 
{
    public static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }


    public MutualfundsMicroDTO mutualfundsMicroDTO(String mutualFundId, String mutualFundName, String mutualFundValue) {
    	MutualfundsMicroDTO mutualfundsMicroDTO = new MutualfundsMicroDTO();
    	mutualfundsMicroDTO.setMutualFundId(mutualFundId);
    	mutualfundsMicroDTO.setMutualFundName(mutualFundName);
    	mutualfundsMicroDTO.setMutualFundValue(mutualFundValue);
    	return mutualfundsMicroDTO;
	}
}