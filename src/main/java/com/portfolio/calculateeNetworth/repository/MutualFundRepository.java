package com.portfolio.calculateeNetworth.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.calculateeNetworth.model.MutualFund;
import com.portfolio.calculateeNetworth.model.Portfolio;

/*
 * Author: Saravanan R
 * Date: 23-06-2021
 * Description: Repository to extend the model class "MutualFund"*/
@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund,String>{
 Set<MutualFund> findByPortfolio(Portfolio portfolio);
}
