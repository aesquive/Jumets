package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * CatPsi generated by hbm2java
 */
public class CatPsi  implements java.io.Serializable {


     private int catPsiId;
     private Cal cal;
     private String catPsiDes;
     private Set relPsiSocs = new HashSet(0);

    public CatPsi() {
    }

	
    public CatPsi(int catPsiId) {
        this.catPsiId = catPsiId;
    }
    public CatPsi(int catPsiId, Cal cal, String catPsiDes, Set relPsiSocs) {
       this.catPsiId = catPsiId;
       this.cal = cal;
       this.catPsiDes = catPsiDes;
       this.relPsiSocs = relPsiSocs;
    }
   
    public int getCatPsiId() {
        return this.catPsiId;
    }
    
    public void setCatPsiId(int catPsiId) {
        this.catPsiId = catPsiId;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public String getCatPsiDes() {
        return this.catPsiDes;
    }
    
    public void setCatPsiDes(String catPsiDes) {
        this.catPsiDes = catPsiDes;
    }
    public Set getRelPsiSocs() {
        return this.relPsiSocs;
    }
    
    public void setRelPsiSocs(Set relPsiSocs) {
        this.relPsiSocs = relPsiSocs;
    }




}


