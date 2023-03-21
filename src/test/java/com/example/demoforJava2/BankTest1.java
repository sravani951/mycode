package com.example.demoforJava2;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import com.example.demoforJava2.entity.Bank;
import com.example.demoforJava2.repo.BankRepo;

@SpringBootTest
public class BankTest1 {
@Autowired
BankRepo bankRepo;
@Order(1)
@Test
public void saveBankTest() {
	Bank bank = new Bank();
	bank.setId(2);
	bank.setBenaccno(1234);
	bank.setCustacno(74646);
	bank.setCustname("sharma");
	bankRepo.save(bank);
	Assertions.assertNotNull(bankRepo.findById(2L).get());

}
@Order(3)
@Test
public void getIddtls() {
	Bank b=bankRepo.findById(2L).get();
	assertThat(b.getId()).isEqualTo(2L);
}
@Order(2)
@Test
public void getAlldtls() {
	List<Bank> list=bankRepo.findAll();
	assertThat(list.size()).isGreaterThan(0);
	
	}
@Order(4)
@Test
public void bankUpdate() {
	Bank bank= bankRepo.findById(2L).get();
	bank.setCustname("rohitsharma1");
	bankRepo.save(bank);
	Assertions.assertNotEquals("rohitsharma", bankRepo.findById(2L).get().getCustname());
	
}
@Order(5)
@Test
public void deleteId() {
	bankRepo.deleteById(21L);
    assertThat(bankRepo.existsById(20L)).isFalse();
}
}
