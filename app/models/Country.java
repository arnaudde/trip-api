package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Country extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(length = 25, nullable = false, unique = true)
    @Constraints.MaxLength(25)
    @Constraints.Required
    public String name;

    @Column(nullable =  false)
    @Constraints.Required
    public Float budget;

    private static Finder<Long, Country> finder = new Finder<>(Country.class);

    public static List<Country> findAll() {
        return finder.all();
    }

    public static Country find(Long id) {
        return finder.byId(id);
    }

    public static Country findByName(String name) {
        return finder.query().where().eq("name", name).findOne();
    }
}
