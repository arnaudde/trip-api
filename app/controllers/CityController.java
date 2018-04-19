package controllers;

import io.ebean.Ebean;
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

    @Inject
    FormFactory formFactory;

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
        } else {
            City city = form.get();
            city.country = Country.find(city.country_id);
            city.save();
            return ok(toJson(city));
        }
    }

    public Result updateCity(Long id) {
      Form<City> form = formFactory.form(City.class).bindFromRequest();
      if (form.hasErrors()) {
        return badRequest(form.errorsAsJson());
      } else {
        City city = City.find(id);
        if (city == null)
        {
          Map<String, Map<String, String>> error = new HashMap();
          Map<String, String> fields = new HashMap();
          fields.put("message", "Could not update, no city was found for this id");
          fields.put("id", String.valueOf(id));
          error.put("error", fields);
          return badRequest(toJson(error));
        } else {
          City newCity = form.get();
          Country country = Country.find(newCity.country_id);
          if (country == null) {
            Map<String, Map<String, String>> error = new HashMap();
            Map<String, String> fields = new HashMap();
            fields.put("message", "Could not update, no city was found for this country");
            fields.put("country", String.valueOf(newCity.country_id));
            error.put("error", fields);
            return badRequest(toJson(error));
          }
          else {
            newCity.setCountry(country);
            newCity.setId(id);
            newCity.update();
            return ok(toJson(newCity));
          }
        }
      }
    }
}
