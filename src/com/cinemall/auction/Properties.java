package com.cinemall.auction;

import java.math.BigDecimal;

public class Properties {
	private long id;
	private String name;
	private BigDecimal lastValue;
	
	public Properties(long id, String name) {
		this.id = id;
		this.name = name;
	}

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

	public BigDecimal getLastValue() {
		return lastValue;
	}

	public void setLastValue(BigDecimal lastValue) {
		this.lastValue = lastValue;
	}
	
	
}
