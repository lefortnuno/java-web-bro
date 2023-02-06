package jnotify;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NotifyType;
import com.sbix.jnotify.NotifyWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author -TROFEL-
 */
public class Login extends javax.swing.JFrame {

    Connecteur conn = new Connecteur();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model = new DefaultTableModel();
    
    Connecteur connV = new Connecteur();
    Statement stmV;
    ResultSet RsV;
    DefaultTableModel modelV = new DefaultTableModel();
    
    Connecteur connL = new Connecteur();
    Statement stmL;
    ResultSet RsL;
    DefaultTableModel Lmodel = new DefaultTableModel();
    
    Connecteur connResum = new Connecteur();
    Statement stmResum;
    ResultSet RsResum;
    DefaultTableModel ResumModel = new DefaultTableModel();
    
    public Login() {
        initComponents();
        
        model.addColumn("N*Client");
        model.addColumn("Nom");
        
        idLocDesign.setVisible(false);
        try{
            stm=conn.ObtenirConnections().createStatement();
            ResultSet Rs =stm.executeQuery("Select * from client ORDER BY id DESC");
            while(Rs.next()){
                model.addRow(new Object[]{
                    "Cli - "+Rs.getString("id"),
                    Rs.getString("nom")});
            }
        }
        catch(Exception e){System.err.println(e);}
        tableEnDesign.setModel(model);
        
        modelV.addColumn("N*Voiture");
        modelV.addColumn("Numero IM");
        modelV.addColumn("Marque");
        modelV.addColumn("pu");
        modelV.addColumn("stock");
        idVDS.setVisible(false);
        try{
            stmV=connV.ObtenirConnections().createStatement();
            ResultSet RsV =stmV.executeQuery("Select * from voiture ORDER BY id DESC");
            while(RsV.next()){
                /*ATAO MTOVY AM'NY MYSQL ny VARIABLE N'CHAMP ID NOM ADRESS*/
                modelV.addRow(new Object[]{
                    "Voiture - "+RsV.getString("id"),
                    RsV.getString("numero"),
                    RsV.getString("marque"),
                    RsV.getString("pu"),
                    RsV.getString("stock")});
            }
        }
        catch(Exception e){System.err.println(e);}
        tableVoitureEnDesign.setModel(modelV);
        
        Lmodel.addColumn("ID");
        Lmodel.addColumn("N*Locataire");
        Lmodel.addColumn("Nom Locataire");
        Lmodel.addColumn("N*Voiture");
        Lmodel.addColumn("Qte");
        Lmodel.addColumn("Date");
        idLDS.setVisible(false);
        try{
            stmL=connL.ObtenirConnections().createStatement();
            ResultSet RsL =stmL.executeQuery("SELECT vente.id, client.id, client.nom, voiture.numero, "
                    + "qte, DATE_FORMAT(date, '%d-%m-%Y') FROM vente, client, voiture WHERE "
                    + "client.id=vente.idCli AND voiture.id=vente.idVtr "
                    + "ORDER BY vente.id DESC;");
            while(RsL.next()){
                Lmodel.addRow(new Object[]{
                    "N# - "+RsL.getString("vente.id"),
                    "Cli - "+RsL.getString("client.id"),
                    RsL.getString("client.nom"),
                    RsL.getString("voiture.numero"),
                    RsL.getString("qte"),
                    RsL.getString("DATE_FORMAT(date, '%d-%m-%Y')")});
            }
        }
        catch(Exception e){System.err.println(e);}
        tableLouerEnDesign.setModel(Lmodel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pageParent = new javax.swing.JPanel();
        loginPage = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        champNomUtilisateur = new javax.swing.JTextField();
        champMotdePasse = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        seconnecterBTN = new javax.swing.JButton();
        quitterBTN = new javax.swing.JButton();
        aideBTN = new javax.swing.JButton();
        effacerBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pageGLV = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        voituresNavBar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        locatairesNavBar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        quitterNavBar = new javax.swing.JLabel();
        pageGLVContenu = new javax.swing.JPanel();
        louerPage = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableLouerEnDesign = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        numero1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        idLDS = new javax.swing.JTextField();
        qteLDS = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        listVoituresDS = new javax.swing.JComboBox();
        listLocatairesDS = new javax.swing.JComboBox();
        jDateLDS = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        ajouterNouvelleLocVtr = new javax.swing.JButton();
        supprimerLocVtr = new javax.swing.JButton();
        modifierLocVtr = new javax.swing.JButton();
        actualiserLouer = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        rechercheTapantLouer = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jdateUn = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jdateDeux = new com.toedter.calendar.JDateChooser();
        rechercherEntreDeuxDate = new javax.swing.JButton();
        locatairesPage = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        nomLocDesign = new javax.swing.JTextField();
        idLocDesign = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEnDesign = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        ajouterLocataire = new javax.swing.JButton();
        supprimerLocataire = new javax.swing.JButton();
        modifierLocataire = new javax.swing.JButton();
        actualiser = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        rechercherLocataire = new javax.swing.JButton();
        nomLocDesignRechrch = new javax.swing.JTextField();
        voituresPage = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        numero = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        idVDS = new javax.swing.JTextField();
        puVDS = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        numVDS = new javax.swing.JTextField();
        desgVDS = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        stockVDS = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVoitureEnDesign = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        ajouterVoiture = new javax.swing.JButton();
        supprimerVoiture = new javax.swing.JButton();
        modifierVoiture = new javax.swing.JButton();
        actualiserVoiture = new javax.swing.JButton();
        numDesignRechrchVoiture = new javax.swing.JTextField();
        rechercherVoiture = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1460, 830));
        setPreferredSize(new java.awt.Dimension(1700, 830));

        pageParent.setMinimumSize(new java.awt.Dimension(1020, 830));
        pageParent.setPreferredSize(new java.awt.Dimension(217, 659));
        pageParent.setLayout(new java.awt.CardLayout());

