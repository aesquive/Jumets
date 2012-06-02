package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * RngEda generated by hbm2java
 */
public class RngEda  implements java.io.Serializable {


     private int rngEdaId;
     private Integer calId;
     private String rngEdaDes;
     private Float rngEdaLimInf;
     private Float rngEdaLimSup;
     private Integer rngEdaOrdPre;
     private Float rngEdaPto;
     private Float rngEdaWoe;
     private String rngEdaDesLar;
     private Set cliMtas = new HashSet(0);

    public RngEda() {
    }

	
    public RngEda(int rngEdaId) {
        this.rngEdaId = rngEdaId;
    }
    public RngEda(int rngEdaId, Integer calId, String rngEdaDes, Float rngEdaLimInf, Float rngEdaLimSup, Integer rngEdaOrdPre, Float rngEdaPto, Float rngEdaWoe, String rngEdaDesLar, Set cliMtas) {
       this.rngEdaId = rngEdaId;
       this.calId = calId;
       this.rngEdaDes = rngEdaDes;
       this.rngEdaLimInf = rngEdaLimInf;
       this.rngEdaLimSup = rngEdaLimSup;
       this.rngEdaOrdPre = rngEdaOrdPre;
       this.rngEdaPto = rngEdaPto;
       this.rngEdaWoe = rngEdaWoe;
       this.rngEdaDesLar = rngEdaDesLar;
       this.cliMtas = cliMtas;
    }
   
    public int getRngEdaId() {
        return this.rngEdaId;
    }
    
    public void setRngEdaId(int rngEdaId) {
        this.rngEdaId = rngEdaId;
    }
    public Integer getCalId() {
        return this.calId;
    }
    
    public void setCalId(Integer calId) {
        this.calId = calId;
    }
    public String getRngEdaDes() {
        return this.rngEdaDes;
    }
    
    public void setRngEdaDes(String rngEdaDes) {
        this.rngEdaDes = rngEdaDes;
    }
    public Float getRngEdaLimInf() {
        return this.rngEdaLimInf;
    }
    
    public void setRngEdaLimInf(Float rngEdaLimInf) {
        this.rngEdaLimInf = rngEdaLimInf;
    }
    public Float getRngEdaLimSup() {
        return this.rngEdaLimSup;
    }
    
    public void setRngEdaLimSup(Float rngEdaLimSup) {
        this.rngEdaLimSup = rngEdaLimSup;
    }
    public Integer getRngEdaOrdPre() {
        return this.rngEdaOrdPre;
    }
    
    public void setRngEdaOrdPre(Integer rngEdaOrdPre) {
        this.rngEdaOrdPre = rngEdaOrdPre;
    }
    public Float getRngEdaPto() {
        return this.rngEdaPto;
    }
    
    public void setRngEdaPto(Float rngEdaPto) {
        this.rngEdaPto = rngEdaPto;
    }
    public Float getRngEdaWoe() {
        return this.rngEdaWoe;
    }
    
    public void setRngEdaWoe(Float rngEdaWoe) {
        this.rngEdaWoe = rngEdaWoe;
    }
    public String getRngEdaDesLar() {
        return this.rngEdaDesLar;
    }
    
    public void setRngEdaDesLar(String rngEdaDesLar) {
        this.rngEdaDesLar = rngEdaDesLar;
    }
    public Set getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set cliMtas) {
        this.cliMtas = cliMtas;
    }




}

