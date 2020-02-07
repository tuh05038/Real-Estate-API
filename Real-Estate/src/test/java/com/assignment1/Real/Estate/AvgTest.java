package com.assignment1.Real.Estate;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class AvgTest {

	@Test
	void AvgTestPrice() throws IOException {
		getStat.parseData();
		double result = avgStat.getAvg(9);
		assertEquals(234144.26, result, 0.0001);
	}

}
