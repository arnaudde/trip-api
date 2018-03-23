// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/user/tripapi/conf/routes
// @DATE:Fri Mar 23 11:23:54 GMT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:27
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:14
  class ReverseCityController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getCity(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "city/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:14
    def createCity(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "city")
    }
  
    // @LINE:18
    def getAllCities(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cities")
    }
  
    // @LINE:16
    def getCityByName(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "city/name/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
  }

  // @LINE:9
  class ReverseCountryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getCountry(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "country/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:9
    def createCountry(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "country")
    }
  
    // @LINE:10
    def getAllCountries(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "countries")
    }
  
    // @LINE:12
    def getCountryByName(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "country/name/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
  }

  // @LINE:20
  class ReverseAirlineServiceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def getAllAirlineServices(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "airline-services")
    }
  
    // @LINE:20
    def createAirlineService(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "airline-service")
    }
  
  }

  // @LINE:6
  class ReverseFlightController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getAllFlights(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "flights")
    }
  
    // @LINE:6
    def createFlight(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "flight")
    }
  
  }

  // @LINE:23
  class ReverseCityClimateController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def createCityClimate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "city-climate")
    }
  
    // @LINE:24
    def getAllCityClimates(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "city-climates")
    }
  
  }


}
