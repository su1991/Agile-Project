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
public class Volunteer extends javax.swing.JFrame {

    /**
     * Creates new form Volunteer
     */
    public Volunteer() {
       initComponents();
        Customers = new ArrayList<RegisteredDoner>();
        Applications = new ArrayList<VolunteerApplications>();
        CustomerState = new ArrayList<VolunteerState>();
        populateArrayList1();
    }
    
    private static final String username = "root";
    private static final String password = "1234567890";
    private static final String dataConn = "jdbc:mysql://localhost:3306/connector?autoReconnect=true&useSSL=false";
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int i,q,id, delteItem;
    
      Random r = new Random();
    
    
    ArrayList <RegisteredDoner> Customers;
    ArrayList <VolunteerApplications> Applications;
    ArrayList <VolunteerState> CustomerState;
  
    
    
    public void populateArrayList1()
    {
        try
        {
        
            FileInputStream file = new FileInputStream("src\\DataBase\\Cutomers.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
        boolean endOfFile = false;
        
        while (!endOfFile){
            
            try 
            {
              Customers.add((RegisteredDoner) inputFile.readObject());
                
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
              FileOutputStream file = new FileOutputStream("src\\DataBase\\Cutomers.dat");
              ObjectOutputStream outputFile = new ObjectOutputStream(file);
                
              
              for (int i=0; i<Customers.size(); i++){
                  
                  outputFile.writeObject(Customers.get(i));
                  
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
              FileOutputStream file = new FileOutputStream("src\\DataBase\\CustomerState.dat");
              ObjectOutputStream outputFile = new ObjectOutputStream(file);
                
              
              
                  
              outputFile.writeObject(CustomerState.get(0));
              
              
              FileWriter fw=new FileWriter("src\\DataBase\\CutomerState.txt"); 
              
             try 
            {
              
                   fw.write(CustomerState.get(0).CurrentCustomerState);
                   
                  
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
            pst = sqlConn.prepareStatement("select * from connector");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            //DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel(); ///////////////////
            //RecordTable.setRowCount(0);             ////////////////////////////////////////////////
            
            while(rs.next()){
                
                Vector columnData = new Vector();
                
                for (i =1; i<=q;i++){
                    
                    
                    columnData.add(rs.getShort("name"));
                    columnData.add(rs.getShort("password"));
                    columnData.add(rs.getShort("email"));
                   // columnData.add(rs.getShort("creditcard_number"));
                   // columnData.add(rs.getShort("Bank_account_number"));
                    columnData.add(rs.getShort("address"));
                    columnData.add(rs.getShort("phone number"));
                  //  columnData.add(rs.getShort("ID"));
                    
                    
                    
                }
                
               // RecordTable.addRow(columnData); /////////////////////////////////////////////
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
        PasswordText = new javax.swing.JPasswordField();
        Password = new javax.swing.JLabel();
        ConfirmPassword = new javax.swing.JLabel();
        ConfirmPasswordText = new javax.swing.JPasswordField();
        AddressText = new javax.swing.JTextField();
        EmailAddress = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JLabel();
        AddressOfShop = new javax.swing.JLabel();
        EmailText = new javax.swing.JTextField();
        Approved = new javax.swing.JLabel();
        UserNameText = new javax.swing.JTextField();
        UploadButton = new javax.swing.JButton();
        PhoneText = new javax.swing.JTextField();
        ApplyButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

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
        UploadText.setText("Uplaod an ID");
        UploadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadTextActionPerformed(evt);
            }
        });
        getContentPane().add(UploadText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 360, 30));

        PasswordText.setText("jPasswordField1");
        getContentPane().add(PasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 340, -1));

        Password.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        Password.setText("Major Department:");
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 110, -1));

        ConfirmPassword.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        ConfirmPassword.setText("Year Level:");
        getContentPane().add(ConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, -1));

