package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * ConUce generated by hbm2java
 */
public class ConUce  implements java.io.Serializable {


     private BigDecimal conUceId;
     private Cal cal;
     private String conUceDes;
     private Double conUceLimInf;
     private Double conUceLimSup;
     private BigDecimal conUceOrdPre;
     private Double conUcePto;
     private Double conUceWoe;
     private String conUceDesLar;

    public ConUce() {
    }

	
    public ConUce(BigDecimal conUceId) {
        this.conUceId = conUceId;
    }
    public ConUce(BigDecimal conUceId, Cal cal, String conUceDes, Double conUceLimInf, Double conUceLimSup, BigDecimal conUceOrdPre, Double conUcePto, Double conUceWoe, String conUceDesLar) {
       this.conUceId = conUceId;
       this.cal = cal;
       this.conUceDes = conUceDes;
       this.conUceLimInf = conUceLimInf;
       this.conUceLimSup = conUceLimSup;
       this.conUceOrdPre = conUceOrdPre;
       this.conUcePto = conUcePto;
       this.conUceWoe = conUceWoe;
       this.conUceDesLar = conUceDesLar;
    }
   
    public BigDecimal getConUceId() {
        return this.conUceId;
    }
    
    public void setConUceId(BigDecimal conUceId) {
        this.conUceId = conUceId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getConUceDes() {
        return this.conUceDes;
    }
    
    public void setConUceDes(String conUceDes) {
        this.conUceDes = conUceDes;
    }
    public Double getConUceLimInf() {
        return this.conUceLimInf;
    }
    
    public void setConUceLimInf(Double conUceLimInf) {
        this.conUceLimInf = conUceLimInf;
    }
    public Double getConUceLimSup() {
        return this.conUceLimSup;
    }
    
    public void setConUceLimSup(Double conUceLimSup) {
        this.conUceLimSup = conUceLimSup;
    }
    public BigDecimal getConUceOrdPre() {
        return this.conUceOrdPre;
    }
    
    public void setConUceOrdPre(BigDecimal conUceOrdPre) {
        this.conUceOrdPre = conUceOrdPre;
    }
    public Double getConUcePto() {
        return this.conUcePto;
    }
    
    public void setConUcePto(Double conUcePto) {
        this.conUcePto = conUcePto;
    }
    public Double getConUceWoe() {
        return this.conUceWoe;
    }
    
    public void setConUceWoe(Double conUceWoe) {
        this.conUceWoe = conUceWoe;
    }
    public String getConUceDesLar() {
        return this.conUceDesLar;
    }
    
    public void setConUceDesLar(String conUceDesLar) {
        this.conUceDesLar = conUceDesLar;
    }




}


