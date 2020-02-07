package com.assignment1.Real.Estate;

public class sumStat {

	public static double getSum(int index) {
		int i = 0;
		double sum = 0;
		double stat;
		while (i < getStat.table.size()) {
			stat = Integer.parseInt(getStat.table.get(i).get(index));
			sum += stat;
			i++;
		}
		return sum;
	}

}
