package com.wf.training.bootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.StockPrices;

@Repository
public interface StockPricesRepository extends JpaRepository<StockPrices, Long>{
List<StockPrices> findByCompanyCodeOrderByIdDesc(String companyCode);
}
