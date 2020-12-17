package com.wf.training.bootapp.service;

import java.util.List;

import javax.validation.Valid;

import com.wf.training.bootapp.dto.CommissionOutput;
import com.wf.training.bootapp.dto.CompanyOutputDto;
import com.wf.training.bootapp.model.Commission;

public interface CommissionService {
	void addNewCommission(@Valid Commission commission);
	List<CommissionOutput> getAll();
}
