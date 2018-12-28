package com.tokigames.searchaggregator;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightFacade {
	
	static {
		try {
			getAllFlightDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static ArrayList<Flight> listAsc, listDSC;

	private static HashMap<Object, Object> getFlightInformation(String url)
			throws Exception {
		String flightOutput = HttpJsonClient.getJsonOutput(url);
		FlightFactory factory = new FlightFactory();
		factory.getFlightDetailsBaesedOnType(HttpJsonClient.getType(),
				flightOutput);
		listAsc = factory.getSortedFlightListAsc();
		listDSC = factory.getSortedFlightListDsc();
		return factory.getCheapFlightMap();
	}

	public static HashMap<Object, Object> getAllFlightDetails()
			throws Exception {
		HashMap<Object, Object> cheapFlightDetails = getFlightInformation("https://obscure-caverns-79008.herokuapp.com/cheap");
		HashMap<Object, Object> bussinessFlightDetails = getFlightInformation("https://obscure-caverns-79008.herokuapp.com/business");

		HashMap<Object, Object> combineMap = new HashMap<>();
		combineMap.putAll(cheapFlightDetails);
		combineMap.putAll(bussinessFlightDetails);

		return combineMap;
	}
	
	public static ArrayList<Flight>  getFlightListAsc(){
		return listAsc;
	}
	
	public static ArrayList<Flight>  getFlightListDsc(){
		return listDSC;
	}

	public static Flight getSortedListAscByIndex(int index) {
		return listAsc.get(index);
	}

	public static Flight getSortedListDscByIndex(int index) {
		return listAsc.get(index);
	}

}
