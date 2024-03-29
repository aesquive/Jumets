package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * BanPorPag generated by hbm2java
 */
public class BanPorPag  implements java.io.Serializable {


     private BigDecimal banPorPagId;
     private Cal cal;
     private String banPorPagDes;
     private Double banPorPagLimInf;
     private Double banPorPagLimSup;
     private BigDecimal banPorPagOrdPre;
     private Double banPorPagPto;
     private Double banPorPagWoe;
     private String banPorPagDesLar;
     private Set<CliMta> cliMtas = new HashSet<CliMta>(0);

    public BanPorPag() {
    }

	
    public BanPorPag(BigDecimal banPorPagId) {
        this.banPorPagId = banPorPagId;
    }
    public BanPorPag(BigDecimal banPorPagId, Cal cal, String banPorPagDes, Double banPorPagLimInf, Double banPorPagLimSup, BigDecimal banPorPagOrdPre, Double banPorPagPto, Double banPorPagWoe, String banPorPagDesLar, Set<CliMta> cliMtas) {
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
   
    public BigDecimal getBanPorPagId() {
        return this.banPorPagId;
    }
    
    public void setBanPorPagId(BigDecimal banPorPagId) {
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
    public Double getBanPorPagLimInf() {
        return this.banPorPagLimInf;
    }
    
    public void setBanPorPagLimInf(Double banPorPagLimInf) {
        this.banPorPagLimInf = banPorPagLimInf;
    }
    public Double getBanPorPagLimSup() {
        return this.banPorPagLimSup;
    }
    
    public void setBanPorPagLimSup(Double banPorPagLimSup) {
        this.banPorPagLimSup = banPorPagLimSup;
    }
    public BigDecimal getBanPorPagOrdPre() {
        return this.banPorPagOrdPre;
    }
    
    public void setBanPorPagOrdPre(BigDecimal banPorPagOrdPre) {
        this.banPorPagOrdPre = banPorPagOrdPre;
    }
    public Double getBanPorPagPto() {
        return this.banPorPagPto;
    }
    
    public void setBanPorPagPto(Double banPorPagPto) {
        this.banPorPagPto = banPorPagPto;
    }
    public Double getBanPorPagWoe() {
        return this.banPorPagWoe;
    }
    
    public void setBanPorPagWoe(Double banPorPagWoe) {
        this.banPorPagWoe = banPorPagWoe;
    }
    public String getBanPorPagDesLar() {
        return this.banPorPagDesLar;
    }
    
    public void setBanPorPagDesLar(String banPorPagDesLar) {
        this.banPorPagDesLar = banPorPagDesLar;
    }
    public Set<CliMta> getCliMtas() {
        return this.cliMtas;
    }
    
    public void setCliMtas(Set<CliMta> cliMtas) {
        this.cliMtas = cliMtas;
    }




}


