package gestcourier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Utilisateur implements Serializable {
    @Id
    @Column(length = 10)
    private String userNum;
    @Column(length = 100)
    private String userName;
    @Column(length = 20)
    private String userPseudo;
    private String userPassword;
    @Column(length = 10)
    private String userRule;


    @OneToMany(mappedBy = "refCour",fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Collection<Courier> courier;

    public Utilisateur() {
        super();
    }
    public Utilisateur(String userNum, String userName, String userPseudo, String userPassword, String userRule) {
        this.userNum = userNum;
        this.userName = userName;
        this.userPseudo = userPseudo;
        this.userPassword = userPassword;
        this.userRule = userRule;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRule() {
        return userRule;
    }

    public void setUserRule(String userRule) {
        this.userRule = userRule;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Collection<Courier> getCourier() {
        return courier;
    }

    public void setCourier(Collection<Courier> courier) {
        this.courier = courier;
    }
}
