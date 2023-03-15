package com.example.demoforJava2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoforJava2.entity.Bank;

public interface BankRepo extends JpaRepository<Bank, Long> {

}
