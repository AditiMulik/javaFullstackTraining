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
	
	private Users covertInputDtoToEntity(UsersInputDto userInput) {
		Users user = new Users();
		user.setUsername(userInput.getUsername());
		user.setPassword(userInput.getPassword());
		return user;
	}
	
	@Override
	public UsersOutputDto addNewRep(@Valid UsersInputDto userInput) {
		// convert dto into entity
		Users user = this.covertInputDtoToEntity(userInput);
		// save entity in DB : returns the copy of newly added record back
		Users newUser = this.repository.save(user);
		// convert entity into output dto
		UsersOutputDto userOutputDto = this.convertEntityToOutputDto(newUser);
		return userOutputDto;
	}

}
