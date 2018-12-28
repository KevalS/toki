package com.tokigames.searchaggregator;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONArray;

public class FlightFactory {
                private final HashMap<Object, Object> cheapFlightMap = new HashMap<>();
                private final HashMap<Object, Object> businessFlightMap = new HashMap<>();
                private static ArrayList<Flight>  listFlight = new ArrayList<Flight>();
                private static ArrayList<Flight> listFlightDsc = null;             

                public void getFlightDetailsBaesedOnType(String type, String output) throws ParseException {
                                JSONArray array = new org.json.JSONArray(output);
                                for (int i = 0; i < array.length(); i++) {
                                                org.json.JSONObject jsonobject = (org.json.JSONObject) array.get(i);
                                                if (type.equalsIgnoreCase("cheap")) {
                                                                setCheapFlightList(jsonobject);
                                                                long departureTime = (long) jsonobject.get("departureTime");
                                                                cheapFlightMap.put(departureTime, jsonobject);
                                                } else if (type.equalsIgnoreCase("business")) {
                                                                setBussinesFlightList(jsonobject);
                                                                String departureTime = (String) jsonobject.get("departure");
                                                                departureTime = departureTime.replace("T", " ");
                                                                departureTime = departureTime.replace("Z", "");
                                                                Timestamp ts2 = Timestamp.valueOf(departureTime);
                                                                long tsTime1 = ts2.getTime();
                                                                businessFlightMap.put(tsTime1, jsonobject);
                                                }
                                }
                }

                private void setBussinesFlightList(org.json.JSONObject jsonobject) throws ParseException{
                                BussinesFlight flight = new BussinesFlight();
                                String departure = jsonobject.get("departure").toString();
                                String uuid =  jsonobject.get("uuid").toString();
                                String flightStr =  jsonobject.get("flight").toString();
                                String arrival = jsonobject.get("arrival").toString();
                                flight.setArrival(arrival);
                                flight.setDeparture(departure);
                                flight.setFlight(flightStr);
                                flight.setUuid(uuid);
                                listFlight.add(flight);                              
                }

                private void setCheapFlightList(org.json.JSONObject jsonobject){
                                String departureTime = jsonobject.get("departureTime").toString();
                                String id = jsonobject.get("id").toString();
                                String departure =  jsonobject.get("departure").toString();
                                String arrivalTime =  jsonobject.get("arrivalTime").toString();
                                CheapFlight flight = new CheapFlight();
                                flight.setArrivalTime(arrivalTime);
                                flight.setDeparture(departure);
                                flight.setDepartureTime(departureTime);
                                flight.setId(id);
                                listFlight.add(flight);
                }

                public static  ArrayList<Flight> getSortedFlightListAsc(){
                                Collections.sort(listFlight,new DepartureTimeComp());
                                return listFlight;
                }

                public static  ArrayList<Flight> getSortedFlightListDsc(){
                                listFlightDsc = new ArrayList<>(listFlight);
                                Collections.sort(listFlightDsc,new DepartureTimeComp());
                                return listFlightDsc;
                }

                public HashMap<Object, Object> getCheapFlightMap() {
                                return cheapFlightMap;
                }

                public HashMap<Object, Object> getBuissinessFlightMap() {
                                return businessFlightMap;
                }

               

               

}