package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * RelFam generated by hbm2java
 */
public class RelFam  implements java.io.Serializable {


     private BigDecimal relFamId;
     private BigDecimal calId;
     private String relFamDes;
     private Double relFamLimInf;
     private Double relFamLimSup;
     private BigDecimal relFamOrdPre;
     private Double relFamPto;
     private Double relFamWoe;
     private String relFamDesLar;
     private Set<CliGol> cliGols = new HashSet<CliGol>(0);

    public RelFam() {
    }

	
    public RelFam(BigDecimal relFamId) {
        this.relFamId = relFamId;
    }
    public RelFam(BigDecimal relFamId, BigDecimal calId, String relFamDes, Double relFamLimInf, Double relFamLimSup, BigDecimal relFamOrdPre, Double relFamPto, Double relFamWoe, String relFamDesLar, Set<CliGol> cliGols) {
       this.relFamId = relFamId;
       this.calId = calId;
       this.relFamDes = relFamDes;
       this.relFamLimInf = relFamLimInf;
       this.relFamLimSup = relFamLimSup;
       this.relFamOrdPre = relFamOrdPre;
       this.relFamPto = relFamPto;
       this.relFamWoe = relFamWoe;
       this.relFamDesLar = relFamDesLar;
       this.cliGols = cliGols;
    }
   
    public BigDecimal getRelFamId() {
        return this.relFamId;
    }
    
    public void setRelFamId(BigDecimal relFamId) {
        this.relFamId = relFamId;
    }
    public BigDecimal getCalId() {
        return this.calId;
    }
    
    public void setCalId(BigDecimal calId) {
        this.calId = calId;
    }
    public String getRelFamDes() {
        return this.relFamDes;
    }
    
    public void setRelFamDes(String relFamDes) {
        this.relFamDes = relFamDes;
    }
    public Double getRelFamLimInf() {
        return this.relFamLimInf;
    }
    
    public void setRelFamLimInf(Double relFamLimInf) {
        this.relFamLimInf = relFamLimInf;
    }
    public Double getRelFamLimSup() {
        return this.relFamLimSup;
    }
    
    public void setRelFamLimSup(Double relFamLimSup) {
        this.relFamLimSup = relFamLimSup;
    }
    public BigDecimal getRelFamOrdPre() {
        return this.relFamOrdPre;
    }
    
    public void setRelFamOrdPre(BigDecimal relFamOrdPre) {
        this.relFamOrdPre = relFamOrdPre;
    }
    public Double getRelFamPto() {
        return this.relFamPto;
    }
    
    public void setRelFamPto(Double relFamPto) {
        this.relFamPto = relFamPto;
    }
    public Double getRelFamWoe() {
        return this.relFamWoe;
    }
    
    public void setRelFamWoe(Double relFamWoe) {
        this.relFamWoe = relFamWoe;
    }
    public String getRelFamDesLar() {
        return this.relFamDesLar;
    }
    
    public void setRelFamDesLar(String relFamDesLar) {
        this.relFamDesLar = relFamDesLar;
    }
    public Set<CliGol> getCliGols() {
        return this.cliGols;
    }
    
    public void setCliGols(Set<CliGol> cliGols) {
        this.cliGols = cliGols;
    }




}


