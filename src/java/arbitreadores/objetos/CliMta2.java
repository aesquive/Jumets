package arbitreadores.objetos;
// Generated 13-may-2011 8:17:31 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * CliMta2 generated by hbm2java
 */
public class CliMta2  implements java.io.Serializable {


     private Integer cliMta2Id;
     private Cli cli;
     private Date cliFecNac;
     private Integer cliEdaId;
     private String codPosId;
     private Float cliAntRes;
     private Float cliAntEmp;
     private Integer actExtId;
     private Integer asoParId;
     private Integer banCmpId;
     private Integer banPorPagId;
     private Integer barPorUsoId;
     private Integer opnBarId;
     private Integer burActId;
     private Integer burAntId;
     private Integer burHisId;
     private Integer burPagId;
     private Integer buroUsoId;
     private Integer parPltId;
     private Integer depEcoId;
     private Integer dinExtId;
     private Integer edoCvlId;
     private Integer nivEstId;
     private Character cliIndTarCre;
     private Character cliIndBurCre;
     private Integer ingId;
     private Integer migId;
     private Integer proAnoGtoId;
     private Integer ptmId;
     private Integer relId;
     private Integer rldId;
     private Integer sexId;
     private Integer tipResId;
     private Integer tipEmpId;
     private Integer ocpId;
     private String cliDesOcu;
     private Integer rolId;
     private Integer cliIngMen;
     private Integer desId;
     private Integer edoId;
     private Integer cliValViv;
     private Integer cliValMen;

    public CliMta2() {
    }

    public CliMta2(Cli cli, Date cliFecNac, Integer cliEdaId, String codPosId, Float cliAntRes, Float cliAntEmp, Integer actExtId, Integer asoParId, Integer banCmpId, Integer banPorPagId, Integer barPorUsoId, Integer opnBarId, Integer burActId, Integer burAntId, Integer burHisId, Integer burPagId, Integer buroUsoId, Integer parPltId, Integer depEcoId, Integer dinExtId, Integer edoCvlId, Integer nivEstId, Character cliIndTarCre, Character cliIndBurCre, Integer ingId, Integer migId, Integer proAnoGtoId, Integer ptmId, Integer relId, Integer rldId, Integer sexId, Integer tipResId, Integer tipEmpId, Integer ocpId, String cliDesOcu, Integer rolId, Integer cliIngMen, Integer desId, Integer edoId, Integer cliValViv, Integer cliValMen) {
       this.cli = cli;
       this.cliFecNac = cliFecNac;
       this.cliEdaId = cliEdaId;
       this.codPosId = codPosId;
       this.cliAntRes = cliAntRes;
       this.cliAntEmp = cliAntEmp;
       this.actExtId = actExtId;
       this.asoParId = asoParId;
       this.banCmpId = banCmpId;
       this.banPorPagId = banPorPagId;
       this.barPorUsoId = barPorUsoId;
       this.opnBarId = opnBarId;
       this.burActId = burActId;
       this.burAntId = burAntId;
       this.burHisId = burHisId;
       this.burPagId = burPagId;
       this.buroUsoId = buroUsoId;
       this.parPltId = parPltId;
       this.depEcoId = depEcoId;
       this.dinExtId = dinExtId;
       this.edoCvlId = edoCvlId;
       this.nivEstId = nivEstId;
       this.cliIndTarCre = cliIndTarCre;
       this.cliIndBurCre = cliIndBurCre;
       this.ingId = ingId;
       this.migId = migId;
       this.proAnoGtoId = proAnoGtoId;
       this.ptmId = ptmId;
       this.relId = relId;
       this.rldId = rldId;
       this.sexId = sexId;
       this.tipResId = tipResId;
       this.tipEmpId = tipEmpId;
       this.ocpId = ocpId;
       this.cliDesOcu = cliDesOcu;
       this.rolId = rolId;
       this.cliIngMen = cliIngMen;
       this.desId = desId;
       this.edoId = edoId;
       this.cliValViv = cliValViv;
       this.cliValMen = cliValMen;
    }
   
    public Integer getCliMta2Id() {
        return this.cliMta2Id;
    }
    
    public void setCliMta2Id(Integer cliMta2Id) {
        this.cliMta2Id = cliMta2Id;
    }
    public Cli getCli() {
        return this.cli;
    }
    
    public void setCli(Cli cli) {
        this.cli = cli;
    }
    public Date getCliFecNac() {
        return this.cliFecNac;
    }
    
    public void setCliFecNac(Date cliFecNac) {
        this.cliFecNac = cliFecNac;
    }
    public Integer getCliEdaId() {
        return this.cliEdaId;
    }
    
