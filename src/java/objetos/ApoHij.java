package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * ApoHij generated by hbm2java
 */
public class ApoHij  implements java.io.Serializable {


     private BigDecimal apoHijId;
     private Cal cal;
     private String apoHijDes;
     private Double apoHijLimInf;
     private Double apoHijLimSup;
     private BigDecimal apoHijOrdPre;
     private Double apoHijPto;
     private Double apoHijWoe;
     private String apoHijDesLar;
     private Set<CliGol> cliGols = new HashSet<CliGol>(0);

    public ApoHij() {
    }

	
    public ApoHij(BigDecimal apoHijId) {
        this.apoHijId = apoHijId;
    }
    public ApoHij(BigDecimal apoHijId, Cal cal, String apoHijDes, Double apoHijLimInf, Double apoHijLimSup, BigDecimal apoHijOrdPre, Double apoHijPto, Double apoHijWoe, String apoHijDesLar, Set<CliGol> cliGols) {
       this.apoHijId = apoHijId;
       this.cal = cal;
       this.apoHijDes = apoHijDes;
       this.apoHijLimInf = apoHijLimInf;
       this.apoHijLimSup = apoHijLimSup;
       this.apoHijOrdPre = apoHijOrdPre;
       this.apoHijPto = apoHijPto;
       this.apoHijWoe = apoHijWoe;
       this.apoHijDesLar = apoHijDesLar;
       this.cliGols = cliGols;
    }
   
    public BigDecimal getApoHijId() {
        return this.apoHijId;
    }
    
    public void setApoHijId(BigDecimal apoHijId) {
        this.apoHijId = apoHijId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getApoHijDes() {
        return this.apoHijDes;
    }
    
    public void setApoHijDes(String apoHijDes) {
        this.apoHijDes = apoHijDes;
    }
    public Double getApoHijLimInf() {
        return this.apoHijLimInf;
    }
    
    public void setApoHijLimInf(Double apoHijLimInf) {
        this.apoHijLimInf = apoHijLimInf;
    }
    public Double getApoHijLimSup() {
        return this.apoHijLimSup;
    }
    
    public void setApoHijLimSup(Double apoHijLimSup) {
        this.apoHijLimSup = apoHijLimSup;
    }
    public BigDecimal getApoHijOrdPre() {
        return this.apoHijOrdPre;
    }
    
    public void setApoHijOrdPre(BigDecimal apoHijOrdPre) {
        this.apoHijOrdPre = apoHijOrdPre;
    }
    public Double getApoHijPto() {
        return this.apoHijPto;
    }
    
    public void setApoHijPto(Double apoHijPto) {
        this.apoHijPto = apoHijPto;
    }
    public Double getApoHijWoe() {
        return this.apoHijWoe;
    }
    
    public void setApoHijWoe(Double apoHijWoe) {
        this.apoHijWoe = apoHijWoe;
    }
    public String getApoHijDesLar() {
        return this.apoHijDesLar;
    }
    
    public void setApoHijDesLar(String apoHijDesLar) {
        this.apoHijDesLar = apoHijDesLar;
    }
    public Set<CliGol> getCliGols() {
        return this.cliGols;
    }
    
    public void setCliGols(Set<CliGol> cliGols) {
        this.cliGols = cliGols;
    }




}


