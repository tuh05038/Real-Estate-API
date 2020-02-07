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
		double result= junit.getMin(6);
		assertEquals(0.0,result, 0.0001);
	}
	
	@Test
	void MinTestPrice() throws IOException {
		field junit= new field();
		field.parseData();
		double result= junit.getMin(9);
		assertEquals(1551.0,result, 0.0001);
	}
	
	@Test
	void MaxTestSqft() throws IOException {
		field junit= new field();
		field.parseData();
		double result= junit.getMax(6);
		assertEquals(5822.0,result, 0.0001);
	}
	
	@Test
	void MaxTestPrice() throws IOException {
		field junit= new field();
		field.parseData();
		double result= junit.getMax(9);
		assertEquals(884790.0,result, 0.0001);
	}
	
	@Test
	void RangeTestSqft() throws IOException {
		field junit= new field();
		field.parseData();
		double result= junit.getRange(6);
		assertEquals(5822.0,result, 0.0001);
	}
	
	@Test
	void RangeTestPrice() throws IOException {
		field junit= new field();
		field.parseData();
		double result= junit.getRange(9);
		assertEquals(883239.0,result, 0.0001);
	}
	
	@Test
	void AvgTestPrice() throws IOException{
		field junit=new field();
		field.parseData();
		double result=junit.getAvg(9);
		assertEquals(234144.26, result, 0.0001);
	}
	
	

}
