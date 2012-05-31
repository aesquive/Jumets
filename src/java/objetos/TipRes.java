package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TipRes generated by hbm2java
 */
public class TipRes  implements java.io.Serializable {


     private BigDecimal tipResId;
     private BigDecimal calId;
     private String tipResDes;
     private Double tipResLimInf;
     private Double tipResLimSup;
     private BigDecimal tipResOrdPre;
     private Double tipResPto;
     private Double tipResWoe;
     private String tipResDesLar;
     private Set<CliMta> cliMtas = new HashSet<CliMta>(0);

    public TipRes() {
    }

	
    public TipRes(BigDecimal tipResId) {
        this.tipResId = tipResId;
    }
    public TipRes(BigDecimal tipResId, BigDecimal calId, String tipResDes, Double tipResLimInf, Double tipResLimSup, BigDecimal tipResOrdPre, Double tipResPto, Double tipResWoe, String tipResDesLar, Set<CliMta> cliMtas) {
       this.tipResId = tipResId;
       this.calId = calId;
       this.tipResDes = tipResDes;
       this.tipResLimInf = tipResLimInf;
       this.tipResLimSup = tipResLimSup;
       this.tipResOrdPre = tipResOrdPre;
       this.tipResPto = tipResPto;
       this.tipResWoe = tipResWoe;
       this.tipResDesLar = tipResDesLar;
       this.cliMtas = cliMtas;
    }
   
    public BigDecimal getTipResId() {
        return this.tipResId;
    }
    
    public void setTipResId(BigDecimal tipResId) {
        this.tipResId = tipResId;
    }
    public BigDecimal getCalId() {
        return this.calId;
    }
    
    public void setCalId(BigDecimal calId) {
        this.calId = calId;
    }
    public String getTipResDes() {
        return this.tipResDes;
    }
    
    public void setTipResDes(String tipResDes) {
        this.tipResDes = tipResDes;
    }
    public Double getTipResLimInf() {
        return this.tipResLimInf;
    }
    
    public void setTipResLimInf(Double tipResLimInf) {
        this.tipResLimInf = tipResLimInf;
    }
    public Double getTipResLimSup() {
        return this.tipResLimSup;
    }
    
    public void setTipResLimSup(Double tipResLimSup) {
        this.tipResLimSup = tipResLimSup;
    }
    public BigDecimal getTipResOrdPre() {
        return this.tipResOrdPre;
    }
    
    public void setTipResOrdPre(BigDecimal tipResOrdPre) {
        this.tipResOrdPre = tipResOrdPre;
    }
    public Double getTipResPto() {
        return this.tipResPto;
    }
    
    public void setTipResPto(Double tipResPto) {
        this.tipResPto = tipResPto;
    }
    public Double getTipResWoe() {
        return this.tipResWoe;
    }
    
    public void setTipResWoe(Double tipResWoe) {
        this.tipResWoe = tipResWoe;
    }
    public String getTipResDesLar() {
        return this.tipResDesLar;
    }
    
    public void setTipResDesLar(String tipResDesLar) {
        this.tipResDesLar = tipResDesLar;
    }
    public Set<CliMta> getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set<CliMta> cliMtas) {
        this.cliMtas = cliMtas;
    }




}


