/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.dao.impl;

import com.urbi.utils.valueobject.*;

import com.urbi.dao.interfaces.CustomerMetaDAO;
import com.urbi.util.HibernateUtil2;
import com.urbi.utils.valueobject.ProcessValueObject;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.*;
import objetos.Cli;
import objetos.CliMta2;
import objetos.DinExt;
import objetos.NivEst;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JuCMuro
 */
public class CustomerMetaDAOImpl implements CustomerMetaDAO{

    public ProcessValueObject addCustomerMeta(CustomerMetaValueObject customerMetaVO, Cli cli) {

        ProcessValueObject processVO=new ProcessValueObject();
        Session s=null;
        Transaction tx=null;
         System.out.println("entrando en salvar customer meta");
       

        try{
          //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
          s = HibernateUtil2.currentSession();
          tx = s.beginTransaction();
          tx.begin();
          CliMta2 cliMta2=new CliMta2();

          this.fillCustomerMetaValues(cliMta2, customerMetaVO,cli);

          System.out.println("cliente meta: " + cliMta2);
          s.saveOrUpdate(cliMta2);
          tx.commit();

          System.out.println("Se inserto el cliente meta exitosamente: " + cliMta2.getCliMta2Id());
          processVO.setInfoResult("Object",cliMta2);

        }catch(HibernateException ex){
            tx.rollback();
            processVO.setAddError("HibernateError", ex.getMessage());
        }catch(Exception e){
           processVO.setAddError(ProcessValueObject.genericError, e.getMessage());
           System.out.println("Error: " + e.toString());
           tx.rollback();
        }finally{
          HibernateUtil2.closeSession();
        }
        return processVO;
    }


     public ProcessValueObject actualizaCustomerMeta(CliMta2 cliMta) {

        ProcessValueObject processVO=new ProcessValueObject();
        Session s=null;
        Transaction tx=null;
         System.out.println("entrando en actualizar customer meta");


        try{
          //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
          s = HibernateUtil2.currentSession();
          tx = s.beginTransaction();
          tx.begin();

          System.out.println("cliente meta: " + cliMta.getCliMta2Id());
          s.update(cliMta);
          tx.commit();

          System.out.println("Se actualizo el cliente meta exitosamente: " + cliMta.getCliMta2Id());
          processVO.setInfoResult("Object",cliMta);

        }catch(HibernateException ex){
            tx.rollback();
            processVO.setAddError("HibernateError", ex.getMessage());
        }catch(Exception e){
           processVO.setAddError(ProcessValueObject.genericError, e.getMessage());
           System.out.println("Error: " + e.getMessage());
           tx.rollback();
        }finally{
          HibernateUtil2.closeSession();
        }
        return processVO;
    }

