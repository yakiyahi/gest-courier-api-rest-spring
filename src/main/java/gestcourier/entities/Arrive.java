package gestcourier.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Arrive implements Serializable{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idArive;
    @Temporal(TemporalType.DATE)
    private Date dateArive;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "hh:mm:ss")
    private Date heurArive;

    public Arrive() {
        super();
    }

    public Arrive( Date dateArive, Date heurArive) {
        this.dateArive = dateArive;
        this.heurArive = heurArive;
    }

    public Long getIdArive() {
        return idArive;
    }

    public void setIdArive(Long idArive) {
        this.idArive = idArive;
    }

    public Date getDateArive() {
        return dateArive;
    }

    public void setDateArive(Date dateArive) {
        this.dateArive = dateArive;
    }

    public Date getHeurArive() {
        return heurArive;
    }

    public void setHeurArive(Date heurArive) {
        this.heurArive = heurArive;
    }

}
