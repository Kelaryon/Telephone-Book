package Agenda;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class Abonat implements Serializable{
    public Abonat(String Nume,String Prenume,NrTel nr,String CNP,Adresa adresa,String detalii){
        numeSet(Nume);
        prenumeSet(Prenume);
        setCNP(CNP);
        this.nr=nr;
        setAdresa(adresa);
        setDetalii(detalii);
        }
   private long CNP;
   private String Nume;
   private String Prenume;
   private NrTel nr;
   private Adresa adresa;
   private String detalii;

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public Adresa getAdresa() {
        return adresa;
    }
   public static void showError(String errorMessage, String title) {
    JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.INFORMATION_MESSAGE);
}  
   public long getCNP() {
        return CNP;
    }
   public String getPrenume() {
        return Prenume;
    }
   public String getNr() {
        return nr.getNumarTelefon();
    }
   public String getNume() {
        return Nume;
    }
   final void numeSet(String Nume){
        if(Nume.length()>3 && verificareNumeFinal(Nume)==true){
        this.Nume=Nume;}
        else{showError("Nume Invalid","Invalid");
            throw new IllegalArgumentException("Nume invalid!");
                }
        
    };
   final void prenumeSet(String Prenume){
        if(Prenume.length()>3 && verificareNumeFinal(Prenume)==true){
        this.Prenume=Prenume;
        }else{showError("Prenume Invalid","Invalid");
            throw new IllegalArgumentException("Prenume invalid");
        }
    };
   final void setCNP(String CNP){
        if(verificareCNP1(CNP)==true){
            if(verificareCNP2(AgendaPrin.getR(),CNP)==true){
                if(CNP.length()==0){this.CNP=-1;
                return;}                
                this.CNP=Long.parseLong(CNP);
            }
            else{showError("CNP Deja existent","Invalid");
            throw new IllegalArgumentException("CNP Deja Existent!");
                
            }
        }else{showError("CNP","Invalid");
            throw new IllegalArgumentException("CNP invalid");
        }
    }
   //Verificare daca numele este introdus corect
   boolean verificareNume(char nume){
        return (nume>64 && nume<91);
    }
   boolean verificareNume(String nume){
        for (int i =1;i<nume.length();i++){
            if(nume.charAt(i)<96 || nume.charAt(i)>123){
                return false;
            }
        }
        return true;
    }
   boolean verificareNumeFinal(String nume){
        return (verificareNume(nume.charAt(0))==true && verificareNume(nume)==true);
    }
   //Verifica daca CNP-ul este introdus corect
   boolean verificareCNP1(String CNP){
        for (int i =1;i<CNP.length();i++){
            if(CNP.charAt(i)<48 && CNP.charAt(i)>57){
                return false;
            }
        }
        return true;
    }
   boolean verificareCNP2(List<Abonat> r,String CNP){
       Long tester;
       if(CNP.length()==0){
           return true;
       }
       for(int i=0;i<r.size();i++){
           tester=r.get(i).getCNP();
           if(tester==Long.parseLong(CNP)){
               return false;
           }
       }
       return true;
   }
   //Comparatori pentru sortari
   public static class Comparators {
    public static final Comparator<Abonat> NUME = (Abonat o1, Abonat o2) -> o1.Nume.compareTo(o2.Nume);
    public static final Comparator<Abonat> PRENUME = (Abonat o1, Abonat o2) -> o1.Prenume.compareTo(o2.Prenume);
    public static final Comparator<Abonat> NUMAR = (Abonat o1, Abonat o2) -> o1.nr.getNumarTelefon().compareTo(o2.nr.getNumarTelefon());
    }

    @Override
    public String toString() {
        return "Abonat{" + "CNP=" + CNP + ", Nume=" + Nume + ", Prenume=" + Prenume + ", nr=" + nr + '}';
    }
   
}