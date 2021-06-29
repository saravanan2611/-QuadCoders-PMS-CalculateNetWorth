package com.portfolio.calculateeNetworth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portfolio.calculateeNetworth.*;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.StockDetailsMicro;


@Repository
public interface SharePriceRepo extends JpaRepository<StockDetailsMicro,String>{
    

	//public StockDetailsMicro findByShareId(String shareId);
	public StockDetailsMicro findByStockName(String stockName);
	
	@Query("SELECT s FROM StockDetailsMicro s WHERE s.stockId IN (:stockId) order by s.stockId")
	public List<StockDetailsMicro> findByStockId(@Param("stockId") List<String> stockId);
}
	
	/*@Query("SELECT s FROM ShareDetails s WHERE s.shareId IN (:shareID) order by s.shareId")
	public List<StockDetailsM1> findByShareId(@Param("shareID") List<String> shareId);
*/




























