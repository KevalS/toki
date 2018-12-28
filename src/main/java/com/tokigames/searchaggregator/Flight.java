package com.tokigames.searchaggregator;

public abstract class Flight {
	protected String _departureTime;
	protected String _arrivalTime;

	public String get_departure() {
		return _departureTime;
	}

	public String get_arrival() {
		return _arrivalTime;
	}
}
