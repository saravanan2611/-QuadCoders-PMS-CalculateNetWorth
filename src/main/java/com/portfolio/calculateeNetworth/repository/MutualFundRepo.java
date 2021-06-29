package com.portfolio.calculateeNetworth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.portfolio.calculateeNetworth.model.MutualfundsMicro;

public interface MutualFundRepo extends JpaRepository<MutualfundsMicro,String>{
	
	
	public MutualfundsMicro findByMutualFundName(String mutualFundName);
	 	
	 @Query("SELECT m FROM MutualfundsMicro m WHERE m.mutualFundId IN (:mutualFundIdList) order by m.mutualFundId")
	 public List<MutualfundsMicro> findByMutualFundId(@Param("mutualFundIdList") List<String> mutualFundIdList);	
 
}

