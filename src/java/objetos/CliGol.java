package objetos;
// Generated 1/04/2010 01:02:42 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * CliGol generated by hbm2java
 */
public class CliGol  implements java.io.Serializable {


     private BigDecimal cliGolId;
     private ApoPad apoPad;
     private Srv srv;
     private SolCre solCre;
     private IPsi IPsi;
     private ProAnoGto proAnoGto;
     private GtoAlm gtoAlmByGtoAlmId;
     private GtoDeu gtoDeuByGtoDeuId;
     private ApoCon apoCon;
     private GtoLim gtoLim;
     private Mov mov;
     private Pbm pbm;
     private Rel rel;
     private Rol rol;
     private ApoOtr apoOtr;
     private TipCre tipCre;
     private Ptm ptm;
     private ApoHij apoHij;
     private Est est;
     private ActUlt actUlt;
     private VlrViv vlrViv;
     private GtoDiv gtoDiv;
     private CueAbr cueAbr;
     private NivEstPap nivEstPap;
     private GtoEdu gtoEdu;
     private FreRel freRel;
     private Sex sex;
     private NivEst nivEst;
     private NivEstMam nivEstMam;
     private DinExt dinExt;
     private GtoTrn gtoTrn;
     private SitPrxAn sitPrxAn;
     private GtoAlm gtoAlmByGtoAlmHId;
     private GtoDeu gtoDeuByGtoDeuHId;
     private VcsViv vcsViv;
     private FreDin freDin;
     private PagRnt pagRnt;
     private SrvInd srvInd;
     private SitAct sitAct;
     private GtoOtr gtoOtrByGtoOtrHId;
     private NumCre numCre;
     private GtoOtr gtoOtrByGtoOtrId;
     private GtoSld gtoSld;
     private Ocp ocp;
     private CliMta cliMta;
     private TipEmp tipEmp;
     private GtoVes gtoVes;
     private VivAct vivAct;
     private BurUso burUso;
     private RelFam relFam;
     private GtoSerViv gtoSerViv;
     private GtoRen gtoRen;
     private GtoPer gtoPer;
     private String cliGolSitPor;
     private String cliGolDeuPre;
     private BigDecimal apyEcoId;
     private String cliGolRelFamOtr;
     private String cliGolRelOtr;
     private String cliGolRelDec;
     private String cliGolMotCas;
     private String cliGolMotCam;
     private BigDecimal cliGolResAct;
     private String cliGolActPor;
     private String cliGolOcuAct;
     private BigDecimal cliGolEmpAct;
     private BigDecimal cliGolEstCli;
     private BigDecimal cliGolEstPad;
     private BigDecimal cliGolEstMad;
     private String cliGolResCri;
     private BigDecimal cliGolNumDep;
     private String cliGolDesIng;
     private String cliGolGasGas;
     private BigDecimal cliGolAnoCre;
     private BigDecimal cliGolMesCre;
     private BigDecimal cliGolPagAno;
     private BigDecimal cliGolPagMes;
     private String dinExtHId;
     private BigDecimal cliGolDinExt;
     private Character cliGolTarCre;
     private BigDecimal cliGolNumTar;
     private Character cliGolTarDeb;
     private Character cliGolCtaChe;
     private Character cliGolCrePer;
     private Character cliGolCreAut;
     private Character cliGolCreHip;
     private Character cliGolSegVid;
     private Character cliGolSegGmm;
     private Character cliGolOtrCre;
     private String cliGolDesCre;
     private String cliGolGasOtr;
     private Double cliGolImpExt;
     private Double cliGolImpRen;
     private Double cliGolParCon;
     private Double cliGolParHij;
     private Double cliGolParPad;
     private Double cliGolParOtr;
     private String cliGolDesAdi;
     private Double cliGolIng;

