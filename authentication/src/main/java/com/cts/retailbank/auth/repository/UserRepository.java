package com.cts.retailbank.auth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.retailbank.auth.model.AppUser;


@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {

}