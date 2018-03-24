package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Table(
  uniqueConstraints=
  @UniqueConstraint(columnNames={"departure", "arrival", "date", "min_departure_time", "max_departure_time", "max_duration"})
)
@Entity
public class Flight extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(length = 3, nullable = false)
    @Constraints.MaxLength(3)
    @Constraints.Required
    public String departure;

    @Column(length = 3, nullable = false)
    @Constraints.MaxLength(3)
    @Constraints.Required
    public String arrival;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Constraints.Required
    public Date date;

    @Column(length = 4, nullable = false)
    @Constraints.MaxLength(4)
    @Constraints.Required
    public String min_departure_time;

    @Column(length = 4, nullable = false)
    @Constraints.MaxLength(4)
    @Constraints.Required
    public String max_departure_time;

    @Column(length = 4, nullable = false)
    @Constraints.MaxLength(4)
    @Constraints.Required
    public String max_duration;

    @Column(nullable=false)
    @Constraints.Required
    public Integer price;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    public Date created_on;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMin_departure_time() {
        return min_departure_time;
    }

    public void setMin_departure_time(String min_departure_time) {
        this.min_departure_time = min_departure_time;
    }

    public String getMax_departure_time() {
        return max_departure_time;
    }

    public void setMax_departure_time(String max_departure_time) {
        this.max_departure_time = max_departure_time;
    }

    public String getMax_duration() {
        return max_duration;
    }

    public void setMax_duration(String max_duration) {
        this.max_duration = max_duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public static List<Flight> findAll() {
        Finder<Long, Flight> finder = new Finder<>(Flight.class);
        return finder.all();
    }

    public void save() {
        this.created_on = new Date();
        super.save();
    }
}
