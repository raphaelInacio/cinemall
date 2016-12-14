package com.cinemall.auction;

import java.math.BigDecimal;

public interface IActionPlayer {
	void processBid(BigDecimal value, Properties properties);
	void updateCurrentValue(BigDecimal value);
	boolean isValidValue(BigDecimal value);
}
