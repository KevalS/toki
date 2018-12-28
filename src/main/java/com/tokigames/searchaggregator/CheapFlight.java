package com.tokigames.searchaggregator;


public class CheapFlight extends Flight {

	private String id;
	private String departure;
	private String departureTime;
	private String arrivalTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		_setDepartureTime(departureTime);
		this.departureTime = departureTime;
	}

	private void _setDepartureTime(String departureTime2) {
		this._departureTime = DateUtility
				.getCheapFlightConvertsion(departureTime2);

	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		_setArrivalTime(arrivalTime);
		this.arrivalTime = arrivalTime;
	}

	private void _setArrivalTime(String arrivalTime2) {
		this._arrivalTime = DateUtility.getCheapFlightConvertsion(arrivalTime2);
	}

}
