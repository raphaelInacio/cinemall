package com.cinemall.auction;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.util.Scanner;

public class Player  {
	
	private long id;
	private String name;
	private BigDecimal initialValue;
	private BigDecimal currentValue;
	private Bid bid;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getInitialValue() {
		return initialValue;
	}


	public void setInitialValue(BigDecimal initialValue) {
		this.initialValue = initialValue;
	}


	public BigDecimal getCurrentValue() {
		return currentValue;
	}


	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}


	public Bid getBid() {
		return bid;
	}


	public void setBid(Bid bid) {
		this.bid = bid;
	}

}
