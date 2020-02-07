package com.assignment1.Real.Estate;

public class maxStat {

	public static double getMax(int index) {
		double max = Integer.parseInt(getStat.table.get(0).get(index));
		int i = 1;
		double next;
		while (i < getStat.table.size()) {
			next = Integer.parseInt(getStat.table.get(i).get(index));
			if (max <= next) {
				max = next;
			}
			i++;
		}
		return max;
	}

}
