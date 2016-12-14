package com.cinemall.auction;

import java.math.BigDecimal;

public class IAPlayer extends Player {
	
	public IAPlayer(long id, String name, BigDecimal initialValue) {
		super.setId(id);
		super.setName(name);
		super.setInitialValue(initialValue);
		super.setCurrentValue(initialValue);
	}

}
