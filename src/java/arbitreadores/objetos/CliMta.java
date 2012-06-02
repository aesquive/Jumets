package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * CliMta generated by hbm2java
 */
public class CliMta  implements java.io.Serializable {


     private Integer cliMtaId;
     private OpnBar opnBar;
     private BurAnt burAnt;
     private Edo edo;
     private Sex sex;
     private Rol rol;
     private AsoPar asoPar;
     private RngEda rngEda;
     private BurAct burAct;
     private Rel rel;
     private BurUso burUso;
     private Gpo gpo;
     private BanPorUso banPorUso;
     private TipRes tipRes;
     private BanPorPag banPorPag;
     private ActExt actExt;
     private Ocp ocp;
     private Ing ing;
     private Cli cli;
     private Mig mig;
     private ParPlt parPlt;
     private Ptm ptm;
     private DepEco depEco;
     private NivEst nivEst;
     private Cal cal;
     private DinExt dinExt;
     private EdoCvl edoCvl;
     private ProAnoGto proAnoGto;
     private BurHis burHis;
     private TipEmp tipEmp;
     private Rld rld;
     private BurPag burPag;
     private Date cliFecNac;
     private String codPosId;
     private Float cliAntRes;
     private Float cliAntEmp;
     private Integer banCmpId;
     private Character cliIndTarCre;
     private Character cliIndBurCre;
     private String cliDesOcu;
     private Integer cliIngMen;
     private Integer desId;
     private Integer cliValViv;
     private Integer cliValMen;

    public CliMta() {
    }

    public CliMta(OpnBar opnBar, BurAnt burAnt, Edo edo, Sex sex, Rol rol, AsoPar asoPar, RngEda rngEda, BurAct burAct, Rel rel, BurUso burUso, Gpo gpo, BanPorUso banPorUso, TipRes tipRes, BanPorPag banPorPag, ActExt actExt, Ocp ocp, Ing ing, Cli cli, Mig mig, ParPlt parPlt, Ptm ptm, DepEco depEco, NivEst nivEst, Cal cal, DinExt dinExt, EdoCvl edoCvl, ProAnoGto proAnoGto, BurHis burHis, TipEmp tipEmp, Rld rld, BurPag burPag, Date cliFecNac, String codPosId, Float cliAntRes, Float cliAntEmp, Integer banCmpId, Character cliIndTarCre, Character cliIndBurCre, String cliDesOcu, Integer cliIngMen, Integer desId, Integer cliValViv, Integer cliValMen) {
       this.opnBar = opnBar;
       this.burAnt = burAnt;
       this.edo = edo;
       this.sex = sex;
       this.rol = rol;
       this.asoPar = asoPar;
       this.rngEda = rngEda;
       this.burAct = burAct;
       this.rel = rel;
       this.burUso = burUso;
       this.gpo = gpo;
       this.banPorUso = banPorUso;
       this.tipRes = tipRes;
       this.banPorPag = banPorPag;
       this.actExt = actExt;
       this.ocp = ocp;
       this.ing = ing;
       this.cli = cli;
       this.mig = mig;
       this.parPlt = parPlt;
       this.ptm = ptm;
       this.depEco = depEco;
       this.nivEst = nivEst;
       this.cal = cal;
       this.dinExt = dinExt;
       this.edoCvl = edoCvl;
       this.proAnoGto = proAnoGto;
       this.burHis = burHis;
       this.tipEmp = tipEmp;
       this.rld = rld;
       this.burPag = burPag;
       this.cliFecNac = cliFecNac;
       this.codPosId = codPosId;
       this.cliAntRes = cliAntRes;
       this.cliAntEmp = cliAntEmp;
       this.banCmpId = banCmpId;
       this.cliIndTarCre = cliIndTarCre;
       this.cliIndBurCre = cliIndBurCre;
       this.cliDesOcu = cliDesOcu;
       this.cliIngMen = cliIngMen;
       this.desId = desId;
       this.cliValViv = cliValViv;
       this.cliValMen = cliValMen;
    }
   
    public Integer getCliMtaId() {
        return this.cliMtaId;
    }
    
    public void setCliMtaId(Integer cliMtaId) {
        this.cliMtaId = cliMtaId;
    }
    public OpnBar getOpnBar() {
        return this.opnBar;
    }
    
    public void setOpnBar(OpnBar opnBar) {
        this.opnBar = opnBar;
    }
    public BurAnt getBurAnt() {
        return this.burAnt;
    }
    
    public void setBurAnt(BurAnt burAnt) {
        this.burAnt = burAnt;
    }
    public Edo getEdo() {
        return this.edo;
    }
    