    public void setCliEdaId(Integer cliEdaId) {
        this.cliEdaId = cliEdaId;
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
    public Integer getActExtId() {
        return this.actExtId;
    }
    
    public void setActExtId(Integer actExtId) {
        this.actExtId = actExtId;
    }
    public Integer getAsoParId() {
        return this.asoParId;
    }
    
    public void setAsoParId(Integer asoParId) {
        this.asoParId = asoParId;
    }
    public Integer getBanCmpId() {
        return this.banCmpId;
    }
    
    public void setBanCmpId(Integer banCmpId) {
        this.banCmpId = banCmpId;
    }
    public Integer getBanPorPagId() {
        return this.banPorPagId;
    }
    
    public void setBanPorPagId(Integer banPorPagId) {
        this.banPorPagId = banPorPagId;
    }
    public Integer getBarPorUsoId() {
        return this.barPorUsoId;
    }
    
    public void setBarPorUsoId(Integer barPorUsoId) {
        this.barPorUsoId = barPorUsoId;
    }
    public Integer getOpnBarId() {
        return this.opnBarId;
    }
    
    public void setOpnBarId(Integer opnBarId) {
        this.opnBarId = opnBarId;
    }
    public Integer getBurActId() {
        return this.burActId;
    }
    
    public void setBurActId(Integer burActId) {
        this.burActId = burActId;
    }
    public Integer getBurAntId() {
        return this.burAntId;
    }
    
    public void setBurAntId(Integer burAntId) {
        this.burAntId = burAntId;
    }
    public Integer getBurHisId() {
        return this.burHisId;
    }
    
    public void setBurHisId(Integer burHisId) {
        this.burHisId = burHisId;
    }
    public Integer getBurPagId() {
        return this.burPagId;
    }
    
    public void setBurPagId(Integer burPagId) {
        this.burPagId = burPagId;
    }
    public Integer getBuroUsoId() {
        return this.buroUsoId;
    }
    
    public void setBuroUsoId(Integer buroUsoId) {
        this.buroUsoId = buroUsoId;
    }
    public Integer getParPltId() {
        return this.parPltId;
    }
    
    public void setParPltId(Integer parPltId) {
        this.parPltId = parPltId;
    }
    public Integer getDepEcoId() {
        return this.depEcoId;
    }
    
    public void setDepEcoId(Integer depEcoId) {
        this.depEcoId = depEcoId;
    }
    public Integer getDinExtId() {
        return this.dinExtId;
    }
    
    public void setDinExtId(Integer dinExtId) {
        this.dinExtId = dinExtId;
    }
    public Integer getEdoCvlId() {
        return this.edoCvlId;
    }
    
    public void setEdoCvlId(Integer edoCvlId) {
        this.edoCvlId = edoCvlId;
    }
    public Integer getNivEstId() {
        return this.nivEstId;
    }
    
    public void setNivEstId(Integer nivEstId) {
        this.nivEstId = nivEstId;
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
    public Integer getIngId() {
        return this.ingId;
    }
    
    public void setIngId(Integer ingId) {
        this.ingId = ingId;
    }
    public Integer getMigId() {
        return this.migId;
    }
    
    public void setMigId(Integer migId) {
        this.migId = migId;
    }
    public Integer getProAnoGtoId() {
        return this.proAnoGtoId;
    }
    
    public void setProAnoGtoId(Integer proAnoGtoId) {
        this.proAnoGtoId = proAnoGtoId;
    }
    public Integer getPtmId() {
        return this.ptmId;
    }
    
    public void setPtmId(Integer ptmId) {
        this.ptmId = ptmId;
    }
    public Integer getRelId() {
        return this.relId;
    }
    
    public void setRelId(Integer relId) {
        this.relId = relId;
    }
    public Integer getRldId() {
        return this.rldId;
    }
    
    public void setRldId(Integer rldId) {
        this.rldId = rldId;
    }
    public Integer getSexId() {
        return this.sexId;
    }
    
    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }
    public Integer getTipResId() {
        return this.tipResId;
    }
    
    public void setTipResId(Integer tipResId) {
        this.tipResId = tipResId;
    }
    public Integer getTipEmpId() {
        return this.tipEmpId;
    }
    
    public void setTipEmpId(Integer tipEmpId) {
        this.tipEmpId = tipEmpId;
    }
    public Integer getOcpId() {
        return this.ocpId;
    }
    
    public void setOcpId(Integer ocpId) {
        this.ocpId = ocpId;
    }
    public String getCliDesOcu() {
        return this.cliDesOcu;
    }
    
    public void setCliDesOcu(String cliDesOcu) {
        this.cliDesOcu = cliDesOcu;
    }
    public Integer getRolId() {
        return this.rolId;
    }
    
    public void setRolId(Integer rolId) {
        this.rolId = rolId;
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
    public Integer getEdoId() {
        return this.edoId;
    }
    
    public void setEdoId(Integer edoId) {
        this.edoId = edoId;
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

