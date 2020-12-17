package com.wf.training.bootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.training.bootapp.dto.StockExchangeInputDto;
import com.wf.training.bootapp.dto.StockExchangeOutputDto;
import com.wf.training.bootapp.service.StockExchangeService;

@RestController
@RequestMapping("/pms")
public class RestTestController {
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@PostMapping("/tradeCompany")
	public ResponseEntity<StockExchangeOutputDto> tradeCompany(@RequestBody StockExchangeInputDto stockExchangeInputDto){
		StockExchangeOutputDto stockExchangeOutputDto = this.stockExchangeService.tradeCompany(stockExchangeInputDto);
		ResponseEntity<StockExchangeOutputDto> response = new ResponseEntity<StockExchangeOutputDto>(stockExchangeOutputDto, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/tradeCommodity")
	public ResponseEntity<StockExchangeOutputDto> tradeCommodity(@RequestBody StockExchangeInputDto stockExchangeInputDto){
		StockExchangeOutputDto stockExchangeOutputDto = this.stockExchangeService.tradeCommodity(stockExchangeInputDto);
		ResponseEntity<StockExchangeOutputDto> response = new ResponseEntity<StockExchangeOutputDto>(stockExchangeOutputDto, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/test")
	public String getAllManagers(){
		return "PMS app is working";
	}
	
}