    private void fillCustomerMetaValues(CliMta2 customerMeta, CustomerMetaValueObject customerMetaVO, Cli cli) throws ParseException{

        SimpleDateFormat format =
            new SimpleDateFormat("dd/mm/yyyy");

        if(customerMetaVO.getCLI_MTA_ID() != 0)customerMeta.setCliMta2Id(customerMetaVO.getCLI_MTA_ID());
        if(customerMetaVO.getACT_EXT_ID() != 0) customerMeta.setActExtId(customerMetaVO.getACT_EXT_ID());
        if(customerMetaVO.getASO_PAR_ID() != 0) customerMeta.setAsoParId(customerMetaVO.getASO_PAR_ID());
        if(customerMetaVO.getBAN_CMP_ID() != 0)customerMeta.setBanCmpId(customerMetaVO.getBAN_CMP_ID());
        if(customerMetaVO.getBAN_POR_PAG_ID() != 0)customerMeta.setBanPorPagId(customerMetaVO.getBAN_POR_PAG_ID());
        if(customerMetaVO.getBAR_POR_USO_ID() != 0)customerMeta.setBanPorUsoId(customerMetaVO.getBAR_POR_USO_ID());
        if(customerMetaVO.getBUR_ACT_ID() != 0)customerMeta.setBurActId(customerMetaVO.getBUR_ACT_ID());
        if(customerMetaVO.getBUR_ANT_ID() != 0)customerMeta.setBurAntId(customerMetaVO.getBUR_ANT_ID());
        if(customerMetaVO.getBUR_HIS_ID() != 0)customerMeta.setBurHisId(customerMetaVO.getBUR_HIS_ID());
        if(customerMetaVO.getBUR_PAG_ID() != 0)customerMeta.setBurPagId(customerMetaVO.getBUR_PAG_ID());
        if(customerMetaVO.getBURO_USO_ID() != 0)customerMeta.setBurUsoId(customerMetaVO.getBURO_USO_ID());
        //if(customerMetaVO.getCAL_ID() != 0)customerMeta.setCalId(customerMetaVO.getCAL_ID());
        
        if(cli != null)customerMeta.setCli(cli);
        System.out.println("cliente: " + customerMeta.getCli().getCliId());
        
        if(customerMetaVO.getCLI_ANT_EMP() != 0)customerMeta.setCliAntEmp(customerMetaVO.getCLI_ANT_EMP());
        if(customerMetaVO.getCLI_ANT_RES() != 0)customerMeta.setCliAntRes(customerMetaVO.getCLI_ANT_RES());
        if(customerMetaVO.getCLI_DES_OCU() != null)customerMeta.setCliDesOcu(customerMetaVO.getCLI_DES_OCU());
        if(customerMetaVO.getCLI_FEC_NAC() != null)customerMeta.setCliFecNac(format.parse(customerMetaVO.getCLI_FEC_NAC()));
        if(customerMetaVO.getCLI_IND_BUR_CRE() != false)customerMeta.setCliIndBurCre(customerMetaVO.getCLI_IND_BUR_CRE());
        if(customerMetaVO.getCLI_IND_TAR_CRE() != false)customerMeta.setCliIndTarCre(customerMetaVO.getCLI_IND_TAR_CRE());
        if(customerMetaVO.getCLI_ING_MEN() != 0)customerMeta.setCliIngMen(customerMetaVO.getCLI_ING_MEN());
        if(customerMetaVO.getCLI_VAL_MEN() != 0)customerMeta.setCliValMen(customerMetaVO.getCLI_VAL_MEN());
        if(customerMetaVO.getCLI_VAL_VIV() != 0)customerMeta.setCliValViv(customerMetaVO.getCLI_VAL_VIV());
        if(customerMetaVO.getCOD_POS_ID() != null)customerMeta.setCodPosId(customerMetaVO.getCOD_POS_ID());
        if(customerMetaVO.getDEP_ECO_ID() != 0)customerMeta.setDepEcoId(customerMetaVO.getDEP_ECO_ID());
        if(customerMetaVO.getDES_ID() != 0)customerMeta.setDesId(customerMetaVO.getDES_ID());
        if(customerMetaVO.getDIN_EXT_ID() != 0)customerMeta.setDinExtId(customerMetaVO.getDIN_EXT_ID());
        //customerMeta.setEdaId(customerMetaVO.getEDO_ID());
        if(customerMetaVO.getEDO_CVL_ID() != 0)customerMeta.setEdoCvlId(customerMetaVO.getEDO_CVL_ID());
        if(customerMetaVO.getEDO_ID() != 0)customerMeta.setEdoId(customerMetaVO.getEDO_ID());
        //if(customerMetaVO.getGPO_ID() != 0)customerMeta.setGpoId(customerMetaVO.getGPO_ID());
        if(customerMetaVO.getING_ID() != 0)customerMeta.setIngId(customerMetaVO.getING_ID());
        if(customerMetaVO.getMIG_ID() != 0)customerMeta.setMigId(customerMetaVO.getMIG_ID());
        if(customerMetaVO.getNIV_EST_ID() != 0)customerMeta.setNivEstId(customerMetaVO.getNIV_EST_ID());
        if(customerMetaVO.getOCP_ID() != 0)customerMeta.setOcpId(customerMetaVO.getOCP_ID());
        if(customerMetaVO.getOPN_BAR_ID() != 0)customerMeta.setOpnBarId(customerMetaVO.getOPN_BAR_ID());
        if(customerMetaVO.getPAR_PLT_ID() != 0)customerMeta.setParPltId(customerMetaVO.getPAR_PLT_ID());
        //customerMeta.setProAnoGtIdo(customerMetaVO.getPRO_ANO_GTO_ID());
        if(customerMetaVO.getPRO_ANO_GTO_ID() != 0)customerMeta.setProAnoGtoId(customerMetaVO.getPRO_ANO_GTO_ID());
        if(customerMetaVO.getPTM_ID() != 0)customerMeta.setPtmId(customerMetaVO.getPTM_ID());
        if(customerMetaVO.getREL_ID()!= 0)customerMeta.setRelId(customerMetaVO.getREL_ID());
        if(customerMetaVO.getRLD_ID() != 0)customerMeta.setRldId(customerMetaVO.getRLD_ID());
        if(customerMetaVO.getROL_ID() != 0)customerMeta.setRolId(customerMetaVO.getROL_ID());
        if(customerMetaVO.getSEX_ID() != 0)customerMeta.setSexId(customerMetaVO.getSEX_ID());
        if(customerMetaVO.getTIP_EMP_ID() != 0)customerMeta.setTipEmpId(customerMetaVO.getTIP_EMP_ID());
        if(customerMetaVO.getTIP_RES_ID() != 0)customerMeta.setTipResId(customerMetaVO.getTIP_RES_ID());
        if(customerMetaVO.getCLI_EDA_ID() != 0)customerMeta.setEdaId(customerMetaVO.getCLI_EDA_ID());


        System.out.println("customer meta cargado: " + customerMeta.toString());
    }


