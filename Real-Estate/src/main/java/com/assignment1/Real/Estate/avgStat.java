package com.assignment1.Real.Estate;

import org.apache.commons.math3.util.Precision;

public class avgStat {

	public static double getAvg(int index) {
		double avg;
		int i = 0;
		double totalSum = 0;
		// For loop here?
		while (i < getStat.table.size()) {
			// Table being a global variable here does make these functions a bit harder to test.
			int stat = Integer.parseInt(getStat.table.get(i).get(index));
			totalSum += stat;
			i++;
		}
		avg = totalSum / i;
		return Precision.round(avg, 2);
	}

}
