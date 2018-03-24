package controllers;

import models.City;
import models.Country;
import play.data.Form;
import play.data.FormFactory;
import play.data.validation.Constraints;
import play.mvc.*;
import static play.libs.F.Tuple;
import javax.inject.Inject;
import java.util.Map;
import java.util.HashMap;

import static play.libs.Json.toJson;

public class CityController extends Controller {

    @Inject FormFactory formFactory;

    public Result getAllCities() {
        return ok(toJson(City.findAll()));
    }

    public Result getCity(Long id) {
        City city = City.find(id);
        if (city != null) {
            return ok(toJson(city));
        } else {
            Map<String, Map<String, String>> error = new HashMap();
            Map<String, String> fields = new HashMap();
            fields.put("message", "No city was found for this id");
            fields.put("id", String.valueOf(id));
            error.put("error", fields);
            return badRequest(toJson(error));
        }
    }
    public Result getCityByName(String name) {
        City city = City.findByName(name);
        if (city != null) {
            return ok(toJson(city));
        } else {
            Map<String, Map<String, String>> error = new HashMap();
            Map<String, String> fields = new HashMap();
            fields.put("message", "No city was found for this name");
            fields.put("name", name);
            error.put("error", fields);
            return badRequest(toJson(error));
        }
    }

    public Result createCity() {
        Form<City> form = formFactory.form(City.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }
        else {
            City City = form.get();
            City.country = Country.find(City.country_id);
            City.save();
            return ok(toJson(City));
        }
    }

}
