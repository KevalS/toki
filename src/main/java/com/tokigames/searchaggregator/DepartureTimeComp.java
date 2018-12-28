package com.tokigames.searchaggregator;

import java.util.Comparator;

public class DepartureTimeComp implements Comparator<Flight> {

	@Override
	public int compare(Flight a, Flight b) {
		return a.get_departure().equals(b.get_departure()) ? 1 : -1;
	}

}
