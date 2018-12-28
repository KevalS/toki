package com.tokigames.searchaggregator;

import java.text.ParseException;

public class BussinesFlight extends Flight {
	private String uuid;
	private String flight;
	private String departure;
	private String arrival;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) throws ParseException {
		set_departure(departure);
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) throws ParseException {
		set_arrival(arrival);
		this.arrival = arrival;
	}

	private void set_departure(String departure) throws ParseException {
		this._departureTime = DateUtility.getBussinessDateConversion(departure);
	}

	private void set_arrival(String arrival) throws ParseException {
		this._arrivalTime = DateUtility.getBussinessDateConversion(arrival);
	}

}
