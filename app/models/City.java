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

    @Column(length = 3, nullable = false, unique = true)
    @Constraints.MaxLength(3)
    @Constraints.Required
    public String airport_code;

    @Column(nullable=false, unique = true)
    @Constraints.Required
    public Integer b_code;

    @Column(nullable=false, unique = true)
    @Constraints.Required
    public Integer h_code;

    @Column(length = 250, nullable = false)
    @Constraints.MaxLength(250)
    @Constraints.Required
    public String type;

    @Column(length = 250, nullable = false)
    @Constraints.MaxLength(250)
    @Constraints.Required
    public String b_type;

    @Column(nullable =  false)
    @Constraints.Required
    public Float latitude;

    @Column(nullable =  false)
    @Constraints.Required
    public Float longitude;

    @ManyToOne(optional = false)
    @Column(nullable =  false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("country_id")
    public Country country;

    @Constraints.Required
    @Transient
    @JsonIgnore
    public Long country_id;

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