package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * BanPorPag generated by hbm2java
 */
public class BanPorPag  implements java.io.Serializable {


     private int banPorPagId;
     private Cal cal;
     private String banPorPagDes;
     private Float banPorPagLimInf;
     private Float banPorPagLimSup;
     private Integer banPorPagOrdPre;
     private Float banPorPagPto;
     private Float banPorPagWoe;
     private String banPorPagDesLar;
     private Set cliMtas = new HashSet(0);

    public BanPorPag() {
    }

	
    public BanPorPag(int banPorPagId) {
        this.banPorPagId = banPorPagId;
    }
    public BanPorPag(int banPorPagId, Cal cal, String banPorPagDes, Float banPorPagLimInf, Float banPorPagLimSup, Integer banPorPagOrdPre, Float banPorPagPto, Float banPorPagWoe, String banPorPagDesLar, Set cliMtas) {
       this.banPorPagId = banPorPagId;
       this.cal = cal;
       this.banPorPagDes = banPorPagDes;
       this.banPorPagLimInf = banPorPagLimInf;
       this.banPorPagLimSup = banPorPagLimSup;
       this.banPorPagOrdPre = banPorPagOrdPre;
       this.banPorPagPto = banPorPagPto;
       this.banPorPagWoe = banPorPagWoe;
       this.banPorPagDesLar = banPorPagDesLar;
       this.cliMtas = cliMtas;
    }
   
    public int getBanPorPagId() {
        return this.banPorPagId;
    }
    
    public void setBanPorPagId(int banPorPagId) {
        this.banPorPagId = banPorPagId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getBanPorPagDes() {
        return this.banPorPagDes;
    }
    
    public void setBanPorPagDes(String banPorPagDes) {
        this.banPorPagDes = banPorPagDes;
    }
    public Float getBanPorPagLimInf() {
        return this.banPorPagLimInf;
    }
    
    public void setBanPorPagLimInf(Float banPorPagLimInf) {
        this.banPorPagLimInf = banPorPagLimInf;
    }
    public Float getBanPorPagLimSup() {
        return this.banPorPagLimSup;
    }
    
    public void setBanPorPagLimSup(Float banPorPagLimSup) {
        this.banPorPagLimSup = banPorPagLimSup;
    }
    public Integer getBanPorPagOrdPre() {
        return this.banPorPagOrdPre;
    }
    
    public void setBanPorPagOrdPre(Integer banPorPagOrdPre) {
        this.banPorPagOrdPre = banPorPagOrdPre;
    }
    public Float getBanPorPagPto() {
        return this.banPorPagPto;
    }
    
    public void setBanPorPagPto(Float banPorPagPto) {
        this.banPorPagPto = banPorPagPto;
    }
    public Float getBanPorPagWoe() {
        return this.banPorPagWoe;
    }
    
    public void setBanPorPagWoe(Float banPorPagWoe) {
        this.banPorPagWoe = banPorPagWoe;
    }
    public String getBanPorPagDesLar() {
        return this.banPorPagDesLar;
    }
    
    public void setBanPorPagDesLar(String banPorPagDesLar) {
        this.banPorPagDesLar = banPorPagDesLar;
    }
    public Set getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set cliMtas) {
        this.cliMtas = cliMtas;
    }




}


