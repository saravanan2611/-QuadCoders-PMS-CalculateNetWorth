package com.portfolio.calculateeNetworth.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.calculateeNetworth.model.MutualFund;
import com.portfolio.calculateeNetworth.model.MutualfundsMicro;
import com.portfolio.calculateeNetworth.repository.MutualFundRepo;

@Service
public class MutualFundService {
	
	@Autowired
	private MutualFundRepo repository;
	

	public List<Double> getMutualFundByIdList(List<String> mutualFundIdList) {
		List<Double> mfValueList = new ArrayList<>();
		List<MutualfundsMicro> mfList=  repository.findByMutualFundId(mutualFundIdList);
		for(MutualfundsMicro m:mfList) {
			mfValueList.add( m.getMutualFundValue());
		}
		return mfValueList;
	}
	
	public MutualfundsMicro getMutualFundByName(String mutualFundName) {
		return repository.findByMutualFundName(mutualFundName);
	}
	
	
}
