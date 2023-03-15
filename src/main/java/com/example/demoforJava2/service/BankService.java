package com.example.demoforJava2.service;

import java.util.List;

import com.example.demoforJava2.entity.Bank;

public interface BankService {

	
	Bank saveDetails(Bank bank);
 List<Bank> getDetails();
Bank updatedetails(long id, Bank bank);
void deletedetails(long id);
Bank getcustiddtls(long id);
}
