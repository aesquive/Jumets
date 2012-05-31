package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * SitPrxAn generated by hbm2java
 */
public class SitPrxAn  implements java.io.Serializable {


     private BigDecimal sitPrxAnId;
     private BigDecimal calId;
     private String sitPrxAnDes;
     private Double sitPrxAnLimInf;
     private Double sitPrxAnLimSup;
     private BigDecimal sitPrxAnOrdPre;
     private Double sitPrxAnPto;
     private Double sitPrxAnWoe;
     private String sitPrxAnDesLar;
     private Set<CliGol> cliGols = new HashSet<CliGol>(0);

    public SitPrxAn() {
    }

	
    public SitPrxAn(BigDecimal sitPrxAnId) {
        this.sitPrxAnId = sitPrxAnId;
    }
    public SitPrxAn(BigDecimal sitPrxAnId, BigDecimal calId, String sitPrxAnDes, Double sitPrxAnLimInf, Double sitPrxAnLimSup, BigDecimal sitPrxAnOrdPre, Double sitPrxAnPto, Double sitPrxAnWoe, String sitPrxAnDesLar, Set<CliGol> cliGols) {
       this.sitPrxAnId = sitPrxAnId;
       this.calId = calId;
       this.sitPrxAnDes = sitPrxAnDes;
       this.sitPrxAnLimInf = sitPrxAnLimInf;
       this.sitPrxAnLimSup = sitPrxAnLimSup;
       this.sitPrxAnOrdPre = sitPrxAnOrdPre;
       this.sitPrxAnPto = sitPrxAnPto;
       this.sitPrxAnWoe = sitPrxAnWoe;
       this.sitPrxAnDesLar = sitPrxAnDesLar;
       this.cliGols = cliGols;
    }
   
    public BigDecimal getSitPrxAnId() {
        return this.sitPrxAnId;
    }
    
    public void setSitPrxAnId(BigDecimal sitPrxAnId) {
        this.sitPrxAnId = sitPrxAnId;
    }
    public BigDecimal getCalId() {
        return this.calId;
    }
    
    public void setCalId(BigDecimal calId) {
        this.calId = calId;
    }
    public String getSitPrxAnDes() {
        return this.sitPrxAnDes;
    }
    
    public void setSitPrxAnDes(String sitPrxAnDes) {
        this.sitPrxAnDes = sitPrxAnDes;
    }
    public Double getSitPrxAnLimInf() {
        return this.sitPrxAnLimInf;
    }
    
    public void setSitPrxAnLimInf(Double sitPrxAnLimInf) {
        this.sitPrxAnLimInf = sitPrxAnLimInf;
    }
    public Double getSitPrxAnLimSup() {
        return this.sitPrxAnLimSup;
    }
    
    public void setSitPrxAnLimSup(Double sitPrxAnLimSup) {
        this.sitPrxAnLimSup = sitPrxAnLimSup;
    }
    public BigDecimal getSitPrxAnOrdPre() {
        return this.sitPrxAnOrdPre;
    }
    
    public void setSitPrxAnOrdPre(BigDecimal sitPrxAnOrdPre) {
        this.sitPrxAnOrdPre = sitPrxAnOrdPre;
    }
    public Double getSitPrxAnPto() {
        return this.sitPrxAnPto;
    }
    
    public void setSitPrxAnPto(Double sitPrxAnPto) {
        this.sitPrxAnPto = sitPrxAnPto;
    }
    public Double getSitPrxAnWoe() {
        return this.sitPrxAnWoe;
    }
    
    public void setSitPrxAnWoe(Double sitPrxAnWoe) {
        this.sitPrxAnWoe = sitPrxAnWoe;
    }
    public String getSitPrxAnDesLar() {
        return this.sitPrxAnDesLar;
    }
    
    public void setSitPrxAnDesLar(String sitPrxAnDesLar) {
        this.sitPrxAnDesLar = sitPrxAnDesLar;
    }
    public Set<CliGol> getCliGols() {
        return this.cliGols;
    }
    
    public void setCliGols(Set<CliGol> cliGols) {
        this.cliGols = cliGols;
    }




}


