package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA



/**
 * RngAntEmp generated by hbm2java
 */
public class RngAntEmp  implements java.io.Serializable {


     private int rngAntEmpId;
     private Integer calId;
     private String rngAntEmpDes;
     private Float rngAntEmpLimInf;
     private Float rngAntEmpLimSup;
     private Integer rngAntEmpOrdPre;
     private Float rngAntEmpPto;
     private Float rngAntEmpWoe;
     private String rngAntEmpDesLar;

    public RngAntEmp() {
    }

	
    public RngAntEmp(int rngAntEmpId) {
        this.rngAntEmpId = rngAntEmpId;
    }
    public RngAntEmp(int rngAntEmpId, Integer calId, String rngAntEmpDes, Float rngAntEmpLimInf, Float rngAntEmpLimSup, Integer rngAntEmpOrdPre, Float rngAntEmpPto, Float rngAntEmpWoe, String rngAntEmpDesLar) {
       this.rngAntEmpId = rngAntEmpId;
       this.calId = calId;
       this.rngAntEmpDes = rngAntEmpDes;
       this.rngAntEmpLimInf = rngAntEmpLimInf;
       this.rngAntEmpLimSup = rngAntEmpLimSup;
       this.rngAntEmpOrdPre = rngAntEmpOrdPre;
       this.rngAntEmpPto = rngAntEmpPto;
       this.rngAntEmpWoe = rngAntEmpWoe;
       this.rngAntEmpDesLar = rngAntEmpDesLar;
    }
   
    public int getRngAntEmpId() {
        return this.rngAntEmpId;
    }
    
    public void setRngAntEmpId(int rngAntEmpId) {
        this.rngAntEmpId = rngAntEmpId;
    }
    public Integer getCalId() {
        return this.calId;
    }
    
    public void setCalId(Integer calId) {
        this.calId = calId;
    }
    public String getRngAntEmpDes() {
        return this.rngAntEmpDes;
    }
    
    public void setRngAntEmpDes(String rngAntEmpDes) {
        this.rngAntEmpDes = rngAntEmpDes;
    }
    public Float getRngAntEmpLimInf() {
        return this.rngAntEmpLimInf;
    }
    
    public void setRngAntEmpLimInf(Float rngAntEmpLimInf) {
        this.rngAntEmpLimInf = rngAntEmpLimInf;
    }
    public Float getRngAntEmpLimSup() {
        return this.rngAntEmpLimSup;
    }
    
    public void setRngAntEmpLimSup(Float rngAntEmpLimSup) {
        this.rngAntEmpLimSup = rngAntEmpLimSup;
    }
    public Integer getRngAntEmpOrdPre() {
        return this.rngAntEmpOrdPre;
    }
    
    public void setRngAntEmpOrdPre(Integer rngAntEmpOrdPre) {
        this.rngAntEmpOrdPre = rngAntEmpOrdPre;
    }
    public Float getRngAntEmpPto() {
        return this.rngAntEmpPto;
    }
    
    public void setRngAntEmpPto(Float rngAntEmpPto) {
        this.rngAntEmpPto = rngAntEmpPto;
    }
    public Float getRngAntEmpWoe() {
        return this.rngAntEmpWoe;
    }
    
    public void setRngAntEmpWoe(Float rngAntEmpWoe) {
        this.rngAntEmpWoe = rngAntEmpWoe;
    }
    public String getRngAntEmpDesLar() {
        return this.rngAntEmpDesLar;
    }
    
    public void setRngAntEmpDesLar(String rngAntEmpDesLar) {
        this.rngAntEmpDesLar = rngAntEmpDesLar;
    }




}


