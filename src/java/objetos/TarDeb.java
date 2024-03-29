package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * TarDeb generated by hbm2java
 */
public class TarDeb  implements java.io.Serializable {


     private BigDecimal tarDebId;
     private BigDecimal calId;
     private String tarDebDes;
     private Double tarDebLimInf;
     private Double tarDebLimSup;
     private BigDecimal tarDebOrdPre;
     private Double tarDebPto;
     private Double tarDebWoe;
     private String tarDebDesLar;

    public TarDeb() {
    }

	
    public TarDeb(BigDecimal tarDebId) {
        this.tarDebId = tarDebId;
    }
    public TarDeb(BigDecimal tarDebId, BigDecimal calId, String tarDebDes, Double tarDebLimInf, Double tarDebLimSup, BigDecimal tarDebOrdPre, Double tarDebPto, Double tarDebWoe, String tarDebDesLar) {
       this.tarDebId = tarDebId;
       this.calId = calId;
       this.tarDebDes = tarDebDes;
       this.tarDebLimInf = tarDebLimInf;
       this.tarDebLimSup = tarDebLimSup;
       this.tarDebOrdPre = tarDebOrdPre;
       this.tarDebPto = tarDebPto;
       this.tarDebWoe = tarDebWoe;
       this.tarDebDesLar = tarDebDesLar;
    }
   
    public BigDecimal getTarDebId() {
        return this.tarDebId;
    }
    
    public void setTarDebId(BigDecimal tarDebId) {
        this.tarDebId = tarDebId;
    }
    public BigDecimal getCalId() {
        return this.calId;
    }
    
    public void setCalId(BigDecimal calId) {
        this.calId = calId;
    }
    public String getTarDebDes() {
        return this.tarDebDes;
    }
    
    public void setTarDebDes(String tarDebDes) {
        this.tarDebDes = tarDebDes;
    }
    public Double getTarDebLimInf() {
        return this.tarDebLimInf;
    }
    
    public void setTarDebLimInf(Double tarDebLimInf) {
        this.tarDebLimInf = tarDebLimInf;
    }
    public Double getTarDebLimSup() {
        return this.tarDebLimSup;
    }
    
    public void setTarDebLimSup(Double tarDebLimSup) {
        this.tarDebLimSup = tarDebLimSup;
    }
    public BigDecimal getTarDebOrdPre() {
        return this.tarDebOrdPre;
    }
    
    public void setTarDebOrdPre(BigDecimal tarDebOrdPre) {
        this.tarDebOrdPre = tarDebOrdPre;
    }
    public Double getTarDebPto() {
        return this.tarDebPto;
    }
    
    public void setTarDebPto(Double tarDebPto) {
        this.tarDebPto = tarDebPto;
    }
    public Double getTarDebWoe() {
        return this.tarDebWoe;
    }
    
    public void setTarDebWoe(Double tarDebWoe) {
        this.tarDebWoe = tarDebWoe;
    }
    public String getTarDebDesLar() {
        return this.tarDebDesLar;
    }
    
    public void setTarDebDesLar(String tarDebDesLar) {
        this.tarDebDesLar = tarDebDesLar;
    }




}


