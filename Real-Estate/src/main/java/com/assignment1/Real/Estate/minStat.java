package com.assignment1.Real.Estate;

public class minStat {

	public static double getMin(int index) {
		double min = Integer.parseInt(getStat.table.get(0).get(index));
		int i = 1;
		double next;
		while (i < getStat.table.size()) {
			next = Integer.parseInt(getStat.table.get(i).get(index));
			if (min >= next) {
				min = next;
			}
			i++;
		}
		return min;
	}

}
