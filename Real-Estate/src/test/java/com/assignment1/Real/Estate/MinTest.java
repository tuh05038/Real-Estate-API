package com.assignment1.Real.Estate;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class MinTest {

	@Test
	void MinTestSqft() throws IOException {
		getStat.parseData();
		double result = minStat.getMin(6);
		assertEquals(0.0, result, 0.0001);
	}

	@Test
	void MinTestPrice() throws IOException {
		getStat.parseData();
		double result = minStat.getMin(9);
		assertEquals(1551.0, result, 0.0001);
	}

}
