package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * IntPi generated by hbm2java
 */
public class IntPi  implements java.io.Serializable {


     private int intPiId;
     private Cal cal;
     private String intPiDes;
     private Float intPiLimInf;
     private Float intPiLimSup;
     private Set cliPprs = new HashSet(0);

    public IntPi() {
    }

	
    public IntPi(int intPiId) {
        this.intPiId = intPiId;
    }
    public IntPi(int intPiId, Cal cal, String intPiDes, Float intPiLimInf, Float intPiLimSup, Set cliPprs) {
       this.intPiId = intPiId;
       this.cal = cal;
       this.intPiDes = intPiDes;
       this.intPiLimInf = intPiLimInf;
       this.intPiLimSup = intPiLimSup;
       this.cliPprs = cliPprs;
    }
   
    public int getIntPiId() {
        return this.intPiId;
    }
    
    public void setIntPiId(int intPiId) {
        this.intPiId = intPiId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getIntPiDes() {
        return this.intPiDes;
    }
    
    public void setIntPiDes(String intPiDes) {
        this.intPiDes = intPiDes;
    }
    public Float getIntPiLimInf() {
        return this.intPiLimInf;
    }
    
    public void setIntPiLimInf(Float intPiLimInf) {
        this.intPiLimInf = intPiLimInf;
    }
    public Float getIntPiLimSup() {
        return this.intPiLimSup;
    }
    
    public void setIntPiLimSup(Float intPiLimSup) {
        this.intPiLimSup = intPiLimSup;
    }
    public Set getCliPprs() {
        return this.cliPprs;
    }
    
    public void setCliPprs(Set cliPprs) {
        this.cliPprs = cliPprs;
    }




}


