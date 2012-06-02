package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * EdoCvl generated by hbm2java
 */
public class EdoCvl  implements java.io.Serializable {


     private int edoCvlId;
     private Cal cal;
     private String edoCvlDes;
     private Float edoCvlLimInf;
     private Float edoCvlLimSup;
     private Integer edoCvlOrdPre;
     private Float edoCvlPto;
     private Float edoCvlWoe;
     private String edoCvlDesLar;
     private Set cliMtas = new HashSet(0);

    public EdoCvl() {
    }

	
    public EdoCvl(int edoCvlId) {
        this.edoCvlId = edoCvlId;
    }
    public EdoCvl(int edoCvlId, Cal cal, String edoCvlDes, Float edoCvlLimInf, Float edoCvlLimSup, Integer edoCvlOrdPre, Float edoCvlPto, Float edoCvlWoe, String edoCvlDesLar, Set cliMtas) {
       this.edoCvlId = edoCvlId;
       this.cal = cal;
       this.edoCvlDes = edoCvlDes;
       this.edoCvlLimInf = edoCvlLimInf;
       this.edoCvlLimSup = edoCvlLimSup;
       this.edoCvlOrdPre = edoCvlOrdPre;
       this.edoCvlPto = edoCvlPto;
       this.edoCvlWoe = edoCvlWoe;
       this.edoCvlDesLar = edoCvlDesLar;
       this.cliMtas = cliMtas;
    }
   
    public int getEdoCvlId() {
        return this.edoCvlId;
    }
    
    public void setEdoCvlId(int edoCvlId) {
        this.edoCvlId = edoCvlId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getEdoCvlDes() {
        return this.edoCvlDes;
    }
    
    public void setEdoCvlDes(String edoCvlDes) {
        this.edoCvlDes = edoCvlDes;
    }
    public Float getEdoCvlLimInf() {
        return this.edoCvlLimInf;
    }
    
    public void setEdoCvlLimInf(Float edoCvlLimInf) {
        this.edoCvlLimInf = edoCvlLimInf;
    }
    public Float getEdoCvlLimSup() {
        return this.edoCvlLimSup;
    }
    
    public void setEdoCvlLimSup(Float edoCvlLimSup) {
        this.edoCvlLimSup = edoCvlLimSup;
    }
    public Integer getEdoCvlOrdPre() {
        return this.edoCvlOrdPre;
    }
    
    public void setEdoCvlOrdPre(Integer edoCvlOrdPre) {
        this.edoCvlOrdPre = edoCvlOrdPre;
    }
    public Float getEdoCvlPto() {
        return this.edoCvlPto;
    }
    
    public void setEdoCvlPto(Float edoCvlPto) {
        this.edoCvlPto = edoCvlPto;
    }
    public Float getEdoCvlWoe() {
        return this.edoCvlWoe;
    }
    
    public void setEdoCvlWoe(Float edoCvlWoe) {
        this.edoCvlWoe = edoCvlWoe;
    }
    public String getEdoCvlDesLar() {
        return this.edoCvlDesLar;
    }
    
    public void setEdoCvlDesLar(String edoCvlDesLar) {
        this.edoCvlDesLar = edoCvlDesLar;
    }
    public Set getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set cliMtas) {
        this.cliMtas = cliMtas;
    }




}


