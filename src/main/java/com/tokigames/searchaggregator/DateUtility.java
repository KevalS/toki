package com.tokigames.searchaggregator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtility {
	public static String getBussinessDateConversion(String dateStr) throws ParseException{
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		 Date date = dateFormat.parse(dateStr);//You will get date object relative to server/client timezone wherever it is parsed
		 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
		 return formatter.format(date);
	}
	
	public static String getCheapFlightConvertsion(String arrivalTime) {
		Date date = new Date(Long.parseLong(arrivalTime));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(date);
	}
}
