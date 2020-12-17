package com.wf.training.bootapp.service;

import java.util.List;

import javax.validation.Valid;

import com.wf.training.bootapp.dto.PortfolioReportOutput;
import com.wf.training.bootapp.model.PortfolioReport;

public interface PortfolioReportService {
	void addNewPortfolioReport(String username);
	List<PortfolioReportOutput> getAllForUser(String username);
	PortfolioReportOutput fetchSinglePortfolioReport(String username);
}