    public void setEdo(Edo edo) {
        this.edo = edo;
    }
    public Sex getSex() {
        return this.sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public AsoPar getAsoPar() {
        return this.asoPar;
    }
    
    public void setAsoPar(AsoPar asoPar) {
        this.asoPar = asoPar;
    }
    public RngEda getRngEda() {
        return this.rngEda;
    }
    
    public void setRngEda(RngEda rngEda) {
        this.rngEda = rngEda;
    }
    public BurAct getBurAct() {
        return this.burAct;
    }
    
    public void setBurAct(BurAct burAct) {
        this.burAct = burAct;
    }
    public Rel getRel() {
        return this.rel;
    }
    
    public void setRel(Rel rel) {
        this.rel = rel;
    }
    public BurUso getBurUso() {
        return this.burUso;
    }
    
    public void setBurUso(BurUso burUso) {
        this.burUso = burUso;
    }
    public Gpo getGpo() {
        return this.gpo;
    }
    
    public void setGpo(Gpo gpo) {
        this.gpo = gpo;
    }
    public BanPorUso getBanPorUso() {
        return this.banPorUso;
    }
    
    public void setBanPorUso(BanPorUso banPorUso) {
        this.banPorUso = banPorUso;
    }
    public TipRes getTipRes() {
        return this.tipRes;
    }
    
    public void setTipRes(TipRes tipRes) {
        this.tipRes = tipRes;
    }
    public BanPorPag getBanPorPag() {
        return this.banPorPag;
    }
    
    public void setBanPorPag(BanPorPag banPorPag) {
        this.banPorPag = banPorPag;
    }
    public ActExt getActExt() {
        return this.actExt;
    }
    
    public void setActExt(ActExt actExt) {
        this.actExt = actExt;
    }
    public Ocp getOcp() {
        return this.ocp;
    }
    
    public void setOcp(Ocp ocp) {
        this.ocp = ocp;
    }
    public Ing getIng() {
        return this.ing;
    }
    
    public void setIng(Ing ing) {
        this.ing = ing;
    }
    public Cli getCli() {
        return this.cli;
    }
    
    public void setCli(Cli cli) {
        this.cli = cli;
    }
    public Mig getMig() {
        return this.mig;
    }
    
    public void setMig(Mig mig) {
        this.mig = mig;
    }
    public ParPlt getParPlt() {
        return this.parPlt;
    }
    
    public void setParPlt(ParPlt parPlt) {
        this.parPlt = parPlt;
    }
    public Ptm getPtm() {
        return this.ptm;
    }
    
    public void setPtm(Ptm ptm) {
        this.ptm = ptm;
    }
    public DepEco getDepEco() {
        return this.depEco;
    }
    
    public void setDepEco(DepEco depEco) {
        this.depEco = depEco;
    }
    public NivEst getNivEst() {
        return this.nivEst;
    }
    
    public void setNivEst(NivEst nivEst) {
        this.nivEst = nivEst;
    }
    public Cal getCal() {
        return this.cal;
    }
    
    public void setCal(Cal cal) {
        this.cal = cal;
    }
    public DinExt getDinExt() {
        return this.dinExt;
    }
    
    public void setDinExt(DinExt dinExt) {
        this.dinExt = dinExt;
    }
    public EdoCvl getEdoCvl() {
        return this.edoCvl;
    }
    
    public void setEdoCvl(EdoCvl edoCvl) {
        this.edoCvl = edoCvl;
    }
    public ProAnoGto getProAnoGto() {
        return this.proAnoGto;
    }
    
    public void setProAnoGto(ProAnoGto proAnoGto) {
        this.proAnoGto = proAnoGto;
    }
    public BurHis getBurHis() {
        return this.burHis;
    }
    
    public void setBurHis(BurHis burHis) {
        this.burHis = burHis;
    }
    public TipEmp getTipEmp() {
        return this.tipEmp;
    }
    
    public void setTipEmp(TipEmp tipEmp) {
        this.tipEmp = tipEmp;
    }
    public Rld getRld() {
        return this.rld;
    }
    
    public void setRld(Rld rld) {
        this.rld = rld;
    }
    public BurPag getBurPag() {
        return this.burPag;
    }
    
    public void setBurPag(BurPag burPag) {
        this.burPag = burPag;
    }
    public Date getCliFecNac() {
        return this.cliFecNac;
    }
    
    public void setCliFecNac(Date cliFecNac) {
        this.cliFecNac = cliFecNac;
    }
    public String getCodPosId() {
        return this.codPosId;
    }
    
    public void setCodPosId(String codPosId) {
        this.codPosId = codPosId;
    }
    public Float getCliAntRes() {
        return this.cliAntRes;
    }
    
    public void setCliAntRes(Float cliAntRes) {
        this.cliAntRes = cliAntRes;
    }
    public Float getCliAntEmp() {
        return this.cliAntEmp;
    }
    
    public void setCliAntEmp(Float cliAntEmp) {
        this.cliAntEmp = cliAntEmp;
    }
    public Integer getBanCmpId() {
        return this.banCmpId;
    }
    
    public void setBanCmpId(Integer banCmpId) {
        this.banCmpId = banCmpId;
    }
    public Character getCliIndTarCre() {
        return this.cliIndTarCre;
    }
    
    public void setCliIndTarCre(Character cliIndTarCre) {
        this.cliIndTarCre = cliIndTarCre;
    }
    public Character getCliIndBurCre() {
        return this.cliIndBurCre;
    }
    
    public void setCliIndBurCre(Character cliIndBurCre) {
        this.cliIndBurCre = cliIndBurCre;
    }
    public String getCliDesOcu() {
        return this.cliDesOcu;
    }
    
    public void setCliDesOcu(String cliDesOcu) {
        this.cliDesOcu = cliDesOcu;
    }
    public Integer getCliIngMen() {
        return this.cliIngMen;
    }
    
    public void setCliIngMen(Integer cliIngMen) {
        this.cliIngMen = cliIngMen;
    }
    public Integer getDesId() {
        return this.desId;
    }
    
    public void setDesId(Integer desId) {
        this.desId = desId;
    }
    public Integer getCliValViv() {
        return this.cliValViv;
    }
    
    public void setCliValViv(Integer cliValViv) {
        this.cliValViv = cliValViv;
    }
    public Integer getCliValMen() {
        return this.cliValMen;
    }
    
    public void setCliValMen(Integer cliValMen) {
        this.cliValMen = cliValMen;
    }




}