    private void fillCustomerMetaValues(CliMta customerMeta, CustomerMetaValueObject customeMetarVO, Session s){

        /*private int cliMtaId;
     private Cli cli;
     private NivEst nivEst;
    
     private DinExt dinExt;
   */


/*        Cli cli = (Cli) s.get( Cli.class, new Integer( customeMetarVO.getCLI_ID()));
        customerMeta.setCli(cli);

        NivEst nv=(NivEst) s.get(NivEst.class,new Integer(customeMetarVO.getNIV_EST_ID()));
        customerMeta.setNivEst(nv);
        
        DinExt dinExt = (DinExt) s.get(DinExt.class, new Integer(customeMetarVO.getDIN_EXT_ID()) );
        customerMeta.setDinExt(dinExt);

        //private Cal cal;
        Cal cal = (Cal) s.get(Cal.class, new Integer(customeMetarVO.getCAL_ID()));
        customerMeta.setCal(cal);

         //private ProAnoGto proAnoGto;

        ProAnoGto proAnoGto = (ProAnoGto) s.get(ProAnoGto.class, new Integer(customeMetarVO.getPRO_ANO_GTO_ID()));
        customerMeta.setProAnoGto(proAnoGto);

         BanPorUso banPorUso = (BanPorUso) s.get(BanPorUso.class, new Integer (customeMetarVO.getBAR_POR_USO_ID()));
         customerMeta.setBanPorUso(banPorUso);


         BurUso burUso = (BurUso) s.get(BurUso.class, new Integer (customeMetarVO.getBAR_POR_USO_ID()));
         customerMeta.setBurUso(burUso);

         DepEco depEco = (DepEco) s.get(DepEco.class, new Integer (customeMetarVO.getDEP_ECO_ID()));
         customerMeta.setDepEco(depEco);

          Mig mig = (Mig) s.get(Mig.class, new Integer(customeMetarVO.getMIG_ID()));
          customerMeta.setMig(mig);

         Edo edo = (Edo) s.get(Edo.class, new Integer(customeMetarVO.getEDO_ID()));
         customerMeta.setEdo(edo);

         TipRes tipRes = (TipRes) s.get(TipRes.class, new Integer(customeMetarVO.getTIP_RES_ID()));
         customerMeta.setTipRes(tipRes);

         OpnBar opnBar = (OpnBar) s.get(OpnBar.class, new Integer(customeMetarVO.getOPN_BAR_ID()));
         customerMeta.setOpnBar(opnBar);

         Rol rol = (Rol) s.get(Rol.class, new Integer(customeMetarVO.getROL_ID()));
         customerMeta.setRol(rol);

         Rel rel = (Rel) s.get(Rel.class, new Integer( customeMetarVO.getREL_ID()));
         customerMeta.setRol(rol);

         Eda eda = (Eda) s.get(Eda.class, new Integer (customeMetarVO.getCLI_EDA_ID()));
         customerMeta.setEda(eda);

         BurAct burAct = (BurAct) s.get(BurAct.class, new Integer (customeMetarVO.getBUR_ACT_ID()));
         customerMeta.setBurAct(burAct);

         Ocp ocp = (Ocp) s.get(Ocp.class, new Integer (customeMetarVO.getOCP_ID()));
         customerMeta.setOcp(ocp);

          TipEmp tipEmp = (TipEmp) s.get(TipEmp.class, new Integer ( customeMetarVO.getTIP_EMP_ID()));
          customerMeta.setTipEmp(tipEmp);

         BurHis burHis = (BurHis) s.get(BurHis.class, new Integer (customeMetarVO.getBUR_HIS_ID()));
         customerMeta.setBurHis(burHis);

         Ptm ptm = (Ptm) s.get( Ptm.class, new Integer (customeMetarVO.getPTM_ID()));
         customerMeta.setPtm(ptm);

         BurAnt burAnt = (BurAnt) s.get(BurAnt.class, new Integer (customeMetarVO.getBUR_ANT_ID()) );
         customerMeta.setBurAnt(burAnt);

         ParPlt parPlt = (ParPlt) s.get(ParPlt.class, new Integer (customeMetarVO.getPAR_PLT_ID()));
         customerMeta.setParPlt(parPlt);

         BurPag burPag = (BurPag) s.get(BurPag.class, new Integer (customeMetarVO.getBUR_PAG_ID()));
         customerMeta.setBurPag(burPag);

         Gpo gpo = (Gpo) s.get (Gpo.class, new Integer (customeMetarVO.getGPO_ID()));
                 customerMeta.setGpo(gpo);

         Rld rld = (Rld) s.get(Rld.class, new Integer (customeMetarVO.getRLD_ID()));
         customerMeta.setRld(rld);

         AsoPar asoPar = (AsoPar) s.get(AsoPar.class, new Integer (customeMetarVO.getASO_PAR_ID()));
         customerMeta.setAsoPar(asoPar);

         ActExt actExt = (ActExt) s.get(ActExt.class, new Integer (customeMetarVO.getACT_EXT_ID()));
         customerMeta.setActExt(actExt);

         EdoCvl edoCvl = (EdoCvl) s.get(EdoCvl.class, new Integer (customeMetarVO.getEDO_CVL_ID()));
         customerMeta.setEdoCvl(edoCvl);

         Ing ing = (Ing) s.get(Ing.class, new Integer (customeMetarVO.getING_ID()));
         customerMeta.setIng(ing);

         BanPorPag banPorPag = (BanPorPag) s.get(BanPorPag.class, new Integer(customeMetarVO.getBAN_POR_PAG_ID()));
         customerMeta.setBanPorPag(banPorPag);

         Sex sex = (Sex) s.get(Sex.class, new Integer (customeMetarVO.getSEX_ID()));
         customerMeta.setSex(sex);
         
         Date cliFecNac = (Date) s.get(Date.class, new Integer( customeMetarVO.getCLI_FEC_NAC()));
         customerMeta.setCliFecNac(cliFecNac);

         Integer codPosId = (Integer) s.get(Integer.class, new Integer (customeMetarVO.getCOD_POS_ID()));

    */     //customerMeta.setCodPosId(cliDesOcu);


         


           // to fix
/*
         private Double cliAntRes;
         private Double cliAntEmp;
         private int banCmpId;

         private Character cliIndTarCre;

         private Character cliIndBurCre;

         private String cliDesOcu;
         private int cliIngMen;
         private int desId;
         private int cliValViv;
         private int cliValMen;

         private Set<CliBur> cliBurs = new HashSet<CliBur>(0);
         private Set<CliGol> cliGols = new HashSet<CliGol>(0);

*/





 //       customerMeta.setActExt(customeMetarVO.getACT_EXT_ID())


//customeMetarVO.get

      //  customeMetarVO.set
        /*

        "CLI_MTA_ID" NUMBER NOT NULL ENABLE,
	"CLI_ID" NUMBER,
	"GPO_ID" NUMBER,
	"CAL_ID" NUMBER,
	"CLI_FEC_NAC" DATE,
	"CLI_EDA_ID" NUMBER,
	"COD_POS_ID" VARCHAR2(5 BYTE),
	"CLI_ANT_RES" FLOAT(126),
	"CLI_ANT_EMP" FLOAT(126),
	"ACT_EXT_ID" NUMBER,
	"ASO_PAR_ID" NUMBER,
	"BAN_CMP_ID" NUMBER,
	"BAN_POR_PAG_ID" NUMBER,
	"BAR_POR_USO_ID" NUMBER,
	"OPN_BAR_ID" NUMBER,
	"BUR_ACT_ID" NUMBER,
	"BUR_ANT_ID" NUMBER,
	"BUR_HIS_ID" NUMBER,
	"BUR_PAG_ID" NUMBER,
	"BURO_USO_ID" NUMBER,
	"PAR_PLT_ID" NUMBER,
	"DEP_ECO_ID" NUMBER,
	"DIN_EXT_ID" NUMBER,
	"EDO_CVL_ID" NUMBER,
	"NIV_EST_ID" NUMBER,
	"CLI_IND_TAR_CRE" CHAR(1 BYTE),
	"CLI_IND_BUR_CRE" CHAR(1 BYTE),
	"ING_ID" NUMBER,
	"MIG_ID" NUMBER,
	"PRO_ANO_GTO_ID" NUMBER,
	"PTM_ID" NUMBER,
	"REL_ID" NUMBER,
	"RLD_ID" NUMBER,
	"SEX_ID" NUMBER,
	"TIP_RES_ID" NUMBER,
	"TIP_EMP_ID" NUMBER,
	"OCP_ID" NUMBER,
	"CLI_DES_OCU" VARCHAR2(100 BYTE),
	"ROL_ID" NUMBER,
	"CLI_ING_MEN" NUMBER,
	"DES_ID" NUMBER,
	"EDO_ID" NUMBER,
	"CLI_VAL_VIV" NUMBER,
	"CLI_VAL_MEN" NUMBER,
         */

        /*
        customer.setCalId(customeMetarVO.getCalId());
        customer.setCliApeMat(customeMetarVO.getCliApeMat());
        customer.setCliApePat(customeMetarVO.getCliApePat());
        customer.setCliDomCal(customeMetarVO.getCliDomCal());
        customer.setCliDomCol(customeMetarVO.getCliDomCol());
        customer.setCliDomNumExt(customeMetarVO.getCliDomNumExt());
        customer.setCliDomNumInt(customeMetarVO.getCliDomNumInt());
        customer.setCliFecNac(customeMetarVO.getCliFecNac());
        customer.setCliNom(customeMetarVO.getCliNom());
        customer.setCodPosId(customeMetarVO.getCodPosId());
*/


        //customer.setCliRFC(customerVO.getCliRFC());

    }


