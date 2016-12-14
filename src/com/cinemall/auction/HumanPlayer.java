package com.cinemall.auction;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.util.Scanner;

public class HumanPlayer extends Player implements IActionPlayer {

	public HumanPlayer(long id, String name, BigDecimal initialValue) {
		super.setId(id);
		super.setName(name);
		super.setInitialValue(initialValue);
		super.setCurrentValue(initialValue);
	}

	@Override
	public void processBid(BigDecimal value, Properties properties) {
		boolean condition = true;
		while (condition) {
			@SuppressWarnings("resource") // never close System.in!
			Scanner s = new Scanner(System.in);
			try {
				out.println("Por favor insira o lance para a propriedade:" + properties.getName() + ", ultimo lance."
						+ properties.getLastValue());
				String bid = s.nextLine();
				BigDecimal bidValue = new BigDecimal(bid);
				if (isValidValue(bidValue)) {
					updateCurrentValue(new BigDecimal(bid));
				}
			} catch (Exception e) {
				continue;
			}
		}

	}

	@Override
	public void updateCurrentValue(BigDecimal value) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValidValue(BigDecimal value) {
		if (value.intValue() > super.getCurrentValue().intValue()) {
			return true;
		} else {
			return false;
		}
	}

}
