package com.wf.training.bootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapp.model.Users;


// @Component
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    // nothing to add
}
