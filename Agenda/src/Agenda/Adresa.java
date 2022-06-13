/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.io.Serializable;

/**
 *
 * @author Alex
 */
public class Adresa implements Serializable {
   private String tara;
   private String oras;
   private String localitate;
   private String adr1;
   private String adr2;

    public Adresa(String tara, String oras, String localitate, String adr1, String adr2) {
        setTara(tara);
        setOras(oras);
        setLocalitate(localitate);
        setAdr1(adr1);
        setAdr2(adr2);
    }

    public String getTara() {
        return tara;
    }

    public String getOras() {
        return oras;
    }

    public String getLocalitate() {
        return localitate;
    }

    public String getAdr1() {
        return adr1;
    }

    public String getAdr2() {
        return adr2;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public void setAdr1(String adr1) {
        this.adr1 = adr1;
    }

    public void setAdr2(String adr2) {
        this.adr2 = adr2;
    }
    
}
