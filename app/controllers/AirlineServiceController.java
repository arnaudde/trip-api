package controllers;

import models.AirlineService;
import models.City;
import play.data.Form;
import play.data.FormFactory;
import play.data.validation.Constraints;
import play.mvc.*;
import static play.libs.F.Tuple;
import javax.inject.Inject;

import static play.libs.Json.toJson;

public class AirlineServiceController extends Controller {

    @Inject FormFactory formFactory;

    public Result getAllAirlineServices() {
        return ok(toJson(AirlineService.findAll()));
    }

    public Result createAirlineService() {
        Form<AirlineService> form = formFactory.form(AirlineService.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }
        else {
            AirlineService airlineService = form.get();
            airlineService.departure = City.find(airlineService.departure_id);
            airlineService.arrival = City.find(airlineService.arrival_id);
            airlineService.save();
            return ok(toJson(airlineService));
        }
    }

}
