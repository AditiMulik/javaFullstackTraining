package com.wf.training.bootapp.service;

import java.util.List;

import com.wf.training.bootapp.dto.CompanyInputDto;
import com.wf.training.bootapp.dto.CompanyOutputDto;


public interface CompanyService {
	public List<CompanyOutputDto> fetchAllCompanies();
	public CompanyOutputDto fetchSingleCompany(Long id);
	public CompanyOutputDto addCompany(CompanyInputDto companyInputDto);
	public CompanyOutputDto editCompany(Long id, CompanyInputDto companyInputDto);
}
