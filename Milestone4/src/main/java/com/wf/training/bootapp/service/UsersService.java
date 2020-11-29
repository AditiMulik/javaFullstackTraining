package com.wf.training.bootapp.service;

import java.util.List;

import javax.validation.Valid;

import com.wf.training.bootapp.dto.UsersInputDto;
import com.wf.training.bootapp.dto.UsersOutputDto;


public interface UsersService {

	UsersOutputDto addNewRep(@Valid UsersInputDto user);

		
	
}
