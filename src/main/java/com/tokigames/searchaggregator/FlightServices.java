/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokigames.searchaggregator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author KEVAL
 */
public class FlightServices {

	private static Map<Object, Object> getSortedCollection(HashMap<Object, Object> combineMap, String type) {
		Map<Object, Object> hmap = new TreeMap<>();
		hmap.putAll(combineMap);
		if (type.equalsIgnoreCase("ASC"))
			return hmap;
		else if (type.equalsIgnoreCase("DES")) {
			Map<Object, Object> reverseSortedMap = new TreeMap<>(
					Collections.reverseOrder());
			reverseSortedMap.putAll(combineMap);
			return reverseSortedMap;
		} else
			return combineMap;
	}

	public Flight getFlightListAsc(Integer index) {
		return FlightFacade.getSortedListAscByIndex(index);
	}

	public Flight getFlightListDsc(Integer index) {
		return FlightFacade.getSortedListDscByIndex(index);
	}

	public ArrayList<Flight> getAllFlightAsc() {
		return FlightFacade.getFlightListAsc();
	}

	public ArrayList<Flight> getAllFlightDsc() {
		return FlightFacade.getFlightListDsc();
	}
}
