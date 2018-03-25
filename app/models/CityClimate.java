package models;

import java.util.*;
import javax.persistence.*;

import models.City;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"city_id", "month"})
)

@Entity
public class CityClimate extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @ManyToOne(optional = false)
    @Column(nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    public City city;

    @Constraints.Required
    @Transient
    @JsonIgnore
    public Long city_id;

    @Column(nullable = false)
    @Constraints.Required
    public Integer month;

    @Column(nullable = false)
    @Constraints.Required
    @Constraints.Min(-70)
    @Constraints.Max(70)
    public Integer mean_temperature;

    @Column(nullable = false)
    @Constraints.Required
    @Constraints.Min(-70)
    @Constraints.Max(70)
    public Integer min_mean_temperature;

    @Column(nullable = false)
    @Constraints.Required
    @Constraints.Min(-70)
    @Constraints.Max(70)
    public Integer max_mean_temperature;

    @Column(nullable = false)
    @Constraints.Min(0)
    @Constraints.Required
    public Integer precipitations;

    @Column(nullable = false)
    @Constraints.Min(0)
    @Constraints.Max(31)
    @Constraints.Required
    public Integer number_days_of_rain;

    @Column(nullable = false)
    @Constraints.Min(0)
    @Constraints.Max(5)
    @Constraints.Required
    public Integer score;

    public City getCity() {
        return city;
    }

    public static List<CityClimate> findAll() {
        Finder<Long, CityClimate> finder = new Finder<>(CityClimate.class);
        return finder.all();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getMean_temperature() {
        return mean_temperature;
    }

    public void setMean_temperature(Integer mean_temperature) {
        this.mean_temperature = mean_temperature;
    }

    public Integer getMin_mean_temperature() {
        return min_mean_temperature;
    }

    public void setMin_mean_temperature(Integer min_mean_temperature) {
        this.min_mean_temperature = min_mean_temperature;
    }

    public Integer getMax_mean_temperature() {
        return max_mean_temperature;
    }

    public void setMax_mean_temperature(Integer max_mean_temperature) {
        this.max_mean_temperature = max_mean_temperature;
    }

    public Integer getPrecipitations() {
        return precipitations;
    }

    public void setPrecipitations(Integer precipitations) {
        this.precipitations = precipitations;
    }

    public Integer getNumber_days_of_rain() {
        return number_days_of_rain;
    }

    public void setNumber_days_of_rain(Integer number_days_of_rain) {
        this.number_days_of_rain = number_days_of_rain;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
