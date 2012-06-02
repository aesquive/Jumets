package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * ActExt generated by hbm2java
 */
public class ActExt  implements java.io.Serializable {


     private int actExtId;
     private Cal cal;
     private String actExtDes;
     private Float actExtLimInf;
     private Float actExtLimSup;
     private Integer actExtOrdPre;
     private Float actExtPto;
     private Float actExtWoe;
     private String actExtDesLar;
     private Set cliMtas = new HashSet(0);

    public ActExt() {
    }

	
    public ActExt(int actExtId) {
        this.actExtId = actExtId;
    }
    public ActExt(int actExtId, Cal cal, String actExtDes, Float actExtLimInf, Float actExtLimSup, Integer actExtOrdPre, Float actExtPto, Float actExtWoe, String actExtDesLar, Set cliMtas) {
       this.actExtId = actExtId;
       this.cal = cal;
       this.actExtDes = actExtDes;
       this.actExtLimInf = actExtLimInf;
       this.actExtLimSup = actExtLimSup;
       this.actExtOrdPre = actExtOrdPre;
       this.actExtPto = actExtPto;
       this.actExtWoe = actExtWoe;
       this.actExtDesLar = actExtDesLar;
       this.cliMtas = cliMtas;
    }
   
    public int getActExtId() {
        return this.actExtId;
    }
    
    public void setActExtId(int actExtId) {
        this.actExtId = actExtId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getActExtDes() {
        return this.actExtDes;
    }
    
    public void setActExtDes(String actExtDes) {
        this.actExtDes = actExtDes;
    }
    public Float getActExtLimInf() {
        return this.actExtLimInf;
    }
    
    public void setActExtLimInf(Float actExtLimInf) {
        this.actExtLimInf = actExtLimInf;
    }
    public Float getActExtLimSup() {
        return this.actExtLimSup;
    }
    
    public void setActExtLimSup(Float actExtLimSup) {
        this.actExtLimSup = actExtLimSup;
    }
    public Integer getActExtOrdPre() {
        return this.actExtOrdPre;
    }
    
    public void setActExtOrdPre(Integer actExtOrdPre) {
        this.actExtOrdPre = actExtOrdPre;
    }
    public Float getActExtPto() {
        return this.actExtPto;
    }
    
    public void setActExtPto(Float actExtPto) {
        this.actExtPto = actExtPto;
    }
    public Float getActExtWoe() {
        return this.actExtWoe;
    }
    
    public void setActExtWoe(Float actExtWoe) {
        this.actExtWoe = actExtWoe;
    }
    public String getActExtDesLar() {
        return this.actExtDesLar;
    }
    
    public void setActExtDesLar(String actExtDesLar) {
        this.actExtDesLar = actExtDesLar;
    }
    public Set getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set cliMtas) {
        this.cliMtas = cliMtas;
    }




}

