package gestcourier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Consernant implements Serializable {
    @Id
    @Column(length=50)
    private String codeCons;
    @Column(length=100)
    private String nomCons;
    @Column(length=100)
    private String prenomCons;
    @OneToMany(mappedBy = "refCour",fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private Collection<Courier> courier;

    public Consernant() {
        super();
    }

    public Consernant(String codeCons, String nomCons, String prenomCons) {
        this.codeCons = codeCons;
        this.nomCons = nomCons;
        this.prenomCons = prenomCons;
    }

    public String getCodeCons() {
        return codeCons;
    }

    public void setCodeCons(String codeCons) {
        this.codeCons = codeCons;
    }

    public String getNomCons() {
        return nomCons;
    }

    public void setNomCons(String nomCons) {
        this.nomCons = nomCons;
    }

    public String getPrenomCons() {
        return prenomCons;
    }

    public void setPrenomCons(String prenomCons) {
        this.prenomCons = prenomCons;
    }

    public Collection<Courier> getCourier() {
        return courier;
    }

    public void setCourier(Collection<Courier> courier) {
        this.courier = courier;
    }

    @Override
    public String toString() {
        return "Consernant{" +
                "codeCons='" + codeCons + '\'' +
                ", nomCons='" + nomCons + '\'' +
                ", prenomCons='" + prenomCons + '\'' +
                ", courier=" + courier +
                '}';
    }
}
