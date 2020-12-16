package com.wf.training.bootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.StockExchange;

@Repository
public interface StockExchageRepository extends JpaRepository<StockExchange, Long> {
	List<StockExchange> findByUsername(String username);
	List<StockExchange> findByType(String type);
	//List<StockExchange> findByUsernameAndTypeAndCommodityType(String username, String type, String commodityType);
	List<StockExchange> findByUsernameAndType(String username, String type);
	
	@Query("select s from StockExchange s where s.username=:username and s.type=:type and s.commodityType=:commodityType")
	StockExchange findByUsernameAndTypeAndCommodityType(@Param("username")String username, @Param("type")String type, 
			@Param("commodityType")String commodityType);
	
	@Query("select s from StockExchange s where s.username=:username and s.type=:type and s.companyCode=:companyCode")
	StockExchange findByUsernameAndTypeAndCompanyCode(@Param("username")String username, @Param("type")String type, 
			@Param("companyCode")String companyCode);
}
