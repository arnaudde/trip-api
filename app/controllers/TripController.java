package controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import models.City;
import models.Flight;
import play.mvc.*;
import static play.libs.Json.toJson;

public class TripController extends Controller {

  public Result getTrip(
      String departureName,
      String secondDepartureName,
      String arrivalName,
      String departureDate,
      String returnDate,
      Integer minDepartureTime,
      Integer maxDepartureTime,
      Integer minDepartureTimeReturn,
      Integer maxDepartureTimeReturn,
      Integer minSecondDepartureTime,
      Integer maxSecondDepartureTime,
      Integer minSecondDepartureTimeReturn,
      Integer maxSecondDepartureTimeReturn,
      Integer maxDuration) {
    City departure = City.findByName(departureName);
    City arrival = City.findByName(arrivalName);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date start = dateFormat.parse(departureDate);
      Date end = dateFormat.parse(returnDate);
      Flight outboundFlight = Flight.getByParams(
          departure.getAirport_code(),
          arrival.getAirport_code(),
          start,
          minDepartureTime,
          maxDepartureTime,
          maxDuration
      );

      Flight inboundFlight = Flight.getByParams(
          arrival.getAirport_code(),
          departure.getAirport_code(),
          end,
          minDepartureTimeReturn,
          maxDepartureTimeReturn,
          maxDuration
      );



      if (inboundFlight == null || outboundFlight == null) {
        Map<String, Map<String, String>> response = new HashMap();
        Map<String, String> error_fields = new HashMap();
        error_fields.put("message", "No flight was found for the first departure");
        error_fields.put("departure", departureName);
        error_fields.put("arrival", arrivalName);
        error_fields.put("minDepartureTime", String.valueOf(minDepartureTime));
        error_fields.put("maxDepartureTime", String.valueOf(maxDepartureTime));
        error_fields.put("minDepartureTimeReturn", String.valueOf(minDepartureTimeReturn));
        error_fields.put("maxDepartureTimeReturn", String.valueOf(maxDepartureTimeReturn));
        error_fields.put("maxDuration", String.valueOf(maxDuration));
        response.put("error", error_fields);
        return ok(toJson(response));
      }
      Map<String, Integer> fields = new HashMap();
      fields.put("Outbound price", outboundFlight.getPrice());
      fields.put("Inbound price", inboundFlight.getPrice());

      if (secondDepartureName != null) {
        City secondDeparture = City.findByName(secondDepartureName);

        Flight secondOutboundFlight = Flight.getByParams(
            secondDeparture.getAirport_code(),
            arrival.getAirport_code(),
            start,
            minSecondDepartureTime,
            maxSecondDepartureTime,
            maxDuration
        );

        Flight secondInboundFlight = Flight.getByParams(
            arrival.getAirport_code(),
            secondDeparture.getAirport_code(),
            end,
            minSecondDepartureTimeReturn,
            maxSecondDepartureTimeReturn,
            maxDuration
        );

        if (secondInboundFlight == null || secondOutboundFlight == null) {
          Map<String, Map<String, String>> response = new HashMap();
          Map<String, String> error_fields = new HashMap();
          error_fields.put("message", "No flight was found for the second departure");
          error_fields.put("secondDepature", secondDepartureName);
          error_fields.put("arrival", arrivalName);
          error_fields.put("minSecondDepartureTime", String.valueOf(minSecondDepartureTime));
          error_fields.put("maxSecondDepartureTime", String.valueOf(maxSecondDepartureTime));
          error_fields.put("minSecondDepartureTimeReturn", String.valueOf(minSecondDepartureTimeReturn));
          error_fields.put("maxSecondDepartureTimeReturn", String.valueOf(maxSecondDepartureTimeReturn));
          error_fields.put("maxDuration", String.valueOf(maxDuration));
          response.put("error", error_fields);
          return ok(toJson(response));
        }
        fields.put("Second outbound price", secondOutboundFlight.getPrice());
        fields.put("Second inbound price", secondInboundFlight.getPrice());
      }
      return ok(toJson(fields));
    } catch (ParseException e) {
      return badRequest("Wrong date format");
    }

  }
}
