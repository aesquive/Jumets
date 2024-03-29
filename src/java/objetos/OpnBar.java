package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * OpnBar generated by hbm2java
 */
public class OpnBar  implements java.io.Serializable {


     private BigDecimal opnBarId;
     private Cal cal;
     private String opnBarDes;
     private Double opnBarLimInf;
     private Double opnBarLimSup;
     private BigDecimal opnBarOrdPre;
     private Double opnBarPto;
     private Double opnBarWoe;
     private String opnBarDesLar;
     private Set<CliMta> cliMtas = new HashSet<CliMta>(0);

    public OpnBar() {
    }

	
    public OpnBar(BigDecimal opnBarId) {
        this.opnBarId = opnBarId;
    }
    public OpnBar(BigDecimal opnBarId, Cal cal, String opnBarDes, Double opnBarLimInf, Double opnBarLimSup, BigDecimal opnBarOrdPre, Double opnBarPto, Double opnBarWoe, String opnBarDesLar, Set<CliMta> cliMtas) {
       this.opnBarId = opnBarId;
       this.cal = cal;
       this.opnBarDes = opnBarDes;
       this.opnBarLimInf = opnBarLimInf;
       this.opnBarLimSup = opnBarLimSup;
       this.opnBarOrdPre = opnBarOrdPre;
       this.opnBarPto = opnBarPto;
       this.opnBarWoe = opnBarWoe;
       this.opnBarDesLar = opnBarDesLar;
       this.cliMtas = cliMtas;
    }
   
    public BigDecimal getOpnBarId() {
        return this.opnBarId;
    }
    
    public void setOpnBarId(BigDecimal opnBarId) {
        this.opnBarId = opnBarId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getOpnBarDes() {
        return this.opnBarDes;
    }
    
    public void setOpnBarDes(String opnBarDes) {
        this.opnBarDes = opnBarDes;
    }
    public Double getOpnBarLimInf() {
        return this.opnBarLimInf;
    }
    
    public void setOpnBarLimInf(Double opnBarLimInf) {
        this.opnBarLimInf = opnBarLimInf;
    }
    public Double getOpnBarLimSup() {
        return this.opnBarLimSup;
    }
    
    public void setOpnBarLimSup(Double opnBarLimSup) {
        this.opnBarLimSup = opnBarLimSup;
    }
    public BigDecimal getOpnBarOrdPre() {
        return this.opnBarOrdPre;
    }
    
    public void setOpnBarOrdPre(BigDecimal opnBarOrdPre) {
        this.opnBarOrdPre = opnBarOrdPre;
    }
    public Double getOpnBarPto() {
        return this.opnBarPto;
    }
    
    public void setOpnBarPto(Double opnBarPto) {
        this.opnBarPto = opnBarPto;
    }
    public Double getOpnBarWoe() {
        return this.opnBarWoe;
    }
    
    public void setOpnBarWoe(Double opnBarWoe) {
        this.opnBarWoe = opnBarWoe;
    }
    public String getOpnBarDesLar() {
        return this.opnBarDesLar;
    }
    
    public void setOpnBarDesLar(String opnBarDesLar) {
        this.opnBarDesLar = opnBarDesLar;
    }
    public Set<CliMta> getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set<CliMta> cliMtas) {
        this.cliMtas = cliMtas;
    }




}


