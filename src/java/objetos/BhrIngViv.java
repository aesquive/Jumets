package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * BhrIngViv generated by hbm2java
 */
public class BhrIngViv  implements java.io.Serializable {


     private BigDecimal bhrIngVivCntId;
     private BigDecimal calId;
     private String bhrIngVivDes;
     private Double bhrIngVivLimInf;
     private Double bhrIngVivLimSup;
     private BigDecimal bhrIngVivOrdPre;
     private Double bhrIngVivPto;
     private Double bhrIngVivWoe;
     private String bhrIngVivDesLar;
     private Set<CliBhr> cliBhrs = new HashSet<CliBhr>(0);

    public BhrIngViv() {
    }

	
    public BhrIngViv(BigDecimal bhrIngVivCntId) {
        this.bhrIngVivCntId = bhrIngVivCntId;
    }
    public BhrIngViv(BigDecimal bhrIngVivCntId, BigDecimal calId, String bhrIngVivDes, Double bhrIngVivLimInf, Double bhrIngVivLimSup, BigDecimal bhrIngVivOrdPre, Double bhrIngVivPto, Double bhrIngVivWoe, String bhrIngVivDesLar, Set<CliBhr> cliBhrs) {
       this.bhrIngVivCntId = bhrIngVivCntId;
       this.calId = calId;
       this.bhrIngVivDes = bhrIngVivDes;
       this.bhrIngVivLimInf = bhrIngVivLimInf;
       this.bhrIngVivLimSup = bhrIngVivLimSup;
       this.bhrIngVivOrdPre = bhrIngVivOrdPre;
       this.bhrIngVivPto = bhrIngVivPto;
       this.bhrIngVivWoe = bhrIngVivWoe;
       this.bhrIngVivDesLar = bhrIngVivDesLar;
       this.cliBhrs = cliBhrs;
    }
   
    public BigDecimal getBhrIngVivCntId() {
        return this.bhrIngVivCntId;
    }
    
    public void setBhrIngVivCntId(BigDecimal bhrIngVivCntId) {
        this.bhrIngVivCntId = bhrIngVivCntId;
    }
    public BigDecimal getCalId() {
        return this.calId;
    }
    
    public void setCalId(BigDecimal calId) {
        this.calId = calId;
    }
    public String getBhrIngVivDes() {
        return this.bhrIngVivDes;
    }
    
    public void setBhrIngVivDes(String bhrIngVivDes) {
        this.bhrIngVivDes = bhrIngVivDes;
    }
    public Double getBhrIngVivLimInf() {
        return this.bhrIngVivLimInf;
    }
    
    public void setBhrIngVivLimInf(Double bhrIngVivLimInf) {
        this.bhrIngVivLimInf = bhrIngVivLimInf;
    }
    public Double getBhrIngVivLimSup() {
        return this.bhrIngVivLimSup;
    }
    
    public void setBhrIngVivLimSup(Double bhrIngVivLimSup) {
        this.bhrIngVivLimSup = bhrIngVivLimSup;
    }
    public BigDecimal getBhrIngVivOrdPre() {
        return this.bhrIngVivOrdPre;
    }
    
    public void setBhrIngVivOrdPre(BigDecimal bhrIngVivOrdPre) {
        this.bhrIngVivOrdPre = bhrIngVivOrdPre;
    }
    public Double getBhrIngVivPto() {
        return this.bhrIngVivPto;
    }
    
    public void setBhrIngVivPto(Double bhrIngVivPto) {
        this.bhrIngVivPto = bhrIngVivPto;
    }
    public Double getBhrIngVivWoe() {
        return this.bhrIngVivWoe;
    }
    
    public void setBhrIngVivWoe(Double bhrIngVivWoe) {
        this.bhrIngVivWoe = bhrIngVivWoe;
    }
    public String getBhrIngVivDesLar() {
        return this.bhrIngVivDesLar;
    }
    
    public void setBhrIngVivDesLar(String bhrIngVivDesLar) {
        this.bhrIngVivDesLar = bhrIngVivDesLar;
    }
    public Set<CliBhr> getCliBhrs() {
        return this.cliBhrs;
    }
    
    public void setCliBhrs(Set<CliBhr> cliBhrs) {
        this.cliBhrs = cliBhrs;
    }




}


