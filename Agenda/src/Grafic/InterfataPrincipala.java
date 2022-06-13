/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafic;

import Agenda.Abonat;
import Agenda.Abonat.Comparators;
import Agenda.AgendaPrin;
import static Agenda.AgendaPrin.getPropValues;
import static Agenda.AgendaPrin.getR;
import static Agenda.AgendaPrin.setPropValues;
import Agenda.NrTel;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Alex
 */
public class InterfataPrincipala extends javax.swing.JFrame {

    /**
     * Creates new form InterfataPrincipala
     */
    File autoload_save;
    AgendaPrin a=new AgendaPrin(autoload_save);
    Abonat p;
    int select=0;
    String[] ptPoze ={"src/Poze/Poza1.jpg","src/Poze/Poza2.jpg","src/Poze/Poza3.jpg","src/Poze/Poza4.jpg","src/Poze/Poza5.jpg"};
    Icon icone;
    boolean inceput=false;
    int pozaCurenta;
    DefaultTableModel model;
    
    //AutoSave******************************************************************
    TimerTask autosave = new TimerTask(){
            @Override
            public void run() {
                a.salvare(autoload_save, getR());
                inceput=true;
            }
        };
    Timer auto = new Timer();
    //Reclame*******************************************************************
    TimerTask ads1 = new TimerTask(){
        @Override
        public void run() {
            //loop pentru poze
            if(pozaCurenta==5){
                pozaCurenta=0;
            }
            icone=new ImageIcon(ptPoze[pozaCurenta]);
            jAds.setIcon(icone);
            pozaCurenta++;
            }
    };
    //Timer t=new Timer();
    //Verificari pentru sortare jTable
    boolean NUME =false;
    boolean PRENUME=false;
    boolean NUMAR=false;
    Timer tAds=new Timer();
    public InterfataPrincipala() {
        if(!getPropValues("lastsave","saveconfig.properties").equals("")){
           autoload_save = new File(getPropValues("lastsave","saveconfig.properties")); 
        }
        initComponents();
        //Timer Pentru Reclame Pornire******************************************
        //t.schedule(ads1,0,4000);
        //Umple JTabel-ul cu Date din Lista*************************************
        model = (DefaultTableModel) Tabel.getModel();
        //Verifica daca User-ul s-a inregistart si daca este fals Dezactiveaza optiune save si open si activeaza Inregistrare
        if(getPropValues("inregistrat","inregistrare.properties").equals("false")){
            Inregistrare.setEnabled(true);
            Open.setEnabled(false);
            Save.setEnabled(false);
            tAds.schedule(ads1,0,4000);
            }
        //Umple jTable cu date
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        //Sortarea datelor din tabel si lista pe apasarea unui header
        Tabel.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            int col = Tabel.columnAtPoint(e.getPoint());
            switch(col){
   
                case 0:
                       if(NUME==false){
                           getR().sort(Comparators.NUME);
                           NUME=true;
                           PRENUME=false;
                           NUMAR=false;
                       }
                       else{
                           NUME=false;
                           getR().sort(Comparators.NUME.reversed());
                       }
                       model.setRowCount(0);
                       for(int i =0;i<getR().size();i++){
                       p=getR().get(i);
                       Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
                       model.addRow(row);}
                       break;
                case 1:if(PRENUME==false){
                           getR().sort(Comparators.PRENUME);
                           NUME=false;
                           PRENUME=true;
                           NUMAR=false;
                       }
                       else{
                           PRENUME=false;
                           getR().sort(Comparators.PRENUME.reversed());
                       }
                       model.setRowCount(0);
                       for(int i =0;i<getR().size();i++){
                       p=getR().get(i);
                       Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
                       model.addRow(row);}
                       break;
                case 2:if(NUMAR==false){
                           getR().sort(Comparators.NUMAR);
                           NUME=false;
                           PRENUME=false;
                           NUMAR=true;
                       }
                       else{
                           NUMAR=false;
                           getR().sort(Comparators.NUMAR.reversed());
                       }
                       model.setRowCount(0);
                       for(int i =0;i<getR().size();i++){
                       p=getR().get(i);
                       Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
                       model.addRow(row);}
                       break;
            }
            
            //String name = Tabel.getColumnName(col);
            //System.out.println("Column index selected " + col + " " + name);
    }
});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        FileOpen = new javax.swing.JFileChooser();
        FileSave = new javax.swing.JFileChooser();
        jDialogInregistrare = new javax.swing.JDialog();
        txtFieldInregistrare = new javax.swing.JTextField();
        ButonInregistrare = new javax.swing.JButton();
        JSearchDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        JSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Ok = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jAboutDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        JDialogAdauga = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JAdTx1 = new javax.swing.JTextField();
        JAdTx2 = new javax.swing.JTextField();
        JAdTx3 = new javax.swing.JTextField();
        JAdTx4 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        JCancelAdauga = new javax.swing.JButton();
        JOKAdauga = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JAdTx5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        JAdTx6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        JAdTx7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JAdTxA1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        JAdTxA2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        JAdTxA3 = new javax.swing.JTextArea();
        JDialogModifica = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        JMoTx1 = new javax.swing.JTextField();
        JMoTx2 = new javax.swing.JTextField();
        JMoTx3 = new javax.swing.JTextField();
        JMoTx4 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        JCancelModifica = new javax.swing.JButton();
        JOKModifica = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        JMoTx5 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        JMoTx6 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        JMoTx7 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JMoTxA1 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        JMoTxA2 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        JMoTxA3 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButtonAdauga = new javax.swing.JButton();
        jButtonModifica = new javax.swing.JButton();
        jButtonStergere = new javax.swing.JButton();
        jButtonCautare = new javax.swing.JButton();
        JButtonExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jAds = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jFile = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuExit = new javax.swing.JMenuItem();
        jAbonat = new javax.swing.JMenu();
        jAdauga = new javax.swing.JMenuItem();
        jSterge = new javax.swing.JMenuItem();
        jModifica = new javax.swing.JMenuItem();
        jCauta = new javax.swing.JMenuItem();
        jHelp = new javax.swing.JMenu();
        Inregistrare = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jAbout = new javax.swing.JMenuItem();

        FileSave.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        FileSave.setFileFilter(new FileNameExtensionFilter("FISIERE","rrt"));

        jDialogInregistrare.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogInregistrare.setTitle("Inregistrare");
        jDialogInregistrare.setMinimumSize(new java.awt.Dimension(423, 140));
        jDialogInregistrare.setModal(true);
        jDialogInregistrare.getContentPane().setLayout(new java.awt.GridBagLayout());
        jDialogInregistrare.setLocationRelativeTo(Inregistrare);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 276;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 0, 58, 0);
        jDialogInregistrare.getContentPane().add(txtFieldInregistrare, gridBagConstraints);

        ButonInregistrare.setText("Ok");
        ButonInregistrare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButonInregistrareMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 38, 58, 0);
        jDialogInregistrare.getContentPane().add(ButonInregistrare, gridBagConstraints);

        JSearchDialog.setMinimumSize(new java.awt.Dimension(300, 300));
        JSearchDialog.setLocationRelativeTo(Inregistrare);
        JSearchDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Nume");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Prenume");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton2, gridBagConstraints);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Numar");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton3, gridBagConstraints);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("CNP");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton4, gridBagConstraints);

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Tara");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton5, gridBagConstraints);

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("Oras");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton6, gridBagConstraints);

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setText("Localitate");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton7, gridBagConstraints);

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setText("Adr1");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton8, gridBagConstraints);

        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setText("Adr2");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jRadioButton9, gridBagConstraints);

        JSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JSearchKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.weightx = 4.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(JSearch, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        Ok.setText("Ok");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(Ok, gridBagConstraints);

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(Cancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        JSearchDialog.getContentPane().add(jPanel1, gridBagConstraints);

        jAboutDialog.setMinimumSize(new java.awt.Dimension(400, 328));
        jAboutDialog.setResizable(false);
        jAboutDialog.setLocationRelativeTo(Inregistrare);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Program Carte de Telefon\nCreat de Capraru Ovidiu\n\nProgramul poate adauga/modifica/cauta/sorta si\nsterge abonati. ");
        jScrollPane2.setViewportView(jTextArea1);

        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jAboutDialogLayout = new javax.swing.GroupLayout(jAboutDialog.getContentPane());
        jAboutDialog.getContentPane().setLayout(jAboutDialogLayout);
        jAboutDialogLayout.setHorizontalGroup(
            jAboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jAboutDialogLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jButton2)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jAboutDialogLayout.setVerticalGroup(
            jAboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        JDialogAdauga.setMinimumSize(new java.awt.Dimension(700, 700));
        JDialogAdauga.setLocationRelativeTo(null);
        JDialogAdauga.getContentPane().setLayout(new javax.swing.BoxLayout(JDialogAdauga.getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Nume");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Prenume");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(jLabel11, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Nr Telefon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("CNP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(jLabel13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 5.8;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(JAdTx1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel5.add(JAdTx2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel5.add(JAdTx3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel5.add(JAdTx4, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        JCancelAdauga.setText("Cancel");
        JCancelAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCancelAdaugaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel6.add(JCancelAdauga, gridBagConstraints);

        JOKAdauga.setText("Ok");
        JOKAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOKAdaugaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel6.add(JOKAdauga, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel5.add(jPanel6, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tara");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel5.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel5.add(JAdTx5, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Oras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        jPanel5.add(jLabel14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel5.add(JAdTx6, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Localitate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel5.add(jLabel15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel5.add(JAdTx7, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Adr1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jPanel5.add(jLabel16, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Adr2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel5.add(jLabel17, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Detalii");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        jPanel5.add(jLabel18, gridBagConstraints);

        JAdTxA1.setColumns(20);
        JAdTxA1.setRows(5);
        jScrollPane3.setViewportView(JAdTxA1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel5.add(jScrollPane3, gridBagConstraints);

        JAdTxA2.setColumns(20);
        JAdTxA2.setRows(5);
        jScrollPane4.setViewportView(JAdTxA2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel5.add(jScrollPane4, gridBagConstraints);

        JAdTxA3.setColumns(20);
        JAdTxA3.setRows(5);
        jScrollPane5.setViewportView(JAdTxA3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel5.add(jScrollPane5, gridBagConstraints);

        JDialogAdauga.getContentPane().add(jPanel5);

        JDialogModifica.setMinimumSize(new java.awt.Dimension(700, 700));
        JDialogAdauga.setLocationRelativeTo(null);
        JDialogModifica.getContentPane().setLayout(new javax.swing.BoxLayout(JDialogModifica.getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Nume");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(jLabel19, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Prenume");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(jLabel20, gridBagConstraints);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Nr Telefon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(jLabel21, gridBagConstraints);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("CNP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(jLabel22, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 5.8;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(JMoTx1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(JMoTx2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(JMoTx3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(JMoTx4, gridBagConstraints);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        JCancelModifica.setText("Cancel");
        JCancelModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCancelModificaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel8.add(JCancelModifica, gridBagConstraints);

        JOKModifica.setText("Ok");
        JOKModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOKModificaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel8.add(JOKModifica, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel7.add(jPanel8, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Tara");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel7.add(jLabel23, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(JMoTx5, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Oras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        jPanel7.add(jLabel24, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(JMoTx6, gridBagConstraints);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Localitate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel7.add(jLabel25, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(JMoTx7, gridBagConstraints);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Adr1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jPanel7.add(jLabel26, gridBagConstraints);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Adr2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel7.add(jLabel27, gridBagConstraints);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Detalii");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        jPanel7.add(jLabel28, gridBagConstraints);

        JMoTxA1.setColumns(20);
        JMoTxA1.setRows(5);
        jScrollPane6.setViewportView(JMoTxA1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel7.add(jScrollPane6, gridBagConstraints);

        JMoTxA2.setColumns(20);
        JMoTxA2.setRows(5);
        jScrollPane7.setViewportView(JMoTxA2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel7.add(jScrollPane7, gridBagConstraints);

        JMoTxA3.setColumns(20);
        JMoTxA3.setRows(5);
        jScrollPane8.setViewportView(JMoTxA3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel7.add(jScrollPane8, gridBagConstraints);

        JDialogModifica.getContentPane().add(jPanel7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(500, 200));
        setMinimumSize(new java.awt.Dimension(500, 200));
        setPreferredSize(new java.awt.Dimension(500, 500));

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nume", "Prenume", "Numar telefon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabel.setColumnSelectionAllowed(true);
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        Tabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);
        Tabel.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButtonAdauga.setText("Adauga");
        jButtonAdauga.setToolTipText("Adauga Abonati");
        jButtonAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdaugaActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAdauga);

        jButtonModifica.setText("Modifica");
        jButtonModifica.setToolTipText("Modifica Abonati Selectati");
        jButtonModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificaActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonModifica);

        jButtonStergere.setText("Sterge");
        jButtonStergere.setToolTipText("Sterge Abonati Selectati");
        jButtonStergere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStergereActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonStergere);

        jButtonCautare.setText("Cautare");
        jButtonCautare.setToolTipText("Filtreaza dupa textul dat");
        jButtonCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCautareActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCautare);

        JButtonExit.setText("Exit");
        JButtonExit.setToolTipText("Iese din Aplicatie");
        JButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonExitActionPerformed(evt);
            }
        });
        jPanel3.add(JButtonExit);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jAds.setMaximumSize(new java.awt.Dimension(500, 200));
        jAds.setMinimumSize(new java.awt.Dimension(500, 200));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAds, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jFile.setText("File");

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jFile.add(Open);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jFile.add(Save);
        jFile.add(jSeparator1);

        MenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        MenuExit.setText("Exit");
        MenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExitActionPerformed(evt);
            }
        });
        jFile.add(MenuExit);

        jMenuBar1.add(jFile);

        jAbonat.setText("Abonat");

        jAdauga.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jAdauga.setText("Adauga");
        jAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdaugaActionPerformed(evt);
            }
        });
        jAbonat.add(jAdauga);

        jSterge.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jSterge.setText("Sterge");
        jSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStergeActionPerformed(evt);
            }
        });
        jAbonat.add(jSterge);

        jModifica.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jModifica.setText("Modifica");
        jModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificaActionPerformed(evt);
            }
        });
        jAbonat.add(jModifica);

        jCauta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jCauta.setText("Cauta");
        jCauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCautaActionPerformed(evt);
            }
        });
        jAbonat.add(jCauta);

        jMenuBar1.add(jAbonat);

        jHelp.setText("Help");

        Inregistrare.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Inregistrare.setText("Inregistrare");
        Inregistrare.setEnabled(false);
        Inregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InregistrareActionPerformed(evt);
            }
        });
        jHelp.add(Inregistrare);
        jHelp.add(jSeparator2);

        jAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jAbout.setText("About");
        jAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAboutActionPerformed(evt);
            }
        });
        jHelp.add(jAbout);

        jMenuBar1.add(jHelp);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        //Pentru a Incarca******************************************************
        
        int returnVal = FileOpen.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = FileOpen.getSelectedFile();
        a.setR(a.incarcare(file));
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();
    }
    }//GEN-LAST:event_OpenActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        //Pentru a Salva********************************************************
        int returnVal = FileSave.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        String nume;
        String director;
        nume = FileSave.getSelectedFile().getName();
        director = FileSave.getCurrentDirectory().toString();
        autoload_save=a.salvare(director, nume, getR());
        if(inceput==false){
        auto.schedule(autosave,0,300000);
        }
    }
    }//GEN-LAST:event_SaveActionPerformed

    private void jButtonAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdaugaActionPerformed
        //Pentru a Chema Dialog Adaugare - Buton********************************
        JDialogAdauga.setVisible(true);
    }//GEN-LAST:event_jButtonAdaugaActionPerformed

    private void JButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonExitActionPerformed
        // Pentru a Iesi din Program - Buton*************************************
       int n = JOptionPane.showConfirmDialog(null,"Doriti sa parasiti aplicatia ?","Exit dialog",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(n==0){
           if(autoload_save!=null){
           a.salvare(autoload_save,getR());
           try {
               setPropValues("lastsave",autoload_save.getAbsolutePath(),"saveconfig.properties");
           } catch (IOException ex) {
               Logger.getLogger(InterfataPrincipala.class.getName()).log(Level.SEVERE, null, ex);
           }}
           this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
       }
       
    }//GEN-LAST:event_JButtonExitActionPerformed

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        //Pentru a Iesi din Program - Bara Meniu********************************
       int n = JOptionPane.showConfirmDialog(null,"Doriti sa parasiti aplicatia ?","Exit dialog",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(n==0){
           if(autoload_save!=null){
           a.salvare(autoload_save,getR());
           try {
               setPropValues("lastsave",autoload_save.getAbsolutePath(),"saveconfig.properties");
           } catch (IOException ex) {
               Logger.getLogger(InterfataPrincipala.class.getName()).log(Level.SEVERE, null, ex);
           }}
           this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
       }
    }//GEN-LAST:event_MenuExitActionPerformed

    private void InregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InregistrareActionPerformed
        //Pentru a Chema Fereastra Inregistrare*********************************
        jDialogInregistrare.setVisible(true);
    }//GEN-LAST:event_InregistrareActionPerformed

    private void jButtonStergereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStergereActionPerformed
        ////Pentru a sterge un Abonat - Buton***********************************
        int index =Tabel.getSelectedRow();
        if(index>-1){
        int n = JOptionPane.showConfirmDialog(null,"Sigur doriti sa stergeti inregistrarea ??","Delete Dialog",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(n==0){
            int bindex = Tabel.convertRowIndexToModel(index);
            DefaultTableModel modeldelete3=(DefaultTableModel) Tabel.getModel();
            modeldelete3.removeRow(bindex);
            a.Sterge(bindex);
        }
        }
        else{
            JOptionPane.showMessageDialog(null,"Nici un Abonat selectat");
        }
    }//GEN-LAST:event_jButtonStergereActionPerformed

    private void ButonInregistrareMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonInregistrareMouseReleased
        //Fereastra Inregistrare Confirmare*************************************
        String s=txtFieldInregistrare.getText();
            if(s.equals(getPropValues("cod","inregistrarecode.properties"))){
                //a.testsetPropValues("Inregistrare","true");
                JOptionPane.showMessageDialog(null,"Cod corect");
            try {
                setPropValues("inregistrat","true","inregistrare.properties");
            } catch (IOException ex) {
                Logger.getLogger(InterfataPrincipala.class.getName()).log(Level.SEVERE, null, ex);
            }
                Inregistrare.setEnabled(false);
                Open.setEnabled(true);
                Save.setEnabled(true);
                tAds.cancel();
                tAds.purge();
                jPanel2.removeAll();
                jPanel2.setEnabled(false);
                SwingUtilities.updateComponentTreeUI(jPanel2);
                jDialogInregistrare.dispose();
               //JPanel2.repaint();
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Cod incorect");
            }
            
    }//GEN-LAST:event_ButonInregistrareMouseReleased

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        //Pentru a Modifica cu Dublu Click**************************************
        int index =Tabel.getSelectedRow();
        int bindex = Tabel.convertRowIndexToModel(index);
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        JMoTx1.setText(getR().get(bindex).getNume());
        JMoTx2.setText(getR().get(bindex).getPrenume());
        JMoTx3.setText(getR().get(bindex).getNr());
        if(getR().get(bindex).getCNP()!=-1){JMoTx4.setText(Long.toString(getR().get(bindex).getCNP()));}
        JMoTx5.setText(getR().get(bindex).getAdresa().getTara());
        JMoTx6.setText(getR().get(bindex).getAdresa().getOras());
        JMoTx7.setText(getR().get(bindex).getAdresa().getLocalitate());
        JMoTxA1.setText(getR().get(bindex).getAdresa().getAdr1());
        JMoTxA2.setText(getR().get(bindex).getAdresa().getAdr2());
        JMoTxA3.setText(getR().get(bindex).getDetalii());
        JDialogModifica.setVisible(true);
            }
    }//GEN-LAST:event_TabelMouseClicked

    private void TabelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelKeyReleased
        //Pentru a Modifica Apasand Enter***************************************
        int index =Tabel.getSelectedRow();
        int bindex = Tabel.convertRowIndexToModel(index);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if(index>-1){
        JMoTx1.setText(getR().get(bindex).getNume());
        JMoTx2.setText(getR().get(bindex).getPrenume());
        JMoTx3.setText(getR().get(bindex).getNr());
        if(getR().get(bindex).getCNP()!=-1){JMoTx4.setText(Long.toString(getR().get(bindex).getCNP()));}
        JMoTx5.setText(getR().get(bindex).getAdresa().getTara());
        JMoTx6.setText(getR().get(bindex).getAdresa().getOras());
        JMoTx7.setText(getR().get(bindex).getAdresa().getLocalitate());
        JMoTxA1.setText(getR().get(bindex).getAdresa().getAdr1());
        JMoTxA2.setText(getR().get(bindex).getAdresa().getAdr2());
        JMoTxA3.setText(getR().get(bindex).getDetalii());
        JDialogModifica.setVisible(true);}
        }
    }//GEN-LAST:event_TabelKeyReleased

    private void jStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStergeActionPerformed
        //Pentru a sterge un Abonat - Bara Meniu********************************
        int index =Tabel.getSelectedRow();
        int bindex =Tabel.convertRowIndexToModel(index);
        if(index>-1){
        int n = JOptionPane.showConfirmDialog(null,"Sigur doriti sa stergeti inregistrarea ??","Delete Dialog",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
           if(n==0){
        DefaultTableModel modeldelete2=(DefaultTableModel) Tabel.getModel();
        modeldelete2.removeRow(bindex);
        System.out.println(bindex);
        a.Sterge(bindex);
           }
        }
        else{
            JOptionPane.showMessageDialog(null,"Nici un Abonat selectat");
        }
    }//GEN-LAST:event_jStergeActionPerformed

    private void jAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdaugaActionPerformed
        // Chemare Dialog Adaugare - Bara Meniu*********************************
        JDialogAdauga.setVisible(true);
    }//GEN-LAST:event_jAdaugaActionPerformed

    private void jModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificaActionPerformed
        // Pentru a chema Dialog Modificare - Bara Meniu************************
        int index =Tabel.getSelectedRow();
        int bindex = Tabel.convertRowIndexToModel(index);
        if(index>-1){
        JMoTx1.setText(getR().get(bindex).getNume());
        JMoTx2.setText(getR().get(bindex).getPrenume());
        JMoTx3.setText(getR().get(bindex).getNr());
        if(getR().get(bindex).getCNP()!=-1){JMoTx4.setText(Long.toString(getR().get(bindex).getCNP()));}
        JMoTx5.setText(getR().get(bindex).getAdresa().getTara());
        JMoTx6.setText(getR().get(bindex).getAdresa().getOras());
        JMoTx7.setText(getR().get(bindex).getAdresa().getLocalitate());
        JMoTxA1.setText(getR().get(bindex).getAdresa().getAdr1());
        JMoTxA2.setText(getR().get(bindex).getAdresa().getAdr2());
        JMoTxA3.setText(getR().get(bindex).getDetalii());
        JDialogModifica.setVisible(true);}
        else{
            JOptionPane.showMessageDialog(null,"Nici un Abonat selectat");
        }
    }//GEN-LAST:event_jModificaActionPerformed

    private void jButtonModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificaActionPerformed
        // Pentru a chema Dialog Modificare - Buton*****************************
        int index =Tabel.getSelectedRow();
        int bindex = Tabel.convertRowIndexToModel(index);
        if(index>-1){
        JMoTx1.setText(getR().get(bindex).getNume());
        JMoTx2.setText(getR().get(bindex).getPrenume());
        JMoTx3.setText(getR().get(bindex).getNr());
        if(getR().get(bindex).getCNP()!=-1){JMoTx4.setText(Long.toString(getR().get(bindex).getCNP()));}
        JMoTx5.setText(getR().get(bindex).getAdresa().getTara());
        JMoTx6.setText(getR().get(bindex).getAdresa().getOras());
        JMoTx7.setText(getR().get(bindex).getAdresa().getLocalitate());
        JMoTxA1.setText(getR().get(bindex).getAdresa().getAdr1());
        JMoTxA2.setText(getR().get(bindex).getAdresa().getAdr2());
        JMoTxA3.setText(getR().get(bindex).getDetalii());
        JDialogModifica.setVisible(true);}
        else{
            JOptionPane.showMessageDialog(null,"Nici un Abonat selectat");
        }
    }//GEN-LAST:event_jButtonModificaActionPerformed

    private void jButtonCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCautareActionPerformed
        // TODO add your handling code here:
        JSearchDialog.setVisible(true);
    }//GEN-LAST:event_jButtonCautareActionPerformed

    private void jAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAboutActionPerformed
        // TODO add your handling code here:
        jAboutDialog.setVisible(true);
    }//GEN-LAST:event_jAboutActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jAboutDialog.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCautaActionPerformed
        // TODO add your handling code here:
        JSearchDialog.setVisible(true);
    }//GEN-LAST:event_jCautaActionPerformed

    private void JCancelAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCancelAdaugaActionPerformed
        // TODO add your handling code here:
        JDialogAdauga.dispose();
    }//GEN-LAST:event_JCancelAdaugaActionPerformed

    private void JOKAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JOKAdaugaActionPerformed
        // TODO add your handling code here:
        try{
        a.Adauga(JAdTx1.getText(),JAdTx2.getText(),new NrTel(JAdTx3.getText()),JAdTx4.getText(),JAdTx5.getText(),JAdTx6.getText(),JAdTx7.getText(),JAdTxA1.getText(),JAdTxA2.getText(),JAdTxA3.getText());
        JOptionPane.showMessageDialog(null,"Abonat adaugat cu success");
        p=getR().get(getR().size()-1);
        Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
        model.addRow(row);
        model.fireTableDataChanged();
        }catch(HeadlessException e){}
    }//GEN-LAST:event_JOKAdaugaActionPerformed

    private void JCancelModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCancelModificaActionPerformed
        // TODO add your handling code here:
        JDialogModifica.dispose();
    }//GEN-LAST:event_JCancelModificaActionPerformed

    private void JOKModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JOKModificaActionPerformed
        // TODO add your handling code here:
        int index =Tabel.getSelectedRow();
        int bindex = Tabel.convertRowIndexToModel(index);
        DefaultTableModel modelModifica=(DefaultTableModel) Tabel.getModel();
        //modeldelete.removeRow(index);
        try{
        a.Modifica(bindex,JMoTx1.getText(),JMoTx2.getText(),new NrTel(JMoTx3.getText()),JMoTx4.getText(),JMoTx5.getText(),JMoTx6.getText(),JMoTx7.getText(),JMoTxA1.getText(),JMoTxA2.getText(),JAdTxA3.getText());
        JOptionPane.showMessageDialog(null,"Abonat Modificat cu Succes");
        p=getR().get(bindex);
        Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
        modelModifica.removeRow(bindex);
        modelModifica.insertRow(bindex,row);
        modelModifica.fireTableDataChanged();
        JDialogModifica.dispose();
        }catch(HeadlessException e){}
    }//GEN-LAST:event_JOKModificaActionPerformed

    private void JSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JSearchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JSearchKeyReleased

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        select=1;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
        // TODO add your handling code here:
        if(select==1){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(p.getNume().equals(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
        if(select==2){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(p.getPrenume().equals(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
        if(select==3){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(p.getNr().equals(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
        if(select==4){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(Long.toString(p.getCNP()).equals(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
        if(select==5){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(p.getAdresa().getTara().equals(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
        if(select==6){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(p.getAdresa().getOras().equals(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
        if(select==7){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(p.getAdresa().getLocalitate().equals(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
        if(select==8){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(p.getAdresa().getAdr1().contains(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
        if(select==9){
        model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            if(p.getAdresa().getAdr2().contains(JSearch.getText())){
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();}}
    }//GEN-LAST:event_OkActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        select=2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        select=3;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        select=4;
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        select=5;
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        select=6;
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
        select=7;
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
        select=8;
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
        select=9;
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
         model.setRowCount(0);
        for(int i =0;i<getR().size();i++){
            p=getR().get(i);
            Object[] row ={p.getNume(),p.getPrenume(),p.getNr()};
            model.addRow(row);
        }
        model.fireTableDataChanged();
    }//GEN-LAST:event_CancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfataPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
            
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            try{
                //Pentru Splash Screen
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(InterfataPrincipala.class.getName()).log(Level.SEVERE, null, ex);
            }
            new InterfataPrincipala().setVisible(true);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButonInregistrare;
    private javax.swing.JButton Cancel;
    private javax.swing.JFileChooser FileOpen;
    private javax.swing.JFileChooser FileSave;
    private javax.swing.JMenuItem Inregistrare;
    private javax.swing.JTextField JAdTx1;
    private javax.swing.JTextField JAdTx2;
    private javax.swing.JTextField JAdTx3;
    private javax.swing.JTextField JAdTx4;
    private javax.swing.JTextField JAdTx5;
    private javax.swing.JTextField JAdTx6;
    private javax.swing.JTextField JAdTx7;
    private javax.swing.JTextArea JAdTxA1;
    private javax.swing.JTextArea JAdTxA2;
    private javax.swing.JTextArea JAdTxA3;
    private javax.swing.JButton JButtonExit;
    private javax.swing.JButton JCancelAdauga;
    private javax.swing.JButton JCancelModifica;
    private javax.swing.JDialog JDialogAdauga;
    private javax.swing.JDialog JDialogModifica;
    private javax.swing.JTextField JMoTx1;
    private javax.swing.JTextField JMoTx2;
    private javax.swing.JTextField JMoTx3;
    private javax.swing.JTextField JMoTx4;
    private javax.swing.JTextField JMoTx5;
    private javax.swing.JTextField JMoTx6;
    private javax.swing.JTextField JMoTx7;
    private javax.swing.JTextArea JMoTxA1;
    private javax.swing.JTextArea JMoTxA2;
    private javax.swing.JTextArea JMoTxA3;
    private javax.swing.JButton JOKAdauga;
    private javax.swing.JButton JOKModifica;
    private javax.swing.JTextField JSearch;
    private javax.swing.JDialog JSearchDialog;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JButton Ok;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Save;
    private javax.swing.JTable Tabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jAbonat;
    private javax.swing.JMenuItem jAbout;
    private javax.swing.JDialog jAboutDialog;
    private javax.swing.JMenuItem jAdauga;
    private javax.swing.JLabel jAds;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAdauga;
    private javax.swing.JButton jButtonCautare;
    private javax.swing.JButton jButtonModifica;
    private javax.swing.JButton jButtonStergere;
    private javax.swing.JMenuItem jCauta;
    private javax.swing.JDialog jDialogInregistrare;
    private javax.swing.JMenu jFile;
    private javax.swing.JMenu jHelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jModifica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem jSterge;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtFieldInregistrare;
    // End of variables declaration//GEN-END:variables
}
