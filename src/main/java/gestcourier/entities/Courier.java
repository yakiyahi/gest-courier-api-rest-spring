package gestcourier.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Courier implements Serializable {
    @Id
    @Column(length=50)
    private String refCour;
    private String descrCour;
    @Column(length=12)
    private String typeCour;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "userNum")
     private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "codeDirect")
    private Direction direction;
    @OneToOne(cascade = CascadeType.DETACH ,fetch = FetchType.EAGER)
    @JoinColumn(name = "idArive")
    private Arrive arrive;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "codeCons ")
    private  Consernant consernant;

    public Courier() {
        super();
    }

    public Courier(String refCour, String typeCour, String descrCour) {
        this.refCour = refCour;
        this.descrCour = descrCour;
        this.typeCour = typeCour;
    }

    public Courier(String refCour, String typeCour , String descrCour, Utilisateur utilisateur, Direction direction, Arrive arrive) {
        this.refCour = refCour;
        this.descrCour = descrCour;
        this.typeCour = typeCour;
        this.utilisateur = utilisateur;
        this.direction = direction;
        this.arrive = arrive;
    }

    public String getRefCour() {
        return refCour;
    }

    public void setRefCour(String refCour) {
        this.refCour = refCour;
    }

    public String getDescrCour() {
        return descrCour;
    }

    public void setDescrCour(String descrCour) {
        this.descrCour = descrCour;
    }

    public String getTypeCour() {
        return typeCour;
    }

    public void setTypeCour(String typeCour) {
        this.typeCour = typeCour;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Arrive getArrive() {
        return arrive;
    }

    public void setArrive(Arrive arrive) {
        this.arrive = arrive;
    }

    public Consernant getConsernant() {
        return consernant;
    }

    public void setConsernant(Consernant consernant) {
        this.consernant = consernant;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "refCour='" + refCour + '\'' +
                ", descrCour='" + descrCour + '\'' +
                ", typeCour='" + typeCour + '\'' +
                ", utilisateur=" + utilisateur +
                ", direction=" + direction +
                ", arrive=" + arrive +
                ", consernant=" + consernant +
                '}';
    }
}
