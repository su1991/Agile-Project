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
    private static final String dataConn = "jdbc:mysql://localhost:3306/connector?autoReconnect=true&useSSL=false";
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int i,q,id, delteItem;
    
      Random r = new Random();
    
    
    ArrayList <CustomerAccount> Customers;
    ArrayList <Applications> Applications;
    ArrayList <CustomerState> CustomerState;
  
    
    public User_Signup_Interface() {
        initComponents();
        Customers = new ArrayList<CustomerAccount>();
        Applications = new ArrayList<Applications>();
        CustomerState = new ArrayList<CustomerState>();
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
              Customers.add((CustomerAccount) inputFile.readObject());
                
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
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel(); ///////////////////
            RecordTable.setRowCount(0);             ////////////////////////////////////////////////
            
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        UploadText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        UploadText.setText("Uplaod and ID");
        UploadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadTextActionPerformed(evt);
            }
        });
        getContentPane().add(UploadText);
        UploadText.setBounds(20, 400, 360, 30);

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

        Approved.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        Approved.setText("Take notice that the  fomat acceptable for the submited documents shall be in the form of .PDF");
        getContentPane().add(Approved);
        Approved.setBounds(20, 360, 470, 29);
        getContentPane().add(UserNameText);
        UserNameText.setBounds(140, 170, 340, 22);

        UploadButton.setText("Upload:");
        UploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UploadButton);
        UploadButton.setBounds(390, 400, 90, 30);

        Already.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        Already.setText("Already a registered user ?");
        getContentPane().add(Already);
        Already.setBounds(30, 500, 290, 19);

        LoginUserName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        LoginUserName.setText("username:");
        getContentPane().add(LoginUserName);
        LoginUserName.setBounds(40, 540, 68, 20);
        getContentPane().add(LoginUserNameText);
        LoginUserNameText.setBounds(140, 540, 201, 22);

        LoginButton.setText("Log in");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton);
        LoginButton.setBounds(350, 540, 130, 22);

        ForgotButton.setText("Forgot password?");
        ForgotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ForgotButton);
        ForgotButton.setBounds(350, 570, 130, 22);

        LoginPasswordText.setText("jPasswordField1");
        LoginPasswordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginPasswordTextActionPerformed(evt);
            }
        });
        getContentPane().add(LoginPasswordText);
        LoginPasswordText.setBounds(140, 570, 201, 22);

        LoginPassword.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        LoginPassword.setText("Password:");
        getContentPane().add(LoginPassword);
        LoginPassword.setBounds(40, 570, 68, 20);

        PhoneText.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        PhoneText.setText("002");
        PhoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextActionPerformed(evt);
            }
        });
        getContentPane().add(PhoneText);
        PhoneText.setBounds(140, 290, 340, 19);

        ApplyButton.setText("Apply!");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ApplyButton);
        ApplyButton.setBounds(20, 450, 460, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 487, 480, 10);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fundraising_Application/logo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 0, 150, 130);

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
        jScrollPane1.setBounds(30, 640, 452, 160);

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

    private void PhoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextActionPerformed

    private void UploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadButtonActionPerformed
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath();
      UploadText.setText(filename);
    }//GEN-LAST:event_UploadButtonActionPerformed

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
        
       
        CustomerAccount Customer = new CustomerAccount(ApplicationNumber,Name, Password,Email,phoneNumber,PlaceAddress);
        
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

    private void ForgotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotButtonActionPerformed

     
   
     
    }//GEN-LAST:event_ForgotButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
       
        try
        {
        
        FileInputStream file = new FileInputStream("src\\DataBase\\Cutomers.dat");
        ObjectInputStream inputFile = new ObjectInputStream(file);
        boolean endOfFile = false;
        
        while (!endOfFile){
            
            try 
            {
              Customers.add((CustomerAccount) inputFile.readObject());
                
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
            catch (Exception f)
            {
            // JOptionPane.showMessageDialog(null, f.getMessage());
            }
        }
        
        inputFile.close();
        }
        
        catch (IOException e){
            
          //  JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        
        
         try{
        
       
       FileInputStream file = new FileInputStream("src\\DataBase\\Applications.dat");
        ObjectInputStream inputFile = new ObjectInputStream(file);
        boolean endOfFile = false;
        
        while (!endOfFile){
            
            try 
            {
           Applications.add ((Applications) inputFile.readObject());
                
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
            catch (Exception f)
            {
            // JOptionPane.showMessageDialog(null, f.getMessage());
            }
        }
        
        inputFile.close();
        }
        catch (IOException e){
            
           // JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
             
             
        
        
        
        
  if(LoginUserNameText.getText().isEmpty() ||LoginPasswordText.getText().isEmpty() ){
            
                         JOptionPane.showMessageDialog(null, "One of the Required fields is empty please fill it");

 }else{
            
           
      
   boolean abort = false;    
   
   boolean Match = false;
           
           
   for (int i=0;i<Customers.size() && !abort ;i++) {
           
          
     
      if (LoginUserNameText.getText().trim().equals(Customers.get(i).getName().trim())  && LoginPasswordText.getText().equals(Customers.get(i).getPassword()) ){
              
          String x = Integer.toString(Customers.get(i).ApplicationNumber);
          
          for (int j=0; j<Applications.size(); j++){
             
         
                if(x.equals(Applications.get(j).ApplicationNumber) && Applications.get(j).Applicationstatus.equals("Approved")) {
                    
                    
                    
                    
                    CustomerState currentCustomerState = new CustomerState(LoginUserNameText.getText().trim() + " " + LoginPasswordText.getText()); // state is a combination of pass and username
        
        
        
        
        
                    CustomerState.add(0, currentCustomerState);
                            
                            
       
                    saveCustomerStateToFile();
                    
                    
                    
                    
                     Match = true;
                     new User_Interface().setVisible(true);
                     abort = true;
                     break;
                     
                     
                     
                     
                     
                     
                      
                }else if(x.equals(Applications.get(j).ApplicationNumber) && Applications.get(j).Applicationstatus.equals("DisApproved")){
                    
                    JOptionPane.showMessageDialog(null, "Unfortunaely your application has been denied");
                    
                    abort = true;
                    break;
                    
                } 
          }
                     
                
      }
   
     }
   
   
    if (Match == false) {
                      
        
        JOptionPane.showMessageDialog(null, "Failed login attempt, make sure you are inserting the proper credintials");
                       
                     }
        
        
        
        
        
        
  }
        
        
        
        
        
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void LoginPasswordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginPasswordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginPasswordTextActionPerformed

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
    private javax.swing.JTextField AddressText;
    private javax.swing.JLabel Already;
    private javax.swing.JButton ApplyButton;
    private javax.swing.JLabel ApplyLabel;
    private javax.swing.JLabel Approved;
    private javax.swing.JLabel ConfirmPassword;
    private javax.swing.JPasswordField ConfirmPasswordText;
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
    private javax.swing.JTextField PhoneText;
    private javax.swing.JLabel ShopsUserName;
    private javax.swing.JButton UploadButton;
    private javax.swing.JTextField UploadText;
    private javax.swing.JTextField UserNameText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
