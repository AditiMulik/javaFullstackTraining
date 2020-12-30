package com.wf.training.bootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.StockExchange;
import com.wf.training.bootapp.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	List<Users> findByRole(String role);
}
