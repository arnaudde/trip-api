// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/user/tripapi/conf/routes
// @DATE:Fri Mar 23 11:23:54 GMT 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCityController CityController = new controllers.ReverseCityController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCountryController CountryController = new controllers.ReverseCountryController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAirlineServiceController AirlineServiceController = new controllers.ReverseAirlineServiceController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFlightController FlightController = new controllers.ReverseFlightController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCityClimateController CityClimateController = new controllers.ReverseCityClimateController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCityController CityController = new controllers.javascript.ReverseCityController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCountryController CountryController = new controllers.javascript.ReverseCountryController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAirlineServiceController AirlineServiceController = new controllers.javascript.ReverseAirlineServiceController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFlightController FlightController = new controllers.javascript.ReverseFlightController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCityClimateController CityClimateController = new controllers.javascript.ReverseCityClimateController(RoutesPrefix.byNamePrefix());
  }

}
