package Agenda;

import static Agenda.Abonat.showError;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
 public class NrTel implements Serializable{
    private String numarTelefon;
    private byte alfa;
    public NrTel(String numar) {
        setNumar(numar);
    }

    public void setNumar(String numar1) {
        if(numar1.length()==10 && validarenumar(numar1.charAt(0))){
            if(tipnumar(numar1)==true){
                this.alfa=1;//Mobil
            }
            else{
                this.alfa=2;//Fix
            }
            numarTelefon=numar1;
        }
        else{showError("Numar Invalid","Invalid");
            throw new IllegalArgumentException("Numar invalid!");}
}

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public byte getAlfa() {
        return alfa;
    }

    boolean validarenumar(char a){
        return ((a-'0')==0);
    }
    boolean tipnumar(String numar1){
        String anum=numar1.substring(1, 2);
        int a=Integer.parseInt(anum);
        return (a>71 && a<79);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
 }