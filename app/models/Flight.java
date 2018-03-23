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

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Constraints.Required
    public Date date;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    public Date created_on;

    @Column(length = 3, nullable = false)
    @Constraints.MaxLength(3)
    @Constraints.Required
    public String arrival;

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


    public static List<Flight> findAll() {
        Finder<Long, Flight> finder = new Finder<>(Flight.class);
        return finder.all();
    }

    public void save() {
        this.created_on = new Date();
        super.save();
    }
}
