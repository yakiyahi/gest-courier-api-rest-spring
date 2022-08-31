package gestcourier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Direction implements Serializable {
    @Id
    @Column(length = 50)
    private String codeDirect;
    private String abrevDirect;
    private String descrptDirect;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "codeProv")
    public Provenance provenance;

    @OneToMany(mappedBy = "refCour",fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private Collection<Courier> couriers;

    public Direction() {
        super();
    }

    public Direction(String codeDirect, String abrevDirect, String descrptDirect) {
        this.codeDirect = codeDirect;
        this.abrevDirect = abrevDirect;
        this.descrptDirect = descrptDirect;
    }

    public Direction(String codeDirect, String abrevDirect, String descrptDirect, Provenance provenance) {
        this.codeDirect = codeDirect;
        this.abrevDirect = abrevDirect;
        this.descrptDirect = descrptDirect;
        this.provenance = provenance;
    }

    public String getAbrevDirect() {
        return abrevDirect;
    }

    public void setAbrevDirect(String abrevDirect) {
        this.abrevDirect = abrevDirect;
    }

    public String getCodeDirect() {
        return codeDirect;
    }

    public void setCodeDirect(String codeDirect) {
        this.codeDirect = codeDirect;
    }

    public String getDescrptDirect() {
        return descrptDirect;
    }

    public void setDescrptDirect(String descrptDirect) {
        this.descrptDirect = descrptDirect;
    }

    public Provenance getProvenance() {
        return provenance;
    }

    public void setProvenance(Provenance provenance) {
        this.provenance = provenance;
    }

    public Collection<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(Collection<Courier> couriers) {
        this.couriers = couriers;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "codeDirect='" + codeDirect + '\'' +
                ", descrptDirect='" + descrptDirect + '\'' +
                ", provenance=" + provenance +
                ", courriers=" + couriers +
                '}';
    }
}
