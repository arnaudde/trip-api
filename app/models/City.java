package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import models.Country;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class City extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(length = 250, nullable = false, unique = true)
    @Constraints.MaxLength(250)
    @Constraints.Required
    public String name;

    @Column(length = 10, nullable = false, unique = true)
    @Constraints.MaxLength(10)
    @Constraints.Required
    private String airport_code;

    @Column(nullable = false, unique = true)
    @Constraints.Required
    private Integer b_code;

    @Column(nullable = false, unique = true)
    @Constraints.Required
    private Integer h_code;

    @Column(length = 250, nullable = false)
    @Constraints.MaxLength(250)
    @Constraints.Required
    private String type;

    @Column(length = 250, nullable = false)
    @Constraints.MaxLength(250)
    @Constraints.Required
    private String b_type;

    @Column(nullable = false)
    @Constraints.Required
    private Float latitude;

    @Column(nullable = false)
    @Constraints.Required
    private Float longitude;

    @ManyToOne(optional = false)
    @Column(nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("country_id")
    public Country country;

    @Constraints.Required
    @Transient
    @JsonIgnore
    public Long country_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirport_code() {
        return airport_code;
    }

    public void setAirport_code(String airport_code) {
        this.airport_code = airport_code;
    }

    public Integer getB_code() {
        return b_code;
    }

    public void setB_code(Integer b_code) {
        this.b_code = b_code;
    }

    public Integer getH_code() {
        return h_code;
    }

    public void setH_code(Integer h_code) {
        this.h_code = h_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getB_type() {
        return b_type;
    }

    public void setB_type(String b_type) {
        this.b_type = b_type;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    private static Finder<Long, City> finder = new Finder<>(City.class);

    public static List<City> findAll() {
        return finder.all();
    }

    public static City find(Long id) {
        return finder.byId(id);
    }

    public static City findByName(String name) {
        return finder.query().where().eq("name", name).findOne();
    }
}
