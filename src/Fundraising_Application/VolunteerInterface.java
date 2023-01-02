/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fundraising_Application;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JhonsonTheGreat
 */
public class VolunteerInterface extends javax.swing.JFrame {

    /**
     * Creates new form Volunteer
     */
    public VolunteerInterface() {
       initComponents();
        Volunteers = new ArrayList<Volunteer>();
        Applications = new ArrayList<VolunteerApplications>();
        VolunteerState = new ArrayList<VolunteerState>();
        populateArrayList1();
    }
    
    private static final String username = "root";
    private static final String password = "1234567890";
    private static final String dataConn = "jdbc:mysql://localhost:3306/volunteer?autoReconnect=true&useSSL=false";
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int i,q,id, delteItem;
    
      Random r = new Random();
    
    
    ArrayList <Volunteer> Volunteers;
    ArrayList <VolunteerApplications> Applications;
    ArrayList <VolunteerState> VolunteerState;

    
  
    
    
    public void populateArrayList1()
    {
        try
        {
        
            FileInputStream file = new FileInputStream("src\\DataBase\\Volunteers.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
        boolean endOfFile = false;
        
        while (!endOfFile){
            
            try 
            {
              Volunteers.add((Volunteer) inputFile.readObject());
                
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
            catch (Exception f)
            {
             //JOptionPane.showMessageDialog(null, f.getMessage());
            }
        }
        
        inputFile.close();
        }
        catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        
    }
    
    public void saveCustomersToFile(){
         
            try 
            {
              FileOutputStream file = new FileOutputStream("src\\DataBase\\Volunteers.dat");
              ObjectOutputStream outputFile = new ObjectOutputStream(file);
                
              
              for (int i=0; i<Volunteers.size(); i++){
                  
                  outputFile.writeObject(Volunteers.get(i));
                  
              }
              
              outputFile.close();
              JOptionPane.showMessageDialog(null, "The Application was succefully submited to one of our Employees");
              JOptionPane.showMessageDialog(null, "please use the following Application number to check your application status later when employee reviews it");
             
             
              
  
             
            }
        
         catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    
    
    public void saveCustomerStateToFile(){
         
            try 
            {
              FileOutputStream file = new FileOutputStream("src\\DataBase\\VolunteerState.dat");
              ObjectOutputStream outputFile = new ObjectOutputStream(file);
                
              
              
                  
              outputFile.writeObject(VolunteerState.get(0));
              
              
              FileWriter fw=new FileWriter("src\\DataBase\\VolunteerState.txt"); 
              
             try 
            {
              
                   fw.write(VolunteerState.get(0).CurrentCustomerState);
                   
                  
            }
            catch (Exception f)
            {
             JOptionPane.showMessageDialog(null, f.getMessage());
            }
                  
              
              fw.close();
              outputFile.close();
              
              
             
            
             
            }
        
         catch (IOException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }

    
    
    
    public void upDateDB() throws ClassNotFoundException, SQLException{
        
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("select * from volunteer");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel(); ///////////////////
            RecordTable.setRowCount(0);             ////////////////////////////////////////////////
            
            while(rs.next()){
                
                Vector columnData = new Vector();
                
                for (i =1; i<=q;i++){
                    
                    
                    columnData.add(rs.getShort("ID"));
                    columnData.add(rs.getShort("Name"));
                    columnData.add(rs.getShort("Major"));
                    columnData.add(rs.getShort("Level"));
                    columnData.add(rs.getShort("Email"));
                    columnData.add(rs.getShort("PhoneNumber"));
                    columnData.add(rs.getShort("Address"));
                    columnData.add(rs.getShort("Documentation"));
                    
                    
                    
                    
                }
                
                RecordTable.addRow(columnData); /////////////////////////////////////////////
            } 
        } 
        
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ApplyLabel = new javax.swing.JLabel();
        ShopsUserName = new javax.swing.JLabel();
        UploadText = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        Levellabel = new javax.swing.JLabel();
        AddressText = new javax.swing.JTextField();
        EmailAddress = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JLabel();
        AddressOfShop = new javax.swing.JLabel();
        EmailText = new javax.swing.JTextField();
        Approved = new javax.swing.JLabel();
        UploadButton = new javax.swing.JButton();
        PhoneText = new javax.swing.JTextField();
        ApplyButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        LevelText = new javax.swing.JTextField();
        MajorText = new javax.swing.JTextField();
        NameText = new javax.swing.JTextField();

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fundraising_Application/template3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Apply to Volunteer");
        setAutoRequestFocus(false);
        setMinimumSize(new java.awt.Dimension(525, 550));
        setPreferredSize(new java.awt.Dimension(525, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ApplyLabel.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        ApplyLabel.setText("It's our our pleasure to have you sign up to Volunteer for us!");
        getContentPane().add(ApplyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 460, 30));

        ShopsUserName.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        ShopsUserName.setText("Full Name:");
        ShopsUserName.setToolTipText("");
        getContentPane().add(ShopsUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 70, -1));

        UploadText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        UploadText.setText("ID.pdf");
        UploadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadTextActionPerformed(evt);
            }
        });
        getContentPane().add(UploadText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 360, 30));

