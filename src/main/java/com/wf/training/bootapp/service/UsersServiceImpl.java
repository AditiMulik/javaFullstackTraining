package com.wf.training.bootapp.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.UsersInputDto;
import com.wf.training.bootapp.dto.UsersOutputDto;
import com.wf.training.bootapp.model.Users;
import com.wf.training.bootapp.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired UsersRepository repository;
	
	// utility method
	private UsersOutputDto convertEntityToOutputDto(Users user) {
		UsersOutputDto userOutputDto = new UsersOutputDto();
		userOutputDto.setUsername(user.getUsername());
		userOutputDto.setPassword(user.getPassword());
		//employeeOutputDto.setId(employee.getId());
		return userOutputDto;
	}
	
	private Users covertInputDtoToEntity(UsersInputDto userInput, String role) {
		Users user = new Users();
		user.setUsername(userInput.getUsername());
		user.setPassword(userInput.getPassword());
		user.setRole(role);
		return user;
	}
	
	@Override
	public UsersOutputDto addNewRep(@Valid UsersInputDto userInput, String role) {
		Users user = this.covertInputDtoToEntity(userInput,role);
		Users newUser = this.repository.save(user);
		UsersOutputDto userOutputDto = this.convertEntityToOutputDto(newUser);
		return userOutputDto;
	}

	@Override
	public UsersOutputDto addNewInvestor(@Valid UsersInputDto userInput, String role) {
		Users user = this.covertInputDtoToEntity(userInput,role);
		Users newUser = this.repository.save(user);
		UsersOutputDto userOutputDto = this.convertEntityToOutputDto(newUser);
		return userOutputDto;
	}

}
