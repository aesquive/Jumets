package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * BurAct generated by hbm2java
 */
public class BurAct  implements java.io.Serializable {


     private BigDecimal burActId;
     private Cal cal;
     private String burActDes;
     private Double burActLimInf;
     private Double burActLimSup;
     private BigDecimal burActOrdPre;
     private Double burActPto;
     private Double burActWoe;
     private String burActDesLar;
     private Set<CliMta> cliMtas = new HashSet<CliMta>(0);
     private Set<CliBur> cliBursForBurAntId = new HashSet<CliBur>(0);
     private Set<CliBur> cliBursForBurActId = new HashSet<CliBur>(0);

    public BurAct() {
    }

	
    public BurAct(BigDecimal burActId) {
        this.burActId = burActId;
    }
    public BurAct(BigDecimal burActId, Cal cal, String burActDes, Double burActLimInf, Double burActLimSup, BigDecimal burActOrdPre, Double burActPto, Double burActWoe, String burActDesLar, Set<CliMta> cliMtas, Set<CliBur> cliBursForBurAntId, Set<CliBur> cliBursForBurActId) {
       this.burActId = burActId;
       this.cal = cal;
       this.burActDes = burActDes;
       this.burActLimInf = burActLimInf;
       this.burActLimSup = burActLimSup;
       this.burActOrdPre = burActOrdPre;
       this.burActPto = burActPto;
       this.burActWoe = burActWoe;
       this.burActDesLar = burActDesLar;
       this.cliMtas = cliMtas;
       this.cliBursForBurAntId = cliBursForBurAntId;
       this.cliBursForBurActId = cliBursForBurActId;
    }
   
    public BigDecimal getBurActId() {
        return this.burActId;
    }
    
    public void setBurActId(BigDecimal burActId) {
        this.burActId = burActId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getBurActDes() {
        return this.burActDes;
    }
    
    public void setBurActDes(String burActDes) {
        this.burActDes = burActDes;
    }
    public Double getBurActLimInf() {
        return this.burActLimInf;
    }
    
    public void setBurActLimInf(Double burActLimInf) {
        this.burActLimInf = burActLimInf;
    }
    public Double getBurActLimSup() {
        return this.burActLimSup;
    }
    
    public void setBurActLimSup(Double burActLimSup) {
        this.burActLimSup = burActLimSup;
    }
    public BigDecimal getBurActOrdPre() {
        return this.burActOrdPre;
    }
    
    public void setBurActOrdPre(BigDecimal burActOrdPre) {
        this.burActOrdPre = burActOrdPre;
    }
    public Double getBurActPto() {
        return this.burActPto;
    }
    
    public void setBurActPto(Double burActPto) {
        this.burActPto = burActPto;
    }
    public Double getBurActWoe() {
        return this.burActWoe;
    }
    
    public void setBurActWoe(Double burActWoe) {
        this.burActWoe = burActWoe;
    }
    public String getBurActDesLar() {
        return this.burActDesLar;
    }
    
    public void setBurActDesLar(String burActDesLar) {
        this.burActDesLar = burActDesLar;
    }
    public Set<CliMta> getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set<CliMta> cliMtas) {
        this.cliMtas = cliMtas;
    }
    public Set<CliBur> getCliBursForBurAntId() {
        return this.cliBursForBurAntId;
    }
    
    public void setCliBursForBurAntId(Set<CliBur> cliBursForBurAntId) {
        this.cliBursForBurAntId = cliBursForBurAntId;
    }
    public Set<CliBur> getCliBursForBurActId() {
        return this.cliBursForBurActId;
    }
    
    public void setCliBursForBurActId(Set<CliBur> cliBursForBurActId) {
        this.cliBursForBurActId = cliBursForBurActId;
    }




}

