package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA



/**
 * GtoEdu generated by hbm2java
 */
public class GtoEdu  implements java.io.Serializable {


     private int gtoEduId;
     private Cal cal;
     private String gtoEduDes;
     private Float gtoEduLimInf;
     private Float gtoEduLimSup;
     private Integer gtoEduOrdPre;
     private Float gtoEduPto;
     private Float gtoEduWoe;
     private String gtoEduDesLar;

    public GtoEdu() {
    }

	
    public GtoEdu(int gtoEduId) {
        this.gtoEduId = gtoEduId;
    }
    public GtoEdu(int gtoEduId, Cal cal, String gtoEduDes, Float gtoEduLimInf, Float gtoEduLimSup, Integer gtoEduOrdPre, Float gtoEduPto, Float gtoEduWoe, String gtoEduDesLar) {
       this.gtoEduId = gtoEduId;
       this.cal = cal;
       this.gtoEduDes = gtoEduDes;
       this.gtoEduLimInf = gtoEduLimInf;
       this.gtoEduLimSup = gtoEduLimSup;
       this.gtoEduOrdPre = gtoEduOrdPre;
       this.gtoEduPto = gtoEduPto;
       this.gtoEduWoe = gtoEduWoe;
       this.gtoEduDesLar = gtoEduDesLar;
    }
   
    public int getGtoEduId() {
        return this.gtoEduId;
    }
    
    public void setGtoEduId(int gtoEduId) {
        this.gtoEduId = gtoEduId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getGtoEduDes() {
        return this.gtoEduDes;
    }
    
    public void setGtoEduDes(String gtoEduDes) {
        this.gtoEduDes = gtoEduDes;
    }
    public Float getGtoEduLimInf() {
        return this.gtoEduLimInf;
    }
    
    public void setGtoEduLimInf(Float gtoEduLimInf) {
        this.gtoEduLimInf = gtoEduLimInf;
    }
    public Float getGtoEduLimSup() {
        return this.gtoEduLimSup;
    }
    
    public void setGtoEduLimSup(Float gtoEduLimSup) {
        this.gtoEduLimSup = gtoEduLimSup;
    }
    public Integer getGtoEduOrdPre() {
        return this.gtoEduOrdPre;
    }
    
    public void setGtoEduOrdPre(Integer gtoEduOrdPre) {
        this.gtoEduOrdPre = gtoEduOrdPre;
    }
    public Float getGtoEduPto() {
        return this.gtoEduPto;
    }
    
    public void setGtoEduPto(Float gtoEduPto) {
        this.gtoEduPto = gtoEduPto;
    }
    public Float getGtoEduWoe() {
        return this.gtoEduWoe;
    }
    
    public void setGtoEduWoe(Float gtoEduWoe) {
        this.gtoEduWoe = gtoEduWoe;
    }
    public String getGtoEduDesLar() {
        return this.gtoEduDesLar;
    }
    
    public void setGtoEduDesLar(String gtoEduDesLar) {
        this.gtoEduDesLar = gtoEduDesLar;
    }




}