        loginPage.setMinimumSize(new java.awt.Dimension(960, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Utilisateur : ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setText("Mot de passe : ");

        champNomUtilisateur.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        champNomUtilisateur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        champNomUtilisateur.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        champMotdePasse.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        champMotdePasse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(champNomUtilisateur)
                    .addComponent(champMotdePasse, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(champNomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(champMotdePasse, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        seconnecterBTN.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        seconnecterBTN.setText("Se connecter");
        seconnecterBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seconnecterBTNActionPerformed(evt);
            }
        });

        quitterBTN.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        quitterBTN.setText("Quitter");
        quitterBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterBTNActionPerformed(evt);
            }
        });

        aideBTN.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        aideBTN.setText("Aide ");
        aideBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aideBTNActionPerformed(evt);
            }
        });

        effacerBTN.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        effacerBTN.setText("Effacer");
        effacerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacerBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(seconnecterBTN)
                .addGap(40, 40, 40)
                .addComponent(effacerBTN)
                .addGap(18, 18, 18)
                .addComponent(quitterBTN)
                .addGap(18, 18, 18)
                .addComponent(aideBTN)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seconnecterBTN)
                    .addComponent(effacerBTN)
                    .addComponent(quitterBTN)
                    .addComponent(aideBTN))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("SYSTEME D'IDENTIFICATION");

        javax.swing.GroupLayout loginPageLayout = new javax.swing.GroupLayout(loginPage);
        loginPage.setLayout(loginPageLayout);
        loginPageLayout.setHorizontalGroup(
            loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPageLayout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(160, 160, 160)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(342, 342, 342))
        );
        loginPageLayout.setVerticalGroup(
            loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPageLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPageLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        pageParent.add(loginPage, "card2");

        pageGLV.setBackground(new java.awt.Color(204, 204, 204));
        pageGLV.setMinimumSize(new java.awt.Dimension(1020, 860));
        pageGLV.setPreferredSize(new java.awt.Dimension(1720, 930));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 50));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("VenteVoiture");

        voituresNavBar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        voituresNavBar.setText("Voitures");
        voituresNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voituresNavBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voituresNavBarMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText(">>>");

        locatairesNavBar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        locatairesNavBar.setText("Client");
        locatairesNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        locatairesNavBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locatairesNavBarMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Vente");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        quitterNavBar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        quitterNavBar.setText("Quitter");
        quitterNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quitterNavBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitterNavBarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(78, 78, 78)
                .addComponent(voituresNavBar)
                .addGap(18, 18, 18)
                .addComponent(locatairesNavBar)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 861, Short.MAX_VALUE)
                .addComponent(quitterNavBar)
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addComponent(voituresNavBar)
                .addComponent(jLabel6)
                .addComponent(locatairesNavBar)
                .addComponent(jLabel8)
                .addComponent(quitterNavBar))
        );

        pageGLVContenu.setMinimumSize(new java.awt.Dimension(100, 860));
        pageGLVContenu.setPreferredSize(new java.awt.Dimension(1020, 960));
        pageGLVContenu.setLayout(new java.awt.CardLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel13.setText("LISTE DES VENTES DE VOITURE ");

        tableLouerEnDesign.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tableLouerEnDesign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Titre 6"
            }
        ));
        tableLouerEnDesign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLouerEnDesignMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableLouerEnDesign);

        jPanel11.setLayout(null);

        numero1.setText("LOCATAIRE :");
        jPanel11.add(numero1);
        numero1.setBounds(10, 70, 131, 34);

        jLabel18.setText("VOITURE :");
        jPanel11.add(jLabel18);
        jLabel18.setBounds(12, 134, 131, 34);

        idLDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idLDSActionPerformed(evt);
            }
        });
        jPanel11.add(idLDS);
        idLDS.setBounds(10, 20, 90, 30);

        qteLDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qteLDSActionPerformed(evt);
            }
        });
        jPanel11.add(qteLDS);
        qteLDS.setBounds(140, 200, 200, 30);

        jLabel19.setText("DATE LOCATION");
        jPanel11.add(jLabel19);
        jLabel19.setBounds(10, 260, 100, 34);

        jLabel20.setText("QTE: ");
        jPanel11.add(jLabel20);
        jLabel20.setBounds(10, 200, 131, 34);

        listVoituresDS.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel11.add(listVoituresDS);
        listVoituresDS.setBounds(140, 130, 200, 40);

        listLocatairesDS.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel11.add(listLocatairesDS);
        listLocatairesDS.setBounds(140, 70, 200, 40);

        jDateLDS.setDateFormatString("dd-MM-yyyy");
        jDateLDS.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel11.add(jDateLDS);
        jDateLDS.setBounds(140, 262, 150, 30);

        ajouterNouvelleLocVtr.setText("Ajouter");
        ajouterNouvelleLocVtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterNouvelleLocVtrActionPerformed(evt);
            }
        });

        supprimerLocVtr.setText("Supprimer");
        supprimerLocVtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerLocVtrActionPerformed(evt);
            }
        });

        modifierLocVtr.setText("Modifier");
        modifierLocVtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierLocVtrActionPerformed(evt);
            }
        });

        actualiserLouer.setText("Actualiser");
        actualiserLouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualiserLouerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajouterNouvelleLocVtr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifierLocVtr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supprimerLocVtr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actualiserLouer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterNouvelleLocVtr, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimerLocVtr, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifierLocVtr, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualiserLouer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        rechercheTapantLouer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rechercheTapantLouer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rechercheTapantLouerKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText(" DE");

        jdateUn.setDateFormatString("dd-MM-yyyy");
        jdateUn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("  A");

        jdateDeux.setDateFormatString("dd-MM-yyyy");
        jdateDeux.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        rechercherEntreDeuxDate.setText("Rechercher");
        rechercherEntreDeuxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherEntreDeuxDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(rechercheTapantLouer, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdateUn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdateDeux, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rechercherEntreDeuxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdateUn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rechercheTapantLouer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jdateDeux, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rechercherEntreDeuxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7)))))
        );

        javax.swing.GroupLayout louerPageLayout = new javax.swing.GroupLayout(louerPage);
        louerPage.setLayout(louerPageLayout);
        louerPageLayout.setHorizontalGroup(
            louerPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(louerPageLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, louerPageLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(louerPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(louerPageLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel13)
                        .addGap(38, 377, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, louerPageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(louerPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(louerPageLayout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(louerPageLayout.createSequentialGroup()
                                .addComponent(jScrollPane3)
                                .addGap(429, 429, 429))))))
        );
        louerPageLayout.setVerticalGroup(
            louerPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(louerPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(louerPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(louerPageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, louerPageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pageGLVContenu.add(louerPage, "card4");

        jPanel5.setLayout(null);

        jLabel9.setText("NOM ET PRENOM :");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(12, 134, 131, 34);

        nomLocDesign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomLocDesignActionPerformed(evt);
            }
        });
        jPanel5.add(nomLocDesign);
        nomLocDesign.setBounds(140, 140, 200, 30);

        idLocDesign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idLocDesignActionPerformed(evt);
            }
        });
        jPanel5.add(idLocDesign);
        idLocDesign.setBounds(140, 70, 200, 30);

        tableEnDesign.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tableEnDesign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableEnDesign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEnDesignMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEnDesign);

        ajouterLocataire.setText("Ajouter");
        ajouterLocataire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterLocataireActionPerformed(evt);
            }
        });

        supprimerLocataire.setText("Supprimer");
        supprimerLocataire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerLocataireActionPerformed(evt);
            }
        });

        modifierLocataire.setText("Modifier");
        modifierLocataire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierLocataireActionPerformed(evt);
            }
        });

        actualiser.setText("Actualiser");
        actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ajouterLocataire, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifierLocataire, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supprimerLocataire, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterLocataire, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimerLocataire, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifierLocataire, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel11.setText("LISTE DES CLIENTS ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel11)
                .addContainerGap(356, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        rechercherLocataire.setText("Rechercher");
        rechercherLocataire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherLocataireActionPerformed(evt);
            }
        });

        nomLocDesignRechrch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nomLocDesignRechrch.setText(" Tapez pour faire une recherche ....");
        nomLocDesignRechrch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomLocDesignRechrchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout locatairesPageLayout = new javax.swing.GroupLayout(locatairesPage);
        locatairesPage.setLayout(locatairesPageLayout);
        locatairesPageLayout.setHorizontalGroup(
            locatairesPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, locatairesPageLayout.createSequentialGroup()
                .addGap(0, 203, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(locatairesPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(locatairesPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(locatairesPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(locatairesPageLayout.createSequentialGroup()
                            .addComponent(nomLocDesignRechrch, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(rechercherLocataire, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(583, Short.MAX_VALUE))
        );
        locatairesPageLayout.setVerticalGroup(
            locatairesPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locatairesPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(locatairesPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(locatairesPageLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(locatairesPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rechercherLocataire, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomLocDesignRechrch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(locatairesPageLayout.createSequentialGroup()
                        .addGap(0, 72, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        pageGLVContenu.add(locatairesPage, "card3");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel12.setText("LISTE DES VOITURES ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(376, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12))
        );

        jPanel9.setLayout(null);

        numero.setText("NUMERO IM :");
        jPanel9.add(numero);
        numero.setBounds(10, 70, 131, 34);

        jLabel15.setText("DESIGNATION :");
        jPanel9.add(jLabel15);
        jLabel15.setBounds(12, 134, 131, 34);

        idVDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idVDSActionPerformed(evt);
            }
        });
        jPanel9.add(idVDS);
        idVDS.setBounds(10, 20, 90, 30);

        puVDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puVDSActionPerformed(evt);
            }
        });
        jPanel9.add(puVDS);
        puVDS.setBounds(140, 210, 200, 30);

        jLabel17.setText("STOCK :");
        jPanel9.add(jLabel17);
        jLabel17.setBounds(10, 270, 131, 34);

        numVDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numVDSActionPerformed(evt);
            }
        });
        jPanel9.add(numVDS);
        numVDS.setBounds(140, 70, 200, 30);

        desgVDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desgVDSActionPerformed(evt);
            }
        });
        jPanel9.add(desgVDS);
        desgVDS.setBounds(140, 140, 200, 30);

        jLabel22.setText("PU :");
        jPanel9.add(jLabel22);
        jLabel22.setBounds(10, 210, 131, 34);

        stockVDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockVDSActionPerformed(evt);
            }
        });
        jPanel9.add(stockVDS);
        stockVDS.setBounds(140, 270, 200, 30);

        tableVoitureEnDesign.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tableVoitureEnDesign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tableVoitureEnDesign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVoitureEnDesignMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableVoitureEnDesign);

        ajouterVoiture.setText("Ajouter");
        ajouterVoiture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterVoitureActionPerformed(evt);
            }
        });

        supprimerVoiture.setText("Supprimer");
        supprimerVoiture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerVoitureActionPerformed(evt);
            }
        });

        modifierVoiture.setText("Modifier");
        modifierVoiture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierVoitureActionPerformed(evt);
            }
        });

        actualiserVoiture.setText("Actualiser");
        actualiserVoiture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualiserVoitureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajouterVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifierVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supprimerVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actualiserVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimerVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifierVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualiserVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        numDesignRechrchVoiture.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        numDesignRechrchVoiture.setText(" Tapez pour faire une recherche ....");
        numDesignRechrchVoiture.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numDesignRechrchVoitureKeyTyped(evt);
            }
        });

        rechercherVoiture.setText("Rechercher");
        rechercherVoiture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherVoitureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout voituresPageLayout = new javax.swing.GroupLayout(voituresPage);
        voituresPage.setLayout(voituresPageLayout);
        voituresPageLayout.setHorizontalGroup(
            voituresPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(voituresPageLayout.createSequentialGroup()
                .addGroup(voituresPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(voituresPageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(voituresPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, voituresPageLayout.createSequentialGroup()
                                .addComponent(numDesignRechrchVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rechercherVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(voituresPageLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        voituresPageLayout.setVerticalGroup(
            voituresPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(voituresPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(voituresPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(voituresPageLayout.createSequentialGroup()
                        .addGroup(voituresPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rechercherVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numDesignRechrchVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pageGLVContenu.add(voituresPage, "card2");

        javax.swing.GroupLayout pageGLVLayout = new javax.swing.GroupLayout(pageGLV);
        pageGLV.setLayout(pageGLVLayout);
        pageGLVLayout.setHorizontalGroup(
            pageGLVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pageGLVContenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1681, Short.MAX_VALUE)
        );
        pageGLVLayout.setVerticalGroup(
            pageGLVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageGLVLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageGLVContenu, javax.swing.GroupLayout.PREFERRED_SIZE, 773, Short.MAX_VALUE))
        );

        pageParent.add(pageGLV, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pageParent, javax.swing.GroupLayout.DEFAULT_SIZE, 1681, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pageParent, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void afficherNotificationDefault(String notif){
        NotifyWindow SnotifyWindow1S = new NotifyWindow(
            NotifyType.DEFAULT_NOTIFICATION,
            notif,
            NotifyWindow.LONG_DELAY, 
            NPosition.BOTTOM_RIGHT);
    }
    private void afficherNotificationSuccess(String notif){
        NotifyWindow SnotifyWindow1S = new NotifyWindow(
            NotifyType.SUCCESS_NOTIFICATION,
            notif,
            NotifyWindow.NORMAL_DELAY, 
            NPosition.BOTTOM_RIGHT);
    }
    private void afficherNotificationOrange(String notif){
        NotifyWindow SnotifyWindow1S = new NotifyWindow(
            NotifyType.WARNING_NOTIFICATION,
            notif,
            NotifyWindow.NORMAL_DELAY, 
            NPosition.BOTTOM_RIGHT);
    }
    private void afficherNotificationErreur(String notif){
        NotifyWindow SnotifyWindow1S = new NotifyWindow(
            NotifyType.ERROR_NOTIFICATION,
            notif,
            NotifyWindow.LONG_DELAY, 
            NPosition.BOTTOM_RIGHT);
    }
    
    private void foreignLouerID(ResultSet RsL, ResultSet RsV) throws SQLException{
        listLocatairesDS.removeAllItems();
        listVoituresDS.removeAllItems();
        while(RsL.next()){
            String id = RsL.getString("id");
            String nom = RsL.getString("nom");
            String tmp = id.concat(" - ");
            tmp = tmp.concat(nom);
            listLocatairesDS.addItem(tmp);
        }
        while(RsV.next()){
            String numero = RsV.getString("numero");
            listVoituresDS.addItem(numero);
        }
    }
    public static String separateurNomID(String nomID){
        final String separateur = " - ";
        String tmp[] = nomID.split(separateur);
        String idLoc ="";
        for(int i=0; i<1; i++){
            idLoc=idLoc.concat(tmp[i]);
        }
        return idLoc;
    }
    public static String separateurStringId(String nomID){
        final String separateur = " - ";
        String tmp[] = nomID.split(separateur);
        String idLoc ="";
        for(int i=1; i<2; i++){
            idLoc=idLoc.concat(tmp[i]);
        }
        return idLoc;
    }
    public static String voitureCastEnString(ResultSet RsV) throws SQLException{
        String tmp="";
        while(RsV.next()){
            String numVtr = RsV.getString("id");
            tmp= tmp.concat(numVtr);
        }
        return tmp;
    }
    public static String voitureEtat(ResultSet RsV) throws SQLException{
        String tmp="";
        while(RsV.next()){
            String etatVtr = RsV.getString("etat");
            tmp= tmp.concat(etatVtr);
        }
        return tmp;
    }
    public static int depFonctNumeroIM(ResultSet RsV, String numVtr) throws SQLException{
        int i=0;
        while(RsV.next()){
            String tmp = RsV.getString("numero");
            if(tmp.equals(numVtr)){i++;}
        }
        return i;
    }
    public static int depFonctNumeroIMenModif(ResultSet RsV2, int id) throws SQLException{
        int i=0;
        String vraiNumero = null;
        while(RsV2.next()){
            vraiNumero = RsV2.getString("id");
        }
        
        if(id!=Integer.parseInt(vraiNumero)){
            i++;
            return  i;
        }
        return i;
    }
    public static int verifEtatVtr(ResultSet RsVerif) throws SQLException{
        int i=0;
        while(RsVerif.next()){
            String etatDispo = RsVerif.getString("voitures.etat");
            if(!etatDispo.equalsIgnoreCase("DISPO")){
                i++;
                return i;
            }
        }
        return i;
    }
    public static int recupIDVoiture(ResultSet RsV) throws SQLException{
        int i=0;
        while(RsV.next()){
            String idVtr = RsV.getString("id_voiture");
            i=Integer.parseInt(idVtr);
        }
        return i;
    }
    
    private void deplace(int i){
        try{ 
            idLocDesign.setText(separateurStringId(model.getValueAt(i, 0).toString()));
            nomLocDesign.setText(model.getValueAt(i, 1).toString());
        }
        catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "erreur de deplacement "+e.getLocalizedMessage());
        }
    }
    private void deplaceVoiture(int i){
        try{
            idVDS.setText(separateurStringId(modelV.getValueAt(i, 0).toString()));
            numVDS.setText(modelV.getValueAt(i, 1).toString());
            desgVDS.setText(modelV.getValueAt(i, 2).toString());
            puVDS.setText(modelV.getValueAt(i, 3).toString());
            stockVDS.setText(modelV.getValueAt(i, 4).toString());
        }
        catch(Exception e){
            System.err.println(e);
//            JOptionPane.showMessageDialog(null, "erreur de deplacement "+e.getLocalizedMessage());
        }
    }
    
    private void deplaceLouer(int i){
        try{
            idLDS.setText(separateurStringId(Lmodel.getValueAt(i, 0).toString()));
            
            // RECUPERER L'ID VOITURE ET LOCATAIRE ET L'AFFICHER SUR LE JCOMBOBOX
            ResultSet foreignLocID=stm.executeQuery("Select id,nom from client where "
                    + "id='"+separateurStringId(Lmodel.getValueAt(i, 1).toString())+"'");
            ResultSet foreignVtrID=stmV.executeQuery("Select numero from voiture where "
                    + "numero='"+Lmodel.getValueAt(i, 3).toString()+"'");
            foreignLouerID(foreignLocID, foreignVtrID);
            
            qteLDS.setText(Lmodel.getValueAt(i, 4).toString());
            // RECUPERER La DATE L'AFFICHER SUR LE JDATECHOSER
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse((String)Lmodel.getValueAt(i, 5).toString());
            jDateLDS.setDate(date);
            
        }
        catch(Exception e){
            System.err.println(e);
            afficherNotificationErreur("erreur de deplacement "+e.getLocalizedMessage());
        }
    }
    private void rechercheDeplace(int i){
        try{
            idLocDesign.setText(model.getValueAt(i, 0).toString());
            nomLocDesign.setText(model.getValueAt(i, 1).toString());
        }
        catch(Exception e){}
    }
    private void rechercheDeplaceVoiture(int i){
        try{
            idVDS.setText(modelV.getValueAt(i, 0).toString());
            numVDS.setText(modelV.getValueAt(i, 1).toString());
            desgVDS.setText(modelV.getValueAt(i, 2).toString());
            puVDS.setText(modelV.getValueAt(i, 3).toString());
            stockVDS.setText(modelV.getValueAt(i, 4).toString());
        }
        catch(Exception e){}
    }
    private void rechercheDeplaceLouer(int i){
        try{
            idLDS.setText(Lmodel.getValueAt(i, 0).toString());
            listLocatairesDS.setSelectedItem(Lmodel.getValueAt(i, 1).toString());
            listVoituresDS.setSelectedItem(Lmodel.getValueAt(i, 2).toString());
            qteLDS.setText(Lmodel.getValueAt(i, 3).toString());
            jDateLDS.setDateFormatString(Lmodel.getValueAt(i, 4).toString());
        }
        catch(Exception e){}
    }
    
    private void afficherListe(){
        try{
            model.setRowCount(0);
            stm=conn.ObtenirConnections().createStatement();
            ResultSet Rs=stm.executeQuery("Select * from client ORDER BY id DESC");
            while(Rs.next()){
                model.addRow(new Object[]{
                    "Cli - "+Rs.getString("id"),
                    Rs.getString("nom")});
            }
            idLocDesign.setText("");                                            
            nomLocDesign.setText("");                                 
            nomLocDesignRechrch.setText("");
        }
        catch(Exception e){System.err.println(e);}
        tableEnDesign.setModel(model);
    }
    private void afficherListeVoiture(){
        try{
            modelV.setRowCount(0);
            stmV=connV.ObtenirConnections().createStatement();
            ResultSet RsV=stmV.executeQuery("Select * from voiture ORDER BY id DESC");
            
            while(RsV.next()){
                /*ATAO MTOVY AM'NY MYSQL ny VARIABLE N'CHAMP ID NOM ADRESS*/
                modelV.addRow(new Object[]{
                    "Voiture - "+RsV.getString("id"),
                    RsV.getString("numero"),
                    RsV.getString("marque"),
                    RsV.getString("pu"),
                    RsV.getString("stock")});
            }
            idVDS.setText(""); 
            numVDS.setText("");                                            
            desgVDS.setText("");                                            
            puVDS.setText("");                                             
            stockVDS.setText("");                          
            numDesignRechrchVoiture.setText("");
        }
        catch(Exception e){System.err.println(e);}
        tableVoitureEnDesign.setModel(modelV);
    }
    private void afficherListeLouer(){
        try{
            Lmodel.setRowCount(0);
            stmL=connL.ObtenirConnections().createStatement();
            ResultSet RsL =stmL.executeQuery("SELECT vente.id, client.id, client.nom, voiture.numero, "
                    + "qte, DATE_FORMAT(date, '%d-%m-%Y') FROM vente, client, voiture WHERE "
                    + "client.id=vente.idCli AND voiture.id=vente.idVtr "
                    + "ORDER BY vente.id DESC;");
            /*REUPPERATION DE TOUTES LES LISTES DE VOITURES ET DE CLIENTS*/
            ResultSet foreignLocID=stm.executeQuery("Select id,nom from client ORDER BY id DESC");
            ResultSet foreignVtrID=stmV.executeQuery("Select numero from voiture ORDER BY id DESC");
            while(RsL.next()){
                Lmodel.addRow(new Object[]{
                    "N# - "+RsL.getString("vente.id"),
                    "Cli - "+RsL.getString("client.id"),
                    RsL.getString("client.nom"),
                    RsL.getString("voiture.numero"),
                    RsL.getString("qte"),
                    RsL.getString("DATE_FORMAT(date, '%d-%m-%Y')")});
            }
            
            foreignLouerID(foreignLocID, foreignVtrID);
            idLDS.setText("");                                
            qteLDS.setText("");
            Date date = new Date();
            jDateLDS.setDate(date);
            jdateUn.setDate(date);            
            jdateDeux.setDate(date);
            rechercheTapantLouer.setText("");

        }
        catch(Exception e){System.err.println(e);}
        tableLouerEnDesign.setModel(Lmodel);
    }
    
    private void effacerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacerBTNActionPerformed
        champNomUtilisateur.setText(null);
        champMotdePasse.setText(null);
    }//GEN-LAST:event_effacerBTNActionPerformed

    private void quitterBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterBTNActionPerformed
        // NOTIFICATION PERSONNALISER PAR MOI
        afficherNotificationDefault("Application Quitter ! A bientot.");
        System.exit(0);
    }//GEN-LAST:event_quitterBTNActionPerformed

    private void seconnecterBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seconnecterBTNActionPerformed
        String utilisateur = champNomUtilisateur.getText();                                             
        String motdepasse = champMotdePasse.getText();
        
        if(utilisateur.contains("admin") && motdepasse.contains("admin")){
            champNomUtilisateur.setText(null);
            champMotdePasse.setText(null);
            afficherNotificationSuccess("Bienvenu, Vous etes Connecté...");
            systemExit();
            pageParent.removeAll();
            pageParent.add(pageGLV);
            pageParent.repaint();
            pageParent.revalidate();
             afficherListeVoiture();
        }else{
//            JOptionPane.showMessageDialog(null, "Information Incorrect !", "Echec de Connection", JOptionPane.ERROR_MESSAGE);
            afficherNotificationErreur("Information Incorrect ! Echec de Connection!");
            champNomUtilisateur.setText(null);
            champMotdePasse.setText(null);
        }
    }//GEN-LAST:event_seconnecterBTNActionPerformed

    private void voituresNavBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voituresNavBarMouseClicked
        pageGLVContenu.removeAll();
        pageGLVContenu.add(voituresPage);
        pageGLVContenu.repaint();
        pageGLVContenu.revalidate();
        afficherListeVoiture();
    }//GEN-LAST:event_voituresNavBarMouseClicked

    private void locatairesNavBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locatairesNavBarMouseClicked
        pageGLVContenu.removeAll();
        pageGLVContenu.add(locatairesPage);
        pageGLVContenu.repaint();
        pageGLVContenu.revalidate();
        afficherListe();
    }//GEN-LAST:event_locatairesNavBarMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        pageGLVContenu.removeAll();
        pageGLVContenu.add(louerPage);
        pageGLVContenu.repaint();
        pageGLVContenu.revalidate();
        afficherListeLouer();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void quitterNavBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitterNavBarMouseClicked
        afficherNotificationSuccess("Vous avez quitter votre session, vous ete Deconnecte ...");
        pageParent.removeAll();
        pageParent.add(loginPage);
        pageParent.repaint();
        pageParent.revalidate();
    }//GEN-LAST:event_quitterNavBarMouseClicked

    private void nomLocDesignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomLocDesignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomLocDesignActionPerformed

    private void idLocDesignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idLocDesignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idLocDesignActionPerformed

    private void tableEnDesignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEnDesignMouseClicked
        try{
            int i=tableEnDesign.getSelectedRow();
            deplace(i);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"erreur de ONCLICKMOUSETABLE "+ e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tableEnDesignMouseClicked

    private void ajouterLocataireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterLocataireActionPerformed
        String id = idLocDesign.getText();
        String nom = nomLocDesign.getText();
        String requete;
        if(idLocDesign.getText().isEmpty()){
            requete = "insert into client(id, nom) "
            + "VALUES (NULL,'"+nom+"')";
        }else{
            requete = "insert into client(id, nom) "
            + "VALUES ('"+id+"','"+nom+"')";
        }
        try{
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Ajouter Reussi");
            afficherListe();
            
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "erreur d'AJOUT "+ e.getMessage());
        }
    }//GEN-LAST:event_ajouterLocataireActionPerformed

    private void supprimerLocataireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerLocataireActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(null, "Etes vous sur de vouloir Supprimer ?",
                "Supprimer",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
            if(idLocDesign.getText().length() != 0){
                
                stmL.executeUpdate("DELETE FROM vente WHERE "
                                + "idCli='"+idLocDesign.getText()+"' ");
                stm.executeUpdate("DELETE FROM client WHERE "
                    + "id='"+idLocDesign.getText()+"' ");
                afficherListe();
                JOptionPane.showMessageDialog(null, "SUPPRESION REUSSI");
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Veuilliez Selectionner!");
            }
        }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erreur pendant la SUPPRESSION " +e.getMessage());
        }
    }//GEN-LAST:event_supprimerLocataireActionPerformed

    private void rechercherLocataireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherLocataireActionPerformed
        try{
            model.setRowCount(0); //pour vider la liste des Locataire
            {
                Rs = stm.executeQuery("SELECT * FROM client WHERE "
                    + "nom = '"+nomLocDesignRechrch.getText()+"'");
            }while(Rs.next()){
                Object[] locataire = {
                    Rs.getString(1),
                    Rs.getString(2),
                };
                model.addRow(locataire);
            }
            if(model.getRowCount() == 0){
                
            }
            else{
                int i=0;
                deplace(i);
            }
        }catch(SQLException | HeadlessException e){System.err.println("e");}
    }//GEN-LAST:event_rechercherLocataireActionPerformed

    private void nomLocDesignRechrchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomLocDesignRechrchKeyTyped
        try{
            model.setRowCount(0); //pour vider la liste des Locataire
            {
                Rs = stm.executeQuery("SELECT * FROM client WHERE "
                    + "nom LIKE '%"+nomLocDesignRechrch.getText()+"%'");
            }while(Rs.next()){
                Object[] locataire = {
                    "Loc - "+Rs.getString(1),
                    Rs.getString(2),
                };
                model.addRow(locataire);
            }
            if(model.getRowCount() == 0){
            }
            else{
                int i=0;
                rechercheDeplace(i);
            }
        }catch(Exception e){System.err.println(e); JOptionPane.showMessageDialog(null,e.getMessage());}
    }//GEN-LAST:event_nomLocDesignRechrchKeyTyped

    private void modifierLocataireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierLocataireActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(null, "Confirmer la modification", "modification",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                if(idLocDesign.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Numero non Trouver !");
                    afficherListe();
                }else{
                    stm.executeUpdate("UPDATE client SET "
                        + "nom='"+nomLocDesign.getText()+"' "
                        + "WHERE id='"+idLocDesign.getText()+"' ");
                    afficherListe();
                    JOptionPane.showMessageDialog(null, "MODIFICATION REUSSI.");
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erreur pendant la MODIFICATION " +e.getMessage());
        }
    }//GEN-LAST:event_modifierLocataireActionPerformed

    private void actualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualiserActionPerformed
        afficherListe();
    }//GEN-LAST:event_actualiserActionPerformed

    private void aideBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aideBTNActionPerformed
        afficherNotificationOrange("Nous vous contacterons bientot. Veuillez patienter un peu s'il vous plait...");
    }//GEN-LAST:event_aideBTNActionPerformed

    private void idVDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idVDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idVDSActionPerformed

    private void puVDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puVDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puVDSActionPerformed

    private void ajouterVoitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterVoitureActionPerformed
        String id = idVDS.getText();
        String numeroIM = numVDS.getText();
        String designation = desgVDS.getText();
        String loyerJ = puVDS.getText();
        String stock = stockVDS.getText();
        String requete;
        
        ResultSet RsV = null;
        try {RsV = stmV.executeQuery("Select numero from voiture ORDER BY id DESC");} 
        catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
        try {
            if(depFonctNumeroIM(RsV,numeroIM)==0){
                if(idVDS.getText().isEmpty()){
                    requete = "insert into voiture(id, numero, marque, pu, stock) "
                            + "VALUES (NULL,'"+numeroIM+"','"+designation+"','"+loyerJ+"','"+stock+"')";
                }else{
                    requete = "insert into voitures(id, numero, designation, etat, loyerJ) "
                            + "VALUES ('"+id+"','"+numeroIM+"','"+designation+"','"+loyerJ+"','"+stock+"')";
                }
                try{
                    stmV.executeUpdate(requete);
                    afficherNotificationSuccess("Ajouter REUSSI");
                    afficherListeVoiture();

                }catch(SQLException | HeadlessException e){
                    afficherNotificationErreur("Il y a une Erreur lors de l'Ajout du Nouveau Voiture !"+ e.getMessage());
                }
            }else{afficherNotificationErreur("IMMATRICULE VOITURE EXISTANT DEJA !");}
        } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
        
    }//GEN-LAST:event_ajouterVoitureActionPerformed

    private void supprimerVoitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerVoitureActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(null, "Etes vous sur de vouloir Supprimer ce Voiture ?",
                "Supprimer la Voiture",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                    if(idVDS.getText().length() != 0){
                        stmL.executeUpdate("DELETE FROM vente WHERE "
                                + "idVtr='"+idVDS.getText()+"' ");
                        stmV.executeUpdate("DELETE FROM voiture WHERE "
                            + "id='"+idVDS.getText()+"'");
                        afficherListeVoiture();
                        afficherNotificationSuccess("La Voiture a bien ete Effacer de la Base de Donnee.");
                        
                    }
                    else{
                        afficherNotificationErreur("Veuilliez Selectionner une Voiture !");
                    }
            }
        }catch(Exception e){
            afficherNotificationErreur("Erreur de suppression du Voiture ! "+ e.getMessage());
        }
    }//GEN-LAST:event_supprimerVoitureActionPerformed

    private void rechercherVoitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherVoitureActionPerformed
        try{
            modelV.setRowCount(0); //pour vider la liste des Locataire
            {
                RsV = stmV.executeQuery("SELECT * FROM voiture WHERE "
                    + "numero = '"+numDesignRechrchVoiture.getText()+"' "
                    + "OR marque LIKE '%"+numDesignRechrchVoiture.getText()+"%' ORDER BY id DESC");
            }while(RsV.next()){
                Object[] voiture = {
                    RsV.getString(1),
                    RsV.getString(2),
                    RsV.getString(3),
                    RsV.getString(4),
                    RsV.getString(5),
                };
                modelV.addRow(voiture);
            }
            if(modelV.getRowCount() == 0){
                afficherNotificationErreur("Ce Voiture n'est pas disponible dans notre Base de Donnee !");    
            }
            else{
                int i=0;
                deplaceVoiture(i);
            }
        }catch(SQLException | HeadlessException e){System.err.println("e"); JOptionPane.showMessageDialog(null,e.getMessage());}
    }//GEN-LAST:event_rechercherVoitureActionPerformed

    private void modifierVoitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierVoitureActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(null, "Confirmer la modification", "modification",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                if(idVDS.getText().isEmpty()){
                    afficherNotificationErreur("Identifiant du Voiture non Trouver !");
                    afficherListeVoiture();
                }else{
                        //VALEUR BOOLEAN VERIFIER SI LE MATRICULE DEMANDER EXISTE DEJA
                        boolean matricule = true; 
                        // VARIABLE RESULTSET POUR COMPARER L'IM AVEC TOUT LES M DE LA BDD
                        ResultSet RsV = null;
                        try {RsV = stmV.executeQuery("Select numero from voiture ORDER BY id DESC");} 
                        catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                        
                        // APPEL FONCTION QUI COMPARE L'IM AVEC TOUT L'IM DE LA BDD
                        if(depFonctNumeroIM(RsV,numVDS.getText()) !=0 ){
                            // S'IL Y A CORRESPONDANSE ON "FALSE" D'ABORD
                            matricule = false;
                            
                            /* ENSUITE ON CREE UNE AUTRE RESULTATSET POUR VOIR SI LA CORRESPONDANCE 
                            TROUVE N'EST PAS LE NUMERO D'IM D'ORIGINE*/
                            ResultSet RsV2 = null;
                            
                            try {RsV2 = stmV.executeQuery("Select id from voiture WHERE numero='"+numVDS.getText()+"'");} 
                            catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                            
                            /* APPEL DE FONCTION POUR VERIFIER L'ID DU MATRICULATION SUR LE CHAMP JLABEL ET 
                            L'ID DU CHAMP JLABEL VOITURE A MODIFIER */
                            int verifVraiNum = depFonctNumeroIMenModif(RsV2,Integer.parseInt(idVDS.getText()));
                            
                            if(verifVraiNum==0){
                                /*CECI IMPLIQUE QUE LA CORRESPONDANCE TROUVER ULTERIEUREMENT
                                N'EST AUTRES QUE L'IM ORIGINALE DU VEHICULE DONC VRAI*/
                                /*PLUS SIMPLEMENT: ICI ON A PAS TOUCHE LE CHAMPS JLABEL MAIS 
                                C'EST LES AUTRES CHAMP QU'ON VEUT MODIFIER VIA MYSQL*/
                                matricule = true;
                            }
                        }
                        /*IF MATRICULE == TRUE ALORS GO EXECUTEQUERY*/
                        if(matricule){
                            stmV.executeUpdate("UPDATE voiture SET "
                                    + "numero='"+numVDS.getText()+"',"
                                    + "marque='"+desgVDS.getText()+"',"
                                    + "pu='"+puVDS.getText()+"', "
                                    + "stock='"+stockVDS.getText()+"' "
                                    + "WHERE id='"+idVDS.getText()+"' ");
                            afficherListeVoiture();
                            afficherNotificationSuccess("La Voiture a bien ete Modifier.");
                        }
                        else{afficherNotificationErreur("IMMATRICULE VOITURE EXISTANT DEJA !");}
                    
                }
            }
        }catch(HeadlessException | SQLException e){
            afficherNotificationErreur("Erreur de Modification du Voiture ! "+ e.getMessage());
        }
    }//GEN-LAST:event_modifierVoitureActionPerformed

    private void actualiserVoitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualiserVoitureActionPerformed
        afficherListeVoiture();
    }//GEN-LAST:event_actualiserVoitureActionPerformed

    private void tableVoitureEnDesignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVoitureEnDesignMouseClicked
        try{
            int i=tableVoitureEnDesign.getSelectedRow();
            deplaceVoiture(i);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"erreur de ONCLICKMOUSETABLE "+ e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tableVoitureEnDesignMouseClicked

    private void numVDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numVDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numVDSActionPerformed

    private void desgVDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desgVDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desgVDSActionPerformed

    private void numDesignRechrchVoitureKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numDesignRechrchVoitureKeyTyped
        try{
            modelV.setRowCount(0); //pour vider la liste des Locataire
            {
                RsV = stmV.executeQuery("SELECT * FROM voiture WHERE "
                    + "numero LIKE '%"+numDesignRechrchVoiture.getText()+"%'"
                            + "OR marque LIKE '%"+numDesignRechrchVoiture.getText()+"%' "
                            + "ORDER BY id DESC");
            }while(RsV.next()){
                Object[] voiture = {
                    "Voiture - "+RsV.getString(1),
                    RsV.getString(2),
                    RsV.getString(3),
                    RsV.getString(4),
                    RsV.getString(5),

                };
                modelV.addRow(voiture);
            }
            if(modelV.getRowCount() == 0){
//                System.err.println("okkkk");
            }
            else{
                int i=0;
                rechercheDeplaceVoiture(i);
            }
        }catch(Exception e){System.err.println(e); afficherNotificationErreur("Non trouver"+e.getMessage());}
    }//GEN-LAST:event_numDesignRechrchVoitureKeyTyped

    private void tableLouerEnDesignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLouerEnDesignMouseClicked
        try{
            int i=tableLouerEnDesign.getSelectedRow();
            deplaceLouer(i);
        }
        catch(Exception e){
            afficherNotificationErreur("erreur de ONCLICKMOUSETABLE "+ e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tableLouerEnDesignMouseClicked

    private void idLDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idLDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idLDSActionPerformed

    private void qteLDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qteLDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qteLDSActionPerformed

    private void ajouterNouvelleLocVtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterNouvelleLocVtrActionPerformed
        String id = idLDS.getText();
        String nbjour = qteLDS.getText();
        
        //RECUPERER L'ID DU LOCATAIRE
        String idLoc = separateurNomID(listLocatairesDS.getSelectedItem().toString());
        
        // RECUPERER L'ID DU VEHICULE ET SON ETAT
        ResultSet foreignVtrID = null;
        ResultSet etatVtr = null;
        String idVtr = null;
        String etatVoiture = null;
        try {
            foreignVtrID = stmV.executeQuery("SELECT id FROM voiture WHERE "
                    + "numero='"+listVoituresDS.getSelectedItem().toString()+"'");
        } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
        try {
            idVtr = voitureCastEnString(foreignVtrID);
        } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
        
        
        //RECUPERER LA DATE SELECTIONNER
        String dateLoc = new SimpleDateFormat("yyyy-MM-dd").format(jDateLDS.getDate());
        
        //EXECUTER LA REQUETER MYSQL
        String requete;
        
        if(qteLDS.getText().isEmpty()){afficherNotificationErreur("Veuillez remplir le champ Qte !");}
        else{
            if(Integer.parseInt(qteLDS.getText())<=0){afficherNotificationErreur("ECHEC : Qte <=0 !");}
            else{
                    if(idLDS.getText().isEmpty()){
                        requete = "INSERT INTO vente(id, idCli, idVtr, qte, date) "
                        + "VALUES (NULL,'"+idLoc+"','"+idVtr+"','"+nbjour+"','"+dateLoc+"')";
                    }else{
                        requete = "INSERT INTO vente(id, idCli, idVtr, qte, date) "
                        + "VALUES ('"+id+"','"+idLoc+"','"+idVtr+"','"+nbjour+"','"+dateLoc+"')";
                    }
                    try{
                        stmL.executeUpdate(requete);
                        afficherNotificationSuccess("VENTE REUSSI");
                        afficherListeLouer();

                    }catch(SQLException | HeadlessException e){
                        afficherNotificationErreur("ECHEC DE LA VENTE! "+ e.getMessage());
                    }
                
            }
        }
    }//GEN-LAST:event_ajouterNouvelleLocVtrActionPerformed

    private void supprimerLocVtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerLocVtrActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(null, "Etes vous sur de vouloir Supprimer LE ?",
                "Supprimer la vente de  Voiture",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
            if(idLDS.getText().length() != 0){
                //RECUPERER L'ID DU VEHICULE
                ResultSet foreignVtrID = null;
                String idVtr = null;
                try {
                    foreignVtrID = stmV.executeQuery("SELECT id FROM voiture WHERE "
                            + "numero='"+listVoituresDS.getSelectedItem().toString()+"'");
                } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                try {
                    idVtr = voitureCastEnString(foreignVtrID);
                } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                
                //EXECUTION DES REQUETES MYSQL
                stmL.executeUpdate("DELETE FROM vente WHERE "
                    + "id='"+idLDS.getText()+"' ");
                afficherListeLouer();
                afficherNotificationSuccess("SUPPRESSION REUSSI");
            }
            else{
                afficherNotificationErreur("Veuilliez Selectionner une Voiture !");
            }
        }
        }catch(Exception e){
            afficherNotificationErreur("Erreur lors de la suppression du Location de Voiture ! "+ e.getMessage());
        }
    }//GEN-LAST:event_supprimerLocVtrActionPerformed

    private void rechercherEntreDeuxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherEntreDeuxDateActionPerformed
        try{
            Lmodel.setRowCount(0); 
            stmL=connL.ObtenirConnections().createStatement();
            
            ResumModel.setRowCount(0); 
            stmResum=connResum.ObtenirConnections().createStatement();
            
            //RECUPERER DES DATES CHOISIE
            String date1 = new SimpleDateFormat("yyyy-MM-dd").format(jdateUn.getDate());
            String date2 = new SimpleDateFormat("yyyy-MM-dd").format(jdateDeux.getDate());
 
            ResultSet RsL = stmL.executeQuery("SELECT vente.id, client.id, client.nom, voiture.numero, "
                    + "qte, DATE_FORMAT(date, '%d-%m-%Y') FROM vente, client, voiture WHERE "
                    + "client.id=vente.idCli AND voiture.id=vente.idVtr "
                    + "AND vente.date BETWEEN  '"+date1+"'"
                    + "AND '"+date2+"' ORDER BY vente.id DESC ");
            
            while(RsL.next()){
                Lmodel.addRow(new Object[]{
                    "N# - "+RsL.getString("vente.id"),
                    "Cli - "+RsL.getString("client.id"),
                    RsL.getString("client.nom"),
                    RsL.getString("voiture.numero"),
                    RsL.getString("qte"),
                    RsL.getString("DATE_FORMAT(date, '%d-%m-%Y')")});
            }
            
            if(Lmodel.getRowCount() == 0){
                afficherNotificationErreur("LA LISTE EST VIDE !");  
            }
        }catch(SQLException | HeadlessException e){
            afficherNotificationErreur("on trouver "+e.getMessage());
        }
        tableLouerEnDesign.setModel(Lmodel);
    
    }//GEN-LAST:event_rechercherEntreDeuxDateActionPerformed

    private void modifierLocVtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierLocVtrActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(null, "Confirmer la modification", "modification",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                if(idLDS.getText().isEmpty()){
                    afficherNotificationErreur("Identifiant de venteVoiture non Trouver !");
                    afficherListeLouer();
                }else{
                    if(qteLDS.getText().isEmpty()){afficherNotificationErreur("Veuillez remplir le champ Qte !");}
                    else{
                            // RECUPERER LA DATE SELECTIONNER + L'ID DU LOCATAIRE + DU VEHICULE 
                            String dateLoc = new SimpleDateFormat("yyyy-MM-dd").format(jDateLDS.getDate());
                            String idLoc = separateurNomID(listLocatairesDS.getSelectedItem().toString());

                            ResultSet foreignVtrID = null;
                            String idVtr = null;
                            try {
                                foreignVtrID = stmV.executeQuery("SELECT id FROM voiture WHERE "
                                        + "numero='"+listVoituresDS.getSelectedItem().toString()+"'");
                            } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                            try {
                                idVtr = voitureCastEnString(foreignVtrID);
                            } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}

                            stmL.executeUpdate("UPDATE vente SET "
                                + "idCli='"+idLoc+"',"
                                + "idVtr='"+idVtr+"',"
                                + "qte='"+qteLDS.getText()+"',"
                                + "date='"+dateLoc+"' "
                                + "WHERE id='"+idLDS.getText()+"' ");
                            afficherListeLouer();
                            afficherNotificationSuccess("La venteVoiture a bien ete Modifier.");
                        
                    }
                }
            }
        }catch(HeadlessException | SQLException e){
            afficherNotificationErreur("Il y a une Erreur lors de la Modification  venteVoiture ! "+ e.getMessage());
        }
    }//GEN-LAST:event_modifierLocVtrActionPerformed

    private void actualiserLouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualiserLouerActionPerformed
        afficherListeLouer();
    }//GEN-LAST:event_actualiserLouerActionPerformed

    private void rechercheTapantLouerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheTapantLouerKeyTyped
        try {
            Lmodel.setRowCount(0);
            {
                RsL = stmL.executeQuery("SELECT vente.id, client.id, client.nom, voiture.numero, "
                        + "qte, DATE_FORMAT(date, '%d-%m-%Y') FROM vente, client, voiture WHERE "
                        + "client.id=vente.idCli AND voiture.id=vente.idVtr "
                        + "AND (client.nom LIKE '%"+rechercheTapantLouer.getText()+"%' "
                        + "OR voiture.numero LIKE '%"+rechercheTapantLouer.getText()+"%') "
                        + "ORDER BY vente.id DESC ");
            }
            
            while(RsL.next()){
                Object[] louer = {
                    "N# - "+RsL.getString("vente.id"),
                    "Loc - "+RsL.getString("client.id"),
                    RsL.getString("client.nom"),
                    RsL.getString("voiture.numero"),
                    RsL.getString("qte"),
                    RsL.getString("DATE_FORMAT(date, '%d-%m-%Y')"),
                };
                Lmodel.addRow(louer);
            }
        }  catch (Exception e) {afficherNotificationErreur("ERREUR : "+e); }
    }//GEN-LAST:event_rechercheTapantLouerKeyTyped

    private void stockVDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockVDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockVDSActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualiser;
    private javax.swing.JButton actualiserLouer;
    private javax.swing.JButton actualiserVoiture;
    private javax.swing.JButton aideBTN;
    private javax.swing.JButton ajouterLocataire;
    private javax.swing.JButton ajouterNouvelleLocVtr;
    private javax.swing.JButton ajouterVoiture;
    private javax.swing.JPasswordField champMotdePasse;
    private javax.swing.JTextField champNomUtilisateur;
    private javax.swing.JTextField desgVDS;
    private javax.swing.JButton effacerBTN;
    private javax.swing.JTextField idLDS;
    private javax.swing.JTextField idLocDesign;
    private javax.swing.JTextField idVDS;
    private com.toedter.calendar.JDateChooser jDateLDS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdateDeux;
    private com.toedter.calendar.JDateChooser jdateUn;
    private javax.swing.JComboBox listLocatairesDS;
    private javax.swing.JComboBox listVoituresDS;
    private javax.swing.JLabel locatairesNavBar;
    private javax.swing.JPanel locatairesPage;
    private javax.swing.JPanel loginPage;
    private javax.swing.JPanel louerPage;
    private javax.swing.JButton modifierLocVtr;
    private javax.swing.JButton modifierLocataire;
    private javax.swing.JButton modifierVoiture;
    private javax.swing.JTextField nomLocDesign;
    private javax.swing.JTextField nomLocDesignRechrch;
    private javax.swing.JTextField numDesignRechrchVoiture;
    private javax.swing.JTextField numVDS;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel numero1;
    private javax.swing.JPanel pageGLV;
    private javax.swing.JPanel pageGLVContenu;
    private javax.swing.JPanel pageParent;
    private javax.swing.JTextField puVDS;
    private javax.swing.JTextField qteLDS;
    private javax.swing.JButton quitterBTN;
    private javax.swing.JLabel quitterNavBar;
    private javax.swing.JTextField rechercheTapantLouer;
    private javax.swing.JButton rechercherEntreDeuxDate;
    private javax.swing.JButton rechercherLocataire;
    private javax.swing.JButton rechercherVoiture;
    private javax.swing.JButton seconnecterBTN;
    private javax.swing.JTextField stockVDS;
    private javax.swing.JButton supprimerLocVtr;
    private javax.swing.JButton supprimerLocataire;
    private javax.swing.JButton supprimerVoiture;
    private javax.swing.JTable tableEnDesign;
    private javax.swing.JTable tableLouerEnDesign;
    private javax.swing.JTable tableVoitureEnDesign;
    private javax.swing.JLabel voituresNavBar;
    private javax.swing.JPanel voituresPage;
    // End of variables declaration//GEN-END:variables

    private void systemExit(){
        WindowEvent winCloseing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    }

    private Object SimpleDateFormat(String yyyyMMdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