        ConfirmPasswordText.setText("jPasswordField1");
        getContentPane().add(ConfirmPasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 340, -1));

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
        getContentPane().add(UserNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 340, -1));

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
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 450, -1));

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
        String Name = UserNameText.getText().trim();
        String Password = PasswordText.getText();
        String Email = EmailText.getText();
        String phoneNumber = PhoneText.getText();
        String PlaceAddress = AddressText.getText();

        int accNumberpart1 = r.nextInt(9999);
        int accNumberpart2 = r.nextInt(9999);
        int accNumberpart3 = r.nextInt(9999);
        int accNumberpart4 = r.nextInt(9999);

        int ccNumberpart1 = r.nextInt(9999);
        int ccNumberpart2 = r.nextInt(9999);
        int ccNumberpart3 = r.nextInt(9999);
        int ccNumberpart4 = r.nextInt(9999);

        String AccountNumber = (String.valueOf(accNumberpart1) + "-" + String.valueOf(accNumberpart2) +  "-"  + String.valueOf(accNumberpart3) +  "-"  + String.valueOf(accNumberpart4));

        String CreditCardNumber = (String.valueOf(ccNumberpart1) + "-" + String.valueOf(ccNumberpart2) +  "-"  + String.valueOf(ccNumberpart3) +  "-"  + String.valueOf(ccNumberpart4));

        String pin = "0000";

        boolean ErrorChecker0 = false;

        boolean ErrorChecker1 = true;
        boolean ErrorChecker2 = true;
        boolean ErrorChecker3 = true;
        boolean ErrorChecker4 = true;
        boolean ErrorChecker5 = true;
        boolean ErrorChecker6 = true;
        boolean ErrorChecker7 = true;
        boolean ErrorChecker8 = true;

        if (UploadText.getText().isEmpty() ||AddressText.getText().isEmpty() ||UserNameText.getText().isEmpty()||PhoneText.getText().isEmpty()||

            EmailText.getText().isEmpty() ||PasswordText.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "One of the Required fields is empty please fill it");
            ErrorChecker1 = false;

        }

        if (! PasswordText.getText().equals(ConfirmPasswordText.getText())){

            JOptionPane.showMessageDialog(null, "error, The passwords in the password and confirm password text fields dont match");
            ErrorChecker2 = false;

        }

        if (UserNameText.getText().length() < 10 ){

            JOptionPane.showMessageDialog(null, "error, The username should be atlease 10 characters long");
            ErrorChecker3 = false;
        }

        if (PasswordText.getText().length() < 10 ){

            JOptionPane.showMessageDialog(null, "error, The password should be atlease 10 characters long");
            ErrorChecker4 = false;
        }

        if (! EmailText.getText().contains("@") ){

            JOptionPane.showMessageDialog(null, "error, please enter a valid email");
            ErrorChecker5 = false;

        }

        if ( ! PhoneText.getText().startsWith("0") ){

            JOptionPane.showMessageDialog(null, "error, please enter a valid phone number");
            ErrorChecker6 = false;

        }

        if (  PhoneText.getText().length() < 9 ){

            JOptionPane.showMessageDialog(null, "error, please enter a valid phone number");
            ErrorChecker6 = false;

        }

        if (! UploadText.getText().contains(".pdf")){

            JOptionPane.showMessageDialog(null, "error, make sure you upload a pdf file");
            ErrorChecker7 = false;

        }

        if ( ErrorChecker1 == true && ErrorChecker2 == true && ErrorChecker3 == true && ErrorChecker4 == true && ErrorChecker5 == true && ErrorChecker6 == true && ErrorChecker7 == true) {

            try {

                int intValue = Integer.parseInt(PhoneText.getText());

            } catch(NumberFormatException e){

                JOptionPane.showMessageDialog(null, "error, please enter a valid phone number");

            }

            RegisteredDoner Customer = new RegisteredDoner(ApplicationNumber,Name, Password,Email,phoneNumber,PlaceAddress);

            Customer.setAccountNumber(AccountNumber);
            Customer.setCreditCardNumber(CreditCardNumber);
            Customer.setPinNumber(pin);

            Customers.add(Customer);
            saveCustomersToFile();
            JOptionPane.showMessageDialog(null, "Apllication# " + ApplicationNumber);

        }

        try
        {

            FileInputStream file = new FileInputStream("src\\DataBase\\Cutomers.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            FileWriter fw=new FileWriter("src\\DataBase\\CutomersData.txt");
            FileWriter fw2 = new FileWriter("src\\DataBase\\ManageApplicantsRequests.txt");

            for (int i=0;i<Customers.size();i++){

                try
                {

                    fw.write("\n" + Customers.get(i).getName() + "\n" + Customers.get(i).getEmail()+ "\n" + Customers.get(i).getPhoneNumber()+ "\n" + Customers.get(i).getPlaceAddress()+"\n" + Customers.get(i).getPassword() + "\n" + Customers.get(i).getAccountNumber() + "\n" + Customers.get(i).getCreditCardNumber() + "\n" + Customers.get(i).Balance );
                    fw2.write("\n" + Customers.get(i).getApplicationNumber() + "\n" + Customers.get(i).getName() + "\n" + Customers.get(i).getEmail()+ "\n" + Customers.get(i).getPhoneNumber()+ "\n" + Customers.get(i).getPlaceAddress()+"\n" + Customers.get(i).getPassword() + "\n");

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

        try {

            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("insert into connector(name,password,email,creditcard_number,Bank_account_number,address,ID)value(?,?,?,?,?,?,?)");

            pst.setString(1, UserNameText.getText());
            pst.setString(2, PasswordText.getText());
            pst.setString(3, EmailText.getText());
            pst.setString(4, "2345-4567-0987-4567");
            pst.setString(5, "5674-4879-4098-1324");
            pst.setString(6, AddressText.getText());
            int i = r.nextInt(999999);
            pst.setString(7, Integer. toString(i));

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
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Volunteer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressOfShop;
    private javax.swing.JTextField AddressText;
    private javax.swing.JButton ApplyButton;
    private javax.swing.JLabel ApplyLabel;
    private javax.swing.JLabel Approved;
    private javax.swing.JLabel ConfirmPassword;
    private javax.swing.JPasswordField ConfirmPasswordText;
    private javax.swing.JLabel EmailAddress;
    private javax.swing.JTextField EmailText;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField PasswordText;
    private javax.swing.JLabel PhoneNumber;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JLabel ShopsUserName;
    private javax.swing.JButton UploadButton;
    private javax.swing.JTextField UploadText;
    private javax.swing.JTextField UserNameText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
