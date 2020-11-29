package com.wf.training.bootapp.service;

import java.util.List;

import com.wf.training.bootapp.dto.CommodityInputDto;
import com.wf.training.bootapp.dto.CommodityOutputDto;

public interface CommodityService {
	public List<CommodityOutputDto> fetchAllCommodity();
	public CommodityOutputDto fetchSingleCommodity(Long id);
	public CommodityOutputDto addCommodity(CommodityInputDto commodityInputDto);
	public CommodityOutputDto editCommodity(Long id, CommodityInputDto commodityInputDto);
}
