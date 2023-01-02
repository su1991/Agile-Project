/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fundraising_Application;

import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.io.FileWriter;  
import  java.util.Random;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
/**imp
 *
 * @author hp
 */



public class User_Signup_Interface extends javax.swing.JFrame  {
    
    private static final String username = "root";
    private static final String password = "1234567890";
    private static final String dataConn = "jdbc:mysql://localhost:3306/registered_doner?autoReconnect=true&useSSL=false";
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int i,q,id, delteItem;
    
      Random r = new Random();
    
    
    ArrayList <RegisteredDoner> Customers;
    ArrayList <VolunteerApplications> Applications;
    ArrayList <VolunteerState> CustomerState;
  
    
    public User_Signup_Interface() {
        initComponents();
        Customers = new ArrayList<RegisteredDoner>();
        Applications = new ArrayList<VolunteerApplications>();
        CustomerState = new ArrayList<VolunteerState>();
        populateArrayList1();
    }

    
    
    
    
    
    
    
    
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
              
             
              
  
             
            }
        
         catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    
    
   

    
    
    
    public void upDateDB() throws ClassNotFoundException, SQLException{
        
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("select * from registered_doner");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel(); ///////////////////
            RecordTable.setRowCount(0);             ////////////////////////////////////////////////
            
            while(rs.next()){
                
                Vector columnData = new Vector();
                
                for (i =1; i<=q;i++){
                    
                    columnData.add(rs.getShort("ID"));
                    columnData.add(rs.getShort("Username"));
                    columnData.add(rs.getShort("Password"));
                    columnData.add(rs.getShort("Email"));
                    columnData.add(rs.getShort("Phone_Number"));
                    columnData.add(rs.getShort("Address"));
                    columnData.add(rs.getShort("Credit_Card_Number"));
                    columnData.add(rs.getShort("Bank_Account_Number"));
                    
                    
                  //  columnData.add(rs.getShort("ID"));
                    
                    
                    
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

        ApplyLabel = new javax.swing.JLabel();
        ShopsUserName = new javax.swing.JLabel();
        PasswordText = new javax.swing.JPasswordField();
        Password = new javax.swing.JLabel();
        ConfirmPassword = new javax.swing.JLabel();
        ConfirmPasswordText = new javax.swing.JPasswordField();
        AddressText = new javax.swing.JTextField();
        EmailAddress = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JLabel();
        AddressOfShop = new javax.swing.JLabel();
        EmailText = new javax.swing.JTextField();
        UserNameText = new javax.swing.JTextField();
        Already = new javax.swing.JLabel();
        LoginUserName = new javax.swing.JLabel();
        LoginUserNameText = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        ForgotButton = new javax.swing.JButton();
        LoginPasswordText = new javax.swing.JPasswordField();
        LoginPassword = new javax.swing.JLabel();
        PhoneText = new javax.swing.JTextField();
        ApplyButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CreditCardText = new javax.swing.JTextField();
        PhoneNumber1 = new javax.swing.JLabel();
        AddressOfShop1 = new javax.swing.JLabel();
        BankAccountText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Sign up");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(517, 700));
        getContentPane().setLayout(null);

        ApplyLabel.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        ApplyLabel.setText("It's our our pleasure to have you sign up with us!");
        getContentPane().add(ApplyLabel);
        ApplyLabel.setBounds(50, 120, 464, 50);

        ShopsUserName.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        ShopsUserName.setText("UserName:");
        ShopsUserName.setToolTipText("");
        getContentPane().add(ShopsUserName);
        ShopsUserName.setBounds(30, 170, 70, 17);

        PasswordText.setText("jPasswordField1");
        getContentPane().add(PasswordText);
        PasswordText.setBounds(140, 200, 340, 22);

        Password.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        Password.setText("Password:");
        getContentPane().add(Password);
        Password.setBounds(30, 200, 70, 17);

        ConfirmPassword.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        ConfirmPassword.setText("Confirm password: ");
        getContentPane().add(ConfirmPassword);
        ConfirmPassword.setBounds(30, 230, 110, 17);

        ConfirmPasswordText.setText("jPasswordField1");
        getContentPane().add(ConfirmPasswordText);
        ConfirmPasswordText.setBounds(140, 230, 340, 22);

        AddressText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        AddressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressTextActionPerformed(evt);
            }
        });
        getContentPane().add(AddressText);
        AddressText.setBounds(140, 320, 340, 19);

        EmailAddress.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        EmailAddress.setText("       Email Adrress:");
        getContentPane().add(EmailAddress);
        EmailAddress.setBounds(10, 260, 110, 17);

        PhoneNumber.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        PhoneNumber.setText("Phone Number:");
        getContentPane().add(PhoneNumber);
        PhoneNumber.setBounds(30, 290, 90, 17);

        AddressOfShop.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        AddressOfShop.setText("Home Address:");
        getContentPane().add(AddressOfShop);
        AddressOfShop.setBounds(30, 320, 100, 20);

        EmailText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        EmailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTextActionPerformed(evt);
            }
        });
        getContentPane().add(EmailText);
        EmailText.setBounds(140, 260, 340, 19);
        getContentPane().add(UserNameText);
        UserNameText.setBounds(140, 170, 340, 22);

        Already.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        Already.setText("Already a registered user ?");
        getContentPane().add(Already);
        Already.setBounds(30, 480, 290, 19);

        LoginUserName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        LoginUserName.setText("username:");
        getContentPane().add(LoginUserName);
        LoginUserName.setBounds(40, 520, 68, 20);
        getContentPane().add(LoginUserNameText);
        LoginUserNameText.setBounds(140, 520, 201, 22);

        LoginButton.setText("Log in");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton);
        LoginButton.setBounds(350, 520, 130, 22);

        ForgotButton.setText("Forgot password?");
        ForgotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ForgotButton);
        ForgotButton.setBounds(350, 550, 130, 22);

        LoginPasswordText.setText("jPasswordField1");
        LoginPasswordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginPasswordTextActionPerformed(evt);
            }
        });
        getContentPane().add(LoginPasswordText);
        LoginPasswordText.setBounds(140, 550, 201, 22);

        LoginPassword.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        LoginPassword.setText("Password:");
        getContentPane().add(LoginPassword);
        LoginPassword.setBounds(40, 550, 68, 20);

        PhoneText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        PhoneText.setText("002");
        PhoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextActionPerformed(evt);
            }
        });
        getContentPane().add(PhoneText);
        PhoneText.setBounds(140, 290, 340, 19);

        ApplyButton.setLabel("Register");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ApplyButton);
        ApplyButton.setBounds(20, 420, 460, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 460, 480, 10);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 620, 452, 90);

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

        getContentPane().add(jPanel3);
        jPanel3.setBounds(30, 40, 450, 82);

        CreditCardText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CreditCardText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditCardTextActionPerformed(evt);
            }
        });
        getContentPane().add(CreditCardText);
        CreditCardText.setBounds(140, 380, 340, 19);

        PhoneNumber1.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        PhoneNumber1.setText("Bank Account NO:");
        getContentPane().add(PhoneNumber1);
        PhoneNumber1.setBounds(30, 350, 90, 17);

        AddressOfShop1.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        AddressOfShop1.setText("CreditCard NO:");
        getContentPane().add(AddressOfShop1);
        AddressOfShop1.setBounds(30, 380, 100, 20);

        BankAccountText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        BankAccountText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankAccountTextActionPerformed(evt);
            }
        });
        getContentPane().add(BankAccountText);
        BankAccountText.setBounds(140, 350, 340, 19);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressTextActionPerformed

    private void EmailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTextActionPerformed

    private void PhoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextActionPerformed

    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed

        
        
        
       
                
       
        
        String Name = UserNameText.getText().trim();
        String Password = PasswordText.getText();
        String Email = EmailText.getText();
        String phoneNumber = PhoneText.getText();
        String PlaceAddress = AddressText.getText();
        String BankAccount = BankAccountText.getText();
        String CreditCard = CreditCardText.getText();
        
        
        
        boolean ErrorChecker0 = false;
        
        boolean ErrorChecker1 = true;
        boolean ErrorChecker2 = true;
        boolean ErrorChecker3 = true;
        boolean ErrorChecker4 = true;
        boolean ErrorChecker5 = true;
        boolean ErrorChecker6 = true;
        boolean ErrorChecker7 = true;
        boolean ErrorChecker8 = true;
        
        
        
        if (AddressText.getText().isEmpty() ||UserNameText.getText().isEmpty()||PhoneText.getText().isEmpty()||
                
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
        
        
        
        if ( ErrorChecker1 == true && ErrorChecker2 == true && ErrorChecker3 == true && ErrorChecker4 == true && ErrorChecker5 == true && ErrorChecker6 == true ) {
        
       
        try {
                
                int intValue = Integer.parseInt(PhoneText.getText());
                
                
            } catch(NumberFormatException e){
                
               JOptionPane.showMessageDialog(null, "error, please enter a valid phone number"); 
                
                
            }
        
       
        RegisteredDoner Customer = new RegisteredDoner(Name, Password,Email,phoneNumber,PlaceAddress, BankAccount, CreditCard);
        
        
        Customers.add(Customer);
        
        saveCustomersToFile();
        
       
        
        }         
       
    
        /////////////////////////////////////   file database  ////////////////////////
        
        try
        {
        
            FileInputStream file = new FileInputStream("src\\DataBase\\Cutomers.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
        
        FileWriter fw=new FileWriter("src\\DataBase\\CutomersData.txt");  
        FileWriter fw2 = new FileWriter("src\\DataBase\\ManageApplicantsRequests.txt");
        
       for (int i=0;i<Customers.size();i++){
           
            try 
            {
              
                   fw.write("\n" + Customers.get(i).getName() + "\n" + Customers.get(i).getEmail()+ "\n" + Customers.get(i).getPhoneNumber()+ "\n" + Customers.get(i).getAdress()+"\n" + Customers.get(i).getPassword() + "\n" + Customers.get(i).getAccountNumber() + "\n" + Customers.get(i).getCreditCardNumber() + "\n" );
                   fw2.write( "\n" + Customers.get(i).getName() + "\n" + Customers.get(i).getEmail()+ "\n" + Customers.get(i).getPhoneNumber()+ "\n" + Customers.get(i).getAdress()+"\n" + Customers.get(i).getPassword() + "\n");
                  
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
    
        
          /////////////////////////////////////   file database  ////////////////////////
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         /////////////////////////////////////  SQL database  ////////////////////////
        
        
        try {
            
            
        Class.forName("com.mysql.jdbc.Driver");
        sqlConn = DriverManager.getConnection(dataConn, username, password);
        pst = sqlConn.prepareStatement("insert into registered_doner(ID, Username,Password,Email, Phone_Number, Address, Credit_Card_Number,Bank_Account_Number)value(?,?,?,?,?,?,?,?)");
         
        int i = r.nextInt(999999);
        pst.setString(1, Integer. toString(i));
        pst.setString(2, UserNameText.getText());
        pst.setString(3, PasswordText.getText());
        pst.setString(4, EmailText.getText());
        pst.setString(5, PhoneText.getText());
        pst.setString(6, AddressText.getText());
        pst.setString(7, CreditCardText.getText());
        pst.setString(8, BankAccountText.getText());
        
       
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Record Added");
        
        upDateDB();
        
       
        
        } catch (ClassNotFoundException ex){
             
            java.util.logging.Logger.getLogger(User_Signup_Interface.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
             
        } catch (SQLException ex){
             
            java.util.logging.Logger.getLogger(User_Signup_Interface.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
             
        }
        
        
          /////////////////////////////////////  SQL database  ////////////////////////
        
        
        
    }//GEN-LAST:event_ApplyButtonActionPerformed

    private void ForgotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotButtonActionPerformed

     
   
     
    }//GEN-LAST:event_ForgotButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
       
       
        
        
        
        
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void LoginPasswordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginPasswordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginPasswordTextActionPerformed

    private void CreditCardTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditCardTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreditCardTextActionPerformed

    private void BankAccountTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankAccountTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BankAccountTextActionPerformed

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
            java.util.logging.Logger.getLogger(User_Signup_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Signup_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Signup_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Signup_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Signup_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressOfShop;
    private javax.swing.JLabel AddressOfShop1;
    private javax.swing.JTextField AddressText;
    private javax.swing.JLabel Already;
    private javax.swing.JButton ApplyButton;
    private javax.swing.JLabel ApplyLabel;
    private javax.swing.JTextField BankAccountText;
    private javax.swing.JLabel ConfirmPassword;
    private javax.swing.JPasswordField ConfirmPasswordText;
    private javax.swing.JTextField CreditCardText;
    private javax.swing.JLabel EmailAddress;
    private javax.swing.JTextField EmailText;
    private javax.swing.JButton ForgotButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginPassword;
    private javax.swing.JPasswordField LoginPasswordText;
    private javax.swing.JLabel LoginUserName;
    private javax.swing.JTextField LoginUserNameText;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField PasswordText;
    private javax.swing.JLabel PhoneNumber;
    private javax.swing.JLabel PhoneNumber1;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JLabel ShopsUserName;
    private javax.swing.JTextField UserNameText;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
