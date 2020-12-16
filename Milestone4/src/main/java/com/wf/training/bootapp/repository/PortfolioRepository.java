package com.wf.training.bootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long>{

	Portfolio findByUsername(String username);
}
