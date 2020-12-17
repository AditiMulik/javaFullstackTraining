package com.wf.training.bootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.CommodityDetails;

@Repository
public interface CommodityDetailsRepository extends JpaRepository<CommodityDetails, Long>{
	CommodityDetails findByType(String type);
}
