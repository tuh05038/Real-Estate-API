package com.assignment1.Real.Estate;

public class rangeStat {

	public static double getRange(int index) {
		double min = Integer.parseInt(getStat.table.get(0).get(index));
		double max = Integer.parseInt(getStat.table.get(0).get(index));
		int i = 1;
		double next;
		while (i < getStat.table.size()) {
			next = Integer.parseInt(getStat.table.get(i).get(index));
			if (min >= next) {
				min = next;
			}
			if (max <= next) {
				max = next;
			}
			i++;
		}
		return max - min;
	}

}
