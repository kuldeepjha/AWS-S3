package com.ama.aws.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateUtilsConvert {

	public static void main(String args[]) throws ParseException {

		DateUtilsConvert dateUtilsConvert = new DateUtilsConvert();
		dateUtilsConvert.str_Date();
	}
	
	public String str_Date() {

		final String DATE_TIME_REGEX_MMDDYYYY1 = "^([1-9]|([012][0-9])|(3[01]))\\/([0]{0,1}[1-9]|1[012])\\/\\d\\d\\d\\d\\s([0-1]?[0-9]|2?[0-3]):([0-9]\\d):([0-9]\\d)$";
		DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
		DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
		String inputDateStr = "01/01/1992 00:00:00";
		Pattern pattern = Pattern.compile(DATE_TIME_REGEX_MMDDYYYY1);
		Date date1;
		try {
			date1 = inputFormat.parse(inputDateStr);
			return outputFormat.format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}