    public CliGol() {
    }

	
    public CliGol(BigDecimal cliGolId) {
        this.cliGolId = cliGolId;
    }
    public CliGol(BigDecimal cliGolId, ApoPad apoPad, Srv srv, SolCre solCre, IPsi IPsi, ProAnoGto proAnoGto, GtoAlm gtoAlmByGtoAlmId, GtoDeu gtoDeuByGtoDeuId, ApoCon apoCon, GtoLim gtoLim, Mov mov, Pbm pbm, Rel rel, Rol rol, ApoOtr apoOtr, TipCre tipCre, Ptm ptm, ApoHij apoHij, Est est, ActUlt actUlt, VlrViv vlrViv, GtoDiv gtoDiv, CueAbr cueAbr, NivEstPap nivEstPap, GtoEdu gtoEdu, FreRel freRel, Sex sex, NivEst nivEst, NivEstMam nivEstMam, DinExt dinExt, GtoTrn gtoTrn, SitPrxAn sitPrxAn, GtoAlm gtoAlmByGtoAlmHId, GtoDeu gtoDeuByGtoDeuHId, VcsViv vcsViv, FreDin freDin, PagRnt pagRnt, SrvInd srvInd, SitAct sitAct, GtoOtr gtoOtrByGtoOtrHId, NumCre numCre, GtoOtr gtoOtrByGtoOtrId, GtoSld gtoSld, Ocp ocp, CliMta cliMta, TipEmp tipEmp, GtoVes gtoVes, VivAct vivAct, BurUso burUso, RelFam relFam, GtoSerViv gtoSerViv, GtoRen gtoRen, GtoPer gtoPer, String cliGolSitPor, String cliGolDeuPre, BigDecimal apyEcoId, String cliGolRelFamOtr, String cliGolRelOtr, String cliGolRelDec, String cliGolMotCas, String cliGolMotCam, BigDecimal cliGolResAct, String cliGolActPor, String cliGolOcuAct, BigDecimal cliGolEmpAct, BigDecimal cliGolEstCli, BigDecimal cliGolEstPad, BigDecimal cliGolEstMad, String cliGolResCri, BigDecimal cliGolNumDep, String cliGolDesIng, String cliGolGasGas, BigDecimal cliGolAnoCre, BigDecimal cliGolMesCre, BigDecimal cliGolPagAno, BigDecimal cliGolPagMes, String dinExtHId, BigDecimal cliGolDinExt, Character cliGolTarCre, BigDecimal cliGolNumTar, Character cliGolTarDeb, Character cliGolCtaChe, Character cliGolCrePer, Character cliGolCreAut, Character cliGolCreHip, Character cliGolSegVid, Character cliGolSegGmm, Character cliGolOtrCre, String cliGolDesCre, String cliGolGasOtr, Double cliGolImpExt, Double cliGolImpRen, Double cliGolParCon, Double cliGolParHij, Double cliGolParPad, Double cliGolParOtr, String cliGolDesAdi, Double cliGolIng) {
       this.cliGolId = cliGolId;
       this.apoPad = apoPad;
       this.srv = srv;
       this.solCre = solCre;
       this.IPsi = IPsi;
       this.proAnoGto = proAnoGto;
       this.gtoAlmByGtoAlmId = gtoAlmByGtoAlmId;
       this.gtoDeuByGtoDeuId = gtoDeuByGtoDeuId;
       this.apoCon = apoCon;
       this.gtoLim = gtoLim;
       this.mov = mov;
       this.pbm = pbm;
       this.rel = rel;
       this.rol = rol;
       this.apoOtr = apoOtr;
       this.tipCre = tipCre;
       this.ptm = ptm;
       this.apoHij = apoHij;
       this.est = est;
       this.actUlt = actUlt;
       this.vlrViv = vlrViv;
       this.gtoDiv = gtoDiv;
       this.cueAbr = cueAbr;
       this.nivEstPap = nivEstPap;
       this.gtoEdu = gtoEdu;
       this.freRel = freRel;
       this.sex = sex;
       this.nivEst = nivEst;
       this.nivEstMam = nivEstMam;
       this.dinExt = dinExt;
       this.gtoTrn = gtoTrn;
       this.sitPrxAn = sitPrxAn;
       this.gtoAlmByGtoAlmHId = gtoAlmByGtoAlmHId;
       this.gtoDeuByGtoDeuHId = gtoDeuByGtoDeuHId;
       this.vcsViv = vcsViv;
       this.freDin = freDin;
       this.pagRnt = pagRnt;
       this.srvInd = srvInd;
       this.sitAct = sitAct;
       this.gtoOtrByGtoOtrHId = gtoOtrByGtoOtrHId;
       this.numCre = numCre;
       this.gtoOtrByGtoOtrId = gtoOtrByGtoOtrId;
       this.gtoSld = gtoSld;
       this.ocp = ocp;
       this.cliMta = cliMta;
       this.tipEmp = tipEmp;
       this.gtoVes = gtoVes;
       this.vivAct = vivAct;
       this.burUso = burUso;
       this.relFam = relFam;
       this.gtoSerViv = gtoSerViv;
       this.gtoRen = gtoRen;
       this.gtoPer = gtoPer;
       this.cliGolSitPor = cliGolSitPor;
       this.cliGolDeuPre = cliGolDeuPre;
       this.apyEcoId = apyEcoId;
       this.cliGolRelFamOtr = cliGolRelFamOtr;
       this.cliGolRelOtr = cliGolRelOtr;
       this.cliGolRelDec = cliGolRelDec;
       this.cliGolMotCas = cliGolMotCas;
       this.cliGolMotCam = cliGolMotCam;
       this.cliGolResAct = cliGolResAct;
       this.cliGolActPor = cliGolActPor;
       this.cliGolOcuAct = cliGolOcuAct;
       this.cliGolEmpAct = cliGolEmpAct;
       this.cliGolEstCli = cliGolEstCli;
       this.cliGolEstPad = cliGolEstPad;
       this.cliGolEstMad = cliGolEstMad;
       this.cliGolResCri = cliGolResCri;
       this.cliGolNumDep = cliGolNumDep;
       this.cliGolDesIng = cliGolDesIng;
       this.cliGolGasGas = cliGolGasGas;
       this.cliGolAnoCre = cliGolAnoCre;
       this.cliGolMesCre = cliGolMesCre;
       this.cliGolPagAno = cliGolPagAno;
       this.cliGolPagMes = cliGolPagMes;
       this.dinExtHId = dinExtHId;
       this.cliGolDinExt = cliGolDinExt;
       this.cliGolTarCre = cliGolTarCre;
       this.cliGolNumTar = cliGolNumTar;
       this.cliGolTarDeb = cliGolTarDeb;
       this.cliGolCtaChe = cliGolCtaChe;
       this.cliGolCrePer = cliGolCrePer;
       this.cliGolCreAut = cliGolCreAut;
       this.cliGolCreHip = cliGolCreHip;
       this.cliGolSegVid = cliGolSegVid;
       this.cliGolSegGmm = cliGolSegGmm;
       this.cliGolOtrCre = cliGolOtrCre;
       this.cliGolDesCre = cliGolDesCre;
       this.cliGolGasOtr = cliGolGasOtr;
       this.cliGolImpExt = cliGolImpExt;
       this.cliGolImpRen = cliGolImpRen;
       this.cliGolParCon = cliGolParCon;
       this.cliGolParHij = cliGolParHij;
       this.cliGolParPad = cliGolParPad;
       this.cliGolParOtr = cliGolParOtr;
       this.cliGolDesAdi = cliGolDesAdi;
       this.cliGolIng = cliGolIng;
    }
   
