package com.tokigames.searchaggregator;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fligt")
public class FlightController {
                FlightServices services = new FlightServices();   
                public static void main(String[] args) {
                                FlightServices services = new FlightServices();
                                Flight f = services.getFlightListAsc(2);
                                System.out.println(f);
                }
 
                @GetMapping(value = "ASC/{index}", produces = { MediaType.APPLICATION_JSON_VALUE })
                public ResponseEntity<Flight> getFlightListAsc(
                                                @PathVariable("id") Integer id) {
                                Flight f = services.getFlightListAsc(id);
                                return new ResponseEntity<>(f, HttpStatus.OK);
                }

                @GetMapping(value = "DSC/{index}", produces = { MediaType.APPLICATION_JSON_VALUE })
                public ResponseEntity<Flight> getFlightListDsc(
                                                @PathVariable("id") Integer id) {
                                Flight f = services.getFlightListDsc(id);
                                return new ResponseEntity<>(f, HttpStatus.OK);
                }
 
                @GetMapping(value = "ASC", produces = { MediaType.APPLICATION_JSON_VALUE })
                public ResponseEntity<ArrayList<Flight>> getAllFlightAsc() {
                                ArrayList<Flight> f = services.getAllFlightAsc();
                                return new ResponseEntity<>(f, HttpStatus.OK);
                }

                @GetMapping(value = "DSC", produces = { MediaType.APPLICATION_JSON_VALUE })
                public ResponseEntity<ArrayList<Flight>> getAllFlightDsc() {
                                ArrayList<Flight> f = services.getAllFlightDsc();
                                return new ResponseEntity<>(f, HttpStatus.OK);
                }
}