package gestcourier.entities;

import java.io.Serializable;

public class Graph implements Serializable{
    private String prov;
    private int nombCour;

    public Graph(){
    }
    public String getProv(){
        return prov;
    }
    public void setProv(String prov){
        this.prov = prov;
    }
    public int getNombCour(){
        return nombCour;
    }
    public void setNombCour(int nombCour){
        this.nombCour= nombCour;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "prov='" + prov + '\'' +
                ", nombCour=" + nombCour +
                '}';
    }
}
