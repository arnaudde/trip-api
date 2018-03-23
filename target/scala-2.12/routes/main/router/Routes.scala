// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/user/tripapi/conf/routes
// @DATE:Fri Mar 23 11:23:54 GMT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  FlightController_0: controllers.FlightController,
  // @LINE:9
  CountryController_1: controllers.CountryController,
  // @LINE:14
  CityController_4: controllers.CityController,
  // @LINE:20
  AirlineServiceController_3: controllers.AirlineServiceController,
  // @LINE:23
  CityClimateController_2: controllers.CityClimateController,
  // @LINE:27
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    FlightController_0: controllers.FlightController,
    // @LINE:9
    CountryController_1: controllers.CountryController,
    // @LINE:14
    CityController_4: controllers.CityController,
    // @LINE:20
    AirlineServiceController_3: controllers.AirlineServiceController,
    // @LINE:23
    CityClimateController_2: controllers.CityClimateController,
    // @LINE:27
    Assets_5: controllers.Assets
  ) = this(errorHandler, FlightController_0, CountryController_1, CityController_4, AirlineServiceController_3, CityClimateController_2, Assets_5, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FlightController_0, CountryController_1, CityController_4, AirlineServiceController_3, CityClimateController_2, Assets_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """flight""", """controllers.FlightController.createFlight()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """flights""", """controllers.FlightController.getAllFlights()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """country""", """controllers.CountryController.createCountry()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """countries""", """controllers.CountryController.getAllCountries()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """country/""" + "$" + """id<[^/]+>""", """controllers.CountryController.getCountry(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """country/name/""" + "$" + """name<[^/]+>""", """controllers.CountryController.getCountryByName(name:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """city""", """controllers.CityController.createCity()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """city/""" + "$" + """id<[^/]+>""", """controllers.CityController.getCity(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """city/name/""" + "$" + """name<[^/]+>""", """controllers.CityController.getCityByName(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cities""", """controllers.CityController.getAllCities()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """airline-service""", """controllers.AirlineServiceController.createAirlineService()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """airline-services""", """controllers.AirlineServiceController.getAllAirlineServices()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """city-climate""", """controllers.CityClimateController.createCityClimate()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """city-climates""", """controllers.CityClimateController.getAllCityClimates()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_FlightController_createFlight0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("flight")))
  )
  private[this] lazy val controllers_FlightController_createFlight0_invoker = createInvoker(
    FlightController_0.createFlight(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FlightController",
      "createFlight",
      Nil,
      "POST",
      this.prefix + """flight""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_FlightController_getAllFlights1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("flights")))
  )
  private[this] lazy val controllers_FlightController_getAllFlights1_invoker = createInvoker(
    FlightController_0.getAllFlights(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FlightController",
      "getAllFlights",
      Nil,
      "GET",
      this.prefix + """flights""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_CountryController_createCountry2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("country")))
  )
  private[this] lazy val controllers_CountryController_createCountry2_invoker = createInvoker(
    CountryController_1.createCountry(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountryController",
      "createCountry",
      Nil,
      "POST",
      this.prefix + """country""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_CountryController_getAllCountries3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("countries")))
  )
  private[this] lazy val controllers_CountryController_getAllCountries3_invoker = createInvoker(
    CountryController_1.getAllCountries(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountryController",
      "getAllCountries",
      Nil,
      "GET",
      this.prefix + """countries""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_CountryController_getCountry4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("country/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CountryController_getCountry4_invoker = createInvoker(
    CountryController_1.getCountry(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountryController",
      "getCountry",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """country/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_CountryController_getCountryByName5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("country/name/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CountryController_getCountryByName5_invoker = createInvoker(
    CountryController_1.getCountryByName(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountryController",
      "getCountryByName",
      Seq(classOf[String]),
      "GET",
      this.prefix + """country/name/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_CityController_createCity6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("city")))
  )
  private[this] lazy val controllers_CityController_createCity6_invoker = createInvoker(
    CityController_4.createCity(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CityController",
      "createCity",
      Nil,
      "POST",
      this.prefix + """city""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_CityController_getCity7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("city/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CityController_getCity7_invoker = createInvoker(
    CityController_4.getCity(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CityController",
      "getCity",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """city/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_CityController_getCityByName8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("city/name/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CityController_getCityByName8_invoker = createInvoker(
    CityController_4.getCityByName(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CityController",
      "getCityByName",
      Seq(classOf[String]),
      "GET",
      this.prefix + """city/name/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_CityController_getAllCities9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cities")))
  )
  private[this] lazy val controllers_CityController_getAllCities9_invoker = createInvoker(
    CityController_4.getAllCities(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CityController",
      "getAllCities",
      Nil,
      "GET",
      this.prefix + """cities""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_AirlineServiceController_createAirlineService10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("airline-service")))
  )
  private[this] lazy val controllers_AirlineServiceController_createAirlineService10_invoker = createInvoker(
    AirlineServiceController_3.createAirlineService(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AirlineServiceController",
      "createAirlineService",
      Nil,
      "POST",
      this.prefix + """airline-service""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_AirlineServiceController_getAllAirlineServices11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("airline-services")))
  )
  private[this] lazy val controllers_AirlineServiceController_getAllAirlineServices11_invoker = createInvoker(
    AirlineServiceController_3.getAllAirlineServices(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AirlineServiceController",
      "getAllAirlineServices",
      Nil,
      "GET",
      this.prefix + """airline-services""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_CityClimateController_createCityClimate12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("city-climate")))
  )
  private[this] lazy val controllers_CityClimateController_createCityClimate12_invoker = createInvoker(
    CityClimateController_2.createCityClimate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CityClimateController",
      "createCityClimate",
      Nil,
      "POST",
      this.prefix + """city-climate""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_CityClimateController_getAllCityClimates13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("city-climates")))
  )
  private[this] lazy val controllers_CityClimateController_getAllCityClimates13_invoker = createInvoker(
    CityClimateController_2.getAllCityClimates(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CityClimateController",
      "getAllCityClimates",
      Nil,
      "GET",
      this.prefix + """city-climates""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Assets_versioned14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned14_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_FlightController_createFlight0_route(params@_) =>
      call { 
        controllers_FlightController_createFlight0_invoker.call(FlightController_0.createFlight())
      }
  
    // @LINE:7
    case controllers_FlightController_getAllFlights1_route(params@_) =>
      call { 
        controllers_FlightController_getAllFlights1_invoker.call(FlightController_0.getAllFlights())
      }
  
    // @LINE:9
    case controllers_CountryController_createCountry2_route(params@_) =>
      call { 
        controllers_CountryController_createCountry2_invoker.call(CountryController_1.createCountry())
      }
  
    // @LINE:10
    case controllers_CountryController_getAllCountries3_route(params@_) =>
      call { 
        controllers_CountryController_getAllCountries3_invoker.call(CountryController_1.getAllCountries())
      }
  
    // @LINE:11
    case controllers_CountryController_getCountry4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CountryController_getCountry4_invoker.call(CountryController_1.getCountry(id))
      }
  
    // @LINE:12
    case controllers_CountryController_getCountryByName5_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_CountryController_getCountryByName5_invoker.call(CountryController_1.getCountryByName(name))
      }
  
    // @LINE:14
    case controllers_CityController_createCity6_route(params@_) =>
      call { 
        controllers_CityController_createCity6_invoker.call(CityController_4.createCity())
      }
  
    // @LINE:15
    case controllers_CityController_getCity7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CityController_getCity7_invoker.call(CityController_4.getCity(id))
      }
  
    // @LINE:16
    case controllers_CityController_getCityByName8_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_CityController_getCityByName8_invoker.call(CityController_4.getCityByName(name))
      }
  
    // @LINE:18
    case controllers_CityController_getAllCities9_route(params@_) =>
      call { 
        controllers_CityController_getAllCities9_invoker.call(CityController_4.getAllCities())
      }
  
    // @LINE:20
    case controllers_AirlineServiceController_createAirlineService10_route(params@_) =>
      call { 
        controllers_AirlineServiceController_createAirlineService10_invoker.call(AirlineServiceController_3.createAirlineService())
      }
  
    // @LINE:21
    case controllers_AirlineServiceController_getAllAirlineServices11_route(params@_) =>
      call { 
        controllers_AirlineServiceController_getAllAirlineServices11_invoker.call(AirlineServiceController_3.getAllAirlineServices())
      }
  
    // @LINE:23
    case controllers_CityClimateController_createCityClimate12_route(params@_) =>
      call { 
        controllers_CityClimateController_createCityClimate12_invoker.call(CityClimateController_2.createCityClimate())
      }
  
    // @LINE:24
    case controllers_CityClimateController_getAllCityClimates13_route(params@_) =>
      call { 
        controllers_CityClimateController_getAllCityClimates13_invoker.call(CityClimateController_2.getAllCityClimates())
      }
  
    // @LINE:27
    case controllers_Assets_versioned14_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned14_invoker.call(Assets_5.versioned(path, file))
      }
  }
}
