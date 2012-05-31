package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TipEmp generated by hbm2java
 */
public class TipEmp  implements java.io.Serializable {


     private BigDecimal tipEmpId;
     private BigDecimal calId;
     private String tipEmpDes;
     private Double tipEmpLimInf;
     private Double tipEmpLimSup;
     private BigDecimal tipEmpOrdPre;
     private Double tipEmpPto;
     private Double tipEmpWoe;
     private String tipEmpDesLar;
     private Set<CliGol> cliGols = new HashSet<CliGol>(0);
     private Set<CliMta> cliMtas = new HashSet<CliMta>(0);

    public TipEmp() {
    }

	
    public TipEmp(BigDecimal tipEmpId) {
        this.tipEmpId = tipEmpId;
    }
    public TipEmp(BigDecimal tipEmpId, BigDecimal calId, String tipEmpDes, Double tipEmpLimInf, Double tipEmpLimSup, BigDecimal tipEmpOrdPre, Double tipEmpPto, Double tipEmpWoe, String tipEmpDesLar, Set<CliGol> cliGols, Set<CliMta> cliMtas) {
       this.tipEmpId = tipEmpId;
       this.calId = calId;
       this.tipEmpDes = tipEmpDes;
       this.tipEmpLimInf = tipEmpLimInf;
       this.tipEmpLimSup = tipEmpLimSup;
       this.tipEmpOrdPre = tipEmpOrdPre;
       this.tipEmpPto = tipEmpPto;
       this.tipEmpWoe = tipEmpWoe;
       this.tipEmpDesLar = tipEmpDesLar;
       this.cliGols = cliGols;
       this.cliMtas = cliMtas;
    }
   
    public BigDecimal getTipEmpId() {
        return this.tipEmpId;
    }
    
    public void setTipEmpId(BigDecimal tipEmpId) {
        this.tipEmpId = tipEmpId;
    }
    public BigDecimal getCalId() {
        return this.calId;
    }
    
    public void setCalId(BigDecimal calId) {
        this.calId = calId;
    }
    public String getTipEmpDes() {
        return this.tipEmpDes;
    }
    
    public void setTipEmpDes(String tipEmpDes) {
        this.tipEmpDes = tipEmpDes;
    }
    public Double getTipEmpLimInf() {
        return this.tipEmpLimInf;
    }
    
    public void setTipEmpLimInf(Double tipEmpLimInf) {
        this.tipEmpLimInf = tipEmpLimInf;
    }
    public Double getTipEmpLimSup() {
        return this.tipEmpLimSup;
    }
    
    public void setTipEmpLimSup(Double tipEmpLimSup) {
        this.tipEmpLimSup = tipEmpLimSup;
    }
    public BigDecimal getTipEmpOrdPre() {
        return this.tipEmpOrdPre;
    }
    
    public void setTipEmpOrdPre(BigDecimal tipEmpOrdPre) {
        this.tipEmpOrdPre = tipEmpOrdPre;
    }
    public Double getTipEmpPto() {
        return this.tipEmpPto;
    }
    
    public void setTipEmpPto(Double tipEmpPto) {
        this.tipEmpPto = tipEmpPto;
    }
    public Double getTipEmpWoe() {
        return this.tipEmpWoe;
    }
    
    public void setTipEmpWoe(Double tipEmpWoe) {
        this.tipEmpWoe = tipEmpWoe;
    }
    public String getTipEmpDesLar() {
        return this.tipEmpDesLar;
    }
    
    public void setTipEmpDesLar(String tipEmpDesLar) {
        this.tipEmpDesLar = tipEmpDesLar;
    }
    public Set<CliGol> getCliGols() {
        return this.cliGols;
    }
    
    public void setCliGols(Set<CliGol> cliGols) {
        this.cliGols = cliGols;
    }
    public Set<CliMta> getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set<CliMta> cliMtas) {
        this.cliMtas = cliMtas;
    }




}

