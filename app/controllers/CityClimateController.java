package controllers;

import models.CityClimate;
import models.City;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

import static play.libs.Json.toJson;

public class CityClimateController extends Controller {

    @Inject FormFactory formFactory;

    public Result getAllCityClimates() {
        return ok(toJson(CityClimate.findAll()));
    }

    public Result createCityClimate() {
        Form<CityClimate> form = formFactory.form(CityClimate.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }
        else {
            CityClimate cityClimate = form.get();
            cityClimate.city = City.find(cityClimate.city_id);
            cityClimate.save();
            return ok(toJson(cityClimate));
        }
    }

}
