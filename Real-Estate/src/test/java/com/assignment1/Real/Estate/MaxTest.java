package com.assignment1.Real.Estate;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class MaxTest {

	@Test
	void MaxTestSqft() throws IOException {
		getStat.parseData();
		double result = maxStat.getMax(6);
		assertEquals(5822.0, result, 0.0001);
	}

	@Test
	void MaxTestPrice() throws IOException {
		getStat.parseData();
		double result = maxStat.getMax(9);
		assertEquals(884790.0, result, 0.0001);
	}

}
