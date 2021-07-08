package com.portfolio.calculateeNetworth.repository;

import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portfolio.calculateeNetworth.model.Portfolio;
import com.portfolio.calculateeNetworth.model.StockDetails;

/*
 * Author: Saravanan R
 * Date: 23-06-2021
 * Description: Repository to extend the model class "StockDetails"*/
@Repository
public interface QuoteRepo extends JpaRepository<StockDetails,Integer>
{
	Set<StockDetails> findByPortfolio(Portfolio portfolio);
}