    public CliMta2 getCustomerMetaByID(int IdCustomer) {
          Session s=null;
        Transaction tx=null;
        CliMta2 customer=null;

        try{
          //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
          s = HibernateUtil2.currentSession();
          tx = s.beginTransaction();

          customer = (CliMta2) s.createQuery("from CliMta2 c where c.cli.cliId=" + IdCustomer).uniqueResult();

          if(customer == null){
            customer = new CliMta2();
          }

        }catch(HibernateException ex){
            tx.rollback();
            //processVO.setAddError("HibernateError", ex.getMessage());
        }catch(Exception e){
           //processVO.setAddError(ProcessValueObject.genericError, e.getMessage());
            tx.rollback();
        }finally{
            HibernateUtil2.closeSession();
        }

        return customer;
    }

    public List obtieneSectores(int tipoActividad) {
        Session s = null;
        Transaction tx = null;
        List<Srv> q = null;
        try{
           //Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
           s = HibernateUtil2.currentSession();
           tx  = s.beginTransaction();
           q = (List<Srv>) s.createQuery("from Srv as s where s.calId=6 and s.tipEmpId=" + tipoActividad).list();

       }catch(HibernateException ex){
            ex.printStackTrace();
        }catch(Exception e){
           e.printStackTrace();
        }finally{
            HibernateUtil2.closeSession();
        }

       return q;
    }

    public List obtineSubsectores(int sector) {
        Session s = null;
        Transaction tx = null;
        List<Ocp> q = null;
        try{
           //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
           s = HibernateUtil2.currentSession();
           s.beginTransaction();
           q = (List<Ocp>) s.createQuery("from Ocp as o where o.cal.calId=6 and o.srvId=" + sector).list();

       }catch(HibernateException ex){
            ex.printStackTrace();
        }catch(Exception e){
           e.printStackTrace();
        }finally{
            HibernateUtil2.closeSession();
        }

       return q;
    }

    public List obtenerDesarollosXEdo( int estado) {
        Session s = null;
        Transaction tx = null;
        List<Des> q = null;
        try{
           //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
           s = HibernateUtil2.currentSession();
           tx = s.beginTransaction();
           q = (List<Des>) s.createQuery("from Des as d where d.cal.calId=6 and d.edo.edoId=" + estado).list();

           //System.out.println("datos: " + q.get(0).getDesDes());
       }catch(HibernateException ex){
            ex.printStackTrace();
        }catch(Exception e){
           e.printStackTrace();
        }finally{
            HibernateUtil2.closeSession();
        }

       return q;
    }

}
