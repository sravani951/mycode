package com.example.demoforJava2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 private long id;
 private String custname;
 private long custacno;

 public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCustname() {
	return custname;
}
public void setCustname(String custname) {
	this.custname = custname;
}
public Bank(long id, String custname, long custacno, long benaccno) {
	super();
	this.id = id;
	this.custname = custname;
	this.custacno = custacno;
	this.benaccno = benaccno;
}
public Bank() {
	super();
	// TODO Auto-generated constructor stub
}
public long getCustacno() {
	return custacno;
}
public void setCustacno(long custacno) {
	this.custacno = custacno;
}
@Override
public String toString() {
	return "Bank [id=" + id + ", custname=" + custname + ", custacno=" + custacno + ", benaccno=" + benaccno + "]";
}
public long getBenaccno() {
	return benaccno;
}
public void setBenaccno(long benaccno) {
	this.benaccno = benaccno;
}
private long benaccno;
}
