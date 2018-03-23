package models;

import java.util.*;
import javax.persistence.*;
import models.City;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Table(
  uniqueConstraints=
  @UniqueConstraint(columnNames={"city_id", "month"})
)

@Entity
public class CityClimate extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @ManyToOne(optional = false)
    @Column(nullable =  false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("city_id")
    public City city;

    @Constraints.Required
    @Transient
    @JsonIgnore
    public Long city_id;

    @Column(nullable=false)
    @Constraints.Required
    public Integer month;

    @Column(nullable=false)
    @Constraints.Required
    @Constraints.Min(-70)
    @Constraints.Max(70)
    public Integer mean_temperature;

    @Column(nullable=false)
    @Constraints.Required
    @Constraints.Min(-70)
    @Constraints.Max(70)
    public Integer min_mean_temperature;

    @Column(nullable=false)
    @Constraints.Required
    @Constraints.Min(-70)
    @Constraints.Max(70)
    public Integer max_mean_temperature;

    @Column(nullable=false)
    @Constraints.Min(0)
    @Constraints.Required
    public Integer precipitations;

    @Column(nullable=false)
    @Constraints.Min(0)
    @Constraints.Max(31)
    @Constraints.Required
    public Integer number_days_of_rain;

    @Column(nullable=false)
    @Constraints.Min(0)
    @Constraints.Max(5)
    @Constraints.Required
    public Integer score;


    public static List<CityClimate> findAll() {
        Finder<Long, CityClimate> finder = new Finder<>(CityClimate.class);
        return finder.all();
    }
}
