package com.wf.training.bootapp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.CommissionOutput;
import com.wf.training.bootapp.dto.CompanyOutputDto;
import com.wf.training.bootapp.model.Commission;
import com.wf.training.bootapp.model.Company;
import com.wf.training.bootapp.repository.CommissionRepository;

@Service
public class CommissionServiceImpl implements CommissionService {

	@Autowired 
	CommissionRepository commissionRepository;

	private CommissionOutput convertEntityToOutputDto(Commission commission) {
		CommissionOutput commissionOutput = new CommissionOutput();
		System.out.println(commission.getCommissionAmount());
		commissionOutput.setCommissionAmount(String.valueOf(commission.getCommissionAmount()));
		System.out.println(commissionOutput.getCommissionAmount());
		commissionOutput.setStockdate(commission.getStockdate().toString());
		commissionOutput.setStocktime(commission.getStocktime().toString());
		return commissionOutput;
	}
	
	@Override
	public void addNewCommission(@Valid Commission commission) {
		this.commissionRepository.save(commission);
		
	}

	@Override
	public List<CommissionOutput> getAll() {
		List<Commission> commissionList = this.commissionRepository.findAllByOrderByIdAsc();
		List<CommissionOutput> commissionOutput = 
				commissionList.stream()
							 .map(this :: convertEntityToOutputDto)
							 .collect(Collectors.toList());
		return commissionOutput;
	} 

}
