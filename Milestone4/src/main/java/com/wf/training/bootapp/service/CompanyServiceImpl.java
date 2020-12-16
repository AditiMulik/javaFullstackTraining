package com.wf.training.bootapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.CompanyInputDto;
import com.wf.training.bootapp.dto.CompanyOutputDto;
import com.wf.training.bootapp.model.Company;
import com.wf.training.bootapp.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired CompanyRepository repository;
	
	@Autowired
	StockPricesService stockPricesService;

	private CompanyOutputDto convertEntityToOutputDto(Company company) {
		CompanyOutputDto companyOutputDto = new CompanyOutputDto();
		companyOutputDto.setCode(company.getCode());
		companyOutputDto.setCurrency(company.getCurrency());
		companyOutputDto.setOperation(company.getOperation());
		companyOutputDto.setSector(company.getSector());
		companyOutputDto.setSharecount(company.getSharecount().toString());
		companyOutputDto.setShareprice(this.stockPricesService.fetchSingleStockPrices(company.getCode()));//company.getShareprice().toString());
		companyOutputDto.setTitle(company.getTitle());
		companyOutputDto.setTurnover(company.getTurnover().toString());
		return companyOutputDto;
	}
	
	private Company covertInputDtoToEntity(CompanyInputDto companyInputDto) {
		Company company = new Company();
		company.setCode(companyInputDto.getCode());
		company.setCurrency(companyInputDto.getCurrency());
		company.setOperation(companyInputDto.getOperation());
		company.setSector(companyInputDto.getSector());
		company.setSharecount(Integer.valueOf(companyInputDto.getSharecount()));
		company.setShareprice(Integer.valueOf(companyInputDto.getShareprice()));
		company.setTitle(companyInputDto.getTitle());
		company.setTurnover(Integer.valueOf(companyInputDto.getTurnover()));
		return company;
	}
	
	@Override
	public List<CompanyOutputDto> fetchAllCompanies() {
		List<Company> companies = this.repository.findAll();
		List<CompanyOutputDto> companyDtos = 
				companies.stream()
							 .map(this :: convertEntityToOutputDto)
							 .collect(Collectors.toList());
		return companyDtos;
	}

	@Override
	public CompanyOutputDto fetchSingleCompany(Long id) {
		Company company = this.repository.findById(id).orElse(null);
		CompanyOutputDto companyOutputDto =  this.convertEntityToOutputDto(company);
		return companyOutputDto;
	}

	@Override
	public CompanyOutputDto addCompany(CompanyInputDto companyInputDto) {
		Company company = this.covertInputDtoToEntity(companyInputDto);
		Company newCompany = this.repository.save(company);
		CompanyOutputDto companyOutputDto = this.convertEntityToOutputDto(newCompany);
		return companyOutputDto;
	}

	@Override
	public CompanyOutputDto editCompany(Long id, CompanyInputDto companyInputDto) {
		Company company = this.covertInputDtoToEntity(companyInputDto);
		company.setId(id);
		Company updatedCompany = this.repository.save(company);
		CompanyOutputDto companyOutputDto = this.convertEntityToOutputDto(updatedCompany);
		return companyOutputDto;
	}

}