    public BigDecimal getCliGolId() {
        return this.cliGolId;
    }
    
    public void setCliGolId(BigDecimal cliGolId) {
        this.cliGolId = cliGolId;
    }
    public ApoPad getApoPad() {
        return this.apoPad;
    }
    
    public void setApoPad(ApoPad apoPad) {
        this.apoPad = apoPad;
    }
    public Srv getSrv() {
        return this.srv;
    }
    
    public void setSrv(Srv srv) {
        this.srv = srv;
    }
    public SolCre getSolCre() {
        return this.solCre;
    }
    
    public void setSolCre(SolCre solCre) {
        this.solCre = solCre;
    }
    public IPsi getIPsi() {
        return this.IPsi;
    }
    
    public void setIPsi(IPsi IPsi) {
        this.IPsi = IPsi;
    }
    public ProAnoGto getProAnoGto() {
        return this.proAnoGto;
    }
    
    public void setProAnoGto(ProAnoGto proAnoGto) {
        this.proAnoGto = proAnoGto;
    }
    public GtoAlm getGtoAlmByGtoAlmId() {
        return this.gtoAlmByGtoAlmId;
    }
    
    public void setGtoAlmByGtoAlmId(GtoAlm gtoAlmByGtoAlmId) {
        this.gtoAlmByGtoAlmId = gtoAlmByGtoAlmId;
    }
    public GtoDeu getGtoDeuByGtoDeuId() {
        return this.gtoDeuByGtoDeuId;
    }
    
