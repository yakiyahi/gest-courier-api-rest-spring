package gestcourier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Decision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDecis;
    @Column(length = 5)
    private String typeDecis;

    private String descrDcis;

    @Temporal(TemporalType.DATE)
    private Date dateDecis;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "refCour")
    private Courier courier;

    public Decision() {
        super();
    }

    public Decision(String typeDecis, String descrDcis, Date dateDecis, Courier courier) {
        this.typeDecis = typeDecis;
        this.descrDcis = descrDcis;
        this.dateDecis = dateDecis;
        this.courier = courier;
    }

    public Long getIdDecis() {
        return idDecis;
    }

    public void setIdDecis(Long idDecis) {
        this.idDecis = idDecis;
    }

    public Date getDateDecis() {
        return dateDecis;
    }

    public void setDateDecis(Date dateDecis) {
        this.dateDecis = dateDecis;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getTypeDecis() {
        return typeDecis;
    }

    public void setTypeDecis(String typeDecis) {
        this.typeDecis = typeDecis;
    }

    public String getDescrDcis() {
        return descrDcis;
    }

    public void setDescrDcis(String descrDcis) {
        this.descrDcis = descrDcis;
    }

    @Override
    public String toString() {
        return "Decision{" +
                "idDecis=" + idDecis +
                ", typeDecis='" + typeDecis + '\'' +
                ", descrDcis='" + descrDcis + '\'' +
                ", dateDecis=" + dateDecis +
                ", courier=" + courier +
                '}';
    }
}
