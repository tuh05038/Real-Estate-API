package com.assignment1.Real.Estate;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

//test that find the min, max, and range for sqft and price statistics
class StatTests {

	@Test
	void MinTestSqft() throws IOException {
		field junit= new field();
		field.parseData();
		int result= junit.getMin(6);
		assertEquals(0,result);
	}
	
	@Test
	void MinTestPrice() throws IOException {
		field junit= new field();
		field.parseData();
		int result= junit.getMin(9);
		assertEquals(1551,result);
	}
	
	@Test
	void MaxTestSqft() throws IOException {
		field junit= new field();
		field.parseData();
		int result= junit.getMax(6);
		assertEquals(5822,result);
	}
	
	@Test
	void MaxTestPrice() throws IOException {
		field junit= new field();
		field.parseData();
		int result= junit.getMax(9);
		assertEquals(884790,result);
	}
	
	@Test
	void RangeTestSqft() throws IOException {
		field junit= new field();
		field.parseData();
		int result= junit.getRange(6);
		assertEquals(5822,result);
	}
	
	@Test
	void RangeTestPrice() throws IOException {
		field junit= new field();
		field.parseData();
		int result= junit.getRange(9);
		assertEquals(883239,result);
	}
	
	//wowowowowowowowowwow
	

}
