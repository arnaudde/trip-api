package controllers;

import models.AirlineService;
import models.City;
import play.data.Form;
import play.data.FormFactory;
import play.data.validation.Constraints;
import play.mvc.*;
import static play.libs.F.Tuple;
import javax.inject.Inject;
import java.util.Map;
import java.util.HashMap;

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

    public Result getAirlineServiceByParams(Long departure_id,
                                    Long arrival_id,
                                    Integer month,
                                    Integer min_departure_time,
                                    Integer max_departure_time,
                                    Integer max_duration) {
        AirlineService airlineService = AirlineService.getByParams(departure_id,
                arrival_id,
                month,
                min_departure_time,
                max_departure_time,
                max_duration);
        if (airlineService != null) {
            return ok(toJson(airlineService));
        } else {
            Map<String, Map<String, String>> error = new HashMap();
            Map<String, String> fields = new HashMap();
            fields.put("message", "No flight was found for this query");
            fields.put("depature_id", String.valueOf(departure_id));
            fields.put("month", String.valueOf(month));
            fields.put("arrival_id", String.valueOf(arrival_id));
            fields.put("min_departure_time", String.valueOf(min_departure_time));
            fields.put("max_departure_time", String.valueOf(max_departure_time));
            fields.put("max_duration", String.valueOf(max_duration));
            error.put("error", fields);
            return badRequest(toJson(error));
        }
    }

}
