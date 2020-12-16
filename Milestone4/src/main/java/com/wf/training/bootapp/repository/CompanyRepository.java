package com.wf.training.bootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
	Company findByCode(String code);

}
