package com.example.demoforJava2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoforJava2.entity.Bank;
import com.example.demoforJava2.repo.BankRepo;
import com.example.demoforJava2.service.BankService;




@RestController
public class BankController {
	
	private BankService bankService;
	
	
	public BankController(BankService bankService) {
		super();
		this.bankService = bankService;
	}
	@PostMapping("/api/custdetails")
    public ResponseEntity<Bank> bankdetails(@RequestBody Bank bank) {
	return new ResponseEntity<Bank>(bankService.saveDetails(bank), HttpStatus.CREATED);
     }
	@GetMapping("/api/custbdetails")
	public ResponseEntity<List<Bank>> getdetails() {
		return new ResponseEntity<>(bankService.getDetails(),HttpStatus.OK);
	}
	@GetMapping("/api/custbdetails/{id}")
	public ResponseEntity<Bank> getiddetails(@PathVariable long id){
		return new ResponseEntity<>(bankService.getcustiddtls(id), HttpStatus.OK);
	}
	
//	@GetMapping("/api/custiddetails/{id}")
//	public ResponseEntity<Bank> getiddetails(@PathVariable long id) {
//	Optional<Bank> bank = bankRepo.findById(id);
//		if(bank.isPresent()) {
//			return new ResponseEntity<>(bank.get(),HttpStatus.OK);
//		   }
//		else {
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
//	}
	

//	@PutMapping("/api/custiddetails/{id}")
//	public ResponseEntity<Bank> updateiddetails(@PathVariable long id, @RequestBody Bank bank1) {
//	Optional<Bank> bank = bankRepo.findById(id);
//		if(bank.isPresent()) {
//			bank.get().setBenaccno(bank1.getBenaccno());
//			bank.get().setCustacno(bank1.getCustacno());
//			bank.get().setCustname(bank1.getCustname());
//			return new ResponseEntity<>(bankRepo.save(bank.get()),HttpStatus.OK);
//		   }
//		else {
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
//	}
	
	@PutMapping("/api/custiddetails/{id}")
	public ResponseEntity<Bank> updateiddetails(@PathVariable long id, @RequestBody Bank bank){
		return new ResponseEntity<Bank>(bankService.updatedetails(id, bank),HttpStatus.OK);
	}
//	@DeleteMapping("/api/delcustiddetails/{id}")
//	public ResponseEntity<Bank> deleteiddetails(@PathVariable long id) {
//	Optional<Bank> bank = bankRepo.findById(id);
//		if(bank.isPresent()) {
//			bankRepo.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.OK);
//		   }
//		else {
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
//	}
	@DeleteMapping("/api/delcustiddetails/{id}")
	public ResponseEntity<String> deleteiddetails(@PathVariable long id) {
		bankService.deletedetails(id);
		return new ResponseEntity<String>("Id deleted successfully",HttpStatus.OK);
	}

	
	
}