    public void setGtoDeuByGtoDeuId(GtoDeu gtoDeuByGtoDeuId) {
        this.gtoDeuByGtoDeuId = gtoDeuByGtoDeuId;
    }
    public ApoCon getApoCon() {
        return this.apoCon;
    }
    
    public void setApoCon(ApoCon apoCon) {
        this.apoCon = apoCon;
    }
    public GtoLim getGtoLim() {
        return this.gtoLim;
    }
    
    public void setGtoLim(GtoLim gtoLim) {
        this.gtoLim = gtoLim;
    }
    public Mov getMov() {
        return this.mov;
    }
    
    public void setMov(Mov mov) {
        this.mov = mov;
    }
    public Pbm getPbm() {
        return this.pbm;
    }
    
    public void setPbm(Pbm pbm) {
        this.pbm = pbm;
    }
    public Rel getRel() {
        return this.rel;
    }
    
    public void setRel(Rel rel) {
        this.rel = rel;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public ApoOtr getApoOtr() {
        return this.apoOtr;
    }
    
    public void setApoOtr(ApoOtr apoOtr) {
        this.apoOtr = apoOtr;
    }
    public TipCre getTipCre() {
        return this.tipCre;
    }
    
    public void setTipCre(TipCre tipCre) {
        this.tipCre = tipCre;
    }
    public Ptm getPtm() {
        return this.ptm;
    }
    
    public void setPtm(Ptm ptm) {
        this.ptm = ptm;
    }
    public ApoHij getApoHij() {
        return this.apoHij;
    }
    
    public void setApoHij(ApoHij apoHij) {
        this.apoHij = apoHij;
    }
    public Est getEst() {
        return this.est;
    }
    
    public void setEst(Est est) {
        this.est = est;
    }
    public ActUlt getActUlt() {
        return this.actUlt;
    }
    
    public void setActUlt(ActUlt actUlt) {
        this.actUlt = actUlt;
    }
    public VlrViv getVlrViv() {
        return this.vlrViv;
    }
    
    public void setVlrViv(VlrViv vlrViv) {
        this.vlrViv = vlrViv;
    }
    public GtoDiv getGtoDiv() {
        return this.gtoDiv;
    }
    
    public void setGtoDiv(GtoDiv gtoDiv) {
        this.gtoDiv = gtoDiv;
    }
    public CueAbr getCueAbr() {
        return this.cueAbr;
    }
    
    public void setCueAbr(CueAbr cueAbr) {
        this.cueAbr = cueAbr;
    }
    public NivEstPap getNivEstPap() {
        return this.nivEstPap;
    }
    
    public void setNivEstPap(NivEstPap nivEstPap) {
        this.nivEstPap = nivEstPap;
    }
    public GtoEdu getGtoEdu() {
        return this.gtoEdu;
    }
    
    public void setGtoEdu(GtoEdu gtoEdu) {
        this.gtoEdu = gtoEdu;
    }
    public FreRel getFreRel() {
        return this.freRel;
    }
    
    public void setFreRel(FreRel freRel) {
        this.freRel = freRel;
    }
    public Sex getSex() {
        return this.sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public NivEst getNivEst() {
        return this.nivEst;
    }
    
    public void setNivEst(NivEst nivEst) {
        this.nivEst = nivEst;
    }
    public NivEstMam getNivEstMam() {
        return this.nivEstMam;
    }
    
    public void setNivEstMam(NivEstMam nivEstMam) {
        this.nivEstMam = nivEstMam;
    }
    public DinExt getDinExt() {
        return this.dinExt;
    }
    
    public void setDinExt(DinExt dinExt) {
        this.dinExt = dinExt;
    }
    public GtoTrn getGtoTrn() {
        return this.gtoTrn;
    }
    
    public void setGtoTrn(GtoTrn gtoTrn) {
        this.gtoTrn = gtoTrn;
    }
    public SitPrxAn getSitPrxAn() {
        return this.sitPrxAn;
    }
    
    public void setSitPrxAn(SitPrxAn sitPrxAn) {
        this.sitPrxAn = sitPrxAn;
    }
    public GtoAlm getGtoAlmByGtoAlmHId() {
        return this.gtoAlmByGtoAlmHId;
    }
    
    public void setGtoAlmByGtoAlmHId(GtoAlm gtoAlmByGtoAlmHId) {
        this.gtoAlmByGtoAlmHId = gtoAlmByGtoAlmHId;
    }
    public GtoDeu getGtoDeuByGtoDeuHId() {
        return this.gtoDeuByGtoDeuHId;
    }
    
    public void setGtoDeuByGtoDeuHId(GtoDeu gtoDeuByGtoDeuHId) {
        this.gtoDeuByGtoDeuHId = gtoDeuByGtoDeuHId;
    }
    public VcsViv getVcsViv() {
        return this.vcsViv;
    }
    
    public void setVcsViv(VcsViv vcsViv) {
        this.vcsViv = vcsViv;
    }
    public FreDin getFreDin() {
        return this.freDin;
    }
    
    public void setFreDin(FreDin freDin) {
        this.freDin = freDin;
    }
    public PagRnt getPagRnt() {
        return this.pagRnt;
    }
    
    public void setPagRnt(PagRnt pagRnt) {
        this.pagRnt = pagRnt;
    }
    public SrvInd getSrvInd() {
        return this.srvInd;
    }
    
    public void setSrvInd(SrvInd srvInd) {
        this.srvInd = srvInd;
    }
    public SitAct getSitAct() {
        return this.sitAct;
    }
    
    public void setSitAct(SitAct sitAct) {
        this.sitAct = sitAct;
    }
    public GtoOtr getGtoOtrByGtoOtrHId() {
        return this.gtoOtrByGtoOtrHId;
    }
    
    public void setGtoOtrByGtoOtrHId(GtoOtr gtoOtrByGtoOtrHId) {
        this.gtoOtrByGtoOtrHId = gtoOtrByGtoOtrHId;
    }
    public NumCre getNumCre() {
        return this.numCre;
    }
    
    public void setNumCre(NumCre numCre) {
        this.numCre = numCre;
    }
    public GtoOtr getGtoOtrByGtoOtrId() {
        return this.gtoOtrByGtoOtrId;
    }
    
    public void setGtoOtrByGtoOtrId(GtoOtr gtoOtrByGtoOtrId) {
        this.gtoOtrByGtoOtrId = gtoOtrByGtoOtrId;
    }
    public GtoSld getGtoSld() {
        return this.gtoSld;
    }
    
    public void setGtoSld(GtoSld gtoSld) {
        this.gtoSld = gtoSld;
    }
    public Ocp getOcp() {
        return this.ocp;
    }
    
    public void setOcp(Ocp ocp) {
        this.ocp = ocp;
    }
    public CliMta getCliMta() {
        return this.cliMta;
    }
    
    public void setCliMta(CliMta cliMta) {
        this.cliMta = cliMta;
    }
    public TipEmp getTipEmp() {
        return this.tipEmp;
    }
    
    public void setTipEmp(TipEmp tipEmp) {
        this.tipEmp = tipEmp;
    }
    public GtoVes getGtoVes() {
        return this.gtoVes;
    }
    
    public void setGtoVes(GtoVes gtoVes) {
        this.gtoVes = gtoVes;
    }
    public VivAct getVivAct() {
        return this.vivAct;
    }
    
    public void setVivAct(VivAct vivAct) {
        this.vivAct = vivAct;
    }
    public BurUso getBurUso() {
        return this.burUso;
    }
    
    public void setBurUso(BurUso burUso) {
        this.burUso = burUso;
    }
    public RelFam getRelFam() {
        return this.relFam;
    }
    
    public void setRelFam(RelFam relFam) {
        this.relFam = relFam;
    }
    public GtoSerViv getGtoSerViv() {
        return this.gtoSerViv;
    }
    
    public void setGtoSerViv(GtoSerViv gtoSerViv) {
        this.gtoSerViv = gtoSerViv;
    }
    public GtoRen getGtoRen() {
        return this.gtoRen;
    }
    
    public void setGtoRen(GtoRen gtoRen) {
        this.gtoRen = gtoRen;
    }
    public GtoPer getGtoPer() {
        return this.gtoPer;
    }
    
    public void setGtoPer(GtoPer gtoPer) {
        this.gtoPer = gtoPer;
    }
    public String getCliGolSitPor() {
        return this.cliGolSitPor;
    }
    
    public void setCliGolSitPor(String cliGolSitPor) {
        this.cliGolSitPor = cliGolSitPor;
    }
    public String getCliGolDeuPre() {
        return this.cliGolDeuPre;
    }
    
    public void setCliGolDeuPre(String cliGolDeuPre) {
        this.cliGolDeuPre = cliGolDeuPre;
    }
    public BigDecimal getApyEcoId() {
        return this.apyEcoId;
    }
    
    public void setApyEcoId(BigDecimal apyEcoId) {
        this.apyEcoId = apyEcoId;
    }
    public String getCliGolRelFamOtr() {
        return this.cliGolRelFamOtr;
    }
    
    public void setCliGolRelFamOtr(String cliGolRelFamOtr) {
        this.cliGolRelFamOtr = cliGolRelFamOtr;
    }
    public String getCliGolRelOtr() {
        return this.cliGolRelOtr;
    }
    
    public void setCliGolRelOtr(String cliGolRelOtr) {
        this.cliGolRelOtr = cliGolRelOtr;
    }
    public String getCliGolRelDec() {
        return this.cliGolRelDec;
    }
    
    public void setCliGolRelDec(String cliGolRelDec) {
        this.cliGolRelDec = cliGolRelDec;
    }
    public String getCliGolMotCas() {
        return this.cliGolMotCas;
    }
    
    public void setCliGolMotCas(String cliGolMotCas) {
        this.cliGolMotCas = cliGolMotCas;
    }
    public String getCliGolMotCam() {
        return this.cliGolMotCam;
    }
    
    public void setCliGolMotCam(String cliGolMotCam) {
        this.cliGolMotCam = cliGolMotCam;
    }
    public BigDecimal getCliGolResAct() {
        return this.cliGolResAct;
    }
    
    public void setCliGolResAct(BigDecimal cliGolResAct) {
        this.cliGolResAct = cliGolResAct;
    }
    public String getCliGolActPor() {
        return this.cliGolActPor;
    }
    
    public void setCliGolActPor(String cliGolActPor) {
        this.cliGolActPor = cliGolActPor;
    }
    public String getCliGolOcuAct() {
        return this.cliGolOcuAct;
    }
    
    public void setCliGolOcuAct(String cliGolOcuAct) {
        this.cliGolOcuAct = cliGolOcuAct;
    }
    public BigDecimal getCliGolEmpAct() {
        return this.cliGolEmpAct;
    }
    
    public void setCliGolEmpAct(BigDecimal cliGolEmpAct) {
        this.cliGolEmpAct = cliGolEmpAct;
    }
    public BigDecimal getCliGolEstCli() {
        return this.cliGolEstCli;
    }
    
    public void setCliGolEstCli(BigDecimal cliGolEstCli) {
        this.cliGolEstCli = cliGolEstCli;
    }
    public BigDecimal getCliGolEstPad() {
        return this.cliGolEstPad;
    }
    
    public void setCliGolEstPad(BigDecimal cliGolEstPad) {
        this.cliGolEstPad = cliGolEstPad;
    }
    public BigDecimal getCliGolEstMad() {
        return this.cliGolEstMad;
    }
    
    public void setCliGolEstMad(BigDecimal cliGolEstMad) {
        this.cliGolEstMad = cliGolEstMad;
    }
    public String getCliGolResCri() {
        return this.cliGolResCri;
    }
    
    public void setCliGolResCri(String cliGolResCri) {
        this.cliGolResCri = cliGolResCri;
    }
    public BigDecimal getCliGolNumDep() {
        return this.cliGolNumDep;
    }
    
    public void setCliGolNumDep(BigDecimal cliGolNumDep) {
        this.cliGolNumDep = cliGolNumDep;
    }
    public String getCliGolDesIng() {
        return this.cliGolDesIng;
    }
    
    public void setCliGolDesIng(String cliGolDesIng) {
        this.cliGolDesIng = cliGolDesIng;
    }
    public String getCliGolGasGas() {
        return this.cliGolGasGas;
    }
    
    public void setCliGolGasGas(String cliGolGasGas) {
        this.cliGolGasGas = cliGolGasGas;
    }
    public BigDecimal getCliGolAnoCre() {
        return this.cliGolAnoCre;
    }
    
    public void setCliGolAnoCre(BigDecimal cliGolAnoCre) {
        this.cliGolAnoCre = cliGolAnoCre;
    }
    public BigDecimal getCliGolMesCre() {
        return this.cliGolMesCre;
    }
    
    public void setCliGolMesCre(BigDecimal cliGolMesCre) {
        this.cliGolMesCre = cliGolMesCre;
    }
    public BigDecimal getCliGolPagAno() {
        return this.cliGolPagAno;
    }
    
    public void setCliGolPagAno(BigDecimal cliGolPagAno) {
        this.cliGolPagAno = cliGolPagAno;
    }
    public BigDecimal getCliGolPagMes() {
        return this.cliGolPagMes;
    }
    
    public void setCliGolPagMes(BigDecimal cliGolPagMes) {
        this.cliGolPagMes = cliGolPagMes;
    }
    public String getDinExtHId() {
        return this.dinExtHId;
    }
    
    public void setDinExtHId(String dinExtHId) {
        this.dinExtHId = dinExtHId;
    }
    public BigDecimal getCliGolDinExt() {
        return this.cliGolDinExt;
    }
    
    public void setCliGolDinExt(BigDecimal cliGolDinExt) {
        this.cliGolDinExt = cliGolDinExt;
    }
    public Character getCliGolTarCre() {
        return this.cliGolTarCre;
    }
    
    public void setCliGolTarCre(Character cliGolTarCre) {
        this.cliGolTarCre = cliGolTarCre;
    }
    public BigDecimal getCliGolNumTar() {
        return this.cliGolNumTar;
    }
    
    public void setCliGolNumTar(BigDecimal cliGolNumTar) {
        this.cliGolNumTar = cliGolNumTar;
    }
    public Character getCliGolTarDeb() {
        return this.cliGolTarDeb;
    }
    
    public void setCliGolTarDeb(Character cliGolTarDeb) {
        this.cliGolTarDeb = cliGolTarDeb;
    }
    public Character getCliGolCtaChe() {
        return this.cliGolCtaChe;
    }
    
    public void setCliGolCtaChe(Character cliGolCtaChe) {
        this.cliGolCtaChe = cliGolCtaChe;
    }
    public Character getCliGolCrePer() {
        return this.cliGolCrePer;
    }
    
    public void setCliGolCrePer(Character cliGolCrePer) {
        this.cliGolCrePer = cliGolCrePer;
    }
    public Character getCliGolCreAut() {
        return this.cliGolCreAut;
    }
    
    public void setCliGolCreAut(Character cliGolCreAut) {
        this.cliGolCreAut = cliGolCreAut;
    }
    public Character getCliGolCreHip() {
        return this.cliGolCreHip;
    }
    
    public void setCliGolCreHip(Character cliGolCreHip) {
        this.cliGolCreHip = cliGolCreHip;
    }
    public Character getCliGolSegVid() {
        return this.cliGolSegVid;
    }
    
    public void setCliGolSegVid(Character cliGolSegVid) {
        this.cliGolSegVid = cliGolSegVid;
    }
    public Character getCliGolSegGmm() {
        return this.cliGolSegGmm;
    }
    
    public void setCliGolSegGmm(Character cliGolSegGmm) {
        this.cliGolSegGmm = cliGolSegGmm;
    }
    public Character getCliGolOtrCre() {
        return this.cliGolOtrCre;
    }
    
    public void setCliGolOtrCre(Character cliGolOtrCre) {
        this.cliGolOtrCre = cliGolOtrCre;
    }
    public String getCliGolDesCre() {
        return this.cliGolDesCre;
    }
    
    public void setCliGolDesCre(String cliGolDesCre) {
        this.cliGolDesCre = cliGolDesCre;
    }
    public String getCliGolGasOtr() {
        return this.cliGolGasOtr;
    }
    
    public void setCliGolGasOtr(String cliGolGasOtr) {
        this.cliGolGasOtr = cliGolGasOtr;
    }
    public Double getCliGolImpExt() {
        return this.cliGolImpExt;
    }
    
    public void setCliGolImpExt(Double cliGolImpExt) {
        this.cliGolImpExt = cliGolImpExt;
    }
    public Double getCliGolImpRen() {
        return this.cliGolImpRen;
    }
    
    public void setCliGolImpRen(Double cliGolImpRen) {
        this.cliGolImpRen = cliGolImpRen;
    }
    public Double getCliGolParCon() {
        return this.cliGolParCon;
    }
    
    public void setCliGolParCon(Double cliGolParCon) {
        this.cliGolParCon = cliGolParCon;
    }
    public Double getCliGolParHij() {
        return this.cliGolParHij;
    }
    
    public void setCliGolParHij(Double cliGolParHij) {
        this.cliGolParHij = cliGolParHij;
    }
    public Double getCliGolParPad() {
        return this.cliGolParPad;
    }
    
    public void setCliGolParPad(Double cliGolParPad) {
        this.cliGolParPad = cliGolParPad;
    }
    public Double getCliGolParOtr() {
        return this.cliGolParOtr;
    }
    
    public void setCliGolParOtr(Double cliGolParOtr) {
        this.cliGolParOtr = cliGolParOtr;
    }
    public String getCliGolDesAdi() {
        return this.cliGolDesAdi;
    }
    
    public void setCliGolDesAdi(String cliGolDesAdi) {
        this.cliGolDesAdi = cliGolDesAdi;
    }
    public Double getCliGolIng() {
        return this.cliGolIng;
    }
    
    public void setCliGolIng(Double cliGolIng) {
        this.cliGolIng = cliGolIng;
    }




}

