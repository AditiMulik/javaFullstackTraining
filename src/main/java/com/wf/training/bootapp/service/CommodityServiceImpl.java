package com.wf.training.bootapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.CommodityInputDto;
import com.wf.training.bootapp.dto.CommodityOutputDto;
import com.wf.training.bootapp.model.CommodityDetails;
import com.wf.training.bootapp.repository.CommodityDetailsRepository;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired CommodityDetailsRepository repository;
	
	@Autowired
	StockExchangeService stockExchangeService;

	private CommodityOutputDto convertEntityToOutputDto(CommodityDetails commodityDetails) {
		CommodityOutputDto commodityOutputDto = new CommodityOutputDto();
		commodityOutputDto.setType(commodityDetails.getType());
		commodityOutputDto.setPrice(commodityDetails.getPrice().toString());
		return commodityOutputDto;
	}
	
	private CommodityDetails covertInputDtoToEntity(CommodityInputDto commodityInputDto) {
		CommodityDetails commodityDetails = new CommodityDetails();
		commodityDetails.setType(commodityInputDto.getType());
		commodityDetails.setPrice(Integer.valueOf(commodityInputDto.getPrice()));
		return commodityDetails;
	}
	
	@Override
	public List<CommodityOutputDto> fetchAllCommodity() {
		List<CommodityDetails> commodityDetails = this.repository.findAll();
		List<CommodityOutputDto> commodityOutputDto = 
				commodityDetails.stream()
							 .map(this :: convertEntityToOutputDto)
							 .collect(Collectors.toList());
		return commodityOutputDto;
	}

	@Override
	public CommodityOutputDto fetchSingleCommodity(Long id) {
		return null;
	}

	@Override
	public CommodityOutputDto addCommodity(CommodityInputDto commodityInputDto) {
		CommodityDetails existingCommodityDetails = this.repository.findByType(commodityInputDto.getType());
		CommodityDetails commodityDetails = new CommodityDetails();
		if(existingCommodityDetails == null) {
			commodityDetails = this.covertInputDtoToEntity(commodityInputDto);
		}
		else {
			commodityDetails = this.repository.findById(existingCommodityDetails.getId()).orElse(null);
			commodityDetails.setPrice(Integer.valueOf(commodityInputDto.getPrice()));
		}

		CommodityDetails newCommodityDetails = this.repository.save(commodityDetails);
		CommodityOutputDto commodityOutputDto = this.convertEntityToOutputDto(newCommodityDetails);
		
		this.stockExchangeService.updateCommodityRecords();
		return commodityOutputDto;
	}

	@Override
	public CommodityOutputDto editCommodity(Long id, CommodityInputDto commodityInputDto) {
		CommodityDetails commodityDetails = this.covertInputDtoToEntity(commodityInputDto);
		commodityDetails.setId(id);
		CommodityDetails updatedCommodityDetails = this.repository.save(commodityDetails);
		CommodityOutputDto commodityOutputDto = this.convertEntityToOutputDto(updatedCommodityDetails);
		return commodityOutputDto;
	}

	@Override
	public Integer fetchCommodityPrice(String type) {
		CommodityDetails commodityDetails = this.repository.findByType(type);
		return commodityDetails.getPrice();
	}

}
