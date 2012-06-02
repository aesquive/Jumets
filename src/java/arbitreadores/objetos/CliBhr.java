package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * CliBhr generated by hbm2java
 */
public class CliBhr  implements java.io.Serializable {


     private Integer cliBhrId;
     private Edo edo;
     private BhrCtaPurRie bhrCtaPurRie;
     private BhrAct bhrAct;
     private Eda eda;
     private Ocp ocp;
     private BhrMenIng bhrMenIng;
     private BhrPagPtlCnt bhrPagPtlCnt;
     private BhrEfi bhrEfi;
     private BhrIngViv bhrIngViv;
     private Integer ciId;
     private Integer ftrPprId;
     private Integer intPiId;
     private Set pagCliBhrs = new HashSet(0);

    public CliBhr() {
    }

    public CliBhr(Edo edo, BhrCtaPurRie bhrCtaPurRie, BhrAct bhrAct, Eda eda, Ocp ocp, BhrMenIng bhrMenIng, BhrPagPtlCnt bhrPagPtlCnt, BhrEfi bhrEfi, BhrIngViv bhrIngViv, Integer ciId, Integer ftrPprId, Integer intPiId, Set pagCliBhrs) {
       this.edo = edo;
       this.bhrCtaPurRie = bhrCtaPurRie;
       this.bhrAct = bhrAct;
       this.eda = eda;
       this.ocp = ocp;
       this.bhrMenIng = bhrMenIng;
       this.bhrPagPtlCnt = bhrPagPtlCnt;
       this.bhrEfi = bhrEfi;
       this.bhrIngViv = bhrIngViv;
       this.ciId = ciId;
       this.ftrPprId = ftrPprId;
       this.intPiId = intPiId;
       this.pagCliBhrs = pagCliBhrs;
    }
   
    public Integer getCliBhrId() {
        return this.cliBhrId;
    }
    
    public void setCliBhrId(Integer cliBhrId) {
        this.cliBhrId = cliBhrId;
    }
    public Edo getEdo() {
        return this.edo;
    }
    
    public void setEdo(Edo edo) {
        this.edo = edo;
    }
    public BhrCtaPurRie getBhrCtaPurRie() {
        return this.bhrCtaPurRie;
    }
    
    public void setBhrCtaPurRie(BhrCtaPurRie bhrCtaPurRie) {
        this.bhrCtaPurRie = bhrCtaPurRie;
    }
    public BhrAct getBhrAct() {
        return this.bhrAct;
    }
    
    public void setBhrAct(BhrAct bhrAct) {
        this.bhrAct = bhrAct;
    }
    public Eda getEda() {
        return this.eda;
    }
    
    public void setEda(Eda eda) {
        this.eda = eda;
    }
    public Ocp getOcp() {
        return this.ocp;
    }
    
    public void setOcp(Ocp ocp) {
        this.ocp = ocp;
    }
    public BhrMenIng getBhrMenIng() {
        return this.bhrMenIng;
    }
    
    public void setBhrMenIng(BhrMenIng bhrMenIng) {
        this.bhrMenIng = bhrMenIng;
    }
    public BhrPagPtlCnt getBhrPagPtlCnt() {
        return this.bhrPagPtlCnt;
    }
    
    public void setBhrPagPtlCnt(BhrPagPtlCnt bhrPagPtlCnt) {
        this.bhrPagPtlCnt = bhrPagPtlCnt;
    }
    public BhrEfi getBhrEfi() {
        return this.bhrEfi;
    }
    
    public void setBhrEfi(BhrEfi bhrEfi) {
        this.bhrEfi = bhrEfi;
    }
    public BhrIngViv getBhrIngViv() {
        return this.bhrIngViv;
    }
    
    public void setBhrIngViv(BhrIngViv bhrIngViv) {
        this.bhrIngViv = bhrIngViv;
    }
    public Integer getCiId() {
        return this.ciId;
    }
    
    public void setCiId(Integer ciId) {
        this.ciId = ciId;
    }
    public Integer getFtrPprId() {
        return this.ftrPprId;
    }
    
    public void setFtrPprId(Integer ftrPprId) {
        this.ftrPprId = ftrPprId;
    }
    public Integer getIntPiId() {
        return this.intPiId;
    }
    
    public void setIntPiId(Integer intPiId) {
        this.intPiId = intPiId;
    }
    public Set getPagCliBhrs() {
        return this.pagCliBhrs;
    }
    
    public void setPagCliBhrs(Set pagCliBhrs) {
        this.pagCliBhrs = pagCliBhrs;
    }




}

