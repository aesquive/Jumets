/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.utils.valueobject;

import java.util.Date;

/**
 *
 * @author JuCMuro
 */
public class CustomerValueObject {

    private int cliId;
    private int calId;
    private String cliApePat;
    private String cliApeMat;
    private String cliNom;
    private Date cliFecNac;
    private String cliDomCal;
    private String cliDomNumExt;
    private String cliDomNumInt;
    private String cliDomCol;
    private String codPosId;
    private String cliRFC;
    private String cliEdad;

    public Date getCliFecNac() {
        return cliFecNac;
    }

    public void setCliFecNac(Date cliFecNac) {
        this.cliFecNac = cliFecNac;
    }

  public CustomerValueObject(){
      this.resetValues();
  }

    public int getCalId() {
        return calId;
    }

    public void setCalId(int calId) {
        this.calId = calId;
    }

    public String getCliApeMat() {
        return cliApeMat;
    }

    public void setCliApeMat(String cliApeMat) {
        this.cliApeMat = cliApeMat;
    }

    public String getCliApePat() {
        return cliApePat;
    }

    public void setCliApePat(String cliApePat) {
        this.cliApePat = cliApePat;
    }

    public String getCliDomCal() {
        return cliDomCal;
    }

    public void setCliDomCal(String cliDomCal) {
        this.cliDomCal = cliDomCal;
    }

    public String getCliDomCol() {
        return cliDomCol;
    }

    public void setCliDomCol(String cliDomCol) {
        this.cliDomCol = cliDomCol;
    }

    public String getCliDomNumExt() {
        return cliDomNumExt;
    }

    public void setCliDomNumExt(String cliDomNumExt) {
        this.cliDomNumExt = cliDomNumExt;
    }

    public String getCliDomNumInt() {
        return cliDomNumInt;
    }

    public void setCliDomNumInt(String cliDomNumInt) {
        this.cliDomNumInt = cliDomNumInt;
    }



    public String getCliNom() {
        return cliNom;
    }

    public void setCliNom(String cliNom) {
        this.cliNom = cliNom;
    }

    public String getCodPosId() {
        return codPosId;
    }

    public void setCodPosId(String codPosId) {
        this.codPosId = codPosId;
    }

    public String getCliRFC() {
        return cliRFC;
    }

    public void setCliRFC(String cliRFC) {
        this.cliRFC = cliRFC;
    }

    private void resetValues(){
        //TODO SET the default Values
        
    }


    public int getCliId() {
        return cliId;
    }

    public void setCliId(int cliId) {
        this.cliId = cliId;
    }

    public String getCliEdad() {
        return cliEdad;
    }

    public void setCliEdad(String cliEdad) {
        this.cliEdad = cliEdad;
    }

    public String toString(){

        return "\n calId: " + calId + "\n cliApePat: " + cliApePat + "\n cliApeMat: " + cliApeMat
                + "\n cliNom: " + cliNom + "\n cliFecNac:" + cliFecNac + "\n cliDomCal: " + cliDomCal
                + "\n cliDomNumExt: " + cliDomNumExt + "\n cliDomNumInt: " + cliDomNumInt
                +"\n cliDomCol: " + cliDomCol + "\n codPosId: " + codPosId + "\n cliRFC: " + cliRFC
                + "\n cliId: " + cliId + "\n cliEdad: " + cliEdad;
    }

}
