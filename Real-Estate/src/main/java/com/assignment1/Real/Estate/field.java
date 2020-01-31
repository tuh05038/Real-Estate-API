package com.assignment1.Real.Estate;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class field {

	public static List<List<String>> table = new ArrayList<List<String>>();

	public static void parseData() throws IOException {
		File csvData = new File("real-estate-data.csv");
		CSVParser csvParser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader("Street",
				"City", "Zip", "State", "Bed", "Bath", "sq_ft", "type", "sale_date", "price", "latitude", "longitude"));

		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(csvParser.spliterator(), false);

		csvRecordStream.skip(1).forEach(csvRecord -> {
			List<String> row = new ArrayList<String>();
			for (int i = 0; i < 12; i++) {
				row.add(csvRecord.get(i));
			}
			table.add(row);
		});
	}

	@RequestMapping(value = "/housing-statistics", method = RequestMethod.GET)
	public int getParam(@RequestParam(value = "statistic", defaultValue = "") String statistic,
			@RequestParam(value = "field", defaultValue = "") String field) {
		int stat = -1;
		int index = -1;
		field = field.toLowerCase();
		statistic = statistic.toLowerCase();

		if (field.compareTo("price") == 0) {
			index = 9;
		}
		if (field.compareTo("squareFootage") == 0 || field.compareTo("sq_ft") == 0) {
			index = 6;
		}

		if (statistic.compareTo("min") == 0 || statistic.compareTo("minimum") == 0) {
			stat = getMin(index);
		}

		if (statistic.compareTo("max") == 0 || statistic.compareTo("maximum") == 0) {
			stat = getMax(index);
		}

		if (statistic.compareTo("avg") == 0 || statistic.compareTo("average") == 0) {
			stat = getAvg(index);
		}

		if (statistic.compareTo("sum") == 0) {
			stat = getSum(index);
		}

		if (statistic.compareTo("range") == 0) {
			stat = getRange(index);
		}
		return stat;
	}

	public int getMin(int index) {
		int min = Integer.parseInt(table.get(0).get(index));
		int i = 1;
		int next;
		while (i < table.size()) {
			next = Integer.parseInt(table.get(i).get(index));
			if (min >= next) {
				min = next;
			}
			i++;
		}
		return min;
	}

	public int getMax(int index) {
		int max = Integer.parseInt(table.get(0).get(index));
		int i = 1;
		int next;
		while (i < table.size()) {
			next = Integer.parseInt(table.get(i).get(index));
			if (max <= next) {
				max = next;
			}
			i++;
		}
		return max;
	}

	public int getAvg(int index) {
		int avg;
		int i = 0;
		int totalSum = 0;
		while (i < table.size()) {
			int stat = Integer.parseInt(table.get(i).get(index));
			totalSum += stat;
			i++;
		}
		avg = totalSum / i;
		return avg;
	}

	public int getSum(int index) {
		int i = 0;
		int sum = 0;
		int stat;
		while (i < table.size()) {
			stat = Integer.parseInt(table.get(i).get(index));
			sum += stat;
			i++;
		}
		return sum;
	}

	public int getRange(int index) {
		int range = getMax(index) - getMin(index);
		return range;
	}

}
