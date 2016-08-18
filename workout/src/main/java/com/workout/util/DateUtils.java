package com.workout.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtils {
	
	private static final String DATE_FORMATE = "dd-MM-yyyy";
	
	public static LocalDate convertDateStringToDate(String date) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATE);
		LocalDate dateConverted = LocalDate.parse(date, dateTimeFormatter);
		
		return dateConverted;
	}

}
