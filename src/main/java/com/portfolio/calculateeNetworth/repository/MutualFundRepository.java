package com.portfolio.calculateeNetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.calculateeNetworth.model.MutualFund;

/*
 * Author: Saravanan R
 * Date: 23-06-2021
 * Description: Repository to extend the model class "MutualFund"*/
@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund,String>{

}
