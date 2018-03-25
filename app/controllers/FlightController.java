package controllers;

import models.Flight;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import java.util.Map;
import java.util.HashMap;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import static play.libs.Json.toJson;

import java.text.ParseException;

public class FlightController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result getAllFlights() {
        return ok(toJson(Flight.findAll()));
    }

    public Result createFlight() {
        Form<Flight> form = formFactory.form(Flight.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        } else {
            Flight flight = form.get();
            flight.save();
            return ok(toJson(flight));
        }
    }

    public Result getFlightByParams(String departure,
                                    String arrival,
                                    String date,
                                    Integer min_departure_time,
                                    Integer max_departure_time,
                                    Integer max_duration) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Flight flight = Flight.getByParams(departure,
                    arrival,
                    dateFormat.parse(date),
                    min_departure_time,
                    max_departure_time,
                    max_duration);
            if (flight != null) {
                return ok(toJson(flight));
            } else {
                Map<String, Map<String, String>> error = new HashMap();
                Map<String, String> fields = new HashMap();
                fields.put("message", "No flight was found for this query");
                fields.put("depature", departure);
                fields.put("arrival", arrival);
                fields.put("date", date);
                fields.put("min_departure_time", String.valueOf(min_departure_time));
                fields.put("max_departure_time", String.valueOf(max_departure_time));
                fields.put("max_duration", String.valueOf(max_duration));
                error.put("error", fields);
                return badRequest(toJson(error));
            }
        } catch (ParseException e) {
            return badRequest("Date is not valid");
        }
    }
}
