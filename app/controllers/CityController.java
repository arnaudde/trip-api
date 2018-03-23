package controllers;

import models.City;
import models.Country;
import play.data.Form;
import play.data.FormFactory;
import play.data.validation.Constraints;
import play.mvc.*;
import static play.libs.F.Tuple;
import javax.inject.Inject;

import static play.libs.Json.toJson;

public class CityController extends Controller {

    @Inject FormFactory formFactory;

    public Result getAllCities() {
        return ok(toJson(City.findAll()));
    }

    public Result getCity(Long id) { return ok(toJson(City.find(id))); }
    public Result getCityByName(String name) { return ok(toJson(City.findByName(name))); }

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
