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
public class getStat {

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
	public String getParam(@RequestParam(value = "statistic", defaultValue = "") String statistic,
			@RequestParam(value = "field", defaultValue = "") String field) {
		double stat = -1.0;
		int index = -1;
		field = field.toLowerCase();
		statistic = statistic.toLowerCase();
		org.json.JSONObject result = new org.json.JSONObject();

		if (field.compareTo("price") == 0) {
			index = 9;
		}
		if (field.compareTo("squarefootage") == 0 || field.compareTo("sqft") == 0) {
			index = 6;
		}

		if (statistic.compareTo("min") == 0 || statistic.compareTo("minimum") == 0) {
			stat = minStat.getMin(index);
		}

		if (statistic.compareTo("max") == 0 || statistic.compareTo("maximum") == 0) {
			stat = maxStat.getMax(index);
		}

		if (statistic.compareTo("avg") == 0 || statistic.compareTo("average") == 0) {
			stat = avgStat.getAvg(index);
		}

		if (statistic.compareTo("sum") == 0) {
			stat = sumStat.getSum(index);
		}

		if (statistic.compareTo("range") == 0) {
			stat = rangeStat.getRange(index);
		}
		
		result.put("statistic", statistic);
		result.put("field", field);
		result.put("value", stat);
		return result.toString();
	}

}
