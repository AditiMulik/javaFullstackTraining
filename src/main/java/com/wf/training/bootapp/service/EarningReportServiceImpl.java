package com.wf.training.bootapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.EarningReportOutput;
import com.wf.training.bootapp.model.EarningReport;
import com.wf.training.bootapp.repository.EarningReportRepository;
@Service
public class EarningReportServiceImpl implements EarningReportService {
	@Autowired 
	EarningReportRepository earningReportRepository;
	
	private EarningReportOutput convertEntityToOutputDto(EarningReport earningReport) {
		EarningReportOutput earningReportOutput = new EarningReportOutput();
		earningReportOutput.setEarningReportValue(String.valueOf(earningReport.getEarnedAmount()));
		earningReportOutput.setReportdate(earningReport.getReportdate());
		earningReportOutput.setReporttime(earningReport.getReporttime());
		return earningReportOutput;
	}
	
	@Override
	public void addNewPortfolioReport(String username, int inputValue) {
		EarningReport newearningReport = new EarningReport();
		newearningReport.setEarnedAmount(inputValue);
		newearningReport.setReportdate(LocalDate.now());
		newearningReport.setReporttime(LocalTime.now());
		newearningReport.setUsername(username);
		
		this.earningReportRepository.save(newearningReport);
	}

	@Override
	public List<EarningReportOutput> getAllForUser(String username) {
		List<EarningReport> earningReportList = this.earningReportRepository.findByUsernameOrderById(username);
		List<EarningReportOutput> earningReportOutputList = earningReportList.stream()
				 .map(this :: convertEntityToOutputDto)
				 .collect(Collectors.toList());
		return earningReportOutputList;
	}

	@Override
	public EarningReportOutput fetchSinglePortfolioReport(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
