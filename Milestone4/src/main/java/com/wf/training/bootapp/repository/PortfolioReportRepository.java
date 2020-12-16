package com.wf.training.bootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.PortfolioReport;


@Repository
public interface PortfolioReportRepository extends JpaRepository<PortfolioReport, Long> {
	List<PortfolioReport> findByUsername(String username);
	
	List<PortfolioReport> findByUsernameOrderByReportdateDescReporttimeDesc(String username);
	
	List<PortfolioReport> findByUsernameOrderById(String username);
}
