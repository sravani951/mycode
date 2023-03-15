package com.example.demoforJava2.serviceimpl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoforJava2.entity.Bank;
import com.example.demoforJava2.exception.ResouceNotFoundException;
import com.example.demoforJava2.repo.BankRepo;
import com.example.demoforJava2.service.BankService;

@Service
public class ServiceImpl implements BankService{
      private BankRepo bankRepo;
      
     public ServiceImpl(BankRepo bankRepo) {
		super();
		this.bankRepo = bankRepo;
	}
   @Override
     public Bank saveDetails(Bank bank) {
		return bankRepo.save(bank);
	}
   @Override
   public List<Bank> getDetails() {
	   return bankRepo.findAll();
	   
	  
   }

   
@Override
public void deletedetails(long id) {
	 bankRepo.findById(id).orElseThrow(()->new ResouceNotFoundException("Bank","id",id));
	 bankRepo.deleteById(id);
	
}
@Override
public Bank updatedetails(long id, Bank bank1) {
	Optional<Bank> bank = bankRepo.findById(id);
	if(bank.isPresent()) {
		bank.get().setBenaccno(bank1.getBenaccno());
		bank.get().setCustacno(bank1.getCustacno());
		bank.get().setCustname(bank1.getCustname());
	return bankRepo.save(bank.get());
	   }
	else {
	throw new ResouceNotFoundException("Bank","id",id);
}
	
}
@Override
public Bank getcustiddtls(long id) {
	Optional<Bank> bank = bankRepo.findById(id);
	if(bank.isPresent()) {
		return bankRepo.getById(id);
	}
	else throw new ResouceNotFoundException("Bank","id",id);
}

	
	
      
}
