package gestcourier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Provenance implements Serializable {
    @Id
    @Column(length = 10)
    private String codeProv;
    @Column(length = 10)
    private String abrevProv;
    private String libelProv;
    @OneToMany(mappedBy = "codeDirect",
            cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Collection<Direction> directions;
    public Provenance() {
        super();
    }

    public Provenance(String codeProv, String abrevProv, String libelProv) {
        this.codeProv = codeProv;
        this.abrevProv = abrevProv;
        this.libelProv = libelProv;
    }

    public String getCodeProv() {
        return codeProv;
    }

    public void setCodeProv(String codeProv) {
        this.codeProv = codeProv;
    }

    public String getAbrevProv() {
        return abrevProv;
    }

    public void setAbrevProv(String abrevProv) {
        this.abrevProv = abrevProv;
    }

    public String getLibelProv() {
        return libelProv;
    }

    public void setLibelProv(String libelPov) {
        this.libelProv = libelPov;
    }

    public Collection<Direction> getDirections() {
        return directions;
    }

    public void setDirections(Collection<Direction> directions) {
        this.directions = directions;
    }
}
