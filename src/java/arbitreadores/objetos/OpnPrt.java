package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA



/**
 * OpnPrt generated by hbm2java
 */
public class OpnPrt  implements java.io.Serializable {


     private int opnPrtId;
     private Cal cal;
     private String opnPrtDes;
     private Float opnPrtLimInf;
     private Float opnPrtLimSup;
     private Integer opnPrtOrdPre;
     private Float opnPrtPto;
     private Float opnPrtWoe;
     private String opnPrtDesLar;

    public OpnPrt() {
    }

	
    public OpnPrt(int opnPrtId) {
        this.opnPrtId = opnPrtId;
    }
    public OpnPrt(int opnPrtId, Cal cal, String opnPrtDes, Float opnPrtLimInf, Float opnPrtLimSup, Integer opnPrtOrdPre, Float opnPrtPto, Float opnPrtWoe, String opnPrtDesLar) {
       this.opnPrtId = opnPrtId;
       this.cal = cal;
       this.opnPrtDes = opnPrtDes;
       this.opnPrtLimInf = opnPrtLimInf;
       this.opnPrtLimSup = opnPrtLimSup;
       this.opnPrtOrdPre = opnPrtOrdPre;
       this.opnPrtPto = opnPrtPto;
       this.opnPrtWoe = opnPrtWoe;
       this.opnPrtDesLar = opnPrtDesLar;
    }
   
    public int getOpnPrtId() {
        return this.opnPrtId;
    }
    
    public void setOpnPrtId(int opnPrtId) {
        this.opnPrtId = opnPrtId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getOpnPrtDes() {
        return this.opnPrtDes;
    }
    
    public void setOpnPrtDes(String opnPrtDes) {
        this.opnPrtDes = opnPrtDes;
    }
    public Float getOpnPrtLimInf() {
        return this.opnPrtLimInf;
    }
    
    public void setOpnPrtLimInf(Float opnPrtLimInf) {
        this.opnPrtLimInf = opnPrtLimInf;
    }
    public Float getOpnPrtLimSup() {
        return this.opnPrtLimSup;
    }
    
    public void setOpnPrtLimSup(Float opnPrtLimSup) {
        this.opnPrtLimSup = opnPrtLimSup;
    }
    public Integer getOpnPrtOrdPre() {
        return this.opnPrtOrdPre;
    }
    
    public void setOpnPrtOrdPre(Integer opnPrtOrdPre) {
        this.opnPrtOrdPre = opnPrtOrdPre;
    }
    public Float getOpnPrtPto() {
        return this.opnPrtPto;
    }
    
    public void setOpnPrtPto(Float opnPrtPto) {
        this.opnPrtPto = opnPrtPto;
    }
    public Float getOpnPrtWoe() {
        return this.opnPrtWoe;
    }
    
    public void setOpnPrtWoe(Float opnPrtWoe) {
        this.opnPrtWoe = opnPrtWoe;
    }
    public String getOpnPrtDesLar() {
        return this.opnPrtDesLar;
    }
    
    public void setOpnPrtDesLar(String opnPrtDesLar) {
        this.opnPrtDesLar = opnPrtDesLar;
    }




}

