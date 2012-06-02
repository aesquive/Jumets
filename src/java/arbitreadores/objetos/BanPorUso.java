package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * BanPorUso generated by hbm2java
 */
public class BanPorUso  implements java.io.Serializable {


     private int banPorUsoId;
     private Cal cal;
     private String banPorUsoDes;
     private Float banPorUsoLimInf;
     private Float banPorUsoLimSup;
     private Integer banPorUsoOrdPre;
     private Float banPorUsoPto;
     private Float banPorUsoWoe;
     private String banPorUsoDesLar;
     private Set cliMtas = new HashSet(0);

    public BanPorUso() {
    }

	
    public BanPorUso(int banPorUsoId) {
        this.banPorUsoId = banPorUsoId;
    }
    public BanPorUso(int banPorUsoId, Cal cal, String banPorUsoDes, Float banPorUsoLimInf, Float banPorUsoLimSup, Integer banPorUsoOrdPre, Float banPorUsoPto, Float banPorUsoWoe, String banPorUsoDesLar, Set cliMtas) {
       this.banPorUsoId = banPorUsoId;
       this.cal = cal;
       this.banPorUsoDes = banPorUsoDes;
       this.banPorUsoLimInf = banPorUsoLimInf;
       this.banPorUsoLimSup = banPorUsoLimSup;
       this.banPorUsoOrdPre = banPorUsoOrdPre;
       this.banPorUsoPto = banPorUsoPto;
       this.banPorUsoWoe = banPorUsoWoe;
       this.banPorUsoDesLar = banPorUsoDesLar;
       this.cliMtas = cliMtas;
    }
   
    public int getBanPorUsoId() {
        return this.banPorUsoId;
    }
    
    public void setBanPorUsoId(int banPorUsoId) {
        this.banPorUsoId = banPorUsoId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getBanPorUsoDes() {
        return this.banPorUsoDes;
    }
    
    public void setBanPorUsoDes(String banPorUsoDes) {
        this.banPorUsoDes = banPorUsoDes;
    }
    public Float getBanPorUsoLimInf() {
        return this.banPorUsoLimInf;
    }
    
    public void setBanPorUsoLimInf(Float banPorUsoLimInf) {
        this.banPorUsoLimInf = banPorUsoLimInf;
    }
    public Float getBanPorUsoLimSup() {
        return this.banPorUsoLimSup;
    }
    
    public void setBanPorUsoLimSup(Float banPorUsoLimSup) {
        this.banPorUsoLimSup = banPorUsoLimSup;
    }
    public Integer getBanPorUsoOrdPre() {
        return this.banPorUsoOrdPre;
    }
    
    public void setBanPorUsoOrdPre(Integer banPorUsoOrdPre) {
        this.banPorUsoOrdPre = banPorUsoOrdPre;
    }
    public Float getBanPorUsoPto() {
        return this.banPorUsoPto;
    }
    
    public void setBanPorUsoPto(Float banPorUsoPto) {
        this.banPorUsoPto = banPorUsoPto;
    }
    public Float getBanPorUsoWoe() {
        return this.banPorUsoWoe;
    }
    
    public void setBanPorUsoWoe(Float banPorUsoWoe) {
        this.banPorUsoWoe = banPorUsoWoe;
    }
    public String getBanPorUsoDesLar() {
        return this.banPorUsoDesLar;
    }
    
    public void setBanPorUsoDesLar(String banPorUsoDesLar) {
        this.banPorUsoDesLar = banPorUsoDesLar;
    }
    public Set getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set cliMtas) {
        this.cliMtas = cliMtas;
    }




}

