package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA



/**
 * RelAfe generated by hbm2java
 */
public class RelAfe  implements java.io.Serializable {


     private int relAfeId;
     private Integer calId;
     private String relAfeDes;
     private Float relAfeLimInf;
     private Float relAfeLimSup;
     private Integer relAfeOrdPre;
     private Float relAfePto;
     private Float relAfeWoe;
     private String relAfeDesLar;

    public RelAfe() {
    }

	
    public RelAfe(int relAfeId) {
        this.relAfeId = relAfeId;
    }
    public RelAfe(int relAfeId, Integer calId, String relAfeDes, Float relAfeLimInf, Float relAfeLimSup, Integer relAfeOrdPre, Float relAfePto, Float relAfeWoe, String relAfeDesLar) {
       this.relAfeId = relAfeId;
       this.calId = calId;
       this.relAfeDes = relAfeDes;
       this.relAfeLimInf = relAfeLimInf;
       this.relAfeLimSup = relAfeLimSup;
       this.relAfeOrdPre = relAfeOrdPre;
       this.relAfePto = relAfePto;
       this.relAfeWoe = relAfeWoe;
       this.relAfeDesLar = relAfeDesLar;
    }
   
    public int getRelAfeId() {
        return this.relAfeId;
    }
    
    public void setRelAfeId(int relAfeId) {
        this.relAfeId = relAfeId;
    }
    public Integer getCalId() {
        return this.calId;
    }
    
    public void setCalId(Integer calId) {
        this.calId = calId;
    }
    public String getRelAfeDes() {
        return this.relAfeDes;
    }
    
    public void setRelAfeDes(String relAfeDes) {
        this.relAfeDes = relAfeDes;
    }
    public Float getRelAfeLimInf() {
        return this.relAfeLimInf;
    }
    
    public void setRelAfeLimInf(Float relAfeLimInf) {
        this.relAfeLimInf = relAfeLimInf;
    }
    public Float getRelAfeLimSup() {
        return this.relAfeLimSup;
    }
    
    public void setRelAfeLimSup(Float relAfeLimSup) {
        this.relAfeLimSup = relAfeLimSup;
    }
    public Integer getRelAfeOrdPre() {
        return this.relAfeOrdPre;
    }
    
    public void setRelAfeOrdPre(Integer relAfeOrdPre) {
        this.relAfeOrdPre = relAfeOrdPre;
    }
    public Float getRelAfePto() {
        return this.relAfePto;
    }
    
    public void setRelAfePto(Float relAfePto) {
        this.relAfePto = relAfePto;
    }
    public Float getRelAfeWoe() {
        return this.relAfeWoe;
    }
    
    public void setRelAfeWoe(Float relAfeWoe) {
        this.relAfeWoe = relAfeWoe;
    }
    public String getRelAfeDesLar() {
        return this.relAfeDesLar;
    }
    
    public void setRelAfeDesLar(String relAfeDesLar) {
        this.relAfeDesLar = relAfeDesLar;
    }




}


