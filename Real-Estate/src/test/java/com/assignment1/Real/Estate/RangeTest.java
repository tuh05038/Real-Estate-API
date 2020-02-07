package com.assignment1.Real.Estate;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class RangeTest {

	@Test
	void RangeTestSqft() throws IOException {
		getStat.parseData();
		double result = rangeStat.getRange(6);
		assertEquals(5822.0, result, 0.0001);
	}

	@Test
	void RangeTestPrice() throws IOException {
		getStat.parseData();
		double result = rangeStat.getRange(9);
		assertEquals(883239.0, result, 0.0001);
	}

}