        Password.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        Password.setText("Major Department:");
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 110, -1));

        Levellabel.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        Levellabel.setText("Year Level:");
        getContentPane().add(Levellabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, -1));

        AddressText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        AddressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressTextActionPerformed(evt);
            }
        });
        getContentPane().add(AddressText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 340, -1));

        EmailAddress.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        EmailAddress.setText("       Email Adrress:");
        getContentPane().add(EmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 110, -1));

        PhoneNumber.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        PhoneNumber.setText("Phone Number:");
        getContentPane().add(PhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 90, -1));

        AddressOfShop.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        AddressOfShop.setText("Home Address:");
        getContentPane().add(AddressOfShop, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, 20));

        EmailText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        EmailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTextActionPerformed(evt);
            }
        });
        getContentPane().add(EmailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 340, -1));

        Approved.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        Approved.setText("Take notice that the  fomat acceptable for the submited documents shall be in the form of .PDF");
        getContentPane().add(Approved, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 470, 29));

        UploadButton.setText("Upload:");
        UploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UploadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 90, 30));

        PhoneText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        PhoneText.setText("002");
        PhoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextActionPerformed(evt);
            }
        });
        getContentPane().add(PhoneText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 340, -1));

        ApplyButton.setText("Apply!");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ApplyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 460, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fundraising_Application/template3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 450, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 480, 460, 30));
        getContentPane().add(LevelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 340, -1));
        getContentPane().add(MajorText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 340, -1));
        getContentPane().add(NameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 340, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UploadTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UploadTextActionPerformed

    private void AddressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressTextActionPerformed

    private void EmailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTextActionPerformed

    private void UploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        UploadText.setText(filename);
    }//GEN-LAST:event_UploadButtonActionPerformed

    private void PhoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextActionPerformed

    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed

        int ApplicationNumber = r.nextInt(9999);
        String Name = NameText.getText().trim();
        String Major = MajorText.getText();
        int Level = Integer.parseInt(LevelText.getText());
        String Email = EmailText.getText();
        String phoneNumber = PhoneText.getText();
        String Address = AddressText.getText();
        String Documentation = "xccxc//cxcxc//xcxcxc//Id.pdf";


        boolean ErrorChecker0 = false;

        boolean ErrorChecker1 = true;
        
        boolean ErrorChecker3 = true;
        boolean ErrorChecker4 = true;
        boolean ErrorChecker5 = true;
        boolean ErrorChecker6 = true;
        boolean ErrorChecker7 = true;
        boolean ErrorChecker8 = true;

        if (UploadText.getText().isEmpty() ||AddressText.getText().isEmpty() ||NameText.getText().isEmpty()||PhoneText.getText().isEmpty()||

            EmailText.getText().isEmpty() ||MajorText.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "One of the Required fields is empty please fill it");
            ErrorChecker1 = false;

        }

        


       
        try {

                int intValue = Integer.parseInt(PhoneText.getText());

            } catch(NumberFormatException e){

                JOptionPane.showMessageDialog(null, "error, please enter a valid phone number");

            }

            
            Volunteer Volunteer = new Volunteer(ApplicationNumber, Name, Major, Level, Email, phoneNumber, Address, Documentation);
            
            Volunteers.add(Volunteer);
            
            saveCustomersToFile();
            JOptionPane.showMessageDialog(null, "Apllication# " + ApplicationNumber);

        

        try
        {

            FileInputStream file = new FileInputStream("src\\DataBase\\Cutomers.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            FileWriter fw=new FileWriter("src\\DataBase\\CutomersData.txt");
            FileWriter fw2 = new FileWriter("src\\DataBase\\ManageApplicantsRequests.txt");

            for (int i=0;i<Volunteers.size();i++){

                try
                {

                    fw.write("\n" + Volunteers.get(i).getName() + "\n" + Volunteers.get(i).getEmail()+ "\n" + Volunteers.get(i).getPhoneNumber()+ "\n" + Volunteers.get(i).getAddress()+"\n" );
                    fw2.write("\n" + Volunteers.get(i).getApplicationNumber() + "\n" + Volunteers.get(i).getName() + "\n" + Volunteers.get(i).getEmail()+ "\n" + Volunteers.get(i).getPhoneNumber()+ "\n" + Volunteers.get(i).getAddress()+"\n" );

                }
                catch (Exception f)
                {
                    // JOptionPane.showMessageDialog(null, f.getMessage());
                }

            }
            fw.close();
            fw2.close();
            inputFile.close();
        }
        catch (IOException e){

            // JOptionPane.showMessageDialog(null, e.getMessage());

        }
        
        
        
        
         /////////////////////////////////////  SQL database  ////////////////////////

        try {

            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("insert into volunteer(ID, Name,Major,Level,Email,PhoneNumber,Address,Documentation)value(?,?,?,?,?,?,?,?)");

            
            int i = ApplicationNumber;
            pst.setString(1, Integer. toString(i));
            pst.setString(2, NameText.getText());
            pst.setString(3, MajorText.getText());
            pst.setString(4, LevelText.getText());
            pst.setString(5, EmailText.getText());
            pst.setString(6, PhoneNumber.getText());
            pst.setString(7, AddressText.getText());
            pst.setString(8, Documentation);
            

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Added");

            upDateDB();

        } catch (ClassNotFoundException ex){

            java.util.logging.Logger.getLogger(User_Signup_Interface.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);

        } catch (SQLException ex){

            java.util.logging.Logger.getLogger(User_Signup_Interface.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);

        }

    }//GEN-LAST:event_ApplyButtonActionPerformed

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
            java.util.logging.Logger.getLogger(VolunteerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VolunteerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VolunteerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VolunteerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VolunteerInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressOfShop;
    private javax.swing.JTextField AddressText;
    private javax.swing.JButton ApplyButton;
    private javax.swing.JLabel ApplyLabel;
    private javax.swing.JLabel Approved;
    private javax.swing.JLabel EmailAddress;
    private javax.swing.JTextField EmailText;
    private javax.swing.JTextField LevelText;
    private javax.swing.JLabel Levellabel;
    private javax.swing.JTextField MajorText;
    private javax.swing.JTextField NameText;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel PhoneNumber;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JLabel ShopsUserName;
    private javax.swing.JButton UploadButton;
    private javax.swing.JTextField UploadText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private String getApplicationNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getPhoneNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getPlaceAddress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
