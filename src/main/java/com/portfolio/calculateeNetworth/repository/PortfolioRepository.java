package com.portfolio.calculateeNetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.calculateeNetworth.model.Portfolio;

/*
 * Author: Saravanan R
 * Date: 23-06-2021
 * Description: Repository to extend the model class "Portfolio"*/
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
