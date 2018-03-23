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
    @Column(nullable =  false)
    public City arrival;

    @Constraints.Required
    @Transient
    @JsonIgnore
    @JsonProperty("arrival_id")
    public Long arrival_id;

    @Column(nullable=false)
    @Constraints.Required
    public Integer min_departure_time;

    @Column(nullable=false)
    @Constraints.Required
    public Integer max_departure_time;

    @Column(nullable=false)
    @Constraints.Required
    public Integer max_duration;

    @Column(nullable=false)
    @Constraints.Min(1)
    @Constraints.Max(12)
    @Constraints.Required
    public Integer month;

    @Column(nullable=false)
    @Constraints.Required
    public Boolean exists;

    public static List<AirlineService> findAll() {
        Finder<Long, AirlineService> finder = new Finder<>(AirlineService.class);
        return finder.all();
    }
}
