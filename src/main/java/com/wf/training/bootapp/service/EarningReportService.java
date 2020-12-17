package com.wf.training.bootapp.service;

import java.util.List;

import com.wf.training.bootapp.dto.EarningReportOutput;

public interface EarningReportService {
	void addNewPortfolioReport(String username, int inputValue);
	List<EarningReportOutput> getAllForUser(String username);
	EarningReportOutput fetchSinglePortfolioReport(String username);
}
