package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA



/**
 * SolCre generated by hbm2java
 */
public class SolCre  implements java.io.Serializable {


     private int solCreId;
     private Integer calId;
     private String solCreDes;
     private Float solCreLimInf;
     private Float solCreLimSup;
     private Integer solCreOrdPre;
     private Float solCrePto;
     private Float solCreWoe;
     private String solCreDesLar;

    public SolCre() {
    }

	
    public SolCre(int solCreId) {
        this.solCreId = solCreId;
    }
    public SolCre(int solCreId, Integer calId, String solCreDes, Float solCreLimInf, Float solCreLimSup, Integer solCreOrdPre, Float solCrePto, Float solCreWoe, String solCreDesLar) {
       this.solCreId = solCreId;
       this.calId = calId;
       this.solCreDes = solCreDes;
       this.solCreLimInf = solCreLimInf;
       this.solCreLimSup = solCreLimSup;
       this.solCreOrdPre = solCreOrdPre;
       this.solCrePto = solCrePto;
       this.solCreWoe = solCreWoe;
       this.solCreDesLar = solCreDesLar;
    }
   
    public int getSolCreId() {
        return this.solCreId;
    }
    
    public void setSolCreId(int solCreId) {
        this.solCreId = solCreId;
    }
    public Integer getCalId() {
        return this.calId;
    }
    
    public void setCalId(Integer calId) {
        this.calId = calId;
    }
    public String getSolCreDes() {
        return this.solCreDes;
    }
    
    public void setSolCreDes(String solCreDes) {
        this.solCreDes = solCreDes;
    }
    public Float getSolCreLimInf() {
        return this.solCreLimInf;
    }
    
    public void setSolCreLimInf(Float solCreLimInf) {
        this.solCreLimInf = solCreLimInf;
    }
    public Float getSolCreLimSup() {
        return this.solCreLimSup;
    }
    
    public void setSolCreLimSup(Float solCreLimSup) {
        this.solCreLimSup = solCreLimSup;
    }
    public Integer getSolCreOrdPre() {
        return this.solCreOrdPre;
    }
    
    public void setSolCreOrdPre(Integer solCreOrdPre) {
        this.solCreOrdPre = solCreOrdPre;
    }
    public Float getSolCrePto() {
        return this.solCrePto;
    }
    
    public void setSolCrePto(Float solCrePto) {
        this.solCrePto = solCrePto;
    }
    public Float getSolCreWoe() {
        return this.solCreWoe;
    }
    
    public void setSolCreWoe(Float solCreWoe) {
        this.solCreWoe = solCreWoe;
    }
    public String getSolCreDesLar() {
        return this.solCreDesLar;
    }
    
    public void setSolCreDesLar(String solCreDesLar) {
        this.solCreDesLar = solCreDesLar;
    }




}


