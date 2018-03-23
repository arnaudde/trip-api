package controllers;

import models.Country;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import java.util.Map;
import java.util.HashMap;

import javax.inject.Inject;

import static play.libs.Json.toJson;

public class CountryController extends Controller {

    @Inject FormFactory formFactory;

    public Result getAllCountries() {
        return ok(toJson(Country.findAll()));
    }

    public Result getCountry(Long id) {
        Country country = Country.find(id);
        if (country != null) {
            return ok(toJson(country));
        } else {
            Map<String, Map<String, String>> error = new HashMap();
            Map<String, String> fields = new HashMap();
            fields.put("message", "No country was found for this id");
            fields.put("id", String.valueOf(id));
            error.put("error", fields);
            return badRequest(toJson(error));
        }
    }
    public Result getCountryByName(String name) {
        Country country = Country.findByName(name);
        if (country != null) {
            return ok(toJson(country));
        }
        else {
            Map<String, Map<String, String>> error = new HashMap();
            Map<String, String> fields = new HashMap();
            fields.put("message", "No country was found for this name");
            fields.put("name", name);
            error.put("error", fields);
            return badRequest(toJson(error));
        }
     }

    public Result createCountry() {
        Form<Country> form = formFactory.form(Country.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }
        else {
            Country country = form.get();
            country.save();
            return ok(toJson(country));
        }
    }
}
