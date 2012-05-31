package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol  implements java.io.Serializable {


     private BigDecimal rolId;
     private BigDecimal calId;
     private String rolDes;
     private Double rolLimInf;
     private Double rolLimSup;
     private BigDecimal rolOrdPre;
     private Double rolPto;
     private Double rolWoe;
     private String rolDesLar;
     private Set<CliGol> cliGols = new HashSet<CliGol>(0);
     private Set<CliMta> cliMtas = new HashSet<CliMta>(0);

    public Rol() {
    }

	
    public Rol(BigDecimal rolId) {
        this.rolId = rolId;
    }
    public Rol(BigDecimal rolId, BigDecimal calId, String rolDes, Double rolLimInf, Double rolLimSup, BigDecimal rolOrdPre, Double rolPto, Double rolWoe, String rolDesLar, Set<CliGol> cliGols, Set<CliMta> cliMtas) {
       this.rolId = rolId;
       this.calId = calId;
       this.rolDes = rolDes;
       this.rolLimInf = rolLimInf;
       this.rolLimSup = rolLimSup;
       this.rolOrdPre = rolOrdPre;
       this.rolPto = rolPto;
       this.rolWoe = rolWoe;
       this.rolDesLar = rolDesLar;
       this.cliGols = cliGols;
       this.cliMtas = cliMtas;
    }
   
    public BigDecimal getRolId() {
        return this.rolId;
    }
    
    public void setRolId(BigDecimal rolId) {
        this.rolId = rolId;
    }
    public BigDecimal getCalId() {
        return this.calId;
    }
    
    public void setCalId(BigDecimal calId) {
        this.calId = calId;
    }
    public String getRolDes() {
        return this.rolDes;
    }
    
    public void setRolDes(String rolDes) {
        this.rolDes = rolDes;
    }
    public Double getRolLimInf() {
        return this.rolLimInf;
    }
    
    public void setRolLimInf(Double rolLimInf) {
        this.rolLimInf = rolLimInf;
    }
    public Double getRolLimSup() {
        return this.rolLimSup;
    }
    
    public void setRolLimSup(Double rolLimSup) {
        this.rolLimSup = rolLimSup;
    }
    public BigDecimal getRolOrdPre() {
        return this.rolOrdPre;
    }
    
    public void setRolOrdPre(BigDecimal rolOrdPre) {
        this.rolOrdPre = rolOrdPre;
    }
    public Double getRolPto() {
        return this.rolPto;
    }
    
    public void setRolPto(Double rolPto) {
        this.rolPto = rolPto;
    }
    public Double getRolWoe() {
        return this.rolWoe;
    }
    
    public void setRolWoe(Double rolWoe) {
        this.rolWoe = rolWoe;
    }
    public String getRolDesLar() {
        return this.rolDesLar;
    }
    
    public void setRolDesLar(String rolDesLar) {
        this.rolDesLar = rolDesLar;
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


