 package models;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"departure_id", "arrival_id", "month", "min_departure_time", "max_departure_time", "max_duration"})
)
@Entity
public class AirlineService extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @ManyToOne(optional = false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("departure_id")
    @Column(nullable =  false)
    public City departure;

    @Constraints.Required
    @Transient
    @JsonIgnore
    public Long departure_id;

    @ManyToOne(optional = false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("arrival_id")
    @Column(nullable =  false)
    public City arrival;

    @Constraints.Required
    @Transient
    @JsonIgnore
    public Long arrival_id;

    @Column(nullable=false)
    @Constraints.Required
    @Constraints.Min(0)
    @Constraints.Max(2400)
    public Integer min_departure_time;

    @Column(nullable=false)
    @Constraints.Required
    @Constraints.Min(0)
    @Constraints.Max(2400)
    public Integer max_departure_time;

    @Column(nullable=false)
    @Constraints.Required
    @Constraints.Min(0)
    public Integer max_duration;

    @Column(nullable=false)
    @Constraints.Min(1)
    @Constraints.Max(12)
    @Constraints.Required
    public Integer month;

    @Column(nullable=false)
    @Constraints.Required
    public Boolean exists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getDeparture() {
        return departure;
    }

    public void setDeparture(City departure) {
        this.departure = departure;
    }

    public Long getDeparture_id() {
        return departure_id;
    }

    public void setDeparture_id(Long departure_id) {
        this.departure_id = departure_id;
    }

    public City getArrival() {
        return arrival;
    }

    public void setArrival(City arrival) {
        this.arrival = arrival;
    }

    public Long getArrival_id() {
        return arrival_id;
    }

    public void setArrival_id(Long arrival_id) {
        this.arrival_id = arrival_id;
    }

    public Integer getMin_departure_time() {
        return min_departure_time;
    }

    public void setMin_departure_time(Integer min_departure_time) {
        this.min_departure_time = min_departure_time;
    }

    public Integer getMax_departure_time() {
        return max_departure_time;
    }

    public void setMax_departure_time(Integer max_departure_time) {
        this.max_departure_time = max_departure_time;
    }

    public Integer getMax_duration() {
        return max_duration;
    }

    public void setMax_duration(Integer max_duration) {
        this.max_duration = max_duration;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    private static Finder<Long, AirlineService> finder = new Finder<>(AirlineService.class);

    public static List<AirlineService> findAll() {
        return finder.all();
    }

    public static AirlineService getByParams(
            Long departure_id,
            Long arrival_id,
            Integer month,
            Integer min_departure_time,
            Integer max_departure_time,
            Integer max_duration
    ) {
        return finder.query().where()
                .eq("departure_id", departure_id)
                .eq("arrival_id", arrival_id)
                .eq("month", month)
                .ge("min_departure_time", min_departure_time)
                .le("max_departure_time", max_departure_time)
                .le("max_duration", max_duration)
                .findOne();
    }
}
