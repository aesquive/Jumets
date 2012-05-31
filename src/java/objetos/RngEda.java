package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * RngEda generated by hbm2java
 */
public class RngEda  implements java.io.Serializable {


     private BigDecimal rngEdaId;
     private BigDecimal calId;
     private String rngEdaDes;
     private Double rngEdaLimInf;
     private Double rngEdaLimSup;
     private BigDecimal rngEdaOrdPre;
     private Double rngEdaPto;
     private Double rngEdaWoe;
     private String rngEdaDesLar;

    public RngEda() {
    }

	
    public RngEda(BigDecimal rngEdaId) {
        this.rngEdaId = rngEdaId;
    }
    public RngEda(BigDecimal rngEdaId, BigDecimal calId, String rngEdaDes, Double rngEdaLimInf, Double rngEdaLimSup, BigDecimal rngEdaOrdPre, Double rngEdaPto, Double rngEdaWoe, String rngEdaDesLar) {
       this.rngEdaId = rngEdaId;
       this.calId = calId;
       this.rngEdaDes = rngEdaDes;
       this.rngEdaLimInf = rngEdaLimInf;
       this.rngEdaLimSup = rngEdaLimSup;
       this.rngEdaOrdPre = rngEdaOrdPre;
       this.rngEdaPto = rngEdaPto;
       this.rngEdaWoe = rngEdaWoe;
       this.rngEdaDesLar = rngEdaDesLar;
    }
   
    public BigDecimal getRngEdaId() {
        return this.rngEdaId;
    }
    
    public void setRngEdaId(BigDecimal rngEdaId) {
        this.rngEdaId = rngEdaId;
    }
    public BigDecimal getCalId() {
        return this.calId;
    }
    
    public void setCalId(BigDecimal calId) {
        this.calId = calId;
    }
    public String getRngEdaDes() {
        return this.rngEdaDes;
    }
    
    public void setRngEdaDes(String rngEdaDes) {
        this.rngEdaDes = rngEdaDes;
    }
    public Double getRngEdaLimInf() {
        return this.rngEdaLimInf;
    }
    
    public void setRngEdaLimInf(Double rngEdaLimInf) {
        this.rngEdaLimInf = rngEdaLimInf;
    }
    public Double getRngEdaLimSup() {
        return this.rngEdaLimSup;
    }
    
    public void setRngEdaLimSup(Double rngEdaLimSup) {
        this.rngEdaLimSup = rngEdaLimSup;
    }
    public BigDecimal getRngEdaOrdPre() {
        return this.rngEdaOrdPre;
    }
    
    public void setRngEdaOrdPre(BigDecimal rngEdaOrdPre) {
        this.rngEdaOrdPre = rngEdaOrdPre;
    }
    public Double getRngEdaPto() {
        return this.rngEdaPto;
    }
    
    public void setRngEdaPto(Double rngEdaPto) {
        this.rngEdaPto = rngEdaPto;
    }
    public Double getRngEdaWoe() {
        return this.rngEdaWoe;
    }
    
    public void setRngEdaWoe(Double rngEdaWoe) {
        this.rngEdaWoe = rngEdaWoe;
    }
    public String getRngEdaDesLar() {
        return this.rngEdaDesLar;
    }
    
    public void setRngEdaDesLar(String rngEdaDesLar) {
        this.rngEdaDesLar = rngEdaDesLar;
    }




}


