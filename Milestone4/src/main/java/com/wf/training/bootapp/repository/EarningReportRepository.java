package com.wf.training.bootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.EarningReport;
@Repository
public interface EarningReportRepository extends JpaRepository<EarningReport, Long>{
	List<EarningReport> findByUsername(String username);
	
	List<EarningReport> findByUsernameOrderByReportdateDescReporttimeDesc(String username);
	
	List<EarningReport> findByUsernameOrderById(String username);
}
