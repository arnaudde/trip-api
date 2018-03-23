// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/user/tripapi/conf/routes
// @DATE:Fri Mar 23 11:23:54 GMT 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:27
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseCityController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getCity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CityController.getCity",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "city/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:14
    def createCity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CityController.createCity",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "city"})
        }
      """
    )
  
    // @LINE:18
    def getAllCities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CityController.getAllCities",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cities"})
        }
      """
    )
  
    // @LINE:16
    def getCityByName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CityController.getCityByName",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "city/name/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseCountryController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getCountry: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountryController.getCountry",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "country/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:9
    def createCountry: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountryController.createCountry",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "country"})
        }
      """
    )
  
    // @LINE:10
    def getAllCountries: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountryController.getAllCountries",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "countries"})
        }
      """
    )
  
    // @LINE:12
    def getCountryByName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountryController.getCountryByName",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "country/name/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseAirlineServiceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def getAllAirlineServices: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AirlineServiceController.getAllAirlineServices",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "airline-services"})
        }
      """
    )
  
    // @LINE:20
    def createAirlineService: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AirlineServiceController.createAirlineService",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "airline-service"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseFlightController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getAllFlights: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FlightController.getAllFlights",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "flights"})
        }
      """
    )
  
    // @LINE:6
    def createFlight: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FlightController.createFlight",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "flight"})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseCityClimateController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def createCityClimate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CityClimateController.createCityClimate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "city-climate"})
        }
      """
    )
  
    // @LINE:24
    def getAllCityClimates: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CityClimateController.getAllCityClimates",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "city-climates"})
        }
      """
    )
  
  }


}
