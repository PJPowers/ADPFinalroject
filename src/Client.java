/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NR Burger
 */
public class Client extends javax.swing.JFrame {

    private static Socket socket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private ArrayList<Customer> customerList;

    /**
     * Creates new form ClientFrame
     */
    
    public Client() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddCustomer = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddCustomer.setText("Add a new Customer");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        jButton6.setText("jButton6");

        jButton7.setText("jButton7");

        jButton8.setText("jButton8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnAddCustomer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnAddCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void addCust()
   {
     AddCustFrame objAddCust = new AddCustFrame();
     
     objAddCust.show();  
     this.dispose();
   }
    
    private void addDvd()
   {
     ///AddDvdFrame objAddDvd = new AddDvdFrame();
     
    // objAddDvd.show();  
     this.dispose();
   }
    
    private void rentDvd()
   {
     //RentDvdFrame objRentDvd = new RentDvdFrame();
     
    // objRentDvd.show();  
     this.dispose();
   }
    
    private void returnDvd()
   {
     //ReturnDvdFrame objReturnDvd = new ReturnDvdFrame();
     
    // objReturnDvd.show();  
     this.dispose();
   }
    
    private void listAllMovies()
   {
     //ListAllMoviesFrame objListAllMovies = new ListAllMoviesFrame();
     
    // objListAllMovies.show();  
     this.dispose();
   }
    
    private void listAllCust()
   {
     //ListAllCustFrame objListAllCust = new ListAllCustFrame();
     
     //objListAllCust.show();  
     this.dispose();
   }
    private void searchMovies()
   {
     //SearchFrame objSearchMovies = new SearchFrame();
     
     //objSearchMovies.show();  
     this.dispose();
   }
    
    
    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
    
        addCust();
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        addDvd();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        rentDvd();
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        returnDvd();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       listAllMovies();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        listAllCust();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        searchMovies();
    }//GEN-LAST:event_jButton6ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
      try
        {
            socket = new Socket("localhost", 30000); 
            out = new ObjectOutputStream(socket.getOutputStream()); 
            out.flush();
            in = new ObjectInputStream(socket.getInputStream()); 
        
        }
      catch(IOException e)
        {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }
    
    public ArrayList customerTable(){
    customerList = new ArrayList<Customer>();
     try
     {
        out.writeObject("tableC");
        out.flush();
        customerList = (ArrayList) in.readObject(); 
     }
     catch(IOException e)
     {
        e.printStackTrace();
     }
     catch(ClassNotFoundException e)
     {
        e.printStackTrace();
     }
   return customerList; 
    }
    
    //sends request to server to add new customer 
    public void addNewCustomer(String name, String surname, String phoneNumber){
        
        String message = name+"#"+surname+"#"+phoneNumber; 
        
        String command = "addNew";
        try
        {
            out.writeObject(command+message);
            out.flush();
            String reply = (String)in.readObject();
            JOptionPane.showMessageDialog(null, reply);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
      
} 
    //sends request to server to remove customer
    public void removeCustomer(int i){
        try
        {
            String number = Integer.toString(i); 
            String command = "remove"; 
            out.writeObject(command+number);
            out.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
   
    
   
//closes all sockets and streams
public void closeStreams(){
try{
in.close();
out.close();
socket.close();
System.exit(0); 
}catch(IOException e){
e.printStackTrace();
}
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    // End of variables declaration//GEN-END:variables
}
