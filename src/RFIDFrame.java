

import com.phidget22.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.io.File;
import java.io.FileNotFoundException;


public class RFIDFrame extends javax.swing.JFrame implements RFIDable {

    RFID rfid = null;
    
    SimulateCardReadFrame scrf;
    boolean ListenStatus =true ;
    
    ArrayList<String> products = new ArrayList<String>();
    ArrayList<Account> database = new ArrayList<Account>();
    FileScanner scanner = new FileScanner();
        

    
    public RFIDFrame() throws Exception {
       
        initComponents();     
        scrf = new SimulateCardReadFrame(this);
        scrf.setVisible(true);
        
        
        //Initializes scanner
        scanner = new FileScanner(); 
        //gets accounts from text files
        String currentDirectory = System.getProperty("user.dir");
        String tempDir1 = currentDirectory + "\\files\\ProgramFiles\\Passwords.txt";
        String tempDir2 = currentDirectory + "\\files\\ProgramFiles\\RFIDS.txt";
        ArrayList<String> passwords = scanner.readAndReturnStringArrayList(tempDir1);
        ArrayList<String> RFIDS = scanner.readAndReturnStringArrayList(tempDir2);
        
        for (int k = 0; k<RFIDS.size(); k++) {
                String temp1 = RFIDS.get(k);
                String temp2 = passwords.get(k);
                Account temp = new Account(temp2, temp1);
                database.add(temp);
        }
        
       
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Activate = new java.awt.Button();
        Deactivate = new java.awt.Button();
        jButton1 = new javax.swing.JButton();
        list1 = new java.awt.List();
        buttonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Activate.setLabel("Activate");
        Activate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActivateMouseClicked(evt);
            }
        });
        Activate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivateActionPerformed(evt);
            }
        });

        Deactivate.setLabel("Deactivate");
        Deactivate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeactivateMouseClicked(evt);
            }
        });
        Deactivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeactivateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Activate, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deactivate, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Deactivate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Activate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Clear Log");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });

        buttonExit.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        buttonExit.setText("EXIT PROGRAM");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(buttonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActivateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActivateMouseClicked
        System.out.println("activate mouse clicked");
        try{
            setUpThePhidgetThing();
        }catch(Exception e) {}
        
    }//GEN-LAST:event_ActivateMouseClicked

    
    private void DeactivateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeactivateMouseClicked
        // TODO add your handling code here:
        System.out.print("closing...");
        try{rfid.close();} catch(Exception e) { } 
        rfid = null;
    }//GEN-LAST:event_DeactivateMouseClicked

     
    private void ActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivateActionPerformed
        try {
            rfid.open(5000);
        }catch(Exception e) {
            System.out.println("Error connecting to RFID");
        }
        
    }//GEN-LAST:event_ActivateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        list1.removeAll();
        products.clear();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DeactivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeactivateActionPerformed
        DeactivateMouseClicked(null);
    }//GEN-LAST:event_DeactivateActionPerformed

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list1ActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        //Save passwords and RFIDS into ArrayList<String>
        
        ArrayList<String> passwords = new ArrayList<String>();
        ArrayList<String> RFIDS = new ArrayList<String>();
        for (Account A : database){
            passwords.add(A.getPassword());
            RFIDS.add(A.getRFID());
        }
        String currentDirectory = System.getProperty("user.dir");
        String tempDir1 = currentDirectory + "\\files\\ProgramFiles\\Passwords.txt";
        String tempDir2 = currentDirectory + "\\files\\ProgramFiles\\RFIDS.txt";
        TextFile passwordFile = new TextFile(tempDir1);
        TextFile RFIDSFile = new TextFile(tempDir2);
        
        passwordFile.changeInfo(passwords);
        RFIDSFile.changeInfo(RFIDS);
        
        
        //Should never run into exception anyway
        try {
            passwordFile.wipeAndSave();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RFIDFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            RFIDSFile.wipeAndSave();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RFIDFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    /**
     * @param args the command line arguments
     */
   public void setUpThePhidgetThing() throws Exception { 
        rfid = new RFID();   
        rfid.addAttachListener(new AttachListener() {
            public void onAttach(AttachEvent ae) {
                    RFID phid = (RFID) ae.getSource();
                    try {
                            if(phid.getDeviceClass() != DeviceClass.VINT){
                                    System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " attached");
                            }
                            else{
                                    System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " hub port " + phid.getHubPort() + " attached");
                            }
                    } catch (PhidgetException ex) {
                            System.out.println(ex.getDescription());
                    }
            }
        });

        rfid.addDetachListener(new DetachListener() {
            public void onDetach(DetachEvent de) {
                    RFID phid = (RFID) de.getSource();
                    try {
                            if (phid.getDeviceClass() != DeviceClass.VINT) {
                                    System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " detached");
                            } else {
                                    System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " hub port " + phid.getHubPort() + " detached");
                            }
                    } catch (PhidgetException ex) {
                            System.out.println(ex.getDescription());
                    }
            }
        });

        rfid.addErrorListener(new ErrorListener() {
            public void onError(ErrorEvent ee) {
                    System.out.println("Error: " + ee.getDescription());
            }
        });

        rfid.addTagListener(new RFIDTagListener() {
            public void onTag(RFIDTagEvent e) {
                    System.out.println("Tag read: " + e.getTag());
                    handleRead(e.getTag() );
            }
        });

        rfid.addTagLostListener(new RFIDTagLostListener() {
            public void onTagLost(RFIDTagLostEvent e) {
                    System.out.println("Tag lost: " + e.getTag());
                    handleLoss(e.getTag() );
            }
        });

  
   }

   
    @Override
   public void handleRead(String scannedRFID){ //id is the scanned RFID
       System.out.println("handleRead: " + scannedRFID);    
       products.add(scannedRFID);
       //show it
       
       
       boolean found = false;
       for (int k=0;k<database.size();k++) {
           if (scannedRFID.equals(database.get(k).getRFID())){ //if the scanned id is equal to the account's id
               String tpass = "";
               while (!tpass.equals(database.get(k).getPassword())) {
                   tpass=UserInput.getString("Enter your password");
               }
               found = true;
               if (tpass.equals(database.get(k).getPassword())) {
                   
                    //enter the cloud
                    System.out.println("Accessing your files....");
                    FileVaultFrame FVF = new FileVaultFrame(scannedRFID, this, scrf);
                    FVF.setVisible(true);
                    this.setVisible(false);
                    scrf.setVisible(false);
                    //Make this and simulate card frame temp invis
               }
           }
       }
       
       if (found == false) {
            String YN = "";
            while (!(YN.equals("Y")) && !(YN.equals("N"))) {
                YN = UserInput.getString("You are not registered in our database, you like to create an account? (Y/N)");
            }
            if (YN.equals("Y")) {
                String newpass ="";
                newpass = UserInput.getString("What would you like your password to be?");
                Account tempacc = new Account(newpass, scannedRFID);
                System.out.println("New account created! Your new id is " + scannedRFID);
                database.add(tempacc);
                
                
                createNewFolder(scannedRFID);
                FileVaultFrame FVF = new FileVaultFrame(scannedRFID, this, scrf);
                FVF.setVisible(true);
                this.setVisible(false);
                scrf.setVisible(false);
            }
        }
       
       
       
       list1.removeAll();
       for(String s: products)
           list1.add( s );
       
       
   } 

   
    public void handleLoss(String id){
       System.out.println("handleLoss: " + id );
   } 
    
   
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run()  {
              
                try {
                    System.out.println("Making frame...");
                    new RFIDFrame().setVisible(true);
                }
                catch(Exception e) {
                    System.out.println("Error Encountered!");
                    System.exit(0);
                }
            }
        }
                        );
    }
    
    public void createNewFolder(String name){
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory + "\\files\\";
        new File(path + name).mkdir();
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Activate;
    private java.awt.Button Deactivate;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables



}

