package controllers;

import models.Flight;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

import static play.libs.Json.toJson;

public class FlightController extends Controller {

    @Inject FormFactory formFactory;

    public Result getAllFlights() {
        return ok(toJson(Flight.findAll()));
    }

    public Result createFlight() {
        Form<Flight> form = formFactory.form(Flight.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }
        else {
            Flight flight = form.get();
            flight.save();
            return ok(toJson(flight));
        }
    }

}
