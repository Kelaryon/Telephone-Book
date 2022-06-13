package Agenda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;




public class AgendaPrin {
    public AgendaPrin(File autoload){
        if(autoload!= null){
        if(autoload.exists()&& !autoload.isDirectory()){
    r=incarcare(autoload);}
    }};
    //Modificare autosalvare;
    //metode de adaugare,stergere si modificare de abonati
    public void Sterge(int i){
        r.remove(i);
    };
    public void Modifica(int i,String a,String b,NrTel d,String c,String Tara,String Oras,String Localitate, String Adr1,String Adr2,String detalii){
        r.set(i,new Abonat(a,b,d,c,new Adresa(Tara,Oras,Localitate,Adr1,Adr2),detalii));
    }
    public void Adauga(String a,String b,NrTel d,String c,String Tara,String Oras,String Localitate, String Adr1,String Adr2,String detalii){
        r.add(new Abonat(a,b,d,c,new Adresa(Tara,Oras,Localitate,Adr1,Adr2),detalii));        
    }
    private static List<Abonat> r= new ArrayList<>();
    //setter si getter pentru lista cu abonati
    public void setR(List<Abonat> alpha) {
        r = alpha;
    }
    public static List<Abonat> getR() {
        return r;
    }

    //Metode folosite pentru incarcare salvare si autosalvare
    public File salvare(String a,String b,List<Abonat> r){
        File delta = new File(a,b.concat(".rrt"));
        try{
            FileOutputStream fos = new FileOutputStream(delta);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(r);
        }
        catch(IOException e){
            e.printStackTrace(System.out);
        }
        return delta;
    };
    public void salvare(File save,List<Abonat> r){
        try{
            FileOutputStream fos = new FileOutputStream(save);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(r);
        }
        catch(IOException e){
            e.printStackTrace(System.out);
        }
        
    };
    public List<Abonat> incarcare(File a){
        List <Abonat> ar = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream(a);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ar = (ArrayList) ois.readObject();
        }catch(IOException ioe){
         }catch(ClassNotFoundException c){
             System.out.println("Class not found");
         }
        return ar;
    }
    @Override
    public String toString() {
        return "CarteDeTelefon{" + "r=" + r + '}';
    }
    //setter si getter pentru configurati
    public static String getPropValues(String gama,String beta){
                String result=null;
                Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream(beta)) {
            prop.load(in);
            result = prop.getProperty(gama);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AgendaPrin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AgendaPrin.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
		return result;
	}
    public static void setPropValues(String gama,String alfa,String beta) throws IOException{
                Properties prop = new Properties();
        try (FileOutputStream in = new FileOutputStream(beta)) {
            prop.setProperty(gama,alfa);
            prop.store(in,null);
        }
    }
  
}
